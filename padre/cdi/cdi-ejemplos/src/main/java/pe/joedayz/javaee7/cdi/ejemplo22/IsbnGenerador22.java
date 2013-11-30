package pe.joedayz.javaee7.cdi.ejemplo22;


import java.util.Random;

@TreceDigitos22
public class IsbnGenerador22 implements GeneradorNumero22 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    return "13-84356-" + Math.abs(new Random().nextInt());
  }
}