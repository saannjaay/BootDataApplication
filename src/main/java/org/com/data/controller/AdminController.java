package org.com.data.controller;

import java.util.List;

import org.com.data.exception.AdminNotFoundException;
import org.com.data.model.Admin;
import org.com.data.model.Count;
import org.com.data.services.AdminServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")

public class AdminController {
	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@Autowired
	private AdminServices adminservices;

	@GetMapping("/message")

	public String message() {
		logger.info("GetMapping");
		System.out.println("Hello");
		sy

		return "Welcome Admin";

	}

	@GetMapping
	public List<Admin> getAllAdminList() {
		logger.info("Get all admin list using getMapping");
		return adminservices.getAllAdminList();

	}

	@GetMapping("/{aid}")
	public Admin getAdmin(@PathVariable(name = "aid") int aid, @RequestAttribute("counter") Count counter)
			throws AdminNotFoundException {
		Admin admin = adminservices.getAdminByID(aid);
		counter.setCount(counter.getCount() + 1);
		System.out.println(counter.toString());
		return admin;
	}

	@DeleteMapping("/{aid}")
	public void delete(@PathVariable(name = "aid") Integer aid) throws AdminNotFoundException {
		logger.info("create new  user using @PostMapping");
		adminservices.delete(aid);

	}

	@PostMapping
	public Admin addAdmin(@RequestBody Admin admin) {
		admin.setAid(0);
		logger.info("create new  user using @PostMapping");
		return adminservices.save(admin);
	}

	@PostMapping("/all")
	public List<Admin> addAdmins(@RequestBody List<Admin> admins) throws Exception {
		System.err.println("sssssssssssssssssss");
		if (!admins.isEmpty()) {
			admins.forEach(e -> e.setAid(0));
			logger.info("create new  user using @PostMapping");
			return adminservices.saveAll(admins);
		} else {
			throw new Exception("No users in request");
		}

	}

	@PutMapping("/{aid}")
	public Admin updateAdmin(@PathVariable(name = "aid") Integer id, @RequestBody Admin admin)
			throws AdminNotFoundException {

		return adminservices.update(id, admin);

	}

	@DeleteMapping
	public void deleteMultiple(@RequestBody List<Admin> admin) throws AdminNotFoundException {
		try {
			adminservices.deleteAll(admin);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@RequestMapping("/count")
	public String getCount(@RequestAttribute("Count") Count count) {

		count.setCount(count.getCount() + 1);

		return count.toString();

	}
}
