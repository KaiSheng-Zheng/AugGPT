import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ConcreteChessGame() {
        this.chessComponents =new ChessComponent[8][8];
        this.currentPlayer =ChessColor.WHITE;
    }

    public void loadChessGame(List<String> chessboard) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                switch (chessboard.get(i).charAt(j)){
                    case 'r':
                        ChessboardPoint r=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new RookChessComponent(r,ChessColor.WHITE,'r');
                        break;
                    case 'R':
                        ChessboardPoint R=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new RookChessComponent(R,ChessColor.BLACK,'R');
                        break;
                    case 'k':
                        ChessboardPoint k=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new KingChessComponent(k,ChessColor.WHITE,'k');
                        break;
                    case 'K':
                        ChessboardPoint K=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new KingChessComponent(K,ChessColor.BLACK,'K');
                        break;
                    case 'n':
                        ChessboardPoint n=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new KnightChessComponent(n,ChessColor.WHITE,'n');
                        break;
                    case 'N':
                        ChessboardPoint N=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new KnightChessComponent(N,ChessColor.BLACK,'N');
                        break;
                    case 'q':
                        ChessboardPoint q=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new QueenChessComponent(q,ChessColor.WHITE,'q');
                        break;
                    case 'Q':
                        ChessboardPoint Q=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new QueenChessComponent(Q,ChessColor.BLACK,'Q');
                        break;
                    case 'b':
                        ChessboardPoint b=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new BishopChessComponent(b,ChessColor.WHITE,'b');
                        break;
                    case 'B':
                        ChessboardPoint B=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new BishopChessComponent(B,ChessColor.BLACK,'B');
                        break;
                    case 'p':
                        ChessboardPoint p=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new PawnChessComponent(p,ChessColor.WHITE,'p');
                        break;
                    case 'P':
                        ChessboardPoint P=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new PawnChessComponent(P,ChessColor.BLACK,'P');
                        break;
                    case '_':
                        ChessboardPoint m=new ChessboardPoint(i,j);
                        chessComponents[i][j]=new EmptySlotComponent(m,ChessColor.NONE,'_');
                }
            }
            
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                chessComponents[i][j].setChessboard(chessComponents);
            }
        }
        if (chessboard.get(8).equals("w")){
            currentPlayer=ChessColor.WHITE;
        }else {
            currentPlayer=ChessColor.BLACK;
        }
    }

    ;


    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }




    public ChessComponent getChess(int x, int y) {
        return chessComponents[x][y];
    }


    public String getChessboardGraph() {
        StringBuffer a = new StringBuffer();
        StringBuffer b = new StringBuffer();
        StringBuffer c = new StringBuffer();
        StringBuffer d = new StringBuffer();
        StringBuffer e = new StringBuffer();
        StringBuffer f = new StringBuffer();
        StringBuffer g = new StringBuffer();
        StringBuffer h = new StringBuffer();

        for (int j = 0; j < chessComponents[0].length; j++) {
            a.append(chessComponents[0][j].name);
            b.append(chessComponents[1][j].name);
            c.append(chessComponents[2][j].name);
            d.append(chessComponents[3][j].name);
            e.append(chessComponents[4][j].name);
            f.append(chessComponents[5][j].name);
            g.append(chessComponents[6][j].name);
            h.append(chessComponents[7][j].name);

        }
        return String.format(a + "\n" + b + "\n" + c + "\n" + d + "\n" + e + "\n" + f + "\n" + g + "\n" + h);
    }




    public String getCapturedChess(ChessColor player) {
       String a=getChessboardGraph();
       String[]x=a.split("\n");
        int Rcounter=0;
        int rcounter=0;
        int Kcounter=0;
        int kcounter=0;
        int Bcounter=0;
        int bcounter=0;
        int Qcounter=0;
        int qcounter=0;
        int Ncounter=0;
        int ncounter=0;
        int Pcounter=0;
        int pcounter=0;
        StringBuilder sb=new StringBuilder();
        for (int i = 0; i < x.length; i++) {
            for (int j = 0; j < x[i].length(); j++) {
                switch (x[i].charAt(j)){
                    case 'R':
                        Rcounter+=1;
                        break;
                    case 'r':
                        rcounter+=1;
                        break;
                    case 'K':
                        Kcounter+=1;
                        break;
                    case 'k':
                        kcounter+=1;
                        break;
                    case 'B':
                        Bcounter+=1;
                        break;
                    case 'b':
                        bcounter+=1;
                        break;
                    case 'Q':
                        Qcounter+=1;
                        break;
                    case 'q':
                        qcounter+=1;
                        break;
                    case 'N':
                        Ncounter+=1;
                        break;
                    case 'n':
                        ncounter+=1;
                        break;
                    case 'P':
                        Pcounter+=1;
                        break;
                    case 'p':
                        pcounter+=1;
                        break;
                }
            }
            int Rlost=2-Rcounter;
            int rlost=2-Rcounter;
            int Klost=1-Rcounter;
            int klost=1-Rcounter;
            int Blost=2-Rcounter;
            int blost=2-Rcounter;
            int Qlost=1-Rcounter;
            int qlost=1-Rcounter;
            int Nlost=2-Rcounter;
            int nlost=2-Rcounter;
            int Plost=8-Rcounter;
            int plost=8-Rcounter;

            if (player.equals(ChessColor.BLACK)) {
                if (Klost != 0) {
                    sb.append("K " + Klost + "\n");
                }
                if (Qlost != 0) {
                    sb.append("Q " + Qlost + "\n");
                }
                if (Rlost != 0) {
                    sb.append("R " + Rlost + "\n");
                }
                if (Blost != 0) {
                    sb.append("B " + Blost + "\n");
                }
                if (Nlost != 0) {
                    sb.append("N " + Nlost + "\n");
                }
                if (Plost != 0) {
                    sb.append("P " + Plost + "\n");
                }
            }
            if (player.equals(ChessColor.WHITE)){
                if (klost != 0) {
                    sb.append("k " + klost + "\n");
                }
                if (qlost != 0) {
                    sb.append("q " + qlost + "\n");
                }
                if (rlost != 0) {
                    sb.append("r " + rlost + "\n");
                }
                if (blost != 0) {
                    sb.append("b " + blost + "\n");
                }
                if (nlost != 0) {
                    sb.append("n " + nlost + "\n");
                }
                if (plost != 0) {
                    sb.append("p " + plost + "\n");
                }
            }




        }
        return sb.toString();
    }


        public List<ChessboardPoint> getCanMovePoints (ChessboardPoint source){
            ChessComponent chess=chessComponents[source.getX()][source.getY()];
            List<ChessboardPoint> canMovePoints = chess.canMoveTo();
            canMovePoints.sort(new Comparator<ChessboardPoint>() {
                @Override
                public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                    int num = o1.getX() - o2.getX();
                    int num2 = num == 0 ? o1.getY() - o2.getY() : num;
                    return num2;
                }
            });
            return canMovePoints;
        }


    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if (!currentPlayer.equals(chessComponents[sourceX][sourceY].getChessColor())) {
            return false;
        }
        if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))) {
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX, targetY));
            chessComponents[sourceX][sourceY] = new EmptySlotComponent(new ChessboardPoint(sourceX, sourceY), ChessColor.NONE, '_');
            if (currentPlayer.equals(ChessColor.BLACK)) {
                currentPlayer = ChessColor.WHITE;
            } else {
                currentPlayer = ChessColor.BLACK;
            }
            return true;
        }
        return false;
    }

}
