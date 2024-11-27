package com.group2.To_Do_App.repository;

import com.group2.To_Do_App.model.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    //find task by the task ID and user ID
//    @Query("SELECT t FROM Task t WHERE t.id = :taskId AND t.user.id = :userId")
//    Optional<Task> findByTaskIdAndUserId(@Param("taskId") Long taskId, @Param("userId") Long userId);

    Optional<Task> findByTaskIdAndUserId(Long taskId, Long userId);
}
