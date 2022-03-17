package com.cg.canteen.aug3.AdminController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import org.springframework.web.servlet.ModelAndView;

import com.cg.canteen.aug3.AdminEntity.CustomerEntity;
import com.cg.canteen.aug3.AdminServices.CustomerServices;
import com.lowagie.text.pdf.codec.Base64.InputStream;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;


@RestController
public class CustomerController {
	
		@Autowired
		CustomerServices  customerServices;
		
		private static final Logger LOG = LoggerFactory.getLogger(CustomerController.class);
		
		
		@GetMapping("/getCustomerById/{cId}")
		public ResponseEntity<CustomerEntity> getCustomerById(@PathVariable int cId){
			LOG.info("Get Customer By ID");
			CustomerEntity  customerEntity=customerServices.getCustomerById(cId);
			return new ResponseEntity<CustomerEntity>(customerEntity,HttpStatus.OK);
			
		}
		
		@GetMapping("/getAllCustomer")
	    public List<CustomerEntity> getAllCustomer() {
	        LOG.info("getAllCustomer");
	        return customerServices.getAllCustomer();
	    }
		@PostMapping("/addCustomer")
		public CustomerEntity addCustomer(@RequestBody CustomerEntity  customerEntity ) {
				LOG.info("AddCustomer");
			return customerServices.addCustomer(customerEntity);
		}
		
		@PutMapping("/updateCustomer")
	    public CustomerEntity updateCustomer(@RequestBody CustomerEntity customerEntity) {
	        LOG.info("updateCustomer");
	        return customerServices.updateCustomer(customerEntity);
	    }

	 

	    // http://localhost:8082/deleteEmp/{eid}
	    @DeleteMapping("/deleteCustomer/{cId}")
	    public int deleteCustomer(@PathVariable int cId) {
	        LOG.info("deleteCustomer");
	        return customerServices.deleteCustomer(cId);
	    }
	    
	    @GetMapping("/getCustomerWithName/{cName}")
	    public ResponseEntity<List<CustomerEntity>> getCustomerWithName(@PathVariable String cName) {
	        LOG.info("getCustomerWithName");
	        List<CustomerEntity> cList = customerServices.getCustomerWithName(cName);
	        return new ResponseEntity<>(cList, HttpStatus.OK);
	    }
	    
	    @GetMapping("/getCustomerWithCity/{cCity}")
	    public ResponseEntity<List<CustomerEntity>> getCustomerWithCity(@PathVariable String cCity) {
	        LOG.info("getCustomerWithCity");
	        List<CustomerEntity> cList = customerServices.getCustomerWithCity(cCity);
	        return new ResponseEntity<>(cList, HttpStatus.OK);
	    }
	    
	    @GetMapping("/getCustomerWithGender/{cGender}")
	    public ResponseEntity<List<CustomerEntity>> getCustomerWithGender(@PathVariable String cGender) {
	        LOG.info("getCustomerWithGender");
	        List<CustomerEntity> cList = customerServices.getCustomerWithGender(cGender);
	        return new ResponseEntity<>(cList, HttpStatus.OK);
	    }
	    
	    
	    @PostMapping("/loginCustomer")
		public ResponseEntity<CustomerEntity> adminLogin(@RequestBody CustomerEntity customerEntity) {
	    	LOG.info("Customer_Login");
			CustomerEntity result = customerServices.loginCustomer(customerEntity.getcUsername(), customerEntity.getcPassword());
			ResponseEntity<CustomerEntity> response = new ResponseEntity<>(result, HttpStatus.OK);
			return response;
		}
	
}
