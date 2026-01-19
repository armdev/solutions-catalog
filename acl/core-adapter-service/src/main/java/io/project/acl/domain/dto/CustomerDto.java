/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.acl.domain.dto;

import lombok.Data;

/**
 *
 * @author lenovo
 */
@Data
public class CustomerDto {

    private final Long customerId;
    private final String customer;
    private final String email;
    private final String nameE;
    private final String personNum;

    public CustomerDto(Long customerId, String customer, String email,
                       String nameE, String personNum) {
        this.customerId = customerId;
        this.customer = customer;
        this.email = email;
        this.nameE = nameE;
        this.personNum = personNum;
    }

    // getters only (immutable)
}
