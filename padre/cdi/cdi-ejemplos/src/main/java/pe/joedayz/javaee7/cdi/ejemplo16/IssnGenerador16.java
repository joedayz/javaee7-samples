package pe.joedayz.javaee7.cdi.ejemplo16;

import javax.inject.Inject;


@OchoDigitos16
public class IssnGenerador16 implements GeneradorNumero16 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  @OchoDigitos16
  private String prefix;

  @Inject
  @Random16
  private double postfix;

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    return prefix + postfix;
  }
}