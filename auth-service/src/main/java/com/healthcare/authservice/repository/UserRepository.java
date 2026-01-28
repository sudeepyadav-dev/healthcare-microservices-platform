package com.healthcare.authservice.repository;

import com.healthcare.authservice.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByEmail(String email);//When you need the details (for login or profile)
    boolean existsByEmail(String email);//When you just need to check whether it exists or not

    // Doctor availability check
    //   Optional<Doctor> findByIdAndAvailableTrue(Long doctorId);
}
