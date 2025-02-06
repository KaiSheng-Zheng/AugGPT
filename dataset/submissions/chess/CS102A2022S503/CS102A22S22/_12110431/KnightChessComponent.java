import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor color, char name, ChessComponent[][] chessComponents) {
        super(source, color, name, chessComponents);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> target = new ArrayList<>();
        for (int x=0;x<8;x++){
            int dx=x-getSource().getX();
            for (int y=0;y<8;y++){
                int dy=y-getSource().getY();
                if (Math.pow(dy,2)+Math.pow(dx,2)==5){
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
