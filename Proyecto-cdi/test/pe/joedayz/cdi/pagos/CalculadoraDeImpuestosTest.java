package pe.joedayz.cdi.pagos;

import org.junit.Assert;
import org.junit.Test;

public class CalculadoraDeImpuestosTest {

    @Test
    public void testCalculoIREnElSegundoCalculoContribucion() {

        Funcionario funcionario = new Funcionario();

        CalculadoraDeSalarios calculadoraSalarios
                = new CalculadoraDeSalariosMock(3000.0);

        CalculadoraDeImpuestos calculadoraImpostos
                = new CalculadoraDeImpuestos(calculadoraSalarios);

        //la calculadora de IR usa otra clase para calcular el salario
        double imposto = calculadoraImpostos.calcularImpuestoALaRenta(funcionario);

        Assert.assertEquals(129.4, imposto, 0.0001);

    }
}
