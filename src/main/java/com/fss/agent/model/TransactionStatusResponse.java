package com.fss.agent.model;

public class TransactionStatusResponse {
	
	private String ResCode;
	private String TxnId;
	private String OrgTxnId;
	private String OrgTxnRefId;
	private String OperationName;
	private String ResDesc;
	private String TimeStamp;
	
	public String getResCode() {
		return ResCode;
	}
	public void setResCode(String resCode) {
		ResCode = resCode;
	}
	public String getTxnId() {
		return TxnId;
	}
	public void setTxnId(String txnId) {
		TxnId = txnId;
	}
	public String getOrgTxnId() {
		return OrgTxnId;
	}
	public void setOrgTxnId(String orgTxnId) {
		OrgTxnId = orgTxnId;
	}
	public String getOrgTxnRefId() {
		return OrgTxnRefId;
	}
	public void setOrgTxnRefId(String orgTxnRefId) {
		OrgTxnRefId = orgTxnRefId;
	}
	public String getOperationName() {
		return OperationName;
	}
	public void setOperationName(String operationName) {
		OperationName = operationName;
	}
	public String getResDesc() {
		return ResDesc;
	}
	public void setResDesc(String resDesc) {
		ResDesc = resDesc;
	}
	public String getTimeStamp() {
		return TimeStamp;
	}
	public void setTimeStamp(String timeStamp) {
		TimeStamp = timeStamp;
	}
	
	@Override
	public String toString() {
		return "TransactionStatusResponse [ResCode=" + ResCode + ", TxnId=" + TxnId + ", OrgTxnId=" + OrgTxnId
				+ ", OrgTxnRefId=" + OrgTxnRefId + ", OperationName=" + OperationName + ", ResDesc=" + ResDesc
				+ ", TimeStamp=" + TimeStamp + "]";
	}
}
