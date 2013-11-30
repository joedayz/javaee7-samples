package pe.joedayz.javaee7.cdi;

import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;


@TreceDigitos
public class IsbnGenerator implements GeneradorNumero {

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
    String isbn = "13-84356-" + Math.abs(new Random().nextInt());
    logger.info("Generated ISBN : " + isbn);
    return isbn;
  }
}