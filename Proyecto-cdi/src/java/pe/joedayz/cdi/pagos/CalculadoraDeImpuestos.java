/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.cdi.pagos;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

/**
 *
 * @author josediaz
 */
public class CalculadoraDeImpuestos {

    private CalculadoraDeSalarios calculadoraSalarios;

    public CalculadoraDeImpuestos() {
    }

    @Inject
    public CalculadoraDeImpuestos(CalculadoraDeSalarios calculadora) {
        System.out.println("Iniciando Calculadora de impuestos...");
        calculadoraSalarios = calculadora;
    }

    public double calcularImpuestoALaRenta(Funcionario funcionario) {

        
        double salario = calculadoraSalarios.calculaSalario(funcionario);

        //tabla de impuesto a la renta del 2013
        double quota = 0.0;
        double deducible = 0.0;

        //esta parte es por didactica. Disculpen tanto if jajaja
        if (salario <= 1710.78) {
            quota = 0.0;
            deducible = 0.0;
        } else if (salario > 1710.78 && salario <= 2563.91) {
            quota = 7.5 / 100;
            deducible = 128.31;
        } else if (salario > 2563.91 && salario < 3418.59) {
            quota = 15.0 / 100;
            deducible = 320.60;
        } else if (salario > 3418.59 && salario <= 4271.59) {
            quota = 22.5 / 100;
            deducible = 577.0;
        } else if (salario > 4271.59) {
            quota = 27.5 / 100;
            deducible = 790.58;
        }

        double impuestoSinDescuento = salario * quota;

        return impuestoSinDescuento - deducible;
    }
}
