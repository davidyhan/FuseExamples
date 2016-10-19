package com.elavon.fuse.examples.cxf_to_amq;

import org.apache.camel.LoggingLevel;
import org.apache.camel.builder.RouteBuilder;

public class CxfToAmqRouteBuilder extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    //@formatter:off
    from("cxf:bean:transactionEndpoint")
      .log(LoggingLevel.INFO, "### CXF Endpoint triggred: ${body}")
      .to("direct:end");
    //@formatter:on
  }
}
