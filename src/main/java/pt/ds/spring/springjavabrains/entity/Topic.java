package pt.ds.spring.springjavabrains.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Topic {

    @Id
    private String id;

    private String name;

    private String description;

    public Topic(String id) {
        this.id = id;
        this.name = "";
        this.description = "";
    }
}
