import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessColor chessColor, ChessboardPoint source) {
        this.setChessColor(chessColor);
        this.setSource(source);
        if (chessColor == ChessColor.BLACK) {
            name = 'Q';
        }
        if (chessColor == ChessColor.WHITE) {
            name = 'q';
        }

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        int chushiX = getSource().getX();
        int chushiY = getSource().getY();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (chessboard[i][j].getChessColor() != this.getChessColor()) {
                    if (chushiX == i) {
                        int c=0;
                        for (int k = Math.min(j, chushiY)+1; k < Math.max(chushiY, j); k++) {
                            if (chessboard[i][k].name != '_') {
                                c++;
                            }
                        }
                        if(c==0){
                            ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                            chessboardPoints.add(chessboardPoint);
                        }
                    }
                    if (chushiY == j) {
                        int c=0;
                        for (int k = Math.min(i, chushiX) + 1; k < Math.max(chushiX, i); k++) {
                            if (chessboard[k][j].name != '_') {
                                c++;
                            }
                        }
                        if(c==0){
                            ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                            chessboardPoints.add(chessboardPoint);
                        }
                    }
                    if (chushiX - i == chushiY - j) {
                        int c=0;
                        for (int n = 1; n < Math.abs(chushiX - i); n++) {
                            if (chessboard[Math.min(i, chushiX) + n][Math.min(j, chushiY) + n].name != '_') {
                                c++;
                            }
                        }
                        if(c==0){
                            ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                            chessboardPoints.add(chessboardPoint);
                        }
                    }
                    if (chushiX - i == j - chushiY) {
                        int c=0;
                        for (int n = 1; n < Math.abs(chushiX - i); n++) {
                            if (chessboard[Math.min(i, chushiX) + n][Math.max(j, chushiY)-n].name != '_') {
                               c++;
                            }
                        }
                        if(c==0){
                            ChessboardPoint chessboardPoint = new ChessboardPoint(i, j);
                            chessboardPoints.add(chessboardPoint);
                        }
                    }
                }
            }
        }
        return chessboardPoints;
    }
}
