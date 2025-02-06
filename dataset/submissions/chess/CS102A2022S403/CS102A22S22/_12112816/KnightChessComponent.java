import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint chessboardPoint,ChessColor chessColor) {
        setSource(chessboardPoint);
        setChessColor(chessColor);
        if (chessColor == ChessColor.BLACK) name = 'N';
        else name = 'n';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> can1 = new ArrayList<>();
        ArrayList<ChessboardPoint> can = new ArrayList<>();
        can1.add(new ChessboardPoint(getSource_x()+2,getSource_y()+1));
        can1.add(new ChessboardPoint(getSource_x()+2,getSource_y()-1));
        can1.add(new ChessboardPoint(getSource_x()-2,getSource_y()+1));
        can1.add(new ChessboardPoint(getSource_x()-2,getSource_y()-1));
        can1.add(new ChessboardPoint(getSource_x()+1,getSource_y()+2));
        can1.add(new ChessboardPoint(getSource_x()-1,getSource_y()+2));
        can1.add(new ChessboardPoint(getSource_x()+1,getSource_y()-2));
        can1.add(new ChessboardPoint(getSource_x()-1,getSource_y()-2));
        for (int i = 0; i < can1.size(); i++) {
            if (this.isEmpty(can1.get(i))){
                can.add(can1.get(i));
            }
        }
        return can;
    }
}
