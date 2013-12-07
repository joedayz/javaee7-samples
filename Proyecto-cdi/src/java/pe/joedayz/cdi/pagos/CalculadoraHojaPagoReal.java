/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.joedayz.cdi.pagos;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author josediaz
 */
public class CalculadoraHojaPagoReal implements CalculadoraHojaPago, Serializable{

        @Inject
        private CalculadoraDeSalarios calculadoraDeSalarios;
    
	@Override
	public Hoja calculaHoja(List<Funcionario> funcionarios) {
		double valor = 0.0;
                for (Funcionario funcionario : funcionarios) {
                    valor += calculadoraDeSalarios.calculaSalario(funcionario);
                }
		return new Hoja(new Date(), valor, funcionarios);
	}

    
}
