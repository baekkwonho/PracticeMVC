package BoardTest;

import java.util.Scanner;

public class MainApp {
  

  public static void main(String[] args) {
    
    Scanner keyScanner = new Scanner(System.in);
    
    BoardController.keyScanner = keyScanner;
    
    BoardController board1 = new BoardController("공지게시판");
    BoardController board2 = new BoardController("개발자게시판");
    BoardController board3 = new BoardController("익명게시판");
    
    label1 :
    while (true) {
      System.out.println("[메뉴]");
      System.out.println("1. 공지게시판");
      System.out.println("2. 개발자게시판");
      System.out.println("3. 익명게시판");
      System.out.println("0. 종료");
      System.out.print("메뉴를 입력 하세요.");
      String menuNo = keyScanner.nextLine();
      switch (menuNo) {
      case "1":
        board1.service();
        break;
      case "2" :
        board2.service();
        break;
      case "3" :
        board3.service();
        break;
      case "0" :
        break label1;
      default :
        System.out.println("없는 메뉴 입니다.");
        break;
      }
    }
    
    
    
    keyScanner.close();
  }

}
