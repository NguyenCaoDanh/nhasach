package com.ncd.storeapplication.repository;

import com.ncd.storeapplication.entity.ApplyVoucher;
import com.ncd.storeapplication.generic.IRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ApplyVoucherRepository extends IRepository<ApplyVoucher,Integer> {
}