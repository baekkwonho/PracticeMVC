package BoardTest;

public class BoardDao {
  
  Board[] boards = new Board[100];
  int length = 0;
  
  void insert(Board board) {
    this.boards[length++] = board;
  }
  
  Board[] selectList() {
    Board[] dataArray = new Board[this.length];
    for (int i = 0; i < this.length; i++) {
      dataArray[i] = this.boards[i];
    }
    return dataArray;
  }
 
  Board selectOne(int no) {
    if (no >= 0 && no < this.length) {
      return this.boards[no];
    }
    return null;
    
  }
  
  void update(Board board) {
    this.boards[board.no] = board;
  }
  
  
  int delete(int no) {
    if (no >= 0 && no < this.length) {
      for (int i = no; i < this.length; i++) {
        this.boards[i] = this.boards[i + 1];
      }
      this.length--;
      return 1;
    }
    return 0;
  }
  
}
