package com.yebelo.dbassignment.repository;

import com.yebelo.dbassignment.entity.ShipDetail;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ShipDetailRepository extends JpaRepository<ShipDetail, Integer> {

    Pageable sortedByIdDesc = PageRequest.of(0, 10, Sort.by("id").descending());

    @Override
    Page<ShipDetail> findAll(Pageable page);
}
