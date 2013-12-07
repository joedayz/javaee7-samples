/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.cdi.pagos;

import java.util.List;
import pe.joedayz.cdi.qualificadores.Simulador;

/**
 *
 * @author josediaz
 */
@Simulador
public class SimuladoraCalculoHojaPago implements CalculadoraHojaPago {

    @Override
    public Hoja calculaHoja(List<Funcionario> funcionarios) {
        System.out.println("Simulacion de hoja de pago");
        return null;
    }

}
