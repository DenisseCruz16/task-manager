package com.dmcg.task_manager.repository;

import org.springframework.data.repository.CrudRepository;
import com.dmcg.task_manager.model.Task;

public interface ITaskRepository extends CrudRepository<Task, String>
{}
