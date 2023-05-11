package com.javaBrains.javaBrains.repository;

import com.javaBrains.javaBrains.entity.Policy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PolicyRepository extends JpaRepository<Policy,Long> {
    /*
    * if policy is Policy purchase  (Policy = new PolicyPurchase() )
    *   then policyPurchase will be saved using this repo call
    * if policy is PolicyEndorsement (Policy = new PolicyEndorsement() )
    *      then policyEndorsement will get saved using this repo call
    *   and so on
    *
    * PolicyPurchase and PolicyEndorsement and PolicyRenewal are from Policy
    *
    * */
}
