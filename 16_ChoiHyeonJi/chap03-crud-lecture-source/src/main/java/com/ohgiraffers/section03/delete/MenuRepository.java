package com.ohgiraffers.section03.delete;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static com.ohgiraffers.common.JDBCTemplate.close;

public class MenuRepository {

  public int deleteMenu(Connection con, int menuCode) {

    PreparedStatement pstmt = null;
    int result = 0;

    String sql = "DELETE FROM tbl_menu WHERE menu_code = ?";

    try {
      pstmt = con.prepareStatement(sql);
      pstmt.setInt(1, menuCode);

      result = pstmt.executeUpdate();

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      close(pstmt);
    }

    return result;
  }
}
