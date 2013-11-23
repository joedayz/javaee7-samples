package pe.joedayz.javaee7.cdi.ejemplo04;


import java.util.Random;

public class IsbnGenerador04 implements GeneradorNumero04 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generadorNumero() {
    return "13-84356-" + Math.abs(new Random().nextInt());
  }
}