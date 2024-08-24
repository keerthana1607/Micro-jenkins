package com.keerthana.demo.repo;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.keerthana.demo.model.TaxReturn;

public interface TaxReturnRepo {

    

    List<TaxReturn> getPendingTaxReturns();

    List<TaxReturn> getApprovedTaxReturns();

    List<TaxReturn> getRejectedTaxReturns();

    List<TaxReturn> getPaymentTaxReturns();

    List<TaxReturn> getAllTaxReturnDetails();

    TaxReturn findTaxReturnById(int formId);

    List<String> userFindTaxReturns(int userId);

    Object getApprovedCount();

    Object getRejectedCount();

    Object getPendingCount();

    Object getPaymentCount();

    List<TaxReturn> findTaxReturnsByUserId(int userId);

    boolean deleteTaxReturn(int formId);

    boolean updatePayment(int formId);

   

    boolean updateEmailApproved(int formId);

    

	TaxReturn regTaxForm(TaxReturn tax, MultipartFile image)throws IOException;

	boolean updateEmailRejected(int formId);

//	Object findById(int formId);

	

	
}
