import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(){}

    public KingChessComponent(char name, ChessboardPoint where, ChessColor chessColor){
        this.name = name;
        this.setSource(where);
        this.setChessColor(chessColor);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> chessPoints = new ArrayList<>();
        if (this.getSource().offset(-1, -1) != null &&
                this.chessboard[this.getSource().getX() - 1][this.getSource().getY() -1].getChessColor() == ChessColor.NONE &&
                this.chessboard[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(-1, -1));
        }
        if (this.getSource().offset(-1, 0) != null &&
                this.chessboard[this.getSource().getX() - 1][this.getSource().getY() ].getChessColor() == ChessColor.NONE &&
                this.chessboard[this.getSource().getX() - 1][this.getSource().getY() ].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(-1, 0));
        }
        if (this.getSource().offset(-1, 1) != null &&
                this.chessboard[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() == ChessColor.NONE &&
                this.chessboard[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(-1, 1));
        }
        if (this.getSource().offset(0, -1) != null &&
                this.chessboard[this.getSource().getX() ][this.getSource().getY() - 1].getChessColor() == ChessColor.NONE &&
                this.chessboard[this.getSource().getX() ][this.getSource().getY() - 1].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(0, -1));
        }
        if (this.getSource().offset(0, 1) != null &&
                this.chessboard[this.getSource().getX() ][this.getSource().getY() + 1].getChessColor() == ChessColor.NONE &&
                this.chessboard[this.getSource().getX() ][this.getSource().getY() + 1].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(0, 1));
        }
        if (this.getSource().offset(1, -1) != null &&
                this.chessboard[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() == ChessColor.NONE &&
                this.chessboard[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(1, -1));
        }
        if (this.getSource().offset(1, 0) != null &&
                this.chessboard[this.getSource().getX() + 1][this.getSource().getY() ].getChessColor() == ChessColor.NONE &&
                this.chessboard[this.getSource().getX() + 1][this.getSource().getY() ].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(1, 0));
        }
        if (this.getSource().offset(1, 1) != null &&
                this.chessboard[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() == ChessColor.NONE &&
                this.chessboard[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() != this.chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor()){
            chessPoints.add(this.getSource().offset(1, 1));
        }
        return chessPoints;
    }

}