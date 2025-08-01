package com.descodeuses.planit.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.descodeuses.planit.entity.Contact;

public interface ContactRepository extends JpaRepository<Contact, Long> {

}
