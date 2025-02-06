import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {

    public QueenChessComponent (){
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint > move = new ArrayList<>();
        // +x
        for (int i = 1; i < 8; i++) {
            if(this.getSource().offset(i ,0) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()+i][this.getSource().getY()].getChessColor();
                if(j == this.getChessColor()){
                    break ;
                }
                else if(j != this.getChessColor() && j != ChessColor.NONE ){
                    move.add(this.getSource().offset(i ,0)) ;
                    break;
                }
                else if(j == ChessColor.NONE ){
                    move.add(this.getSource().offset(i ,0)) ;
                }
            }
            else {
                break;
            }
        }
        // -x
        for (int i = 1; i < 8; i++) {
            if(this.getSource().offset(-i ,0) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()-i][this.getSource().getY()].getChessColor();
                if(j == this.getChessColor()){
                    break ;
                }
                else if(j != this.getChessColor() && j != ChessColor.NONE ){
                    move.add(this.getSource().offset(-i ,0)) ;
                    break;
                }
                else if(j == ChessColor.NONE ){
                    move.add(this.getSource().offset(-i ,0)) ;
                }
            }
            else {
                break;
            }
        }
        // +y
        for (int i = 1; i < 8; i++) {
            if(this.getSource().offset(0 ,+i) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()][this.getSource().getY()+i].getChessColor();
                if(j == this.getChessColor()){
                    break ;
                }
                else if(j != this.getChessColor() && j != ChessColor.NONE ){
                    move.add(this.getSource().offset(0 ,+i)) ;
                    break;
                }
                else if(j == ChessColor.NONE ){
                    move.add(this.getSource().offset(0 ,+i)) ;
                }
            }
            else {
                break;
            }
        }
        // -y
        for (int i = 1; i < 8; i++) {
            if(this.getSource().offset(0 ,-i) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()][this.getSource().getY()-i].getChessColor();
                if(j == this.getChessColor()){
                    break ;
                }
                else if(j != this.getChessColor() && j != ChessColor.NONE ){
                    move.add(this.getSource().offset(0 ,-i)) ;
                    break;
                }
                else if(j == ChessColor.NONE ){
                    move.add(this.getSource().offset(0 ,-i)) ;
                }
            }
            else {
                break;
            }
        }
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
