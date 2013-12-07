/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.joedayz.cdi.pagos;

import javax.annotation.Priority;
import javax.enterprise.inject.Alternative;
import javax.interceptor.Interceptor;

/**
 *
 * @author josediaz
 */
@Alternative @Priority(Interceptor.Priority.APPLICATION + 1)
public class CalculadoraDeSalariosPlan2013 implements CalculadoraDeSalarios{

    @Override
    public double calculaSalario(Funcionario funcionario) {
        System.out.println("calcular salario alternativo");
        return 0.0;
    }
    
}
