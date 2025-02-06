import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    private ChessColor currentPlayer;
    @Override
    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard.get(i).charAt(j)==75) {
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
                }
                if (chessboard.get(i).charAt(j)==107) {
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
                }
                if (chessboard.get(i).charAt(j)==81) {
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
                }
                if (chessboard.get(i).charAt(j)==113) {
                    chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
                }
                if (chessboard.get(i).charAt(j)==82) {
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
                }
                if (chessboard.get(i).charAt(j)==114) {
                    chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
                }
                if (chessboard.get(i).charAt(j)==66) {
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
                }
                if (chessboard.get(i).charAt(j)==98) {
                    chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
                }
                if (chessboard.get(i).charAt(j)==78) {
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
                }
                if (chessboard.get(i).charAt(j)==110) {
                    chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
                }
                if (chessboard.get(i).charAt(j)==80) {
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
                }
                if (chessboard.get(i).charAt(j)==112) {
                    chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
                }
                if (chessboard.get(i).charAt(j)=='_') {
                    chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
                }
            }
        }
        if (chessboard.get(8).equals("w")) {
            currentPlayer=ChessColor.WHITE;
        } else  {
            currentPlayer=ChessColor.BLACK;
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
        String a = "";
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                a+=chessComponents[i][j].toString();
            }
            if (i!=7) {
                a+="\n";
            }
        }
        return a;
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        String a = "";
        if (player==ChessColor.BLACK) {
            int k = 0;int q = 0;int r = 0;int b = 0;int n = 0;int p = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName()=='K') {k+=1;}
                    if (chessComponents[i][j].getName()=='Q') {q+=1;}
                    if (chessComponents[i][j].getName()=='R') {r+=1;}
                    if (chessComponents[i][j].getName()=='B') {b+=1;}
                    if (chessComponents[i][j].getName()=='N') {n+=1;}
                    if (chessComponents[i][j].getName()=='P') {p+=1;}
                }
            }
            if (k!=1) {a+="K "+String.valueOf(1-k)+"\n";}
            if (q!=1) {a+="Q "+String.valueOf(1-q)+"\n";}
            if (r!=2) {a+="R "+String.valueOf(2-r)+"\n";}
            if (b!=2) {a+="B "+String.valueOf(2-b)+"\n";}
            if (n!=2) {a+="N "+String.valueOf(2-n)+"\n";}
            if (p!=8) {a+="P "+String.valueOf(8-p);}
        } else {
            int k = 0;int q = 0;int r = 0;int b = 0;int n = 0;int p = 0;
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (chessComponents[i][j].getName()=='k') {k+=1;}
                    if (chessComponents[i][j].getName()=='q') {q+=1;}
                    if (chessComponents[i][j].getName()=='r') {r+=1;}
                    if (chessComponents[i][j].getName()=='b') {b+=1;}
                    if (chessComponents[i][j].getName()=='n') {n+=1;}
                    if (chessComponents[i][j].getName()=='p') {p+=1;}
                }
            }
            if (k!=1) {a+="k "+String.valueOf(1-k)+"\n";}
            if (q!=1) {a+="q "+String.valueOf(1-q)+"\n";}
            if (r!=2) {a+="r "+String.valueOf(2-r)+"\n";}
            if (b!=2) {a+="b "+String.valueOf(2-b)+"\n";}
            if (n!=2) {a+="n "+String.valueOf(2-n)+"\n";}
            if (p!=8) {a+="p "+String.valueOf(8-p);}
        }
        return a;
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
        return canMovePoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (chessComponents[sourceX][sourceY].getName()=='K') {
            ChessComponent a = new KingChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.BLACK,'K');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        if (chessComponents[sourceX][sourceY].getName()=='k') {
            ChessComponent a = new KingChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.WHITE,'k');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        if (chessComponents[sourceX][sourceY].getName()=='Q') {
            ChessComponent a = new QueenChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.BLACK,'Q');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        if (chessComponents[sourceX][sourceY].getName()=='q') {
            ChessComponent a = new QueenChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.WHITE,'q');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        if (chessComponents[sourceX][sourceY].getName()=='R') {
            ChessComponent a = new RookChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.BLACK,'R');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        if (chessComponents[sourceX][sourceY].getName()=='r') {
            ChessComponent a = new RookChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.WHITE,'r');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        if (chessComponents[sourceX][sourceY].getName()=='B') {
            ChessComponent a = new BishopChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.BLACK,'B');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        if (chessComponents[sourceX][sourceY].getName()=='b') {
            ChessComponent a = new BishopChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.WHITE,'b');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        if (chessComponents[sourceX][sourceY].getName()=='N') {
            ChessComponent a = new KnightChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.BLACK,'N');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        if (chessComponents[sourceX][sourceY].getName()=='n') {
            ChessComponent a = new KnightChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.WHITE,'n');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        if (chessComponents[sourceX][sourceY].getName()=='P') {
            ChessComponent a = new PawnChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.BLACK,'P');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        if (chessComponents[sourceX][sourceY].getName()=='p') {
            ChessComponent a = new PawnChessComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.BLACK,'p');
            if (a.canMoveTo().contains(new ChessboardPoint(targetX,targetY))) {
                chessComponents[sourceX][sourceY]=new EmptySlotComponent();
                a.setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[targetX][targetY]=a; return true;
            }
        }
        return false;
    }
}
