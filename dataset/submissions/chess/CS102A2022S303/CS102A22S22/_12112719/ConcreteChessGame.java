import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;


    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        if (Objects.equals(chessboard.get(8), "b")) {
            this.currentPlayer = ChessColor.BLACK;
        } else {
            this.currentPlayer = ChessColor.WHITE;
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r');
                } else if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R');
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n');
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N');
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b');
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B');
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p');
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P');
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q');
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q');
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k');
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K');
                } else if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_');
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setCurrentgame(this);
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

    @Override
    public String getChessboardGraph() {
        StringBuilder graphBuilder = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                graphBuilder.append(chessComponents[i][j].getName());
                if (j == 7) {
                    graphBuilder.append("\n");
                }
            }
        }
        return graphBuilder.toString();
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String graph = this.getChessboardGraph();
        int R = 0, N = 0, B = 0, Q = 0, K = 0, P = 0;
        int r = 0, n = 0, b = 0, q = 0, k = 0, p = 0;
        for (int i = 0; i < graph.length(); i++) {
            if (graph.charAt(i) == 'r') {
                r++;
            } else if (graph.charAt(i) == 'R') {
                R++;
            } else if (graph.charAt(i) == 'n') {
                n++;
                if (i != 0 && graph.charAt(i - 1) == '\\') {
                    n--;
                }
            } else if (graph.charAt(i) == 'N') {
                N++;
            } else if (graph.charAt(i) == 'b') {
                b++;
            } else if (graph.charAt(i) == 'B') {
                B++;
            } else if (graph.charAt(i) == 'k') {
                k++;
            } else if (graph.charAt(i) == 'K') {
                K++;
            } else if (graph.charAt(i) == 'q') {
                q++;
            } else if (graph.charAt(i) == 'Q') {
                Q++;
            } else if (graph.charAt(i) == 'p') {
                p++;
            } else if (graph.charAt(i) == 'P') {
                P++;
            }
        }
        StringBuilder cap = new StringBuilder();
        if (player == ChessColor.WHITE) {
            if (k != 1) {
                cap.append("k 1\n");
            }
            if (q != 1) {
                cap.append("q 1\n");
            }
            if (r == 1) {
                cap.append("r 1\n");
            } else if (r == 0) {
                cap.append("r 2\n");
            }
            if (b == 1) {
                cap.append("b 1\n");
            } else if (b == 0) {
                cap.append("b 2\n");
            }
            if (n == 1) {
                cap.append("n 1\n");
            } else if (n == 0) {
                cap.append("n 2\n");
            }
            for (int i = 0; i < 8; i++) {
                if (p == i) {
                    cap.append(String.format("p %d\n", 8 - i));
                }
            }
        }
        if (player == ChessColor.BLACK) {
            if (K != 1) {
                cap.append("K 1\n");
            }
            if (Q != 1) {
                cap.append("Q 1\n");
            }
            if (R == 1) {
                cap.append("R 1\n");
            } else if (R == 0) {
                cap.append("R 2\n");
            }
            if (B == 1) {
                cap.append("B 1\n");
            } else if (B == 0) {
                cap.append("B 2\n");
            }
            if (N == 1) {
                cap.append("N 1\n");
            } else if (N == 0) {
                cap.append("N 2\n");
            }
            for (int i = 0; i < 8; i++) {
                if (P == i) {
                    cap.append(String.format("P %d\n", 8 - i));
                }
            }
        }
        return cap.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
            // 2. as below statement:
            List<ChessboardPoint> canMovePoints = chess.canMoveTo();
            // 3.sort canMovePoints by x - y ascending order
        ArrayList<ChessboardPoint> list =new ArrayList<>();
        for (int i = 0; i < canMovePoints.size(); i++) {
            list.add(canMovePoints.get(i));
        }
        Comxy xy=new Comxy();
        Collections.sort(list,xy);
            return list;

    }

    public class Comxy implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint chessboardPoint1,ChessboardPoint chessboardPoint2){
            if (chessboardPoint1.getX()<chessboardPoint2.getX()){
                return -1;
            }else if (chessboardPoint1.getX()==chessboardPoint2.getX()) {
                if (chessboardPoint1.getY()<chessboardPoint2.getY()) {
                    return -1;
                }else {
                    return 1;
                }
            }else {
                    return 1;
                }
            }
        }


    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
    

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess = chessComponents[sourceX][sourceY];
        if (chess.getChessColor() == currentPlayer) {
            List<ChessboardPoint> canmoveto = chess.canMoveTo();
            for (int i = 0; i < canmoveto.size(); i++) {
                if (canmoveto.get(i).getX() == targetX && canmoveto.get(i).getY() == targetY) {
                        chess.setSource(new ChessboardPoint(targetX, targetY));
                        chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY),
                                ChessColor.NONE, '_');
                        chessComponents[targetX][targetY] = chess;
                        if (currentPlayer==ChessColor.BLACK){
                            setCurrentPlayer(ChessColor.WHITE);
                        }else {
                            setCurrentPlayer(ChessColor.BLACK);
                        }
                        return true;
                }
            }
            return false;
        }else return false;
    }
}
