package com.lacon.workflow.repository;

import com.lacon.workflow.entity.CustomerDocumentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface CustomerDocumentDetailRepository extends JpaRepository<CustomerDocumentDetails,Long> {


    CustomerDocumentDetails findByJobId(UUID uuid);

    CustomerDocumentDetails findByCustomerId(UUID uuid);
}
