package com.javaBrains.javaBrains.repository;

import com.javaBrains.javaBrains.entity.PolicyEndorsement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyEndorsementRepository extends JpaRepository<PolicyEndorsement,Long> {
}
