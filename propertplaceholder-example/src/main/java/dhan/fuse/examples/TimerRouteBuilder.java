package dhan.fuse.examples;

import org.apache.camel.builder.RouteBuilder;

public class TimerRouteBuilder extends RouteBuilder {

  @Override
  public void configure() throws Exception {
    //@formatter:off
    from("timer://foobar?fixedRate=true&period=5000")
      .beanRef("Bean", "logGlobal");
    //@formatter:on

  }
}
