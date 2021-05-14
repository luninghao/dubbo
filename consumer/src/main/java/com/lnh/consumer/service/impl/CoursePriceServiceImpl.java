package com.lnh.consumer.service.impl;

import com.lnh.consumer.dao.CoursePriceMapper;
import com.lnh.consumer.entity.CourseAndPrice;
import com.lnh.consumer.entity.CoursePrice;
import com.lnh.consumer.service.CoursePriceService;
import java.util.ArrayList;
import java.util.List;

import com.lnh.producer.entity.Course;
import com.lnh.producer.service.CourseListService;
import org.apache.dubbo.config.annotation.Reference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 描述：     课程 价格服务
 */
@Service
public class CoursePriceServiceImpl implements CoursePriceService {

    @Autowired
    CoursePriceMapper coursePriceMapper;

    @Reference(version = "${demo.service.version}")
    CourseListService courseListService;

    @Override
    public CoursePrice getCoursePrice(Integer courseId) {
        return coursePriceMapper.findCoursePrices(courseId);
    }

    @Override
    public List<CourseAndPrice> getCoursesAndPrice() {
        List<CourseAndPrice> courseAndPriceList = new ArrayList<>();
        List<Course> courseList = courseListService.getCourseList();
        for (int i = 0; i < courseList.size(); i++) {
            Course course = courseList.get(i);
            if (course != null) {
                CoursePrice price = getCoursePrice(course.getCourseId());
                if (price != null && price.getPrice() > 0) {
                    CourseAndPrice courseAndPrice = new CourseAndPrice();
                    courseAndPrice.setId(course.getId());
                    courseAndPrice.setCourseId(course.getCourseId());
                    courseAndPrice.setName(course.getName());
                    courseAndPrice.setPrice(price.getPrice());
                    courseAndPriceList.add(courseAndPrice);
                }
            }
        }
        return courseAndPriceList;
    }
}
