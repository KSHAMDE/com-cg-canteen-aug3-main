package com.cg.canteen.aug3.AdminController;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cg.canteen.aug3.AdminEntity.Beverages;

import com.cg.canteen.aug3.AdminServices.BeveragesService;

@RestController
public class BeveragesController {
	
	@Autowired
	BeveragesService beveragesService;
	
	
	private static final Logger LOG = LoggerFactory.getLogger(BeveragesController.class);
	
	@GetMapping("/getBeverages/{bId}")
    public ResponseEntity<Beverages> getBeveragesById(@PathVariable int bId) {
        LOG.info("getBeverages");
        Beverages beverages = beveragesService.getBeveragesById(bId);
        return new ResponseEntity<Beverages>(beverages, HttpStatus.OK);
    }
	
	@GetMapping("/getAllBeverages")
    public List<Beverages> getAllBeverages() {
        LOG.info("getAllBeverages");
        return beveragesService.getAllBeverages();
    }
	
//	public ResponseEntity<Beverages> getBeveragesByPrice(@PathVariable int b_price) {
//        LOG.info("getSBeveragesByPrice");
//        Beverages beverages = beveragesService.getBeveragesByPrice(b_price);
//        return new ResponseEntity<Snacks>(snacks, HttpStatus.OK);
//    }
	
	@PostMapping("/addBeverages")
    public Beverages addBeverages(@RequestBody Beverages beverages) {
        LOG.info("addBeverages");
        return beveragesService.addBeverages(beverages);
    }
	
	@PutMapping("/updateBeverages")
    public Beverages updateBeverages(@RequestBody Beverages beverages) {
        LOG.info("updateBeverages");
        return beveragesService.updateBeverages(beverages);
    }

 

    // http://localhost:8082/deleteEmp/{bId}
    @DeleteMapping("/deleteBeverages/{bId}")
    public int deleteBeverages(@PathVariable int bId) {
        LOG.info("deleteBeverages");
        return beveragesService.deleteBeverages(bId);
    }
    
    
    
    @GetMapping("/getBeveragesWithPrice/{bPrice}")
    public ResponseEntity<List<Beverages>> getBeveragesWithPrice(@PathVariable double bPrice) {
        LOG.info("getBeveragesWithPrice");
        List<Beverages> beList = beveragesService.getBeveragesWithPrice(bPrice);
        return new ResponseEntity<>(beList, HttpStatus.OK);
    }
    
    @GetMapping("/getBeveragesWithName/{bName}")
    public ResponseEntity<List<Beverages>> getBeveragesWithName(@PathVariable String bName) {
        LOG.info("getBeveragesWithName");
        List<Beverages> beList = beveragesService.getBeveragesWithName(bName);
        return new ResponseEntity<>(beList, HttpStatus.OK);
    }
    
    @GetMapping("/getBeveragesWithPriceLessThan/{bPrice}")
    public ResponseEntity<List<Beverages>> getSnacksWithPriceLessThan(@PathVariable double bPrice) {
        LOG.info("getBeveragesWithPriceLessThan");
        List<Beverages> beList = beveragesService.getBeveragesWithPriceLessThan(bPrice);
        return new ResponseEntity<>(beList, HttpStatus.OK);
    }
    
    @GetMapping("/getBeveragesWithPriceGreaterThan/{bPrice}")
    public ResponseEntity<List<Beverages>> getBeveragesWithPriceGreaterThan(@PathVariable double bPrice) {
        LOG.info("getBeveragesWithPriceGreaterThan");
        List<Beverages> beList = beveragesService.getBeveragesWithPriceGreaterThan(bPrice);
        return new ResponseEntity<>(beList, HttpStatus.OK);
    }
}
