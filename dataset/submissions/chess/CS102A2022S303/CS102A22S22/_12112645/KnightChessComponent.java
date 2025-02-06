import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor color,Character name,ChessboardPoint source){
        super(color,name,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove =new ArrayList<>();
        if (getSource().getY()+2<=7&&getSource().getX()-1>=0
                &&chessboard[getSource().getX()-1][getSource().getY()+2].getChessColor()!=getChessColor()){
            canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+2));
        }
        if (getSource().getY()+2<=7&&getSource().getX()+1<8
                &&chessboard[getSource().getX()+1][getSource().getY()+2].getChessColor()!=getChessColor()){
            canMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+2));
        }
        if (getSource().getY()+1<=7&&getSource().getX()-2>=0
                &&chessboard[getSource().getX()-2][getSource().getY()+1].getChessColor()!=getChessColor()){
            canMove.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()+1));
        }
        if (getSource().getY()+1<=7&&getSource().getX()+2<8
                &&chessboard[getSource().getX()+2][getSource().getY()+1].getChessColor()!=getChessColor()){
            canMove.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()+1));
        }
        //
        if (getSource().getY()-2>=0&&getSource().getX()-1>=0
                &&chessboard[getSource().getX()-1][getSource().getY()-2].getChessColor()!=getChessColor()){
            canMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-2));
        }
        if (getSource().getY()-2>=0&&getSource().getX()+1<8
                &&chessboard[getSource().getX()+1][getSource().getY()-2].getChessColor()!=getChessColor()){
            canMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-2));
        }
        if (getSource().getY()-1>=0&&getSource().getX()-2>=0
                &&chessboard[getSource().getX()-2][getSource().getY()-1].getChessColor()!=getChessColor()){
            canMove.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()-1));
        }
        if (getSource().getY()-1>=0&&getSource().getX()+2<8
                &&chessboard[getSource().getX()+2][getSource().getY()-1].getChessColor()!=getChessColor()){
            canMove.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()-1));
        }

        return canMove;
    }

}
