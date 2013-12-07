/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.cdi.controllers;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.inject.Named;
import pe.joedayz.cdi.pagos.CalculadoraDeImpuestos;
import pe.joedayz.cdi.pagos.Funcionario;
import pe.joedayz.cdi.pagos.FuncionarioBuilder;

/**
 *
 * @author josediaz
 */
@Named
public class CalculadoraImpuestosBean {

    @Inject
    private CalculadoraDeImpuestos calculadoraDeImpuestos;

    private double salarioBase;
    private double impuesto;

    public CalculadoraImpuestosBean() {
        System.out.println("Instanciando una CalculadoraImpuestosBean...");
    }

    @PostConstruct
    public void ok() {
        System.out.println("CalculadoraImpuestosBean lista");
    }

    public void calcularImpuesto() {


            Funcionario funcionario = new FuncionarioBuilder()
                                            .conSalarioBaseDe(salarioBase)
                                            .build();

            System.out.println("Efectuando el cálculo.");
            
            System.out.println("Salario base: " + salarioBase);

            
            impuesto = calculadoraDeImpuestos.calcularImpuestoALaRenta(
                    funcionario);
            

            System.out.println("valor de impuesto: " + impuesto);
            System.out.println("Fin.");
    }

    public CalculadoraDeImpuestos getCalculadoraDeImpuestos() {
        return calculadoraDeImpuestos;
    }

    public void setCalculadoraDeImpuestos(CalculadoraDeImpuestos calculadoraDeImpuestos) {
        this.calculadoraDeImpuestos = calculadoraDeImpuestos;
    }

    public double getSalarioBase() {
        return salarioBase;
    }

    public void setSalarioBase(double salarioBase) {
        this.salarioBase = salarioBase;
    }

    public double getImpuesto() {
        return impuesto;
    }

    public void setImpuesto(double impuesto) {
        this.impuesto = impuesto;
    }
    
    
}
