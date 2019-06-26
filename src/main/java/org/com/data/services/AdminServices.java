/**
 * 
 */
package org.com.data.services;

import java.util.List;

import org.com.data.model.Admin;
import org.springframework.stereotype.Service;

/**
 * @author sanjsingh
 *
 */
@Service
public interface AdminServices {

	public List<Admin> getAllAdminList();

	public Admin getAdminByID(int id);

	public Admin save(Admin admin);

	public void delete(int id);

	public Admin update(int id, Admin admin);
	
	public void deleteAll(List<Admin> admin);

	List<Admin> saveAll(List<Admin> admin);

}
