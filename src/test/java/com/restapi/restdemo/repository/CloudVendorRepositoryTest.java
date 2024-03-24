package com.restapi.restdemo.repository;

import com.restapi.restdemo.model.CloudVendor;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import java.util.List;

@DataJpaTest
public class CloudVendorRepositoryTest {

    @Autowired
    private CloudVendorRepository cloudVendorRepository;
    CloudVendor cloudVendor;

    @BeforeEach
    void setUp() {
     cloudVendor =new CloudVendor("1","abc","Kolkata","98766");
     cloudVendorRepository.save(cloudVendor);
    }

    @AfterEach
    void tearDown() {
       cloudVendor=null;
       cloudVendorRepository.deleteAll();
    }

    //Test case success
    @Test
    void testFindByVendorName_Found()
    {
       List<CloudVendor> cloudVendorList= cloudVendorRepository.findByVendorName("abc");
        assertThat(cloudVendorList.get(0).getVendorId()).isEqualTo(cloudVendor.getVendorId());
        assertThat(cloudVendorList.get(0).getVendorAddress()).isEqualTo(cloudVendor.getVendorAddress());
    }



    //test case failure

    @Test
    void testFindByVendorName_NotFound()
    {
        List<CloudVendor> cloudVendorList= cloudVendorRepository.findByVendorName("xyz");
        assertThat(cloudVendorList.isEmpty()).isTrue();

    }


}
