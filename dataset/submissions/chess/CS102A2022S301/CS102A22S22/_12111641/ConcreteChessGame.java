import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[9][8];
    private ChessColor currentPlayer;


//    public static void main(String[] args) {
//        try {
//            List<String> chessboard = Files.readAllLines(Paths.get("./testcases/load/game1.txt"));
//            System.out.println(chessboard);
//            ConcreteChessGame concreteChessGame = new ConcreteChessGame();
//            concreteChessGame.loadChessGame(chessboard);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        }
//
//
//    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessComponent chessComponent;
                char x = chessboard.get(i).charAt(j);
                if (x == 'R') {
                    chessComponent = new RookChessComponent();
                    chessComponent.setChessColor(ChessColor.BLACK);
                } else if (x == 'r') {
                    chessComponent = new RookChessComponent();
                    chessComponent.setChessColor(ChessColor.WHITE);
                } else if (x == 'N') {
                    chessComponent = new KnightChessComponent();
                    chessComponent.setChessColor(ChessColor.BLACK);
                } else if (x == 'n') {
                    chessComponent = new KnightChessComponent();
                    chessComponent.setChessColor(ChessColor.WHITE);
                } else if (x == 'B') {
                    chessComponent = new BishopChessComponent();
                    chessComponent.setChessColor(ChessColor.BLACK);
                } else if (x == 'b') {
                    chessComponent = new BishopChessComponent();
                    chessComponent.setChessColor(ChessColor.WHITE);
                } else if (x == 'Q') {
                    chessComponent = new QueenChessComponent();
                    chessComponent.setChessColor(ChessColor.BLACK);
                } else if (x == 'q') {
                    chessComponent = new QueenChessComponent();
                    chessComponent.setChessColor(ChessColor.WHITE);
                } else if (x == 'K') {
                    chessComponent = new KingChessComponent();
                    chessComponent.setChessColor(ChessColor.BLACK);
                } else if (x == 'k') {
                    chessComponent = new KingChessComponent();
                    chessComponent.setChessColor(ChessColor.WHITE);
                } else if (x == 'P') {
                    chessComponent = new PawnChessComponent();
                    chessComponent.setChessColor(ChessColor.BLACK);
                } else if (x == 'p') {
                    chessComponent = new PawnChessComponent();
                    chessComponent.setChessColor(ChessColor.WHITE);
                } else {
                    chessComponent = new EmptySlotComponent();
                    chessComponent.setChessColor(ChessColor.NONE);
                }
                chessComponent.setName(chessboard.get(i).charAt(j));
                chessComponent.setSource(new ChessboardPoint(i, j));
                chessComponents[i][j] = chessComponent;
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        StringBuilder x = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                x.append(chessComponents[i][j].toString());
            }
            x.append("\n");
        }
        return x.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int R = 0, N = 0, B = 0, Q = 0, K = 0, P = 0, r = 0, n = 0, b = 0, k = 0, q = 0, p = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessComponents[i][j].name) {
                    case 'R':
                        R++;
                        break;
                    case 'N':
                        N++;
                        break;
                    case 'B':
                        B++;
                        break;
                    case 'Q':
                        Q++;
                        break;
                    case 'K':
                        K++;
                        break;
                    case 'P':
                        P++;
                        break;
                    case 'r':
                        r++;
                        break;
                    case 'n':
                        n++;
                        break;
                    case 'b':
                        b++;
                        break;
                    case 'q':
                        q++;
                        break;
                    case 'k':
                        k++;
                        break;
                    case 'p':
                        p++;
                        break;
                    case '-':
                        break;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        if (player == ChessColor.BLACK) {
            if (K != 1) {
                stringBuilder.append("K ").append(1).append("\n");
            }
            if (Q != 1) {
                stringBuilder.append("Q ").append(1).append("\n");
            }
            if (R != 2) {
                stringBuilder.append("R ").append(2-R).append("\n");
            }
            if (B != 2) {
                stringBuilder.append("B ").append(2-B).append("\n");
            }
            if (N != 2) {
                stringBuilder.append("N ").append(2-N).append("\n");
            }
            if (P != 8) {
                stringBuilder.append("P ").append(8-P).append("\n");
            }
        }
        if (player == ChessColor.WHITE) {
            if (k != 1) {
                stringBuilder.append("k ").append(1).append("\n");
            }
            if (q != 1) {
                stringBuilder.append("q ").append(1).append("\n");
            }
            if (r != 2) {
                stringBuilder.append("r ").append(2-r).append("\n");
            }
            if (b != 2) {
                stringBuilder.append("b ").append(2-b).append("\n");
            }
            if (n != 2) {
                stringBuilder.append("n ").append(2-n).append("\n");
            }
            if (p != 8) {
                stringBuilder.append("p ").append(8-p).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return null;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        return false;
    }
}
