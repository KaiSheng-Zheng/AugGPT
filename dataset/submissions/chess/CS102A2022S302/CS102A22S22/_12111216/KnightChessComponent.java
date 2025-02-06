import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessColor h, ChessboardPoint source){
        if(h.equals(ChessColor.BLACK))this.name='N';
        else this.name = 'n';
        this.setSource(source);
        this.setChessColor(h);

    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> ma = new ArrayList<>();

        if(getSource().getX()+1<=7&& getSource().getY()+2<=7&&(chessComponents[getSource().getX()+1][getSource().getY()+2].getChessColor().equals(ChessColor.NONE)||!(chessComponents[getSource().getX()+1][getSource().getY()+2].getChessColor().equals(this.getChessColor())))){ma.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+2));}
        if(getSource().getX()+2<=7&& getSource().getY()+1<=7&&(chessComponents[getSource().getX()+2][getSource().getY()+1].getChessColor().equals(ChessColor.NONE)||!(chessComponents[getSource().getX()+2][getSource().getY()+1].getChessColor().equals(this.getChessColor())))){ma.add(new ChessboardPoint(getSource().getX()+2, getSource().getY()+1));}

        if(getSource().getX()-1>=0&& getSource().getY()+2<=7&&(chessComponents[getSource().getX()-1][getSource().getY()+2].getChessColor().equals(ChessColor.NONE)||!(chessComponents[getSource().getX()-1][getSource().getY()+2].getChessColor().equals(this.getChessColor())))){ma.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+2));}
        if(getSource().getX()-2>=0&& getSource().getY()+1<=7&&(chessComponents[getSource().getX()-2][getSource().getY()+1].getChessColor().equals(ChessColor.NONE)||!(chessComponents[getSource().getX()-2][getSource().getY()+1].getChessColor().equals(this.getChessColor())))){ma.add(new ChessboardPoint(getSource().getX()-2, getSource().getY()+1));}

        if(getSource().getX()+1<=7&& getSource().getY()-2>=0&&(chessComponents[getSource().getX()+1][getSource().getY()-2].getChessColor().equals(ChessColor.NONE)||!(chessComponents[getSource().getX()+1][getSource().getY()-2].getChessColor().equals(this.getChessColor())))){ma.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-2));}
        if(getSource().getX()+2<=7&& getSource().getY()-1>=0&&(chessComponents[getSource().getX()+2][getSource().getY()-1].getChessColor().equals(ChessColor.NONE)||!(chessComponents[getSource().getX()+2][getSource().getY()-1].getChessColor().equals(this.getChessColor())))){ma.add(new ChessboardPoint(getSource().getX()+2, getSource().getY()-1));}

        if(getSource().getX()-1>=0&& getSource().getY()-2>=0&&(chessComponents[getSource().getX()-1][getSource().getY()-2].getChessColor().equals(ChessColor.NONE)||!(chessComponents[getSource().getX()-1][getSource().getY()-2].getChessColor().equals(this.getChessColor())))){ma.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-2));}
        if(getSource().getX()-2>=0&& getSource().getY()-1>=0&&(chessComponents[getSource().getX()-2][getSource().getY()-1].getChessColor().equals(ChessColor.NONE)||!(chessComponents[getSource().getX()-2][getSource().getY()-1].getChessColor().equals(this.getChessColor())))){ma.add(new ChessboardPoint(getSource().getX()-2, getSource().getY()-1));}
        Collections.sort(ma);
        return ma;

    }

    public String toString() {
        return name+"";
    }
}
