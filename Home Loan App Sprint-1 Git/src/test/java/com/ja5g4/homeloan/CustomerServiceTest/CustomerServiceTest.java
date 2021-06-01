package com.ja5g4.homeloan.CustomerServiceTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.ja5g4.homeloan.entities.Customer;
import com.ja5g4.homeloan.exception.CustomerNotFoundException;
import com.ja5g4.homeloan.repository.ICustomerRepository;
import com.ja5g4.homeloan.repository.ILoanAgreementRepository;
import com.ja5g4.homeloan.repository.ILoanApplicationRepository;
import com.ja5g4.homeloan.service.ICustomerServiceImpl;

@SpringBootTest
public class CustomerServiceTest {

	ICustomerRepository customerRepo;
	ILoanApplicationRepository applicationRepo;
	ILoanAgreementRepository agreementRepo;
	private static ICustomerServiceImpl customerService;

	@Test
	// @Disabled
	@DisplayName("Test-Save-Customer")
	void testSaveCustomer() {
		Customer customerInput = new Customer();
		customerInput.setUserId(1);
		customerInput.setCustomerName("Gaurav");
		customerInput.setMobileNumber("9876543210");
		customerInput.setEmailId("gaurav0103@gmail.com");
		customerInput.setPassword("Gaurav0103");
		customerInput.setDateOfBirth(LocalDate.parse("2020-01-08"));
		customerInput.setGender("Male");
		customerInput.setNationality("Indian");
		customerInput.setAadharNumber("1231231223");
		customerInput.setPanNumber("123456yuio");

		when(customerRepo.save(customerInput)).thenReturn(customerInput);
		Customer customer_test = customerService.addCustomer(customerInput);
		assertEquals(customerInput, customer_test);

	}

	@Test
	// @Disabled
	@DisplayName("Test-Get All Customer")
	void testGetAllCustomers() {
		List<Customer> customerList = mock(List.class);
		when(customerRepo.findAll()).thenReturn(customerList);
		List<Customer> outputCustomerList = customerService.viewAllCustomers();
		assertEquals(customerList, outputCustomerList);
	}

	@Test
	// @Disabled
	@DisplayName("Test-Get Customer by Id")
	void testViewCustomerById() throws CustomerNotFoundException {

		
		int input = 1;
		Customer customer = mock(Customer.class);
		Optional<Customer> optional_customer = Optional.of(customer);
		when(customerRepo.findById(input)).thenReturn(optional_customer);
		Optional<Customer> customer_test = Optional.of(customerService.viewCustomer(input));
		assertEquals(optional_customer, customer_test);
	}

	@Test
	// @Disabled
	@DisplayName("Test-Delete Customer")
	void testDeleteCustomer() throws CustomerNotFoundException {
		Customer customerInput = new Customer();
		customerInput.setUserId(1);
		customerInput.setCustomerName("Gaurav");
		customerInput.setMobileNumber("9876543210");
		customerInput.setEmailId("gaurav0103@gmail.com");
		customerInput.setPassword("gaurav0103");
		customerInput.setDateOfBirth(LocalDate.parse("2020-01-08"));
		customerInput.setGender("Male");
		customerInput.setNationality("Indian");
		customerInput.setAadharNumber("1231231223");
		customerInput.setPanNumber("123456yuio");

		Customer output = new Customer();
		output.setUserId(1);
		output.setCustomerName("Gaurav");
		output.setMobileNumber("9876543210");
		output.setEmailId("gaurav0103@gmail.com");
		output.setPassword("gaurav0103");
		output.setDateOfBirth(LocalDate.parse("2020-01-08"));
		output.setGender("Male");
		output.setNationality("Indian");
		output.setAadharNumber("1231231223");
		output.setPanNumber("123456yuio");

		try {
			doNothing().when(customerRepo).delete(customerInput);

			customerService.deleteCustomer(1);

			verify(customerRepo).delete(customerInput);
			assertEquals(customerInput, output);

		} catch (CustomerNotFoundException e) {

		}

	}

	@Test
	// @Disabled
	@DisplayName("Test-Update customer")
	void testUpdateCustomer() throws CustomerNotFoundException {

		Customer customerInput = new Customer();
		customerInput.setUserId(1);
		customerInput.setCustomerName("Gaurav");
		customerInput.setMobileNumber("9876543210");
		customerInput.setEmailId("gaurav0103@gmail.com");
		customerInput.setPassword("gaurav0103");
		customerInput.setDateOfBirth(LocalDate.parse("2020-01-08"));
		customerInput.setGender("Male");
		customerInput.setNationality("Indian");
		customerInput.setAadharNumber("1231231223");
		customerInput.setPanNumber("123456yuio");

		
		Optional<Customer> optionalCustomer= Optional.of(customerInput);
		Customer updateCustomer = new Customer();
		updateCustomer.setUserId(1);
		updateCustomer.setCustomerName("Gaurav Shrivastava");
		updateCustomer.setMobileNumber("9876543210");
		updateCustomer.setEmailId("gaurav0103@gmail.com");
		updateCustomer.setPassword("gaurav0103");
		updateCustomer.setDateOfBirth(LocalDate.parse("2020-01-08"));
		updateCustomer.setGender("Male");
		updateCustomer.setNationality("Indian");
		updateCustomer.setAadharNumber("1231231223");
		updateCustomer.setPanNumber("123456yuio");

		when(customerRepo.findById(1)).thenReturn(optionalCustomer);
		when(customerRepo.save(updateCustomer)).thenReturn(updateCustomer);
		Customer customer_test=customerService.updateCustomer(updateCustomer);
		assertEquals(updateCustomer,customer_test);
		
	}
	
	/*
	 * @Test
	 * 
	 * @DisplayName("Test for find by Date") void testFindCustomerByDate() {
	 * LocalDate input = LocalDate.parse("2021-05-05"); Customer customer =
	 * mock(Customer.class); LoanAgreement agreement=mock(LoanAgreement.class);
	 * List<Customer> optional_customer = List.of(customer); List<LoanAgreement>
	 * optional_agreement=List.of();
	 * when(applicationRepo.findById(input)).thenReturn(optional_customer);
	 * Optional<Customer> customer_test =
	 * Optional.of(customerService.viewCustomerList(input));
	 * assertEquals(optional_customer, customer_test); }
	 */

}
