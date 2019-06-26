/**
 * 
 */
package org.com.data.services;

import java.util.List;
import java.util.Optional;

import org.com.data.exception.AdminNotFoundException;
import org.com.data.model.Admin;
import org.com.data.repository.AdminRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author sanjsingh
 *
 */
@Component
public class AdminServicesImpl implements AdminServices {

	@Autowired
	private AdminRepository adminrepository;

	@Override
	public List<Admin> getAllAdminList() {

		return (List<Admin>) adminrepository.findAll();
	}

	@Override
	public Admin getAdminByID(int id) {

		Optional<Admin> dd = adminrepository.findById(id);
		if (dd.isPresent()) {
			return dd.get();
		} else {
			throw new AdminNotFoundException("Admin Not Found Exception");
		}
	}

	@Override
	public Admin save(Admin admin) {

		return adminrepository.save(admin);

	}
	
	@Override
	public List<Admin> saveAll(List<Admin> admin) {
		return (List<Admin>) adminrepository.saveAll(admin);
	}

	@Override
	public void delete(int id) {
		Optional<Admin> dd = adminrepository.findById(id);
		System.out.println(dd);
		if (dd.isPresent()) {
			adminrepository.deleteById(id);
		} else {
			throw new AdminNotFoundException("Please Enter Correct Admin ID");
		}

	}

	@Override
	public Admin update(int id, Admin admin) {
		Optional<Admin> dd = adminrepository.findById(id);
		if (dd.isPresent()) {
			return adminrepository.save(admin);
		} else {
			throw new AdminNotFoundException("Admin Not Found Exception");
		}
	}

	@Override
	public void deleteAll(List<Admin> admin) {
		adminrepository.deleteAll(admin);
	}

}
