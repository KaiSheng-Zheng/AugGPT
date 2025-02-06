import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ConcreteChessGame implements ChessGame{
    private ChessColor currentPlayer = ChessColor.WHITE;
    private ChessComponent[][] chessComponents = new ChessComponent[8][8];
    static List<String> chessboard ;

    @Override
    public void loadChessGame(List<String> chessboard) {
        this.chessboard = chessboard;
        if(chessboard.get(8).equals("w")){
            currentPlayer = ChessColor.WHITE;
        }
        else currentPlayer = ChessColor.BLACK;
        for(int i = 0; i <8; i ++){
            for(int j = 0 ; j  <8; j ++){
                if (chessboard.get(i).charAt(j) == 'K') {
                    chessComponents[i][j]= new KingChessComponent(i,j,ChessColor.BLACK,'K', chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'Q') {
                    chessComponents[i][j]= new QueenChessComponent(i,j,ChessColor.BLACK,'Q', chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'R') {
                    chessComponents[i][j]= new RookChessComponent(i,j,ChessColor.BLACK,'R', chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'B') {
                    chessComponents[i][j]= new BishopChessComponent(i,j,ChessColor.BLACK,'B', chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'N') {
                    chessComponents[i][j]= new KnightChessComponent(i,j,ChessColor.BLACK,'N', chessComponents);
                } else if (chessboard.get(i).charAt(j) == 'P') {
                    chessComponents[i][j]= new PawnChessComponent(i,j,ChessColor.BLACK,'P', chessComponents);
                }
                else if (chessboard.get(i).charAt(j) == 'k') {
                    chessComponents[i][j]= new KingChessComponent(i,j,ChessColor.WHITE,'k', chessComponents);
                }
                else if (chessboard.get(i).charAt(j) == 'q') {
                    chessComponents[i][j]= new QueenChessComponent(i,j,ChessColor.WHITE,'q',chessComponents);
                }
                else if (chessboard.get(i).charAt(j)== 'r') {
                    chessComponents[i][j]= new RookChessComponent(i,j,ChessColor.WHITE,'r',chessComponents);
                }
                else if (chessboard.get(i).charAt(j) == 'b') {
                    chessComponents[i][j]= new BishopChessComponent(i,j,ChessColor.WHITE,'b',chessComponents);
                }
                else if (chessboard.get(i).charAt(j) == 'n') {
                    chessComponents[i][j]= new KnightChessComponent(i,j,ChessColor.WHITE,'n',chessComponents);
                }
                else if (chessboard.get(i).charAt(j) == 'p') {
                    chessComponents[i][j]= new PawnChessComponent(i,j,ChessColor.WHITE,'p',chessComponents);
                }
                else {
                    chessComponents[i][j]= new EmptySlotComponent(i,j,ChessColor.NONE,'_',chessComponents);
                }
            }
        }

   }

    @Override
    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }

    @Override
    public String getChessboardGraph() {
        String x= String.format("%s\n%s\n%s\n%s\n%s\n%s\n%s\n%s",chessboard.get(0),chessboard.get(1)
        ,chessboard.get(2),chessboard.get(3),chessboard.get(4),chessboard.get(5),
                chessboard.get(6),chessboard.get(7));
        return x;
    }
    @Override
    public String getCapturedChess(ChessColor player) {
        int King = 1 ;
        int Queen = 1;
        int Rooks = 2;
        int  Bishops  = 2;
         int Knights  =2;
         int Pawns = 8;
        for(int i = 0 ; i <8;  i ++){
            for(int j = 0 ; j <8 ; j ++){
                if(player == ChessColor.BLACK ) {
                    if (chessboard.get(i).charAt(j) == 'K') {
                        King--;
                    } else if (chessboard.get(i).charAt(j) == 'Q') {
                        Queen--;
                    } else if (chessboard.get(i).charAt(j) == 'R') {
                        Rooks--;
                    } else if (chessboard.get(i).charAt(j) == 'B') {
                        Bishops--;
                    } else if (chessboard.get(i).charAt(j) == 'N') {
                        Knights--;
                    } else if (chessboard.get(i).charAt(j) == 'P') {
                        Pawns--;
                    }
                }
                if(player == ChessColor.WHITE ) {
                    if (chessboard.get(i).charAt(j) == 'k') {
                        King--;
                    } else if (chessboard.get(i).charAt(j) == 'q') {
                        Queen--;
                    } else if (chessboard.get(i).charAt(j)== 'r') {
                        Rooks--;
                    } else if (chessboard.get(i).charAt(j) == 'b') {
                        Bishops--;
                    } else if (chessboard.get(i).charAt(j) == 'n') {
                        Knights--;
                    } else if (chessboard.get(i).charAt(j) == 'p') {
                        Pawns--;
                    }
                }
            }
        }

         String k = King+"";
         String q = Queen+"";
         String r = Rooks+"";
         String b = Bishops+"";
         String n = Knights+"";
         String p = Pawns+"";
         StringBuilder  result = new StringBuilder();
         if(player==ChessColor.BLACK) {
             if (King != 0) {
                 result.append("K ");
                 result.append(k);
                 result.append("\n");

             }
             if (Queen != 0) {
                 result.append("Q ");
                 result.append(q);
                 result.append("\n");
             }
             if (Rooks != 0) {
                 result.append("R ");
                 result.append(r);
                 result.append("\n");
             }
             if (Bishops != 0) {
                 result.append("B ");
                 result.append(b);
                 result.append("\n");
             }
             if (Knights != 0) {
                 result.append("N ");
                 result.append(n);
                 result.append("\n");
             }
             if (Pawns != 0) {
                 result.append("P ");
                 result.append(p);
                 result.append("\n");
             }
         }
         else if(player==ChessColor.WHITE){
             if (King != 0) {
                 result.append("k ");
                 result.append(k);
                 result.append("\n");

             }
             if (Queen != 0) {
                 result.append("q ");
                 result.append(q);
                 result.append("\n");
             }
             if (Rooks != 0) {
                 result.append("r ");
                 result.append(r);
                 result.append("\n");
             }
             if (Bishops != 0) {
                 result.append("b ");
                 result.append(b);
                 result.append("\n");
             }
             if (Knights != 0) {
                 result.append("n ");
                 result.append(n);
                 result.append("\n");
             }
             if (Pawns != 0) {
                 result.append("p ");
                 result.append(p);
                 result.append("\n");
             }
         }
         String s = result.toString();
        return s;
    }
    @Override
    public ChessComponent getChess(int x, int y ){
        return chessComponents[x][y];
    }
    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        List<ChessboardPoint> chessboardPoints = getChess(source.getX(),source.getY()).canMoveTo();
        for (int i = 0; i < chessboardPoints.size()- 1; i++) {
            for (int j = 0; j < chessboardPoints.size() - 1 - i; j++) {
                if (chessboardPoints.get(j).getX() > chessboardPoints.get(j + 1).getX()) {
                    Collections.swap(chessboardPoints, j, j + 1);
                }
            }
        }
            for (int i = 0; i < chessboardPoints.size()- 1; i++) {
                for (int j = 0; j < chessboardPoints.size() - 1 - i; j++) {
                    if (chessboardPoints.get(j).getY() > chessboardPoints.get(j + 1).getY() &&
                            chessboardPoints.get(j).getX() == chessboardPoints.get(j + 1).getX()) {
                        Collections.swap(chessboardPoints, j, j + 1);
                    }
                }
            }
        return chessboardPoints;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        boolean canmove =false;
        ChessComponent chessComponent= getChess(sourceX,sourceY);
        List<ChessboardPoint> chessboardPoints = chessComponent.canMoveTo();
        ChessboardPoint chessboardPoint = new ChessboardPoint(targetX,targetY);
        if(chessComponent.chessColor ==currentPlayer) {
            for (int i = 0; i < chessboardPoints.size(); i++) {
                if (chessboardPoint.getX() == chessboardPoints.get(i).getX() &&chessboardPoint.getY() ==chessboardPoints.get(i).getY()) {
                    canmove = true;
                }
            }
        }
        if(canmove){
            ChessComponent target= getChess(sourceX,sourceY);
            ChessComponent temp =target;
            char temp_ = chessboard.get(sourceX).charAt(sourceY);
            StringBuilder stringBuilder1 = new StringBuilder(chessboard.get(sourceX));
            if(chessComponents[targetX][targetY].chessColor!=chessComponents[sourceX][sourceY].chessColor){
                stringBuilder1.replace(sourceY, sourceY + 1, String.valueOf('_'));
            }else {
                stringBuilder1.replace(sourceY, sourceY + 1, String.valueOf(chessboard.get(targetX).charAt(targetY)));
            }
            chessboard.set(sourceX,stringBuilder1.toString());
            StringBuilder stringBuilder2 = new StringBuilder(chessboard.get(targetX));
            stringBuilder2.replace(targetY,targetY+1, String.valueOf(temp_));
            chessboard.set(targetX,stringBuilder2.toString());
            if(chessComponents[targetX][targetY].chessColor!=chessComponents[sourceX][sourceY].chessColor){
                chessComponents[sourceX][sourceY] = new EmptySlotComponent(sourceX,sourceY,ChessColor.NONE,'_',chessComponents);
            }
            else {
                chessComponents[sourceX][sourceY] = getChess(targetX, targetY);
            }
            chessComponents[targetX][targetY] =temp;
           for(int i =0; i <8; i ++){
               for(int j = 0 ; j <8; j ++){
                   chessComponents[i][j].setSource(new ChessboardPoint(i,j));

               }
           }
            for(int i =0; i <8; i ++){
                for(int j = 0 ; j <8; j ++){
                    chessComponents[i][j].setChessComponents(chessComponents);
                }
            }
            currentPlayer = currentPlayer == ChessColor.BLACK ? ChessColor.WHITE : ChessColor.BLACK;
        }
        return canmove;
    }
}
