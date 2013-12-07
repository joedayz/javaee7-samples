/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package pe.joedayz.cdi.servlets;

import java.io.IOException;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.joedayz.cdi.pagos.CalculadoraDeSalarios;

/**
 *
 * @author josediaz
 */
@WebServlet("/calcular-salario")
public class CalculadoraSalario extends HttpServlet{
    
    @Inject
    private CalculadoraDeSalarios calculadoraDeSalarios;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
        res.getOutputStream().print("Calculadora: " + 
                calculadoraDeSalarios.getClass());
    }

}
