package dhan.fuse.examples.cxf_to_amq;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;

//@XmlType(name = "TransactionResponse")
@SuppressWarnings("unused")
@XmlRootElement(name = "TransactionResponseModel")
//@XmlAccessorType(XmlAccessType.FIELD)


public class TransactionResponseModel {

  private String response;

  public String getResponse() {
    return response;
  }

  public void setResponse(String response) {
    this.response = response;
  }
}
