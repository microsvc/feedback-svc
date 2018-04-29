package com.example.learn.cockroachdb.feedbacksvc.model;

import lombok.AllArgsConstructor;
import lombok.Value;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by rajaneeshk on 4/29/2018.
 */
@Value
@AllArgsConstructor
public class Feedback {
        private int id;
        private String focusarea;
        private String rating;
}
