package pe.joedayz.javaee7.cdi.ejemplo14;


import java.util.Random;


public class IsbnGenerador14 implements GeneradorNumero14 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    return "13-84356-" + Math.abs(new Random().nextInt());
  }
}