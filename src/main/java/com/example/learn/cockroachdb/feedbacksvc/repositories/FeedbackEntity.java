package com.example.learn.cockroachdb.feedbacksvc.repositories;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

/**
 * Created by rajaneeshk on 4/29/2018.
 */
@Entity
@Table(name = "feedback")
@Data
public class FeedbackEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String focusarea;
    private String rating;

}
