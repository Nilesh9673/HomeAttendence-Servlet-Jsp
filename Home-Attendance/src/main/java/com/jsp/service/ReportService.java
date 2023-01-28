package com.jsp.service;

import java.time.LocalTime;
import java.util.List;

import com.jsp.dao.ReportDao;
import com.jsp.dto.ReportDetail;

public class ReportService {
	ReportDao reportDao = new ReportDao();

	// save report
	public ReportDetail saveReport(ReportDetail report) {
		return reportDao.saveReport(report);
	}

	// getAll Report
	public List<ReportDetail> getAllReport() {
		return reportDao.getAllReport();
	}

	// get by id
	public ReportDetail getReportById(int id) {
		return reportDao.getReportById(id);
	}

	// update singout time
	public ReportDetail updateSignOut(int id, LocalTime lt) {
		return reportDao.updateSignOut(id, lt);
	}

	// update singin time
	public ReportDetail updateSignIn(int id, LocalTime lt) {
		return reportDao.updateSignIn(id, lt);
	}

}
