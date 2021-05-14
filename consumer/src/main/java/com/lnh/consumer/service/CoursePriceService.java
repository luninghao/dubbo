package com.lnh.consumer.service;

import com.lnh.consumer.entity.CourseAndPrice;
import com.lnh.consumer.entity.CoursePrice;
import java.util.List;

/**
 * 描述：     课程价格服务
 */
public interface CoursePriceService {

    CoursePrice getCoursePrice(Integer courseId);

    List<CourseAndPrice> getCoursesAndPrice();
}
