import java.util.ArrayList;
import java.util.List;

public  class KingChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> KingMoveList = new ArrayList<>();
        int departure = 1;
        //UP-RIGHT
        if (getSource().offset(departure,departure) != null){
            if (IsThereOtherPiece(departure + getSource().getX(),departure + getSource().getY()) == 1){
                KingMoveList.add(new ChessboardPoint(departure + getSource().getX(),departure + getSource().getY()));
            }
        }
        //UP
        if (getSource().offset(0,departure) != null){
            if (IsThereOtherPiece( getSource().getX(),departure + getSource().getY()) == 1){
                KingMoveList.add(new ChessboardPoint( getSource().getX(),departure + getSource().getY()));
            }
        }
        //UP-Left
        if (getSource().offset(-departure,departure) != null){
            if (IsThereOtherPiece( -departure + getSource().getX(),departure + getSource().getY()) == 1){
                KingMoveList.add(new ChessboardPoint( -departure + getSource().getX(),departure + getSource().getY()));
            }
        }
        //LEFT
        if (getSource().offset(-departure,0) != null){
            if (IsThereOtherPiece( -departure + getSource().getX(),getSource().getY()) == 1){
                KingMoveList.add(new ChessboardPoint( -departure + getSource().getX(),getSource().getY()));
            }
        }
        //LEFT-BACKWARD
        if (getSource().offset(-departure,-departure) != null){
            if (IsThereOtherPiece( -departure + getSource().getX(),getSource().getY() - departure) == 1){
                KingMoveList.add(new ChessboardPoint( -departure + getSource().getX(),getSource().getY() - departure));
            }
        }
        //BACKWARD
        if (getSource().offset(0,-departure) != null){
            if (IsThereOtherPiece(  getSource().getX(),getSource().getY() - departure) == 1){
                KingMoveList.add(new ChessboardPoint(  getSource().getX(),getSource().getY() - departure));
            }
        }
        //BACKWARD-RIGHT
        if (getSource().offset(departure,-departure) != null){
            if (IsThereOtherPiece(  departure + getSource().getX(),getSource().getY() - departure) == 1){
                KingMoveList.add(new ChessboardPoint( departure +  getSource().getX(),getSource().getY() - departure));
            }
        }
        //RIGHT
        if (getSource().offset(departure,0) != null){
            if (IsThereOtherPiece(  departure + getSource().getX(),getSource().getY() ) == 1){
                KingMoveList.add(new ChessboardPoint( departure +  getSource().getX(),getSource().getY() ));
            }
        }

        return KingMoveList;
    }
    public int  IsThereOtherPiece (int a,int b){
        if ((chessboard[a][b].getName() == '_' )){return 1;}
        else if(chessboard[a][b].getChessColor() == getChessColor()){
            return 2;
        }else {
            return 3;
        }
    }
}
