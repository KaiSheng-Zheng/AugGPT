import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessColor color = getChessColor();
        List<ChessboardPoint> list = new ArrayList<>();

        for (int i = source.getX()-1; i >=0 ; i--) {
            ChessboardPoint point = new ChessboardPoint(i,source.getY());
            if(chessComponent[i][source.getY()].getChessColor()!=color||
                    chessComponent[i][source.getY()].getChessColor()==ChessColor.NONE){
                boolean b = true;
                for (int j = source.getX()-1; j >i; j--) {
                    if(!(chessComponent[j][source.getY()] instanceof EmptySlotComponent)){
                        b = false;
                        break;
                    }
                }
                if(b){
                    list.add(point);
                }
            }
        }

        for (int i = source.getX()+1; i < 8; i++) {
            ChessboardPoint point = new ChessboardPoint(i,source.getY());

            if(chessComponent[i][source.getY()].getChessColor()!=color||
                    chessComponent[i][source.getY()].getChessColor()==ChessColor.NONE){
                boolean b = true;
                for (int j = source.getX()+1; j <i; j++) {
                    if(!(chessComponent[j][source.getY()] instanceof EmptySlotComponent)){
                        b = false;
                        break;
                    }
                }
                if(b){
                    list.add(point);
                }
            }
        }

        for (int i = source.getY()-1; i >=0 ; i--) {
            ChessboardPoint point = new ChessboardPoint(source.getX(),i);

            if(chessComponent[source.getX()][i].getChessColor()!=color||
                    chessComponent[source.getX()][i].getChessColor()==ChessColor.NONE){
                boolean b = true;
                for (int j = source.getY()-1; j >i; j--) {
                    if(!(chessComponent[source.getX()][j] instanceof EmptySlotComponent)){
                        b = false;
                        break;
                    }
                }
                if(b){
                    list.add(point);
                }
            }
        }

        for (int i = source.getY()+1; i < 8; i++) {
            ChessboardPoint point = new ChessboardPoint(source.getX(),i);
            if(chessComponent[source.getX()][i].getChessColor()!=color||
                    chessComponent[source.getX()][i].getChessColor()==ChessColor.NONE){
                boolean b = true;
                for (int j = source.getY()+1; j < i; j++) {
                    if(!(chessComponent[source.getX()][j] instanceof EmptySlotComponent)){
                        b = false;
                        break;
                    }
                }
                if(b){
                    list.add(point);
                }
            }
        }
        for (int i = source.getX()-1,l = source.getY() + 1; i >=0&&l<8 ; i--,l++) {//youshang
            ChessboardPoint point = new ChessboardPoint(i,l);
            if(chessComponent[i][l].getChessColor()!=color||chessComponent[i][l].getChessColor()==ChessColor.NONE){
                boolean b = true;
                for (int j = source.getX()-1,k = source.getY() + 1; j >i&& k < l; j--,k++) {
                    if(!(chessComponent[j][k] instanceof EmptySlotComponent)){
                        b = false;
                        break;
                    }
                }
                if(b){
                    list.add(point);
                }
            }
        }

        for (int i = source.getX()+1,l = source.getY() + 1; i < 8&&l<8; i++,l++) {//youxia
            ChessboardPoint point = new ChessboardPoint(i,l);

            if(chessComponent[i][l].getChessColor()!=color|| chessComponent[i][l].getChessColor()==ChessColor.NONE){
                boolean b = true;
                for (int j = source.getX()+1,k = source.getY() + 1; j <i && k < l; j++,k++) {
                    if(!(chessComponent[j][k] instanceof EmptySlotComponent)){
                        b = false;
                        break;
                    }
                }
                if(b){
                    list.add(point);
                }
            }
        }

        for (int i = source.getY()-1,l = source.getX()-1; i >=0 && l>=0 ; i--,l--) {//zuoshang
            ChessboardPoint point = new ChessboardPoint(l,i);

            if(chessComponent[l][i].getChessColor()!=color||chessComponent[l][i].getChessColor()==ChessColor.NONE){
                boolean b = true;
                for (int j = source.getY()-1,k = source.getX()-1; j >i && k>l; j--,k--) {
                    if(!(chessComponent[k][j] instanceof EmptySlotComponent)){
                        b = false;
                        break;
                    }
                }
                if(b){
                    list.add(point);
                }
            }
        }

        for (int i = source.getY()-1,l = source.getX()+1; i >= 0 && l<8; i--,l++) {//zuoxia
            ChessboardPoint point = new ChessboardPoint(l,i);
            if(chessComponent[l][i].getChessColor()!=color||chessComponent[l][i].getChessColor()==ChessColor.NONE){
                boolean b = true;
                for (int j = source.getY()-1,k = source.getX()+1; j > i&&k<l; j--,k++) {
                    if(!(chessComponent[k][j] instanceof EmptySlotComponent)){
                        b = false;
                        break;
                    }
                }
                if(b){
                    list.add(point);
                }
            }
        }

        Collections.sort(list, new Comparator<ChessboardPoint>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if(o1.getX()-o2.getX()!=0){
                    return o1.getX()-o2.getX();
                }else{
                    return o1.getY()-o2.getY();
                }
            }
        });

        return list;
    }
}
