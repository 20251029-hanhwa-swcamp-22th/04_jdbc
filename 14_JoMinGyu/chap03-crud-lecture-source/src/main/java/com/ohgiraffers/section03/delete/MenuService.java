package com.ohgiraffers.section03.delete;

import java.sql.Connection;

import static com.ohgiraffers.common.JDBCTemplate.*;
import static java.sql.DriverManager.getConnection;

/* Service 계층
 * - 비즈니스 로직(데이터 가공, 트랜잭션 처리, Repository 호출)을 담당하는 계층
 * */
public class MenuService {

  // modifyMenu -> removeMenu로 변경
  public int removeMenu(int menuCode) { // Menu 객체 대신 int menuCode를 매개변수로 받음
    Connection con = getConnection();

    MenuRepository menuRepository = new MenuRepository();

    // repository 메서드를 호출하여 결과(1:성공, 0:실패) 반환받기
    // updateMenu -> removeMenu로 변경
    int result = menuRepository.removeMenu(con, menuCode);

    if(result > 0) commit(con);
    else           rollback(con);

    close(con); // JDBCTemplate에 close(Connection)이 있다면 추가하는 것이 좋습니다.

    return result;
  }

}