package com.devpoc.multiple.db.rest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.devpoc.multiple.db.mongobonerepo.PatientMongoRepository;
import com.devpoc.multiple.db.mongooneentity.PatientMongo;
import com.devpoc.multiple.db.mongosecondentity.HosptitalMongo;
import com.devpoc.multiple.db.mongosecondrepo.HospitalMongoRepository;
import com.devpoc.multiple.db.rdboneentity.Patient;
import com.devpoc.multiple.db.rdbonerepo.PatientRepository;
import com.devpoc.multiple.db.rdbsecondentity.Hospital;
import com.devpoc.multiple.db.rdbsecondrepo.HospitalRepository;





@RestController
@RequestMapping("/api/hospitalinfo")
public class HospitalInfoController {
	
	
	@Autowired
    private PatientRepository patientRepositry;

    @Autowired
    private HospitalRepository hospitalRepository;

    @Autowired
    private HospitalMongoRepository hospitalmongorepo ;

    @Autowired
    private PatientMongoRepository patientMongoRepository;
    
    @RequestMapping(method = RequestMethod.GET, path = "/db1",
            produces = {
            		 MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Page<Patient> getAllPatientDb1(@RequestHeader final HttpHeaders headers, final Pageable pageable) {
        return patientRepositry.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/db2",
            produces = {
            		 MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Page<Hospital> getAllHospitalDb2(@RequestHeader final HttpHeaders headers, final Pageable pageable) {
        return hospitalRepository.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/mongo1",
            produces = {
            		 MediaType.APPLICATION_JSON_VALUE
            })
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public Page<PatientMongo> getAllPatientMongo1(@RequestHeader final HttpHeaders headers, final Pageable pageable) {
        return patientMongoRepository.findAll(pageable);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/mongo2",
            produces = {
                   MediaType.APPLICATION_JSON_VALUE
           })
    @ResponseBody
    public Page<HosptitalMongo> getAllHospitalMongo1(@RequestHeader final HttpHeaders headers, final Pageable pageable) {
      return hospitalmongorepo.findAll(pageable);
    }


}
