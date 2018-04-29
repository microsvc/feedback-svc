package com.example.learn.cockroachdb.feedbacksvc.controller;

import com.example.learn.cockroachdb.feedbacksvc.model.Feedback;
import com.example.learn.cockroachdb.feedbacksvc.repositories.FeedbackEntity;
import com.example.learn.cockroachdb.feedbacksvc.repositories.FeedbackRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * Created by rajaneeshk on 4/29/2018.
 */
@RestController
@RequestMapping("/api")
public class FeedbackController {
    private static final Logger LOGGER = LoggerFactory.getLogger(FeedbackController.class);

    private final FeedbackRepository repository;

    @Autowired
    FeedbackController(FeedbackRepository repository) {
        this.repository = repository;
    }

    @DeleteMapping("/feedback/{id}")
    public void deleteFeedback(@PathVariable(value = "id") int id) {
        LOGGER.info("Deleting a feedback entry with id: {}", id);
        Optional<FeedbackEntity> entity = repository.findById(id);
        if (entity.isPresent()) {
            repository.delete(entity.get());
            LOGGER.info("Deleted feedback entry: {}", entity);
        }
        LOGGER.info("Deleted feedback entry: {}", entity);
    }

    @GetMapping("/feedback/{id}")
    public Feedback getFeedback(@PathVariable(value = "id") int id) {
        LOGGER.info("Retrieve  feedback entry with id: {}", id);
        Optional<FeedbackEntity> entity = repository.findById(id);
        Feedback feedback = entity.isPresent() ? mapFeedback(entity.get()) : null;
        return feedback;

    }

    private Feedback mapFeedback(FeedbackEntity entity) {

        return new Feedback(entity.getId(), entity.getFocusarea(), entity.getRating());
    }

}
