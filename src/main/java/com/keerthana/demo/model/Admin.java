package com.keerthana.demo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Admin")
public class Admin {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int adminId;
	private String adminName;
	private String adminPassword;
	private String adminMobile;
	private String adminEmail;
	
	
//	@OneToMany(targetEntity = TaxPolicy.class, cascade = CascadeType.REFRESH)
//	@JoinColumn(name = "admin_id")
//	private Set<TaxPolicy> taxPolicy;

	
	public Admin() {
		super();
		
	}

	public Admin(int adminId, String adminName, String adminPassword, String adminMobile, String adminEmail
			) {
		super();
		this.adminId = adminId;
		this.adminName = adminName;
		this.adminPassword = adminPassword;
		this.adminMobile = adminMobile;
		this.adminEmail = adminEmail;
//		this.taxPolicy = taxPolicy;
	
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminMobile() {
		return adminMobile;
	}

	public void setAdminMobile(String adminMobile) {
		this.adminMobile = adminMobile;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

//	public Set<TaxPolicy> getTaxPolicy() {
//		return taxPolicy;
//	}
//
//	public void setTaxPolicy(Set<TaxPolicy> taxPolicy) {
//		this.taxPolicy = taxPolicy;
//	}

	
	

}
