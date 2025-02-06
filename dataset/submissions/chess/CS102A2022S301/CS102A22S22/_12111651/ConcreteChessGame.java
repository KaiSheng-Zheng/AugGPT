
import java.util.*;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        int k = 0;
        for (int i = 0; i < 8 ; i++) {
            for (int j = 0; j < chessboard.get(i).length(); j++) {
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'r') {
                    chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p',chessComponents);
                }
                if (chessboard.get(i).charAt(j) == '_') {
                    chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_',chessComponents);
                }
                k = i;
            }
        }

        k++;
        if (chessboard.get(8).charAt(0) == 'w') {
            this.currentPlayer = ChessColor.WHITE;
        }
        if (chessboard.get(8).charAt(0) == 'b') {
            this.currentPlayer = ChessColor.BLACK;
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
        return String.format("%s%s%s%s%s%s%s%s\n%s%s%s%s%s%s%s%s\n%s%s%s%s%s%s%s%s\n%s%s%s%s%s%s%s%s\n%s%s%s%s%s%s%s%s\n%s%s%s%s%s%s%s%s\n%s%s%s%s%s%s%s%s\n%s%s%s%s%s%s%s%s",
                chessComponents[0][0].name, chessComponents[0][1].name, chessComponents[0][2].name, chessComponents[0][3].name, chessComponents[0][4].name, chessComponents[0][5].name, chessComponents[0][6].name, chessComponents[0][7].name,
                chessComponents[1][0].name, chessComponents[1][1].name, chessComponents[1][2].name, chessComponents[1][3].name, chessComponents[1][4].name, chessComponents[1][5].name, chessComponents[1][6].name, chessComponents[1][7].name,
                chessComponents[2][0].name, chessComponents[2][1].name, chessComponents[2][2].name, chessComponents[2][3].name, chessComponents[2][4].name, chessComponents[2][5].name, chessComponents[2][6].name, chessComponents[2][7].name,
                chessComponents[3][0].name, chessComponents[3][1].name, chessComponents[3][2].name, chessComponents[3][3].name, chessComponents[3][4].name, chessComponents[3][5].name, chessComponents[3][6].name, chessComponents[3][7].name,
                chessComponents[4][0].name, chessComponents[4][1].name, chessComponents[4][2].name, chessComponents[4][3].name, chessComponents[4][4].name, chessComponents[4][5].name, chessComponents[4][6].name, chessComponents[4][7].name,
                chessComponents[5][0].name, chessComponents[5][1].name, chessComponents[5][2].name, chessComponents[5][3].name, chessComponents[5][4].name, chessComponents[5][5].name, chessComponents[5][6].name, chessComponents[5][7].name,
                chessComponents[6][0].name, chessComponents[6][1].name, chessComponents[6][2].name, chessComponents[6][3].name, chessComponents[6][4].name, chessComponents[6][5].name, chessComponents[6][6].name, chessComponents[6][7].name,
                chessComponents[7][0].name, chessComponents[7][1].name, chessComponents[7][2].name, chessComponents[7][3].name, chessComponents[7][4].name, chessComponents[7][5].name, chessComponents[7][6].name, chessComponents[7][7].name
        );
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int Bk = 0;
        int Bq = 0;
        int Br = 0;
        int Bb = 0;
        int Bn = 0;
        int Bp = 0;
        int Wk = 0;
        int Wq = 0;
        int Wr = 0;
        int Wb = 0;
        int Wn = 0;
        int Wp = 0;
        String sBk = null;
        String sBq = null;
        String sBr = null;
        String sBb = null;
        String sBn = null;
        String sBp = null;
        String sWk = null;
        String sWq = null;
        String sWr = null;
        String sWb = null;
        String sWn = null;
        String sWp = null;
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    if (chessComponents[i][j].name == 'K') Bk++;
                    if (chessComponents[i][j].name == 'Q') Bq++;
                    if (chessComponents[i][j].name == 'R') Br++;
                    if (chessComponents[i][j].name == 'B') Bb++;
                    if (chessComponents[i][j].name == 'N') Bn++;
                    if (chessComponents[i][j].name == 'P') Bp++;
                }
            }
            String str = "";
            if (Bk != 1) {
                sBk = "K " + (1 - Bk);
                str = str.concat(sBk) + "\n";
            }
            if (Bq != 1) {
                sBq = "Q " + (1 - Bq);
                str = str.concat(sBq) + "\n";
            }
            if (Br != 2) {
                sBr = "R " + (2 - Br);
                str = str.concat(sBr) + "\n";
            }
            if (Bb != 2) {
                sBb = "B " + (2 - Bb);
                str = str.concat(sBb) + "\n";
            }
            if (Bn != 2) {
                sBn = "N " + (2 - Bn);
                str = str.concat(sBn) + "\n";
            }
            if (Bp != 8) {
                sBp = "P " + (8 - Bp);
                str = str.concat(sBp) + "\n";
            }
            return str;

        }
        if(player == ChessColor.WHITE) {
            for (int i = 0; i < chessComponents.length; i++) {
                for (int j = 0; j < chessComponents[i].length; j++) {
                    if (chessComponents[i][j].name == 'k') Wk++;
                    if (chessComponents[i][j].name == 'q') Wq++;
                    if (chessComponents[i][j].name == 'r') Wr++;
                    if (chessComponents[i][j].name == 'b') Wb++;
                    if (chessComponents[i][j].name == 'n') Wn++;
                    if (chessComponents[i][j].name == 'p') Wp++;
                }
            }
            String str = "";
            if (Wk != 1) {
                sWk = "k " + (1 - Wk);
                str = str.concat(sWk) + "\n";
            }
            if (Wq != 1) {
                sWq = "q " + (1 - Wq);
                str = str.concat(sWq) + "\n";
            }
            if (Wr != 2) {
                sWr = "r " + (2 - Wr);
                str = str.concat(sWr) + "\n";
            }
            if (Wb != 2) {
                sWb = "b " + (2 - Wb);
                str = str.concat(sWb) + "\n";
            }
            if (Wn != 2) {
                sWn = "n " + (2 - Wn);
                str = str.concat(sWn) + "\n";
            }
            if (Wp != 8) {
                sWp = "p " + (8 - Wp);
                str = str.concat(sWp) + "\n";
            }
            return str;
        }
        return "";
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX();
        int y = source.getY();
        List<ChessboardPoint> canMovePoints = chessComponents[x][y].canMoveTo();
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() >= o2.getX()) {
                    return 1;
                } else {
                    return -1;
                }
            }
        });
        Collections.sort(canMovePoints, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() > o2.getX()) {
                    return 1;
                } else if (o1.getX() < o2.getX()) {
                    return -1;
                } else {
                    if (o1.getY() >= o2.getY()) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if( targetX >= 0 && targetX < 8 && targetY >= 0 && targetY < 8) {
            if (currentPlayer != chessComponents[sourceX][sourceY].getChessColor()) {
                return false;
            } else {
                if (chessComponents[sourceX][sourceY].getChessColor() != chessComponents[targetX][targetY].getChessColor()) {
                    ChessboardPoint source = new ChessboardPoint(sourceX, sourceY);
                    ChessboardPoint target = new ChessboardPoint(targetX,targetY);
                    List<ChessboardPoint> canMovePoints = getCanMovePoints(source);
                    for (int i = 0; i < canMovePoints.size(); i++) {
                        if (canMovePoints.get(i).getX() == targetX && canMovePoints.get(i).getY() == targetY) {
                            if (chessComponents[targetX][targetY].getChessColor() == ChessColor.NONE) {
                                char nameT = chessComponents[targetX][targetY].name;
                                char nameS = chessComponents[sourceX][sourceY].name;
                                chessComponents[targetX][targetY] = createnewComponent(target,nameS);
                                chessComponents[sourceX][sourceY] = createnewComponent(source,nameT);
                            } else {
                                char nameT = chessComponents[targetX][targetY].name;
                                char nameS = chessComponents[sourceX][sourceY].name;
                                chessComponents[targetX][targetY] = createnewComponent(target,nameS);
                                chessComponents[sourceX][sourceY] = new EmptySlotComponent(source, ChessColor.NONE, '_', chessComponents);
                            }
                            if (currentPlayer == ChessColor.BLACK) {
                                currentPlayer = ChessColor.WHITE;
                            } else {
                                currentPlayer = ChessColor.BLACK;
                            }
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }

    public ChessComponent createnewComponent (ChessboardPoint point, Character name){
        int i = point.getX();
        int j = point.getY();

        if (name == 'K') {
            chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'K',chessComponents);
        }
        if (name == 'k') {
            chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'k',chessComponents);
        }
        if (name == 'Q') {
            chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'Q',chessComponents);
        }
        if (name == 'q') {
            chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'q',chessComponents);
        }
        if (name == 'R') {
            chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'R',chessComponents);
        }
        if (name == 'r') {
            chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'r',chessComponents);
        }
        if (name == 'B') {
            chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'B',chessComponents);
        }
        if (name == 'b') {
            chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'b',chessComponents);
        }
        if (name == 'N') {
            chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'N',chessComponents);
        }
        if (name == 'n') {
            chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'n',chessComponents);
        }
        if (name == 'P') {
            chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, 'P',chessComponents);
        }
        if (name == 'p') {
            chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, 'p',chessComponents);
        }
        if (name == '_') {
            chessComponents[i][j] = new EmptySlotComponent(new ChessboardPoint(i, j), ChessColor.NONE, '_',chessComponents);
        }

        return chessComponents[i][j];
    }
}



