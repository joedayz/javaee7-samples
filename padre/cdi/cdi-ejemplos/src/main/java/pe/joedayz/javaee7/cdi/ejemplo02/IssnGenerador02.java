package pe.joedayz.javaee7.cdi.ejemplo02;

import java.util.Random;

public class IssnGenerador02 implements GeneradorNumero02{

	@Override
	public String generarNumero() {
		return "8-" + Math.abs(new Random().nextInt());
	}

}
