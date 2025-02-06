import java.util.ArrayList;
import java.util.List;
public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor){
        super(source,chessColor);
        chessComponents[source.getX()][source.getY()] = new HasChessComponent(source,chessColor);
        if(chessColor == ChessColor.BLACK){
            name = 'Q';
        }else if(chessColor == ChessColor.WHITE){
            name = 'q';
        }
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> answer = new ArrayList<ChessboardPoint>();
        for(int x = getSource().getX(); x < 8; x++){
            if(!(getChessComponents(x, getSource().getY()) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(x, getSource().getY()));
            }else if(getChessComponents(x, getSource().getY()) instanceof HasChessComponent && getChessColor() != getChessComponents(x, getSource().getY()).getChessColor()){
                answer.add(new ChessboardPoint(x, getSource().getY()));
                break;
            }else {break;}
        }for(int x = getSource().getX(); x >=0; x--) {
            if (!(getChessComponents(x, getSource().getY()) instanceof HasChessComponent)) {
                answer.add(new ChessboardPoint(x, getSource().getY()));
            } else if (getChessComponents(x, getSource().getY()) instanceof HasChessComponent && getChessColor() != getChessComponents(x, getSource().getY()).getChessColor()) {
                answer.add(new ChessboardPoint(x, getSource().getY()));
                break;
            } else {
                break;
            }
        }for(int y = getSource().getY(); y < 8; y++){
            if(!(getChessComponents(getSource().getX(), y) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(getSource().getX(), y));
            }else if(getChessComponents(getSource().getX(), y) instanceof HasChessComponent && getChessColor() != getChessComponents(getSource().getX(), y).getChessColor()){
                answer.add(new ChessboardPoint(getSource().getX(), y));
                break;
            }else {break;}
        }for(int y = getSource().getY(); y >=0; y--){
            if(!(getChessComponents(getSource().getX(), y) instanceof HasChessComponent)){
                answer.add(new ChessboardPoint(getSource().getX(), y));
            }else if(getChessComponents(getSource().getX(), y) instanceof HasChessComponent && getChessColor() != getChessComponents(getSource().getX(), y).getChessColor()){
                answer.add(new ChessboardPoint(getSource().getX(), y));
                break;
            }else {break;}
        } for(int x = 1 ; x < 8-getSource().getX()&&x < 8-getSource().getY(); x++){
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
