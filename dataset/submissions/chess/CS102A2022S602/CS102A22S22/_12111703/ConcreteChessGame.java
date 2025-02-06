import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame implements ChessGame {

    private ChessComponent[][] chessComponents = new ChessComponent[8][8];

    private ChessColor currentPlayer = ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard) {

        String[] a = chessboard.get(0).split("");
        String[] b = chessboard.get(1).split("");
        String[] c = chessboard.get(2).split("");
        String[] d = chessboard.get(3).split("");
        String[] e = chessboard.get(4).split("");
        String[] f = chessboard.get(5).split("");
        String[] g = chessboard.get(6).split("");
        String[] h = chessboard.get(7).split("");
        String p = chessboard.get(8);
        if (p.equals("w")) {
            currentPlayer = ChessColor.WHITE;
        }
        if (p.equals("b")) {
            currentPlayer = ChessColor.BLACK;
        }

        for (int i = 0; i < 8; i++) {
            ChessComponent m = new ChessComponent() {
                @Override
                public List<ChessboardPoint> canMoveTo() {
                    return null;
                }
            };
            m.name = a[i].charAt(0);
            if (Character.isUpperCase(m.name)) {
                m.setChessColor(ChessColor.BLACK);
            } else if (Character.isLowerCase(m.name)) {
                m.setChessColor(ChessColor.WHITE);
            } else {
                m.setChessColor(ChessColor.NONE);
            }
            ChessboardPoint chessboardPoint = new ChessboardPoint(0, i);
            m.setSource(chessboardPoint);
            chessComponents[0][i] = m;
        }
        for (int i = 0; i < 8; i++) {
            ChessComponent m = new ChessComponent() {
                @Override
                public List<ChessboardPoint> canMoveTo() {
                    return null;
                }
            };
            m.name = b[i].charAt(0);
            if (Character.isUpperCase(m.name)) {
                m.setChessColor(ChessColor.BLACK);
            } else if (Character.isLowerCase(m.name)) {
                m.setChessColor(ChessColor.WHITE);
            } else {
                m.setChessColor(ChessColor.NONE);
            }
            ChessboardPoint chessboardPoint = new ChessboardPoint(0, i);
            m.setSource(chessboardPoint);
            chessComponents[1][i] = m;
        }
        for (int i = 0; i < 8; i++) {
            ChessComponent m = new ChessComponent() {
                @Override
                public List<ChessboardPoint> canMoveTo() {
                    return null;
                }
            };
            m.name = c[i].charAt(0);
            if (Character.isUpperCase(m.name)) {
                m.setChessColor(ChessColor.BLACK);
            } else if (Character.isLowerCase(m.name)) {
                m.setChessColor(ChessColor.WHITE);
            } else {
                m.setChessColor(ChessColor.NONE);
            }
            ChessboardPoint chessboardPoint = new ChessboardPoint(0, i);
            m.setSource(chessboardPoint);
            chessComponents[2][i] = m;
        }
        for (int i = 0; i < 8; i++) {
            ChessComponent m = new ChessComponent() {
                @Override
                public List<ChessboardPoint> canMoveTo() {
                    return null;
                }
            };
            m.name = d[i].charAt(0);
            if (Character.isUpperCase(m.name)) {
                m.setChessColor(ChessColor.BLACK);
            } else if (Character.isLowerCase(m.name)) {
                m.setChessColor(ChessColor.WHITE);
            } else {
                m.setChessColor(ChessColor.NONE);
            }
            ChessboardPoint chessboardPoint = new ChessboardPoint(0, i);
            m.setSource(chessboardPoint);
            chessComponents[3][i] = m;
        }
        for (int i = 0; i < 8; i++) {
            ChessComponent m = new ChessComponent() {
                @Override
                public List<ChessboardPoint> canMoveTo() {
                    return null;
                }
            };
            m.name = e[i].charAt(0);
            if (Character.isUpperCase(m.name)) {
                m.setChessColor(ChessColor.BLACK);
            } else if (Character.isLowerCase(m.name)) {
                m.setChessColor(ChessColor.WHITE);
            } else {
                m.setChessColor(ChessColor.NONE);
            }
            ChessboardPoint chessboardPoint = new ChessboardPoint(0, i);
            m.setSource(chessboardPoint);
            chessComponents[4][i] = m;
        }
        for (int i = 0; i < 8; i++) {
            ChessComponent m = new ChessComponent() {
                @Override
                public List<ChessboardPoint> canMoveTo() {
                    return null;
                }
            };
            m.name = f[i].charAt(0);
            if (Character.isUpperCase(m.name)) {
                m.setChessColor(ChessColor.BLACK);
            } else if (Character.isLowerCase(m.name)) {
                m.setChessColor(ChessColor.WHITE);
            } else {
                m.setChessColor(ChessColor.NONE);
            }
            ChessboardPoint chessboardPoint = new ChessboardPoint(0, i);
            m.setSource(chessboardPoint);
            chessComponents[5][i] = m;
        }
        for (int i = 0; i < 8; i++) {
            ChessComponent m = new ChessComponent() {
                @Override
                public List<ChessboardPoint> canMoveTo() {
                    return null;
                }
            };
            m.name = g[i].charAt(0);
            if (Character.isUpperCase(m.name)) {
                m.setChessColor(ChessColor.BLACK);
            } else if (Character.isLowerCase(m.name)) {
                m.setChessColor(ChessColor.WHITE);
            } else {
                m.setChessColor(ChessColor.NONE);
            }
            ChessboardPoint chessboardPoint = new ChessboardPoint(0, i);
            m.setSource(chessboardPoint);
            chessComponents[6][i] = m;
        }
        for (int i = 0; i < 8; i++) {
            ChessComponent m = new ChessComponent() {
                @Override
                public List<ChessboardPoint> canMoveTo() {
                    return null;
                }
            };
            m.name = h[i].charAt(0);
            if (Character.isUpperCase(m.name)) {
                m.setChessColor(ChessColor.BLACK);
            } else if (Character.isLowerCase(m.name)) {
                m.setChessColor(ChessColor.WHITE);
            } else {
                m.setChessColor(ChessColor.NONE);
            }
            ChessboardPoint chessboardPoint = new ChessboardPoint(0, i);
            m.setSource(chessboardPoint);
            chessComponents[7][i] = m;
        }


    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        String a = "";
        String b = "";
        String c = "";
        String d = "";
        String e = "";
        String f = "";
        String g = "";
        String h = "";
        for (int i = 0; i < 8; i++) {
            a = a + chessComponents[0][i].toString();
            b = b + chessComponents[1][i].toString();
            c = c + chessComponents[2][i].toString();
            d = d + chessComponents[3][i].toString();
            e = e + chessComponents[4][i].toString();
            f = f + chessComponents[5][i].toString();
            g = g + chessComponents[6][i].toString();
            h = h + chessComponents[7][i].toString();
        }
        return a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n" + h;
    }

    public String getCapturedChess(ChessColor player) {
        int k = 0;
        int q = 0;
        int b = 0;
        int n = 0;
        int r = 0;
        int p = 0;
        String a = "";
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("K")) {
                        k++;
                    }
                    if (chessComponents[i][j].toString().equals("Q")) {
                        q++;
                    }
                    if (chessComponents[i][j].toString().equals("B")) {
                        b++;
                    }
                    if (chessComponents[i][j].toString().equals("N")) {
                        n++;
                    }
                    if (chessComponents[i][j].toString().equals("R")) {
                        r++;
                    }
                    if (chessComponents[i][j].toString().equals("P")) {
                        p++;
                    }
                }
            }
        }
        if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].toString().equals("k")) {
                        k++;
                    }
                    if (chessComponents[i][j].toString().equals("q")) {
                        q++;
                    }
                    if (chessComponents[i][j].toString().equals("b")) {
                        b++;
                    }
                    if (chessComponents[i][j].toString().equals("n")) {
                        n++;
                    }
                    if (chessComponents[i][j].toString().equals("r")) {
                        r++;
                    }
                    if (chessComponents[i][j].toString().equals("p")) {
                        p++;
                    }
                }
            }
        }
        if (player == ChessColor.BLACK) {
            if (k < 1) {
                a = a + "K 1\n";
            }
            if (q < 1) {
                a = a + "Q 1\n";
            }
            if (r < 2) {
                a = a + "R " + (2 - r) + "\n";
            }
            if (b < 2) {
                a = a + "B " + (2 - b) + "\n";
            }
            if (n < 2) {
                a = a + "N " + (2 - n) + "\n";
            }
            if (p < 8) {
                a = a + "P " + (8 - p) + "\n";
            }
        }
        if (player == ChessColor.WHITE) {
            if (k < 1) {
                a = a + "k 1\n";
            }
            if (q < 1) {
                a = a + "q 1\n";
            }
            if (r < 2) {
                a = a + "r " + (2 - r) + "\n";
            }
            if (b < 2) {
                a = a + "b " + (2 - b) + "\n";
            }
            if (n < 2) {
                a = a + "n " + (2 - n) + "\n";
            }
            if (p < 8) {
                a = a + "p " + (8 - p) + "\n";
            }
        }
        if (player == ChessColor.NONE) {
            a = null;
        }
        return a;
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent a = chessComponents[sourceX][sourceY];
        ChessComponent c = chessComponents[targetX][targetY];
        boolean b = false;
        if (currentPlayer == ChessColor.BLACK && a.getChessColor() == ChessColor.BLACK) {
            b = true;
        } else if (currentPlayer == ChessColor.WHITE && a.getChessColor() == ChessColor.WHITE) {
            b = true;
        } else {
            b = false;
        }
        if (b) {
            a.setSource(targetX, targetY);
            c.setSource(sourceX, sourceY);
            c.name = '_';
            c.setChessColor(ChessColor.NONE);
        }
        return b;
    }

    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        ChessComponent chess =chessComponents[x][y];
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        if (chess.toString().equals("K")||chess.toString().equals("k")){
            chess=new KingChessComponent();


        }
        canMovePoints=chess.canMoveTo();
        return canMovePoints;
    }}
