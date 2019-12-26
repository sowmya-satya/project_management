package com.mindtree.projectmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mindtree.projectmanagement.entity.Account;

@Repository
public interface AccountRepository extends JpaRepository<Account, Integer> {

}
