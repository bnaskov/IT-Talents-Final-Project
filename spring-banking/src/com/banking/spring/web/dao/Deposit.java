package com.banking.spring.web.dao;

import java.sql.Date;

public class Deposit extends BankProduct {

	private int duration;
	private double interest;
	private Date startDate;
	private Date endDate;

	public Deposit() {

	}

	public Deposit(int duration, double interest, Date startDate, Date endDate) {
		super();
		this.duration = duration;
		this.interest = interest;
		this.startDate = startDate;
		this.endDate = endDate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public double getInterest() {
		return interest;
	}

	public void setInterest(double interest) {
		this.interest = interest;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	@Override
	public String toString() {
		return "Deposit [iban=" + super.getIban() + ", amount="
				+ super.getAmount() + ", username=" + super.getUsername()
				+ ", duration=" + this.getDuration() + ", interest="
				+ this.getInterest() + ", startDate=" + this.getStartDate()
				+ ", endDate=" + this.getEndDate() + "]";
	}
}
