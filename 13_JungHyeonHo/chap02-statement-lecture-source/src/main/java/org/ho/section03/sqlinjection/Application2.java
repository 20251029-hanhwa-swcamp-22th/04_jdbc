package org.ho.section03.sqlinjection;

import java.sql.*;

import static org.ho.common.JDBCTemplate.close;
import static org.ho.common.JDBCTemplate.getConnection;

public class Application2 {
  public static void main(String[] args) {

    Connection conn = null; //1.DB 연결 객체
    PreparedStatement pstmt = null;  //2.SQL 전달 후 수행 결과 받아오는 객체
    ResultSet rset = null;  //3.SELECT 수행 결과를 얻어와 저장하는 객체
    try{
      conn = getConnection();

      // 홑따옴표(')를 처리하는데 내부에 값이 확실히 들어가는지 장담할 수 없다.=>SQL Injection 위험
      String sql = "select * from tbl_menu" +
          " where menu_code = ?" +
          " and menu_name = ?";


      int menuCode = 16;
      String menuName = "' or 1=1 or 1='";

      /* prepareStatement : 쿼리를 운반하고 결과를 반환하는 객체 */
      pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1,menuCode);
      pstmt.setString(2,menuName);

      // executeQuery() : SELECT 수행 후 ResultSet 반환
      /* ResultSet : SELECT 결과를 다루는 객체(1행씩) */
      // PreparedStatement에서는 executeQuery()에 SQL을 넘기지 않는다.
      // SQL은 prepareStatement()에서 이미 전달되었고,
      // 여기서는 바인딩된 값으로 실행만 한다.
      rset = pstmt.executeQuery();

      while(rset.next()) { // 다음 행이 있다면 이동하고 true 반환(반복)


        // 한 행에서 특정 컬럼 값을 자바 자료형에 맞춰 얻어오기
        System.out.printf("menu_code : %d \n",rset.getInt("menu_code"));
        System.out.printf("menu_name : %s \n",rset.getString("menu_name"));
        System.out.printf("menu_price : %d \n",rset.getInt("menu_price"));
        System.out.printf("category_code : %d \n",rset.getInt("category_code"));
        System.out.printf("orderable_status : %s \n",rset.getString("orderable_status"));
        System.out.println("------------------------------------------------------------------");
      }

    }catch(SQLException e){
      throw new RuntimeException(e);
    }finally {
      // 프로그램 안정성을 위해 JDBC 객체를 생성 역순으로 반환
      close(rset);
      close(pstmt);
      close(conn);
    }

  }
}
