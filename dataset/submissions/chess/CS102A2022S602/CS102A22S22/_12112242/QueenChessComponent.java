import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessComponent[][]chessComponents, ChessboardPoint source){
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
        for (int i=1;i<8;i++){
            if (x+i<8&&x+i>=0&&y+i<8&&y+i>=0) {
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
            if (x-i<8&&x-i>=0&&y-i<8&&y-i>=0){
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
            if (x+i<8&&x+i>=0&&y-i<8&&y-i>=0){
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
            if (x-i<8&&x-i>=0&&y+i<8&&y+i>=0){
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
