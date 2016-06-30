package ChartTest;

import java.util.Scanner;

public class CartController {
  static Scanner keyScanner;
  
  CartDao cartDao = new CartDao();
  
  void add() {
    
    Cart cart = new Cart();
    
    label :
    while (true) {
      System.out.print("상품 번호를 입력 해 주세요. ");
      String str = keyScanner.nextLine();
      char[] chars = str.toCharArray();
      
      for (int i = 0; i < chars.length; i++){
        if ( chars[i] >= 'a' && chars[i] <= 'z') {
          System.out.println("숫자만 입력 가능 합니다.");
          continue label;
        }
      }
      int productNo = Integer.parseInt(str);
      if (productNo > 7 || productNo < 1) {
        System.out.println("해당 메뉴가 없습니다.");
        continue label;
      } else {
          cartDao.print(cart, productNo);
        }
      break;
      }
    
      label1 :
      while (true) {
        System.out.print("수량을 입력 해 주세요. ");
        String str = keyScanner.nextLine().toLowerCase();
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++){
          if ( chars[i] >= 'a' && chars[i] <= 'z') {
            System.out.println("숫자만 입력 가능 합니다.");
            continue label1;
          }
        }
        cart.qty = Integer.parseInt(str);
        break;
       }
    cart.sumPrice = cart.qty * cart.price;
    
    label1 :
    while (true) {
      System.out.print("추가 하시겠습니까?(y/n) ");
      String answer = keyScanner.nextLine().toLowerCase();
      
      if (answer.equals("y")) {
        System.out.println("추가 되었습니다.");
        cartDao.insert(cart);
        break label1;
      } else if (answer.equals("n")) {
        System.out.println("삭제 취소되었습니다.");
        break label1;
      } else {
        System.out.println("잘못 입력 하셨습니다.");
        continue label1;
      }
    }
  }
  
  void cart() {
    
    Cart[] carts = cartDao.printList();
    
    if (carts.length == 0) {
      System.out.println("장바구니가 비어있습니다.");
    } else {
      int totalPrice = 0;
      System.out.println("번호  상품명    단가    수량    총 금액");
      for (int i = 0; i < carts.length; i++) {
        System.out.printf("  %d   %s %8d %4d  %11d\n",carts[i].no, carts[i].productName, carts[i].price, 
            carts[i].qty, carts[i].sumPrice);
        totalPrice += carts[i].sumPrice;
      }
      System.out.println("------------------------------------------");
      System.out.printf("                       total  %9d\n",totalPrice);
    }
    
    while (true) {
      if ( carts.length == 0) {
        break;
      }
      System.out.print("결제 하시겠습니까?(y/N) ");
      String answer = keyScanner.nextLine().toLowerCase();

      if (answer.equals("y")) {
        System.out.println("결제 되었습니다.");
        for (int i = 0; i < carts.length; i++) {
          cartDao.clean(i);
        }
        break;
      } else if(answer.equals("n") || answer.equals("")) {
        System.out.println("결제 취소 되었습니다.");
        break;
      } else {
        System.out.println("잘못 입력 하셨습니다.");
        continue;
      }
    }
  }
  
  void delete() {
    
    System.out.print("번호를 입력 해 주세요. ");
    int productNo = Integer.parseInt(keyScanner.nextLine()) - 1;
    
    Cart cart = cartDao.selectOne(productNo);
    System.out.printf("현재 수량 %d개 있습니다.\n", cart.qty);
    
    System.out.print("삭제할 수량을 입력 해 주세요. ");
    int deleteNo = Integer.parseInt(keyScanner.nextLine());
    
    label1 :
    while (true) {
      System.out.print("삭제 하시겠습니까?(y/n) ");
      String answer = keyScanner.nextLine().toLowerCase();

      if (answer.equals("y")) {
        System.out.println("삭제 되었습니다.");
        cartDao.delete(cart, productNo, deleteNo);
        break label1;
      } else if (answer.equals("n")) {
        System.out.println("삭제 취소 되었습니다.");
        break label1;
      } else {
        System.out.println("잘못 입력 하셨습니다.");
        continue label1;
      }
    }
  }
  

}
