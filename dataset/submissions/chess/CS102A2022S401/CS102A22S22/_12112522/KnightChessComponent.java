import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class KnightChessComponent extends ChessComponent{



    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessColor color = getChessColor();
        List<ChessboardPoint> list = new ArrayList<>();

        if(source.getX()+2<8&&source.getY()+1<8){
            if(chessComponent[source.getX()+2][source.getY()+1].getChessColor()!=color||
                    chessComponent[source.getX()+2][source.getY()+1].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()+2,source.getY()+1);
                list.add(point);
            }
        }

        if(source.getX()+2<8&&source.getY()-1>=0){
            if(chessComponent[source.getX()+2][source.getY()-1].getChessColor()!=color||
                    chessComponent[source.getX()+2][source.getY()-1].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()+2,source.getY()-1);
                list.add(point);
            }
        }
        if(source.getX()-2>=0&&source.getY()+1<8){
            if(chessComponent[source.getX()-2][source.getY()+1].getChessColor()!=color||
                    chessComponent[source.getX()-2][source.getY()+1].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()-2,source.getY()+1);
                list.add(point);
            }
        }

        if(source.getX()-2>=0&&source.getY()-1>=0){
            if(chessComponent[source.getX()-2][source.getY()-1].getChessColor()!=color||
                    chessComponent[source.getX()-2][source.getY()-1].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()-2,source.getY()-1);
                list.add(point);
            }
        }

        if(source.getX()+1<8&&source.getY()+2<8){
            if(chessComponent[source.getX()+1][source.getY()+2].getChessColor()!=color||
                    chessComponent[source.getX()+1][source.getY()+2].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()+1,source.getY()+2);
                list.add(point);
            }
        }

        if(source.getX()+1<8&&source.getY()-2>=0){
            if(chessComponent[source.getX()+1][source.getY()-2].getChessColor()!=color||
                    chessComponent[source.getX()+1][source.getY()-2].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()+1,source.getY()-2);
                list.add(point);
            }
        }

        if(source.getX()-1>=0&&source.getY()+2<8){
            if(chessComponent[source.getX()-1][source.getY()+2].getChessColor()!=color||
                    chessComponent[source.getX()-1][source.getY()+2].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()-1,source.getY()+2);
                list.add(point);
            }
        }

        if(source.getX()-1>=0&&source.getY()-2>=0){
            if(chessComponent[source.getX()-1][source.getY()-2].getChessColor()!=color||
                    chessComponent[source.getX()-1][source.getY()-2].getChessColor()==ChessColor.NONE){
                ChessboardPoint point = new ChessboardPoint(source.getX()-1,source.getY()-2);
                list.add(point);
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
