import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    ChessComponent[][]chessComponents;
    public KnightChessComponent(){

    }
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        this.name=chessColor==ChessColor.BLACK?'N':'n';
    }

    public List<ChessboardPoint>canMoveTo(){
        List<ChessboardPoint>canMoveTo=new ArrayList<>();
        if (getSource().getX()+2<8&&getSource().getY()+1<8&&(chessComponents[getSource().getX()+2][getSource().getY()+1].getChessColor()!=getCurrentPlayer())){
            canMoveTo.add(getSource().offset(2,1));
        }
        if (getSource().getX()-2>=0&&getSource().getY()+1<8&&(chessComponents[getSource().getX()-2][getSource().getY()+1].getChessColor()!=getCurrentPlayer())){
            canMoveTo.add(getSource().offset(-2,1));
        }
        if (getSource().getX()-2>=0&&getSource().getY()-1>=0&&(chessComponents[getSource().getX()-2][getSource().getY()-1].getChessColor()!=getCurrentPlayer())){
            canMoveTo.add(getSource().offset(-2,-1));
        }
        if (getSource().getX()+2<8&&getSource().getY()-1>=0&&(chessComponents[getSource().getX()+2][getSource().getY()-1].getChessColor()!=getCurrentPlayer())){
            canMoveTo.add(getSource().offset(2,-1));
        }//change on x==2, change on y==1
        if (getSource().getX()+1<8&&getSource().getY()+2<8&&(chessComponents[getSource().getX()+1][getSource().getY()+2].getChessColor()!=getCurrentPlayer())){
            canMoveTo.add(getSource().offset(1,2));
        }
        if (getSource().getX()-1>=0&&getSource().getY()+2<8&&(chessComponents[getSource().getX()-1][getSource().getY()+2].getChessColor()!=getCurrentPlayer())){
            canMoveTo.add(getSource().offset(-1,2));
        }
        if (getSource().getX()-1>=0&&getSource().getY()-2>=0&&(chessComponents[getSource().getX()-1][getSource().getY()-2].getChessColor()!=getCurrentPlayer())){
            canMoveTo.add(getSource().offset(-1,-2));
        }
        if (getSource().getX()+1<8&&getSource().getY()-2>=0&&(chessComponents[getSource().getX()+1][getSource().getY()-2].getChessColor()!=getCurrentPlayer())){
            canMoveTo.add(getSource().offset(1,-2));
        }//change on y==2,change on x==1
        return canMoveTo;
    }


    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public ChessColor getCurrentPlayer(){
        if (this.name=='N'){
            return ChessColor.BLACK;
        }else return ChessColor.WHITE;
    }
}
