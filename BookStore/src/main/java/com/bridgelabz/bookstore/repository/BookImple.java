package com.bridgelabz.bookstore.repository;

import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.entity.BookInformation;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BookImple extends JpaRepository<BookInformation, Long> {

}
