package com.javaBrains.javaBrains.repository;

import com.javaBrains.javaBrains.entity.PolicyRenewal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRenewalRepository extends JpaRepository<PolicyRenewal,Long> {
}
