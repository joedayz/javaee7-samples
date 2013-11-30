package pe.joedayz.javaee7.cdi.ejemplo34;


import java.util.Random;


public class IssnGenerador34 implements GeneradorNumero34 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generateNumber() {
    return "8-" + Math.abs(new Random().nextInt());
  }
}