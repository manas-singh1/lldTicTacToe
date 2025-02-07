import java.util.ArrayList;
import java.util.List;

public class Board {
    private int size;
    private PlayingPiece[][] board;

    public Board(int size){
        this.size=size;
        this.board=new PlayingPiece[size][size];
    }


    public void printBoard() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (board[i][j] != null) {
                    System.out.print(" " + board[i][j].piece + " ");
                } else {
                    System.out.print("   ");
                }
                if (j < size - 1) {
                    System.out.print("|");
                }
            }
            System.out.println();
            if (i < size - 1) {
                System.out.println("---+---+---");
            }
        }
    }


    public boolean addPiece(int row, int column, PlayingPiece sign) {
        try {
            if (board[row][column] != null) {
                System.out.println("Already used cell!!!");
                return false;
            } else {
                board[row][column] = sign;
                return true;
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        return false;
    }

     public List<Pair<Integer,Integer>> getEmptyBlocks(){
        List<Pair<Integer,Integer>> emptyRowColumn=new ArrayList<>();
        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(board[i][j]==null){
                    emptyRowColumn.add(new Pair<>(i,j));
                }
            }
        }
        return emptyRowColumn;
    }

    public Integer getSize(){
        return size;
    }

    public PlayingPiece[][] getBoard() {
        return board;
    }
}
