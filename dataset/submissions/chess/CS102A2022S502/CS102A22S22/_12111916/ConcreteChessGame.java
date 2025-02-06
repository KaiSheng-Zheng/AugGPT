import java.util.*;

public  class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame(){
        this.currentPlayer=ChessColor.WHITE;  this.chessComponents=new ChessComponent[8][8];

    }
   public void loadChessGame(List<String> chessboard) {

       for (int i = 0; i < 8; i++) {
           for (int j = 0; j < 8;j++){
               switch (chessboard.get(i).substring(j, j + 1)) {
                   case "R" -> {
                       this.chessComponents[i][j] = new RookChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       chessComponents[i][j].setName('R');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "r" -> {
                       this.chessComponents[i][j] = new RookChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.WHITE);
                       chessComponents[i][j].setName('r');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "B" -> {
                       this.chessComponents[i][j] = new BishopChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       chessComponents[i][j].setName('B');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "b" -> {
                       this.chessComponents[i][j] = new BishopChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.WHITE);
                       chessComponents[i][j].setName('b');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "K" -> {
                       this.chessComponents[i][j] = new KingChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       chessComponents[i][j].setName('K');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "k" -> {
                       this.chessComponents[i][j] = new KingChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.WHITE);
                       chessComponents[i][j].setName('k');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "Q" -> {
                       this.chessComponents[i][j] = new QueenChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       chessComponents[i][j].setName('Q');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "q" -> {
                       this.chessComponents[i][j] = new QueenChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.WHITE);
                       chessComponents[i][j].setName('q');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "P" -> {
                       this.chessComponents[i][j] = new PawnChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       chessComponents[i][j].setName('P');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "p" -> {
                       this.chessComponents[i][j] = new PawnChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.WHITE);
                       chessComponents[i][j].setName('p');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "N" -> {
                       this.chessComponents[i][j] = new KnightChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.BLACK);
                       chessComponents[i][j].setName('N');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "n" -> {
                       this.chessComponents[i][j] = new KnightChessComponent();
                       chessComponents[i][j].setChessColor(ChessColor.WHITE);
                       chessComponents[i][j].setName('n');
                       ChessboardPoint ss=new ChessboardPoint(i,j);
                       chessComponents[i][j].setSource(ss);
                   }
                   case "_" -> {
                       chessComponents[i][j] = new EmptySlotComponent();
                       chessComponents[i][j].setName('_');
                   }
               }
               chessComponents[i][j].setChessboard(chessComponents);

           }
       }
       switch (chessboard.get(8)) {
           case "w" -> this.currentPlayer = ChessColor.WHITE;
           case "b" -> this.currentPlayer = ChessColor.BLACK;
       }
   }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    @Override
    public String getChessboardGraph(){
      //  StringBuilder[] s=new StringBuilder[8];
        String[] s=new String[8];
      for (int i=0;i<8;i++){
          s[i]="";
          for (int j=0;j<8;j++){
             // String x=String.valueOf(this.chessComponents[i][j].getName());
             // s[i].append(x);
              s[i]+=this.chessComponents[i][j].getName();
          }
      }
        return String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",s[0],s[1],s[2],s[3],s[4],s[5],s[6],s[7]);
   }

    public String getCapturedChess(ChessColor player){
        int R=2; int r=2; int B=2; int b=2; int K=1; int k=1; int N=2;int n=2; int P=8;int p=8; int Q=1;int q=1;
           for (int i=0;i<8;i++) {
               for (int j = 0; j < 8; j++) {
                   if (chessComponents[i][j].getName() == 'R') {
                       R--;
                   } else if (chessComponents[i][j].getName() == 'r') {
                       r--;
                   } else if (chessComponents[i][j].getName() == 'B') {
                       B--;
                   } else if (chessComponents[i][j].getName() == 'b') {
                       b--;
                   } else if (chessComponents[i][j].getName() == 'K') {
                       K--;
                   } else if (chessComponents[i][j].getName() == 'k') {
                       k--;
                   } else if (chessComponents[i][j].getName() == 'N') {
                       N--;
                   } else if (chessComponents[i][j].getName() == 'n') {
                       n--;
                   } else if (chessComponents[i][j].getName() == 'P') {
                       P--;
                   } else if (chessComponents[i][j].getName() == 'p') {
                       p--;
                   } else if (chessComponents[i][j].getName() == 'Q') {
                       Q--;
                   } else if (chessComponents[i][j].getName() == 'q') {
                       q--;

                   }
               }
           }
           StringBuilder sb =new StringBuilder();
           sb.setLength(0);
           if(player==ChessColor.BLACK){
           if(K!=0){sb.append(String.format("K %d\n",K));} // if(k!=0){sb.append(String.format("k %d\n",k));}
        if(Q!=0){sb.append(String.format("Q %d\n",Q));}  // if(q!=0){sb.append(String.format("q %d\n",q));}
        if(R!=0){sb.append(String.format("R %d\n",R));} // if(r!=0){sb.append(String.format("r %d\n",r));}
        if(B!=0){sb.append(String.format("B %d\n",B));}  //if(b!=0){sb.append(String.format("b %d\n",b));}
        if(N!=0){sb.append(String.format("N %d\n",N));}  // if(n!=0){sb.append(String.format("n %d\n",n));}
        if(P!=0){sb.append(String.format("P %d\n",P));}
           }  else {

               if(k!=0){sb.append(String.format("k %d\n",k));}

               if(q!=0){sb.append(String.format("q %d\n",q));}

               if(r!=0){sb.append(String.format("r %d\n",r));}

               if(b!=0){sb.append(String.format("b %d\n",b));}

               if(n!=0){sb.append(String.format("n %d\n",n));}
               if(p!=0){sb.append(String.format("p %d\n",p));}
           }

          return sb.toString();


    }
    public ChessComponent getChess(int x, int y){
        return chessComponents[x][y];
    }
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> chess = getChess(source.getX(), source.getY()).canMoveTo();
        if (chess == null) {
            return new ArrayList<>();
        }

//            Collections.sort(chess, new Comparator<ChessboardPoint>() {
//                @Override
//                public int compare(ChessboardPoint o1, ChessboardPoint o2) {
//                    if (o1.getX() < o2.getX() || (o1.getX() == o2.getX() && o1.getY() < o2.getY())) {
//                        return -1;
//                    } else {
//                        return 1;
//                    }
//                }
//            });
            return chess;
        }
  public boolean contains(List<ChessboardPoint> m,ChessboardPoint chessboardPoint){
        for (int i=0;i<m.size();i++){
            if(m.get(i).getX()==chessboardPoint.getX() && m.get(i).getY()==chessboardPoint.getY()){
                return true;
            }
        }
        return false;
    }

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY){

        if(chessComponents[sourceX][sourceY].canMoveTo()==null){return false;}
        if(contains(chessComponents[sourceX][sourceY].canMoveTo(),new ChessboardPoint(targetX,targetY) )&&currentPlayer==chessComponents[sourceX][sourceY].getChessColor()){
            chessComponents[targetX][targetY]=chessComponents[sourceX][sourceY];
            chessComponents[targetX][targetY].setSource(new ChessboardPoint(targetX,targetY));
            

//            switch (chessComponents[sourceX][sourceY].name){
//                case 'K'-> {
//                    this.chessComponents[targetX][targetY] = new KingChessComponent();
//                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
//                    chessComponents[targetX][targetY].setName('K');
//                    ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                    chessComponents[targetX][targetY].setSource(ss);
//
//                }
//             case 'k'-> {
//                 this.chessComponents[targetX][targetY] = new KingChessComponent();
//                 chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
//                 chessComponents[targetX][targetY].setName('k');
//                 ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                 chessComponents[targetX][targetY].setSource(ss);
//             }
//             case 'P'-> {
//                    this.chessComponents[targetX][targetY] = new PawnChessComponent();
//                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
//                    chessComponents[targetX][targetY].setName('P');
//                    ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                    chessComponents[targetX][targetY].setSource(ss);
//
//                }
//             case 'p'-> {
//                    this.chessComponents[targetX][targetY] = new PawnChessComponent();
//                    chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
//                    chessComponents[targetX][targetY].setName('p');
//                    ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                    chessComponents[targetX][targetY].setSource(ss);
//
//                }
//                case 'N'-> {
//                    this.chessComponents[targetX][targetY] = new KnightChessComponent();
//                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
//                    chessComponents[targetX][targetY].setName('N');
//                    ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                    chessComponents[targetX][targetY].setSource(ss);
//
//                }
//                case 'n'-> {
//                    this.chessComponents[targetX][targetY] = new KnightChessComponent();
//                    chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
//                    chessComponents[targetX][targetY].setName('n');
//                    ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                    chessComponents[targetX][targetY].setSource(ss);
//
//                }
//                case 'R'-> {
//                    this.chessComponents[targetX][targetY] = new RookChessComponent();
//                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
//                    chessComponents[targetX][targetY].setName('R');
//                    ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                    chessComponents[targetX][targetY].setSource(ss);
//
//                }
//                case 'r'-> {
//                    this.chessComponents[targetX][targetY] = new RookChessComponent();
//                    chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
//                    chessComponents[targetX][targetY].setName('r');
//                    ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                    chessComponents[targetX][targetY].setSource(ss);
//
//                }
//                case 'B'-> {
//                    this.chessComponents[targetX][targetY] = new BishopChessComponent();
//                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
//                    chessComponents[targetX][targetY].setName('B');
//                    ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                    chessComponents[targetX][targetY].setSource(ss);
//
//                }
//                case 'b'-> {
//                    this.chessComponents[targetX][targetY] = new BishopChessComponent();
//                    chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
//                    chessComponents[targetX][targetY].setName('b');
//                    ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                    chessComponents[targetX][targetY].setSource(ss);
//
//                }
//                case 'Q'-> {
//                    this.chessComponents[targetX][targetY] = new QueenChessComponent();
//                    chessComponents[targetX][targetY].setChessColor(ChessColor.BLACK);
//                    chessComponents[targetX][targetY].setName('Q');
//                    ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                    chessComponents[targetX][targetY].setSource(ss);
//
//                }
//                case 'q'-> {
//                    this.chessComponents[targetX][targetY] = new QueenChessComponent();
//                    chessComponents[targetX][targetY].setChessColor(ChessColor.WHITE);
//                    chessComponents[targetX][targetY].setName('q');
//                    ChessboardPoint ss = new ChessboardPoint(targetX, targetY);
//                    chessComponents[targetX][targetY].setSource(ss);
//
//                }
//        }
        chessComponents[sourceX][sourceY]=new EmptySlotComponent();
            chessComponents[sourceX][sourceY].setName('_');
            if(currentPlayer==ChessColor.WHITE){
                currentPlayer=ChessColor.BLACK;
            }else if(currentPlayer==ChessColor.BLACK){
                currentPlayer=ChessColor.WHITE;
            }
            return true;
        }else {
            return false;
        }

    }


}
