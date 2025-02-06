import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessComponent[][] chessComponents, ChessboardPoint chessboardPoint) {
        this.chessComponents = chessComponents;
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> KingPoints = new ArrayList<>();
        if (this.getSource().getX() + 1 < 8 && chessComponents[getSource().getX()+1][getSource().getY()].getChessColor() != this.getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(getSource().getX() + 1, getSource().getY());
            KingPoints.add(destination);
        }
        if (this.getSource().getX() - 1 >=0 && chessComponents[getSource().getX()-1][getSource().getY()].getChessColor() != this.getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(getSource().getX() - 1, getSource().getY());
            KingPoints.add(destination);
        }
        if (this.getSource().getY() + 1 < 8 && chessComponents[getSource().getX()][getSource().getY()+1].getChessColor() != this.getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(getSource().getX(), getSource().getY() + 1);
            KingPoints.add(destination);
        }
        if (this.getSource().getY() - 1 >= 0 && chessComponents[getSource().getX()][getSource().getY()-1].getChessColor() != this.getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(getSource().getX(), getSource().getY() - 1);
            KingPoints.add(destination);
        }
        if (this.getSource().getX() + 1 < 8 && this.getSource().getY() + 1 < 8 && chessComponents[getSource().getX()+1][getSource().getY()+1].getChessColor() != this.getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1);
            KingPoints.add(destination);
        }
        if (this.getSource().getX() - 1 >= 0 && this.getSource().getY() - 1 >= 0 && chessComponents[getSource().getX()-1][getSource().getY()-1].getChessColor() != this.getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1);
            KingPoints.add(destination);
        }
        if (this.getSource().getX() + 1 < 8 && this.getSource().getY() - 1 >= 0 && chessComponents[getSource().getX()+1][getSource().getY()-1].getChessColor() != this.getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1);
            KingPoints.add(destination);
        }
        if (this.getSource().getX() - 1 >=0 && this.getSource().getY() + 1 < 8 && chessComponents[getSource().getX()-1][getSource().getY()+1].getChessColor() != this.getChessColor()){
            ChessboardPoint destination = new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1);
            KingPoints.add(destination);
        }
        return KingPoints;
    }
}