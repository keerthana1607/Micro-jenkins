package com.keerthana.demo.serviceimpl;

import com.keerthana.demo.service.TaxPolicyService;


import jakarta.transaction.Transactional;

import com.keerthana.demo.model.TaxPolicy;
import com.keerthana.demo.repo.TaxPolicyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@Transactional
public class TaxPolicyServiceImpl implements TaxPolicyService {

	@Autowired
	private TaxPolicyRepo taxPolicyRepository;

	@Override
	public List<TaxPolicy> getAllPoliciesDetails() {
		return taxPolicyRepository.getPolicyDetails();
	}

	@Override
	public TaxPolicy find(int policyId) {
		return taxPolicyRepository.findById(policyId);
	}

	@Override
	public TaxPolicy regPolicy(TaxPolicy tax) {
		return taxPolicyRepository.registerPolicy(tax);
	}

	@Override
	public TaxPolicy updatePolicy(TaxPolicy tax) {
		return taxPolicyRepository.updatePolicies(tax);
	}

	@Override
	public boolean deletePolicy(int policyId) {
		return taxPolicyRepository.deletePolicies(policyId);
	}

	public List<TaxPolicy> getAllPoliciesDetailsById(int policyId) {
		return taxPolicyRepository.getPackageDetailsIdlist(policyId);
	}

	@Override
	public List<TaxPolicy> getAllPoliciesType() {
		return taxPolicyRepository.findByPolicyType();
	}

}
