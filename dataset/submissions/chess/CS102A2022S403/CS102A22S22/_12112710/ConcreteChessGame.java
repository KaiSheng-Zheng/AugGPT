import java.util.*;
public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;


    public ChessComponent transform(char c) {
        if (c == 'p') {
            return new PawnChessComponent(ChessColor.WHITE, 'p');
        } else if (c == 'P') {
            return new PawnChessComponent(ChessColor.BLACK, 'P');
        } else if (c == 'n') {
            return new KnightChessComponent(ChessColor.WHITE, 'n');
        } else if (c == 'N') {
            return new KnightChessComponent(ChessColor.BLACK, 'N');
        } else if (c == 'b') {
            return new BishopChessComponent(ChessColor.WHITE, 'b');
        } else if (c == 'B') {
            return new BishopChessComponent(ChessColor.BLACK, 'B');
        } else if (c == 'r') {
            return new RookChessComponent(ChessColor.WHITE, 'r');
        } else if (c == 'R') {
            return new RookChessComponent(ChessColor.BLACK, 'R');
        } else if (c == 'q') {
            return new QueenChessComponent(ChessColor.WHITE, 'q');
        } else if (c == 'Q') {
            return new QueenChessComponent(ChessColor.BLACK, 'Q');
        } else if (c == 'k') {
            return new KingChessComponent(ChessColor.WHITE, 'k');
        } else if (c == 'K') {
            return new KingChessComponent(ChessColor.BLACK, 'K');
        } else return new EmptySlotComponent(ChessColor.NONE, '_');

    }


    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j] = transform(chessboard.get(i).charAt(j));
                chessComponents[i][j].setGame(this);
                chessComponents[i][j].setSource(new ChessboardPoint(i, j));
            }
        }
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else if (chessboard.get(8).equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        }
    }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder sb0 = new StringBuilder();
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        StringBuilder sb3 = new StringBuilder();
        StringBuilder sb4 = new StringBuilder();
        StringBuilder sb5 = new StringBuilder();
        StringBuilder sb6 = new StringBuilder();
        StringBuilder sb7 = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            sb0.append(chessComponents[0][i].toString());
        }
        for (int i = 0; i < 8; i++) {
            sb1.append(chessComponents[1][i].toString());
        }
        for (int i = 0; i < 8; i++) {
            sb2.append(chessComponents[2][i].toString());
        }
        for (int i = 0; i < 8; i++) {
            sb3.append(chessComponents[3][i].toString());
        }
        for (int i = 0; i < 8; i++) {
            sb4.append(chessComponents[4][i].toString());
        }
        for (int i = 0; i < 8; i++) {
            sb5.append(chessComponents[5][i].toString());
        }
        for (int i = 0; i < 8; i++) {
            sb6.append(chessComponents[6][i].toString());
        }
        for (int i = 0; i < 8; i++) {
            sb7.append(chessComponents[7][i].toString());
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", sb0.toString(), sb1.toString(), sb2.toString(),
                sb3.toString(), sb4.toString(), sb5.toString(),
                sb6.toString(), sb7.toString());
    }

    public String getCapturedChess(ChessColor player) {
        String[] s = new String[64];
        for (int i = 0; i < 8; i++) {
            s[i] = chessComponents[0][i].toString();
        }
        for (int i = 0; i < 8; i++) {
            s[i + 8] = chessComponents[1][i].toString();
        }
        for (int i = 0; i < 8; i++) {
            s[i + 16] = chessComponents[2][i].toString();
        }
        for (int i = 0; i < 8; i++) {
            s[i + 24] = chessComponents[3][i].toString();
        }
        for (int i = 0; i < 8; i++) {
            s[i + 32] = chessComponents[4][i].toString();
        }
        for (int i = 0; i < 8; i++) {
            s[i + 40] = chessComponents[5][i].toString();
        }
        for (int i = 0; i < 8; i++) {
            s[i + 48] = chessComponents[6][i].toString();
        }
        for (int i = 0; i < 8; i++) {
            s[i + 56] = chessComponents[7][i].toString();
        }
        int pc = 0;
        int rc = 0;
        int nc = 0;
        int bc = 0;
        int qc = 0;
        int kc = 0;
        StringBuilder sb = new StringBuilder();
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 64; i++) {
                if (Objects.equals(s[i], "P")) {
                    pc++;
                }
                if (Objects.equals(s[i], "N")) {
                    nc++;
                }
                if (Objects.equals(s[i], "B")) {
                    bc++;
                }
                if (Objects.equals(s[i], "Q")) {
                    qc++;
                }
                if (Objects.equals(s[i], "R")) {
                    rc++;
                }
                if (Objects.equals(s[i], "K")) {
                    kc++;
                }
            }
            if (kc != 1) {
                sb.append("K 1\n");
            }
            if (qc != 1) {
                sb.append("Q 1\n");
            }
            if (rc != 2) {
                sb.append("R ").append(2 - rc).append("\n");
            }
            if (bc != 2) {
                sb.append("B ").append(2 - bc).append("\n");
            }
            if (nc != 2) {
                sb.append("N ").append(2 - nc).append("\n");
            }
            if (pc != 8) {
                sb.append("P ").append(8 - pc).append("\n");
            }
        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < 64; i++) {
                if (Objects.equals(s[i], "p")) {
                    pc++;
                }
                if (Objects.equals(s[i], "n")) {
                    nc++;
                }
                if (Objects.equals(s[i], "b")) {
                    bc++;
                }
                if (Objects.equals(s[i], "q")) {
                    qc++;
                }
                if (Objects.equals(s[i], "r")) {
                    rc++;
                }
                if (Objects.equals(s[i], "k")) {
                    kc++;
                }
            }
            if (kc != 1) {
                sb.append("k 1\n");
            }
            if (qc != 1) {
                sb.append("q 1\n");
            }
            if (rc != 2) {
                sb.append("r ").append(2 - rc).append("\n");
            }
            if (bc != 2) {
                sb.append("b ").append(2 - bc).append("\n");
            }
            if (nc != 2) {
                sb.append("n ").append(2 - nc).append("\n");
            }
            if (pc != 8) {
                sb.append("p ").append(8 - pc).append("\n");
            }
        }
        String S = sb.toString();
        return S;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

     private static class SortPoints implements Comparator<ChessboardPoint> {
        @Override
        public int compare(ChessboardPoint p1, ChessboardPoint p2) {
            if (p1.getX() > p2.getX()) {
                return 1;
            } else if (p1.getX() < p2.getX()) {
                return -1;
            } else {
                if (p1.getY() > p2.getY()) {
                    return 1;
                } else if (p1.getY() < p2.getY()) {
                    return -1;
                } else return 0;
            }
        }
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        Comparator<ChessboardPoint> sp = new SortPoints();
        List<ChessboardPoint> result = chess.canMoveTo();
        if (result.size()==0){
            return result;
        }else {
        result.sort(sp);}
        return result;
    }


    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean can = false;
           if (sourceX < 8 && sourceX >= 0 && sourceY < 8 && sourceY >= 0 &&targetX < 8 && targetX >= 0&&targetY < 8 && targetY >= 0){
            ChessComponent chessSource = chessComponents[sourceX][sourceY];
        ChessComponent chessTarget = chessComponents[targetX][targetY];
        List<ChessboardPoint> list = chessSource.canMoveTo();
        if (chessSource.getChessColor() != getCurrentPlayer()) {
            can = false;
        }
        if (chessSource.getChessColor() == ChessColor.NONE) {
            can = false;
        }
        boolean have=false;
            for (ChessboardPoint point : list) {
                if (point.getX() == chessTarget.getSource().getX() && point.getY() == chessTarget.getSource().getY()) {
                    have = true;
                } else have = false;
            }
            if (chessSource.getChessColor() == getCurrentPlayer() && have) {
            chessComponents[targetX][targetY] = chessSource;
            chessComponents[targetX][targetY].setSource(chessSource.getSource());
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(ChessColor.NONE, '_');

            if (currentPlayer == ChessColor.WHITE) {
                this.currentPlayer = ChessColor.BLACK;
            } else if (currentPlayer == ChessColor.BLACK) {
                this.currentPlayer = ChessColor.WHITE;
            }
            can = true;
        }}
        return can;
    }


}
