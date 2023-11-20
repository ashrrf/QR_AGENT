package com.fss.agent.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class TransactionStatusRequest {
		 @NotBlank(message = "Incorrect Channel")
		 @Size(max = 2,message = "Channel Field Length Must be upto 3 didgit")
		 String channel;
		 
		 @NotBlank
		 @Size(max = 35, message = "txnId Length Must be upto 35 digits")
		 String txnId;
		 
		 @NotBlank
		 @Size(max = 35, message = "orgTxnId Length Must be upto 35 digits")
		 String orgTxnId;
		 
		 @NotBlank
		 @Size(max = 35, message = "orgTxnRefId Length Must be upto 35 digits")
		 String orgTxnRefId;
		 
		 @NotBlank
		 String orgTxnStatus;
		 
		 @NotBlank
		 @Size(max = 50, message = "operationName Length Must be upto 50 digits")
		 String operationName;
		 
		 @NotBlank
		 String orgId;
		 
		 String timeStamp;
		 
		 @NotBlank(message = "Terminal ID is Incorrect")
		 @Size(max = 30, message = "Terminal ID Length Must be upto 30 digits")
		 String terminalID;
		 
		 @NotBlank(message = "Amount is Incorrect")
		 @Size(max = 10, message = "Amount Length Must be upto 10 digits")
		 String amount;
		 
		public String getChannel() {
			return channel;
		}
		public void setChannel(String channel) {
			this.channel = channel;
		}
		public String getTxnId() {
			return txnId;
		}
		public void setTxnId(String txnId) {
			this.txnId = txnId;
		}
		public String getOrgTxnId() {
			return orgTxnId;
		}
		public void setOrgTxnId(String orgTxnId) {
			this.orgTxnId = orgTxnId;
		}
		public String getOrgTxnRefId() {
			return orgTxnRefId;
		}
		public void setOrgTxnRefId(String orgTxnRefId) {
			this.orgTxnRefId = orgTxnRefId;
		}
		public String getOrgTxnStatus() {
			return orgTxnStatus;
		}
		public void setOrgTxnStatus(String orgTxnStatus) {
			this.orgTxnStatus = orgTxnStatus;
		}
		public String getOperationName() {
			return operationName;
		}
		public void setOperationName(String operationName) {
			this.operationName = operationName;
		}
	
		public String getOrgId() {
			return orgId;
		}
		public void setOrgId(String orgId) {
			this.orgId = orgId;
		}
		public String getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}
		public String getTerminalID() {
			return terminalID;
		}
		public void setTerminalID(String terminalID) {
			this.terminalID = terminalID;
		}
		public String getAmount() {
			return amount;
		}
		public void setAmount(String amount) {
			this.amount = amount;
		}
		@Override
		public String toString() {
			return "TransactionStatusRequest [channel=" + channel + ", txnId=" + txnId + ", orgTxnId=" + orgTxnId
					+ ", orgTxnRefId=" + orgTxnRefId + ", orgTxnStatus=" + orgTxnStatus + ", operationName="
					+ operationName + ", orgId=" + orgId + ", timeStamp=" + timeStamp + ", terminalID=" + terminalID
					+ ", amount=" + amount + "]";
		}
		
		
}
