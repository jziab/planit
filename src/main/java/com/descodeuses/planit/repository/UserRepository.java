package com.descodeuses.planit.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.descodeuses.planit.entity.DCUSER;

public interface UserRepository extends JpaRepository<DCUSER, Long>{
     Optional<DCUSER> findByUsername(String username);

     

}
