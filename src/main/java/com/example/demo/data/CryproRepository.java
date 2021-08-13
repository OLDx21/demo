package com.example.demo.data;

import com.example.demo.model.CryptoClass;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface CryproRepository extends MongoRepository<CryptoClass, Double> {

    @Query("{$expr:{$and:[{$eq:[{$year:'$createdDate'}, ?0]}, {$eq:[{$month:'$createdDate'}, ?1]}]}")
    List<CryptoClass> findByMonth(int year, int month );

    List<CryptoClass> findByDateBetween(Date firstdayofmonth, Date lastdayofmonth );

    Page<CryptoClass> findAll(Pageable pageable);
}
