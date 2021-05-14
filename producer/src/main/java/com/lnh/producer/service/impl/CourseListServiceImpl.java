package com.lnh.producer.service.impl;

import java.util.List;

import com.lnh.producer.entity.Course;
import com.lnh.producer.mapper.CourseMapper;
import com.lnh.producer.service.CourseListService;
import org.apache.dubbo.config.annotation.Service;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 描述：     课程列表服务实现类
 */
@Service(version = "${demo.service.version}")
public class CourseListServiceImpl implements CourseListService {

    @Autowired
    CourseMapper courseMapper;

    public List<Course> getCourseList() {
        return courseMapper.findValidCourses();
    }

}
