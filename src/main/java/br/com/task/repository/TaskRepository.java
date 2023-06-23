package br.com.task.repository;

import br.com.task.entity.Task;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface TaskRepository extends MongoRepository<Task, String> {
    List<Task> findTaskByCompleted(boolean completed);

    @Query("{ 'createdDate': {'$lt': ?0 }, 'completed': true }")
    List<Task> findOldTasksCompletedThan(LocalDateTime createdDate);
}
