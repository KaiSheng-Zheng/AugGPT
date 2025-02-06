import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent() {
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char c) {
        this.setSource(source);
        this.setChessColor(chessColor);
        this.name = c;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result = new ArrayList<>();
        if((this.getSource().offset(-2,1) != null) &&
                (chessComponents[this.getSource().getX()-2][this.getSource().getY()+1].getChessColor() != this.getChessColor())){
            result.add(this.getSource().offset(-2,1));
        }
        if((this.getSource().offset(-2,-1) != null) &&
                (chessComponents[this.getSource().getX()-2][this.getSource().getY()-1].getChessColor() != this.getChessColor())){
            result.add(this.getSource().offset(-2,-1));
        }
        if((this.getSource().offset(2,-1) != null) &&
                (chessComponents[this.getSource().getX()+2][this.getSource().getY()-1].getChessColor() != this.getChessColor())){
            result.add(this.getSource().offset(2,-1));
        }
        if((this.getSource().offset(2,1) != null) &&
                (chessComponents[this.getSource().getX()+2][this.getSource().getY()+1].getChessColor() != this.getChessColor())){
            result.add(this.getSource().offset(2,1));
        }
        if((this.getSource().offset(-1,2) != null) &&
                (chessComponents[this.getSource().getX()-1][this.getSource().getY()+2].getChessColor() != this.getChessColor())){
            result.add(this.getSource().offset(-1,2));
        }
        if((this.getSource().offset(-1,-2) != null) &&
                (chessComponents[this.getSource().getX()-1][this.getSource().getY()-2].getChessColor() != this.getChessColor())){
            result.add(this.getSource().offset(-1,-2));
        }
        if((this.getSource().offset(1,2) != null) &&
                (chessComponents[this.getSource().getX()+1][this.getSource().getY()+2].getChessColor() != this.getChessColor())){
            result.add(this.getSource().offset(1,2));
        }
        if((this.getSource().offset(1,-2) != null) &&
                (chessComponents[this.getSource().getX()+1][this.getSource().getY()-2].getChessColor() != this.getChessColor())){
            result.add(this.getSource().offset(1,-2));
        }
        return result;
    }
}
