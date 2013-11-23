package pe.joedayz.javaee7.cdi.ejemplo10;


import java.util.Random;


@NumeroDeDigitos10(value = Digitos.THIRTEEN, odd = true)
public class IsbnParGenerador10 implements GeneradorNumero10 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    return "131-84356-" + Math.abs(new Random().nextInt());
  }
}