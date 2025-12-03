package com.phalanx.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.phalanx.model.ListRoles;

@Repository
public interface ListRolesRepository extends JpaRepository<ListRoles, Integer> {

}
