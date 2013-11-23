package pe.joedayz.javaee7.cdi.ejemplo06;


import javax.enterprise.inject.Default;
import java.util.Random;


@Default
public class IsbnGenerador06 implements GeneradorNumero06 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    return "13-84356-" + Math.abs(new Random().nextInt());
  }
}