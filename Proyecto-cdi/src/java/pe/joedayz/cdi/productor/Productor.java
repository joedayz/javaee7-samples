/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.joedayz.cdi.productor;

import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pe.joedayz.cdi.pagos.CalculadoraHojaPago;
import pe.joedayz.cdi.pagos.CalculadoraHojaPagoReal;

/**
 *
 * @author josediaz
 */
public class Productor {
    
    //	@Produces
    public CalculadoraHojaPago crearUnaCalculadora(){
		System.out.println("Produtor.crearUnaCalculadora()");
		return new CalculadoraHojaPagoReal();
	}
        
        @Produces
        public Logger crearLogger(InjectionPoint injectionPoint){
            return LoggerFactory.getLogger(injectionPoint.getMember().
                    getDeclaringClass());
        }
}
