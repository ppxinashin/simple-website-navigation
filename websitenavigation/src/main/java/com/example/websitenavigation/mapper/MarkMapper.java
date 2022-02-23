package com.example.websitenavigation.mapper;

import com.example.websitenavigation.pojo.Mark;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MarkMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Mark record);

    int insertSelective(Mark record);

    Mark selectByPrimaryKey(Long id);

    List<Mark> selectByUserId(Integer userId);

    List<Mark> selectAll();

    int updateByPrimaryKeySelective(Mark record);

    int updateByPrimaryKey(Mark record);
}