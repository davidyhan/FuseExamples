package com.elavon.fuse.examples.cxf_to_amq;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace = "http://service.transaction.ws.inbound.elavon.com/",
  name = "transaction", serviceName = "transaction")
public interface TransactionService {

  @WebMethod(operationName = "Transaction")
  @WebResult(name = "TransactionResponse")
  TransactionResponseModel transaction(
    @WebParam(name = "TransactionRequest") TransactionRequestModel transactoinResponse);

}
