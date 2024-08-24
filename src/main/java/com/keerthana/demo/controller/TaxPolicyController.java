package com.keerthana.demo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.keerthana.demo.model.TaxPolicy;
import com.keerthana.demo.service.TaxPolicyService;


@RestController
@CrossOrigin("*")
@RequestMapping("/taxpolicies")
public class TaxPolicyController {

	@Autowired
	private TaxPolicyService taxPolicyService;

	// to get all the data from the database
	@GetMapping("/getAllPoliciesList")
	public List<TaxPolicy> getPolicyDetails() {
		return taxPolicyService.getAllPoliciesDetails();
	}
	
	@GetMapping("/getAllPoliciesListById")
	public List<TaxPolicy> getPolicyDetailsById(int policyId) {
		return taxPolicyService.getAllPoliciesDetailsById(policyId);
	}

	
	@GetMapping("/getAllPoliciesType")
	public List<TaxPolicy> getPolicyTypes() {
		return taxPolicyService.getAllPoliciesType();
	}

	
	// get by id
	@GetMapping("/GetPolicyId/{policyId}")
	public TaxPolicy find(@PathVariable("policyId") int policyId) {
		return taxPolicyService.find(policyId);
	}

	@PostMapping("/doPoliciesDetailsInsert")
	public TaxPolicy regPack(@RequestBody TaxPolicy tax) {

		return taxPolicyService.regPolicy(tax);

	}

	

	@PutMapping("/doPolicyDetailsUpdate")
	public TaxPolicy updatePolicy(@RequestBody TaxPolicy tax) {

		return taxPolicyService.updatePolicy(tax);

	}
	
	

	@DeleteMapping("/deletePolicy/{policyId}")
	public boolean deletePolicies(@PathVariable("policyId") int policyId) {
		return taxPolicyService.deletePolicy(policyId);

	}
}
