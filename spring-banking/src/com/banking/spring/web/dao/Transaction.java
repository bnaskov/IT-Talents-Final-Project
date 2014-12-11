package com.banking.spring.web.dao;

import java.sql.Date;
import java.sql.Time;

import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Transaction {

	private Date date;
	private Time time;

	@NotBlank
	private String initiatorIban;

	@NotBlank
	private String recipientIban;

	@NotBlank
	@Size(min = 10, max = 100)
	private String reason;

	@NotBlank
	@Min(10)
	private double amount;

	public Transaction() {

	}

	public Transaction(Date date, Time time, String initiatorIban,
			String recipientIban, String reason, double transferAmount) {
		this.date = date;
		this.time = time;
		this.initiatorIban = initiatorIban;
		this.recipientIban = recipientIban;
		this.reason = reason;
		this.amount = transferAmount;
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

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((initiatorIban == null) ? 0 : initiatorIban.hashCode());
		result = prime * result + ((reason == null) ? 0 : reason.hashCode());
		result = prime * result
				+ ((recipientIban == null) ? 0 : recipientIban.hashCode());
		long temp;
		temp = Double.doubleToLongBits(amount);
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
		if (reason == null) {
			if (other.reason != null)
				return false;
		} else if (!reason.equals(other.reason))
			return false;
		if (recipientIban == null) {
			if (other.recipientIban != null)
				return false;
		} else if (!recipientIban.equals(other.recipientIban))
			return false;
		if (Double.doubleToLongBits(amount) != Double
				.doubleToLongBits(other.amount))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Transaction [date=" + date + ", time=" + time
				+ ", initiatorIban=" + initiatorIban + ", recipientIban="
				+ recipientIban + ", reasonForTransfer=" + reason + ", amount="
				+ amount + "]";
	}

}
