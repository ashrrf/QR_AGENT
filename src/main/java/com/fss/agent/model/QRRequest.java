package com.fss.agent.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class QRRequest {
		
		@NotBlank(message = "Operation Name is Incorrect")
		@Size(max = 30, message = "Operation Name Length Must be upto 30  digits")
		String operationName;
		
		@Size(max = 30, message = "Terminal ID Length Must be upto 30  digits")
		@NotBlank(message = "Terminal ID is Incorrect")
		String aid;
		
		@Size(max = 10, message = "Amount Length Must be upto 10  digits")
		@NotBlank(message = "Amount is Incorrect")
		String amt;
		
		@NotBlank(message = "OEM is Incorrect")
		@Size(max = 10, message = "OEM  Length Must be upto 10  digits")
		String oem;
		
		String timeStamp;
		
		public String getOperationName() {
			return operationName;
		}
		public void setOperationName(String operationName) {
			this.operationName = operationName;
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
		public String getOem() {
			return oem;
		}
		public void setOem(String oem) {
			this.oem = oem;
		}
		public String getTimeStamp() {
			return timeStamp;
		}
		public void setTimeStamp(String timeStamp) {
			this.timeStamp = timeStamp;
		}
		
		@Override
		public String toString() {
			return "QRData [operationName=" + operationName + ", aid=" + aid + ", amt=" + amt + ", oem=" + oem
					+ ", timeStamp=" + timeStamp + "]";
		}
}
