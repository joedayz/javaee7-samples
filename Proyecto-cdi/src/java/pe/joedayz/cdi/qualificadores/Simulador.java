package pe.joedayz.cdi.qualificadores;

import static java.lang.annotation.ElementType.*;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.enterprise.util.Nonbinding;


import javax.inject.Qualifier;
import pe.joedayz.cdi.servlets.PlanDeTrabajo;

@Target({TYPE, FIELD, METHOD, PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Qualifier
public @interface Simulador {

    PlanDeTrabajo planDeTrabajo() default PlanDeTrabajo.VERSION_2005;
    boolean planAprobado() default true;
    @Nonbinding boolean enviarNotificacion() default false;
}
