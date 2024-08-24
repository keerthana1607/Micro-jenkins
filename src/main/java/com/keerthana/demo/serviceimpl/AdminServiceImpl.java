package com.keerthana.demo.serviceimpl;

import com.keerthana.demo.service.AdminService;

import com.keerthana.demo.model.Admin;
import com.keerthana.demo.repo.AdminRepo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepo admindao;

	@Override
	public Admin newAdmin(Admin newAdmin) {
		return admindao.newAdmin(newAdmin);
	}

	@Override
	public List<Admin> getAdmins() {

		return admindao.getAdmins();

	}

	@Override
	public Admin adminfind(int adminId) {
		return admindao.adminfind(adminId);
	}

	@Override
	public List<Integer> getAdminIdList() {
		return admindao.getAdminIdList();
	}

	@Override
	public Admin updateAdmin(Admin admin) {
		return admindao.updateAdmin(admin);
	}

	@Override
	public Admin adminLogin(String userName, String userPassword) {
		return admindao.adminLogin(userName, userPassword);
	}
}
