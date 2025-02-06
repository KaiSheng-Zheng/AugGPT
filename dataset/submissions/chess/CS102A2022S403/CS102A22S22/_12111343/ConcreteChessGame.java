import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.ll
    private ChessColor currentPlayer;

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)) {
                    case 'K':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case 'B':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case 'R':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case 'N':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case 'Q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case 'P':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.BLACK,
                                new ChessboardPoint(i, j));
                        break;
                    case '_':
                        chessComponents[i][j] = new EmptySlotComponent(ChessColor.NONE,
                                new ChessboardPoint(i, j));
                        break;
                    case 'k':
                        chessComponents[i][j] = new KingChessComponent(ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                    case 'r':
                        chessComponents[i][j] = new RookChessComponent(ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                    case 'n':
                        chessComponents[i][j] = new KnightChessComponent(ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                    case 'q':
                        chessComponents[i][j] = new QueenChessComponent(ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                    case 'p':
                        chessComponents[i][j] = new PawnChessComponent(ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                    case 'b':
                        chessComponents[i][j] = new BishopChessComponent(ChessColor.WHITE,
                                new ChessboardPoint(i, j));
                        break;
                }
            }
        }
        switch (chessboard.get(8)) {
            case "w" :
                this.currentPlayer = ChessColor.WHITE;
                break;
            case "b" :
                this.currentPlayer = ChessColor.BLACK;
                break;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder graph = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graph.append(chessComponents[i][j].name);
            }
            graph.append("\n");
        }
        return graph.toString();
    }

    public String getCapturedChess(ChessColor player) {
        StringBuilder Black = new StringBuilder();
        StringBuilder White = new StringBuilder();
        int K = 0, P = 0, Q = 0, N = 0, B = 0, R = 0, k = 0, p = 0, q = 0, n = 0, b = 0, r = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessComponents[i][j].name == 'K') {
                    K += 1;
                } else if (chessComponents[i][j].name == 'P') {
                    P += 1;
                } else if (chessComponents[i][j].name == 'Q') {
                    Q += 1;
                } else if (chessComponents[i][j].name == 'B') {
                    B += 1;
                } else if (chessComponents[i][j].name == 'N') {
                    N += 1;
                } else if (chessComponents[i][j].name == 'R') {
                    R += 1;
                } else if (chessComponents[i][j].name == 'k') {
                    k += 1;
                } else if (chessComponents[i][j].name == 'p') {
                    p += 1;
                } else if (chessComponents[i][j].name == 'q') {
                    q += 1;
                } else if (chessComponents[i][j].name == 'b') {
                    b += 1;
                } else if (chessComponents[i][j].name == 'n') {
                    n += 1;
                } else if (chessComponents[i][j].name == 'r') {
                    r += 1;
                }
            }
        }
        if (player == ChessColor.BLACK) {
            if (K == 0) {
                Black.append(String.format("K 1\n"));
            }
            if (Q == 0) {
                Black.append(String.format("Q 1\n"));
            }
            if (R != 2) {
                Black.append(String.format("R %d\n", 2 - R));
            }
            if (B != 2) {
                Black.append(String.format("B %d\n", 2 - B));
            }
            if (N != 2) {
                Black.append(String.format("N %d\n", 2 - N));
            }
            if (P != 8) {
                Black.append(String.format("P %d\n", 8 - P));
            }
            return Black.toString();
        } else {
            if (k == 0) {
                White.append(String.format("k 1\n"));
            }
            if (q == 0) {
                White.append(String.format("q 1\n"));
            }
            if (r != 2) {
                White.append(String.format("r %d\n", 2 - r));
            }
            if (b != 2) {
                White.append(String.format("b %d\n", 2 - b));
            }
            if (n != 2) {
                White.append(String.format("n %d\n", 2 - n));
            }
            if (p != 8) {
                White.append(String.format("p %d\n", 8 - p));
            }
            return White.toString();
        }
    }

    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        chessComponents[source.getX()][source.getY()].loadCurrentChessboard(chessComponents);
        ArrayList<ChessboardPoint> moveTo=(ArrayList<ChessboardPoint>)chessComponents[source.getX()][source.getY()].canMoveTo();
        moveTo.sort(new Sort());
        return moveTo;
    }
    private static class Sort implements Comparator<ChessboardPoint>{
        @Override
        public int compare(ChessboardPoint p1,ChessboardPoint p2){
            return p1.getX()==p2.getX()?p1.getY()-p2.getY():p1.getX()-p2.getX();
        }
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
        ChessboardPoint target = new ChessboardPoint(targetX, targetY);
        ChessComponent sc = chessComponents[sourceX][sourceY];
        boolean can = false;
        if (getChess(sourceX,sourceY).getChessColor() == currentPlayer){
            for (int i=0;i<sc.canMoveTo().size();i++){
                if (sc.canMoveTo().get(i).getX()==targetX&&sc.canMoveTo().get(i).getY()==targetY){
                    sc.setSource(target);
                    chessComponents[targetX][targetY]=sc;
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(ChessColor.NONE,source);
                    if (currentPlayer==ChessColor.WHITE){
                        currentPlayer=ChessColor.BLACK;
                    }else {
                        currentPlayer=ChessColor.WHITE;
                    }
                    can = true;
                }
            }
        }
        return can;
    }
}