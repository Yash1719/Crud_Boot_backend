package com.restapi.restdemo.service;

import com.restapi.restdemo.model.CloudVendor;

import java.util.List;

public interface CloudVendorService {

    public String  createCloudVendor(CloudVendor cloudvendor);
    public String updateCloudVendor(CloudVendor cloudvendor);
    public String deleteCloudVendor(String cloudVendorId);
    public CloudVendor getCloudVendor(String cloudVendorId);
    public List<CloudVendor> getAllCloudVendor();
}
