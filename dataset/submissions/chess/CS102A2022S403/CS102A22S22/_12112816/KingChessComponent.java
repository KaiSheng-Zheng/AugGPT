import java.util.*;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor) {
        setSource(chessboardPoint);
        setChessColor(chessColor);

        if (chessColor == ChessColor.WHITE) name = 'k';
        else name = 'K';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> can1 = new ArrayList<>();
        ArrayList<ChessboardPoint> can = new ArrayList<>();

        can1.add(new ChessboardPoint(getSource_x()-1,getSource_y()-1));
        can1.add(new ChessboardPoint(getSource_x()-1,getSource_y()));
        can1.add(new ChessboardPoint(getSource_x()-1,getSource_y()+1));
        can1.add(new ChessboardPoint(getSource_x(),getSource_y()-1));
        can1.add(new ChessboardPoint(getSource_x(),getSource_y()+1));
        can1.add(new ChessboardPoint(getSource_x()+1,getSource_y()-1));
        can1.add(new ChessboardPoint(getSource_x()+1,getSource_y()));
        can1.add(new ChessboardPoint(getSource_x()+1,getSource_y()+1));
        for (int i = 0; i < can1.size(); i++) {
            if (this.isEmpty(can1.get(i))){
                can.add(can1.get(i));
            }
        }
        return can;
    }

}
