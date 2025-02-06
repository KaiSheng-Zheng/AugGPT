import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor) {
        setSource(chessboardPoint);
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK) name = 'P';
        else name = 'p';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        if (this.getChessColor()==ChessColor.BLACK){
//            if (getSource_x()==1 & this.isEmpty(new ChessboardPoint(getSource_x()+2,getSource_y())) & chessboard[getSource_x()+1][getSource_y()].getChessColor() == ChessColor.NONE)
//                can.add(new ChessboardPoint(getSource_x()+2,getSource_y()));
//            if (this.isEmpty(new ChessboardPoint(getSource_x()+1,getSource_y())) & chessboard[getSource_x()+1][getSource_y()].getChessColor() != ChessColor.WHITE)
//                can.add(new ChessboardPoint(getSource_x()+1,getSource_y()));
            if (getSource_x() < 7 & chessboard[getSource_x()+1][getSource_y()].getChessColor() == ChessColor.NONE){
                can.add(new ChessboardPoint(getSource_x()+1,getSource_y()));
                if (getSource_x()==1 & chessboard[getSource_x()+2][getSource_y()].getChessColor() == ChessColor.NONE)
                    can.add(new ChessboardPoint(getSource_x()+2,getSource_y()));
            }
//            if (this.isEmpty(new ChessboardPoint(getSource_x()+1,getSource_y()+1)) & chessboard[getSource_x()+1][getSource_y()+1].getChessColor() == ChessColor.WHITE)
//                can.add(new ChessboardPoint(getSource_x()+1,getSource_y()+1));
//            if (this.isEmpty(new ChessboardPoint(getSource_x()+1,getSource_y()-1)) & chessboard[getSource_x()+1][getSource_y()-1].getChessColor() == ChessColor.WHITE)
//                can.add(new ChessboardPoint(getSource_x()+1,getSource_y()-1));
            if (this.isAnotherColor(new ChessboardPoint(getSource_x()+1,getSource_y()+1))) can.add(new ChessboardPoint(getSource_x()+1,getSource_y()+1));
            if (this.isAnotherColor(new ChessboardPoint(getSource_x()+1,getSource_y()-1))) can.add(new ChessboardPoint(getSource_x()+1,getSource_y()-1));
        }


        if (this.getChessColor()==ChessColor.WHITE){
//            if (getSource_x()==6 & this.isEmpty(new ChessboardPoint(getSource_x()-2,getSource_y())) & chessboard[getSource_x()-1][getSource_y()].getChessColor() == ChessColor.NONE)
//                can.add(new ChessboardPoint(getSource_x()-2,getSource_y()));
//            if (this.isEmpty(new ChessboardPoint(getSource_x()-1,getSource_y())) & chessboard[getSource_x()-1][getSource_y()].getChessColor() != ChessColor.BLACK)
//                can.add(new ChessboardPoint(getSource_x()-1,getSource_y()));
            if (getSource_x() > 0 & chessboard[getSource_x()-1][getSource_y()].getChessColor() == ChessColor.NONE){
                can.add(new ChessboardPoint(getSource_x()-1,getSource_y()));
                if (getSource_x()==6 & chessboard[getSource_x()-2][getSource_y()].getChessColor() == ChessColor.NONE)
                    can.add(new ChessboardPoint(getSource_x()-2,getSource_y()));
            }
//            if (this.isEmpty(new ChessboardPoint(getSource_x()-1,getSource_y()+1)) & chessboard[getSource_x()-1][getSource_y()+1].getChessColor() == ChessColor.BLACK)
//                can.add(new ChessboardPoint(getSource_x()-1,getSource_y()+1));
//            if (this.isEmpty(new ChessboardPoint(getSource_x()-1,getSource_y()-1)) & chessboard[getSource_x()-1][getSource_y()-1].getChessColor() == ChessColor.BLACK)
//                can.add(new ChessboardPoint(getSource_x()-1,getSource_y()-1));
            if (this.isAnotherColor(new ChessboardPoint(getSource_x()-1,getSource_y()+1))) can.add(new ChessboardPoint(getSource_x()-1,getSource_y()+1));
            if (this.isAnotherColor(new ChessboardPoint(getSource_x()-1,getSource_y()-1))) can.add(new ChessboardPoint(getSource_x()-1,getSource_y()-1));
        }
        return can;
    }
}