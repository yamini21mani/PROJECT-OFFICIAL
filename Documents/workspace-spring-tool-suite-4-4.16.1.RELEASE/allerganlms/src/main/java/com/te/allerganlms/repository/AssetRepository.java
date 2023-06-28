package com.te.allerganlms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.te.allerganlms.entity.Asset;
@Repository
public interface AssetRepository extends JpaRepository<Asset, Integer> {

}
