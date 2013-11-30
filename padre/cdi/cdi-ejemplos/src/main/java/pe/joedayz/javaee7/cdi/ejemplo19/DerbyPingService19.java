package pe.joedayz.javaee7.cdi.ejemplo19;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import java.sql.Connection;
import java.sql.SQLException;



@ApplicationScoped
public class DerbyPingService19 {

  // ======================================
  // =             Attributes             =
  // ======================================

  @Inject
  private Connection conn;

  // ======================================
  // =          Business methods          =
  // ======================================

  public void ping() throws SQLException {
    conn.createStatement().executeQuery("SELECT 1 FROM SYSIBM.SYSDUMMY1");
  }
}
