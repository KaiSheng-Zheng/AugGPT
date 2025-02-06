import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        super.name = name;
    }

    private List<ChessboardPoint> list;

    @Override
    public List<ChessboardPoint> canMoveTo() {
        list = new ArrayList<>();
        ChessComponent[][] chessComponents = ConcreteChessGame.getInstance().getChessComponents();
        for (int i = 1; i < 8; i++) {
            ChessboardPoint chessboardPoint = getSource().offset(i, 0);
            if (verification(chessboardPoint,chessComponents)){
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint chessboardPoint = getSource().offset(-i, 0);
            if (verification(chessboardPoint,chessComponents)){
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint chessboardPoint = getSource().offset(0, i);
            if (verification(chessboardPoint,chessComponents)){
                break;
            }
        }
        for (int i = 1; i < 8; i++) {
            ChessboardPoint chessboardPoint = getSource().offset(0, -i);
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

        if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor().equals(ChessColor.NONE)){
            list.add(chessboardPoint);
        }else if (chessComponents[getSource().getX()][getSource().getY()].getChessColor().equals(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor())){
            return true;
        }else {
            list.add(chessboardPoint);
            return true;
        }

        return false;
    }
}
