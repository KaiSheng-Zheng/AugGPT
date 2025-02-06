import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x=source.getX(),y=source.getY();
        List<ChessboardPoint> a=new ArrayList<>();
        if(chessComponents[x][y].getChessColor()==ChessColor.BLACK){
            if(x==1){
                if(chessComponents[x+1][y]instanceof EmptySlotComponent) {
                    a.add(new ChessboardPoint(x+1, y ));
                }
                if(chessComponents[x+1][y+1].getChessColor()==ChessColor.WHITE){
                    a.add(new ChessboardPoint(x+1, y+1 ));
                }
                if(chessComponents[x+2][y]instanceof EmptySlotComponent){
                    a.add(new ChessboardPoint(x+2, y ));
                }
            }else if(x==7){}
            else{
                if(chessComponents[x+1][y-1].getChessColor()==ChessColor.WHITE ){
                    a.add(new ChessboardPoint(x+1, y-1 ));
                }
                if(chessComponents[x+1][y]instanceof EmptySlotComponent) {
                a.add(new ChessboardPoint(x+1, y ));
            } if(chessComponents[x+1][y+1].getChessColor()==ChessColor.WHITE){
                    a.add(new ChessboardPoint(x+1, y+1 ));
                }
            }
        }else {
            if(x==6){
                if(chessComponents[x-2][y]instanceof EmptySlotComponent){
                    a.add(new ChessboardPoint(x-2, y ));
                }
                if(chessComponents[x-1][y]instanceof EmptySlotComponent) {
                    a.add(new ChessboardPoint(x-1, y ));
                }
            }else if(x==0){}
            else{
                if(chessComponents[x-1][y-1].getChessColor()==ChessColor.BLACK) {
                    a.add(new ChessboardPoint(x-1, y -1));
                }
                if(chessComponents[x-1][y]instanceof EmptySlotComponent) {
                    a.add(new ChessboardPoint(x-1, y ));
                }
                if(chessComponents[x-1][y+1].getChessColor()==ChessColor.BLACK) {
                    a.add(new ChessboardPoint(x-1, y+1 ));
                }
            }

        }
        return a;
    }
    public ChessboardPoint getSource(){
        return source;
    }

    public char getName() {
        return this.name;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}
