package pe.joedayz.javaee7.cdi.ejemplo02;

import java.util.Random;

public class IsbnGenerador02 implements GeneradorNumero02 {

	@Override
	public String generarNumero() {
		return "13-84356-" +
					Math.abs(new Random().nextInt());
	}

}
