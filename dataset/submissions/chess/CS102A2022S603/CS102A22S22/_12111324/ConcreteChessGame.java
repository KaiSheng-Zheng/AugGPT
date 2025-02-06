
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class ConcreteChessGame implements ChessGame {
    private ChessComponent[][] chessComponents;
    private ChessColor currentPlayer;
    private static ChessComponent[][] staticChessComponents;

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public void setCurrentPlayer(ChessColor currentPlayer) {
        this.currentPlayer = currentPlayer;
    }

    public void setStaticChessComponents() {
        staticChessComponents=getChessComponents();
    }

    public static ChessColor getStaticChessColor(ChessboardPoint chessboardPoint){
        return staticChessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor();
    }

    public ConcreteChessGame(){
        chessComponents=new ChessComponent[8][8];
        currentPlayer=ChessColor.WHITE;
    }
    public void loadChessGame(List<String> chessboard) {
        if (Objects.equals(chessboard.get(8), "w"))
            this.currentPlayer=ChessColor.WHITE;
        if (Objects.equals(chessboard.get(8), "b"))
            this.currentPlayer=ChessColor.BLACK;
        for (int x=0;x<8;x++){
            for (int y=0;y<8;y++){
                switch (chessboard.get(x).charAt(y)){
                    case 'K':
                        chessComponents[x][y]=new KingChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'K');
                        break;
                    case 'k':
                        chessComponents[x][y]=new KingChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'k');
                        break;
                    case 'Q':
                        chessComponents[x][y]=new QueenChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'Q');
                        break;
                    case 'q':
                        chessComponents[x][y]=new QueenChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'q');
                        break;
                    case 'R':
                        chessComponents[x][y]=new RookChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'R');
                        break;
                    case 'r':
                        chessComponents[x][y]=new RookChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'r');
                        break;
                    case 'B':
                        chessComponents[x][y]=new BishopChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'B');
                        break;
                    case 'b':
                        chessComponents[x][y]=new BishopChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'b');
                        break;
                    case 'P':
                        chessComponents[x][y]=new PawnChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'P');
                        break;
                    case 'p':
                        chessComponents[x][y]=new PawnChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'p');
                        break;
                    case 'N':
                        chessComponents[x][y]=new KnightChessComponent(new ChessboardPoint(x,y),ChessColor.BLACK,'N');
                        break;
                    case 'n':
                        chessComponents[x][y]=new KnightChessComponent(new ChessboardPoint(x,y),ChessColor.WHITE,'n');
                        break;
                    case '_':
                        chessComponents[x][y]=new EmptySlotComponent(new ChessboardPoint(x,y));
                        break;
                    default:
                        break;
                }
            }
        }
        setStaticChessComponents();
    }


    public ChessColor getCurrentPlayer() {
        return this.currentPlayer;
    }


    public ChessComponent getChess(int x, int y) {
        return this.chessComponents[x][y];
    }


    public String getCapturedChess(ChessColor player) {
        StringBuilder result= new StringBuilder();
        int[] chessNumber={1,1,2,2,2,8};
       if (player==ChessColor.WHITE){
           for (int x=0;x<8;x++){
               for (int y=0;y<8;y++){
                   switch (chessComponents[x][y].getName()){
                       case 'k':
                           chessNumber[0]--;
                           break;
                       case 'q':
                           chessNumber[1]--;
                           break;
                       case 'r':
                           chessNumber[2]--;
                           break;
                       case 'b':
                           chessNumber[3]--;
                           break;
                       case 'n':
                           chessNumber[4]--;
                           break;
                       case 'p':
                           chessNumber[5]--;
                           break;
                       default:
                           break;
                   }
               }
           }
           for (int i=0;i<6;i++){
               if (chessNumber[i]!=0)
                   switch (i){
                       case 0:
                           result.append("k").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       case 1:
                           result.append("q").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       case 2:
                           result.append("r").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       case 3:
                           result.append("b").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       case 4:
                           result.append("n").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       case 5:
                           result.append("p").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       default:
                           break;
                   }
           }
           return result.toString();
       }else {
           for (int x=0;x<8;x++){
               for (int y=0;y<8;y++){
                   switch (chessComponents[x][y].getName()){
                       case 'K':
                           chessNumber[0]--;
                           break;
                       case 'Q':
                           chessNumber[1]--;
                           break;
                       case 'R':
                           chessNumber[2]--;
                           break;
                       case 'B':
                           chessNumber[3]--;
                           break;
                       case 'N':
                           chessNumber[4]--;
                           break;
                       case 'P':
                           chessNumber[5]--;
                           break;
                       default:
                           break;
                   }
               }
           }
           for (int i=0;i<6;i++){
               if (chessNumber[i]!=0)
                   switch (i){
                       case 0:
                           result.append("K").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       case 1:
                           result.append("Q").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       case 2:
                           result.append("R").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       case 3:
                           result.append("B").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       case 4:
                           result.append("N").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       case 5:
                           result.append("P").append(" ").append(chessNumber[i]).append("\n");
                           break;
                       default:
                           break;
                   }
           }
           return result.toString();
       }
    }

    @Override
    public List<ChessboardPoint> getCanMovePoints(ChessboardPoint source) {
        ChessComponent chess=getChess(source.getX(),source.getY());
        List<ChessboardPoint> canMovePoints=chess.canMoveTo();
        ArrayList<ChessboardPoint> result=new ArrayList<>();
        ArrayList<Integer> value=new ArrayList<>();
        for (int i=0;i<canMovePoints.size();i++){
            if (canMovePoints.get(i)==null)
                continue;
            value.add(10*canMovePoints.get(i).getX()+canMovePoints.get(i).getY());
        }
        Collections.sort(value);
        for (int x=0;x<canMovePoints.size();x++){
            for (int y=0;y<canMovePoints.size();y++){
                if (value.get(x) ==10*canMovePoints.get(y).getX()+canMovePoints.get(y).getY()){
                    result.add(canMovePoints.get(y));
                }
            }
        }
        return result;
    }

    @Override
    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        ChessComponent chess=getChess(sourceX,sourceY);
        List<ChessboardPoint> canMovePoints=chess.canMoveTo();
        if (chess.getChessColor()!=getCurrentPlayer())
            return false;
        for (int i=0;i<canMovePoints.size();i++){
            if (canMovePoints.get(i).getX()==targetX&&canMovePoints.get(i).getY()==targetY){
                chess.setSource(new ChessboardPoint(targetX,targetY));
             chessComponents[targetX][targetY]=chess;
             chessComponents[sourceX][sourceY]=new EmptySlotComponent(new ChessboardPoint(sourceX,sourceY));
             if (getCurrentPlayer()==ChessColor.BLACK){
                 setCurrentPlayer(ChessColor.WHITE);
             }else setCurrentPlayer(ChessColor.BLACK);
             setStaticChessComponents();
             return true;
            }
        }
        return false;
    }

    public String getChessboardGraph(){
        StringBuilder graph = new StringBuilder();
        for (int x=0;x<7;x++){
            for (int y=0;y<8;y++){
                graph.append(chessComponents[x][y].getName());
            }
            graph.append("\n");
        }
        for (int i=0;i<8;i++){
            graph.append(chessComponents[7][i].getName());
        }
        return graph.toString();
    }
}
