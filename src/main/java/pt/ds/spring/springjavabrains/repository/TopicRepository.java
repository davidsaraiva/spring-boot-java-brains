package pt.ds.spring.springjavabrains.repository;

import org.springframework.data.repository.CrudRepository;

import pt.ds.spring.springjavabrains.entity.Topic;

public interface TopicRepository extends CrudRepository<Topic, String> {

}
