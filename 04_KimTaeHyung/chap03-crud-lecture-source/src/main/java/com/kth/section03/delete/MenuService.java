package com.kth.section03.delete;

import java.sql.Connection;

import static com.kth.common.JDBCTemplate.*;

public class MenuService {

  public int removeMenu(int menuCode) {
    Connection con = getConnection();

    MenuRepository menuRepository = new MenuRepository();

    int result = menuRepository.deleteMenu(con, menuCode);

    if(result > 0) commit(con);
    else           rollback(con);

    return result;
  }
}
