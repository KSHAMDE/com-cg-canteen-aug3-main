package com.cg.canteen.aug3.AdminServices;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.canteen.aug3.AdminEntity.Beverages;

import com.cg.canteen.aug3.AdminException.BeveragesNotFoundException;

import com.cg.canteen.aug3.AdminRepository.BeveragesRepository;

@Service
public class BeveragesService {
	
	@Autowired
	BeveragesRepository beveragesRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(BeveragesService.class);

		public Beverages getBeveragesById(int bId) {
			
			LOG.info("getBeveragesById " + bId);
			Optional<Beverages> bopt=beveragesRepository.findById(bId);
			
			if(bopt.isEmpty()) {
				LOG.error("Beverages Not Found");
				throw new BeveragesNotFoundException();
			}else
				return bopt.get();
	        
	       // return optSnacks.get();
	    }
		
		public List<Beverages> getAllBeverages() {
					
					LOG.info("getAllBeverages");
			        return beveragesRepository.findAll();
			        
			       // return optSnacks.get();
		}
		
		public Beverages addBeverages(Beverages beverages) {
	        LOG.info("addBeverages");
	        try {
	            return beveragesRepository.save(beverages);
	        }catch(IllegalArgumentException iae) {
				LOG.error(iae.getMessage());
	            return null; //Change to meaningful message
			}
	         
	    }
		
		public Beverages updateBeverages(Beverages beverages) {
	        LOG.info("updateBeverage");
	        return beveragesRepository.save(beverages);
	    }
		
		public int deleteBeverages(int bId) {
			
			boolean exists=beveragesRepository.existsById(bId);
			if(exists) {
				LOG.info("deleteSnacks");
				beveragesRepository.deleteById(bId);
			}else {
				LOG.error("Beverages Not Found");
				throw new BeveragesNotFoundException();
			}
	        return bId;
	    }
		
		
		
		public List<Beverages> getBeveragesWithPrice(double bPrice) {
	        LOG.info("getBeveragesByPrice " + bPrice);
	        List<Beverages> beList = beveragesRepository.findBybPrice(bPrice);
	        if (beList.size() == 0) {
	            LOG.error("Beverages not found.");
	            throw new BeveragesNotFoundException();
	        } else
	            return beList;
	    }   
		
		public List<Beverages> getBeveragesWithName(String bName) {
	        LOG.info("getBeveragesWithName" + bName);
	        List<Beverages> beList = beveragesRepository.findBybName(bName);
	        if (beList.size() == 0) {
	            LOG.error("Snacks not found.");
	            throw new BeveragesNotFoundException();
	        } else
	            return beList;
	    } 
		
		public  List<Beverages> getBeveragesWithPriceLessThan(double bPrice){
			LOG.info("getBeveragesWithPriceLessThan" + bPrice);
	        List<Beverages> beList = beveragesRepository.findBybPriceLessThan(bPrice);
	        if (beList.size() == 0) {
	            LOG.error("Beverages not found.");
	            throw new BeveragesNotFoundException();
	        } else
	            return beList;
			
		}
		public  List<Beverages> getBeveragesWithPriceGreaterThan(double bPrice){
			LOG.info("getBeveragesWithPriceGreaterThan" + bPrice);
	        List<Beverages> beList = beveragesRepository.findBybPriceGreaterThan(bPrice);
	        if (beList.size() == 0) {
	            LOG.error("Beverages not found.");
	            throw new BeveragesNotFoundException();
	        } else
	            return beList;
			
		}
}