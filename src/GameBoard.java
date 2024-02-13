public class GameBoard {

    private char[][] slots;
    private char activePlayer;
    String winner;

    public GameBoard() {
        slots = new char[6][7];
        activePlayer = 'O';
        winner = "no one";

        for(int row = 0; row < 6; row++) {
            for(int col = 0; col < 7; col++) {
                slots[row][col] = ' ';
            }
        }

    }

    public String toString() {
        String output = "";

        for(int i = 0; i < 50; i++) {
            output += "\n";
        }

        // Output the column labels
//        for(int i = 0; i < 7; i++) {
//            output += " " + (i+1) + " ";
//        }

        output += "\n";
        for(int i = 0; i < 7; i++) {
            output += "---";
        }

        // Output the slots' values
        for(int row = 5; row >= 0; row--) {
            output += "\n";
            for(int col = 0; col < 7; col++) {
                output += " " + slots[row][col] + " ";
            }
        }

        output += "\n";
        for(int i = 0; i < 7; i++) {
            output += "---";
        }

        // Output the column labels
        output += "\n";
        for(int i = 0; i < 7; i++) {
            output += " " + (i+1) + " ";
        }

        return output;
    }

    public char[][] getSlots() { return slots; }
    public char getActivePlayer() { return activePlayer; }
    public void setSlots(int row, int col, char value) { slots[row][col] = value; }
    public void swapActivePlayer() {
        if(activePlayer == 'X') {
            activePlayer = 'O';
        } else {
            activePlayer = 'X';
        }
    }

    public boolean isGameOver() {
        boolean gameOverFlag = false;

        // Check if all columns are full
        boolean foundAnOpenSlot = false;
        for(int col = 0; col < 7; col++) {
            if(hasOpenSlots(col)) {
                foundAnOpenSlot = true;
            }
        }
        if(!foundAnOpenSlot) {
            winner = "draw";
            gameOverFlag = true;
        }

        // Check for horizontal wins
        for(int row = 0; row < 6; row++) {
            for(int col = 0; col < 4; col++) {
                if(slots[row][col] != ' '
                        && slots[row][col] == slots[row][col+1]
                        && slots[row][col] == slots[row][col+2]
                        && slots[row][col] == slots[row][col+3]
                ) {
                    winner = "Player " + activePlayer;
                    gameOverFlag = true;
                }
            }
        }

        // Check for vertical wins
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 7; col++) {
                if(slots[row][col] != ' '
                        && slots[row][col] == slots[row+1][col]
                        && slots[row][col] == slots[row+2][col]
                        && slots[row][col] == slots[row+3][col]
                ) {
                    winner = "Player " + activePlayer;
                    gameOverFlag = true;
                }
            }
        }

        // Check for diagonal upward wins
        for(int row = 0; row < 3; row++) {
            for(int col = 0; col < 4; col++) {
                if(slots[row][col] != ' '
                        && slots[row][col] == slots[row+1][col+1]
                        && slots[row][col] == slots[row+2][col+2]
                        && slots[row][col] == slots[row+3][col+3]
                ) {
                    winner = "Player " + activePlayer;
                    gameOverFlag = true;
                }
            }
        }

        // Check for diagonal downward wins
        for(int row = 3; row < 6; row++) {
            for(int col = 0; col < 4; col++) {
                if(slots[row][col] != ' '
                        && slots[row][col] == slots[row-1][col+1]
                        && slots[row][col] == slots[row-2][col+2]
                        && slots[row][col] == slots[row-3][col+3]
                ) {
                    winner = "Player " + activePlayer;
                    gameOverFlag = true;
                }
            }
        }

        return gameOverFlag;
    }

    public boolean hasOpenSlots(int col) {

        // If row 5 for this col is open, return true
        if(slots[5][col] == ' ') {
            return true;
        } else {
            return false;
        }
    }

    public void placeToken(int col) {
        boolean tokenPlaced = false;
        int row = 0;
        while(!tokenPlaced) {
            if(slots[row][col] == ' ') {
                slots[row][col] = activePlayer;
                tokenPlaced = true;
            }
            row++;
        }
    }

    public void congratulateWinner() {
        System.out.println(this);
        if(winner.equals("draw")) {
            System.out.println("This game ended in a draw. Congratulations to both players!");
        } else {
            System.out.println("Congratulations to " + winner + " on the victory!");
        }

    }

    public void playTurn(UserInputRetriever uir) {
        System.out.println(this);
        System.out.println("Player " + activePlayer + ", choose a column:");
        boolean validColumn = false;
        while(!validColumn) {
            int userSelection = uir.getIntInput(1, 7) - 1;
            if(hasOpenSlots(userSelection)) {
                placeToken(userSelection);
                validColumn = true;
            } else {
                System.out.println("Sorry, that column is already full.");
            }
        }
    }

    public void playGame(UserInputRetriever uir) {
        System.out.println("Let's play Connect Four!");
        GameBoard gb = new GameBoard();
        while(!gb.isGameOver()) {
            gb.swapActivePlayer();
            gb.playTurn(uir);
        }
        gb.congratulateWinner();
    }



}
