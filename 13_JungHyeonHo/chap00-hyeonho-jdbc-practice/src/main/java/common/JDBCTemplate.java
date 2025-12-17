package common;

import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class JDBCTemplate {

  public static Connection getConnection() {
    Properties prop = new Properties();
    Connection conn;
    try {
      prop.load(new FileReader("src/main/java/config/mariadb.properties"));
      conn = DriverManager.getConnection(prop.getProperty("url"), prop.getProperty("username"), prop.getProperty("password"));
    } catch (Exception e) {
      throw new RuntimeException(e);
    }
    return conn;
  }
  public static void close(Connection conn){
    try {
      conn.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public static void close(PreparedStatement pstmt){
    try {
      pstmt.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
  public static void close(ResultSet rset){
    try {
      rset.close();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }
  }
}
