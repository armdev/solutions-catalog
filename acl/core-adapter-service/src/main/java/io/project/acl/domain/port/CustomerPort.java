/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.acl.domain.port;

import io.project.acl.domain.dto.CustomerDto;
import java.util.Optional;

/**
 *
 * @author armen_arzumanyan
 */
public interface CustomerPort {

   public Optional<CustomerDto> findCustomerById(Long customerId);
}
