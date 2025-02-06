import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    protected char name;
    public KnightChessComponent (ChessColor chessColor){
        this.chessColor=chessColor;
        if(chessColor==ChessColor.BLACK){
            name='N';
        }else if(chessColor==ChessColor.WHITE){
            name='n';
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
//    ChessColor chessColor=ChessColor.NONE;
    if(name=='N'){
        this. chessColor=ChessColor.BLACK;
    }else if(name=='n'){
        this.  chessColor=ChessColor.WHITE;
    }
        ArrayList<ChessboardPoint>CanMovePoint=new ArrayList<>();
//-----------------------------------------------------------------
    if(x-2>=0){
        if(y+1<8){
            if(!IfFriendsHere.thereAreFriend(x-2,y+1,chessColor)){
                CanMovePoint.add(new ChessboardPoint(x-2,y+1));
            }
        }
        if(y-1>=0){
            if(!IfFriendsHere.thereAreFriend(x-2,y-1,chessColor)){
                CanMovePoint.add(new ChessboardPoint(x-2,y-1));
            }
        }
    }
    //-------------------------------------------------------------------
    if(x+2<8){
        if(y+1<8){
            if(!IfFriendsHere.thereAreFriend(x+2,y+1,chessColor)){
                CanMovePoint.add(new ChessboardPoint(x+2,y+1));
            }
        }
        if(y-1>=0){
            if(!IfFriendsHere.thereAreFriend(x+2,y-1,chessColor)){
                CanMovePoint.add(new ChessboardPoint(x+2,y-1));
            }
        }
    }
    //------------------------------------------------------------------------
    if(y+2<8){
        if(x+1<8){
            if(!IfFriendsHere.thereAreFriend(x+1,y+2,chessColor)){
                CanMovePoint.add(new ChessboardPoint(x+1,y+2));
            }
     }
    if(x-1>=0){
        if(!IfFriendsHere.thereAreFriend(x-1,y+2,chessColor)){
            CanMovePoint.add(new ChessboardPoint(x-1,y+2));
         }
    }
}
        //-----------------------------------------------------------------------------------
        if(y-2>=0){
            if(x+1<8){
                if(!IfFriendsHere.thereAreFriend(x+1,y-2,chessColor)){
                    CanMovePoint.add(new ChessboardPoint(x+1,y-2));
                }
            }
            if(x-1>=0){
                if(!IfFriendsHere.thereAreFriend(x-1,y-2,chessColor)){
                    CanMovePoint.add(new ChessboardPoint(x-1,y-2));
                }
            }
        }
        //--------------------------------------------------------------------------------------
        return CanMovePoint;

    }
}
