package com.fss.agent.api.stub;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.fss.agent.constant.QRConstants;
import com.fss.agent.model.QRResponse;
import com.fss.agent.model.QRRequest;
import com.fss.agent.model.TransactionStatusRequest;
import com.fss.agent.model.TransactionStatusResponse;

@RestController
public class QRServerTest {
	public static final Logger logger = LoggerFactory.getLogger(QRServerTest.class);
	
	@PostMapping("/QRServerTransactionStatus")
	public TransactionStatusResponse getTransactionStatus(@RequestBody TransactionStatusRequest transactionStatusRequest) {
		logger.debug("Inside QR Server Transaction Status "+transactionStatusRequest);
		TransactionStatusResponse response=new TransactionStatusResponse();
		response.setResCode(QRConstants.SUCCESS_RESP_CODE);
		response.setOperationName(QRConstants.OPERATION_NAME_TRANS_STATUS);
		response.setOrgTxnId(transactionStatusRequest.getOrgTxnId());
		response.setOrgTxnRefId(transactionStatusRequest.getOrgTxnRefId());
		response.setTxnId(transactionStatusRequest.getTxnId());
		response.setResDesc("Approved");
		String timeStamp = DateTimeFormatter.ofPattern(QRConstants.DATE_FORMAT).format(LocalDateTime.now());
		response.setTimeStamp(timeStamp);
		logger.debug("returning respone from QR Server Transaction Status "+response);
		return response;
	}
	
	@PostMapping("/QRServerGenerateQR")
	@ResponseBody
	public Object generateQR(@RequestBody QRRequest request) {
		logger.debug("inside QRServerGenerateQR "+request);
		QRResponse response=new QRResponse();
		response.setAid(request.getAid());
		response.setAmt(request.getAmt());
		String timeStamp = DateTimeFormatter.ofPattern(QRConstants.DATE_FORMAT).format(LocalDateTime.now());
		response.setTimeStamp(timeStamp);
		response.setOperationName("ATMQRCodeResp");
		response.setResult("00");
		response.setQr("upi://pay?pa=CBI@cbin&pn=CBIATMCASHWithdrawl&tr=329317816701&am=1000.00&mode=18&purpose=12&or\r\n"
				+ "gId=159016&mid=401107&tid=CBI6f125ac55d8e473080d059253d381d6b&mc=6013&tn=M04M248003&msid=2931\r\n"
				+ "0231710956&sign=MEUCIQDtiu2NbtXDdfqBErkCrisOx5gmxjdREtrWRBd5qhYu0gIgDdnQYbFM1DjZ7YujDhQ+2gBowC\r\n"
				+ "y+8vmvvXVxv3l9V/k=");
		response.setTid("CBI6f125ac55d8e473080d059253d381d6b");
		response.setTr("329317816701|CBI@cbin");
		response.setRid("150086");
		response.setErrorCode("000");
		response.setErrorDesc("QR code generated successfully");
		logger.debug("returning respone from QR Server "+response);
		return response;
	}
}
