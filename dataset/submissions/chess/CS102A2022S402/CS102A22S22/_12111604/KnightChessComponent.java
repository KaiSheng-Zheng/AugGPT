import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent( ChessboardPoint source, ChessColor chessColor, char name) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(i - getSource().getX()) == 1 && Math.abs(j - getSource().getY()) == 2 && getChessComponents()[i][j].getChessColor() != getChessColor()){
                    arrayList.add(new ChessboardPoint(i,j));
                }
                if (Math.abs(i - getSource().getX()) == 2 && Math.abs(j - getSource().getY()) == 1 && getChessComponents()[i][j].getChessColor() != getChessColor()){
                    arrayList.add(new ChessboardPoint(i,j));
                }
            }
        }
        return arrayList;
    }
}
