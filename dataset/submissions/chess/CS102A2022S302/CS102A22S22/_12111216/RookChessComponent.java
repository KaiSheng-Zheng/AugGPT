import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(ChessColor h, ChessboardPoint source){
        if(h.equals(ChessColor.BLACK))this.name='R';
        else this.name = 'r';
        this.setSource(source);
        this.setChessColor(h);
    }

    public List<ChessboardPoint> canMoveTo(){
        List<ChessboardPoint> ju = new ArrayList<>();
        for (int i = 1; i < 8; i++) {
            if(getSource().getX()+i<=7){
                if(chessComponents[getSource().getX() + i][getSource().getY()].getChessColor().equals(ChessColor.NONE))
                    ju.add(new ChessboardPoint(getSource().getX()+i, getSource().getY() ));
                if (chessComponents[getSource().getX() + i][getSource().getY()].getChessColor().equals(this.getChessColor()))
                    break;
                if (!(chessComponents[getSource().getX() + i][getSource().getY()].getChessColor().equals(this.getChessColor())|| chessComponents[getSource().getX() + i][getSource().getY()].getChessColor().equals(ChessColor.NONE)))
                {ju.add(new ChessboardPoint(getSource().getX()+i, getSource().getY() ));break;}
            }}

        for (int i = 1; i < 8; i++) {
            if(getSource().getX()+i>=0){
                if(chessComponents[getSource().getX() - i][getSource().getY()].getChessColor().equals(ChessColor.NONE))
                    ju.add(new ChessboardPoint(getSource().getX()-i, getSource().getY() ));
                if (chessComponents[getSource().getX() - i][getSource().getY()].getChessColor().equals(this.getChessColor()))
                    break;
                if (!(chessComponents[getSource().getX() - i][getSource().getY()].getChessColor().equals(this.getChessColor())|| chessComponents[getSource().getX() - i][getSource().getY()].getChessColor().equals(ChessColor.NONE)))
                {ju.add(new ChessboardPoint(getSource().getX()-i, getSource().getY() ));break;}
            }}

        for (int i = 1; i < 8; i++) {
            if(getSource().getY()+i<=7){
                if(chessComponents[getSource().getX()][getSource().getY()+i].getChessColor().equals(ChessColor.NONE))
                    ju.add(new ChessboardPoint(getSource().getX(), getSource().getY()+i ));
                if (chessComponents[getSource().getX()][getSource().getY()+i].getChessColor().equals(this.getChessColor()))
                    break;
                if (!(chessComponents[getSource().getX()][getSource().getY()+i].getChessColor().equals(this.getChessColor())|| chessComponents[getSource().getX()][getSource().getY()+i].getChessColor().equals(ChessColor.NONE)))
                {ju.add(new ChessboardPoint(getSource().getX(), getSource().getY()+i ));break;}
            }}
        for (int i = 1; i < 8; i++) {
            if(getSource().getY()-i>=0){
                if(chessComponents[getSource().getX()][getSource().getY()-i].getChessColor().equals(ChessColor.NONE))
                    ju.add(new ChessboardPoint(getSource().getX(), getSource().getY()-i ));
                if (chessComponents[getSource().getX()][getSource().getY()-i].getChessColor().equals(this.getChessColor()))
                    break;
                if (!(chessComponents[getSource().getX()][getSource().getY()-i].getChessColor().equals(this.getChessColor())|| chessComponents[getSource().getX()][getSource().getY()-i].getChessColor().equals(ChessColor.NONE)))
                {ju.add(new ChessboardPoint(getSource().getX(), getSource().getY()-i ));break;}
            }}
        Collections.sort(ju);
        return ju;
    }

    public String toString() {
        return name+"";
    }
}
