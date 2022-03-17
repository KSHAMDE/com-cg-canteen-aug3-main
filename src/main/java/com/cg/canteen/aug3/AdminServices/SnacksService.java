package com.cg.canteen.aug3.AdminServices;

import java.util.List;
import java.util.Optional;

//import javax.swing.plaf.synth.SynthOptionPaneUI;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.canteen.aug3.AdminEntity.Snacks;
import com.cg.canteen.aug3.AdminException.SnacksNotFoundException;
import com.cg.canteen.aug3.AdminRepository.SnacksRepository;

@Service
public class SnacksService {

	@Autowired
	SnacksRepository snacksRepository;

	private static final Logger LOG = LoggerFactory.getLogger(SnacksService.class);

	// Exception_getSnacksById
	public Snacks getSnacksById(int sId) {
		LOG.info("getSnacksById" + sId);
		Optional<Snacks> optSnacks = snacksRepository.findById(sId);
		if (optSnacks.isEmpty()) {
			LOG.error("Snacks not found.");
			throw new SnacksNotFoundException();
		} else
			return optSnacks.get();
	}

	public List<Snacks> getAllSnacks() {

		LOG.info("getAllSnacks ");
		return snacksRepository.findAll();

		// return optSnacks.get();
	}

	public Snacks addSnacks(Snacks snacks) {
		LOG.info("addSnacks");
		try {
			return snacksRepository.save(snacks);
		}catch (IllegalArgumentException iae) {
			LOG.error(iae.getMessage());
            return null; //Change to meaningful message
		}

	}
	
	public Snacks updateSnacks(Snacks snacks) {
		
		LOG.info("updateSnacks");
		return snacksRepository.save(snacks);
	}
	
	public int deleteSnacks(int sId) {
		
		boolean exists=snacksRepository.existsById(sId);
		if(exists) {
			LOG.info("deleteSnacks");
			snacksRepository.deleteById(sId);
		}
		else {
			LOG.error("Snacks not found.");
			throw new SnacksNotFoundException();
		}
		return sId;
	}
	
	public List<Snacks> getSnackWithPrice(double sPrice) {
        LOG.info("getSnacksByPrice " + sPrice);
        List<Snacks> snkList = snacksRepository.findBysPrice(sPrice);
        if (snkList.size() == 0) {
            LOG.error("Snacks not found.");
            throw new SnacksNotFoundException();
        } else
            return snkList;
    }   
	
	public List<Snacks> getSnackWithName(String sName) {
        LOG.info("getSnackWithName" + sName);
        List<Snacks> snkList = snacksRepository.findBysName(sName);
        if (snkList.size() == 0) {
            LOG.error("Snacks not found.");
            throw new SnacksNotFoundException();
        } else
            return snkList;
    } 
	
	public  List<Snacks> getSnackWithPriceLessThan(double sPrice){
		LOG.info("getSnackWithPriceLessThan" + sPrice);
        List<Snacks> snkList = snacksRepository.findBysPriceLessThan(sPrice);
        if (snkList.size() == 0) {
            LOG.error("Snacks not found.");
            throw new SnacksNotFoundException();
        } else
            return snkList;
		
	}
	public  List<Snacks> getSnackWithPriceGreaterThan(double sPrice){
		LOG.info("getSnackWithPriceGreaterThan" + sPrice);
        List<Snacks> snkList = snacksRepository.findBysPriceGreaterThan(sPrice);
        if (snkList.size() == 0) {
            LOG.error("Snacks not found.");
            throw new SnacksNotFoundException();
        } else
            return snkList;
		
	}
}