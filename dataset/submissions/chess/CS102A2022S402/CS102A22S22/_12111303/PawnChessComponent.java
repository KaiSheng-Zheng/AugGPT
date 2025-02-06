import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        setSource(source);
        setChessColor(chessColor);
        super.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list = new ArrayList<>();
        ChessComponent[][] chessComponents = ConcreteChessGame.getInstance().getChessComponents();
        for (int i = -1; i < 2; i++) {
            if (getChessColor() == ChessColor.BLACK) {
                ChessboardPoint chessboardPoint = getSource().offset(1, i);
                if (chessboardPoint == null){
                    continue;
                }
                if (i == 0){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.NONE){
                        list.add(chessboardPoint);
                    }else {
                        continue;
                    }
                    if (getSource().getX() == 1){
                        ChessboardPoint offset = getSource().offset(2, 0);
                        if (chessComponents[offset.getX()][offset.getY()].getChessColor() == ChessColor.NONE) {
                            list.add(offset);
                        }else {
                            continue;
                        }
                    }
                    continue;
                }else {
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.WHITE){
                        list.add(chessboardPoint);
                    }
                }
            } else if (getChessColor() == ChessColor.WHITE) {
                ChessboardPoint chessboardPoint = getSource().offset(-1, i);
                if (chessboardPoint == null){
                    continue;
                }
                if (i == 0){
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.NONE){
                        list.add(chessboardPoint);
                    }else {
                        continue;
                    }
                    if (getSource().getX() == 6){
                        ChessboardPoint offset = getSource().offset(-2, 0);
                        if (chessComponents[offset.getX()][offset.getY()].getChessColor() == ChessColor.NONE) {
                            list.add(offset);
                        }else {
                            continue;
                        }
                    }
                    continue;
                }else {
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.BLACK){
                        list.add(chessboardPoint);
                    }
                }
            }
        }
        return list;
    }
}
