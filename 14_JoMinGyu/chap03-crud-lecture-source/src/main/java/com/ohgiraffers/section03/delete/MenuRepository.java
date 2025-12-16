package com.ohgiraffers.section03.delete;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;

import static com.ohgiraffers.common.JDBCTemplate.close;

/* Repository(저장소) 계층
 * DBMS를 통해 수행할 CRUD 작업 단위의 메서드를 정의하는 계층
 * */
public class MenuRepository {

  // updateMenu -> removeMenu로 변경
  // Menu modifyMenu 대신 int menuCode를 매개변수로 받음
  public int removeMenu(Connection con, int menuCode){
    int result = 0; // 삭제 결과 : 1 또는 0

    PreparedStatement pstmt = null;
    Properties prop = new Properties(); // XML 읽어오기

    try{

      prop.loadFromXML(new FileInputStream("src/main/java/com/ohgiraffers/mapper/MenuMapper.xml"));

      // updateMenu -> deleteMenu로 변경
      String sql = prop.getProperty("deleteMenu");

      pstmt = con.prepareStatement(sql);

      // DELETE 구문은 보통 WHERE 절에 조건을 하나만 사용 (예: DELETE FROM TBL_MENU WHERE MENU_CODE = ?)
      // 삭제할 메뉴 코드를 설정
      pstmt.setInt(1, menuCode);

      result = pstmt.executeUpdate(); // DELETE 수행

    } catch (Exception e) {
      // throw new RuntimeException(e); // 원본 코드와 동일하게 처리
      e.printStackTrace(); // 예외 추적을 위해 임시로 변경
      throw new RuntimeException(e);
    } finally {
      close(pstmt);
    }

    return result;
  }
}