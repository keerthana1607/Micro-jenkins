package com.keerthana.demo.serviceimpl;

import com.keerthana.demo.model.TaxReturn;
import com.keerthana.demo.repo.TaxPolicyRepo;
import com.keerthana.demo.repo.TaxReturnRepo;
import com.keerthana.demo.service.TaxReturnService;

import jakarta.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
@Transactional
public class TaxReturnServiceImpl implements TaxReturnService {

	@Autowired
	private TaxReturnRepo taxReturnRepo;
	
	@Autowired
	private TaxPolicyRepo taxPolicyRepo;

	@Override
	public boolean updateApprovedForm(int formId) {
		
		return taxReturnRepo.updateEmailApproved(formId);
	}

	@Override
	public boolean updateRejectedForm(int formId) {
		return taxReturnRepo.updateEmailRejected(formId);
	}

	@Override
	public boolean updatePayment(int formId) {
		return taxReturnRepo.updatePayment(formId);
	}

	@Override
	public List<TaxReturn> getPendingforms() {
		return taxReturnRepo.getPendingTaxReturns();
	}

	@Override
	public List<TaxReturn> getApprovedforms() {
		return taxReturnRepo.getApprovedTaxReturns();
	}

	@Override
	public List<TaxReturn> getRejectedforms() {
		return taxReturnRepo.getRejectedTaxReturns();
	}

	@Override
	public List<TaxReturn> getPaymentforms() {
		return taxReturnRepo.getPaymentTaxReturns();
	}

	@Override
	public TaxReturn appfind(int formId) {
		return taxReturnRepo.findTaxReturnById(formId);
	}

	@Override
	public List<String> userfindForm(int userId) {
		return taxReturnRepo.userFindTaxReturns(userId);
	}

	@Override
	public Object getApprovedCount() {
		return taxReturnRepo.getApprovedCount();
	}

	@Override
	public Object getRejectedCount() {
		return taxReturnRepo.getRejectedCount();
	}

	@Override
	public Object getPendingCount() {
		return taxReturnRepo.getPendingCount();
	}

	@Override
	public Object getPaymentCount() {
		return taxReturnRepo.getPaymentCount();
	}

	@Override
	public List<TaxReturn> findFormbyId(int userId) {
		return taxReturnRepo.findTaxReturnsByUserId(userId);
	}

	@Override
	public boolean deleteForm(int formId) {
		return taxReturnRepo.deleteTaxReturn(formId);
	}

	@Override
	public TaxReturn getTaxReturnById(int formId) {
		return taxReturnRepo.findTaxReturnById(formId);
	}

	public TaxReturn regform(TaxReturn tax, MultipartFile image) throws IOException {
        double taxRate = taxPolicyRepo.getEqualentTaxRate(tax.getTaxableAmount());
        double calculatedTax = tax.getTaxableAmount() * (taxRate / 100);
        tax.setCalculatedTax(calculatedTax);
		return taxReturnRepo.regTaxForm(tax, image);
    }



}
