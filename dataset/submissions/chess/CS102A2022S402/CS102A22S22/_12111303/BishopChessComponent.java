import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        super.name = name;
    }

    private List<ChessboardPoint> list = new ArrayList<>();

    @Override
    public List<ChessboardPoint> canMoveTo() {

        list.clear();
        ChessComponent[][] chessComponents = ConcreteChessGame.getInstance().getChessComponents();

        for (int i = 1; i < 8; i++) {
            ChessboardPoint chessboardPoint = getSource().offset(i, i);
            if (verification(chessboardPoint,chessComponents)){
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint chessboardPoint = getSource().offset(i, -i);
            if (verification(chessboardPoint,chessComponents)){
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint chessboardPoint = getSource().offset(-i, i);
            if (verification(chessboardPoint,chessComponents)){
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint chessboardPoint = getSource().offset(-i, -i);
            if (verification(chessboardPoint,chessComponents)){
                break;
            }
        }
        return list;
    }

    public boolean verification(ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents){

        if (chessboardPoint == null){
            return true;
        }
        if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.NONE){
            list.add(chessboardPoint);
        }else if (chessComponents[getSource().getX()][getSource().getY()].getChessColor() == chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()){
            return true;
        }else {
            list.add(chessboardPoint);
            return true;
        }

        return false;
    }
}
