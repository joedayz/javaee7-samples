package pe.joedayz.javaee7.cdi.ejemplo16;


import javax.inject.Inject;
import java.util.logging.Logger;


@TreceDigitos16
public class IsbnGenerador16 implements GeneradorNumero16 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  Logger log;

  @Inject
  @TreceDigitos16
  private String prefix;

  @Inject
  @TreceDigitos16
  private int editorNumber;

  @Inject
  @Random16
  private double postfix;

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    log.warning("Debug message with @Inject");
    return prefix + editorNumber + postfix;
  }
}