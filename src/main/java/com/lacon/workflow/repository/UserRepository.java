package com.lacon.workflow.repository;


import com.lacon.workflow.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    List<User> findAllByRole(String role);

    Optional<User> findByPhone(String username);
    Optional<User> findByUserId(UUID userId);

}
