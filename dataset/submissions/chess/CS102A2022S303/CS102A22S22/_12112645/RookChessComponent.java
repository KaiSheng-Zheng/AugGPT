import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor color,Character name,ChessboardPoint source){
        super(color,name,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove =new ArrayList<>();
        for (int i = getSource().getX()+1; i <8 ; i++) {
            int j=getSource().getY();
            if(chessboard[i][j]instanceof EmptySlotComponent){canMove.add(new ChessboardPoint(i,j));}
            else if (chessboard[i][j].getChessColor()!=getChessColor()){
                canMove.add(new ChessboardPoint(i,j));break;
            }else {break;}
        }
        for (int i = getSource().getX()-1; i >=0 ; i--) {
            int j=getSource().getY();
            if(chessboard[i][j]instanceof EmptySlotComponent){canMove.add(new ChessboardPoint(i,j));}
            else if (chessboard[i][j].getChessColor()!=getChessColor()){
                canMove.add(new ChessboardPoint(i,j));break;
            }else {break;}
        }
        for (int j = getSource().getY()+1; j<8 ; j++) {
            int i =getSource().getX();
            if(chessboard[i][j]instanceof EmptySlotComponent){canMove.add(new ChessboardPoint(i,j));}
            else if (chessboard[i][j].getChessColor()!=getChessColor()){
                canMove.add(new ChessboardPoint(i,j));break;
            }else {break;}
        }
        for (int j = getSource().getY()-1; j>=0 ; j--) {
            int i =getSource().getX();
            if(chessboard[i][j]instanceof EmptySlotComponent){canMove.add(new ChessboardPoint(i,j));}
            else if (chessboard[i][j].getChessColor()!=getChessColor()){
                canMove.add(new ChessboardPoint(i,j));break;
            }else {break;}
        }
        return canMove;
    }




}