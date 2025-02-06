import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    public ConcreteChessGame() {
        chessComponents = new ChessComponent[8][8];
        currentPlayer = ChessColor.WHITE;
    }
    public void loadChessGame(List<String> chessboard) {
        if (chessboard.get(8).charAt(0) == 'w') {
            currentPlayer = ChessColor.WHITE;
        } else {
            currentPlayer = ChessColor.BLACK;
        }
       for (int i = 0; i < 8; i++) {
           for (int j = 0; j < 8; j++) {
               switch (chessboard.get(i).charAt(j)) {
                   case 'P':{
                       chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),chessComponents, 'P');
                       break; }
                   case 'R':{
                       chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),chessComponents,  'R');
                       break; }
                   case 'N':{
                       chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),chessComponents,  'N');
                       break; }
                   case 'B':{
                       chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),chessComponents, 'B');
                       break; }
                   case 'Q':{
                       chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),chessComponents, 'Q');
                       break; }
                   case 'K':{
                       chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),chessComponents, 'K');
                       break; }
                   case 'p':{
                       chessComponents[i][j]=new PawnChessComponent(new ChessboardPoint(i,j),chessComponents, 'p');
                       break; }
                   case 'r':{
                       chessComponents[i][j]=new RookChessComponent(new ChessboardPoint(i,j),chessComponents, 'r');
                       break; }
                   case 'n':{
                       chessComponents[i][j]=new KnightChessComponent(new ChessboardPoint(i,j),chessComponents, 'n');
                       break; }
                   case 'b':{
                       chessComponents[i][j]=new BishopChessComponent(new ChessboardPoint(i,j),chessComponents, 'b');
                       break; }
                  case 'q':{
                       chessComponents[i][j]=new QueenChessComponent(new ChessboardPoint(i,j),chessComponents, 'q');
                       break; }
                   case 'k':{
                       chessComponents[i][j]=new KingChessComponent(new ChessboardPoint(i,j),chessComponents,  'k');
                       break; }
                   case '_':{
                       chessComponents[i][j]=new EmptyChessComponent(new ChessboardPoint(i,j),chessComponents,'_');
                  break;
                   }
               }
           }
       }
   }
public ChessColor getCurrentPlayer(){
        return this.currentPlayer;
}
public String getChessboardGraph(){
        String result="";
    for (int i = 0; i < 8; i++) {
        for (int j = 0; j < 8; j++) {
        result=result+chessComponents[i][j].getName();

        }
   result=result + "\n";
    }

return result;}
 public String getCapturedChess(ChessColor chessColor){
     String result="";
        int countPawnBlack=0;;int countRookBlack=0;
      int countKnightBlack=0;
        int countBishopBlack=0; int countKingBlack=0;
        int countQueenBlack=0;
   if (chessColor==chessColor.BLACK){
     for (int i = 0; i < 8; i++) {
         for (int j = 0; j < 8; j++) {
             switch (chessComponents[i][j].getName()) {
                 case 80:{
                     countPawnBlack++;
                       break;
                 }
                 case 82:{
                     countRookBlack++;
                     break;
                 }
                 case 78:{
                     countKnightBlack++;
                             break;
                 }
                 case 66:{
                     countBishopBlack++;
                     break;
                 }
                 case 81:{
                     countQueenBlack++;
                     break;
                 }
                 case 75:{
                     countKingBlack++;
                     break;
                 }
             }
         }}
       countPawnBlack=8-countPawnBlack;
       countBishopBlack=2-countBishopBlack;
       countKnightBlack=2-countKnightBlack;
       countRookBlack=2-countRookBlack;
       countQueenBlack=1-countQueenBlack;
       countKingBlack=1-countKingBlack;

       if (countKingBlack!=0){
result=result+"K "+countKingBlack+"\n";
       }
         if (countQueenBlack!=0){
      result=result+"Q "+countQueenBlack+"\n";
  }
  if (countRookBlack!=0){
     result=result+"R "+countRookBlack+"\n";
  }
if (countBishopBlack!=0){
    result=result+"B "+countBishopBlack+"\n";
}
  if (countKnightBlack!=0){
      result=result+"N "+countKnightBlack+"\n";
  }
   if (countPawnBlack!=0) {
       result=result+"P "+countPawnBlack+"\n";
   }

     }
     else if((chessColor==chessColor.WHITE)){
         for (int i = 0; i < 8; i++) {
             for (int j = 0; j < 8; j++) {
                 switch (chessComponents[i][j].getName()) {
                     case 112:{
                         countPawnBlack++;
                         break;
                     }
                     case 114:{
                         countRookBlack++;
                         break;
                     }
                     case 110:{
                         countKnightBlack++;
                         break;
                     }
                     case 98:{
                         countBishopBlack++;
                         break;
                     }
                     case 113:{
                         countQueenBlack++;
                         break;
                     }
                     case 107:{
                         countKingBlack++;
                         break;
                     }
                 }
             }
         }
         countPawnBlack=8-countPawnBlack;
         countBishopBlack=2-countBishopBlack;
         countKnightBlack=2-countKnightBlack;
         countRookBlack=2-countRookBlack;
         countQueenBlack=1-countQueenBlack;
      countKingBlack=1-countKingBlack;

         if (countKingBlack!=0){
             result=result+"k "+countKingBlack+"\n";

         }

         if (countQueenBlack!=0){
             result=result+"q "+countQueenBlack+"\n";
         }
         if (countRookBlack!=0){
             result=result+"r "+countRookBlack+"\n";
         }
         if (countBishopBlack!=0){
             result=result+"b "+countBishopBlack+"\n";
         }
         if (countKnightBlack!=0){
             result=result+"n "+countKnightBlack+"\n";
         }
         if (countPawnBlack!=0) {
             result=result+"p "+countPawnBlack+"\n";
         }
   }
   return result; }
    public ChessComponent getChess(int x,int y){
return chessComponents[x][y];
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
       ChessComponent chess=chessComponents[source.getX()][source.getY()];
        ArrayList<ChessboardPoint> point=new ArrayList<>();
List <ChessboardPoint> canMoveToPoint=chess.canMoveTo();
      canMoveToPoint.sort(new Comparator<ChessboardPoint>() {
          @Override
          public int compare(ChessboardPoint o1, ChessboardPoint o2) {
              if (o1.getX()>o2.getX()) {
                  return 0;
              }
           else if (o1.getX()<o2.getX()) {
                  return -2;
              }
   else if (o1.getY()>=o2.getY()){
         return 0;
     }
else return -2;
     }
      });
      for (int i=0;i<canMoveToPoint.size();i++){
          point.add(canMoveToPoint.get(i));
      }
   return point;}

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        int judge = 1;
        if (chessComponents[sourceX][sourceY].canMoveTo().contains((new ChessboardPoint(targetX, targetY))) && chessComponents[sourceX][sourceY].name >= 97 && getCurrentPlayer() == ChessColor.WHITE) {

            currentPlayer = ChessColor.BLACK;
            judge = 0;
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = (new EmptyChessComponent(new ChessboardPoint(sourceX, sourceY), chessComponents, '_'));
        } else if (chessComponents[sourceX][sourceY].canMoveTo().contains((new ChessboardPoint(targetX, targetY))) && chessComponents[sourceX][sourceY].name <= 90 && getCurrentPlayer() == ChessColor.BLACK) {
            currentPlayer = ChessColor.WHITE;
            judge = 0;
            chessComponents[targetX][targetY] = chessComponents[sourceX][sourceY];
            chessComponents[sourceX][sourceY] = (new EmptyChessComponent(new ChessboardPoint(sourceX, sourceY), chessComponents, '_'));

        }
        if (judge == 0) {
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    switch (chessComponents[i][j].name) {
                        case 'P': {
                            chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), chessComponents, 'P');
                            break;
                        }
                        case 'R': {
                            chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), chessComponents, 'R');
                            break;
                        }
                        case 'N': {
                            chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), chessComponents, 'N');
                            break;
                        }
                        case 'B': {
                            chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), chessComponents, 'B');
                            break;
                        }
                        case 'Q': {
                            chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), chessComponents, 'Q');
                            break;
                        }
                        case 'K': {
                            chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), chessComponents, 'K');
                            break;
                        }
                        case 'p': {
                            chessComponents[i][j] = new PawnChessComponent(new ChessboardPoint(i, j), chessComponents, 'p');
                            break;
                        }
                        case 'r': {
                            chessComponents[i][j] = new RookChessComponent(new ChessboardPoint(i, j), chessComponents, 'r');
                            break;
                        }
                        case 'n': {
                            chessComponents[i][j] = new KnightChessComponent(new ChessboardPoint(i, j), chessComponents, 'n');
                            break;
                        }
                        case 'b': {
                            chessComponents[i][j] = new BishopChessComponent(new ChessboardPoint(i, j), chessComponents, 'b');
                            break;
                        }
                        case 'q': {
                            chessComponents[i][j] = new QueenChessComponent(new ChessboardPoint(i, j), chessComponents, 'q');
                            break;
                        }
                        case 'k': {
                            chessComponents[i][j] = new KingChessComponent(new ChessboardPoint(i, j), chessComponents, 'k');
                            break;
                        }
                        case '_': {
                            chessComponents[i][j] = new EmptyChessComponent(new ChessboardPoint(i, j), chessComponents, '_');
                            break;
                        }
                    }


                }
            }
        }
    if (judge==1){
        return false;
    }
    else return true;
    }




    public  ChessComponent[][] getChessComponents() {
        return chessComponents;
    }
}

