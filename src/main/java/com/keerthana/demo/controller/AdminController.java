package com.keerthana.demo.controller;


import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.keerthana.demo.model.Admin;
import com.keerthana.demo.service.AdminService;

@RestController
@CrossOrigin("*")
@RequestMapping("/admin")
public class AdminController {

		@Autowired
		AdminService adminservice;

	    // to insert the data
		@PostMapping("/doadmininsert")
		public Admin insertAdmin(@RequestBody Admin newAdmin) {
			return adminservice.newAdmin(newAdmin);

		}

		@PutMapping("/updateadmin")
		public Admin updateAdmin(@RequestBody Admin admin) {

			return adminservice.updateAdmin(admin);
		}

		// to get all the data from the database
		@GetMapping("/getallAdminList")
		public List<Admin> getAdmins() {
			return adminservice.getAdmins();
		}

		// get by id
		@GetMapping("/getadminid/{adminId}")
		public Admin appfind(@PathVariable("adminId") int adminId) {
			return adminservice.adminfind(adminId);
		}

		@GetMapping("/loginadmin/{adminName}/{adminPassword}")
		public boolean loginAdmin(@PathVariable("adminName") String adminName,
				@PathVariable("adminPassword") String adminPassword) {
			try {
				adminservice.adminLogin(adminName, adminPassword);
				return true;
			} catch (Exception e) {
				return false;
			}
		}
}

	

