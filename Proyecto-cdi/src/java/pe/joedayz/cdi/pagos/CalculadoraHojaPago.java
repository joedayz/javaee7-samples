/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.joedayz.cdi.pagos;

import java.util.List;

/**
 *
 * @author josediaz
 */
public interface CalculadoraHojaPago {
    
    
    Hoja calculaHoja(List<Funcionario> funcionarios);
}
