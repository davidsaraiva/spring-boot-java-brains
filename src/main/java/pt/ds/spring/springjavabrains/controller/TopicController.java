package pt.ds.spring.springjavabrains.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;
import pt.ds.spring.springjavabrains.entity.Topic;
import pt.ds.spring.springjavabrains.service.TopicService;

@Slf4j
@RestController
public class TopicController {

    @Autowired
    private TopicService topicService;

    @RequestMapping(value = "/topics", method = RequestMethod.GET)
    public List<Topic> getAllTopics() {
        log.info("TopicController - Fetch all topics");
        return topicService.getAllTopics();
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.GET)
    public Topic getTopic(@PathVariable String id) {
        log.info("TopicController - Fetch topic by id " + id);
        return topicService.getTopic(id);
    }

    @RequestMapping(value = "/topics", method = RequestMethod.POST)
    public void addTopic(@RequestBody Topic topic) {
        log.info("TopicController - Adding topic " + topic);
        topicService.addTopic(topic);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.PUT)
    public void updateTopic(@RequestBody Topic topic, @PathVariable String id) {
        log.info("TopicController - Updating topic " + topic + " with id " + id);
        topicService.updateTopic(topic, id);
    }

    @RequestMapping(value = "/topics/{id}", method = RequestMethod.DELETE)
    public void deleteTopic(@PathVariable String id) {
        log.info("TopicController - Deleting topic with id " + id);
        topicService.deleteTopic(id);
    }


}
