package com.ncd.storeapplication.repository;

import com.ncd.storeapplication.entity.Branches;
import com.ncd.storeapplication.generic.IRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchesRepository extends IRepository<Branches, Integer> {
}
