import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public  KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessColor color = getChessColor();
        List<ChessboardPoint> list = new ArrayList<>();

        if(source.getX()+1<8&&source.getY()+1<8){
            if(chessComponent[source.getX()+1][source.getY()+1].getChessColor()!=color||
                    chessComponent[source.getX()+1][source.getY()+1].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()+1,source.getY()+1);
                list.add(point);
            }
        }

        if(source.getX()+1<8&&source.getY()-1>=0){
            if(chessComponent[source.getX()+1][source.getY()-1].getChessColor()!=color||
                    chessComponent[source.getX()+1][source.getY()-1].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()+1,source.getY()-1);
                list.add(point);
            }
        }
        if(source.getX()-1>=0&&source.getY()+1<8){
            if(chessComponent[source.getX()-1][source.getY()+1].getChessColor()!=color||
                    chessComponent[source.getX()-1][source.getY()+1].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()-1,source.getY()+1);
                list.add(point);
            }
        }

        if(source.getX()-1>=0&&source.getY()-1>=0){
            if(chessComponent[source.getX()-1][source.getY()-1].getChessColor()!=color||
                    chessComponent[source.getX()-1][source.getY()-1].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()-1,source.getY()-1);
                list.add(point);
            }
        }

        if(source.getX()+1<8){
            if(chessComponent[source.getX()+1][source.getY()].getChessColor()!=color||
                    chessComponent[source.getX()+1][source.getY()].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()+1,source.getY());
                list.add(point);
            }
        }

        if(source.getY()-1>=0){
            if(chessComponent[source.getX()][source.getY()-1].getChessColor()!=color||
                    chessComponent[source.getX()][source.getY()-1].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX(),source.getY()-1);
                list.add(point);
            }
        }

        if(source.getX()-1>=0){
            if(chessComponent[source.getX()-1][source.getY()].getChessColor()!=color||
                    chessComponent[source.getX()-1][source.getY()].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()-1,source.getY());
                list.add(point);
            }
        }

        if(source.getY()+1<8){
            if(chessComponent[source.getX()][source.getY()+1].getChessColor()!=color||
                    chessComponent[source.getX()][source.getY()+1].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX(),source.getY()+1);
                list.add(point);
            }
        }

        list.sort(new Comparator<>() {
            @Override
            public int compare(ChessboardPoint o1, ChessboardPoint o2) {
                if (o1.getX() - o2.getX() != 0) {
                    return o1.getX() - o2.getX();
                } else {
                    return o1.getY() - o2.getY();
                }
            }
        });

        return list;
    }

}
