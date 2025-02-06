import java.util.ArrayList;
import java.util.List;
public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int a = getSource().getX();
        int b = getSource().getY();
        List<ChessboardPoint> shit = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if(this.fuck(-i,-i) ) {
                shit.add(new ChessboardPoint(a - i, b - i));
                if(this.getChessComponents()[getSource().getX()-i][getSource().getY()-i].getChessColor() != ChessColor.NONE){
                    break;
                }
            }
            if(this.getSource().offset(-i,-i) != null ) {
                if (this.getChessColor() == this.getChessComponents()[getSource().getX() - i][getSource().getY() - i].getChessColor()) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(this.fuck(-i,i) ) {
                shit.add(new ChessboardPoint(a - i, b + i));
                if(this.getChessComponents()[getSource().getX()-i][getSource().getY()+i].getChessColor() != ChessColor.NONE){
                    break;
                }
            }
            if(this.getSource().offset(-i,i) != null ) {
                if (this.getChessColor() == this.getChessComponents()[getSource().getX() - i][getSource().getY() + i].getChessColor()) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(this.fuck(i,i) ) {
                shit.add(new ChessboardPoint(a + i, b + i));
                if(this.getChessComponents()[getSource().getX()+i][getSource().getY()+i].getChessColor() != ChessColor.NONE){
                    break;
                }
            }
            if(this.getSource().offset(i,i) != null ) {
                if (this.getChessColor() == this.getChessComponents()[getSource().getX() + i][getSource().getY() + i].getChessColor()) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(this.fuck(i,-i) ) {
                shit.add(new ChessboardPoint(a + i, b - i));
                if(this.getChessComponents()[getSource().getX()+i][getSource().getY()-i].getChessColor() != ChessColor.NONE){
                    break;
                }
            }
            if(this.getSource().offset(i,-i) != null ) {
                if (this.getChessColor() == this.getChessComponents()[getSource().getX() + i][getSource().getY() - i].getChessColor()) {
                    break;
                }
            }
        }
        return shit;
    }
}
