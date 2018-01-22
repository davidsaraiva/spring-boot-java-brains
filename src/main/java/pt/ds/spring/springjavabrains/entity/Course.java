package pt.ds.spring.springjavabrains.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {

    @Id
    private String id;

    private String name;

    private String description;

    @ManyToOne
    private Topic topic;

    public void relateToTopic(String topicId) {
        this.setTopic(new Topic(topicId));
    }
}
