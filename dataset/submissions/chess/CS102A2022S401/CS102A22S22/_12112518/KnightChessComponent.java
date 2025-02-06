import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(){};

    public KnightChessComponent(char name, ChessboardPoint where, ChessColor chessColor){
        this.name = name;
        this.setSource(where);
        this.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessPoints = new ArrayList<>();
        if (this.getSource().offset(1, 2) != null &&
                this.chessboard[this.getSource().getX() + 1][this.getSource().getY() + 2].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(1, 2));
        }
        if (this.getSource().offset(1, -2) != null &&
                this.chessboard[this.getSource().getX() + 1][this.getSource().getY() - 2].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(1, -2));
        }
        if (this.getSource().offset(-1, -2) != null &&
                this.chessboard[this.getSource().getX() - 1][this.getSource().getY() - 2].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(-1, -2));
        }
        if (this.getSource().offset(-1, 2) != null &&
                this.chessboard[this.getSource().getX() - 1][this.getSource().getY() + 2].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(-1, 2));
        }
        if (this.getSource().offset(2, 1) != null &&
                this.chessboard[this.getSource().getX() + 2][this.getSource().getY() + 1].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(2, 1));
        }
        if (this.getSource().offset(2, -1) != null &&
                this.chessboard[this.getSource().getX() + 2][this.getSource().getY() - 1].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(2, -1));
        }
        if (this.getSource().offset(-2, -1) != null &&
                this.chessboard[this.getSource().getX() - 2][this.getSource().getY() - 1].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(-2, -1));
        }
        if (this.getSource().offset(-2, 1) != null &&
                this.chessboard[this.getSource().getX() - 2][this.getSource().getY() + 1].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(-2, 1));
        }
        return chessPoints;
    }

}