package com.vericab.trips.repositories;

import com.vericab.trips.model.*;
import com.vericab.trips.models.Role;
import com.vericab.trips.models.RoleName;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName roleName);
}
