package com.lnh.consumer.controller;

import com.lnh.consumer.entity.CourseAndPrice;
import com.lnh.consumer.entity.CoursePrice;
import com.lnh.consumer.service.CoursePriceService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 描述：CoursePriceController
 */
@RestController
public class CoursePriceController {

    @Autowired
    CoursePriceService coursePriceService;


    @GetMapping({"/price"})
    public Integer getCoursePrice(Integer courseId) {
        CoursePrice coursePrice = coursePriceService.getCoursePrice(courseId);
        if (coursePrice != null) {
            return coursePrice.getPrice();
        } else {
            return -1;
        }
    }


    @GetMapping({"/coursesAndPrice"})
    public List<CourseAndPrice> getcoursesAndPrice() {
        return coursePriceService.getCoursesAndPrice();
    }
}
