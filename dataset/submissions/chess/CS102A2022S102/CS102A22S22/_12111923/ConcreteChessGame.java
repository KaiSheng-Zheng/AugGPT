import java.util.ArrayList;
        import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    private List<String> chessboard;
    private ChessboardPoint source;
    private List<ChessboardPoint> canMoveTo;

    public ConcreteChessGame(ChessComponent[][] chessComponents) {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public ConcreteChessGame(ChessColor currentPlayer) {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = currentPlayer;
        if (currentPlayer == ChessColor.NONE) {
            this.currentPlayer = ChessColor.WHITE;
        }
    }

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                ChessboardPoint b = new ChessboardPoint(i, j);
                if (chessboard.get(i).charAt(j) == '_') {
                    this.chessComponents[i][j] = new EmptyChessComponent();
                    this.chessComponents[i][j].name = '_';
                } else if (chessboard.get(i).charAt(j) == 'R') {
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].name = 'R';
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].name = 'N';
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].name = 'B';
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].name = 'Q';
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].name = 'K';
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].name = 'P';
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    this.chessComponents[i][j] = new RookChessComponent();
                    this.chessComponents[i][j].name = 'r';
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    this.chessComponents[i][j] = new KnightChessComponent();
                    this.chessComponents[i][j].name = 'n';
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    this.chessComponents[i][j] = new BishopChessComponent();
                    this.chessComponents[i][j].name = 'b';
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    this.chessComponents[i][j] = new QueenChessComponent();
                    this.chessComponents[i][j].name = 'q';
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    this.chessComponents[i][j] = new KingChessComponent();
                    this.chessComponents[i][j].name = 'k';
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    this.chessComponents[i][j] = new PawnChessComponent();
                    this.chessComponents[i][j].name = 'p';
                }
            }
        }
        switch ((chessboard.get(8))) {
            case "w":
                this.currentPlayer = ChessColor.WHITE;
                break;
            case "b":
                this.currentPlayer = ChessColor.BLACK;
                break;
        }
    }

    public String getChessboardGraph() {
        StringBuilder OUT = new StringBuilder();
        OUT.append("");
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                OUT.append(this.chessComponents[i][j].name);
            }
            OUT.append("\n");
        }
        return String.valueOf(OUT);
    }

    public String getCapturedChess(ChessColor player) {
        int R = 0;
        int N = 0;
        int B = 0;
        int Q = 0;
        int K = 0;
        int P = 0;
        int r = 0;
        int n = 0;
        int b = 0;
        int q = 0;
        int k = 0;
        int p = 0;
        StringBuilder output = new StringBuilder();
        output.append("");
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'R') {
                        R++;
                    } else if (chessComponents[i][j].name == 'N') {
                        N++;
                    } else if (chessComponents[i][j].name == 'B') {
                        B++;
                    } else if (chessComponents[i][j].name == 'Q') {
                        Q++;
                    } else if (chessComponents[i][j].name == 'K') {
                        K++;
                    } else if (chessComponents[i][j].name == 'P') {
                        P++;
                    }
                }
            }
            if (K < 1) {
                output.append("K " + (1 - K) + "\n");
            }
            if (Q < 1) {
                output.append("Q " + (1 - Q) + "\n");
            }
            if (R < 2) {
                output.append("R " + (2 - R) + "\n");

            }
            if (B < 2) {
                output.append("B " + (2 - B) + "\n");
            }
            if (N < 2) {
                output.append("N " + (2 - N) + "\n");
            }
            if (P < 8) {
                output.append("P " + (8 - P));
            }
        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'r') {
                        r++;
                    } else if (chessComponents[i][j].name == 'n') {
                        n++;
                    } else if (chessComponents[i][j].name == 'b') {
                        b++;
                    } else if (chessComponents[i][j].name == 'q') {
                        q++;
                    } else if (chessComponents[i][j].name == 'k') {
                        k++;
                    } else if (chessComponents[i][j].name == 'p') {
                        p++;
                    }
                }
            }
            if (k < 1) {
                output.append("k " + (1 - k) + "\n");
            }
            if (q < 1) {
                output.append("q " + (1 - q) + "\n");
            }
            if (r < 2) {
                output.append("r " + (2 - r) + "\n");

            }
            if (b < 2) {
                output.append("b " + (2 - b) + "\n");
            }
            if (n < 2) {
                output.append("n " + (2 - n) + "\n");
            }
            if (p < 8) {
                output.append("p " + (8 - p));
            }
        }
        return String.valueOf(output);
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMveTo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (source.getX() == i) {
                    ChessboardPoint add = new ChessboardPoint(i, j);
                    canMveTo.add(add);
                }
                if (source.getY() == j) {
                    ChessboardPoint add = new ChessboardPoint(i, j);
                    canMveTo.add(add);
                }
            }
        }
        return canMveTo;
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX,targetY))){
            return true;
        }else return false;

    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent Chess = this.getChess(source.getX(), source.getY());
        List<ChessboardPoint> getCanMovePoints = Chess.canMoveTo();

        return ComparecanMoveTo(getCanMovePoints);
    }

    protected List<ChessboardPoint> ComparecanMoveTo(List<ChessboardPoint> canMoveTo) {
        List<ChessboardPoint> comparecanMoveTo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                for (int k = 0; k < canMoveTo.size(); k++) {
                    if (i == canMoveTo.get(k).getX() && j == canMoveTo.get(k).getY()) {
                        comparecanMoveTo.add(canMoveTo.get(k));
                    }
                }
            }
        }
        return comparecanMoveTo;
    }
}