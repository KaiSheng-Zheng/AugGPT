import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j) == 'R') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    RookChessComponent a = new RookChessComponent(this.chessComponents, k);
                    a.setName('R');
                    a.setChessColor(ChessColor.BLACK);

                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    KnightChessComponent a = new KnightChessComponent(this.chessComponents, k);
                    a.setName('N');
                    a.setChessColor(ChessColor.BLACK);

                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    BishopChessComponent a = new BishopChessComponent(this.chessComponents, k);
                    a.setName('B');
                    a.setChessColor(ChessColor.BLACK);

                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    QueenChessComponent a = new QueenChessComponent(this.chessComponents, k);
                    a.setName('Q');
                    a.setChessColor(ChessColor.BLACK);

                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == 'K') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    KingChessComponent a = new KingChessComponent(this.chessComponents, k);
                    a.setName('K');
                    a.setChessColor(ChessColor.BLACK);

                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    PawnChessComponent a = new PawnChessComponent(this.chessComponents, k);
                    a.setName('P');
                    a.setChessColor(ChessColor.BLACK);

                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == '_') {
                    EmptySlotComponent a = new EmptySlotComponent();
                    a.setName('_');
                    a.setChessColor(ChessColor.NONE);

                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == 'p') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    PawnChessComponent a = new PawnChessComponent(this.chessComponents, k);
                    a.setName('p');
                    a.setChessColor(ChessColor.WHITE);
                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == 'r') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    RookChessComponent a = new RookChessComponent(this.chessComponents, k);
                    a.setName('r');
                    a.setChessColor(ChessColor.WHITE);

                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == 'n') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    KnightChessComponent a = new KnightChessComponent(this.chessComponents, k);
                    a.setName('n');
                    a.setChessColor(ChessColor.WHITE);

                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == 'b') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    BishopChessComponent a = new BishopChessComponent(this.chessComponents, k);
                    a.setName('b');
                    a.setChessColor(ChessColor.WHITE);

                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == 'q') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    QueenChessComponent a = new QueenChessComponent(this.chessComponents, k);
                    a.setName('q');
                    a.setChessColor(ChessColor.WHITE);

                    chessComponents[i][j] = a;
                } else if (chessboard.get(i).charAt(j) == 'k') {
                    ChessboardPoint k = new ChessboardPoint(i, j);
                    KingChessComponent a = new KingChessComponent(this.chessComponents, k);
                    a.setName('k');
                    a.setChessColor(ChessColor.WHITE);

                    chessComponents[i][j] = a;
                }
            }
            if (chessboard.get(8).charAt(0) == 'w') {
                currentPlayer = ChessColor.WHITE;
            } else if (chessboard.get(8).charAt(0) == 'b') {
                currentPlayer = ChessColor.BLACK;
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
        String a = "", b = "", c = "", d = "", e = "", f = "", g = "", h = "";
        for (int i = 0; i < 8; i++) {
            a = a + chessComponents[0][i].getName();
        }
        for (int i = 0; i < 8; i++) {
            b = b + chessComponents[1][i].getName();
        }
        for (int i = 0; i < 8; i++) {
            c = c + chessComponents[2][i].getName();
        }
        for (int i = 0; i < 8; i++) {
            d = d + chessComponents[3][i].getName();
        }
        for (int i = 0; i < 8; i++) {
            e = e + chessComponents[4][i].getName();
        }
        for (int i = 0; i < 8; i++) {
            f = f + chessComponents[5][i].getName();
        }
        for (int i = 0; i < 8; i++) {
            g = g + chessComponents[6][i].getName();
        }
        for (int i = 0; i < 8; i++) {
            h = h + chessComponents[7][i].getName();
        }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s", a, b, c, d, e, f, g, h);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int a = 0, b = 0, c = 0, d = 0, e = 0, f = 0;
        String A = "";
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'R') {
                        a++;
                    } else if (chessComponents[i][j].getName() == 'N') {
                        b++;
                    } else if (chessComponents[i][j].getName() == 'B') {
                        c++;
                    } else if (chessComponents[i][j].getName() == 'Q') {
                        d++;
                    } else if (chessComponents[i][j].getName() == 'K') {
                        e++;
                    } else if (chessComponents[i][j].getName() == 'P') {
                        f++;
                    }
                }
            }
            if (e != 1) {
                e = 1 - e;
                A = A + "K" + " " + e + "\n";
            } else {
                A = A + "";
            }
            if (d != 1) {
                d = 1 - d;
                A = A + "Q" + " " + d + "\n";
            } else {
                A = A + "";
            }
            if (a != 2) {
                a = 2 - a;
                A = A + "R" + " " + a + "\n";
            } else {
                A = A + "";
            }
            if (c != 2) {
                c = 2 - c;
                A = A + "B" + " " + c + "\n";
            } else {
                A = A + "";
            }
            if (b != 2) {
                b = 2 - b;
                A = A + "N" + " " + b + "\n";
            } else {
                A = A + "";
            }
            if (f != 8) {
                f = 8 - f;
                A = A + "P" + " " + f + "\n";
            } else {
                A = A + "";
            }
        } else if (player == ChessColor.WHITE) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName() == 'r') {
                        a++;
                    } else if (chessComponents[i][j].getName() == 'n') {
                        b++;
                    } else if (chessComponents[i][j].getName() == 'b') {
                        c++;
                    } else if (chessComponents[i][j].getName() == 'q') {
                        d++;
                    } else if (chessComponents[i][j].getName() == 'k') {
                        e++;
                    } else if (chessComponents[i][j].getName() == 'p') {
                        f++;
                    }
                }
            }
            if (e != 1) {
                e = 1 - e;
                A = A + "k" + " " + e + "\n";
            } else {
                A = A + "";
            }
            if (d != 1) {
                d = 1 - d;
                A = A + "q" + " " + d + "\n";
            } else {
                A = A + "";
            }
            if (a != 2) {
                a = 2 - a;
                A = A + "r" + " " + a + "\n";
            } else {
                A = A + "";
            }
            if (c != 2) {
                c = 2 - c;
                A = A + "b" + " " + c + "\n";
            } else {
                A = A + "";
            }
            if (b != 2) {
                b = 2 - b;
                A = A + "n" + " " + b + "\n";
            } else {
                A = A + "";
            }
            if (f != 8) {
                f = 8 - f;
                A = A + "p" + " " + f + "\n";
            } else {
                A = A + "";
            }
        }
        return A;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        ChessComponent chess = chessComponents[x][y];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
            for (int i = 0; i < canMovePoints.size(); i++) {
                for (int j = 0; j < i; j++) {
                    if (canMovePoints.get(i).getX() < canMovePoints.get(j).getX()) {
                        ChessboardPoint temp = canMovePoints.get(i);
                        canMovePoints.set(i, canMovePoints.get(j));
                        canMovePoints.set(j, temp);
                    } else if (canMovePoints.get(i).getX() == canMovePoints.get(j).getX()) {
                        if (canMovePoints.get(i).getY() < canMovePoints.get(j).getY()) {
                            ChessboardPoint temp = canMovePoints.get(i);
                            canMovePoints.set(i, canMovePoints.get(j));
                            canMovePoints.set(j, temp);
                        }
                    }
                }
            }
            return canMovePoints;
            }
     @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        ChessComponent source = chessComponents[sourceX][sourceY];
        ChessboardPoint chessboardPoint=new ChessboardPoint(targetX,targetY);
        List canMoveTo = source.canMoveTo();
        String target = "("+targetX+","+targetY+")";
        if(currentPlayer==source.chessColor&&source.chessColor == ChessColor.WHITE){
            for (Object o : canMoveTo) {
                if (o.toString().equals(target)) {
                    source.setSource(chessboardPoint);
                    ChessboardPoint sourceChessboardPoint = new ChessboardPoint(sourceX, sourceY);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[targetX][targetY] = source;
                    currentPlayer = ChessColor.BLACK;
                    return true;
                }
            }
        } else if (currentPlayer == source.chessColor && source.chessColor == ChessColor.BLACK) {
            for (Object o : canMoveTo) {
                if (o.toString().equals(target)) {
                    source.setSource(chessboardPoint);
                    ChessboardPoint sourceChessboardPoint = new ChessboardPoint(sourceX, sourceY);
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[targetX][targetY] = source;
                    currentPlayer = ChessColor.WHITE;
                    return true;
                }
            }
        }
        return false;
    }


}

