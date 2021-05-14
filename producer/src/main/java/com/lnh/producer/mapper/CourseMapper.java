package com.lnh.producer.mapper;

import java.util.List;

import com.lnh.producer.entity.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 描述：     Mapper类
 */
@Mapper
@Repository
public interface CourseMapper {

    @Select("SELECT * FROM course WHERE valid = 1")
    List<Course> findValidCourses();
}
