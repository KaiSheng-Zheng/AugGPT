import java.util.ArrayList;
import java.util.List;
public class RookChessComponent extends ChessComponent{
    public RookChessComponent() {
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int a = getSource().getX();
        int b = getSource().getY();
        List<ChessboardPoint> shit = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if(this.fuck(-i,0) ){
                shit.add(new ChessboardPoint(a-i,b));
                if(this.getChessComponents()[getSource().getX()-i][getSource().getY()].getChessColor() != ChessColor.NONE){
                    break;
                }
            }
            if(this.getSource().offset(-i,0) != null ) {
                if (this.getChessColor() == this.getChessComponents()[getSource().getX() - i][getSource().getY()].getChessColor()) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(this.fuck(0,-i) ){
                shit.add(new ChessboardPoint(a,b-i));
                if(this.getChessComponents()[getSource().getX()][getSource().getY()-i].getChessColor() != ChessColor.NONE){
                    break;
                }
            }
            if(this.getSource().offset(0,-i) != null ) {
                if (this.getChessColor() == this.getChessComponents()[getSource().getX()][getSource().getY()-i].getChessColor()) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(this.fuck(i,0) ){
                shit.add(new ChessboardPoint(a+i,b));
                if(this.getChessComponents()[getSource().getX()+i][getSource().getY()].getChessColor() != ChessColor.NONE){
                    break;
                }
            }
            if(this.getSource().offset(i,0) != null ) {
                if (this.getChessColor() == this.getChessComponents()[getSource().getX() + i][getSource().getY()].getChessColor()) {
                    break;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if(this.fuck(0,i) ){
                shit.add(new ChessboardPoint(a,b+i));
                if(this.getChessComponents()[getSource().getX()][getSource().getY()+i].getChessColor() != ChessColor.NONE){
                    break;
                }
            }
            if(this.getSource().offset(0,i) != null ) {
                if (this.getChessColor() == this.getChessComponents()[getSource().getX()][getSource().getY()+i].getChessColor()) {
                    break;
                }
            }
        }
        return shit;
    }
}
