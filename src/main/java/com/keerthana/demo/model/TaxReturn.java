package com.keerthana.demo.model;

import java.time.LocalDate;


import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "tax_return")
public class TaxReturn {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int formId;

	private LocalDate formDate;

	private String formStatus;

	private int age;

	private String incomeType;

	private double incomeAmount;

	private String deductionType;

	private double deductionAmount;

	private double taxableAmount;

	private double calculatedTax;

	@Lob
	@Column(length = 10000000)
	private byte[] proof;

	public TaxReturn(byte[] proof) {
		super();
		this.proof = proof;
	}

	

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;

	public TaxReturn() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaxReturn(int formId, LocalDate formDate, String formStatus, int age, String incomeType, double incomeAmount,
			String deductionType, double deductionAmount, double taxableAmount, double calculatedTax, User user) {
		super();
		this.formId = formId;
		this.formDate = formDate;
		this.formStatus = formStatus;
		this.age = age;
		this.incomeType = incomeType;
		this.incomeAmount = incomeAmount;
		this.deductionType = deductionType;
		this.deductionAmount = deductionAmount;
		this.taxableAmount = taxableAmount;
		this.calculatedTax = calculatedTax;
		this.user = user;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public LocalDate getFormDate() {
		return formDate;
	}

	public void setFormDate(LocalDate formDate) {
		this.formDate = formDate;
	}

	public String getFormStatus() {
		return formStatus;
	}

	public void setFormStatus(String formStatus) {
		this.formStatus = formStatus;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getIncomeType() {
		return incomeType;
	}

	public void setIncomeType(String incomeType) {
		this.incomeType = incomeType;
	}

	public double getIncomeAmount() {
		return incomeAmount;
	}

	public void setIncomeAmount(double incomeAmount) {
		this.incomeAmount = incomeAmount;
	}

	public String getDeductionType() {
		return deductionType;
	}

	public void setDeductionType(String deductionType) {
		this.deductionType = deductionType;
	}

	public double getDeductionAmount() {
		return deductionAmount;
	}

	public void setDeductionAmount(double deductionAmount) {
		this.deductionAmount = deductionAmount;
	}

	public double getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(double taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

	public double getCalculatedTax() {
		return calculatedTax;
	}

	public void setCalculatedTax(double calculatedTax) {
		this.calculatedTax = calculatedTax;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	public byte[] getProof() {
		return proof;
	}

	public void setProof(byte[] proof) {
		this.proof = proof;
	}

}
