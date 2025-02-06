import java.awt.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    // A 2-dimension array to store all the chess components
// should be initialized in your construct method.
// i.e. = new ChessComponent[8][8]
    private ChessComponent[][] chessComponents;
    // What's the current player's color, black or white?
// should be initialized in your construct method.
// by default, set the color to white.
    private ChessColor currentPlayer;
    List<String> chessboard;


    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
    }

   public void loadChessGame(List<String> chessboard){
        this.chessboard = new ArrayList<>();
        EmptySlotComponent E = new EmptySlotComponent();

       for (int i = 0; i < chessboard.size() - 1; i++) {
           for (int j = 0; j < chessboard.get(i).length(); j++) {
               switch (chessboard.get(i).charAt(j)){
                   case 'R' :
                       ChessboardPoint Rp = new ChessboardPoint(i,j);
                       RookChessComponent R = new RookChessComponent(ChessColor.BLACK,Rp);
                       chessComponents[i][j] = R;
                       chessComponents[i][j].setChessComponents(this.chessComponents);
                   break;
                   case 'r' :
                       ChessboardPoint rp = new ChessboardPoint(i,j);
                       RookChessComponent r = new RookChessComponent(ChessColor.WHITE,rp);
                       chessComponents[i][j] = r;
                       chessComponents[i][j].setChessComponents(this.chessComponents);

                   break;
                   case 'Q' :
                       ChessboardPoint Qp = new ChessboardPoint(i,j);
                       QueenChessComponent Q = new QueenChessComponent(ChessColor.BLACK,Qp);
                       chessComponents[i][j] = Q;
                       chessComponents[i][j].setChessComponents(this.chessComponents);
                   break;
                   case 'q' :
                       ChessboardPoint qp = new ChessboardPoint(i,j);
                       QueenChessComponent q = new QueenChessComponent(ChessColor.WHITE,qp);
                       chessComponents[i][j] = q;
                       chessComponents[i][j].setChessComponents(this.chessComponents);
                   break;
                   case 'K' :
                       ChessboardPoint Kp = new ChessboardPoint(i,j);
                       KingChessComponent K = new KingChessComponent(ChessColor.BLACK,Kp);
                       chessComponents[i][j] = K;
                       chessComponents[i][j].setChessComponents(this.chessComponents);
                   break;
                   case 'k' :
                       ChessboardPoint kp = new ChessboardPoint(i,j);
                       KingChessComponent k = new KingChessComponent(ChessColor.WHITE,kp);
                       chessComponents[i][j] = k;
                       chessComponents[i][j].setChessComponents(this.chessComponents);
                   break;
                   case 'N' :
                       ChessboardPoint Np = new ChessboardPoint(i,j);
                       KnightChessComponent N = new KnightChessComponent(ChessColor.BLACK,Np);
                       chessComponents[i][j] = N;
                       chessComponents[i][j].setChessComponents(this.chessComponents);
                   break;
                   case 'n' :
                       ChessboardPoint np = new ChessboardPoint(i,j);
                       KnightChessComponent n = new KnightChessComponent(ChessColor.WHITE,np);
                       chessComponents[i][j] = n;
                       chessComponents[i][j].setChessComponents(this.chessComponents);
                   break;
                   case '_' : chessComponents[i][j] = E;
                   break;
                   case 'P' :
                       ChessboardPoint Pp = new ChessboardPoint(i,j);
                       PawnChessComponent P = new PawnChessComponent(ChessColor.BLACK,Pp);
                       chessComponents[i][j] = P;
                       chessComponents[i][j].setChessComponents(this.chessComponents);
                   break;
                   case 'p' :
                       ChessboardPoint pp = new ChessboardPoint(i,j);
                       PawnChessComponent p = new PawnChessComponent(ChessColor.WHITE,pp);
                       chessComponents[i][j] = p;
                       chessComponents[i][j].setChessComponents(this.chessComponents);
                   break;
                   case 'B' :
                       ChessboardPoint Bp = new ChessboardPoint(i,j);
                       BishopChessComponent B = new BishopChessComponent(ChessColor.BLACK,Bp);
                       chessComponents[i][j] = B;
                       chessComponents[i][j].setChessComponents(this.chessComponents);
                   break;
                   case 'b' :
                       ChessboardPoint bp = new ChessboardPoint(i,j);
                       BishopChessComponent b = new BishopChessComponent(ChessColor.WHITE,bp);
                       chessComponents[i][j] = b;
                       chessComponents[i][j].setChessComponents(this.chessComponents);
               }
           }
       }
       if (chessboard.get(chessboard.size() - 1).equals("w")){
           currentPlayer = ChessColor.WHITE;
       }else {
           currentPlayer = ChessColor.BLACK;
       }
       for (int i = 0; i < chessboard.size() - 1; i++) {
           this.chessboard.add(chessboard.get(i));
       }

    }

    //@Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public String getChessboardGraph(){
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < chessboard.size(); i++) {
            s.append(chessboard.get(i));
            if (i < chessboard.size()-1) {
                s.append("\n");
            }
        }
        return String.valueOf(s);
    }

    public String getCapturedChess(ChessColor player){
        RookChessComponent R = new RookChessComponent(ChessColor.BLACK);
        RookChessComponent r = new RookChessComponent(ChessColor.WHITE);
        KingChessComponent K = new KingChessComponent(ChessColor.BLACK);
        KingChessComponent k = new KingChessComponent(ChessColor.WHITE);
        KnightChessComponent Kn = new KnightChessComponent(ChessColor.BLACK);
        KnightChessComponent kn = new KnightChessComponent(ChessColor.WHITE);
        QueenChessComponent Q = new QueenChessComponent(ChessColor.BLACK);
        QueenChessComponent q = new QueenChessComponent(ChessColor.WHITE);
        PawnChessComponent P = new PawnChessComponent(ChessColor.BLACK);
        PawnChessComponent p = new PawnChessComponent(ChessColor.WHITE);
        BishopChessComponent B = new BishopChessComponent(ChessColor.BLACK);
        BishopChessComponent b = new BishopChessComponent(ChessColor.WHITE);
        HashMap<ChessComponent,Integer> record = new HashMap<>();
        record.put(R,2);
        record.put(r,2);
        record.put(K,1);
        record.put(k,1);
        record.put(Kn,2);
        record.put(kn,2);
        record.put(Q,1);
        record.put(q,1);
        record.put(P,8);
        record.put(p,8);
        record.put(B,2);
        record.put(b,2);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < chessComponents[i].length; j++) {
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].chessColor == ChessColor.BLACK){record.put(R, record.get(R) - 1);continue;}
                if (chessComponents[i][j] instanceof RookChessComponent && chessComponents[i][j].chessColor == ChessColor.WHITE){record.put(r, record.get(r) - 1);continue;}
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].chessColor == ChessColor.BLACK){record.put(K, record.get(K) - 1);continue;}
                if (chessComponents[i][j] instanceof KingChessComponent && chessComponents[i][j].chessColor == ChessColor.WHITE){record.put(k, record.get(k) - 1);continue;}
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].chessColor == ChessColor.BLACK){record.put(Kn, record.get(Kn) - 1);continue;}
                if (chessComponents[i][j] instanceof KnightChessComponent && chessComponents[i][j].chessColor == ChessColor.WHITE){record.put(kn, record.get(kn) - 1);continue;}
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].chessColor == ChessColor.BLACK){record.put(Q, record.get(Q) - 1);continue;}
                if (chessComponents[i][j] instanceof QueenChessComponent && chessComponents[i][j].chessColor == ChessColor.WHITE){record.put(q, record.get(q) - 1);continue;}
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].chessColor == ChessColor.BLACK){record.put(P, record.get(P) - 1);continue;}
                if (chessComponents[i][j] instanceof PawnChessComponent && chessComponents[i][j].chessColor == ChessColor.WHITE){record.put(p, record.get(p) - 1);continue;}
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].chessColor == ChessColor.BLACK){record.put(B,record.get(B) - 1);continue;}
                if (chessComponents[i][j] instanceof BishopChessComponent && chessComponents[i][j].chessColor == ChessColor.WHITE){record.put(b,record.get(b) - 1);}
            }

        }
        StringBuilder Return = new StringBuilder();
        if (player == ChessColor.BLACK){
            boolean j1 = record.get(K) != 0;
            boolean j2 = record.get(Q) != 0;
            boolean j3 = record.get(R) != 0;
            boolean j4 = record.get(B) != 0;
            boolean j5 = record.get(Kn) != 0;
            boolean j6 = record.get(P) != 0;
            if (j1){
                Return.append("K 1\n");
            }
            if (j2){
                Return.append("Q 1\n");
            }
            if (j3){
                Return.append("R ").append(record.get(R)).append("\n");
            }
            if (j4){
                Return.append("B ").append(record.get(B)).append("\n");
            }
            if (j5){
                Return.append("N ").append(record.get(Kn)).append("\n");
            }
            if (j6){
                Return.append("P ").append(record.get(P)).append("\n");
            }
        }else if (player == ChessColor.WHITE){
            boolean j1 = record.get(k) != 0;
            boolean j2 = record.get(q) != 0;
            boolean j3 = record.get(r) != 0;
            boolean j4 = record.get(b) != 0;
            boolean j5 = record.get(kn) != 0;
            boolean j6 = record.get(p) != 0;
            if (j1){
                Return.append("k 1\n");
            }
            if (j2){
                Return.append("q 1\n");
            }
            if (j3){
                Return.append("r ").append(record.get(r)).append("\n");
            }
            if (j4){
                Return.append("b ").append(record.get(b)).append("\n");
            }
            if (j5){
                Return.append("n ").append(record.get(kn)).append("\n");
            }
            if (j6){
                Return.append("p ").append(record.get(p)).append("\n");
            }
        }
        return Return.toString();
    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source){
        List<ChessboardPoint> canMovePoints;
            canMovePoints = chessComponents[source.getX()][source.getY()].canMoveTo();
            collectionSort(canMovePoints);
        return canMovePoints;
    }
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){
        if (currentPlayer == getChess(sourceX,sourceY).chessColor) {
            int num = chessComponents[sourceX][sourceY].canMoveTo().size();
            for (int i = 0; i < num; i++) {
                if (chessComponents[sourceX][sourceY].canMoveTo().get(i).getX() == targetX && chessComponents[sourceX][sourceY].canMoveTo().get(i).getY() == targetY) {
                    chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
                    chessComponents[sourceX][sourceY] = new EmptySlotComponent();
                    chessComponents[sourceX][sourceY].setSource(new ChessboardPoint(sourceX,sourceY));
                    chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                    if (currentPlayer == ChessColor.BLACK) {
                        currentPlayer = ChessColor.WHITE;
                    } else if (currentPlayer == ChessColor.WHITE) {
                        currentPlayer = ChessColor.BLACK;
                    }
                    return true;
                }
            }
        }
        return false;
    }
    public void collectionSort(List<ChessboardPoint> chessboardPoints){
        for (int i = 0; i < chessboardPoints.size() - 1; i++) {
            for (int j = 0; j < chessboardPoints.size() -1; j++) {
                if (chessboardPoints.get(j).getX() > chessboardPoints.get(j + 1).getX()){
                    ChessboardPoint temp = new ChessboardPoint(chessboardPoints.get(j).getX(),chessboardPoints.get(j).getY());
                    chessboardPoints.set(j,chessboardPoints.get(j + 1));
                    chessboardPoints.set(j + 1, temp);
                }else if (chessboardPoints.get(j).getY() > chessboardPoints.get(j + 1).getY() && chessboardPoints.get(j).getX() == chessboardPoints.get(j + 1).getX()){
                    ChessboardPoint temp = new ChessboardPoint(chessboardPoints.get(j).getX(),chessboardPoints.get(j).getY());
                    chessboardPoints.set(j,chessboardPoints.get(j + 1));
                    chessboardPoints.set(j + 1, temp);
                }
            }
        }
    }
}
