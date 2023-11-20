package com.fss.agent.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.fss.agent.constant.QRConstants;
import com.fss.agent.model.QRResponse;
import com.fss.agent.model.QRRequest;
import com.fss.agent.model.TransactionStatusRequest;
import com.fss.agent.model.TransactionStatusResponse;

import jakarta.validation.Valid;

@RestController
public class QRAgentController {
	public static final Logger logger = LoggerFactory.getLogger(QRAgentController.class);

	@Autowired
	private RestTemplate restTemplate;

	@Value("${QR_REQUEST_URL}")
	private String requestURLForQR;

	@Value("${TRANSACTION_STATUS_REQUEST_URL}")
	private String transactionStatusURL;

	/**
	 * @param qrRequest
	 * @return
	 */
	@PostMapping("/generateQR")
	@ResponseBody
	public QRResponse generateQR(@Valid @RequestBody QRRequest qrRequest, BindingResult bindingResult) {

		QRResponse qrResponse = new QRResponse();

		if (bindingResult.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			StringBuffer allErrorDesc = new StringBuffer();
			for (FieldError errorDesc : fieldErrors) {
				allErrorDesc.append(errorDesc.getDefaultMessage() + ", ");
			}
			String finalErrorDesc = allErrorDesc.replace(allErrorDesc.lastIndexOf(", "), allErrorDesc.length(), "")
					.toString();
			qrResponse.setErrorDesc(finalErrorDesc);
			qrResponse.setErrorCode(QRConstants.ERROR_RESP_CODE);
			qrResponse.setAid(qrRequest.getAid());
			qrResponse.setAmt(qrRequest.getAmt());
			qrResponse.setOperationName(QRConstants.OPERATION_NAME_QR_GENERATION);
			qrResponse.setResult("01");
			String timeStamp = DateTimeFormatter.ofPattern(QRConstants.DATE_FORMAT).format(LocalDateTime.now());
			qrResponse.setTimeStamp(timeStamp);
			return qrResponse;
		}

		try {
			logger.debug("QR Generation Request To QR Server");
			qrRequest.setTimeStamp(DateTimeFormatter.ofPattern(QRConstants.DATE_FORMAT).format(LocalDateTime.now()));
			qrResponse = restTemplate.postForObject(requestURLForQR, qrRequest, QRResponse.class);
			logger.debug("QR Generation Response From Qr Server");
		} catch (Exception e) {
			logger.error(e.getMessage());
			qrResponse.setErrorDesc("Exception While Processing QR Generation Request ");
			qrResponse.setErrorCode(QRConstants.ERROR_RESP_CODE);
			qrResponse.setAid(qrRequest.getAid());
			qrResponse.setAmt(qrRequest.getAmt());
			qrResponse.setOperationName(QRConstants.OPERATION_NAME_QR_GENERATION);
			qrResponse.setResult("01");
			String timeStamp = DateTimeFormatter.ofPattern(QRConstants.DATE_FORMAT).format(LocalDateTime.now());
			qrResponse.setTimeStamp(timeStamp);
			return qrResponse;
		}
		return qrResponse;
	}

	/**
	 * @param transactionStatusRequest
	 * @return
	 */
	@PostMapping("/transactionStatus")
	public TransactionStatusResponse getTransactionStatus(
			@Valid @RequestBody TransactionStatusRequest transactionStatusRequest,BindingResult bindingResult) {
		TransactionStatusResponse transactionStatusResponse = new TransactionStatusResponse();
		
		if (bindingResult.hasErrors()) {
			List<FieldError> fieldErrors = bindingResult.getFieldErrors();
			StringBuffer allErrorDesc = new StringBuffer();
			for (FieldError errorDesc : fieldErrors) {
				allErrorDesc.append(errorDesc.getDefaultMessage() + ", ");
			}
			String finalErrorDesc = allErrorDesc.replace(allErrorDesc.lastIndexOf(", "), allErrorDesc.length(), "")
					.toString();
			transactionStatusResponse.setResDesc(finalErrorDesc);
			transactionStatusResponse.setResCode("001");
			transactionStatusResponse.setOrgTxnId(transactionStatusRequest.getOrgTxnId());
			transactionStatusResponse.setOrgTxnRefId(transactionStatusRequest.getOrgTxnRefId());
			transactionStatusResponse.setOperationName(QRConstants.OPERATION_NAME_TRANS_STATUS);
			transactionStatusResponse.setTxnId(transactionStatusRequest.getTxnId());
			String timeStamp = DateTimeFormatter.ofPattern(QRConstants.DATE_FORMAT).format(LocalDateTime.now());
			transactionStatusResponse.setTimeStamp(timeStamp);
			return transactionStatusResponse;
		}
		try {
			logger.debug("Transaction Status Request To QR Server");
			transactionStatusRequest.setTimeStamp(DateTimeFormatter.ofPattern(QRConstants.DATE_FORMAT).format(LocalDateTime.now()));
			transactionStatusResponse = restTemplate.postForObject(transactionStatusURL, transactionStatusRequest,
					TransactionStatusResponse.class);
			logger.debug("Transaction Status Response From QR Server");
		} catch (Exception e) {
			logger.error(e.getMessage());
			transactionStatusResponse.setResDesc("Exception While Processing Transaction Status Request ");
			transactionStatusResponse.setResCode("001");
			transactionStatusResponse.setOrgTxnId(transactionStatusRequest.getOrgTxnId());
			transactionStatusResponse.setOrgTxnRefId(transactionStatusRequest.getOrgTxnRefId());
			transactionStatusResponse.setOperationName(QRConstants.OPERATION_NAME_TRANS_STATUS);
			transactionStatusResponse.setTxnId(transactionStatusRequest.getTxnId());
			String timeStamp = DateTimeFormatter.ofPattern(QRConstants.DATE_FORMAT).format(LocalDateTime.now());
			transactionStatusResponse.setTimeStamp(timeStamp);
			return transactionStatusResponse;
		}
		return transactionStatusResponse;
	}
}
