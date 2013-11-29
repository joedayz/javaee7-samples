package pe.joedayz.javaee7.cdi.ejemplo16;

import javax.enterprise.inject.Produces;
import java.util.Random;


public class ProductorNumero16 {

  @Produces
  @TreceDigitos16
  private String prefix13digits = "13-";

  @Produces
  @TreceDigitos16
  private int editorNumber = 84356;

  @Produces
  @OchoDigitos16
  private String prefix8digits = "8-";

  @Produces
  @Random16
  public double random() {
    return Math.abs(new Random().nextInt());
  }
}
