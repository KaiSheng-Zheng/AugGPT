import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents = new ChessComponent[8][8];
        this.currentPlayer = ChessColor.WHITE;
//        chessComponents [0][0] = new RookChessComponent(new ChessboardPoint(0,0),ChessColor.BLACK,'R',this.chessComponents ) ;
//        chessComponents [0][7] = new RookChessComponent(new ChessboardPoint(0,7),ChessColor.BLACK,'R',this.chessComponents) ;
//        chessComponents [7][0] = new RookChessComponent(new ChessboardPoint(7,0),ChessColor.WHITE,'r',) ;
//        chessComponents [7][7] = new RookChessComponent(new ChessboardPoint(7,7),ChessColor.WHITE,'r') ;
//        chessComponents [0][1] = new KnightChessComponent(new ChessboardPoint(0,1),ChessColor.BLACK,'N') ;
//        chessComponents [0][6] = new KnightChessComponent(new ChessboardPoint(0,7),ChessColor.BLACK,'N') ;
//        chessComponents [7][1] = new KnightChessComponent(new ChessboardPoint(7,1),ChessColor.WHITE,'n') ;
//        chessComponents [7][6] = new KnightChessComponent(new ChessboardPoint(7,7),ChessColor.WHITE,'n') ;
//        chessComponents [0][2] = new BishopChessComponent(new ChessboardPoint(0,2),ChessColor.BLACK,'B') ;
//        chessComponents [0][5] = new BishopChessComponent(new ChessboardPoint(0,5),ChessColor.BLACK,'B') ;
//        chessComponents [7][2] = new BishopChessComponent(new ChessboardPoint(7,2),ChessColor.WHITE ,'b') ;
//        chessComponents [7][5] = new BishopChessComponent(new ChessboardPoint(7,5),ChessColor.WHITE ,'b') ;
//        chessComponents [0][3] = new QueenChessComponent(new ChessboardPoint(0,3),ChessColor.BLACK,'Q') ;
//        chessComponents [0][4] = new KingChessComponent(new ChessboardPoint(0,4),ChessColor.BLACK,'K') ;
//        chessComponents [7][3] = new QueenChessComponent(new ChessboardPoint(7,3),ChessColor.WHITE,'q') ;
//        chessComponents [7][4] = new KingChessComponent(new ChessboardPoint(7,4),ChessColor.WHITE,'k') ;
//        for (int i = 0; i < 8; i++) {
//            chessComponents [1][i] = new PawnChessComponent(new ChessboardPoint(1,i),ChessColor.BLACK,'P' ) ;
//            chessComponents [6][i] = new PawnChessComponent(new ChessboardPoint(6,i),ChessColor.WHITE,'p' ) ;
//        }
//        for (int i = 2; i < 6; i++) {
//            for (int j = 0; j < 8; j++) {
//                chessComponents [i][j] = new EmptySlotChessComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_' ) ;
//            }
//        }
    }

    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char c = chessboard.get(i).charAt(j);
                if (c == 'R') {
                    RookChessComponent chess = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == 'N') {
                    KnightChessComponent chess = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == 'B') {
                    BishopChessComponent chess = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == 'Q') {
                    QueenChessComponent chess = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == 'P') {
                    PawnChessComponent chess = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == 'K') {
                    KingChessComponent chess = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.BLACK, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == 'r') {
                    RookChessComponent chess = new RookChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == 'n') {
                    KnightChessComponent chess = new KnightChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == 'b') {
                    BishopChessComponent chess = new BishopChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == 'q') {
                    QueenChessComponent chess = new QueenChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == 'k') {
                    KingChessComponent chess = new KingChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == 'p') {
                    PawnChessComponent chess = new PawnChessComponent(new ChessboardPoint(i, j), ChessColor.WHITE, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
                if (c == '_') {
                    EmptySlotChessComponent chess = new EmptySlotChessComponent(new ChessboardPoint(i, j), ChessColor.NONE, c, this.chessComponents);
                    chessComponents[i][j] = chess;
                }
            }
        }
        String color = chessboard.get(8);
        if (color.equals("b")) {
            this.currentPlayer = ChessColor.BLACK;
        } else {
            this.currentPlayer = ChessColor.WHITE;
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
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                result.append(chessComponents[i][j].name);
            }
            result.append("\n");
        }
        String s = "" + result;
        return s;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        int have[] = new int[6];
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'K') {
                        have[0] = ++have[0];
                    } else if (chessComponents[i][j].name == 'Q') {
                        have[1] = ++have[1];
                    } else if (chessComponents[i][j].name == 'R') {
                        have[2] = ++have[2];
                    } else if (chessComponents[i][j].name == 'B') {
                        have[3] = ++have[3];
                    } else if (chessComponents[i][j].name == 'N') {
                        have[4] = ++have[4];
                    } else if (chessComponents[i][j].name == 'P') {
                        have[5] = ++have[5];
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].name == 'k') {
                        have[0] = ++have[0];
                    } else if (chessComponents[i][j].name == 'q') {
                        have[1] = ++have[1];
                    } else if (chessComponents[i][j].name == 'r') {
                        have[2] = ++have[2];
                    } else if (chessComponents[i][j].name == 'b') {
                        have[3] = ++have[3];
                    } else if (chessComponents[i][j].name == 'n') {
                        have[4] = ++have[4];
                    } else if (chessComponents[i][j].name == 'p') {
                        have[5] = ++have[5];
                    }
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        if (player == ChessColor.BLACK) {
            if (1 - have[0] != 0) {
                sb.append("K ");
                sb.append(1 - have[0]);
                sb.append("\n");
//                    s.concat("K ") ;
//                    s.concat(String.valueOf(1-have[0])) ;
//                    s.concat("\n") ;
            }
            if (1 - have[1] != 0) {
                sb.append("Q ");
                sb.append(1 - have[1]);
                sb.append("\n");
            }
            if (2 - have[2] != 0) {
                sb.append("R ");
                sb.append(2 - have[2]);
                sb.append("\n");
            }
            if (2 - have[3] != 0) {
                sb.append("B ");
                sb.append(2 - have[3]);
                sb.append("\n");
            }
            if (2 - have[4] != 0) {
                sb.append("N ");
                sb.append(2 - have[4]);
                sb.append("\n");
            }
            if (8 - have[5] != 0) {
                sb.append("P ");
                sb.append(8 - have[5]);
                sb.append("\n");
            }
        } else {
            if (1 - have[0] != 0) {
                sb.append("k ");
                sb.append(1 - have[0]);
                sb.append("\n");
//                    s.concat("K ") ;
//                    s.concat(String.valueOf(1-have[0])) ;
//                    s.concat("\n") ;
            }
            if (1 - have[1] != 0) {
                sb.append("q ");
                sb.append(1 - have[1]);
                sb.append("\n");
            }
            if (2 - have[2] != 0) {
                sb.append("r ");
                sb.append(2 - have[2]);
                sb.append("\n");
            }
            if (2 - have[3] != 0) {
                sb.append("b ");
                sb.append(2 - have[3]);
                sb.append("\n");
            }
            if (2 - have[4] != 0) {
                sb.append("n ");
                sb.append(2 - have[4]);
                sb.append("\n");
            }
            if (8 - have[5] != 0) {
                sb.append("p ");
                sb.append(8 - have[5]);
                sb.append("\n");
            }
        }
        return sb.toString();
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x1 = source.getX();
        int y1 = source.getY();
        ChessComponent j = this.chessComponents[x1][y1];
        List<ChessboardPoint> canMovePoints = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int k = 0; k < 8; k++) {
                ChessboardPoint point = new ChessboardPoint(i, k);
                for (int l = 0; l < j.canMoveTo().size(); l++) {
                    if (j.canMoveTo().get(l).getX() == point.getX() && j.canMoveTo().get(l).getY() == point.getY()) {
                        canMovePoints.add(point);
                    }
                }
            }
        }
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (new ChessboardPoint(sourceX, sourceY).offset(0, 0) != null && new ChessboardPoint(targetX, targetY).offset(0, 0) != null) {
            ChessComponent j = this.chessComponents[sourceX][sourceY];
            if (j.getChessColor() == currentPlayer) {
                if (j.canMoveTo().size() != 0) {
                    for (int i = 0; i < j.canMoveTo().size(); i++) {
                        if (j.canMoveTo().get(i).getX() == targetX && j.canMoveTo().get(i).getY() == targetY) {
                            if (this.chessComponents[targetX][targetY].getChessColor() != j.getChessColor()) {
                                    //eat
                                    j.setSource(new ChessboardPoint(targetX, targetY));
                                    this.chessComponents[targetX][targetY] = j;
                                    this.chessComponents[sourceX][sourceY] = new EmptySlotChessComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
                                    for (int h = 0; h < 8; h++) {
                                        for (int k = 0; k < 8; k++) {
                                            chessComponents[h][k].setChessComponents(this.chessComponents);
                                        }
                                    }
                                    if (this.currentPlayer == ChessColor.BLACK) {
                                        setCurrentPlayer(ChessColor.WHITE);
                                    } else if (this.currentPlayer == ChessColor.WHITE) {
                                        setCurrentPlayer(ChessColor.BLACK);
                                    }
                                    return true;
                            }
                        }
                    }
                }
                else {
                    return false;
                }
            }
            else {
                return false;
            }
        }
        else {
            return false;
        }
        return false;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
}
