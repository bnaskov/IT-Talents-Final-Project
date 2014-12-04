package users;

public class Transaction {
	// Timestamp date
	private String initiatorIban;
	private String recipientIban;
	private String reasonForTransfer;
	private double transferAmount;

	Transaction(String initiatorIban, String recipientIban,
			String reasonForTransfer, double transferAmount) {
		setInitiatorIban(initiatorIban);
		setRecipientIban(recipientIban);
		setReasonForTransfer(reasonForTransfer);
		setTransferAmount(transferAmount);
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
}
