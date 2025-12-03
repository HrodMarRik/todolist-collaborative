package com.phalanx.service;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.phalanx.model.ListInfo;

@Repository
public interface ListInfoRepository extends JpaRepository<ListInfo, Integer> {
   
    // custom query to search in contact
    List<ListInfo> findByTitleContaining(String text);  
}

