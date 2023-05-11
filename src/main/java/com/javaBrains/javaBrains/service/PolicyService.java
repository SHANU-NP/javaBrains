package com.javaBrains.javaBrains.service;

import com.javaBrains.javaBrains.entity.Policy;
import com.javaBrains.javaBrains.entity.PolicyEndorsement;
import com.javaBrains.javaBrains.entity.PolicyPurchase;
import com.javaBrains.javaBrains.entity.PolicyRenewal;
import com.javaBrains.javaBrains.model.PolicyRequest;
import com.javaBrains.javaBrains.model.SuccessResponse;
import com.javaBrains.javaBrains.repository.PolicyRepository;
import org.springframework.stereotype.Service;

@Service
public class PolicyService {
    private final PolicyRepository policyRepository;

    public PolicyService(PolicyRepository policyRepository) {
        this.policyRepository = policyRepository;
    }

    public SuccessResponse createNewPolicy(PolicyRequest request) {

        Policy policy = null;
        switch (request.getFlowType()){
            case PURCHASE:
                policy = new PolicyPurchase();
                break;
            case  ENDORSEMENT:
                policy = new PolicyEndorsement();
                break;
            case RENEWAL:
                policy = new PolicyRenewal();
                break;
            default:
                break;
        }

        policy.setComment(request.getComment());
        /*do you want to know how this save working ?
        * its so simple , Based on the object instantiation its just saving the concrete object with its repository
        */
        policyRepository.save(policy);
        return new SuccessResponse("Success");
    }
}
