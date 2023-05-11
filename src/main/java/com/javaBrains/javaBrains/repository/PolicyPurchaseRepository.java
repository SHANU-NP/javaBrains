package com.javaBrains.javaBrains.repository;

import com.javaBrains.javaBrains.entity.PolicyPurchase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyPurchaseRepository extends JpaRepository<PolicyPurchase,Long> {
}
