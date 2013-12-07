/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.cdi.servlets;

import java.io.IOException;
import javax.annotation.PostConstruct;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.joedayz.cdi.pagos.CalculadoraDeImpuestos;
import pe.joedayz.cdi.pagos.Funcionario;
import pe.joedayz.cdi.pagos.FuncionarioBuilder;

/**
 *
 * @author josediaz
 */
@WebServlet("/hola-cdi")
public class IniciandoConCDI extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private CalculadoraDeImpuestos calculadoraImpuestos;

    public IniciandoConCDI() {
        System.out.println("Instanciando a Servlet...");
    }

    @PostConstruct
    public void ok() {
        System.out.println("Servlet listo.");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        double salarioBase = 50000.00;//Double.parseDouble(req.getParameter("salario"));

        Funcionario funcionario = new FuncionarioBuilder().conSalarioBaseDe(salarioBase)
                .build();

        System.out.println("Efectuando el calculo");

        //La calculadora de IR usa otra clase para calcular el salario
        double impuesto
                = calculadoraImpuestos.calcularImpuestoALaRenta(funcionario);

        res.getOutputStream().print(
                String.format("Salario base: R$ %.2f\n"
                        + "Impuesto de: R$ %.2f", salarioBase, impuesto));
        System.out.println("Fin.");

    }
}
