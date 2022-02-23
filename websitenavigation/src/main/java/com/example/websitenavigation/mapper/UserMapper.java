package com.example.websitenavigation.mapper;

import com.example.websitenavigation.pojo.User;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface UserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer id);

    User selectTheLoginUser(String userName, String passwd);

    List<User> selectAllUser();

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}