import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends  ChessComponent{
    protected char name;
    public BishopChessComponent(ChessColor chessColor){
        this.chessColor=chessColor;
        if(chessColor==ChessColor.BLACK){
            name='B';
        }else if(chessColor==ChessColor.WHITE){
            name='b';
        }
    }
    @Override
    public String toString() {
        return String.valueOf(name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=source.getX();
        int y=source.getY();
//        ChessColor chessColor = ChessColor.NONE;
        ArrayList<ChessboardPoint> CanMovePoint = new ArrayList<>();
        if (name == 'B') {
            this.    chessColor = ChessColor.BLACK;
        } else if (name == 'b') {
            this.   chessColor = ChessColor.WHITE;
        }
        for(int i=x+1,j=y+1;i<8&&j<8;i++,j++){
            if(IfEnemyHere.thereAreEnemy(i,j,chessColor)){
                CanMovePoint.add(new ChessboardPoint(i,j));
                break;
            }
            if(IfFriendsHere.thereAreFriend(i,j,chessColor)){
                break;
            }
            CanMovePoint.add(new ChessboardPoint(i,j));
        }
        for(int i=x+1,j=y-1;i<8&&j>=0;i++,j--){
            if(IfEnemyHere.thereAreEnemy(i,j,chessColor)){
                CanMovePoint.add(new ChessboardPoint(i,j));
                break;
            }
            if(IfFriendsHere.thereAreFriend(i,j,chessColor)){
                break;
            }
            CanMovePoint.add(new ChessboardPoint(i,j));
        }
        for(int i=x-1,j=y+1;i>=0&&j<8;i--,j++){
            if(IfEnemyHere.thereAreEnemy(i,j,chessColor)){
                CanMovePoint.add(new ChessboardPoint(i,j));
                break;
            }
            if(IfFriendsHere.thereAreFriend(i,j,chessColor)){
                break;
            }
            CanMovePoint.add(new ChessboardPoint(i,j));
        }
        for(int i=x-1,j=y-1;i>=0&&j>=0;i--,j--){
            if(IfEnemyHere.thereAreEnemy(i,j,chessColor)){
                CanMovePoint.add(new ChessboardPoint(i,j));
                break;
            }
            if(IfFriendsHere.thereAreFriend(i,j,chessColor)){
                break;
            }
            CanMovePoint.add(new ChessboardPoint(i,j));
        }
         return  CanMovePoint;

    }

}
