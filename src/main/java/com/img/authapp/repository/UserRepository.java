package com.img.authapp.repository;

import com.img.authapp.model.MyUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<MyUser, Long> {

    MyUser getById(Long id);

    MyUser getByUsername(String username);

}
