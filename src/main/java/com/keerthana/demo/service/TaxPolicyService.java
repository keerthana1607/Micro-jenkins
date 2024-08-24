package com.keerthana.demo.service;


import com.keerthana.demo.model.TaxPolicy;
import java.util.List;


public interface TaxPolicyService {

	
	
		List<TaxPolicy> getAllPoliciesDetails();

		TaxPolicy find(int policyId);

		TaxPolicy regPolicy(TaxPolicy tax);

		TaxPolicy updatePolicy(TaxPolicy tax);

		boolean deletePolicy(int policyId);

	
		
		public List<TaxPolicy> getAllPoliciesDetailsById(int policyId);

		List<TaxPolicy> getAllPoliciesType();
		
	}

	

