import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {

    public KnightChessComponent(){
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint > move = new ArrayList<>();
        // x+1,y+2
            if(this.getSource().offset(1 ,2) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()+1][this.getSource().getY()+2].getChessColor();
                if(j != this.getChessColor() ){
                    move.add(this.getSource().offset(1 ,2)) ;
                }
//                else if(j == ChessColor.NONE ){
//                    move.add(this.getSource().offset(1 ,2)) ;
//                }
            }

        // x+1,y-2
            if(this.getSource().offset(1 ,-2) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()+1][this.getSource().getY()-2].getChessColor();
                if(j != this.getChessColor()  ){
                    move.add(this.getSource().offset(1 ,-2)) ;
                }
//                else if(j == ChessColor.NONE ){
//                    move.add(this.getSource().offset(1 ,-2)) ;
//                }
            }

        // x+2,y+1
            if(this.getSource().offset(2 ,1) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()+2][this.getSource().getY()+1].getChessColor();
                if(j != this.getChessColor()  ){
                    move.add(this.getSource().offset(2 ,1)) ;
                }
//                else if(j == ChessColor.NONE ){
//                    move.add(this.getSource().offset(2 ,1)) ;
//                }
            }

        // x+2,y-1
            if(this.getSource().offset(2 ,-1) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()+2][this.getSource().getY()-1].getChessColor();
                if(j != this.getChessColor()  ){
                    move.add(this.getSource().offset(2 ,-1)) ;
                }
            }

        // x-1,y+2
            if(this.getSource().offset(-1 ,2) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()-1][this.getSource().getY()+2].getChessColor();
                if(j != this.getChessColor() ){
                    move.add(this.getSource().offset(-1 ,2)) ;
                }
            }

        // x-1,y-2
            if(this.getSource().offset(-1 ,-2) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()-1][this.getSource().getY()-2].getChessColor();
                if(j != this.getChessColor()  ){
                    move.add(this.getSource().offset(-1 ,-2)) ;
                }
//                else if(j == ChessColor.NONE ){
//                    move.add(this.getSource().offset(-1 ,-2)) ;
//                }
            }

        // x-2,y+1
            if(this.getSource().offset(-2 ,+1) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()-2][this.getSource().getY()+1].getChessColor();
               if(j != this.getChessColor() ){
                    move.add(this.getSource().offset(-2 ,+1)) ;
                }
//                else if(j == ChessColor.NONE ){
//                    move.add(this.getSource().offset(-2 ,+1)) ;
//                }
            }

        // x-2,y-1
            if(this.getSource().offset(-2 ,-1) != null) {
                ChessColor j = this.getChessComponents()[this.getSource().getX()-2][this.getSource().getY()-1].getChessColor();
                if(j != this.getChessColor()  ){
                    move.add(this.getSource().offset(-2 ,-1) );
                }
//                else if(j == ChessColor.NONE ){
//                    move.add(this.getSource().offset(-2 ,-1)) ;
//                }
            }

        return move;
    }
}
