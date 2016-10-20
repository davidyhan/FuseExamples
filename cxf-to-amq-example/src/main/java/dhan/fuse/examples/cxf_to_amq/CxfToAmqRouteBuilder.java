package dhan.fuse.examples.cxf_to_amq;

import javax.xml.bind.JAXBContext;

import org.apache.camel.Exchange;
import org.apache.camel.LoggingLevel;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.converter.jaxb.JaxbDataFormat;
import org.apache.cxf.message.MessageContentsList;

public class CxfToAmqRouteBuilder extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    JAXBContext jaxbContext = JAXBContext.newInstance(TransactionResponseModel.class);
    JaxbDataFormat transactionDataFormat = new JaxbDataFormat(jaxbContext);

    //@formatter:off
    from("{{cxfEndpoint}}")
      .log(LoggingLevel.INFO, "### CXF Endpoint triggred: ${body}")
      .process(new Processor(){
        @Override
        public void process(Exchange exchange) throws Exception {
          TransactionResponseModel response = new TransactionResponseModel();
          response.setResponse("Success");
          exchange.getIn().setBody(response);
        }
      })
      .wireTap("direct:wiretap");
    //@formatter:on

    //@formatter:off
    from("direct:wiretap")
      .marshal(transactionDataFormat)
      .to("{{amqDestination}}");
    //@formatter:on
  }
}
