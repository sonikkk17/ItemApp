package com.cpan252.tekkenreborn.repository;

import com.cpan252.tekkenreborn.model.Item;
import com.cpan252.tekkenreborn.model.Item.Brand;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//It will be an interface that defines operations with the fighter
//table in the database
@Repository
public interface ItemRepository  extends CrudRepository<Item, Long> {

    List<Item> findByBrandFromAndCreatedAt(Brand brand, int yearOfCreation);
}
