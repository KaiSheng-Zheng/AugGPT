import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.                             //default?
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {

        if (chessboard.get(8).equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
//                this.chessComponents[i][j].setChessboard(this.chessComponents);
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                } else {
                    chessComponents[i][j] = new EmptySlotComponent(chessComponents, new ChessboardPoint(i, j), chessboard.get(i).charAt(j));
                }
//                chessComponents[i][j].setName(chessboard.get(i).charAt(j));
//                chessComponents[i][j].getSource().setX(i);
//                chessComponents[i][j].getSource().setY(j);
//                if(chessboard.get(i).charAt(j)>='a'&chessboard.get(i).charAt(j)<='z'){
//                    chessComponents[i][j].setChessColor(ChessColor.WHITE);
//                }else{
//                    chessComponents[i][j].setChessColor(ChessColor.BLACK);
//                }
            }
        }

    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph.append(chessComponents[i][j].getName());
            }
            graph.append('\n');
        }
        return graph.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String chess = "";
        int K = 0;
        int k = 0;
        int N = 0;
        int n = 0;
        int P = 0;
        int p = 0;
        int Q = 0;
        int q = 0;
        int R = 0;
        int r = 0;
        int B = 0;
        int b = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].getName() == 'K') {
                    K++;
                }
                if (chessComponents[i][j].getName() == 'N') {
                    N++;
                }
                if (chessComponents[i][j].getName() == 'P') {
                    P++;
                }
                if (chessComponents[i][j].getName() == 'Q') {
                    Q++;
                }
                if (chessComponents[i][j].getName() == 'R') {
                    R++;
                }
                if (chessComponents[i][j].getName() == 'B') {
                    B++;
                }
                if (chessComponents[i][j].getName() == 'k') {
                    k++;
                }
                if (chessComponents[i][j].getName() == 'n') {
                    n++;
                }
                if (chessComponents[i][j].getName() == 'p') {
                    p++;
                }
                if (chessComponents[i][j].getName() == 'q') {
                    q++;
                }
                if (chessComponents[i][j].getName() == 'r') {
                    r++;
                }
                if (chessComponents[i][j].getName() == 'b') {
                    b++;
                }
            }
        }
        if (player.equals(ChessColor.BLACK)) {
            if (K == 0) {
                chess = chess.concat("K 1\n");
            }
            if (Q == 0) {
                chess = chess.concat("Q 1\n");
            }
            if (R <= 1) {
                chess = chess.concat(String.format("R %d\n", 2 - R));
            }
            if (B <= 1) {
                chess = chess.concat(String.format("B %d\n", 2 - B));
            }
            if (N <= 1) {
                chess = chess.concat(String.format("N %d\n", 2 - N));
            }
            if (P <= 7) {
                chess = chess.concat(String.format("P %d\n", 8 - P));
            }

        } else {
            if (k == 0) {
                chess = chess.concat("k 1\n");
            }
            if (q == 0) {
                chess = chess.concat("q 1\n");
            }
            if (r <= 1) {
                chess = chess.concat(String.format("r %d\n", 2 - r));
            }
            if (b <= 1) {
                chess = chess.concat(String.format("b %d\n", 2 - b));
            }
            if (n <= 1) {
                chess = chess.concat(String.format("n %d\n", 2 - n));
            }
            if (p <= 7) {
                chess = chess.concat(String.format("p %d\n", 8 - p));
            }

        }

        return chess;
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {

        return ChessboardPoint.sort(chessComponents[source.getX()][source.getY()].canMoveTo());

    }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int size = chessComponents[sourceX][sourceY].canMoveTo().size();

        if(currentPlayer==chessComponents[sourceX][sourceY].getChessColor()) {
            for (int i = 0; i < size; i++) {
                if ((chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX
                        & chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY)) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent
                            (chessComponents, new ChessboardPoint(sourceX, sourceY), '_');
                    if (currentPlayer.equals(ChessColor.WHITE)) {
                        currentPlayer = ChessColor.BLACK;
                    } else {
                        currentPlayer = ChessColor.WHITE;
                    }
                    for (int j = 0; j < 8; j++) {
                        for (int k = 0; k < 8; k++) {
                            chessComponents[j][k].setChessboard(chessComponents);
                        }
                    }
                    return true;
                }
            }
        }
            return false;

    }
}
