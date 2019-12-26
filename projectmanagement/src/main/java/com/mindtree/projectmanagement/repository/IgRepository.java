package com.mindtree.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.projectmanagement.entity.Ig;

@Repository
public interface IgRepository extends JpaRepository<Ig, Integer>{

}
