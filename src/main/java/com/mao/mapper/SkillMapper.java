/**
 * @author: mao
 * @description
 * @date: 2024/4/11 19:07
 * @created by Guangzhi Mao
 * @motto: 海纳百川有容乃大，壁立千仞无欲则刚
 * @Github: http://github.com/masterchange13
 */


package com.mao.mapper;

import com.mao.bean.Skill;
import com.mao.bean.User;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface SkillMapper {

    @Select("select * from skill")
    List<Skill> selectAllSkill(int i);
}
