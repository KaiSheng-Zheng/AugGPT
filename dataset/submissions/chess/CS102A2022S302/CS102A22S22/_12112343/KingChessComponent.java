import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent() {
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char c) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name = c;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        int row = this.getSource().getX();
        int col = this.getSource().getY();
        for (int i = -1; i <= 1 ; i++) {
            if((this.getSource().offset(-1,i) != null) &&
                    (chessComponents[row-1][col+i].getChessColor() != this.getChessColor())){
                result.add(this.getSource().offset(-1,i));
            }
        }
        if((this.getSource().offset(0,-1) != null) &&
                (chessComponents[row][col-1].getChessColor() != this.getChessColor())){
            result.add(this.getSource().offset(0,-1));
        }
        if((this.getSource().offset(0,1) != null) &&
                (chessComponents[row][col+1].getChessColor() != this.getChessColor())){
            result.add(this.getSource().offset(0,1));
        }
        for (int i = -1; i <= 1 ; i++) {
            if((this.getSource().offset(1,i) != null) &&
                    (chessComponents[row+1][col+i].getChessColor() != this.getChessColor())){
                result.add(this.getSource().offset(1,i));
            }
        }
        return result;
    }
}
