/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.cdi.pagos;

import java.util.List;
import pe.joedayz.cdi.qualificadores.Simulador;
import static pe.joedayz.cdi.servlets.PlanDeTrabajo.*;

/**
 *
 * @author josediaz
 */
@Simulador(planDeTrabajo = VERSION_2013)
public class SimuladoraCalculoHojaPagoPlan2013 implements CalculadoraHojaPago {

    @Override
    public Hoja calculaHoja(List<Funcionario> funcionarios) {

        System.out.println("Simulacion con el plan 2013");
        return null;
    }

}
