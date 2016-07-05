package BoardTest;

import java.util.Scanner;

public class BoardController {
  
  String boardName;
  static Scanner keyScanner;
  public BoardController() {}
  public BoardController(String Boardname) {
    this.boardName = Boardname;
  }
  
  BoardDao boardDao = new BoardDao();
  
  public void service() {
    
    label1 :
    while (true) {
      System.out.printf("[메뉴] -> %s\n", this.boardName);
      System.out.println("1. List 2. Add 3. Detail 4. Update 5. Delete 0. Menu");
      System.out.print("메뉴를 입력 하세요. ");
      String commend = keyScanner.nextLine();
      switch (commend) {
      case "1" : case "list" :
        this.list();
        break;
      case "2" : case "add" :
        this.add();
        break;
      case "3" : case "detail" :
        this.detail();
        break;
      case "4" : case "update" :
        this.update();
        break;
      case "5" : case "delete" :
        this.delete();
        break;
      case "0" : case "menu":
        break label1;
      default :
        System.out.println("해당 메뉴가 없습니다");
        break;
      }
    }
  }
  
  void list() {
    
    Board[] boards = boardDao.selectList();
    for (int i = 0; i < boards.length; i++) {
      System.out.printf("%d %s %s %s \n", i, boards[i].title,
          boards[i].contents, boards[i].createdDate);
    }
    
  }
  
  void add() {
    Board board = new Board();
    System.out.print("제목? ");
    board.title = keyScanner.nextLine();
    System.out.print("내용? ");
    board.contents = keyScanner.nextLine();
    System.out.print("작성자? ");
    board.writer = keyScanner.nextLine();

    
    while (true) {
      System.out.print("저장 하시겠습니까?(y/n) ");
      String answer = keyScanner.nextLine().toLowerCase();

      if (answer.equals("y") || answer.equals("")) {
        System.out.println("저장 되었습니다.");
        boardDao.insert(board);
        break;
      } else {
        System.out.println("저장 취소 되었습니다.");
        break;
      }
    }
  }
  
  void detail() {
    
    while (true) {

      System.out.print("번호? ");
      int num = Integer.parseInt(keyScanner.nextLine());

      Board board = boardDao.selectOne(num);
      if (board == null) {
        System.out.println("해당 게시물이 없습니다.");
        break;
      }
      
      System.out.printf("게시판 번호: %d\n", board.no);
      System.out.printf("제목: %s\n", board.title);
      System.out.printf("내용: %s\n", board.contents);
      System.out.printf("작성자: %s\n", board.writer);
      System.out.printf("작성일: %s\n", board.createdDate);
      
      break;
    }
    
  }
  
  void update() {
    System.out.print("번호? ");
    int num = Integer.parseInt(keyScanner.nextLine());
    
    Board originBoard = boardDao.selectOne(num);
    if (originBoard == null) {
      System.out.println("해당 게시물이 없습니다.");
    }
    Board newBoard = new Board();
    
    System.out.printf("제목(%s)? ",originBoard.title);
    newBoard.title = keyScanner.nextLine();
    System.out.printf("내용(%s)? ",originBoard.contents);
    newBoard.contents = keyScanner.nextLine();
    
    while (true) {
      System.out.print("변경 하시겠습니까?(y/n) ");
      String answer = keyScanner.nextLine().toLowerCase();

      if (answer.equals("y") || answer.equals("")) {
        originBoard.title = newBoard.title;
        originBoard.contents = newBoard.contents;
        System.out.println("변경 되었습니다.");
        break;
      } else if (answer.equals("n")) {
        System.out.println("변경 취소되었습니다.");
        break;
      } else {
        System.out.println("잘못 입력 하셨습니다.");
        continue;
      }
    }
    
  }
  
  void delete() {
    System.out.print("번호? ");
    int num = Integer.parseInt(keyScanner.nextLine());
    
    label1 :
    while (true) {
      System.out.print("삭제 하시겠습니까?(y/n) ");
      String answer = keyScanner.nextLine().toLowerCase();
      if ( answer.equals("y") || answer.equals("")) {
        int count = boardDao.delete(num);
        if ( count > 0) {
          System.out.println("삭제 되었습니다.");
          break label1;
        } else {
          System.out.println("해당 게시물이 없습니다.");
          break label1;
        }
      }else if (!answer.equals("n")) {
        System.out.println("잘못 입력 하셨습니다.");
        continue label1;
      }else {
        System.out.println("삭제 취소 되었습니다.");
        break;
      }
    }
  }
  
}
