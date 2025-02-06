
import java.util.ArrayList;
import java.util.List;

class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessComponent[][]chessComponents, ChessboardPoint source){
        this.chessComponents=chessComponents;
        this.source=source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x= source.getX();
        int y= source.getY();
        List<ChessboardPoint>chessboardPointList=new ArrayList<>();
        for (int i=x+1;i<=7;i++){
            if (chessComponents[i][y]instanceof EmptySlotComponent){
                chessboardPointList.add(new ChessboardPoint(i,y));
            }else {
                if (chessComponents[i][y].getChessColor()!=this.getChessColor()){
                    chessboardPointList.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        for (int i=x-1;i>=0;i--){
            if (chessComponents[i][y]instanceof EmptySlotComponent){
                chessboardPointList.add(new ChessboardPoint(i,y));
            }else {
                if (chessComponents[i][y].getChessColor()!=this.getChessColor()){
                    chessboardPointList.add(new ChessboardPoint(i,y));
                }
                break;
            }
        }
        for (int i=y+1;i<=7;i++){
            if (chessComponents[x][i]instanceof EmptySlotComponent){
                chessboardPointList.add(new ChessboardPoint(x,i));
            }else {
                if (chessComponents[x][i].getChessColor()!=this.getChessColor()){
                    chessboardPointList.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        for (int i=y-1;i>=0;i--){
            if (chessComponents[x][i]instanceof EmptySlotComponent){
                chessboardPointList.add(new ChessboardPoint(x,i));
            }else {
                if (chessComponents[x][i].getChessColor()!=this.getChessColor()){
                    chessboardPointList.add(new ChessboardPoint(x,i));
                }
                break;
            }
        }
        return chessboardPointList;

    }

    @Override
    public String toString() {
        return super.toString();
    }

}
