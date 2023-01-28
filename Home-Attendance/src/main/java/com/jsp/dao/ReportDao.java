package com.jsp.dao;

import java.time.LocalTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.jsp.dto.ReportDetail;

public class ReportDao {
	EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("nilesh");
	EntityManager entityManager = entityManagerFactory.createEntityManager();
	EntityTransaction entityTransaction = entityManager.getTransaction();

	// save report
	public ReportDetail saveReport(ReportDetail report) {
		entityTransaction.begin();
		entityManager.persist(report);
		entityTransaction.commit();
		return report;
	}

	// getAll Report
	public List<ReportDetail> getAllReport() {
		String sql = "select r from ReportDetail r";
		Query query = entityManager.createQuery(sql);
		List<ReportDetail> report = query.getResultList();
		return report;
	}

	public ReportDetail getReportById(int id) {
		ReportDetail reportDetail = entityManager.find(ReportDetail.class, id);
		return reportDetail;
	}

	// update singOut time
	public ReportDetail updateSignOut(int id, LocalTime lt) {
		ReportDetail reportDetail = entityManager.find(ReportDetail.class, id);
		reportDetail.setSign_out(lt);
		entityTransaction.begin();
		entityManager.merge(reportDetail);
		entityTransaction.commit();
		return reportDetail;
	}

	// update singin time
	public ReportDetail updateSignIn(int id, LocalTime lt) {
		ReportDetail reportDetail = entityManager.find(ReportDetail.class, id);
		reportDetail.setSign_in(lt);
		entityTransaction.begin();
		entityManager.merge(reportDetail);
		entityTransaction.commit();
		return reportDetail;
	}

}
