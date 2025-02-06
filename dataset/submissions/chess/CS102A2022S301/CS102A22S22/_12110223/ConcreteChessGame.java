
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.lang.Comparable;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[9][9];
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
                chessComponents[i][j] = judge(String.valueOf(chessboard.get(i).charAt(j)), i, j);
            }
        }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChees(chessComponents);
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer = ChessColor.WHITE;
        } else currentPlayer = ChessColor.BLACK;
    }


    public ChessComponent judge(String x, int i, int j) {
        if (x.equals("k") || x.equals("K")) {
            ChessComponent aaa = new KingChessComponent();
            aaa.setSource(new ChessboardPoint(i, j));
            if (x.equals("k")) {
                aaa.setChessColor(ChessColor.WHITE);
                aaa.setName('k');
            } else {
                aaa.setChessColor(ChessColor.BLACK);
                aaa.setName('K');
            }
            return aaa;
        } else if (x.equals("q") || x.equals("Q")) {
            ChessComponent aaa = new QueenChessComponent();
            aaa.setSource(new ChessboardPoint(i, j));
            if (x.equals("q")) {
                aaa.setChessColor(ChessColor.WHITE);
                aaa.setName('q');
            } else {
                aaa.setName('Q');
                aaa.setChessColor(ChessColor.BLACK);
            }
            return aaa;
        } else if (x.equals("r") || x.equals("R")) {
            ChessComponent aaa = new RookChessComponent();
            aaa.setSource(new ChessboardPoint(i, j));
            if (x.equals("r")) {
                aaa.setChessColor(ChessColor.WHITE);
                aaa.setName('r');
            } else {
                aaa.setName('R');
                aaa.setChessColor(ChessColor.BLACK);
            }
            return aaa;
        } else if (x.equals("b") || x.equals("B")) {
            ChessComponent aaa = new BishopChessComponent();
            aaa.setSource(new ChessboardPoint(i, j));
            if (x.equals("b")) {
                aaa.setChessColor(ChessColor.WHITE);
                aaa.setName('b');
            } else {
                aaa.setName('B');
                aaa.setChessColor(ChessColor.BLACK);
            }
            return aaa;
        } else if (x.equals("P") || x.equals("p")) {
            ChessComponent aaa = new PawnChessComponent();
            aaa.setSource(new ChessboardPoint(i, j));
            if (x.equals("p")) {
                aaa.setChessColor(ChessColor.WHITE);
                aaa.setName('p');
            } else {
                aaa.setName('P');
                aaa.setChessColor(ChessColor.BLACK);
            }
            return aaa;
        } else if (x.equals("N") || x.equals("n")) {
            ChessComponent aaa = new KnightChessComponent();
            aaa.setSource(new ChessboardPoint(i, j));
            if (x.equals("n")) {
                aaa.setChessColor(ChessColor.WHITE);
                aaa.setName('n');
            } else {
                aaa.setName('N');
                aaa.setChessColor(ChessColor.BLACK);
            }
            return aaa;
        } else {
            ChessComponent aaa = new EmptySlotComponent();
            aaa.setSource(new ChessboardPoint(i, j));
            aaa.setName('_');
            return aaa;
        }
    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        String x = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                x = x.concat(String.valueOf(chessComponents[i][j].getName()));
            }
            if (i != 7) {
                x = x.concat("\n");
            }
        }
        return x;
    }

    public String getCapturedChess(ChessColor player) {
        String x = "";
        String ssx = "";
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0, g = 0, h = 0, ii = 0, jj = 0, k = 0, l = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ("R".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    a = a + 1;
                } else if ("N".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    b = b + 1;
                } else if ("B".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    c = c + 1;
                } else if ("Q".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    d = d + 1;
                } else if ("K".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    e = e + 1;
                } else if ("P".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    f = f + 1;
                } else if ("r".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    g = g + 1;
                } else if ("n".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    h = h + 1;
                } else if ("b".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    ii = ii + 1;
                } else if ("q".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    jj = jj + 1;
                } else if ("k".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    k = k + 1;
                } else if ("p".equals(String.valueOf(chessComponents[i][j].getName()))) {
                    l = l + 1;
                }
            }
        }
        if (player == ChessColor.BLACK) {
            if (e <1) {
                x = x.concat("K 1" + "\n");
            }
            if (d <1) {
                x = x.concat("Q 1" + "\n");
            }
            if (a < 2) {
                x = x.concat("R " + (2 - a) + "\n");
            }
            if (c < 2) {
                x = x.concat("B " + (2 - c) + "\n");
            }
            if (b < 2) {
                x = x.concat("N " + (2 - b) + "\n");
            }
            if (f < 8) {
                x = x.concat("P " + (8 - f) + "\n");
            }
            System.out.println(a);
            System.out.println(c);
            System.out.println(b);
            return x;
        }
        if (player == ChessColor.WHITE) {
            if (k < 1) {
                ssx = ssx.concat("k 1" + "\n");
            }
            if (jj < 1) {
                ssx = ssx.concat("q 1" + "\n");
            }
            if (g < 2) {
                ssx = ssx.concat("r " + (2 - g) + "\n");
            }
            if (ii < 2) {
                ssx = ssx.concat("b " + (2 - ii) + "\n");
            }
            if (h < 2) {
                ssx = ssx.concat("n " + (2 - h) + "\n");
            }
            if (l < 8) {
                ssx = ssx.concat("p " + (8 - l) + "\n");
            }

        }
        return ssx;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent a = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = new ArrayList<ChessboardPoint>();
        canMovePoints = a.canMoveTo();
        Collections.sort(canMovePoints);
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].name == '_') {
            return false;
        } else if (currentPlayer == chessComponents[sourceX][sourceY].getChessColor()) {
            ChessboardPoint aa = new ChessboardPoint(sourceX, sourceY);
            boolean hah = false;
            ChessboardPoint aaa = new ChessboardPoint(targetX, targetY);
            for (int i = 0; i < getCanMovePoints(aa).size(); i++) {
                if (getCanMovePoints(aa).get(i).equal(aaa)) {
                    hah = true;
                    break;
                }
            }
            if (hah) {
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
                chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                for (int i = 0; i < 8; i++) {
                    for (int j = 0; j < 8; j++) {
                        chessComponents[i][j].setChees(chessComponents);
                    }
                }
                if (currentPlayer == ChessColor.BLACK) {
                    currentPlayer = ChessColor.WHITE;
                } else currentPlayer = ChessColor.BLACK;
                return true;
            } else return false;
        }else return false;
    }

    public ChessComponent getChess(int x, int y){
            System.out.println(chessComponents[1][4]);
            return chessComponents[x][y];

    }
}