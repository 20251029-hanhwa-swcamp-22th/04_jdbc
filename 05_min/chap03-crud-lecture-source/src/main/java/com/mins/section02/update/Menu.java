package com.mins.section02.update;

// DTO : 클래스간 데이터 이동(계층간 이동)에 사용될 객체
public class Menu {
  private int menuCode;
  private String menuName;
  private int menuPrice;
  private int categoryCode;
  private String orderableStatus;

  public Menu(int menuCode, String menuName, int menuPrice) {
    this.menuCode = menuCode;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
  }

  public String getMenuName() {
    return menuName;
  }

  public int getMenuPrice() {
    return menuPrice;
  }

  public int getCategoryCode() {
    return categoryCode;
  }

  public String getOrderableStatus() {
    return orderableStatus;
  }

  public int getMenuCode() {
    return menuCode;
  }

  @Override
  public String toString() {
    return "Menu{" +
        "menuCode=" + menuCode +
        ", menuName='" + menuName + '\'' +
        ", menuPrice=" + menuPrice +
        ", categoryCode=" + categoryCode +
        ", orderableStatus='" + orderableStatus + '\'' +
        '}';
  }
}
