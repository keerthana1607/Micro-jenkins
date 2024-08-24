package com.keerthana.demo.model;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tax_policy")
public class TaxPolicy {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int policyId;

	private String policyName;

	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate effectiveFrom;

	 @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate effectiveTo;

	private String description;

	private String policyType;

	private double incomeFrom;

	private double incomeTo;

	private double taxRates;
	
	

	public TaxPolicy() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaxPolicy(int policyId, String policyName, LocalDate effectiveFrom, LocalDate effectiveTo,
			String description, String policyType, double incomeFrom, double incomeTo, double taxRates) {
		super();
		this.policyId = policyId;
		this.policyName = policyName;
		this.effectiveFrom = effectiveFrom;
		this.effectiveTo = effectiveTo;
		this.description = description;
		this.policyType = policyType;
		this.incomeFrom = incomeFrom;
		this.incomeTo = incomeTo;
		this.taxRates = taxRates;
	}

	public int getPolicyId() {
		return policyId;
	}

	public void setPolicyId(int policyId) {
		this.policyId = policyId;
	}

	public String getPolicyName() {
		return policyName;
	}

	public void setPolicyName(String policyName) {
		this.policyName = policyName;
	}

	public LocalDate getEffectiveFrom() {
		return effectiveFrom;
	}

	public void setEffectiveFrom(LocalDate effectiveFrom) {
		this.effectiveFrom = effectiveFrom;
	}

	public LocalDate getEffectiveTo() {
		return effectiveTo;
	}

	public void setEffectiveTo(LocalDate effectiveTo) {
		this.effectiveTo = effectiveTo;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPolicyType() {
		return policyType;
	}

	public void setPolicyType(String policyType) {
		this.policyType = policyType;
	}

	public double getIncomeFrom() {
		return incomeFrom;
	}

	public void setIncomeFrom(double incomeFrom) {
		this.incomeFrom = incomeFrom;
	}

	public double getIncomeTo() {
		return incomeTo;
	}

	public void setIncomeTo(double incomeTo) {
		this.incomeTo = incomeTo;
	}

	public double getTaxRates() {
		return taxRates;
	}

	public void setTaxRates(double taxRates) {
		this.taxRates = taxRates;
	}
	
	
	

}
