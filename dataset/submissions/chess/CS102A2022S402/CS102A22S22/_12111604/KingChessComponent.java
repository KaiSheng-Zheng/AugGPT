import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
       this.setSource(source);
       this.setChessColor(chessColor);
       this.setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(getSource().getY() - j) <= 1 && Math.abs(getSource().getX() - i) <= 1 && getChessComponents()[i][j].getChessColor() != getChessColor()){
                    arrayList.add(new ChessboardPoint(i,j));
                }
            }
        }
        return arrayList;
    }
}
