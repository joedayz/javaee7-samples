package pe.joedayz.javaee7.cdi.ejemplo36;


import java.util.Random;


public class IssnGenerador36 implements GeneradorNumero36 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generateNumber() {
    return "8-" + Math.abs(new Random().nextInt());
  }
}