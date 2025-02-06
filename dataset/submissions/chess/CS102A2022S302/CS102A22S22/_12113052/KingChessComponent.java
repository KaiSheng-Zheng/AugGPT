import java.util.ArrayList;
import java.util.List;
public class KingChessComponent extends ChessComponent {



    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        this.name=chessColor==ChessColor.BLACK?'K':'k';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>canMoveTo=new ArrayList<>();
        if (getSource().getX()<8&&getSource().getY()+1<8&&(chessComponents[getSource().getX()][getSource().getY()+1].getChessColor()!=getCurrentPlayer())){
            canMoveTo.add(getSource().offset(0,1));
        }
        if (getSource().getX()+1<8&&getSource().getY()>=0&&(chessComponents[getSource().getX()+1][getSource().getY()].getChessColor()!=getCurrentPlayer())){
            canMoveTo.add(getSource().offset(1,0));
        }
        if (getSource().getX()-1>=0&&getSource().getY()>=0&&(chessComponents[getSource().getX()-1][getSource().getY()].getChessColor()!=getCurrentPlayer())){
            canMoveTo.add(getSource().offset(-1,0));
        }
        if (getSource().getX()<8&&getSource().getY()-1>=0&&chessComponents[getSource().getX()][getSource().getY()-1].getChessColor()!=getCurrentPlayer()){
            canMoveTo.add(getSource().offset(0,-1));
        }
        if (getSource().getX()+1<8&&getSource().getY()+1<8&&chessComponents[getSource().getX()+1][getSource().getY()+1].getChessColor()!=getCurrentPlayer()){
            canMoveTo.add(getSource().offset(1,1));
        }
        if (getSource().getX()-1>=0&&getSource().getY()+1<8&&chessComponents[getSource().getX()-1][getSource().getY()+1].getChessColor()!=getCurrentPlayer()){
            canMoveTo.add(getSource().offset(-1,1));
        }
        if (getSource().getX()-1>=0&&getSource().getY()-1>=0&&chessComponents[getSource().getX()-1][getSource().getY()-1].getChessColor()!=getCurrentPlayer()){
            canMoveTo.add(getSource().offset(-1,-1));
        }

        if (getSource().getX()+1<8&&getSource().getY()-1>=0&&chessComponents[getSource().getX()+1][getSource().getY()-1].getChessColor()!=getCurrentPlayer()){
            canMoveTo.add(getSource().offset(1,-1));
        }
        return canMoveTo;
    }

    public ChessColor getCurrentPlayer() {
        if (this.name=='K'){
            return ChessColor.BLACK;
        }else return ChessColor.WHITE;
    }



}
