package com.dmcg.task_manager.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import com.dmcg.task_manager.model.Task;

public interface ITaskRepository extends CrudRepository<Task, String>, PagingAndSortingRepository<Task, String>
{}
