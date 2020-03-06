package com.devpoc.multiple.db.mongobonerepo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.devpoc.multiple.db.mongooneentity.PatientMongo;

public interface PatientMongoRepository extends MongoRepository<PatientMongo, Long>{

}
