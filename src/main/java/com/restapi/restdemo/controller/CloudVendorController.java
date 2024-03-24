package com.restapi.restdemo.controller;

import com.restapi.restdemo.model.CloudVendor;
import com.restapi.restdemo.response.ResponseHandler;
import com.restapi.restdemo.service.CloudVendorService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cloudVendor")
public class CloudVendorController {

    CloudVendorService cloudVendorService;
    public CloudVendorController(CloudVendorService cloudVendorService) {
        this.cloudVendorService = cloudVendorService;
    }


    //read specific cloud vendor
    @GetMapping("{vendorId}")
    public ResponseEntity<Object> getCloudVendorDetails(@PathVariable("vendorId") String vendorId) {
      return  ResponseHandler.responseBuilder("Requested Vendor details are here", HttpStatus.OK,cloudVendorService.getCloudVendor(vendorId));
     //  return cloudVendorService.getCloudVendor(vendorId);
    }
    //get all cloud Vendor in list form
    @GetMapping()
    public List<CloudVendor> getAllCloudVendorDetails() {
        return cloudVendorService.getAllCloudVendor();
    }



//creating the post request
    @PostMapping
    public  String createCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
    {
        cloudVendorService.createCloudVendor(cloudVendor);
        return "created successfully";

    }
  //creating the put request update
    @PutMapping
  public  String updateCloudVendorDetails(@RequestBody CloudVendor cloudVendor)
  {
      cloudVendorService.updateCloudVendor(cloudVendor);
      return "Cloud vendor updated successfully";
  }

  //delete request
    @DeleteMapping("{vendorId}")
  public  String deleteCloudVendorDetails(@PathVariable("vendorId") String vendorId)
  {
      cloudVendorService.deleteCloudVendor(vendorId);
      return "Cloud vendor Deleted successfully";

  }



}
