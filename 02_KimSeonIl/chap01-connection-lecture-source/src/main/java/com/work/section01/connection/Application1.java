package com.work.section01.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
//java.collection
//Map<String, String> 장점 입출력이 간단함 프로퍼티즈

public class Application1 {
  public static void main(String[] args) {
    Connection con = null;
    /* Connection
    * - DB 연결 정보를 저장하고
    *   Java application과 DBMS를 연결해주는 객체*/
    // 객체 생성 == 메모리 적재
    try {
      //DriverManager를 이용하여 connection 객체 생성
      con = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306", "swcamp", "swcamp"
      );

      System.out.println("con = " + con);

    } catch (SQLException e) {
      e.printStackTrace();
    }finally {
      try {
        con.close();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
