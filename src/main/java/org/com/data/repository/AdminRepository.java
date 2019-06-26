/**
 * 
 */
package org.com.data.repository;

import org.com.data.model.Admin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * @author sanjsingh
 *
 */
@Repository
public interface AdminRepository extends CrudRepository<Admin, Integer> {

}
