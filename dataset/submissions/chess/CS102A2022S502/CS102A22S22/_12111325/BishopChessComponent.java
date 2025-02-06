import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint > move = new ArrayList<>();
        // +x +y
        for (int i = 1; i < 8; i++) {
            if(this.getSource().offset(i ,i) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()+i][this.getSource().getY()+i].getChessColor();
                if(j == this.getChessColor()){
                    break ;
                }
                else if(j != this.getChessColor() && j != ChessColor.NONE ){
                    move.add(this.getSource().offset(i ,i)) ;
                    break;
                }
                else if(j == ChessColor.NONE ){
                    move.add(this.getSource().offset(i ,i)) ;
                }
            }
            else {
                break;
            }
        }
        // -x -y
        for (int i = 1; i < 8; i++) {
            if(this.getSource().offset(-i ,-i) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()-i][this.getSource().getY()-i].getChessColor();
                if(j == this.getChessColor()){
                    break ;
                }
                else if(j != this.getChessColor() && j != ChessColor.NONE ){
                    move.add(this.getSource().offset(-i ,-i)) ;
                    break;
                }
                else if(j == ChessColor.NONE ){
                    move.add(this.getSource().offset(-i ,-i)) ;
                }
            }
            else {
                break;
            }
        }
        // -x +y
        for (int i = 1; i < 8; i++) {
            if(this.getSource().offset(-i ,+i) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()-i][this.getSource().getY()+i].getChessColor();
                if(j == this.getChessColor()){
                    break ;
                }
                else if(j != this.getChessColor() && j != ChessColor.NONE ){
                    move.add(this.getSource().offset(-i ,+i)) ;
                    break;
                }
                else if(j == ChessColor.NONE ){
                    move.add(this.getSource().offset(-i ,+i)) ;
                }
            }
            else {
                break;
            }
        }
        // +x -y
        for (int i = 1; i < 8; i++) {
            if(this.getSource().offset(i ,-i) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()+i][this.getSource().getY()-i].getChessColor();
                if(j == this.getChessColor()){
                    break ;
                }
                else if(j != this.getChessColor() && j != ChessColor.NONE ){
                    move.add(this.getSource().offset(i ,-i)) ;
                    break;
                }
                else if(j == ChessColor.NONE ){
                    move.add(this.getSource().offset(i ,-i)) ;
                }
            }
            else {
                break;
            }
        }
        return move;
    }
}
