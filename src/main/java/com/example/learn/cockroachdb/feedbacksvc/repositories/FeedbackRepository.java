package com.example.learn.cockroachdb.feedbacksvc.repositories;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by rajaneeshk on 4/29/2018.
 */
@Repository
public interface FeedbackRepository extends CrudRepository<FeedbackEntity, Integer> {
}
