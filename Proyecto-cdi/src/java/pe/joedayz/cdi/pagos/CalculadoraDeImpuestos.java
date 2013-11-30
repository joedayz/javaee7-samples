/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.joedayz.cdi.pagos;

import javax.annotation.PostConstruct;

/**
 *
 * @author josediaz
 */
public class CalculadoraDeImpuestos {
 
    	@PostConstruct
	public void init(){
		System.out.println("Calculadora de impuestos listo!");
	}
}
