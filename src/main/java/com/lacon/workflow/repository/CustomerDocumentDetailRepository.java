package com.lacon.workflow.repository;

import com.lacon.workflow.entity.CustomerDocumentDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerDocumentDetailRepository extends JpaRepository<CustomerDocumentDetails,Long> {


}
