package pe.joedayz.javaee7.cdi;


import javax.enterprise.inject.Alternative;
import javax.inject.Inject;
import java.util.Random;
import java.util.logging.Logger;


@Alternative
@TreceDigitos
public class MockGeneratorTest implements GeneradorNumero {

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
    String mock = "MOCK-" + Math.abs(new Random().nextInt());
    logger.info("Generated Mock : " + mock);
    return mock;
    }
}
