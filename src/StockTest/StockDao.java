package StockTest;

public class StockDao {
  
  Stock[] stocks = new Stock[100];
  int length = 0;
  
  void insert(Stock stock) {
    stocks[length++] = stock;
  }

  Stock[] printList() {
    Stock[] dataArray = new Stock[this.length];
    for (int i = 0; i < dataArray.length; i++) {
      dataArray[i] = this.stocks[i];
    }
    return dataArray;
  }
  
  Stock selectOne(int menuNo) {
    for (int i = 0; i < this.stocks.length; i++) {
      if (this.stocks[i].no == menuNo) {
        return this.stocks[i];
      }
    }
    return null;
   /* if (menuNo < 0 || menuNo > this.length) {
      System.out.println("갖고 있는 주식이 아닙니다.");
    } else {
      return this.stocks[menuNo];
    }return null;*/
  }
  
  void delete(Stock stock,int no, int deleteNo) {
    if (stock.qty == deleteNo) {
      for (int i = no; i < this.length; i++) {
        this.stocks[no] = this.stocks[no + 1];
      }
      this.length--;
    } else if (stock.qty > deleteNo) {
      stock.qty -= deleteNo;
      stock.sumprice = stock.qty * stock.stockCost;
    } else {
      System.out.println("갖고 있는 수량보다 많이 입력 하였습니다. ");
    }
  }
  
}
