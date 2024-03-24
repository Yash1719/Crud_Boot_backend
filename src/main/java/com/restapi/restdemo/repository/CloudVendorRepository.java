package com.restapi.restdemo.repository;

import com.restapi.restdemo.model.CloudVendor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CloudVendorRepository extends JpaRepository<CloudVendor,String> {
List<CloudVendor> findByVendorName(String vendorName);
}
