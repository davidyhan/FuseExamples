package com.elavon.fuse.examples.cxf_to_amq;

import java.util.Properties;

import org.apache.camel.Exchange;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.impl.DefaultExchange;
import org.apache.camel.test.junit4.CamelTestSupport;
import org.apache.cxf.message.MessageContentsList;
import org.junit.Test;


public class RouteBuilderTest extends CamelTestSupport {
  private static final String AMQ = "mock:fin";

  @Override
  protected RouteBuilder createRouteBuilder() {
    return new CxfToAmqRouteBuilder();
  }

  @Override
  protected Properties useOverridePropertiesWithPropertiesComponent() {
    Properties properties = new Properties();
    properties.put("cxfEndpoint", "direct:test");
    properties.put("amqDestination", AMQ);
    return properties;
  }

  @Test
  public void test() throws Exception {
    MockEndpoint fin = getMockEndpoint(AMQ);
    fin.setExpectedCount(1);

    Exchange exchange = new DefaultExchange(context);
    MessageContentsList list = new MessageContentsList();
    TransactionRequestModel request = new TransactionRequestModel();
    list.add(request);
    exchange.getIn().setBody(list);

    template.send("direct:test", exchange);

    assertMockEndpointsSatisfied();
  }
}
