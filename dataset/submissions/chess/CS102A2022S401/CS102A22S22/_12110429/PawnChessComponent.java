import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
   protected char name;
    public PawnChessComponent (ChessColor chessColor){
        this.chessColor=chessColor;
        if(chessColor==ChessColor.BLACK){
            name='P';
        }else if(chessColor==ChessColor.WHITE){
            name='p';
        }
    }
    @Override
    public String toString() {
        return String.valueOf(name);
    }


    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        if (name == 'P') {
            this.chessColor = ChessColor.BLACK;
        } else if (name == 'p') {
            this.chessColor = ChessColor.WHITE;
        }
        ArrayList<ChessboardPoint> CanMovePoint = new ArrayList<>();
//        //------------------------------------------------------
        if(chessColor==ChessColor.BLACK&&x==1&&!IfFriendsHere.thereAreFriend(x+1,y,chessColor)&&!IfFriendsHere.thereAreFriend(x+2,y,chessColor)&&!IfEnemyHere.thereAreEnemy(x+1,y,chessColor)&&!IfEnemyHere.thereAreEnemy(x+2,y,chessColor)){
            CanMovePoint.add(new ChessboardPoint(x+2,y));
        }
        if(chessColor==ChessColor.WHITE&&x==6&&!IfFriendsHere.thereAreFriend(x-1,y,chessColor)&&!IfFriendsHere.thereAreFriend(x-2,y,chessColor)&&!IfEnemyHere.thereAreEnemy(x-1,y,chessColor)&&!IfEnemyHere.thereAreEnemy(x-2,y,chessColor)){
            CanMovePoint.add(new ChessboardPoint(x-2,y));
        }
        //-------------------------------------------------------(chessColor==ChessColor.WHITE&&x==6)
        if(chessColor==ChessColor.BLACK) {
            if (x + 1 < 8 && !IfFriendsHere.thereAreFriend(x + 1, y, chessColor) && !IfEnemyHere.thereAreEnemy(x + 1, y, chessColor)) {
                CanMovePoint.add(new ChessboardPoint(x + 1, y));
            }
            //---------------------------------------------------------
            if(x+1<8) {
                if(y+1<8) {
                    if (IfEnemyHere.thereAreEnemy(x + 1, y + 1, chessColor)) {
                        CanMovePoint.add(new ChessboardPoint(x + 1, y + 1));
                    }
                }
                if(y-1>=0) {
                    if (IfEnemyHere.thereAreEnemy(x + 1, y - 1, chessColor)) {
                        CanMovePoint.add(new ChessboardPoint(x + 1, y - 1));
                    }
                }
            }
        }else if(chessColor==ChessColor.WHITE){
            if (x -1 >=0 && !IfFriendsHere.thereAreFriend(x -1, y, chessColor) && !IfEnemyHere.thereAreEnemy(x -1, y, chessColor)) {
                CanMovePoint.add(new ChessboardPoint(x -1, y));
            }
            //---------------------------------------------------------
            if(x-1>=0) {
                if(y+1<8) {
                    if (IfEnemyHere.thereAreEnemy(x - 1, y + 1, chessColor)) {
                        CanMovePoint.add(new ChessboardPoint(x - 1, y + 1));
                    }
                }
                if(y-1>=0) {
                    if (IfEnemyHere.thereAreEnemy(x - 1, y - 1, chessColor)) {
                        CanMovePoint.add(new ChessboardPoint(x - 1, y - 1));
                    }
                }
            }
        }
      //  -------------------------------------------------------------

        return CanMovePoint;


    }
}
 