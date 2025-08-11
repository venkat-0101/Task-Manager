package com.learning.task_manager.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.learning.task_manager.Model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

  Optional<Task> findByname(String taskName);
   
}