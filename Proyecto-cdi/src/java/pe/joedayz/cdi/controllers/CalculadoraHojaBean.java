/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.cdi.controllers;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.inject.Inject;
import javax.inject.Named;
import pe.joedayz.cdi.pagos.CalculadoraHojaPago;
import pe.joedayz.cdi.pagos.Funcionario;
import pe.joedayz.cdi.pagos.FuncionarioBuilder;
import pe.joedayz.cdi.pagos.Hoja;

/**
 *
 * @author josediaz
 */
@Named
@ConversationScoped
public class CalculadoraHojaBean implements Serializable {

    private Hoja hoja;
    private FuncionarioBuilder builder;
    private List<Funcionario> funcionarios;
    private double salarioFuncionario;

    @Inject
    private Conversation conversation;

    @Inject
    private CalculadoraHojaPago calculadoraHoja;

    @PostConstruct
    public void init() {
        builder = new FuncionarioBuilder();
        funcionarios = new ArrayList<>();
    }

    public void iniciaConversacion() {
        if (conversation.isTransient()) {
            conversation.begin();
        }
    }

    public void terminaConversacion() {
        if (!conversation.isTransient()) {
            conversation.end();
        }
    }

    public void agregarFuncionario() {
        Funcionario funcionario = builder
                .conSalarioBaseDe(salarioFuncionario).build();
        getFuncionarios().add(funcionario);
    }

    public void calcularHoja() {
        hoja = calculadoraHoja.calculaHoja(getFuncionarios());
    }

    public double getSalarioFuncionario() {
        return salarioFuncionario;
    }

    public void setSalarioFuncionario(double salarioFuncionario) {
        this.salarioFuncionario = salarioFuncionario;
    }

    public Hoja getHoja() {
        return hoja;
    }

    public List<Funcionario> getFuncionarios() {
        return funcionarios;
    }
}
