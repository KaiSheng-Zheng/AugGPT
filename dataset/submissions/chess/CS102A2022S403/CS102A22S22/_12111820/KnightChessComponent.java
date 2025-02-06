import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor color,ChessboardPoint cp,char name){
        this.chessColor = color;
        this.source = cp;
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> a = new ArrayList<>();
         for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(source.getX() - i) == 2 && Math.abs(source.getY() - j) == 1){
                    if (chessComponent[i][j].getChessColor() != getChessColor()){
                        a.add(new ChessboardPoint(i,j));
                    }
                }
                if (Math.abs(source.getX() - i) == 1 && Math.abs(source.getY() - j) == 2){
                    if (chessComponent[i][j].getChessColor() != getChessColor()){
                        a.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        return a;
    }
}
