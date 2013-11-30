package pe.joedayz.javaee7.cdi.ejemplo19;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class JDBCConnectionProducer19 {

  @Produces
  private Connection createConnection() {
    Connection conn = null;
    try {
      Class.forName("org.apache.derby.jdbc.EmbeddedDriver").newInstance();
      conn = DriverManager.getConnection("jdbc:derby:memory:cdiDB;create=true", "APP", "APP");

    } catch (InstantiationException | IllegalAccessException | ClassNotFoundException | SQLException e) {
      e.printStackTrace();
    }
    return conn;
  }

  private void closeConnection(@Disposes Connection conn) throws SQLException {
    conn.close();
  }
}
