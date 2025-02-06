import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent() {
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int a = getSource().getX();
        int b = getSource().getY();
        List<ChessboardPoint> shit = new ArrayList<>();
        if (getChessColor() == ChessColor.WHITE) {
            if (a == 6) {
                if (this.getChessComponents()[a - 1][b].getChessColor() == ChessColor.NONE) {
                    shit.add(new ChessboardPoint(a - 1, b));
                }
                if (this.getChessComponents()[a - 2][b].getChessColor() == ChessColor.NONE &&
                        this.getChessComponents()[a - 1][b].getChessColor() == ChessColor.NONE) {
                    shit.add(new ChessboardPoint(a - 2, b));
                }
            } else {
                if (this.fuck(-1, 0)) {
                    if (this.getChessComponents()[a - 1][b].getChessColor() == ChessColor.NONE) {
                        shit.add(new ChessboardPoint(a - 1, b));
                    }
                }
                if (this.fuck(-1, -1)) {
                    if (this.getChessComponents()[a - 1][b - 1].getChessColor() == ChessColor.BLACK) {
                        shit.add(new ChessboardPoint(a - 1, b - 1));
                    }
                }
                if (this.fuck(-1, 1)) {
                    if (this.getChessComponents()[a - 1][b + 1].getChessColor() == ChessColor.BLACK) {
                        shit.add(new ChessboardPoint(a - 1, b + 1));
                    }
                }
            }
        } else if (getChessColor() == ChessColor.BLACK) {
            if (a == 1) {
                if (this.getChessComponents()[a + 1][b].getChessColor() == ChessColor.NONE) {
                    shit.add(new ChessboardPoint(a + 1, b));
                }
                if (this.getChessComponents()[a + 2][b].getChessColor() == ChessColor.NONE &&
                        this.getChessComponents()[a + 1][b].getChessColor() == ChessColor.NONE) {
                    shit.add(new ChessboardPoint(a + 2, b));
                }
                if(this.fuck(1,-1) ){
                    if (this.getChessComponents()[a + 1][b - 1].getChessColor() == ChessColor.WHITE) {
                        shit.add(new ChessboardPoint(a + 1, b - 1));
                    }
                }
                if(this.fuck(1,1) ){
                    if (this.getChessComponents()[a + 1][b + 1].getChessColor() == ChessColor.WHITE) {
                        shit.add(new ChessboardPoint(a + 1, b + 1));
                    }
                }
            } else {if (this.fuck(1, 0)) {
                if (this.getChessComponents()[a + 1][b].getChessColor() == ChessColor.NONE) {
                    shit.add(new ChessboardPoint(a + 1, b));
                }
            }
            if(this.fuck(1,-1) ){
                if (this.getChessComponents()[a + 1][b - 1].getChessColor() == ChessColor.WHITE) {
                    shit.add(new ChessboardPoint(a + 1, b - 1));
                }
            }
            if(this.fuck(1,1) ){
                if (this.getChessComponents()[a + 1][b + 1].getChessColor() == ChessColor.WHITE) {
                    shit.add(new ChessboardPoint(a + 1, b + 1));
                }
            }
        }
    }
        return shit;
    }
}
