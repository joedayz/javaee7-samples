package pe.joedayz.javaee7.cdi.ejemplo12;

import java.util.Random;


@OchoDigitos12
@Par12
public class IssnGenerador12 implements GeneradorNumero12 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    return "8-" + Math.abs(new Random().nextInt());
  }
}