/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.joedayz.cdi.servlets;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.enterprise.inject.Any;
import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import pe.joedayz.cdi.pagos.CalculadoraHojaPago;
import pe.joedayz.cdi.pagos.Funcionario;
import pe.joedayz.cdi.pagos.FuncionarioBuilder;
import pe.joedayz.cdi.pagos.Hoja;
import pe.joedayz.cdi.qualificadores.Simulador;
import static pe.joedayz.cdi.servlets.PlanDeTrabajo.VERSION_2013;

/**
 *
 * @author josediaz
 */
@WebServlet("/calcular-hoja")
public class CalcularHojaPago extends HttpServlet {

    private static final long serialVersionUID = -1101326761035072120L;

    @Inject @Simulador(planDeTrabajo = VERSION_2013)
    private CalculadoraHojaPago calculadoraHoja;

    public CalcularHojaPago() {
        System.out.println("Instanciando el Servlet"
                + " CalcularHojaPago...");
    }

    @PostConstruct
    public void ok() {
        System.out.println("CalcularHojaPago listo.");
    }

    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {

        FuncionarioBuilder builder = new FuncionarioBuilder();

        Funcionario f1 = builder.conSalarioBaseDe(1000.0).build();
        Funcionario f2 = builder.conSalarioBaseDe(2000.0).build();
        Funcionario f3 = builder.conSalarioBaseDe(3000.0).build();

        List<Funcionario> funcionarios = Arrays.asList(f1, f2, f3);

        System.out.println("Efectuando el cálculo...");

        Hoja hoja = calculadoraHoja.calculaHoja(funcionarios);

        //mensaje para el usuário
        res.getOutputStream().print("Calculo de hoja ejecutado con exito");

        //salida en consola
        System.out.println("Fin.");
    }

}
