package com.fss.agent.model;

public class QRResponse {
	
		String operationName;
		String result;
		String aid;
		String amt;
		String qr;
		String tid;
		String tr;
		String rid;
		String errorCode;
		String errorDesc;
		String timeStamp;
		
		public String getOperationName() {
			return operationName;
		}
		public void setOperationName(String operationName) {
			this.operationName = operationName;
		}
		public String getResult() {
			return result;
		}
		public void setResult(String result) {
			this.result = result;
		}
		public String getAid() {
			return aid;
		}
		public void setAid(String aid) {
			this.aid = aid;
		}
		public String getAmt() {
			return amt;
		}
		public void setAmt(String amt) {
			this.amt = amt;
		}
		public String getQr() {
			return qr;
		}
		public void setQr(String qr) {
			this.qr = qr;
		}
		public String getTid() {
			return tid;
		}
		public void setTid(String tid) {
			this.tid = tid;
		}
		public String getTr() {
			return tr;
		}
		public void setTr(String tr) {
			this.tr = tr;
		}
		public String getRid() {
			return rid;
		}
		public void setRid(String rid) {
			this.rid = rid;
		}
		public String getErrorCode() {
			return errorCode;
		}
		public void setErrorCode(String errorCode) {
			this.errorCode = errorCode;
		}
		public String getErrorDesc() {
			return errorDesc;
		}
		public void setErrorDesc(String errorDesc) {
			this.errorDesc = errorDesc;
		}
		public String getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}
		@Override
		public String toString() {
			return "QRDataResponse [operationName=" + operationName + ", result=" + result + ", aid=" + aid + ", amt="
					+ amt + ", qr=" + qr + ", tid=" + tid + ", tr=" + tr + ", rid=" + rid + ", errorCode=" + errorCode
					+ ", errorDesc=" + errorDesc + ", timeStamp=" + timeStamp + "]";
		}
}
