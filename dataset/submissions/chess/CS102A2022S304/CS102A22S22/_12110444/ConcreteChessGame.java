
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer = ChessColor.WHITE;

    public ConcreteChessGame(ChessComponent[][] chessComponents, ChessColor currentPlayer) {
        this.chessComponents = chessComponents;
        this.currentPlayer = currentPlayer;
    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R' || chessboard.get(i).charAt(j) == 'r') {
                    RookChessComponent C = new RookChessComponent(i, j, chessboard.get(i).charAt(j),this.chessComponents);
                    this.chessComponents[i][j] = C;
                } else if (chessboard.get(i).charAt(j) == 'N' || chessboard.get(i).charAt(j) == 'n') {
                    KnightChessComponent C = new KnightChessComponent(i, j, chessboard.get(i).charAt(j),this.chessComponents);
                    this.chessComponents[i][j] = C;
                } else if (chessboard.get(i).charAt(j) == 'K' || chessboard.get(i).charAt(j) == 'k') {
                    KingChessComponent C = new KingChessComponent(i, j, chessboard.get(i).charAt(j),chessComponents);
                    chessComponents[i][j] = C;
                } else if (chessboard.get(i).charAt(j) == 'Q' || chessboard.get(i).charAt(j) == 'q') {
                    QueenChessComponent C = new QueenChessComponent(i, j, chessboard.get(i).charAt(j),chessComponents);
                    chessComponents[i][j] = C;
                } else if (chessboard.get(i).charAt(j) == 'B' || chessboard.get(i).charAt(j) == 'b') {
                    BishopChessComponent C = new BishopChessComponent(i, j, chessboard.get(i).charAt(j),chessComponents);
                    chessComponents[i][j] = C;
                } else if (chessboard.get(i).charAt(j) == 'P' || chessboard.get(i).charAt(j) == 'p') {
                    PawnChessComponent C = new PawnChessComponent(i, j, chessboard.get(i).charAt(j),chessComponents);
                    chessComponents[i][j] = C;
                } else if (chessboard.get(i).charAt(j) == '_') {
                    EmptySlotComponent C = new EmptySlotComponent(i, j, chessboard.get(i).charAt(j));
                    chessComponents[i][j] = C;
                }
            }
        }
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).charAt(0) == 'b') {
            currentPlayer = ChessColor.BLACK;
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

    @Override
    public String getChessboardGraph() {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 8; j++) {
                str.append(chessComponents[i][j].name);
            }
            str.append("\n");
        }
        for (int i = 0; i < 8; i++) {
            str.append(chessComponents[7][i].name);
        }
        return str.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int K = 0;
        int Q = 0;
        int R = 0;
        int B = 0;
        int N = 0;
        int P = 0;
        String s = getChessboardGraph();
        StringBuilder str = new StringBuilder();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < getChessboardGraph().length(); i++) {
                if (getChessboardGraph().charAt(i) == 'K') {
                    K++;
                } else if (getChessboardGraph().charAt(i) == 'Q') {
                    Q++;
                } else if (getChessboardGraph().charAt(i) == 'R') {
                    R++;
                } else if (getChessboardGraph().charAt(i) == 'B') {
                    B++;
                } else if (getChessboardGraph().charAt(i) == 'N') {
                    N++;
                } else if (getChessboardGraph().charAt(i) == 'P') {
                    P++;
                }
            }

            if (K != 1) {
                str.append("K 1\n");
            }
            if (Q != 1) {
                str.append("Q 1\n");
            }
            if (R != 2) {
                str.append("R ").append(2 - R).append("\n");
            }
            if (B != 2) {
                str.append("B ").append(2 - B).append("\n");
            }
            if (N != 2) {
                str.append("N ").append(2 - N).append("\n");
            }
            if (P != 8) {
                str.append("P ").append(8 - P).append("\n");
            }
        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < getChessboardGraph().length(); i++) {
                if (getChessboardGraph().charAt(i) == 'k') {
                    K++;
                }
                if (getChessboardGraph().charAt(i) == 'q') {
                    Q++;
                }
                if (getChessboardGraph().charAt(i) == 'r') {
                    R++;
                }
                if (getChessboardGraph().charAt(i) == 'b') {
                    B++;
                }
                if (getChessboardGraph().charAt(i) == 'n') {
                    N++;
                }
                if (getChessboardGraph().charAt(i) == 'p') {
                    P++;
                }
            }
            if (K != 1) {
                str.append("k 1\n");
            }
            if (Q != 1) {
                str.append("q 1\n");
            }
            if (R != 2) {
                str.append("r ").append(2 - R).append("\n");
            }
            if (B != 2) {
                str.append("b ").append(2 - B).append("\n");
            }
            if (N != 2) {
                str.append("n ").append(2 - N).append("\n");
            }
            if (P != 8) {
                str.append("p ").append(8 - P).append("\n");
            }
        }

        return str.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        return getChess(source.getX(), source.getY()).canMoveTo();
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (getChess(sourceX, sourceY).getChessColor() != currentPlayer) {
            return false;
        }
        for (ChessboardPoint chessboardPoint : getChess(sourceX, sourceY).canMoveTo()) {
            if (chessboardPoint.getX() == targetX && chessboardPoint.getY() == targetY) {
                currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
                chessComponents[targetX][targetY] = getChess(sourceX, sourceY);
                chessComponents[targetX][targetY].getChessboardPoint().setX(targetX);
                chessComponents[targetX][targetY].getChessboardPoint().setY(targetY);
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX, sourceY, ' ');
                return true;
            }
        }
        return false;
    }

}




