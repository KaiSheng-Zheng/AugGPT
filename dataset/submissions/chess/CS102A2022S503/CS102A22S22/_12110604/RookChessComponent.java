import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{

    public  RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }
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
        list.sort((o1, o2) -> {
            if (o1.getX() - o2.getX() != 0) {
                return o1.getX() - o2.getX();
            } else {
                return o1.getY() - o2.getY();
            }
        });

        return list;
    }

}
