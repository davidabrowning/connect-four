public class TestDriver {

    public static void main(String[] args) {

        // Test UserInputRetriever.getIntInput(int min, int max)
//        System.out.println("\nTest 1: Get an integer between 1 and 7:");
//        UserInputRetriever uir1 = new UserInputRetriever();
//        System.out.println("Please enter an integer between 1 and 7:");
//        System.out.println("You entered " + uir1.getIntInput(1, 7));

        // Test GameBoard.toString()
        System.out.println("\nTest 2: Print GameBoards");
        GameBoard gb2 = new GameBoard();
        System.out.println(gb2);

        // Test GameBoard.isGameOver()
        System.out.println("\nTest 3: Check if game is over");
        GameBoard gb3 = new GameBoard();
        System.out.println(gb3);
        System.out.println(gb3.isGameOver());
        gb3.setSlots(0, 1, 'X');
        gb3.setSlots(0, 2, 'X');
        gb3.setSlots(0, 3, 'X');
        gb3.setSlots(0, 4, 'X');
        System.out.println(gb3);
        System.out.println(gb3.isGameOver());

        gb3 = new GameBoard();
        System.out.println(gb3);
        System.out.println(gb3.isGameOver());
        gb3.setSlots(2, 2, 'X');
        gb3.setSlots(3, 2, 'X');
        gb3.setSlots(4, 2, 'X');
        gb3.setSlots(5, 2, 'X');
        System.out.println(gb3);
        System.out.println(gb3.isGameOver());

        gb3 = new GameBoard();
        System.out.println(gb3);
        System.out.println(gb3.isGameOver());
        gb3.setSlots(0, 1, 'X');
        gb3.setSlots(1, 2, 'X');
        gb3.setSlots(2, 3, 'X');
        gb3.setSlots(3, 4, 'X');
        System.out.println(gb3);
        System.out.println(gb3.isGameOver());

        gb3 = new GameBoard();
        System.out.println(gb3);
        System.out.println(gb3.isGameOver());
        gb3.setSlots(4, 3, 'X');
        gb3.setSlots(3, 4, 'X');
        gb3.setSlots(2, 5, 'X');
        gb3.setSlots(1, 6, 'X');
        System.out.println(gb3);
        System.out.println(gb3.isGameOver());


        // Test GameBoard.swapPlayerTurn()
        System.out.println("\nTest 4: Swap player turn");
        GameBoard gb4 = new GameBoard();
        System.out.println("Turn: " + gb4.getActivePlayer());
        gb4.swapActivePlayer();
        System.out.println("Turn: " + gb4.getActivePlayer());
        gb4.swapActivePlayer();
        System.out.println("Turn: " + gb4.getActivePlayer());

        // Test GameBoard.hasOpenSlots(int col)
        System.out.println("\nTest 5: Check if a column 6 has open slots");
        GameBoard gb5 = new GameBoard();
        System.out.println(gb5);
        System.out.println(gb5.hasOpenSlots(6));
        for(int i = 0; i < 6; i++) {
            gb5.setSlots(i, 6, 'X');
        }
        System.out.println(gb5);
        System.out.println(gb5.hasOpenSlots(6));

        // Test GameBoard.placeToken(char player, int col)
        System.out.println("\nTest 6: Play a token");
        GameBoard gb6 = new GameBoard();
        gb6.placeToken(0);
        gb6.placeToken(0);
        gb6.placeToken(1);
        gb6.placeToken(2);
        gb6.placeToken(2);
        gb6.placeToken(2);
        gb6.placeToken(2);
        System.out.println(gb6);

        // Test GameBoard.playTurn()
//        System.out.println("\nTest 7: Play a turn");
//        UserInputRetriever uir7 = new UserInputRetriever();
//        GameBoard gb7 = new GameBoard();
//        for(int i = 0; i < 8; i++) {
//            System.out.println(gb7);
//            gb7.playTurn(uir7);
//        }

        // Test GameBoard.playGame()
        System.out.println("\nTest 8: Play a game");
        UserInputRetriever uir8 = new UserInputRetriever();
        GameBoard gb8 = new GameBoard();
        gb8.playGame(uir8);

    }

}
