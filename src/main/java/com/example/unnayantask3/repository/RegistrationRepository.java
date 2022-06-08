package com.example.unnayantask3.repository;

import com.example.unnayantask3.entity.Registration;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationRepository  extends JpaRepository<Registration,Long> {
}
