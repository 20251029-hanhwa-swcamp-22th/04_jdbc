package com.ohgiraffers.section02.update;

// DTO : 클래스간 데이터 이동(계층간 이동)에 사용될 객체
public class Menu {
   private int menuCode;
   private String menuName;
   private int categoryCode;
   private int menuPrice;
   private String orderableStatus;

  public Menu(int menuCode, String menuName, int menuPrice) {
    this.menuCode = menuCode;
    this.menuName = menuName;
    this.menuPrice = menuPrice;
  }

  public int getMenuCode() {
    return menuCode;
  }

  public void setMenuCode(int menuCode) {
    this.menuCode = menuCode;
  }

  public String getMenuName() {
    return menuName;
  }

  public void setMenuName(String menuName) {
    this.menuName = menuName;
  }

  public int getCategoryCode() {
    return categoryCode;
  }

  public void setCategoryCode(int categoryCode) {
    this.categoryCode = categoryCode;
  }

  public int getMenuPrice() {
    return menuPrice;
  }

  public void setMenuPrice(int menuPrice) {
    this.menuPrice = menuPrice;
  }

  public String getOrderableStatus() {
    return orderableStatus;
  }

  public void setOrderableStatus(String orderableStatus) {
    this.orderableStatus = orderableStatus;
  }

  @Override
  public String toString() {
    return "Menu{" +
        "menuCode=" + menuCode +
        ", menuName='" + menuName + '\'' +
        ", categoryCode=" + categoryCode +
        ", menuPrice=" + menuPrice +
        ", orderableStatus='" + orderableStatus + '\'' +
        '}';
  }
}
