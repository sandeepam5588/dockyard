package com.yebelo.dbassignment.repository;

import com.yebelo.dbassignment.entity.ShipDetail;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipDetailRepository extends JpaRepository<ShipDetail, Integer> {
}
