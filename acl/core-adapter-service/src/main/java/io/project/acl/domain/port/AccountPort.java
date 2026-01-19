/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package io.project.acl.domain.port;

import io.project.acl.domain.model.BalanceResult;

/**
 *
 * @author armen_arzumanyan
 */
public interface AccountPort {

    BalanceResult getBalance(String accountId);
}
