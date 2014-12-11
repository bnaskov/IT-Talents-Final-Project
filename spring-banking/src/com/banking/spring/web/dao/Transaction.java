package com.banking.spring.web.dao;

import java.sql.Date;
import java.sql.Time;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

public class Transaction {

	private Date date;
	private Time time;
	private String initiatorIban;
	private String recipientIban;

	@Size(min = 10, max = 100)
	private String reasonForTransfer;

	@Min(10)
	private double transferAmount;

	public Transaction() {

	}

	public Transaction(Date date, Time time, String initiatorIban,
			String recipientIban, String reasonForTransfer,
			double transferAmount) {
		this.date = date;
		this.time = time;
		this.initiatorIban = initiatorIban;
		this.recipientIban = recipientIban;
		this.reasonForTransfer = reasonForTransfer;
		this.transferAmount = transferAmount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public Time getTime() {
		return time;
	}

	public void setTime(Time time) {
		this.time = time;
	}

	public String getInitiatorIban() {
		return initiatorIban;
	}

	public void setInitiatorIban(String initiatorIban) {
		this.initiatorIban = initiatorIban;
	}

	public String getRecipientIban() {
		return recipientIban;
	}

	public void setRecipientIban(String recipientIban) {
		this.recipientIban = recipientIban;
	}

	public String getReasonForTransfer() {
		return reasonForTransfer;
	}

	public void setReasonForTransfer(String reasonForTransfer) {
		this.reasonForTransfer = reasonForTransfer;
	}

	public double getTransferAmount() {
		return transferAmount;
	}

	public void setTransferAmount(double transferAmount) {
		this.transferAmount = transferAmount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((initiatorIban == null) ? 0 : initiatorIban.hashCode());
		result = prime
				* result
				+ ((reasonForTransfer == null) ? 0 : reasonForTransfer
						.hashCode());
		result = prime * result
				+ ((recipientIban == null) ? 0 : recipientIban.hashCode());
		long temp;
		temp = Double.doubleToLongBits(transferAmount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Transaction other = (Transaction) obj;
		if (initiatorIban == null) {
			if (other.initiatorIban != null)
				return false;
		} else if (!initiatorIban.equals(other.initiatorIban))
			return false;
		if (reasonForTransfer == null) {
			if (other.reasonForTransfer != null)
				return false;
		} else if (!reasonForTransfer.equals(other.reasonForTransfer))
			return false;
		if (recipientIban == null) {
			if (other.recipientIban != null)
				return false;
		} else if (!recipientIban.equals(other.recipientIban))
			return false;
		if (Double.doubleToLongBits(transferAmount) != Double
				.doubleToLongBits(other.transferAmount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [date=" + date + ", time=" + time
				+ ", initiatorIban=" + initiatorIban + ", recipientIban="
				+ recipientIban + ", reasonForTransfer=" + reasonForTransfer
				+ ", transferAmount=" + transferAmount + "]";
	}

}
