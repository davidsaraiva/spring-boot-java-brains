package pt.ds.spring.springjavabrains.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import pt.ds.spring.springjavabrains.entity.Course;

public interface CourseRepository extends CrudRepository<Course, String> {

    List<Course> findByTopicId(String topicId);
}
