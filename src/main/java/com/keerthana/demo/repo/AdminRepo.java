package com.keerthana.demo.repo;


import java.util.List;

import com.keerthana.demo.model.Admin;

public interface AdminRepo {

	public Admin newAdmin(Admin newAdmin);

	public List<Admin> getAdmins();

	public Admin adminfind(int adminId);

	public List<Integer> getAdminIdList();

	public Admin updateAdmin(Admin admin);

	public Admin adminLogin(String userName, String userPassword);
}
