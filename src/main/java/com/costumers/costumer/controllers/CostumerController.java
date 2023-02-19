package com.costumers.costumer.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.costumers.costumer.models.Costumer;
import com.costumers.costumer.services.CostumerService;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class CostumerController {

    @Autowired
    private CostumerService costumerService;
    
    @GetMapping("/costumers")
    public List<Costumer> getCostumers() {
        return costumerService.getCostumers();
    }
    @GetMapping("/costumers/{id}")
    public Costumer findById(@PathVariable("id") Long id) {
        return costumerService.getCostumer(id);
    }
    @DeleteMapping("/costumers/{id}")
    public void deleteCostumer(@PathVariable("id") Long id) {
        costumerService.deleteCostumer(id);
    }
    @PutMapping("/costumers/{id}")
    public Costumer updateCostumer(@PathVariable Long id, @RequestBody Costumer costumer) {
        costumer.setId(id);
        return costumerService.updateCostumer(costumer);
    }
    @PostMapping("/costumers")
    public @ResponseBody void saveCostumer(@RequestBody Costumer costumer) {
        costumerService.addCostumer(costumer);
    }

}
