

import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        super.name=name;
    }
@Override
public void setName(char name){
        this.name=name;
}
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> moveto=new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);
                int sign=1;
                int deltaX = Math.abs(source.getX() - destination.getX());
                int deltaY = Math.abs(source.getY() - destination.getY());
                if(deltaX<=1&&deltaY<=1&&(deltaX+deltaY!=0)){
                }
                else {
                    sign=0;
                }
                if(sign==1&&chessComponents[destination.getX()][destination.getY()].getChessColor()!=this.chessColor){
                    moveto.add(destination);
                }
            }
        }
        return moveto;
    }
    public void setSource(int a,int b){
        source=new ChessboardPoint(a,b);
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
}
