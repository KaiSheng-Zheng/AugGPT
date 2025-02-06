import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends  ChessComponent{
   protected char name;
    public QueenChessComponent(ChessColor chessColor){
        this.chessColor=chessColor;
        if(chessColor==ChessColor.BLACK){
            name='Q';
        }else if(chessColor==ChessColor.WHITE){
            name='q';
        }
    }
    @Override
    public String toString() {
        return String.valueOf(name);
    }


    public List<ChessboardPoint> canMoveTo() {
        int x = source.getX();
        int y = source.getY();
        if (name == 'Q') {
            this.chessColor = ChessColor.BLACK;
        } else if (name == 'q') {
            this.chessColor = ChessColor.WHITE;
        }
        ArrayList<ChessboardPoint> CanMovePoint = new ArrayList<>();
        //-------------------------------------------------------------
        for(int i=x+1;i<8;i++){
            if(IfEnemyHere.thereAreEnemy(i,y,chessColor)){
                CanMovePoint.add(new ChessboardPoint(i,y));
                break;
            }
            if(IfFriendsHere.thereAreFriend(i,y,chessColor)){
                break;
            }
            CanMovePoint.add(new ChessboardPoint(i,y));
        }

        for(int i=x-1;i>=0;i--){
            if(IfEnemyHere.thereAreEnemy(i,y,chessColor)){
                CanMovePoint.add(new ChessboardPoint(i,y));
                break;
            }
            if(IfFriendsHere.thereAreFriend(i,y,chessColor)){
                break;
            }
            CanMovePoint.add(new ChessboardPoint(i,y));
        }
        for(int j=y+1;j<8;j++){
            if(IfEnemyHere.thereAreEnemy(x,j,chessColor)){
                CanMovePoint.add(new ChessboardPoint(x,j));
                break;
            }
            if(IfFriendsHere.thereAreFriend(x,j,chessColor)){
                break;
            }
            CanMovePoint.add(new ChessboardPoint(x,j));
        }
        for(int j=y-1;j>=0;j--){
            if(IfEnemyHere.thereAreEnemy(x,j,chessColor)){
                CanMovePoint.add(new ChessboardPoint(x,j));
                break;
            }
            if(IfFriendsHere.thereAreFriend(x,j,chessColor)){
                break;
            }
            CanMovePoint.add(new ChessboardPoint(x,j));
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
     return CanMovePoint;
    }
}
