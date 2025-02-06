import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    ChessComponent[][] chessComponents;

    public PawnChessComponent(ChessComponent[][] chessComponents, ChessboardPoint chessboardPoint) {
        this.chessComponents = chessComponents;
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> PawnPoints = new ArrayList<>();
        if (this.getChessColor() == ChessColor.BLACK) {
            if (this.getSource().getX() + 1 < 8 && chessComponents[this.getSource().getX() + 1][this.getSource().getY()] instanceof EmptySlotComponent) {
                ChessboardPoint destination = new ChessboardPoint(getSource().getX() + 1, getSource().getY());
                PawnPoints.add(destination);
            }
            if (this.getSource().getX() + 1 < 8 && this.getSource().getY() + 1 < 8 && !(chessComponents[this.getSource().getX() +1][this.getSource().getY() + 1] instanceof EmptySlotComponent) && chessComponents[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() == ChessColor.WHITE){
                ChessboardPoint destination = new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() + 1);
                PawnPoints.add(destination);
            }
            if (this.getSource().getX() + 1 < 8 && this.getSource().getY() - 1 >= 0 && !(chessComponents[this.getSource().getX() +1][this.getSource().getY() + 1] instanceof EmptySlotComponent) && chessComponents[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() == ChessColor.WHITE){
                ChessboardPoint destination = new ChessboardPoint(this.getSource().getX() + 1, this.getSource().getY() - 1);
                PawnPoints.add(destination);
            }
            if (this.getSource().getX() == 1 && chessComponents[this.getSource().getX() + 1][this.getSource().getY()] instanceof EmptySlotComponent && chessComponents[this.getSource().getX() + 2][this.getSource().getY()] instanceof EmptySlotComponent){
                ChessboardPoint destination = new ChessboardPoint(this.getSource().getX() + 2, this.getSource().getY());
                PawnPoints.add(destination);
            }
        }else {
            if (this.getSource().getX() - 1 >= 0 && chessComponents[this.getSource().getX() - 1][this.getSource().getY()] instanceof EmptySlotComponent) {
                ChessboardPoint destination = new ChessboardPoint(getSource().getX() - 1, getSource().getY());
                PawnPoints.add(destination);
            }
            if (this.getSource().getX() - 1 >= 0 && this.getSource().getY() - 1 >= 0 && chessComponents[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() == ChessColor.BLACK){
                ChessboardPoint destination = new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() - 1);
                PawnPoints.add(destination);
            }
            if (this.getSource().getX() - 1 >= 0 && this.getSource().getY() + 1 <= 7 && chessComponents[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() == ChessColor.BLACK){
                ChessboardPoint destination = new ChessboardPoint(this.getSource().getX() - 1, this.getSource().getY() + 1);
                PawnPoints.add(destination);
            }
            if (this.getSource().getX() == 6 && chessComponents[this.getSource().getX() - 1][this.getSource().getY()] instanceof EmptySlotComponent && chessComponents[this.getSource().getX() - 2][this.getSource().getY()] instanceof EmptySlotComponent){
                ChessboardPoint destination = new ChessboardPoint(this.getSource().getX() - 2, this.getSource().getY());
                PawnPoints.add(destination);
            }
        }
        return PawnPoints;
    }
}
