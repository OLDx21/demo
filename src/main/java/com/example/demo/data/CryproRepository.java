package com.example.demo.data;

import com.example.demo.model.CryptoClass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface CryproRepository extends MongoRepository<CryptoClass, Double> {

    @Query("{$expr:{$and:[{$eq:[{$year:'$createdDate'}, ?0]}, {$eq:[{$month:'$createdDate'}, ?1]}]}")
    List<CryptoClass> findByCustomQuery(int year, int month);

    List<CryptoClass> findByDateBetween(LocalDate from, LocalDate to);
}
