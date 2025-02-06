import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source=source;
        this.chessColor=chessColor;
        super.name=name;
    }
    @Override
    public void setName(char name){
        this.name=name;
    }
    public ChessColor getChessColor(){
        return chessColor;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> moveto=new ArrayList<>();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint destination=new ChessboardPoint(i,j);int sign=1;
                int deltaX = Math.abs(source.getX() - destination.getX());
                int deltaY = Math.abs(source.getY() - destination.getY());
                if (deltaX == deltaY&&!(deltaX==0&deltaY==0)) {
                    if ((destination.getX() > source.getX() && destination.getY() < source.getY()) || (destination.getX() < source.getX() && destination.getY() > source.getY())) {//zuoxiayoushang
                        int row = Math.max(source.getX(), destination.getX())-1;
                        for (int col = Math.min(destination.getY(), source.getY())+1; col < Math.max(destination.getY(), source.getY()); col++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                sign=0;
                            }
                            row--;
                        }
                    }
                    if((destination.getX() > source.getX() && destination.getY() > source.getY()) || (destination.getX() < source.getX() && destination.getY() < source.getY())) {
                        int row = Math.min(source.getX(), destination.getX())+1;
                        for (int col = Math.min(destination.getY(), source.getY())+1; col < Math.max(destination.getY(), source.getY()); col++) {
                            if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                                sign=0;
                            }
                            row++;
                        }
                    }
                }else {
                    sign=0;
                }
                if(sign==1&&chessComponents[destination.getX()][destination.getY()].getChessColor()!=this.chessColor){
                    moveto.add(destination);
                }
            }
        }
        return moveto;
    }
}
