package com.cg.canteen.aug3.AdminServices;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.canteen.aug3.AdminEntity.CustomerEntity;
import com.cg.canteen.aug3.AdminException.CustomerNotFoundException;
import com.cg.canteen.aug3.AdminRepository.CustomerRepository;


@Service
public class CustomerServices {
	
	@Autowired
	CustomerRepository customerRepository;
	
	private static final Logger LOG = LoggerFactory.getLogger(CustomerServices.class);
	
	public CustomerEntity getCustomerById(int cId) {
		LOG.info("getCustomerById" + cId);
		Optional<CustomerEntity> optCustomer = customerRepository.findById(cId);
		if (optCustomer.isEmpty()) {
			LOG.error("Customer not found.");
			throw new CustomerNotFoundException();
		} else
			//optCustomer.get().getcUsername();
			return optCustomer.get();
	}
	
	public List<CustomerEntity> getAllCustomer(){
		LOG.info("AllCustomer");
		return customerRepository.findAll();
	}
	
	public CustomerEntity addCustomer(CustomerEntity customerEntity) {
			
			LOG.info("addCustomer");
			return customerRepository.save(customerEntity);
			
		}

	public CustomerEntity updateCustomer(CustomerEntity customerEntity) {
        LOG.info("updateCustomer");
        return customerRepository.save(customerEntity);
    }
		
		public int deleteCustomer(int cId) {
			
			LOG.info("Delete Customer");
			boolean exists=customerRepository.existsById(cId);
			if(exists) {
				LOG.info("deleteCustomer");
				customerRepository.deleteById(cId);
			}
			else {
				LOG.error("Customer not found.");
				throw new CustomerNotFoundException();
			}
			return cId;
		}
		
		public List<CustomerEntity> getCustomerWithName(String cName) {
	        LOG.info("getCustomerWithName" + cName);
	        List<CustomerEntity> cList = customerRepository.findBycName(cName);
	        if (cList.size() == 0) {
	            LOG.error("Customer not found.");
	            throw new CustomerNotFoundException();
	        } else
	            return cList;
	    } 
		
		public List<CustomerEntity> getCustomerWithCity(String cCity) {
	        LOG.info("getCustomerWithCity" + cCity);
	        List<CustomerEntity> cList = customerRepository.findBycCity(cCity);
	        if (cList.size() == 0) {
	            LOG.error("Customer not found.");
	            throw new CustomerNotFoundException();
	        } else
	            return cList;
	    }
		
		public List<CustomerEntity> getCustomerWithGender(String cGender) {
	        LOG.info("getCustomerWithGender" + cGender);
	        List<CustomerEntity> cList = customerRepository.findBycGender(cGender);
	        if (cList.size() == 0) {
	            LOG.error("Customer not found.");
	            throw new CustomerNotFoundException();
	        } else
	            return cList;
	    }
		
		public CustomerEntity loginCustomer(String cUsername, String cPassword) {
			CustomerEntity customerEntity;
			
				Optional<CustomerEntity> optCustomer = customerRepository.getBycUsername(cUsername);
				if(optCustomer.get().getcUsername().equals(cUsername) &&  optCustomer.get().getcPassword().equals(cPassword)) 
				{
					
					int cId=optCustomer.get().getcId();
					customerEntity= customerRepository.findById(cId).get();
					LOG.info("Customer login is  successfull");
					return customerEntity;
				}
				else {
					return null;
				}
				
		}
}
