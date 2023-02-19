package com.costumers.costumer.repositories;

import org.springframework.data.repository.CrudRepository;

import com.costumers.costumer.models.Costumer;

public interface CostumerRepository extends CrudRepository<Costumer, Long> {
    
}
