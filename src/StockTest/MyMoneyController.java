package StockTest;

import java.util.Scanner;

public class MyMoneyController {
  
  static Scanner keyScanner;
  
  void deposit() {
    
    System.out.print("입금할 금액을 적어 주세요.> ");
    int myMoney = Integer.parseInt(keyScanner.nextLine());
    
    while (true) {
      System.out.printf("%d원을 입금 하시겠습니까?(Y/n)\n", myMoney);
      String answer = keyScanner.nextLine().trim().toLowerCase();

      if (answer.equals("y")) {
        System.out.println("입금 되었습니다. ");
        //Stock stock = new Stock(myMoney);
        Stock.myMoney += myMoney;
        break;
      } else if (answer.equals("n")) {
        System.out.println("입금 취소 되었습니다. ");
        break;
      } else {
        System.out.println("잘못 입력 하였습니다. ");
        continue;
      }
    }
  }
  
  void withdraw() {
    System.out.print("출금 할 금액을 입력 해 주세요.> ");
    int withdrawMoney = Integer.parseInt(keyScanner.nextLine());
    
    while (true) {
      System.out.printf("%d원 출급 하시겠습니까?(Y/n) ", withdrawMoney);
      String answer = keyScanner.nextLine().trim().toLowerCase();
      
      if (answer.equals("y")) {
        System.out.println("출급 하였습니다. ");
        
        Stock.myMoney -= withdrawMoney;
        
        break;
      } else if (answer.equals("n")) {
        System.out.println("출급 취소 하였습니다. ");
        break;
      } else {
        System.out.println("잘못 입력 하였습니다. ");
        continue;
      }
    }
  }
  
  void myMoney() {
    
    System.out.printf("예금 잔액 : %d\n", Stock.myMoney);
    System.out.printf("주식 보유액 : %d\n", Stock.totalStockPrice);
    System.out.println("--------------------------------");
    System.out.printf("       총액 : %d\n", Stock.totalStockPrice + Stock.myMoney);
  }


}
