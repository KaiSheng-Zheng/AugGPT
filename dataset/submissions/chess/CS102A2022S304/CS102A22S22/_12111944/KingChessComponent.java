
import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    protected ChessComponent[][] chessComponents;
    public KingChessComponent(ChessColor color){
        super();
        this.setChessColor(color);
        if (color==ChessColor.WHITE) {
            this.name = 'k';
        }else if (color==ChessColor.BLACK){
            this.name = 'K';
        }else{
            this.name = '_';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Move = new ArrayList<>();
        if (this.getChessColor()==ChessColor.WHITE){
            int kx = 0, ky = 0;
            for (int i = 0; i < this.chessboard.length; i++) {
                for (int j = 0; j < this.chessboard[i].length; j++) {
                    if (this.chessboard[i][j].name == 'k') {
                        kx = i;
                        ky = j;
                    }
                }
            }
            for (int i = 0; i < this.chessboard.length; i++) {
                for (int j = 0; j < this.chessboard[i].length; j++) {
                    if ((i==kx-1&&j==ky)||(i==kx+1&&j==ky)||(i==kx&&j==ky-1)||(i==kx&&j==ky+1)||(i==kx-1&&j==ky-1)||(i==kx+1&&j==ky-1)||(i==kx-1&&j==ky+1)||(i==kx+1&&j==ky+1)){
                        if (this.chessboard[i][j].name=='_'||this.chessboard[i][j].getChessColor()==ChessColor.BLACK){
                            Move.add(new ChessboardPoint(i,j));
                        }
                    }
                }
            }
        }else{
            int kx = 0, ky = 0;
            for (int i = 0; i < this.chessboard.length; i++) {
                for (int j = 0; j < this.chessboard[i].length; j++) {
                    if (this.chessboard[i][j].name == 'K') {
                        kx = i;
                        ky = j;
                    }
                }
            }
            for (int i = 0; i < this.chessboard.length; i++) {
                for (int j = 0; j < this.chessboard[i].length; j++) {
                    if ((i==kx-1&&j==ky)||(i==kx+1&&j==ky)||(i==kx&&j==ky-1)||(i==kx&&j==ky+1)||(i==kx-1&&j==ky-1)||(i==kx+1&&j==ky-1)||(i==kx-1&&j==ky+1)||(i==kx+1&&j==ky+1)){
                        if (this.chessboard[i][j].name=='_'||this.chessboard[i][j].getChessColor()==ChessColor.WHITE){
                            Move.add(new ChessboardPoint(i,j));
                        }
                    }
                }
            }
        }
        return Move;
    }
}