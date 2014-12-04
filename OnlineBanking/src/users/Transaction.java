package users;

public class Transaction 
{
	private String transactionDate;
	private String initiatorIban;
	private String recipientIban;
	private String reasonForTransfer;
	private double transferAmount;
	
	Transaction(String transactionDate, String initiatorIban, String recipientIban, String reasonForTransfer,	
			double transferAmount)
		{
			setTransactionDate(transactionDate);
			setInitiatorIban(initiatorIban);
			setRecipientIban(recipientIban);
			setReasonForTransfer(reasonForTransfer);
			setTransferAmount(transferAmount);
		}

	public String getTransactionDate() {	return transactionDate;	}

	public void setTransactionDate(String transactionDate) {	this.transactionDate = transactionDate;	}

	public String getInitiatorIban() {	return initiatorIban;	}

	public void setInitiatorIban(String initiatorIban) {	this.initiatorIban = initiatorIban;	}

	public String getRecipientIban() {	return recipientIban;	}

	public void setRecipientIban(String recipientIban) {	this.recipientIban = recipientIban;	}

	public String getReasonForTransfer() {	return reasonForTransfer;	}

	public void setReasonForTransfer(String reasonForTransfer) {	this.reasonForTransfer = reasonForTransfer;	}

	public double getTransferAmount() {	return transferAmount;	}

	public void setTransferAmount(double transferAmount) {	this.transferAmount = transferAmount;	}
	
}
