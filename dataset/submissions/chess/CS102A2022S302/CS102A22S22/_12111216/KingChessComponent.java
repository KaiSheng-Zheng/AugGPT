import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessColor h, ChessboardPoint source){
        if(h.equals(ChessColor.BLACK))this.name='K';
        else this.name = 'k';
        this.setSource(source);
        this.setChessColor(h);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> wang = new ArrayList<>();
        if(getSource().getX()+1<=7&& getSource().getY()+1<=7&&this.checkColor(chessComponents[getSource().getX()+1][getSource().getY()+1])){wang.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+1 ));}
        if(getSource().getX()-1>=0&& getSource().getY()+1<=7&&this.checkColor(chessComponents[getSource().getX()-1][getSource().getY()+1])){wang.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+1 ));}
        if(getSource().getX()+1<=7&& getSource().getY()-1>=0&&this.checkColor(chessComponents[getSource().getX()+1][getSource().getY()-1])){wang.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-1 ));}
        if(getSource().getX()-1>=0&& getSource().getY()-1>=0&&this.checkColor(chessComponents[getSource().getX()-1][getSource().getY()-1])){wang.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-1 ));}

        if(getSource().getX()+1<=7&&this.checkColor(chessComponents[getSource().getX()+1][getSource().getY()])){wang.add(new ChessboardPoint(getSource().getX()+1, getSource().getY() ));}
        if(getSource().getY()+1<=7&&this.checkColor(chessComponents[getSource().getX()][getSource().getY()+1])){wang.add(new ChessboardPoint(getSource().getX(), getSource().getY()+1 ));}
        if (getSource().getX()-1>=0&&this.checkColor(chessComponents[getSource().getX()-1][getSource().getY()])){wang.add(new ChessboardPoint(getSource().getX()-1, getSource().getY() ));}
        if (getSource().getY()-1>=0&&this.checkColor(chessComponents[getSource().getX()][getSource().getY()-1])){wang.add(new ChessboardPoint(getSource().getX(), getSource().getY()-1 ));}
        Collections.sort(wang);
        return wang;

    }

    public String toString() {
        return name+"";
    }
}
