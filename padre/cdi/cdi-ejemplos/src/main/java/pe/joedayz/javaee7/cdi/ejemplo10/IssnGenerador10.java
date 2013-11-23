package pe.joedayz.javaee7.cdi.ejemplo10;

import java.util.Random;


@NumeroDeDigitos10(value = Digitos.EIGHT, odd = true)
public class IssnGenerador10 implements GeneradorNumero10 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    return "8-" + Math.abs(new Random().nextInt());
  }
}