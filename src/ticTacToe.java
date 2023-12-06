import java.util.Scanner;

public class ticTacToe {
    private static final int ROW = 3;
    private static final int COLUMN = 3;
    private static final String[][] board = new String[3][3];

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        final int WINNING_MOVES = 5;
        final int TYING_MOVES = 7;
        int moves = 0;
        int row = -1;
        int column = -1;
        String[][] board = new String[3][3];
        String player = "X";
        boolean playing = true;
        boolean finished = false;

// establishing game loop, clearing board, and 1st player as X
        do {
            System.out.println("Welcome to Tic-Tac-Toe!");
            player = "X";
            playing = true;
            moves = 0;
            clearBoard();
            do {
                // move coordinates + convert to array indices; loop until valid
                do {
                    showBoard();
                    System.out.println("It's " + player + "'s turn!");
                    row = safeInput.getRangedInt(scanner, "What row would you like? ", 1, 3);
                    column = safeInput.getRangedInt(scanner, "What column would you like? ", 1, 3);
                    row--;
                    column--;
                } while (!isValidMove(row, column));
                moves++;
                boardMark(player);
// toggle player
                if(player.equals("X"))
                {
                    player = "O";
                } else
                {
                    player = "X";
                }
//check for win + announce
                if(moves >= WINNING_MOVES)
                {
                    if(isWin(player))
                    {
                        showBoard();
                        System.out.println(player + " has won!");
                        playing = false;
                    }
                }
                if(moves >= TYING_MOVES)
                {
                    if(isTie())
                    {
                        showBoard();
                        System.out.println("It's a tie!");
                        playing = false;
                    }
                }
            } while(playing);
            finished = safeInput.getYNConfirm(scanner, "Would you like to play again?");
        } while (finished);
    }

    //method catalogue
    public static void clearBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int column = 0; column < COLUMN; column++)
            {
                board[row][column] = " ";
            }
        }
    }
    public static void showBoard()
    {
        for(int row = 0; row < ROW; row++)
        {
            for(int column = 0; column < COLUMN; column++)
            {
                System.out.print(board[row][column] + " | ");
            }
            System.out.println();
        }
    }
    public static boolean isValidMove(int row, int column)
    {
        return board[row][column].equals(" ");
    }
    public static boolean isWin(String player)
    {
        return isColumnWin(player) || isRowWin(player) || isDiagonalWin(player);
    }
    public static boolean isRowWin(String player)
    {
        for(int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals(player) && board[row][1].equals(player) && board[row][2].equals(player))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean isColumnWin(String player)
    {
        for(int column = 0; column < COLUMN; column++)
        {
            if(board[0][column].equals(player) && board[1][column].equals(player) && board[2][column].equals(player))
            {
                return true;
            }
        }
        return false;
    }
    public static boolean isDiagonalWin(String player)
    {
        return board[0][0].equals(player) && board[1][1].equals(player) && board[2][2].equals(player)
                || board[0][2].equals(player) && board[1][1].equals(player) && board[2][0].equals(player);
    }
    public static boolean isTie()
    {
        boolean x = false;
        boolean o = false;

        for(int row = 0; row < ROW; row++)
        {
            if(board[row][0].equals("X") || board[row][1].equals("X") || board[row][2].equals("X"))
            {
                x = true;
            }
            if(board[row][0].equals("O") || board[row][1].equals("O") || board[row][2].equals("O"))
            {
                o = true;
            }
            if(! (x && o))
            {
                return false;
            }
        }
        x = o = false;
        if(board[0][0].equals("X") || board[1][1].equals("X") || board[2][2].equals("X"))
        {
            x = true;
        }
        if(board[0][0].equals("O") || board[1][1].equals("O") || board[2][2].equals("O"))
        {
            o = true;
        }
        return x && o;
    }
    public static void boardMark(String player)
    {
        Scanner scanner = new Scanner(System.in);
        int row = safeInput.getRangedInt(scanner, "What row would you like? ", 1, 3 );
        int column = safeInput.getRangedInt(scanner, "What column would you like? ", 1, 3 );
        if(player.equals("X"))
        {
            board[row - 1][column - 1] = "X";
        } else
        {
            board[row - 1][column - 1] = "O";
        }
    }
}

