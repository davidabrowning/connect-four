public class ConnectFourLauncher {

    public static void main(String[] args) {
        UserInputRetriever userInputRetriever = new UserInputRetriever();
        GameBoard gameBoard = new GameBoard();
        gameBoard.playGame(userInputRetriever);
    }

}
