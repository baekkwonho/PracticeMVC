package ChartTest;

public class Cart {
  
  int no;
  String productName;
  String description;
  int price;
  int qty;
  int sumPrice;
  
  public Cart() {
    this.no = 1;
  }
  
  public Cart(int qty) {
    this();
    this.qty = qty;
  }

}
