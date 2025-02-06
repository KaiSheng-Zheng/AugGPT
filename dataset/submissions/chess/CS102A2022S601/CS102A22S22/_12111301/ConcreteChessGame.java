import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                char ch = chessboard.get(i).charAt(j);
                switch (ch) {
                    case 'R':
                        RookChessComponent ch1 = new RookChessComponent(new ChessboardPoint(i, j),chessComponents, ChessColor.BLACK, 'R');
                        chessComponents[i][j] = ch1;
                        break;
                    case 'N':
                        KnightChessComponent ch2 = new KnightChessComponent(new ChessboardPoint(i, j),chessComponents, ChessColor.BLACK, 'N');
                        chessComponents[i][j] = ch2;
                        break;
                    case 'B':
                        BishopChessComponent ch3 = new BishopChessComponent(new ChessboardPoint(i, j), chessComponents,ChessColor.BLACK, 'B');
                        chessComponents[i][j] = ch3;
                        break;
                    case 'Q':
                        QueenChessComponent ch4 = new QueenChessComponent(new ChessboardPoint(i, j),chessComponents, ChessColor.BLACK, 'Q');
                        chessComponents[i][j] = ch4;
                        break;
                    case 'K':
                        KingChessComponent ch5 = new KingChessComponent(new ChessboardPoint(i, j),chessComponents, ChessColor.BLACK, 'K');
                        chessComponents[i][j] = ch5;
                        break;
                    case 'P':
                        PawnChessComponent ch6 = new PawnChessComponent(new ChessboardPoint(i, j),chessComponents, ChessColor.BLACK, 'P');
                        chessComponents[i][j] = ch6;
                        break;
                    case '_':
                        EmptySlotComponent ch7 = new EmptySlotComponent(new ChessboardPoint(i, j), chessComponents,ChessColor.NONE, '_');
                        chessComponents[i][j] = ch7;
                        break;
                    case 'r':
                        RookChessComponent ch8 = new RookChessComponent(new ChessboardPoint(i, j),chessComponents, ChessColor.WHITE, 'r');
                        chessComponents[i][j] = ch8;
                        break;
                    case 'n':
                        KnightChessComponent ch9 = new KnightChessComponent(new ChessboardPoint(i, j), chessComponents,ChessColor.WHITE, 'n');
                        chessComponents[i][j] = ch9;
                        break;
                    case 'b':
                        BishopChessComponent ch10 = new BishopChessComponent(new ChessboardPoint(i, j),chessComponents, ChessColor.WHITE, 'b');
                        chessComponents[i][j] = ch10;
                        break;
                    case 'q':
                        QueenChessComponent ch11 = new QueenChessComponent(new ChessboardPoint(i, j),chessComponents, ChessColor.WHITE, 'q');
                        chessComponents[i][j] = ch11;
                        break;
                    case 'k':
                        KingChessComponent ch12 = new KingChessComponent(new ChessboardPoint(i, j), chessComponents,ChessColor.WHITE, 'k');
                        chessComponents[i][j] = ch12;
                        break;
                    case 'p':
                        PawnChessComponent ch13 = new PawnChessComponent(new ChessboardPoint(i, j), chessComponents,ChessColor.WHITE, 'p');
                        chessComponents[i][j] = ch13;
                        break;
                }
            }
        }
        if (chessboard.get(8).equals("w")) {
            this.currentPlayer = ChessColor.WHITE;
        } else this.currentPlayer = ChessColor.BLACK;

    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph() {
        StringBuilder nb = new StringBuilder();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                nb.append(chessComponents[i][j].name);
            }
            nb.append("\n");
        }
        String abc = "" + nb;
        return abc;
    }


    public String getCapturedChess(ChessColor player) {
        int cao[] = new int[6];
        int tou[] = new int[6];
        if (player == ChessColor.BLACK) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'K':
                            cao[0]++;
                            break;
                        case 'Q':
                            cao[1]++;
                            break;
                        case 'R':
                            cao[2]++;
                            break;
                        case 'B':
                            cao[3]++;
                            break;
                        case 'N':
                            cao[4]++;
                            break;
                        case 'P':
                            cao[5]++;
                            break;
                    }
                }
            }
        } else {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'k':
                            tou[0]++;
                            break;
                        case 'q':
                            tou[1]++;
                            break;
                        case 'r':
                            tou[2]++;
                            break;
                        case 'b':
                            tou[3]++;
                            break;
                        case 'n':
                            tou[4]++;
                            break;
                        case 'p':
                            tou[5]++;
                            break;
                    }
                }
            }
        }
        StringBuilder md = new StringBuilder();
        if (player == ChessColor.BLACK) {
            if (cao[0] == 0) {
                md.append("K ");
                md.append(1);
                md.append("\n");
            }
            if (cao[1] == 0) {
                md.append("Q ");
                md.append(1);
                md.append("\n");
            }
            if (cao[2] != 2) {
                md.append("R ");
                md.append(2 - cao[2]);
                md.append("\n");
            }
            if (cao[3] != 2) {
                md.append("B ");
                md.append(2 - cao[3]);
                md.append("\n");
            }
            if (cao[4] != 2) {
                md.append("N ");
                md.append(2 - cao[4]);
                md.append("\n");
            }
            if (cao[5] != 8) {
                md.append("P ");
                md.append(8 - cao[5]);
                md.append("\n");
            }
        } else {
            if (tou[0] == 0) {
                md.append("k ");
                md.append(1);
                md.append("\n");
            }
            if (tou[1] == 0) {
                md.append("q ");
                md.append(1);
                md.append("\n");
            }
            if (tou[2] != 2) {
                md.append("r ");
                md.append(2 - tou[2]);
                md.append("\n");
            }
            if (tou[3] != 2) {
                md.append("b ");
                md.append(2 - tou[3]);
                md.append("\n");
            }
            if (tou[4] != 2) {
                md.append("n ");
                md.append(2 - tou[4]);
                md.append("\n");
            }
            if (tou[5] != 8) {
                md.append("p ");
                md.append(8 - tou[5]);
                md.append("\n");
            }
        }
        return md.toString();
    }

    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess = chessComponents[source.getX()][source.getY()];
        List<ChessboardPoint> canMovePoints = chess.canMoveTo();
        canMovePoints.sort(Comparator.comparing(ChessboardPoint::getX).thenComparing(ChessboardPoint::getY));
        if (currentPlayer == ChessColor.BLACK) {
            currentPlayer = ChessColor.WHITE;
        } else currentPlayer = ChessColor.BLACK;

        return canMovePoints;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(targetX<0||targetY<0||targetX>7||targetY>7||sourceX<0||sourceY<0||sourceX>7||sourceY>7||chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer) {
            return  false;
        }
        List<ChessboardPoint> sb=chessComponents[sourceX][sourceY].canMoveTo();
        if(chessComponents[sourceX][sourceY].getChessColor() == currentPlayer
        && chessComponents[targetX][targetY].getChessColor() != currentPlayer){
            for(int i=0;i<sb.size();i++)
            {
                if(sb.get(i).getX()==targetX&&sb.get(i).getY()==targetY) {
                    if(currentPlayer==ChessColor.WHITE){
                        currentPlayer=ChessColor.BLACK;
                    }
                    else{
                        currentPlayer=ChessColor.WHITE;
                    }
                    chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),chessComponents,ChessColor.NONE,'_');
                    return true;
                }
            }
        }
        return false;
    }


}
