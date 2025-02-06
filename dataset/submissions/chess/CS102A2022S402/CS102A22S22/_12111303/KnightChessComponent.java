import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        super.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessComponent[][] chessComponents = ConcreteChessGame.getInstance().getChessComponents();
        for (int i = -2; i < 3; i++) {
            for (int j = -2; j < 3; j++) {
                if ((Math.abs(i) + Math.abs(j)) == 3) {
                    ChessboardPoint chessboardPoint = getSource().offset(i,j);
                    if (chessboardPoint == null){
                        continue;
                    }
                    if (chessComponents[getSource().getX()][getSource().getY()].getChessColor() == chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()){
                        continue;
                    }
                    list.add(chessboardPoint);
                }
            }
        }
        return list;
    }
}
