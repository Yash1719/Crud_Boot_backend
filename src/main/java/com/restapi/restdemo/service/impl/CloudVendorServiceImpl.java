package com.restapi.restdemo.service.impl;

import com.restapi.restdemo.exception.CloudVendorNotFoundException;
import com.restapi.restdemo.model.CloudVendor;
import com.restapi.restdemo.repository.CloudVendorRepository; //doubt
import com.restapi.restdemo.service.CloudVendorService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CloudVendorServiceImpl implements CloudVendorService {

    CloudVendorRepository cloudVendorRepository;
    public CloudVendorServiceImpl(CloudVendorRepository cloudVendorRepository){
        this.cloudVendorRepository=cloudVendorRepository;
    }

    @Override
    public String createCloudVendor(CloudVendor cloudvendor) {
        cloudVendorRepository.save(cloudvendor);
        return "Data saved success";
    }

    @Override
    public String updateCloudVendor(CloudVendor cloudvendor) {
        cloudVendorRepository.save(cloudvendor);
        return "Success update";
    }

    @Override
    public String deleteCloudVendor(String cloudVendorId) {
        cloudVendorRepository.deleteById(cloudVendorId);
        return "delete done";
    }

    @Override
    public CloudVendor getCloudVendor(String cloudVendorId) {
        if(cloudVendorRepository.findById(cloudVendorId).isEmpty())
            throw new CloudVendorNotFoundException("Requested cloud vendor does not exist!!");
       return cloudVendorRepository.findById(cloudVendorId).get();
    }

    @Override
    public List<CloudVendor> getAllCloudVendor() {

        return cloudVendorRepository.findAll();
    }
}
