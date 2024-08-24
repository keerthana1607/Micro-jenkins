package com.keerthana.demo.repoimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.keerthana.demo.model.TaxPolicy;
import com.keerthana.demo.repo.TaxPolicyRepo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;

@Repository
public class TaxPolicyRepoImpl implements TaxPolicyRepo {

	@Autowired
	EntityManager entityMan;

	@SuppressWarnings("unchecked")
	@Override
	public List<TaxPolicy> getPolicyDetails() {
		return entityMan.createQuery("from TaxPolicy").getResultList();
	}

	@Override
	public TaxPolicy findById(int policyId) {
		return entityMan.find(TaxPolicy.class, policyId);
	}

	public TaxPolicy registerPolicy(TaxPolicy tax) {

		entityMan.persist(tax);
		return tax;
	}

//	public TaxPolicy updatePolicies(TaxPolicy tax) {
//		
//		try {
//			TaxPolicy taxpolicies = new TaxPolicy();
////			taxpolicies.setPackageId(pack.getPackageId());
//			taxpolicies.setPolicyName(tax.getPolicyName());
//			taxpolicies.setEffectiveFrom(tax.getEffectiveFrom());
//			taxpolicies.setEffectiveTo(tax.getEffectiveTo());
//			taxpolicies.setDescription(tax.getDescription());
//			taxpolicies.setPolicyType(tax.getPolicyType());
//			taxpolicies.setIncomeFrom(tax.getIncomeFrom());
//			taxpolicies.setIncomeTo(tax.getIncomeTo());
//			taxpolicies.setTaxRates(tax.getTaxRates());
//			entityMan.merge(taxpolicies);
//
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//		return null;
//	}
//		
	@Override
	public TaxPolicy updatePolicies(TaxPolicy tax) {
		try {
			// Fetch existing policy from the database
			TaxPolicy existingPolicy = entityMan.find(TaxPolicy.class, tax.getPolicyId());

			if (existingPolicy != null) {
				// Update fields of the existing policy
				existingPolicy.setPolicyName(tax.getPolicyName());
				existingPolicy.setEffectiveFrom(tax.getEffectiveFrom());
				existingPolicy.setEffectiveTo(tax.getEffectiveTo());
				existingPolicy.setDescription(tax.getDescription());
				existingPolicy.setPolicyType(tax.getPolicyType());
				existingPolicy.setIncomeFrom(tax.getIncomeFrom());
				existingPolicy.setIncomeTo(tax.getIncomeTo());
				existingPolicy.setTaxRates(tax.getTaxRates());

				// Merge the updated policy back to the database
				entityMan.merge(existingPolicy);
				return existingPolicy;
			} else {
				// Handle the case where the policy does not exist
				return null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public boolean deletePolicies(int policyId) {
		Query query = entityMan.createQuery("DELETE TaxPolicy p WHERE p.policyId = :policyId");
		query.setParameter("policyId", policyId);
		query.executeUpdate();
		return true;
	}

	@SuppressWarnings("unchecked")

	public List<TaxPolicy> getPackageDetailsIdlist(int policyId) {
		Query q = entityMan.createQuery("SELECT c.policyId FROM TaxPolicy c");
		return q.getResultList();
	}

	@Override
	public Double getEqualentTaxRate(double amount) {
		String jpql = "SELECT t.taxRates FROM TaxPolicy t WHERE :amount BETWEEN t.incomeFrom AND t.incomeTo";
		TypedQuery<Double> query = entityMan.createQuery(jpql, Double.class);
		query.setParameter("amount", amount);

		return query.getResultStream().findFirst().orElse(0.0);
	}

	@SuppressWarnings("unchecked")
	public List<TaxPolicy> findByPolicyType() {

		return entityMan.createQuery("select policyType from TaxPolicy").getResultList();

	}

}
