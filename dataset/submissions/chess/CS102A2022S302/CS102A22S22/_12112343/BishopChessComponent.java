import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char c) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name = c;
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int row = this.getSource().getX();
        int col = this.getSource().getY();
        for (int i = 1; ((row-i) >= 0) && ((col-i) >= 0) ; i++) {
            if(chessComponents[row-i][col-i].getChessColor() != this.getChessColor()){
                if(chessComponents[row-i][col-i].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(row-i, col-i));
                }else {
                    result.add(new ChessboardPoint(row-i, col-i));
                    break;
                }
            }else {
                break;
            }
        }
        for (int i = 1; ((row+i) <= 7) && ((col+i) <= 7) ; i++) {
            if(chessComponents[row+i][col+i].getChessColor() != this.getChessColor()){
                if(chessComponents[row+i][col+i].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(row+i, col+i));
                }else {
                    result.add(new ChessboardPoint(row+i, col+i));
                    break;
                }
            }else {
                break;
            }
        }
        for (int i = 1; ((row-i) >= 0) && ((col+i) <= 7) ; i++) {
            if(chessComponents[row-i][col+i].getChessColor() != this.getChessColor()){
                if(chessComponents[row-i][col+i].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(row-i, col+i));
                }else {
                    result.add(new ChessboardPoint(row-i, col+i));
                    break;
                }
            }else {
                break;
            }
        }
        for (int i = 1; ((row+i) <= 7) && ((col-i) >= 0) ; i++) {
            if(chessComponents[row+i][col-i].getChessColor() != this.getChessColor()){
                if(chessComponents[row+i][col-i].getChessColor() == ChessColor.NONE) {
                    result.add(new ChessboardPoint(row+i, col-i));
                }else {
                    result.add(new ChessboardPoint(row+i, col-i));
                    break;
                }
            }else {
                break;
            }
        }
        return result;
    }
}
