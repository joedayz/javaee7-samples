package pe.joedayz.javaee7.cdi.ejemplo07;

import java.util.Random;


@OchoDigitos07
public class IssnGenerador07 implements GeneradorNumero07 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    return "8-" + Math.abs(new Random().nextInt());
  }
}