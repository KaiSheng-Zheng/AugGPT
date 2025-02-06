import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(chessboardPoint, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int a = 0;
        int b = 0;
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        for (int i = -7; i <= 7; i++) {
            if (getSource().offset(0, i) != getSource() && getSource().offset(0, i) != null) {
                for (int j = Math.min(0, i) + 1; j < Math.max(0, i); j++) {
                    if (chessComponents[getSource().getX()][getSource().getY() + j].name != '_') {
                        b = 1;
                    }
                }if(b == 0){
                    if (getSource().offset(0, i) != null) {
                        chessboardPoints.add(getSource().offset(0, i));
                    }
                }
            }
            if (getSource().offset(i, 0) != getSource()) {
                for (int j = Math.min(0, i) + 1; j < Math.max(0, i); j++) {
                    if(getSource().offset(j, 0) != null) {
                        if (chessComponents[getSource().getX() + j][getSource().getY()].name != '_') {
                            a = 1;
                        }
                    }
                }if(a == 0){
                    if (getSource().offset(i, 0) != null) {
                        chessboardPoints.add(getSource().offset(i, 0));
                    }
                }
            }
        }int c = 0;
        for (int i = -7; i <= 7; i++) {
            if (getSource().offset(i, i) != getSource()) {
                for(int j = Math.min(0, i) + 1; j < Math.max(0, i); j++) {
                    if (getSource().offset(j, j) != null) {
                        if (chessComponents[getSource().getX() + j][getSource().getY() + j].name != '_') {
                            c = 1;
                        }
                    }
                }
                if(c == 0){
                    if (getSource().offset(i, i) != null) {
                        chessboardPoints.add(getSource().offset(i, i));
                    }
                }
            }
        }
        return chessboardPoints;
    }
}
