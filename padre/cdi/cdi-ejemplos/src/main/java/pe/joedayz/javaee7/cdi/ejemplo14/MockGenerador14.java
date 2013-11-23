package pe.joedayz.javaee7.cdi.ejemplo14;

import javax.enterprise.inject.Alternative;

@Alternative
public class MockGenerador14 implements GeneradorNumero14 {

	// ======================================
	// = Business methods =
	// ======================================

	@Override
	public String generarNumero() {
		
		return "MOCK";
	}
}