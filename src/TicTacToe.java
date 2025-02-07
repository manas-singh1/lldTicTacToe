import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TicTacToe {

    public Deque<Player> bothPlayers;
    public Board gameBoard;

    public void initializeGame(int size){

        this.bothPlayers = new LinkedList<>();

        PlayingPieceX kattum = new PlayingPieceX();
        System.out.println("Pls Enter First Player Name:");
        Scanner scanner = new Scanner(System.in);
        String firstPlayer = scanner.nextLine();
        Player player1 = new Player(firstPlayer, kattum);

        System.out.println("Pls Enter Second Player Name:");
        String secondPlayer = scanner.nextLine();
        PlayingPieceO kutta = new PlayingPieceO();
        Player player2 = new Player(secondPlayer, kutta);

        bothPlayers.add(player1);
        bothPlayers.add(player2);
        gameBoard = new Board(size);
    }

    public String startGame(){

        boolean noWinner = true;
        while(noWinner){

            Player playerTurn = bothPlayers.removeFirst();

            gameBoard.printBoard();
            List<Pair<Integer, Integer>> freeSpaces =  gameBoard.getEmptyBlocks();
            if(freeSpaces.isEmpty()) {
                noWinner = false;
                continue;
            }

            System.out.print("Player:" + playerTurn.getName() + " Enter Row, Column (eg-2,2): ");
            Scanner scanner = new Scanner(System.in);
            String s = scanner.nextLine();
            String[] values = s.split(",");
            int row = Integer.valueOf(values[0]);
            int column = Integer.valueOf(values[1]);

            boolean pieceAddedSuccessfully = gameBoard.addPiece(row,column, playerTurn.getPlayingPiece());
            if(!pieceAddedSuccessfully) {
                bothPlayers.addFirst(playerTurn);
                continue;
            }
            bothPlayers.addLast(playerTurn);

            boolean winner = isThereWinner(row, column, playerTurn.getPlayingPiece());
            if(winner) {
                gameBoard.printBoard();
                return playerTurn.getName();
            }
        }

        return "Game Draw!!";
    }

    public boolean isThereWinner(int r, int c, PlayingPiece pieceType) {

        boolean row = true;
        boolean column = true;
        boolean diagonal = true;
        boolean antiDiagonal = true;

        for(int i=0;i<gameBoard.getSize();i++) {

            if(gameBoard.getBoard()[r][i] == null || gameBoard.getBoard()[r][i] != pieceType) {
                row = false;
            }
        }

        for(int i=0;i<gameBoard.getSize();i++) {

            if(gameBoard.getBoard()[i][c] == null || gameBoard.getBoard()[i][c] != pieceType) {
                column = false;
            }
        }

        for(int i=0, j=0; i<gameBoard.getSize();i++,j++) {
            if (gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j] != pieceType) {
                diagonal = false;
            }
        }

        for(int i=0, j=gameBoard.getSize()-1; i<gameBoard.getSize();i++,j--) {
            if (gameBoard.getBoard()[i][j] == null || gameBoard.getBoard()[i][j] != pieceType) {
                antiDiagonal = false;
            }
        }

        return row || column || diagonal || antiDiagonal;
    }


}
