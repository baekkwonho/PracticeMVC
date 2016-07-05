package StockTest;

import java.util.Scanner;

public class MainApp {
  
  public static void main(String[] args) {
    
    Scanner keyScanner = new Scanner(System.in);
    
    StockController stockController = new StockController();
    stockController.keyScanner = keyScanner;
    
    MyMoneyController myMoneyController = new MyMoneyController();
    myMoneyController.keyScanner = keyScanner;
    
    label1 :
    while (true) {

      System.out.println("=====================================");
      System.out.println("1. 입금");
      System.out.println("2. 출금");
      System.out.println("3. 총액");
      System.out.println("4. 주식현황");
      System.out.println("5. 종료");
      System.out.println("=====================================");
      System.out.print("메뉴 번호를 입력하세요> ");
      String menuNo = keyScanner.nextLine();

      switch (menuNo) {
      case "1" :
        myMoneyController.deposit();
        break;
      case "2" :
        myMoneyController.withdraw();
        break;
      case "3" :
        myMoneyController.myMoney();
        break;
      case "4" :
        stockController.service();
        break;
      case "5" :
        break label1;
      default : 
        System.out.println("해당 메뉴가 없습니다.");
        continue;

      }
    }

    keyScanner.close();
  }

}
