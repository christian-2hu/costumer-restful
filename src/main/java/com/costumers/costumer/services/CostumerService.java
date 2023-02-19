package com.costumers.costumer.services;

import java.util.List;
import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.costumers.costumer.models.Costumer;
import com.costumers.costumer.repositories.CostumerRepository;

@Service
public class CostumerService {

    @Autowired
    private CostumerRepository costumerRepository;

    public String addCostumer(Costumer costumer) {
        costumerRepository.save(costumer);
        return "New costumer has been saved!";
    }
    public String addCostumers(List<Costumer> costumers) {
        costumerRepository.saveAll(costumers);
        return "All costumers has been saved!";
    }
    public Costumer updateCostumer(Costumer costumer) {
        return costumerRepository.save(costumer);
    }
    public String deleteCostumer(Long id) {
        costumerRepository.deleteById(id);
        return "Costumer has been deleted!";
    }
    public Costumer getCostumer(Long id) {
        return costumerRepository.findById(id).orElse(new Costumer());
    }
    public List<Costumer> getCostumers() {
        List<Costumer> costumers = new LinkedList<>();
        costumerRepository.findAll().forEach(
            costumer -> costumers.add(costumer)
        );
        return costumers;
    }
}
