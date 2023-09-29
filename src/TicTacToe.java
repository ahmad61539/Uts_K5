import java.util.Scanner;

public class TicTacToe {

    private char[][] board;
    private char currentPlayer;

    public TicTacToe() {
        board = new char[3][3];
        currentPlayer = 'X';
        initializeBoard();
    }

    public void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = ' ';
            }
        }
    }

    public void printBoard() {
        System.out.println("   0   1   2");
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print(i + "| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println("\n-------------");
        }
    }

    public boolean isBoardFull() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean isGameOver() {
        return checkWin('X') || checkWin('O') || isBoardFull();
    }

    public boolean checkWin(char player) {
        // Check rows and columns
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }

        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }

        return false;
    }

    public void makeMove(int row, int col) {
        if (row >= 0 && row < 3 && col >= 0 && col < 3 && board[row][col] == ' ') {
            board[row][col] = currentPlayer;
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        } else {
            System.out.println("Langkah tidak valid. Coba lagi.");
        }
    }

    public static void main(String[] args) {
        TicTacToe game = new TicTacToe();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Reyhan Ganteng");
        System.out.println("Selamat datang di permainan Tic-Tac-Toe!");
        while (!game.isGameOver()) {
            game.printBoard();
            System.out.println("Giliran pemain " + game.currentPlayer + ".");
            System.out.print("Masukkan baris (0, 1, atau 2): ");
            int row = scanner.nextInt();
            System.out.print("Masukkan kolom (0, 1, atau 2): ");
            int col = scanner.nextInt();
            game.makeMove(row, col);
        }

        game.printBoard();

        if (game.checkWin('X')) {
            System.out.println("Pemain X Menang!");
        } else if (game.checkWin('O')) {
            System.out.println("Pemain O Menang!");
        } else {
            System.out.println("Permainan Seri!");
        }
        System.out.println("Created By Centauri And Herlita");
        scanner.close();
    }
}
