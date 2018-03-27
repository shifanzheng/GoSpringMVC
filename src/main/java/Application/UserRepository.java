/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Application;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Shifan
 */
public interface UserRepository extends CrudRepository<UserModel, Long> {

}
