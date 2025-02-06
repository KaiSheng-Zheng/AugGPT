import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends  ChessComponent {
    protected char name;
    public KingChessComponent(ChessColor chessColor) {
        this.chessColor=chessColor;
        if (chessColor == ChessColor.BLACK) {
            name = 'K';
        } else if (chessColor == ChessColor.WHITE) {
            name = 'k';
        }
    }
    @Override
    public String toString() {
        return String.valueOf(name);
    }

    public List<ChessboardPoint> canMoveTo() {
        this.chessColor=chessColor;
        int x= source.getX();
        int y=source.getY();
//        ChessColor chessColor=ChessColor.NONE;
        if(name=='K'){
      this.  chessColor=ChessColor.BLACK;
        }else if(name=='k'){
            this.   chessColor=ChessColor.WHITE;
    }
        ArrayList<ChessboardPoint>CanMovePoint=new ArrayList<>();
        //--------------------------------------------------------------
        if(x-1>=0){
            if(y-1>=0){
        if(!IfFriendsHere.thereAreFriend(x-1,y-1,chessColor )){
            CanMovePoint.add(new ChessboardPoint(x-1,y-1));
        }
            }
            if(y>=0){
                if(!IfFriendsHere.thereAreFriend(x-1,y,chessColor)){
                    CanMovePoint.add(new ChessboardPoint(x-1,y));
                }
            }
            if(y+1<8){
                if(!IfFriendsHere.thereAreFriend(x-1,y+1,chessColor)){
                    CanMovePoint.add(new ChessboardPoint(x-1,y+1));
                }
            }
        }
        //----------------------------------------------------
        if(x+1<8){
            if(y-1>=0){
                if(!IfFriendsHere.thereAreFriend(x+1,y-1,chessColor )){
                    CanMovePoint.add(new ChessboardPoint(x+1,y-1));
                }
            }
            if(y>=0){
                if(!IfFriendsHere.thereAreFriend(x+1,y,chessColor)){
                    CanMovePoint.add(new ChessboardPoint(x+1,y));
                }
            }
            if(y+1<8){
                if(!IfFriendsHere.thereAreFriend(x+1,y+1,chessColor)){
                    CanMovePoint.add(new ChessboardPoint(x+1,y+1));
                }
            }
        }
        //------------------------------------------------------------
        if(y+1<8){
            if(!IfFriendsHere.thereAreFriend(x,y+1,chessColor)){
                CanMovePoint.add(new ChessboardPoint(x,y+1));
            }
        }
        if(y-1>=0){
            if(!IfFriendsHere.thereAreFriend(x,y-1,chessColor )){
                CanMovePoint.add(new ChessboardPoint(x,y-1));
            }
        }
        //---------------------------------------------------------------
        return CanMovePoint;
    }
}
