//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        TicTacToe ticTacToe=new TicTacToe();
        ticTacToe.initializeGame(3);
        String result=ticTacToe.startGame();
        if("Game Draw!!".equals(result)){
            System.out.println(result);
        }else {
            System.out.println(result + " WON!! ");
        }
    }
}