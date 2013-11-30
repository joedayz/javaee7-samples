package pe.joedayz.javaee7.cdi;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;

@OchoDigitos
public class IssnGenerator implements GeneradorNumero {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private Logger logger;

  // ======================================
  // =          Business methods          =
  // ======================================

  @Loggable
  public String generateNumber() {
    String issn =  "8-" + Math.abs(new Random().nextInt());
    logger.info("Generated ISBN : " + issn);
    return issn;
  }
}