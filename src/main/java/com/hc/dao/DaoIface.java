package com.hc.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hc.model.UserModel;

@Repository
public interface DaoIface extends JpaRepository<UserModel, Long> {

	@Query("select count(*) from UserModel where email=:email ")
	int findByEmail(@Param("email") String email);
}
