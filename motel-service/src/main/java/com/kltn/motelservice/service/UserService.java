/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.kltn.motelservice.service;

import com.kltn.motelservice.entity.Role;
import com.kltn.motelservice.entity.RoleName;
import com.kltn.motelservice.entity.User;

/**
 *
 * @author 97lynk
 */
public interface UserService {

    User selectUserByEmail(String userName);

    Role selectRoleByName(RoleName name);
}
