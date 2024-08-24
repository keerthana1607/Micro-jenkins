package com.keerthana.demo.service;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.keerthana.demo.model.TaxReturn;

public interface TaxReturnService {

    

    boolean updateApprovedForm(int formId);

    boolean updateRejectedForm(int formId);

    boolean updatePayment(int formId);

    List<TaxReturn> getPendingforms();

    List<TaxReturn> getApprovedforms();

    List<TaxReturn> getRejectedforms();

    List<TaxReturn> getPaymentforms();

    TaxReturn appfind(int formId);

    List<String> userfindForm(int userId);

    Object getApprovedCount();

    Object getRejectedCount();

    Object getPendingCount();

    Object getPaymentCount();

    List<TaxReturn> findFormbyId(int userId);

    boolean deleteForm(int formId);


    TaxReturn getTaxReturnById(int formId);

	TaxReturn regform(TaxReturn tax, MultipartFile image)throws IOException;

//	TaxReturn findById(int formId);

	
}
