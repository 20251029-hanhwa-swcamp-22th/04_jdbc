package repository;

import common.JDBCTemplate;
import dto.Character;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import static common.JDBCTemplate.close;

public class CharacterRepository {
  private PreparedStatement pstmt;
  private ResultSet rset;
  private int result;

  public void setHp(Connection conn, Character character) {
    try {
      pstmt = conn.prepareStatement("update tbl_menu set menu_price = ?");
      pstmt.setInt(1, character.getHp());
      int result = pstmt.executeUpdate();
    } catch (SQLException e) {
      throw new RuntimeException(e);
    }finally{
      close(rset);
      close(pstmt);
    }
  }
}
