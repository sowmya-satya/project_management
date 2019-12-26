package com.mindtree.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.projectmanagement.entity.Project;

@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer> {

}
