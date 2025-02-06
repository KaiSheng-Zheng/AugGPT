import java.time.Year;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessComponent[][] chessComponents=new ChessComponent[8][8];
    private ChessColor currentPlayer = ChessColor.WHITE;

//    public ConcreteChessGame(ChessComponent[][] chessComponents) {
//        this.chessComponents = chessComponents;
//    }


    public ConcreteChessGame(){

    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint>chess=getChess(source.getX(), source.getY()).canMoveTo();
        if(chess == null) return new ArrayList<>();
        Collections.sort(chess, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX()<o2.getX()||(o1.getX()==o2.getX()&&o1.getY()<o2.getY())){
                    return -1;
                }else {return 1;
                }
            }
        });
        return chess;
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        if(chessComponents[sourceX][sourceY].canMoveTo() == null) return false;
        if (chessComponents[sourceX][sourceY].canMoveTo().contains(new ChessboardPoint(targetX, targetY))&&currentPlayer==chessComponents[sourceX][sourceY].getChessColor()){
            switch (chessComponents[sourceX][sourceY].name){
                case 'K':
                    chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'K');
                    break;
                case 'Q':
                    chessComponents[targetX][targetY]=new QueenChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'Q');
                    break;
                case 'B':
                    chessComponents[targetX][targetY]=new BishopChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'B');
                    break;
                case 'N':
                    chessComponents[targetX][targetY]=new KnightChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'N');
                    break;
                case 'R':
                    chessComponents[targetX][targetY]=new RookChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'R');
                    break;
                case 'P':
                    chessComponents[targetX][targetY]=new PawnChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'P');
                    break;
                case 'k':
                    chessComponents[targetX][targetY]=new KingChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'k');
                    break;
                case 'q':
                    chessComponents[targetX][targetY]=new QueenChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'q');
                    break;
                case 'b':
                    chessComponents[targetX][targetY]=new BishopChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'b');
                    break;
                case 'n':
                    chessComponents[targetX][targetY]=new KnightChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'n');
                    break;
                case 'r':
                    chessComponents[targetX][targetY]=new RookChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'r');
                    break;
                case 'p':
                    chessComponents[targetX][targetY]=new PawnChessComponent(new ChessboardPoint(targetX,targetY),getCurrentPlayer(),'p');
                    break;

            }
            chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY),ChessColor.NONE,'_');
            if (currentPlayer==ChessColor.WHITE){
                currentPlayer=ChessColor.BLACK;
            }else if (currentPlayer==ChessColor.BLACK){
                currentPlayer=ChessColor.WHITE;
            }
            return true;
        }else {
            return false;
        }
    }

//    public ConcreteChessGame(ChessColor currentPlayer) {
//        this.currentPlayer = currentPlayer;
//    }

    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    public void loadChessGame(List<String> chessboard) {
      for (int i = 0;i<8;i++){
          for (int j = 0;j<8;j++){
              if (chessboard.get(i).charAt(j)=='K'){
                  chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'K');
              }else if (chessboard.get(i).charAt(j)=='Q'){
                  chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'Q');
              }else if (chessboard.get(i).charAt(j)=='B'){
                  chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'B');
              }else if (chessboard.get(i).charAt(j)=='N'){
                  chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'N');
              }else if (chessboard.get(i).charAt(j)=='R'){
                  chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'R');
              }else if (chessboard.get(i).charAt(j)=='P'){
                  chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.BLACK,'P');
              }else if (chessboard.get(i).charAt(j)=='k'){
                  chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'k');
              }else if (chessboard.get(i).charAt(j)=='q'){
                  chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'q');
              }else if (chessboard.get(i).charAt(j)=='b'){
                  chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'b');
              }else if (chessboard.get(i).charAt(j)=='n'){
                  chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'n');
              }else if (chessboard.get(i).charAt(j)=='r'){
                  chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'r');
              }else if (chessboard.get(i).charAt(j)=='p'){
                  chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),ChessColor.WHITE,'p');
              }else if (chessboard.get(i).charAt(j)=='_'){
                  chessComponents[i][j]=new EmptySlotComponent(new ChessboardPoint(i,j),ChessColor.NONE,'_');
              }
          }
      }if (chessboard.get(8).charAt(0)=='w'){
         this.currentPlayer=ChessColor.WHITE;
        }else if (chessboard.get(8).charAt(0)=='b'){
          this.currentPlayer=ChessColor.BLACK;
        }ChessComponent.chessComponents=chessComponents;
      }

      public String getChessboardGraph (){
        StringBuilder sb=new StringBuilder();
        for (int i = 0;i<8;i++){
            for (int j = 0;j<8;j++){
                if (chessComponents[i][j].name=='K'){
                    sb.append("K");
                }else if (chessComponents[i][j].name=='Q'){
                    sb.append("Q");
                }else if (chessComponents[i][j].name=='B'){
                    sb.append("B");
                }else if (chessComponents[i][j].name=='N'){
                    sb.append("N");
                }else if (chessComponents[i][j].name=='R'){
                    sb.append("R");
                }else if (chessComponents[i][j].name=='P'){
                    sb.append("P");
                }else if (chessComponents[i][j].name=='k'){
                    sb.append("k");
                }else if (chessComponents[i][j].name=='q'){
                    sb.append("q");
                }else if (chessComponents[i][j].name=='b'){
                    sb.append("b");
                }else if (chessComponents[i][j].name=='n'){
                    sb.append("n");
                }else if (chessComponents[i][j].name=='r'){
                    sb.append("r");
                }else if (chessComponents[i][j].name=='p'){
                    sb.append("p");
            }else if (chessComponents[i][j].name=='_'){
                    sb.append("_");
                }
            }
            sb.append("\n");
        }
          return sb.toString();
      }
      public String getCapturedChess(ChessColor player) {
          int cnt1 = 0;
          int cnt2 = 0;
          int cnt3 = 0;
          int cnt4 = 0;
          int cnt5 = 0;
          int cnt6 = 0;
          StringBuilder counter = new StringBuilder();
          if (player.equals(ChessColor.WHITE)) {
              for (int i = 0; i < 8; i++) {
                  for (int j = 0; j < 8; j++) {
                      if (chessComponents[i][j].name == 'k') {
                          cnt1++;
                      } else if (chessComponents[i][j].name == 'q') {
                          cnt2++;
                      } else if (chessComponents[i][j].name == 'r') {
                          cnt3++;
                      } else if (chessComponents[i][j].name == 'b') {
                          cnt4++;
                      } else if (chessComponents[i][j].name == 'n') {
                          cnt5++;
                      } else if (chessComponents[i][j].name == 'p') {
                          cnt6++;
                      }
                  }
              }
              if (!(cnt1 == 1)) {
                  counter.append("k " + (1 - cnt1) + "\n");
              }
              if (!(cnt2 == 1)) {
                  counter.append("q " + (1 - cnt2) + "\n");
              }
              if (!(cnt3 == 2)) {
                  counter.append("r " + (2 - cnt3) + "\n");
              }
              if (!(cnt4 == 2)) {
                  counter.append("b " + (2 - cnt4) + "\n");
              }
              if (!(cnt5 == 2)) {
                  counter.append("n " + (2 - cnt5) + "\n");
              }
              if (!(cnt6 == 8)) {
                  counter.append("p " + (8 - cnt6) + "\n");
              }
              String s = counter.toString();
              return s;
          } else if (player.equals(ChessColor.BLACK)) {
              for (int i = 0; i < 8; i++) {
                  for (int j = 0; j < 8; j++) {
                      if (chessComponents[i][j].name == 'K') {
                          cnt1++;
                      } else if (chessComponents[i][j].name == 'Q') {
                          cnt2++;
                      } else if (chessComponents[i][j].name == 'R') {
                          cnt3++;
                      } else if (chessComponents[i][j].name == 'B') {
                          cnt4++;
                      } else if (chessComponents[i][j].name == 'N') {
                          cnt5++;
                      } else if (chessComponents[i][j].name == 'P') {
                          cnt6++;
                      }
                  }
              }
              if (!(cnt1 == 1)) {
                  counter.append("K " + (1 - cnt1) + "\n");
              }
              if (!(cnt2 == 1)) {
                  counter.append("Q " + (1 - cnt2) + "\n");
              }
              if (!(cnt3 == 2)) {
                  counter.append("R " + (2 - cnt3) + "\n");
              }
              if (!(cnt4 == 2)) {
                  counter.append("B " + (2 - cnt4) + "\n");
              }
              if (!(cnt5 == 2)) {
                  counter.append("N " + (2 - cnt5) + "\n");
              }
              if (!(cnt6 == 8)) {
                  counter.append("P " + (8 - cnt6) + "\n");
              }
              String s = counter.toString();
              return s;
          } else {
              return null;
          }
      }

    public ChessComponent getChess(int x, int y){
        ChessComponent chessComponent=chessComponents[x][y];
        return chessComponent;
    }
}
//class Point{
//    private int x;
//    private int y;
//
//    public int getX() {
//        return x;
//    }
//
//    public void setX(int x) {
//        this.x = x;
//    }
//
//    public int getY() {
//        return y;
//    }
//
//    public void setY(int y) {
//        this.y = y;
//    }
//
//    public Point(int x, int y) {
//        this.x = x;
//        this.y = y;
//    }
//    public Point(){}
//}

