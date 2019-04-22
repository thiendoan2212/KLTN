package com.kltn.motelservice.repository;

import com.kltn.motelservice.entity.Role;
import com.kltn.motelservice.entity.RoleName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Role findByName(RoleName roleName);
}
