package com.keerthana.demo.repoimpl;

import com.keerthana.demo.repo.AdminRepo;


import com.keerthana.demo.model.Admin;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

@Repository
public class AdminRepoImpl implements AdminRepo {

	@Autowired
	EntityManager entityMan;

	public Admin newAdmin(Admin newAdmin) {
		entityMan.persist(newAdmin);
		return newAdmin;
	}

	@SuppressWarnings("unchecked")

	public List<Admin> getAdmins() {
		return entityMan.createQuery("from Admin").getResultList();
	}

	public Admin adminfind(int adminId) {
		return entityMan.find(Admin.class, adminId);
	}

	@SuppressWarnings("unchecked")

	public List<Integer> getAdminIdList() {
		Query q = entityMan.createQuery("SELECT c.adminId FROM Admin c");
		return q.getResultList();
	}

	public Admin updateAdmin(Admin admin) {
		entityMan.merge(admin);
		return admin;
	}

	public Admin adminLogin(String adminName, String adminPassword) {
		Query query1 = entityMan.createQuery("from Admin u where u.adminName =?1 and u.adminPassword=?2");
		query1.setParameter(1, adminName);
		query1.setParameter(2, adminPassword);

		return (Admin) query1.getSingleResult();

	}
}
