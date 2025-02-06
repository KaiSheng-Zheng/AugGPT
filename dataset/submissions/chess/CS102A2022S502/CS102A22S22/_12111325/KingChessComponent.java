import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    public KingChessComponent(){
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint > move = new ArrayList<>();
        if( this.getSource().offset(1,0) != null && this.getChessComponents()[this.getSource().getX()+1][this.getSource().getY()].getChessColor() != this.getChessColor()){
            move.add(this.getSource().offset(1,0) ) ;
        }
        if(this.getSource().offset(0,1) != null && this.getChessComponents()[this.getSource().getX()][this.getSource().getY()+1].getChessColor() != this.getChessColor()){
            move.add(this.getSource().offset(0,1) ) ;
        }
        if( this.getSource().offset(-1,0) != null && this.getChessComponents()[this.getSource().getX()-1][this.getSource().getY()].getChessColor() != this.getChessColor()){
            move.add(this.getSource().offset(-1,0) ) ;
        }
        if( this.getSource().offset(0,-1) != null && this.getChessComponents()[this.getSource().getX()][this.getSource().getY()-1].getChessColor() != this.getChessColor()){
            move.add(this.getSource().offset(0,-1) ) ;
        }
        if( this.getSource().offset(1,1) != null && this.getChessComponents()[this.getSource().getX()+1][this.getSource().getY()+1].getChessColor() != this.getChessColor()){
            move.add(this.getSource().offset(1,1) ) ;
        }
        if(this.getSource().offset(1,-1) != null && this.getChessComponents()[this.getSource().getX()+1][this.getSource().getY()-1].getChessColor() != this.getChessColor()){
            move.add(this.getSource().offset(1,-1) ) ;
        }
        if( this.getSource().offset(-1,1) != null && this.getChessComponents()[this.getSource().getX()-1][this.getSource().getY()+1].getChessColor() != this.getChessColor()){
            move.add(this.getSource().offset(-1,1) ) ;
        }
        if( this.getSource().offset(-1,-1) != null && this.getChessComponents()[this.getSource().getX()-1][this.getSource().getY()-1].getChessColor() != this.getChessColor()){
            move.add(this.getSource().offset(-1,-1) ) ;
        }
        return move;
    }

}
