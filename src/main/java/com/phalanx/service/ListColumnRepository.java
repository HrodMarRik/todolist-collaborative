package com.phalanx.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.phalanx.model.ListColumn;

@Repository
public interface ListColumnRepository extends JpaRepository<ListColumn, Integer> {

}