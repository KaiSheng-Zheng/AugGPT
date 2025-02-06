import java.util.ArrayList;
import java.util.List;

public class ConcreteChessGame  implements ChessGame{

    private  ChessComponent[][] chessComponents;
    private ChessColor currentPlayer ;
    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        for(int i=0;i<8;i++) {
            for(int j=0;j<8;j++) {
                chessComponents[i][j] = new ChessComponent() {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return null;
                    }

                };
            }
        }
        currentPlayer = ChessColor.WHITE;
    }
    public void loadChessGame (List<String> chessboard) {
        if(chessboard.size()==9) {
            for (int i = 0; i < 8; i++) {
                if (chessboard.get(i).length() == 8) {
                    for (int j = 0; j < 8; j++) {
                        if (chessboard.get(i).charAt(j) >= 'A' && chessboard.get(i).charAt(j) <= 'Z') {
                            if(chessboard.get(i).charAt(j) == 'R') chessComponents[i][j] = new RookChessComponent();
                            if(chessboard.get(i).charAt(j) == 'N') chessComponents[i][j] = new KnightChessComponent();
                            if(chessboard.get(i).charAt(j) == 'B') chessComponents[i][j] = new BishopChessComponent();
                            if(chessboard.get(i).charAt(j) == 'Q') chessComponents[i][j] = new QueenChessComponent();
                            if(chessboard.get(i).charAt(j) == 'K') chessComponents[i][j] = new KingChessComponent();
                            if(chessboard.get(i).charAt(j) == 'P') chessComponents[i][j] = new PawnChessComponent();
                            chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                            chessComponents[i][j].setchessColor(ChessColor.BLACK);
                            chessComponents[i][j].setSource(i,j);
                        } else if (chessboard.get(i).charAt(j) >= 'a' && chessboard.get(i).charAt(j) <= 'z') {
                            if(chessboard.get(i).charAt(j) == 'r') chessComponents[i][j] = new RookChessComponent();
                            if(chessboard.get(i).charAt(j) == 'n') chessComponents[i][j] = new KnightChessComponent();
                            if(chessboard.get(i).charAt(j) == 'b') chessComponents[i][j] = new BishopChessComponent();
                            if(chessboard.get(i).charAt(j) == 'q') chessComponents[i][j] = new QueenChessComponent();
                            if(chessboard.get(i).charAt(j) == 'k') chessComponents[i][j] = new KingChessComponent();
                            if(chessboard.get(i).charAt(j) == 'p') chessComponents[i][j] = new PawnChessComponent();
                            chessComponents[i][j].setName(chessboard.get(i).charAt(j));
                            chessComponents[i][j].setchessColor(ChessColor.WHITE);
                            chessComponents[i][j].setSource(i,j);
                        }
                        else if(chessboard.get(i).charAt(j)=='_') {
                            chessComponents[i][j] = new EmptySlotComponent() {
                            };
                            chessComponents[i][j].setName('_');
                            chessComponents[i][j].setchessColor(ChessColor.NONE);
                            chessComponents[i][j].setSource(i,j);
                        }
                    }
                }
            }

            if (chessboard.get(8).charAt(0) == 'w') currentPlayer = ChessColor.WHITE;
            else if (chessboard.get(8).charAt(0) == 'b') currentPlayer = ChessColor.BLACK;
        }
    }
    //@Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }
    public String getChessboardGraph() {
        StringBuffer a1 = new StringBuffer(); StringBuffer a2 = new StringBuffer();
        StringBuffer a3 = new StringBuffer(); StringBuffer a4 = new StringBuffer();
        StringBuffer a5 = new StringBuffer(); StringBuffer a6 = new StringBuffer();
        StringBuffer a7 = new StringBuffer(); StringBuffer a8 = new StringBuffer();
        for(int i=0;i<8;i++) {
            if(chessComponents[0][i].name=='_') a1.append('_');
            else a1.append(chessComponents[0][i].name);
        }
        for(int i=0;i<8;i++) {
            if(chessComponents[1][i].name=='_') a2.append('_');
            else a2.append(chessComponents[1][i].name);
        }
        for(int i=0;i<8;i++) {
            if(chessComponents[2][i].name=='_') a3.append('_');
            else a3.append(chessComponents[2][i].name);
        }
        for(int i=0;i<8;i++) {
            if(chessComponents[3][i].name=='_') a4.append('_');
            else a4.append(chessComponents[3][i].name);
        }
        for(int i=0;i<8;i++) {
            if(chessComponents[4][i].name=='_') a5.append('_');
            else a5.append(chessComponents[4][i].name);
        }
        for(int i=0;i<8;i++) {
            if(chessComponents[5][i].name=='_') a6.append('_');
            else a6.append(chessComponents[5][i].name);
        }
        for(int i=0;i<8;i++) {
            if(chessComponents[6][i].name=='_') a7.append('_');
            else a7.append(chessComponents[6][i].name);
        }
        for(int i=0;i<8;i++) {
            if(chessComponents[7][i].name=='_') a8.append('_');
            else a8.append(chessComponents[7][i].name);
        }
        String b1 = a1.toString(); String b2 = a2.toString();
        String b3 = a3.toString(); String b4 = a4.toString();
        String b5 = a5.toString(); String b6 = a6.toString();
        String b7 = a7.toString(); String b8 = a8.toString();

        return b1+"\n"+b2+"\n"+b3+"\n"+b4+"\n"+b5+"\n"+b6+"\n"+b7+"\n"+b8+"\n";
    }
    public String getCapturedChess(ChessColor player) {
        int kk=0,qq=0,rr=0,bb=0,kn=0,pp=0;
        if(player == ChessColor.BLACK) {
            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    if(chessComponents[i][j].name == 'K') kk++;
                    else if(chessComponents[i][j].name == 'Q') qq++;
                    else if(chessComponents[i][j].name == 'R') rr++;
                    else if(chessComponents[i][j].name == 'B') bb++;
                    else if(chessComponents[i][j].name == 'N') kn++;
                    else if(chessComponents[i][j].name == 'P') pp++;
                }
            }
            StringBuffer a = new StringBuffer();
            if(kk!=1) {a.append('K');a.append(' ');a.append('1');a.append("\n");}
            if(qq!=1) {a.append('Q');a.append(' ');a.append('1');a.append("\n");}
            if(rr!=2) {a.append('R');a.append(' ');a.append((char)('0'+2-rr));a.append("\n");}
            if(bb!=2) {a.append('B');a.append(' ');a.append((char)('0'+2-bb));a.append("\n");}
            if(kn!=2) {a.append('N');a.append(' ');a.append((char)('0'+2-kn));a.append("\n");}
            if(pp!=8) {a.append('P');a.append(' ');a.append((char)('0'+8-pp));a.append("\n");}
            String str = a.toString();
            return str;
        }
        else if(player == ChessColor.WHITE) {
            for(int i=0;i<8;i++) {
                for(int j=0;j<8;j++) {
                    if(chessComponents[i][j].name == 'k') kk++;
                    else if(chessComponents[i][j].name == 'q') qq++;
                    else if(chessComponents[i][j].name == 'r') rr++;
                    else if(chessComponents[i][j].name == 'b') bb++;
                    else if(chessComponents[i][j].name == 'n') kn++;
                    else if(chessComponents[i][j].name == 'p') pp++;
                }
            }
            StringBuffer a = new StringBuffer();
            if(kk!=1) {a.append('k');a.append(' ');a.append(1);a.append("\n");}
            if(qq!=1) {a.append('q');a.append(' ');a.append(1);a.append("\n");}
            if(rr!=2) {a.append('r');a.append(' ');a.append(2-rr);a.append("\n");}
            if(bb!=2) {a.append('b');a.append(' ');a.append(2-bb);a.append("\n");}
            if(kn!=2) {a.append('n');a.append(' ');a.append(2-kn);a.append("\n");}
            if(pp!=8) {a.append('p');a.append(' ');a.append(8-pp);a.append("\n");}
            String str = a.toString();
            return str;
        }
        return null;
    }
    public ChessComponent getChess(int x,int y) {
        return chessComponents[x][y];
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        int x = source.getX(); int y = source.getY();
        ChessComponent c = new ChessComponent() {
            @Override
            public List<ChessboardPoint> canMoveTo() {
                return null;
            }
        };

        c = chessComponents[x][y];
        c.setchessColor(chessComponents[x][y].getChessColor()); c.setSource(x,y);
        c.setQP(chessComponents);
        List<ChessboardPoint> canMovePoints = c.canMoveTo();
        if(canMovePoints.size()==0) return new ArrayList<>();
        else {
            for(int i=0;i<canMovePoints.size();i++) {
                for(int j=0;j<canMovePoints.size()-1;j++) {
                    if(canMovePoints.get(j).getX() > canMovePoints.get(j+1).getX()) {
                        ChessboardPoint aa = canMovePoints.get(j+1);
                        canMovePoints.set(j+1,canMovePoints.get(j));
                        canMovePoints.set(j,aa);
                    }
                    else if(canMovePoints.get(j).getX() == canMovePoints.get(j+1).getX()) {
                        if(canMovePoints.get(j).getY() > canMovePoints.get(j+1).getY()) {
                            ChessboardPoint aa = canMovePoints.get(j+1);
                            canMovePoints.set(j+1,canMovePoints.get(j));
                            canMovePoints.set(j,aa);
                        }
                    }
                }
            }
        }
        return canMovePoints;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(chessComponents[sourceX][sourceY].getChessColor() != currentPlayer) return false;
        if(chessComponents[sourceX][sourceY].name <= 'Z' && chessComponents[sourceX][sourceY].name >= 'A') {
            ChessComponent c = new ChessComponent() {
                @Override
                public List<ChessboardPoint> canMoveTo() {
                    return null;
                }
            };
            c = chessComponents[sourceX][sourceY];
            c.setchessColor(ChessColor.BLACK); c.setSource(sourceX,sourceY);
            c.setQP(chessComponents);
            List<ChessboardPoint> d = c.canMoveTo();
            boolean t=false;
            for(int i=0;i<d.size();i++) {
                if(d.get(i).getX() == targetX && d.get(i).getY() == targetY) t=true;
            }
            if(t==true) {
                if(currentPlayer==ChessColor.BLACK) currentPlayer = ChessColor.WHITE;
                else if(currentPlayer==ChessColor.WHITE) currentPlayer = ChessColor.BLACK;
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].name = chessComponents[sourceX][sourceY].name;
                chessComponents[targetX][targetY].setchessColor(chessComponents[sourceX][sourceY].getChessColor());
                chessComponents[targetX][targetY].setSource(targetX,targetY);

                chessComponents[sourceX][sourceY] = new EmptySlotComponent() {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return super.canMoveTo();
                    }
                };

                chessComponents[sourceX][sourceY].name = '_';
                chessComponents[sourceX][sourceY].setchessColor(ChessColor.NONE);
                chessComponents[sourceX][sourceY].setSource(sourceX,sourceY);
                return true;
            }
            else return false;
        }
        else if(chessComponents[sourceX][sourceY].name <= 'z' && chessComponents[sourceX][sourceY].name >= 'a') {
            ChessComponent c = new ChessComponent() {
                @Override
                public List<ChessboardPoint> canMoveTo() {
                    return null;
                }
            };
            c = chessComponents[sourceX][sourceY];
            c.setchessColor(ChessColor.WHITE); c.setSource(sourceX,sourceY);
            c.setQP(chessComponents);
            List<ChessboardPoint> d = c.canMoveTo();
            boolean t=false;
            for(int i=0;i<d.size();i++) {
                if(d.get(i).getX() == targetX && d.get(i).getY() == targetY) t=true;
            }
            if(t==true) {
                if(currentPlayer==ChessColor.BLACK) currentPlayer = ChessColor.WHITE;
                else if(currentPlayer==ChessColor.WHITE) currentPlayer = ChessColor.BLACK;
                chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                chessComponents[targetX][targetY].name = chessComponents[sourceX][sourceY].name;
                chessComponents[targetX][targetY].setchessColor(chessComponents[sourceX][sourceY].getChessColor());
                chessComponents[targetX][targetY].setSource(targetX,targetY);

                chessComponents[sourceX][sourceY] = new EmptySlotComponent() {
                    @Override
                    public List<ChessboardPoint> canMoveTo() {
                        return super.canMoveTo();
                    }
                };

                chessComponents[sourceX][sourceY].name = '_';
                chessComponents[sourceX][sourceY].setchessColor(ChessColor.NONE);
                chessComponents[sourceX][sourceY].setSource(sourceX,sourceY);
                return true;
            }
            else return false;
        }
        return true;
    }
    public ChessComponent[][] getchessComponents() {
        return chessComponents;
    }
}
