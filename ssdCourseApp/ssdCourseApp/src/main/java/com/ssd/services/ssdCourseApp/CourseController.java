package com.ssd.services.ssdCourseApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;
import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseRepository courseRepository;

    @RequestMapping("/")
    public String getCoursesAppHome(){
        return ("CourseApp Home");
    }

    @RequestMapping("/courses")
    public List<Course> getCourses(){
        return courseRepository.findAll();
//        return Arrays.asList(
//                new Course("100", "abc","author1"),
//                new Course("101", "def","author2"));
    }

    @RequestMapping("/{id}")
    public Course getSpecificCourse(@PathVariable("id") BigInteger id){
        return courseRepository.getOne(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/courses")
    public void saveCourse(@RequestBody Course course){
        courseRepository.save(course);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "{id}")
    public void deleteCourse(@PathVariable BigInteger id){
        courseRepository.deleteById(id);

    }

}
