package dto;

public class Character {
  int hp;
  int mana;
  int name;

  int maxHp;
  int maxMana;

  public Character(int maxMana, int maxHp, int name) {
    this.mana=this.maxMana = maxMana;
    this.hp=this.maxHp = maxHp;
    this.name = name;
  }

  @Override
  public String toString() {
    return "Character{" +
        "hp=" + hp +
        ", mana=" + mana +
        ", name=" + name +
        ", maxHp=" + maxHp +
        ", maxMana=" + maxMana +
        '}';
  }

  public int getHp() {
    return hp;
  }

  public void setHp(int hp) {
    this.hp = hp;
  }

  public int getMana() {
    return mana;
  }

  public void setMana(int mana) {
    this.mana = mana;
  }

  public int getName() {
    return name;
  }

  public void setName(int name) {
    this.name = name;
  }

  public int getMaxHp() {
    return maxHp;
  }

  public void setMaxHp(int maxHp) {
    this.maxHp = maxHp;
  }

  public int getMaxMana() {
    return maxMana;
  }

  public void setMaxMana(int maxMana) {
    this.maxMana = maxMana;
  }
}
