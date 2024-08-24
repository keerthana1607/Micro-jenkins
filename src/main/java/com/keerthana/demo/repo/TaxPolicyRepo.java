package com.keerthana.demo.repo;

import java.util.List;

import com.keerthana.demo.model.TaxPolicy;

public interface TaxPolicyRepo {

	public List<TaxPolicy> getPolicyDetails();

	public TaxPolicy findById(int policyId);

	public TaxPolicy updatePolicies(TaxPolicy tax);

	public boolean deletePolicies(int policyId);

	public TaxPolicy registerPolicy(TaxPolicy tax);
	
	
	public Double getEqualentTaxRate(double amount);

	public List<TaxPolicy> getPackageDetailsIdlist(int policyId);

	

	public List<TaxPolicy> findByPolicyType();

}
