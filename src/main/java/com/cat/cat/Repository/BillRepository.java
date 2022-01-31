package com.cat.cat.Repository;

import com.cat.cat.Model.BillData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BillRepository extends MongoRepository<BillData, ObjectId> {
}
