package com.keerthana.demo.controller;

import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import com.keerthana.demo.model.TaxReturn;

import com.keerthana.demo.repo.TaxPolicyRepo;
import com.keerthana.demo.repo.TaxReturnRepo;
import com.keerthana.demo.service.TaxReturnService;
import com.keerthana.demo.service.UserService;

@RestController
@CrossOrigin("*")
@RequestMapping("/taxreturns")
public class TaxReturnController {

	@Autowired
	private TaxReturnService taxReturnService;

	@Autowired
	private TaxPolicyRepo taxPolicyRepo;

	@Autowired
	TaxReturnRepo taxReturndao;

	@Autowired
	private UserService userService;

	// to insert the data
	@PostMapping("/forminsert")
	public TaxReturn insertForm(@RequestParam("formDate") String formDateStr, @RequestParam("age") int age,
			@RequestParam("incomeType") String incomeType, @RequestParam("incomeAmount") double incomeAmount,
			@RequestParam("deductionType") String deductionType,
			@RequestParam("deductionAmount") double deductionAmount,
			@RequestParam("taxableAmount") double taxableAmount, @RequestParam("calculatedTax") Double calculatedTax, 
			@RequestParam("proof") MultipartFile image, @RequestParam("userId") int userId) throws IOException {
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
		LocalDate formDate = LocalDate.parse(formDateStr, formatter);

		// Create tax return object
		TaxReturn tax = new TaxReturn();
		tax.setFormDate(formDate);
		tax.setFormStatus("pending");
		tax.setAge(age);
		tax.setIncomeType(incomeType);
		tax.setIncomeAmount(incomeAmount);
		tax.setDeductionType(deductionType);
		tax.setDeductionAmount(deductionAmount);
		tax.setTaxableAmount(taxableAmount);
		tax.setProof(image.getBytes());
		tax.setUser(userService.userfind(userId)); // Ensure you have this service

		// Calculate tax if not provided
		if (calculatedTax == null) {
			double taxRate = taxPolicyRepo.getEqualentTaxRate(tax.getTaxableAmount());
			calculatedTax = tax.getTaxableAmount() * (taxRate / 100);
		}
		tax.setCalculatedTax(calculatedTax);

		return taxReturnService.regform(tax, image);
	}

	@PutMapping("/updateform/{formId}")
	public boolean updateApprovedForm(@PathVariable("formId") int formId) {
		return taxReturnService.updateApprovedForm(formId);
	}

	@PutMapping("/rejectform/{formId}")
	public boolean updateRejectedForm(@PathVariable("formId") int formId) {
		return taxReturnService.updateRejectedForm(formId);
	}

	@PutMapping("/updatePayment/{formId}")
	public boolean updateform(@PathVariable("formId") int formId) {
		return taxReturnService.updatePayment(formId);
	}

	// to get all the data from the database
	@GetMapping("/getpendingformList")
	public List<TaxReturn> getBookings() {
		return taxReturnService.getPendingforms();
	}

	@GetMapping("/getApprovedformList")
	public List<TaxReturn> getApproveBookings() {
		return taxReturnService.getApprovedforms();
	}

	@GetMapping("/getRejectedformList")
	public List<TaxReturn> getRejectedBookings() {
		return taxReturnService.getRejectedforms();
	}

	@GetMapping("/getPaymentformList")
	public List<TaxReturn> getPaymentBookings() {
		return taxReturnService.getPaymentforms();
	}

	// get by id
	@GetMapping("/GetformId/{formId}")
	public TaxReturn appfind(@PathVariable("formId") int formId) {
		return taxReturnService.appfind(formId);
	}

	@GetMapping("/GetFormStatus/{userId}")
	public List<String> userfindBook(@PathVariable("userId") int userId) {
		return taxReturnService.userfindForm(userId);
	}

	@GetMapping("/getapproveCount")
	public Object getApprovedCount() {
		return taxReturnService.getApprovedCount();
	}

	@GetMapping("/getrejectedCount")
	public Object getRejectedCount() {
		return taxReturnService.getRejectedCount();
	}

	@GetMapping("/getpendingCount")
	public Object getPendingCount() {
		return taxReturnService.getPendingCount();
	}

	@GetMapping("/getpaymentCount")
	public Object getpaymentCount() {
		return taxReturnService.getPaymentCount();
	}

	@GetMapping("/getFormbyUserId/{userId}")
	public List<TaxReturn> findFormbyId(@PathVariable("userId") int userId) {
		return taxReturnService.findFormbyId(userId);
	}

	@DeleteMapping("/deleteForm/{formId}")
	public boolean deleteForm(@PathVariable("formId") int formId) {
		return taxReturnService.deleteForm(formId);

	}

	@PostMapping("/sendmail/{formId}")
	public boolean send(@PathVariable("formId") int formId) {
		return taxReturndao.updateEmailApproved(formId);

	}

	@PostMapping("/sendreject/{formId}")
	public boolean sendReject(@PathVariable("formId") int formId) {
		return taxReturndao.updateEmailRejected(formId);
	}

	// to get all the data from the database
	@GetMapping("/getAllformList")
	public List<TaxReturn> getTaxReturnDetails() {
		return taxReturndao.getAllTaxReturnDetails();
	}
	


}
