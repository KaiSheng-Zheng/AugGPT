import java.util.ArrayList;
import java.util.List;
import java.lang.Math;
public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor color, char name,ChessComponent[][] chessComponent) {
        super(source, color, name,chessComponent);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> target = new ArrayList<ChessboardPoint>();
        for (int x=0;x<8;x++){
            int dx=x-getSource().getX();
            for (int y=0;y<8;y++){
                int dy=y-getSource().getY();
                if ((Math.abs(dx) <= 1) && (Math.abs(dy)<= 1)){
                    target.add(new ChessboardPoint(x,y));
                }
            }
        }
        List<ChessboardPoint> tag= new ArrayList<>();
        for (ChessboardPoint i :target){
            if (chessComponents[i.getX()][i.getY()].getChessColor()!=getChessColor()){
                tag.add(i);
            }
        }
        return tag;
    }
}

