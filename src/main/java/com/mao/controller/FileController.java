/**
 * @author: mao
 * @description
 * @date: 2024/4/7 13:49
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.controller;

import com.mao.bean.Student;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.omg.CORBA.MARSHAL;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import sun.util.locale.provider.JRELocaleProviderAdapter;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

@Controller
public class FileController {

    @RequestMapping("/toUploadIndex")
    public String toUploadIndex(){
        return "file/uploadFile";
    }

    // 上传文件，不需要返回页面也不需要做跳转，此时是用来返回数据的
    @RequestMapping(value = "/uploadPhoto", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, String> uploadFile(MultipartFile photo, HttpServletRequest request) {
        Map<String, String> ret = new HashMap<String, String>();

        if (photo == null){
            ret.put("type", "error");
            ret.put("msg", "尚未选择需要上传的文件");
            return ret;
        }
        System.out.println("1......");

        if (photo.getSize() > 1024*1024*10){
            ret.put("type", "error");
            ret.put("msg", "文件过大，超出承受范围");
            return ret;
        }
        System.out.println("2......");

        // 获取文件后缀
        String suffix = photo.getOriginalFilename().substring(photo.getOriginalFilename().lastIndexOf(".") + 1, photo.getOriginalFilename().length());
        if (!".jpg.jpeg.png.gif".toUpperCase().contains(suffix.toUpperCase())){
            ret.put("type", "error");
            ret.put("msg", "文件类型错误,请选择正确文件类型");
            return ret;
        }
        System.out.println("3......");

        // 指定文件上传路径
        String realPath = request.getServletContext().getRealPath("/upload/");
        System.out.println(realPath);

        // 避免首次上传找不到文件夹，需要创建
        File fileDir = new File(realPath);
        if (!fileDir.exists()) {
            fileDir.mkdir();
        }
        System.out.println("4......");

        // 重命名，防止出现重名的情况
        String filename = photo.getOriginalFilename();
        String newFileName = UUID.randomUUID() + "_" + filename;

        try {
            // 将文件上传到指定的位置
            photo.transferTo(new File(realPath + newFileName));
        }catch (IOException e){
            ret.put("type", "error");
            ret.put("msg", "文件保存失败!");
            e.printStackTrace();
            return ret;
        }
        System.out.println("5......");

        ret.put("type", "success");
        ret.put("msg","文件上传成功！");
        ret.put("filepath", realPath);
//        ret.put("filepath", "/upload/");
        ret.put("filename", newFileName);

        return ret;
    }

    @RequestMapping(value = "/student", method = RequestMethod.POST)
    public String uploadInfo(Student student, Model model){
        String fileNameStr = student.getFileNameStr();
        String[] split = fileNameStr.split(",");
        List<String> list = new ArrayList<String>();
        for (String fileName: split){
            list.add(fileName);
        }
        student.setPath(list);
        model.addAttribute("student", student);

        return "file/success";
    }

    @RequestMapping("/downloadFile")
    public ResponseEntity<byte[]> downloadFile(HttpServletRequest request, String fileName) throws IOException {
        String realPath = request.getServletContext().getRealPath("/upload/" + fileName);

        File file = new File(realPath);
        byte[] bytes = FileUtils.readFileToByteArray(file);
        // 设置响应头信息
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", toUTF8String(fileName));

        return new ResponseEntity<byte[]>(bytes, httpHeaders, HttpStatus.OK);
    }

//    处理文件下载过程中，中文文件名的编码转换问题
    public String toUTF8String(String str){
        StringBuffer sb = new StringBuffer();
        int length = str.length();
        for (int i = 0; i < length; ++i){
            // 每次取一个字符，每个字符有对应的unicode编码，除了数字和字母，都需要做处理
            char c = str.charAt(i);
            if (c >= 0 && c <= 255) {
                sb.append(c);
            }else {
                // 转utf-8
                byte b[];
                try {
                    b = Character.toString(c).getBytes("UTF-8");
                }catch (UnsupportedEncodingException e){
                    e.printStackTrace();
                    b = null;
                }

                for (int j = 0; j < b.length; ++j){
                    int  k = b[j];
                    if (k < 0) {
                        k &= 255;
                    }
                    sb.append("%" + Integer.toHexString(k).toUpperCase());
                }
            }
        }
        return sb.toString();
    }

}
