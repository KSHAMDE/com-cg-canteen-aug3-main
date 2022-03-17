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

import com.cg.canteen.aug3.AdminEntity.Snacks;
import com.cg.canteen.aug3.AdminServices.SnacksService;

@RestController
public class SnacksController {
	
	@Autowired
	SnacksService snacksService;
	
	private static final Logger LOG = LoggerFactory.getLogger(SnacksController.class);
	
	
	@GetMapping("/getSnacks/{sId}")
    public ResponseEntity<Snacks> getSnacksById(@PathVariable int sId) {
        LOG.info("getSnacks");
        Snacks snacks = snacksService.getSnacksById(sId);
        return new ResponseEntity<Snacks>(snacks, HttpStatus.OK);
    }
	
	@GetMapping("/getAllSnacks")
    public List<Snacks> getAllSnacks() {
        LOG.info("getAllSnacks");
        return snacksService.getAllSnacks();
    }
		
	@PostMapping("/addSnacks")
    public Snacks addSnacks(@RequestBody Snacks snacks) {
        LOG.info("addSnacks");
        return snacksService.addSnacks(snacks);
    }
	
	@PutMapping("/updateSnacks")
    public Snacks updateSnacks(@RequestBody Snacks snacks) {
        LOG.info("updateSnacks");
        return snacksService.updateSnacks(snacks);
    }

 

    // http://localhost:8082/deleteEmp/{eid}
    @DeleteMapping("/deleteSnacks/{sId}")
    public int deleteSnacks(@PathVariable int sId) {
        LOG.info("deleteSnacks");
        return snacksService.deleteSnacks(sId);
    }
    
    @GetMapping("/getSnacksWithPrice/{sPrice}")
    public ResponseEntity<List<Snacks>> getSnacksWithPrice(@PathVariable double sPrice) {
        LOG.info("getSnacksWithPrice");
        List<Snacks> snkList = snacksService.getSnackWithPrice(sPrice);
        return new ResponseEntity<>(snkList, HttpStatus.OK);
    }
    
    @GetMapping("/getSnackWithName/{sName}")
    public ResponseEntity<List<Snacks>> getSnackWithName(@PathVariable String sName) {
        LOG.info("getSnackWithName");
        List<Snacks> snkList = snacksService.getSnackWithName(sName);
        return new ResponseEntity<>(snkList, HttpStatus.OK);
    }
    
    @GetMapping("/getSnackWithPriceLessThan/{sPrice}")
    public ResponseEntity<List<Snacks>> getSnacksWithPriceLessThan(@PathVariable double sPrice) {
        LOG.info("getSnackWithPriceLessThan");
        List<Snacks> snkList = snacksService.getSnackWithPriceLessThan(sPrice);
        return new ResponseEntity<>(snkList, HttpStatus.OK);
    }
    
    @GetMapping("/getSnackWithPriceGreaterThan/{sPrice}")
    public ResponseEntity<List<Snacks>> getSnacksWithPriceGreaterThan(@PathVariable double sPrice) {
        LOG.info("getSnackWithPriceGreaterThan");
        List<Snacks> snkList = snacksService.getSnackWithPriceGreaterThan(sPrice);
        return new ResponseEntity<>(snkList, HttpStatus.OK);
    }
}
