import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{



    public RookChessComponent(ChessboardPoint source,ChessColor chessColor){
        if (chessColor.equals(ChessColor.BLACK)) setName('R');
        if (chessColor.equals(ChessColor.WHITE)) setName('r');
        setChessColor(chessColor);
        setSource(source);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list=new ArrayList<>();
        int x=this.getSource().getX();int y=this.getSource().getY();
        for (int i=1;i<=7;i++) {
            if (x-i<=7&&x-i>=0) list.add(new ChessboardPoint(x-i,y));
            if (y-i<=7&&y-i>=0) list.add(new ChessboardPoint(x,y-i));
            if (y+i<=7&&y+i>=0) list.add(new ChessboardPoint(x,y+i));
            if (x+i<=7&&x+i>=0) list.add(new ChessboardPoint(x+i,y));
        }
        for(int i =0 ; i<list.size()-1 ; i++) {
            for(int j=0 ; j<list.size()-1-i ; j++) {
                if(list.get(j).getX()>list.get(j+1).getX()) {
                    ChessboardPoint temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
                if(list.get(j).getX()==list.get(j+1).getX()&&list.get(j).getY()>list.get(j+1).getY()) {
                    ChessboardPoint temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
        return list;
    }
}