package com.mins.section02.template;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/* JDBCTemplate 클래스 내 static 메서드 호출 시 클래스명을 생략할 수 있게 함 */
import static com.mins.section02.template.JDBCTemplate.*;

// properties 파일 내용을 읽어와 DB와 연결할 수 있다
public class Application {

  public static void main(String[] args) {

    Connection con = null;

    try{
      con = getConnection();
      System.out.println("con = " + con);

    }catch (Exception e){
      e.printStackTrace();
    }finally { // try에서 예외가 발생을 하던 안하던 마지막에 무조건 실행 , 중간에 만약 리턴이 되도 실행이 된다 우선순위가 엄청 높은 코드
        close(con);
    }
  }
}
