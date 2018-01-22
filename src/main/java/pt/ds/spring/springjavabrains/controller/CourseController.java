package pt.ds.spring.springjavabrains.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pt.ds.spring.springjavabrains.entity.Course;
import pt.ds.spring.springjavabrains.service.CourseService;

@Slf4j
@RestController
public class CourseController {

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.GET)
    public List<Course> getAllTopics(@PathVariable String topicId) {
        log.info("CourseController - Fetch all courses");
        return courseService.getAllCourses(topicId);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.GET)
    public Course getCourse(@PathVariable String id) {
        log.info("CourseController - Fetch course by id " + id);
        return courseService.getCourse(id);
    }

    @RequestMapping(value = "/topics/{topicId}/courses", method = RequestMethod.POST)
    public void addCourse(@PathVariable String topicId, @RequestBody Course course) {
        course.relateToTopic(topicId); // Relate course to topic
        log.info("CourseController - Adding course " + course);
        courseService.addCourse(course);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.PUT)
    public void updateCourse(@PathVariable String topicId, @PathVariable String id, @RequestBody Course course) {
        log.info("CourseController - Updating course " + course + " with id " + id);
        course.relateToTopic(topicId); // Relate course to topic
        courseService.updateCourse(course, id);
    }

    @RequestMapping(value = "/topics/{topicId}/courses/{id}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id) {
        log.info("CourseController - Deleting course with id " + id);
        courseService.deleteCourse(id);
    }


}
