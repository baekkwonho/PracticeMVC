package StockTest;

import java.util.Scanner;

public class StockController {
  static Scanner keyScanner;
  StockDao stockDao = new StockDao();
  
  void service() {
    
    label1 :
      while (true) {
        System.out.println("=================================");
        System.out.printf(" 1.         백산   7860\n");
        System.out.printf(" 2.         파루   3910\n");
        System.out.printf(" 3.   바이로메드 141500\n");
        System.out.printf(" 4.   뉴프라이드   7570\n");
        System.out.printf(" 5.   선데이토즈  30000\n");
        System.out.printf(" 6.   세우글로벌   2100\n");
        System.out.printf(" 7. 아시아나항공   4370\n");
        System.out.printf(" 8.     대한항공  25950\n");
        System.out.printf(" 9.         SG&G   3610\n");
        System.out.printf("10.   삼성중공업   9160\n");

        System.out.println("1. 구매 2. 판매 3. 보유현황 4. 메인메뉴");
        String menuNo = keyScanner.nextLine();

        switch (menuNo) {
        case "1" :
          add();
          break;
        case "2" :
          delete();
          break;
        case "3" :
          list();
          break;
        case "4" :
          break label1;
        default :
          System.out.println("해당 메뉴가 없습니다.");
          continue;
        }
      }
  }
  
  void add() {
    
    Stock stock = new Stock();
  
    
    System.out.print("구매할 주식을 선택 해주세요.> ");
    String answer = keyScanner.nextLine();
    
    switch (answer) {
      case "1" :
        stock.no = 1;
        stock.productName = "        백산";
        stock.stockCost = 7860;
        break;
      case "2" :
        stock.no = 2;
        stock.productName = "        파루";
        stock.stockCost = 3910;
        break;
      case "3" :
        stock.no = 3;
        stock.productName = "  바이로메드";
        stock.stockCost = 141500;
        break;
      case "4" :
        stock.no = 4;
        stock.productName = "  뉴프라이드";
        stock.stockCost = 7570;
        break;
      case "5" :
        stock.no = 5;
        stock.productName = "  선데이토즈";
        stock.stockCost = 30000;
        break;
      case "6" :
        stock.no = 6;
        stock.productName = "  세우글로벌";
        stock.stockCost = 2100;
        break;
      case "7" :
        stock.no = 7;
        stock.productName = "아시아나항공";
        stock.stockCost = 4370;
        break;
      case "8" :
        stock.no = 8;
        stock.productName = "    대한항공";
        stock.stockCost = 25950;
        break;
      case "9" :
        stock.no = 9;
        stock.productName = "       SG&G";
        stock.stockCost = 3610;
        break;
      case "10" :
        stock.no = 10;
        stock.productName = "    삼성중공";
        stock.stockCost = 9160;
        break;
        
    }
    
    while (true) {
      System.out.printf("%d. %s 입력 하셨습니다.\n",stock.no, stock.productName);
      System.out.print("수량을 입력 해 주세요.> ");
      stock.qty = Integer.parseInt(keyScanner.nextLine());
      stock.sumprice = stock.qty * stock.stockCost;

      if (Stock.myMoney < stock.sumprice) {
        System.out.printf("현재 잔액 %d 보다 많이구매 하실 수 없습니다.\n",  Stock.myMoney);
        continue;
      } else {
        Stock.totalStockPrice += stock.sumprice;
        Stock.myMoney -= stock.sumprice;

        System.out.print("구매 하시겠습니까?(Y/n) ");
        String commend = keyScanner.nextLine().trim().toLowerCase();
        if (commend.equals("y")) {
          System.out.println("구매 완료 하였습니다.");
          stockDao.insert(stock);
        } else if (commend.equals("n")) {
          System.out.println("구매 취소 하였습니다.");
        } else {
          System.out.println("다시 입력 해 주세요.");
        }
        break;
      }
    }
  }
  
  
  void list() {
    Stock[] stocks = stockDao.printList();
    System.out.println("         Name       qty     Cost    total");
    for (int i = 0; i < stocks.length; i++) {
      System.out.printf("%d.  %s     %d    %d    %d\n", stocks[i].no, stocks[i].productName, 
          stocks[i].qty, stocks[i].stockCost, stocks[i].sumprice);
    }
  }
  
  void delete() {
    System.out.print("판매할 주식을 선택 해 주세요.> ");
    int menuNo = Integer.parseInt(keyScanner.nextLine());
    
    Stock stock = stockDao.selectOne(menuNo);
    System.out.printf("%d. %s 입력 하셨습니다.\n",stock.no, stock.productName);
    System.out.printf("현재 보유: %d\n", stock.qty);
    System.out.print("판매할 수량을 입력 해 주세요.> ");
    int deleteNo = Integer.parseInt(keyScanner.nextLine());
    
    Stock.myMoney += stock.sumprice;
    Stock.totalStockPrice -= stock.sumprice;
    
    stockDao.delete(stock, stock.no, deleteNo);
    
    
    
    
  }
  
  
}
