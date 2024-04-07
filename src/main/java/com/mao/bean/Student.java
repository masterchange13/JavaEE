/**
 * @author: mao
 * @description
 * @date: 2024/4/7 11:15
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {
    private String stuId;
    private String stuName;
    private Integer age;
//    接收文件信息
    private List<MultipartFile> photos;
    private String fileNameStr;
    private List<String> path;
}
