package dhan.fuse.examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Bean {

  private GlobalVariables global;

  private static final Logger LOGGER = LoggerFactory.getLogger(Bean.class);

  public void logGlobal() {
    LOGGER.info("Variable1 = " + global.getVariable1());
    LOGGER.info("Variable2 = " + global.getVariable2());
    LOGGER.info("Variable3 = " + global.getVariable3());
  }

  public GlobalVariables getGlobal() {
    return global;
  }

  public void setGlobal(GlobalVariables global) {
    this.global = global;
  }
}
