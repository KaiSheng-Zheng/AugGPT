import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor){
        super(source,chessColor);
         chessComponents[source.getX()][source.getY()] = new HasChessComponent(source,chessColor);

        if(chessColor == ChessColor.BLACK){
            name = 'B';
        }else if(chessColor == ChessColor.WHITE){
            name = 'b';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<ChessboardPoint>();
        for(int x = 1 ; x < 8-getSource().getX()&&x < 8-getSource().getY(); x++){
            if(!(getChessComponents(x+ getSource().getX(),x+ getSource().getY()) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(x+ getSource().getX(),x+ getSource().getY()));
            }else if(getChessComponents(x+ getSource().getX(),x+ getSource().getY()) instanceof HasChessComponent && getChessColor() != getChessComponents(x+ getSource().getX(),x+ getSource().getY()).getChessColor()){
                answer.add(new ChessboardPoint(x+ getSource().getX(),x+ getSource().getY()));
                break;
            }else {break;}
        }for(int x = -1 ; x+getSource().getX()>=0&&x+ getSource().getY()>=0; x--){
            if(!(getChessComponents(x+ getSource().getX(),x+ getSource().getY()) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(x+ getSource().getX(),x+ getSource().getY()));
            }else if(getChessComponents(x+ getSource().getX(),x+ getSource().getY()) instanceof HasChessComponent && getChessColor() != getChessComponents(x+ getSource().getX(),x+ getSource().getY()).getChessColor()){
                answer.add(new ChessboardPoint(x+ getSource().getX(),x+ getSource().getY()));
                break;
            }else {break;}
        }for(int x = 1 ; x < 8-getSource().getX()&& getSource().getY()-x>=0; x++){
            if(!(getChessComponents(x+ getSource().getX(),getSource().getY()-x) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(x+ getSource().getX(),getSource().getY()-x));
            }else if(getChessComponents(x+ getSource().getX(),getSource().getY()-x) instanceof HasChessComponent && getChessColor() != getChessComponents(x+ getSource().getX(),getSource().getY()-x).getChessColor()){
                answer.add(new ChessboardPoint(x+ getSource().getX(),x+ getSource().getY()));
                break;
            }else {break;}
        }for(int x = -1 ; x+getSource().getX()>=0&& getSource().getY()-x<8; x--){
            if(!(getChessComponents(x+ getSource().getX(),getSource().getY()-x) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(x+ getSource().getX(),getSource().getY()-x));
            }else if(getChessComponents(x+ getSource().getX(),getSource().getY()-x) instanceof HasChessComponent && getChessColor() != getChessComponents(x+ getSource().getX(),getSource().getY()-x).getChessColor()){
                answer.add(new ChessboardPoint(x+ getSource().getX(),getSource().getY()-x));
                break;
            }else {break;}
        }
        return answer;
    }
}
