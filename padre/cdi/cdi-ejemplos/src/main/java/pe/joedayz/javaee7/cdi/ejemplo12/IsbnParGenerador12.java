package pe.joedayz.javaee7.cdi.ejemplo12;


import java.util.Random;


@TreceDigitos12
@Par12
public class IsbnParGenerador12 implements GeneradorNumero12 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    return "131-84356-" + Math.abs(new Random().nextInt());
  }
}