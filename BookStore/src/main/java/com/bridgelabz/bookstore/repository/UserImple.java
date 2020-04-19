package com.bridgelabz.bookstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bridgelabz.bookstore.entity.BookInformation;
import com.bridgelabz.bookstore.entity.UserInformation;


@Repository
public interface UserImple extends JpaRepository<UserInformation, Long> {
	@Query(value="select * from userinfo where user_Id=?",nativeQuery=true)
	UserInformation findbyUserId(Long userId);
}
