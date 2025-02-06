import java.util.ArrayList;
import java.util.List;
public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor){
        super(source,chessColor);
        chessComponents[source.getX()][source.getY()] = new HasChessComponent(source,chessColor);
        if(chessColor == ChessColor.BLACK){
            name = 'P';
        }else if(chessColor == ChessColor.WHITE){
            name = 'p';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<ChessboardPoint>();
        if(getChessColor()== ChessColor.BLACK){
            if( !(getChessComponents(getSource().getX()+1,getSource().getY()) instanceof HasChessComponent)&&getSource().getX()+1<8){
                answer.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
            }else if(getSource().getX()==1&&!(getChessComponents(getSource().getX()+2,getSource().getY()) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()));
            }else if (getChessComponents( getSource().getX()+1, getSource().getY()+1) instanceof HasChessComponent && getChessColor() != getChessComponents( getSource().getX()+1, getSource().getY()+1).getChessColor()){
                answer.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()+1));
            }else if (getChessComponents( getSource().getX()+1, getSource().getY()-1) instanceof HasChessComponent && getChessColor() != getChessComponents( getSource().getX()+1, getSource().getY()-1).getChessColor()){
                answer.add(new ChessboardPoint(getSource().getX()+1, getSource().getY()-1));
            }
        }else if(getChessColor()== ChessColor.WHITE){
            if( !(getChessComponents(getSource().getX()-1,getSource().getY()) instanceof HasChessComponent)&&getSource().getX()-1>=0){
                answer.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
            }else if(getSource().getX()==6&&!(getChessComponents(getSource().getX()-2,getSource().getY()) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()));
            }else if (getChessComponents( getSource().getX()-1, getSource().getY()-1) instanceof HasChessComponent && getChessColor() != getChessComponents( getSource().getX()-1, getSource().getY()-1).getChessColor()){
                answer.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()-1));
            }else if (getChessComponents( getSource().getX()-1, getSource().getY()+1) instanceof HasChessComponent && getChessColor() != getChessComponents( getSource().getX()-1, getSource().getY()+1).getChessColor()){
                answer.add(new ChessboardPoint(getSource().getX()-1, getSource().getY()+1));
            }
        }
        return null;
    }
}
