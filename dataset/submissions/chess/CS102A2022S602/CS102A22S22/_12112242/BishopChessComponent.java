import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessComponent[][]chessComponents, ChessboardPoint source){
        this.chessComponents=chessComponents;
        this.source=source;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x= source.getX();
        int y= source.getY();
        List<ChessboardPoint>chessboardPointList=new ArrayList<>();
        ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
        for (int i=1;i<8;i++){
            if (chessboardPoint.offset(i,i)!=null) {
                if (chessComponents[x + i][y + i] instanceof EmptySlotComponent) {
                    chessboardPointList.add(new ChessboardPoint(x + i, y + i));
                } else {
                    if (chessComponents[x + i][y + i].getChessColor() != this.getChessColor()) {
                        chessboardPointList.add(new ChessboardPoint(x + i, y + i));
                        break;
                    }
                    else {
                        break;
                    }
                }
            }}
        for (int i=1;i<8;i++){
        if (chessboardPoint.offset(-i,-i)!=null){
            if (chessComponents[x-i][y-i]instanceof EmptySlotComponent){
                chessboardPointList.add(new ChessboardPoint(x-i,y-i));
            }else {
                if (chessComponents[x-i][y-i].getChessColor()!=this.getChessColor()){
                    chessboardPointList.add(new ChessboardPoint(x-i,y-i));
                    break;
                }else {
                break;}
            }}}
        for (int i=1;i<8;i++){
        if (chessboardPoint.offset(i,-i)!=null){
            if (chessComponents[x+i][y-i]instanceof EmptySlotComponent){
                chessboardPointList.add(new ChessboardPoint(x+i,y-i));
            }else {
                if (chessComponents[x+i][y-i].getChessColor()!=this.getChessColor()){
                    chessboardPointList.add(new ChessboardPoint(x+i,y-i));
                    break;
                }else {
                break;}
            }}}
        for (int i=1;i<8;i++){
        if (chessboardPoint.offset(-i,i)!=null){
            if (chessComponents[x-i][y+i]instanceof EmptySlotComponent){
                chessboardPointList.add(new ChessboardPoint(x-i,y+i));
            }else {
                if (chessComponents[x-i][y+i].getChessColor()!=this.getChessColor()){
                    chessboardPointList.add(new ChessboardPoint(x-i,y+i));
                    break;
                }else {
                break;}
            }}
    }
        return chessboardPointList;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}