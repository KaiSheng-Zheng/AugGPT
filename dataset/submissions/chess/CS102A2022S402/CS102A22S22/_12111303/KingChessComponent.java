import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        super.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessComponent[][] chessComponents = ConcreteChessGame.getInstance().getChessComponents();
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0 && j == 0){
                    continue;
                }
                ChessboardPoint chessboardPoint =getSource().offset(i,j);
                if (chessboardPoint == null){
                    continue;
                }
                if (chessComponents[getSource().getX()][getSource().getY()].getChessColor() != chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()){
                list.add(chessboardPoint);
                }
            }
        }
        return list;
    }
}