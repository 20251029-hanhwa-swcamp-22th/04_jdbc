package org.ho.section03.delete;

import org.ho.common.JDBCTemplate;

import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.util.Scanner;

import static org.ho.common.JDBCTemplate.*;

public class MenuRepository {
  /**
   * menuCode를 받아 menuCode를 가진 Menu를 삭제하는 메서드
   * @param conn Connection 객체를 받는다
   * @param menuCode 삭제할 메뉴의 메뉴코드
   * @return 0이면 실패, 1이면 성공
   */
  public int removeMenu(Connection conn,int menuCode){
    Properties prop = new Properties();
    PreparedStatement pstmt = null;
    try {
      prop.loadFromXML(new FileInputStream("src/main/java/org/ho/config/jdbc-config.properties"));
      pstmt = conn.prepareStatement(prop.getProperty("deleteMenu"));
      pstmt.setInt(1,menuCode);
      return pstmt.executeUpdate();
    }catch(Exception e){
      throw new RuntimeException(e);
    }finally{
      close(pstmt);
    }
  }
}
