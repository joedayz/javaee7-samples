package pe.joedayz.javaee7.cdi.ejemplo34;


import javax.decorator.Decorator;
import javax.decorator.Delegate;
import javax.inject.Inject;

/**
 * @author Antonio Goncalves
 *         APress Book - Beginning Java EE 7 with Glassfish 4
 *         http://www.apress.com/
 *         http://www.antoniogoncalves.org
 *         --
 */
@Decorator
public class DeOchoATreceDigitosDecorator34 implements GeneradorNumero34 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @Delegate
  private GeneradorNumero34 numberGenerator;

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generateNumber() {
    String issn = numberGenerator.generateNumber();
    String isbn = "13-84356" + issn.substring(1);
    return isbn;
  }
}