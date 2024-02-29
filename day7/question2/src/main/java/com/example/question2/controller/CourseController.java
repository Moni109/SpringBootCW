package com.example.question2.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.question2.model.Course;
import com.example.question2.service.CourseService;

@RestController
@RequestMapping("/api/course")
public class CourseController {
    private CourseService courseService;
    public CourseController(CourseService courseService){
        this.courseService=courseService;
    }

    @PostMapping
    public ResponseEntity<Course> createCourse(@RequestBody Course course){
        if(courseService.postCourse(course)!=null){
            return new ResponseEntity<>(course,HttpStatus.CREATED);
        }
        return new ResponseEntity<>(course,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    
    @GetMapping
        public ResponseEntity<List<Course>> getCourse(){
            List<Course> c=courseService.getCourses();
            if(c!=null){
                return new ResponseEntity<>(c,HttpStatus.OK);
            }
            return new ResponseEntity<>(c,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    
     @GetMapping("/{courseName}")
    public ResponseEntity<List<Course>> findCourseByName(@PathVariable String courseName){
        List<Course> c=courseService.findCoursename(courseName);
        if(c!=null){
            return new ResponseEntity<>(c,HttpStatus.OK);
        }
        return new ResponseEntity<>(c,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
