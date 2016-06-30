package ChartTest;

public class CartDao {
  
  Cart[] carts = new Cart[100];
  int length = 0;
  
  void print(Cart cart, int productNo) {
    switch (productNo) {
    case 1 :
      cart.no = this.length + 1;
      cart.productName = "컴퓨터";
      cart.description = "컴퓨터 입니다.";
      cart.price = 1_000_000;
      System.out.printf("%d %s %s %d\n", cart.no, cart.productName, 
          cart.description, cart.price);
      break;
    case 2 :
      cart.no = this.length + 1;
      cart.productName = "노트북";
      cart.description = "노트북 입니다.";
      cart.price = 800_000;
      System.out.printf("%d %s %s %d\n", cart.no, cart.productName, 
          cart.description, cart.price);
      break;
    case 3 :
      cart.no = this.length + 1;
      cart.productName = "마우스";
      cart.description = "마우스 입니다.";
      cart.price = 20_000;
      System.out.printf("%d %s %s %d\n", cart.no, cart.productName, 
          cart.description, cart.price);
      break;
    case 4 :
      cart.no = this.length + 1;
      cart.productName = "키보드";
      cart.description = "키보드 입니다.";
      cart.price = 130_000;
      System.out.printf("%d %s %s %d\n", cart.no, cart.productName, 
          cart.description, cart.price);
      break;
    case 5 :
      cart.no = this.length + 1;
      cart.productName = "케이블";
      cart.description = "케이블 입니다.";
      cart.price = 5_000;
      System.out.printf("%d %s %s %d\n", cart.no, cart.productName, 
          cart.description, cart.price);
      break;
    case 6 :
      cart.no = this.length + 1;
      cart.productName = "핸드폰";
      cart.description = "핸드폰 입니다.";
      cart.price = 1_500_000;
      System.out.printf("%d %s %s %d\n", cart.no, cart.productName, 
          cart.description, cart.price);
      break;
    case 7 :
      cart.no = this.length + 1;
      cart.productName = "모니터";
      cart.description = "모니터 입니다.";
      cart.price = 450_000;
      System.out.printf("%d %s %s %d\n", cart.no, cart.productName, 
          cart.description, cart.price);
      break;
      
    }
    
  }
  
  void insert(Cart cart) {
    this.carts[this.length++] = cart;
  }
  
  
  Cart[] printList() {
    Cart[] dataArray = new Cart[this.length];
    for (int i = 0; i < this.length; i++) {
      dataArray[i] = this.carts[i];
    }
    return dataArray;
  }
  
  
  void delete(Cart cart, int productNo, int deleteNo) {
    if ( deleteNo > 0 && deleteNo <= cart.qty) {
      cart.qty -= deleteNo;
      cart.sumPrice = cart.qty * cart.price;
      if (cart.qty == 0) {
        clean(productNo);
      }
    }
  }

  
  Cart selectOne(int productNo) {
    if (productNo < 0 || productNo > this.length) {
      System.out.println("해당 리스트가 없습니다.");
    } else {
      return this.carts[productNo];
    } return null;  
  }
  
  void clean(int productNo) {
    
    for (int i = productNo + 1; i < this.length; i++) {
      this.carts[productNo] = this.carts[productNo + 1];
      this.carts[productNo].no--;
    }
    this.length--;
    
    
  }
  
  
}
