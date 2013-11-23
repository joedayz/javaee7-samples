package pe.joedayz.javaee7.cdi.ejemplo07;


import java.util.Random;

@TreceDigitos07
public class IsbnGenerador07 implements GeneradorNumero07 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    return "13-84356-" + Math.abs(new Random().nextInt());
  }
}