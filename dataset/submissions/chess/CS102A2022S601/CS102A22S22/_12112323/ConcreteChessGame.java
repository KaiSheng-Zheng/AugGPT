import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;

    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }
    public ConcreteChessGame(){
  this.chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
  
}
    @Override
    public void loadChessGame(List<String> chessboard) {
for (int a = 0 ;a<8;a++){
    for (int b = 0 ; b<8;b++){
        String mid = String.valueOf(chessboard.get(a).charAt(b));
        if (mid.equals("B")){
      chessComponents[a][b]= new BishopChessComponent(new ChessboardPoint(a,b),ChessColor.BLACK,'B');
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.BLACK);
            chessComponents[a][b].setName('B');

        }
        else  if (mid.equals("b")){
            chessComponents[a][b]= new BishopChessComponent(new ChessboardPoint(a,b),ChessColor.WHITE,'b');
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.WHITE);
            chessComponents[a][b].setName('b');
        }
        else if (mid.equals("N")){
            chessComponents[a][b]= new KnightChessComponent();
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.BLACK);
            chessComponents[a][b].setName('N');
        }
        else if (mid.equals("n")){
            chessComponents[a][b]= new KnightChessComponent();
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.WHITE);
            chessComponents[a][b].setName('n');
        }
        else if (mid.equals("R")){
            chessComponents[a][b]= new RookChessComponent(new ChessboardPoint(a,b),ChessColor.BLACK,'R');
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.BLACK);
            chessComponents[a][b].setName('R');
        }
        else if (mid.equals("r")){
            chessComponents[a][b]= new RookChessComponent(new ChessboardPoint(a,b),ChessColor.WHITE,'r');
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.WHITE);
            chessComponents[a][b].setName('r');
        }
        else if (mid.equals("Q")){
            chessComponents[a][b]= new QueenChessComponent(new ChessboardPoint(a,b),ChessColor.BLACK,'Q');
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.BLACK);
            chessComponents[a][b].setName('Q');
        }
        else if (mid.equals("q")){
            chessComponents[a][b]= new QueenChessComponent(new ChessboardPoint(a,b),ChessColor.WHITE,'q');
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.WHITE);
            chessComponents[a][b].setName('q');
        }
        else if (mid.equals("K")){
            chessComponents[a][b]= new KingChessComponent();
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.BLACK);
            chessComponents[a][b].setName('K');
        }
        else if (mid.equals("k")){
            chessComponents[a][b]= new KingChessComponent();
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.WHITE);
            chessComponents[a][b].setName('k');
        }
        else if (mid.equals("P")){
            chessComponents[a][b]= new PawnChessComponent();
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.BLACK);
            chessComponents[a][b].setName('P');
        }
        else if (mid.equals("p")){
            chessComponents[a][b]= new PawnChessComponent();
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.WHITE);
            chessComponents[a][b].setName('p');
        }
        else if (mid.equals("_")){
            chessComponents[a][b]= new EmptySlotComponent(new ChessboardPoint(a,b),ChessColor.NONE,'_');
            chessComponents[a][b].JiaZai(this);
            chessComponents[a][b].setChessColor(ChessColor.NONE);
            chessComponents[a][b].setName('_');
        }
    }
}
        String mid = String.valueOf(chessboard.get(8).charAt(0));
if (mid.equals("w")){
    currentPlayer=ChessColor.WHITE;
}
else {
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
     StringBuilder yyc = new StringBuilder();
        for (int a = 0 ;a<8;a++){
            for (int b = 0 ;b<8;b++) {
                if (chessComponents[a][b] .getChessColor()==ChessColor.NONE) {
                    yyc.append("_");
                }
             else if (chessComponents[a][b].getChessColor()==ChessColor.BLACK) {
                  if (chessComponents[a][b] instanceof BishopChessComponent) {
                      yyc.append("B");
                  } else if (chessComponents[a][b] instanceof RookChessComponent) {
                      yyc.append("R");
                  } else if (chessComponents[a][b] instanceof KnightChessComponent) {
                      yyc.append("N");
                  } else if (chessComponents[a][b] instanceof KingChessComponent) {
                      yyc.append("K");
                  } else if (chessComponents[a][b] instanceof QueenChessComponent) {
                      yyc.append("Q");
                  } else if (chessComponents[a][b] instanceof PawnChessComponent) {
                      yyc.append("P");
                  }
              }
else if (chessComponents[a][b].getChessColor()==ChessColor.WHITE){
                  if (chessComponents[a][b] instanceof BishopChessComponent) {
                      yyc.append("b");
                  } else if (chessComponents[a][b] instanceof RookChessComponent) {
                      yyc.append("r");
                  } else if (chessComponents[a][b] instanceof KnightChessComponent) {
                      yyc.append("n");
                  } else if (chessComponents[a][b] instanceof KingChessComponent) {
                      yyc.append("k");
                  } else if (chessComponents[a][b] instanceof QueenChessComponent) {
                      yyc.append("q");
                  } else if (chessComponents[a][b] instanceof PawnChessComponent) {
                      yyc.append("p");
                  }
              }

            }
            yyc.append("\n");
        }
return String.valueOf(yyc);
    }

    @Override
    public String getCapturedChess(ChessColor player) {
        StringBuilder yyc = new StringBuilder();
        int P=0;
        int R=0;
        int N=0;
        int Q=0;
        int K=0;
        int B=0;
        int p=0;
        int r=0;
        int n=0;
        int q=0;
        int k=0;
        int b1=0;
            for (int a = 0; a < 8; a++) {
                for (int b = 0; b < 8; b++) {
                    if (chessComponents[a][b].getChessColor() == ChessColor.BLACK) {
                        if (chessComponents[a][b] instanceof BishopChessComponent) {
                            B++;
                        } else if (chessComponents[a][b] instanceof RookChessComponent) {
                            R++;
                        } else if (chessComponents[a][b] instanceof KnightChessComponent) {
                            N++;
                        } else if (chessComponents[a][b] instanceof KingChessComponent) {
                            K++;
                        } else if (chessComponents[a][b] instanceof QueenChessComponent) {
                            Q++;
                        } else if (chessComponents[a][b] instanceof PawnChessComponent) {
                            P++;
                        }
                    }
                    else if (chessComponents[a][b].getChessColor() == ChessColor.WHITE) {
                            if (chessComponents[a][b] instanceof BishopChessComponent) {
                                b1++;
                            } else if (chessComponents[a][b] instanceof RookChessComponent) {
                                r++;
                            } else if (chessComponents[a][b] instanceof KnightChessComponent) {
                                n++;
                            } else if (chessComponents[a][b] instanceof KingChessComponent) {
                               k++;
                            } else if (chessComponents[a][b] instanceof QueenChessComponent) {
                                q++;
                            } else if (chessComponents[a][b] instanceof PawnChessComponent) {
                               p++;
                            }
                        }
                }
            }
       p=8-p;
       P=8-P;
       R=2-R;
       r=2-r;
       N=2-N;
       n=2-n;
       Q=1-Q;
       q=1-q;
       K=1-K;
       k=1-k;
       B=2-B;
       b1=2-b1;
       if (player==ChessColor.BLACK){
           if (K!=0){
               yyc.append("K");
               yyc.append(" ");
               yyc.append(K);
               yyc.append("\n");
           }
           if (Q!=0){
               yyc.append("Q");
               yyc.append(" ");
               yyc.append(Q);
               yyc.append("\n");
           }
           if (R!=0){
               yyc.append("R");
               yyc.append(" ");
               yyc.append(R);
               yyc.append("\n");
           }
           if (B!=0){
               yyc.append("B");
               yyc.append(" ");
               yyc.append(B);
               yyc.append("\n");
           }
           if (N!=0){
               yyc.append("N");
               yyc.append(" ");
               yyc.append(N);
               yyc.append("\n");
           }
           if (P!=0){
               yyc.append("P");
               yyc.append(" ");
               yyc.append(P);
               yyc.append("\n");
           }
           return String.valueOf(yyc);
       }
       else {
           if (k!=0){
               yyc.append("k");
               yyc.append(" ");
               yyc.append(k);
               yyc.append("\n");
           }
           if (q!=0){
               yyc.append("q");
               yyc.append(" ");
               yyc.append(q);
               yyc.append("\n");
           }
           if (r!=0){
               yyc.append("r");
               yyc.append(" ");
               yyc.append(r);
               yyc.append("\n");
           }
           if (b1!=0){
               yyc.append("b");
               yyc.append(" ");
               yyc.append(b1);
               yyc.append("\n");
           }
           if (n!=0){
               yyc.append("n");
               yyc.append(" ");
               yyc.append(n);
               yyc.append("\n");
           }
           if (p!=0){
               yyc.append("p");
               yyc.append(" ");
               yyc.append(p);
               yyc.append("\n");
           }
           return String.valueOf(yyc);
       }
    }


    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> yyc = chessComponents[source.getX()][source.getY()].canMoveTo();
        int[] cry = new int[yyc.size()];
        for (int a = 0 ; a<yyc.size();a++){
          cry[a]=yyc.get(a).getX()*10+yyc.get(a).getY();
        }
        Arrays.sort(cry);
        List<ChessboardPoint> qaq = new ArrayList<>();
        for (int a = 0 ; a<yyc.size();a++){
            qaq.add(new ChessboardPoint(cry[a]/10,cry[a]%10));
        }
        return qaq;


    }

    @Override
   public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> yyc = this.getCanMovePoints(new ChessboardPoint(sourceX,sourceY));
        for (int a = 0 ; a<yyc.size();a++){
            if (chessComponents[sourceX][sourceY].getChessColor()!=currentPlayer){
                return false;
            }
            if (yyc.get(a).getX()==targetX && yyc.get(a).getY()==targetY){
                chessComponents[targetX][targetY]= chessComponents[sourceX][sourceY];
               chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
                chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
                 setChessComponents(chessComponents);
                if (currentPlayer==ChessColor.WHITE){
                    currentPlayer=ChessColor.BLACK;
                }
                else if (currentPlayer==ChessColor.BLACK){
                    currentPlayer=ChessColor.WHITE;
                }
                return true;

            }
        }
        return false;
    }
}
