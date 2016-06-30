package ChartTest;

import java.util.Scanner;

public class MainApp {

  public static void main(String[] args) {
    
    Scanner keyScanner = new Scanner(System.in);
    
    CartController cartController = new CartController();
    cartController.keyScanner = keyScanner;
    
    label1 :
    while (true) {
      System.out.println("------------------------------------------");
      System.out.println("[상품페이지]");
      System.out.println("[1  컴퓨터  1,000,000]");
      System.out.println("[2  노트북    800,000]");
      System.out.println("[3  마우스     20,000]");
      System.out.println("[4  키보드    130,000]");
      System.out.println("[5  케이블      5,000]");
      System.out.println("[6  핸드폰  1,500,000]");
      System.out.println("[7  모니터    450,000]");

      System.out.println("1. Cart 2. Add 3. Delete 0. End");
      System.out.print("메뉴를 입력 하세요. ");
      String menu = keyScanner.nextLine().toLowerCase();
      
      switch (menu) {
        case "1": case "cart" :
          cartController.cart();
          break;
        case "2": case "add" :
          cartController.add();
          break;
        case "3": case "delete":
          cartController.delete();
          break;
        case "0": case "end":
          break label1;
        default :
          System.out.println("해당 메뉴가 없습니다.");
          continue label1;
      }
    }
    
    keyScanner.close();

  }

}
