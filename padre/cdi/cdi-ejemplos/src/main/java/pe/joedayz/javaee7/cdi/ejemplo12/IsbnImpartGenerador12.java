package pe.joedayz.javaee7.cdi.ejemplo12;


import java.util.Random;


@TreceDigitos12
@Impar12
public class IsbnImpartGenerador12 implements GeneradorNumero12 {

  // ======================================
  // =          Business methods          =
  // ======================================

  public String generarNumero() {
    return "132-84356-" + Math.abs(new Random().nextInt());
  }
}