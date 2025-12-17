package service;

import common.JDBCTemplate;
import repository.CharacterRepository;
import dto.Character;
import java.sql.Connection;

public class CharacterService {

  private CharacterRepository repository = new CharacterRepository();

  public int getDamage(int damage, Character character) {
    Connection conn = null;
    int result;
    try {
      conn = JDBCTemplate.getConnection();

      int nowHp = character.getHp();
      result = nowHp - damage;
      character.setHp(result);
      conn.setAutoCommit(false);
      repository.setHp(conn, character);

      if (result > 0) conn.commit();
      else conn.rollback();
    } catch (Exception e) {
      throw new RuntimeException(e);
    } finally {
      JDBCTemplate.close(conn);
    }
    return result;
  }
}
