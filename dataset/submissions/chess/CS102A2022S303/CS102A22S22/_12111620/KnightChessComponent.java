import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] now) {
        setSource(source);
        setChessColor(chessColor);
        setName(name);
        setNow(now);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canChessMove = new ArrayList<>();

        if (getSource().getX() - 2 >= 0 && getSource().getX() - 2 <= 7
                && getSource().getY() - 1 >= 0 && getSource().getY() - 1 <= 7
                && getChessColor() != getNow()[getSource().getX()-2][getSource().getY()-1].getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()-1));
        }
        if (getSource().getX() - 2 >= 0 && getSource().getX() - 2 <= 7
                && getSource().getY() + 1 >= 0 && getSource().getY() + 1 <= 7
                && getChessColor() != getNow()[getSource().getX()-2][getSource().getY()+1].getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()+1));
        }
        if (getSource().getX() - 1 >= 0 && getSource().getX() - 1 <= 7
                && getSource().getY() - 2 >= 0 && getSource().getY() - 2 <= 7
                && getChessColor() != getNow()[getSource().getX()-1][getSource().getY()-2].getChessColor()) {
            canChessMove.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 2));
        }
        if (getSource().getX() - 1 >= 0 && getSource().getX() - 1 <= 7
                && getSource().getY() + 2 >= 0 && getSource().getY() + 2 <= 7
                && getChessColor() != getNow()[getSource().getX()-1][getSource().getY()+2].getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+2));
        }
        if (getSource().getX() + 1 >= 0 && getSource().getX() + 1 <= 7
                && getSource().getY() - 2 >= 0 && getSource().getY() - 2 <= 7
                && getChessColor() != getNow()[getSource().getX()+1][getSource().getY()-2].getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-2));
        }
        if (getSource().getX() + 1 >= 0 && getSource().getX() + 1 <= 7
                && getSource().getY() + 2 >= 0 && getSource().getY() + 2 <= 7
                && getChessColor() != getNow()[getSource().getX()+1][getSource().getY()+2].getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+2));
        }
        if (getSource().getX() + 2 >= 0 && getSource().getX() + 2 <= 7
                && getSource().getY() - 1 >= 0 && getSource().getY() - 1 <= 7
                && getChessColor() != getNow()[getSource().getX()+2][getSource().getY()-1].getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()-1));
        }
        if (getSource().getX() + 2 >= 0 && getSource().getX() + 2 <= 7
                && getSource().getY() + 1 >= 0 && getSource().getY() + 1 <= 7
                && getChessColor() != getNow()[getSource().getX()+2][getSource().getY()+1].getChessColor()){
            canChessMove.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()+1));
        }

        return canChessMove;
    }
}
