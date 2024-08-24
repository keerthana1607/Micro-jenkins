package com.keerthana.demo.repoimpl;

import com.keerthana.demo.model.TaxReturn;
import com.keerthana.demo.repo.TaxReturnRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Repository;
import org.springframework.web.multipart.MultipartFile;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;

import java.io.IOException;
import java.util.List;

@Repository
public class TaxReturnRepoImpl implements TaxReturnRepo {

	@Autowired
	private EntityManager entityManager;

	@Autowired
	private JavaMailSender mailSender;

	@SuppressWarnings("unchecked")
	@Override
	public List<TaxReturn> getPendingTaxReturns() {
		return entityManager.createQuery("from TaxReturn t where t.formStatus = 'Pending'").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaxReturn> getApprovedTaxReturns() {
		return entityManager.createQuery("from TaxReturn t where t.formStatus = 'Approved'").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaxReturn> getRejectedTaxReturns() {
		return entityManager.createQuery("from TaxReturn t where t.formStatus = 'Rejected'").getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaxReturn> getPaymentTaxReturns() {
		return entityManager.createQuery("from TaxReturn t where t.formStatus = 'Payment Done'").getResultList();
	}

	@Override
	public TaxReturn findTaxReturnById(int formId) {
		return entityManager.find(TaxReturn.class, formId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<String> userFindTaxReturns(int userId) {
		Query query = entityManager.createQuery("SELECT t.formStatus FROM TaxReturn t WHERE t.user.userId = :userId");
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public Object getApprovedCount() {
		Query query = entityManager.createQuery("select count(*) from TaxReturn t where t.formStatus = 'Approved'");
		return query.getSingleResult();
	}

	@Override
	public Object getRejectedCount() {
		Query query = entityManager.createQuery("select count(*) from TaxReturn t where t.formStatus = 'Rejected'");
		return query.getSingleResult();
	}

	@Override
	public Object getPendingCount() {
		Query query = entityManager.createQuery("select count(*) from TaxReturn t where t.formStatus = 'Pending'");
		return query.getSingleResult();
	}

	@Override
	public Object getPaymentCount() {
		Query query = entityManager.createQuery("select count(*) from TaxReturn t where t.formStatus = 'Payment Done'");
		return query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaxReturn> findTaxReturnsByUserId(int userId) {
		Query query = entityManager.createQuery("FROM TaxReturn t WHERE t.user.userId = :userId");
		query.setParameter("userId", userId);
		return query.getResultList();
	}

	@Override
	public boolean deleteTaxReturn(int formId) {
		Query query = entityManager.createQuery("DELETE FROM TaxReturn t WHERE t.formId = :formId");
		query.setParameter("formId", formId);
		return query.executeUpdate() > 0;
	}

	@Override
	public boolean updatePayment(int formId) {
		Query query = entityManager
				.createQuery("UPDATE TaxReturn t SET t.formStatus = :status WHERE t.formId = :formId");
		query.setParameter("status", "Payment Done");
		query.setParameter("formId", formId);
		return query.executeUpdate() > 0;
	}

	@Override
	public boolean updateEmailApproved(int formId) {
		TaxReturn taxReturn = findTaxReturnById(formId);

		taxReturn.setFormStatus("Approved");

		try {
			if (taxReturn != null) {
				entityManager.persist(taxReturn);

				String userEmail = taxReturn.getUser().getUserEmail();
				String userName = taxReturn.getUser().getUserName();

				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("your-email@example.com");
				message.setTo(userEmail);
				message.setSubject("Tax Return Approved");
				message.setText("Dear " + userName + ",\n\n"
						+ "We are pleased to inform you that your tax return has been approved.\n" 
						+ "Please proceed to pay the tax.\n\n" + "Thank you for your attention.\n\n"
						+ "Best regards,\nYour Company");

				mailSender.send(message);
				return true;
			}

		} catch (Exception e) {
			System.err.println(e);
		}
		return false;
	}

	@Override
	public boolean updateEmailRejected(int formId) {
		TaxReturn taxReturn = findTaxReturnById(formId);
		taxReturn.setFormStatus("Rejected");
		
		try {
			if (taxReturn != null) {
				String userEmail = taxReturn.getUser().getUserEmail();
				String userName = taxReturn.getUser().getUserName();

				SimpleMailMessage message = new SimpleMailMessage();
				message.setFrom("your-email@example.com");
				message.setTo(userEmail);
				message.setSubject("Tax Return Rejected");
				message.setText(
						"Dear " + userName + ",\n\n" + "We regret to inform you that your tax return has been rejected.\n"
								+ "Invalidation of  files \n\n" + "If you have any questions, please contact us.\n\n"
								+ "Best regards,\nYour Company");

				mailSender.send(message);
				return true;
			}
		} catch (MailException e) {
			e.printStackTrace();
		}
		return false;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<TaxReturn> getAllTaxReturnDetails() {
		return entityManager.createQuery("from TaxReturn").getResultList();
	}
	
	

	public TaxReturn regTaxForm(TaxReturn tax, MultipartFile image) throws IOException {
		try {
			entityManager.persist(tax);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}


	
	
}
