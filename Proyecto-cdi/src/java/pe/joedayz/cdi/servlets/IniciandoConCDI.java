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

/**
 *
 * @author josediaz
 */
@WebServlet("/hello-cdi")
public class IniciandoConCDI extends HttpServlet {

    private static final long serialVersionUID = 1L;

    @Inject
    private CalculadoraDeImpuestos calculadoraImpostos;

    public IniciandoConCDI() {
        System.out.println("Instanciando a Servlet...");
    }

    @PostConstruct
    public void ok() {
        System.out.println("Servlet listo.");
    }
    
    	protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		double salarioBase = Double.parseDouble(req.getParameter("salario"));
		
		
		System.out.println("Efectuando un cálculo.");
		
		//a calculadora de IR usa outra classe para calcular o salário
		double impuesto =  3500;//calculadoraImpostos.calculaImpostoDeRenda(funcionario);
		
		res.getOutputStream().print(String.format("Salario base: R$ %.2f\n" +
				"Impuesto adeudado: R$ %.2f", salarioBase, impuesto));
		System.out.println("Fin.");
	}
}
