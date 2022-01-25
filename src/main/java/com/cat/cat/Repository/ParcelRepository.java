package com.cat.cat.Repository;


import com.cat.cat.Model.ParcelData;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParcelRepository extends MongoRepository<ParcelData,Long> {
}
