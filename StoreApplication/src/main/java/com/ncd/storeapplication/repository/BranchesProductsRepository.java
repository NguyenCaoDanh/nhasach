package com.ncd.storeapplication.repository;

import com.ncd.storeapplication.entity.BranchesProducts;
import com.ncd.storeapplication.generic.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchesProductsRepository extends IRepository<BranchesProducts,Integer> {
}
