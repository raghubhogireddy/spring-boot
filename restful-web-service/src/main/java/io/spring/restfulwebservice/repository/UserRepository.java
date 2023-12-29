package io.spring.restfulwebservice.repository;

import io.spring.restfulwebservice.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

}
