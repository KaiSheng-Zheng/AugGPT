import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{



    public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
        if (chessColor.equals(ChessColor.BLACK)) setName('B');
        if (chessColor.equals(ChessColor.WHITE)) setName('b');
        setChessColor(chessColor);
        setSource(source);
    }

    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> list=new ArrayList<>();
        int x=this.getSource().getX();int y=this.getSource().getY();
        for (int i=1;i<=7;i++){
            if (x-i<=7&&x-i>=0&&y-i<=7&&y-i>=0) list.add(new ChessboardPoint(x-i,y-i));
            if (x-i<=7&&x-i>=0&&y+i<=7&&y+i>=0) list.add(new ChessboardPoint(x-i,y+i));
            if (x+i<=7&&x+i>=0&&y-i<=7&&y-i>=0) list.add(new ChessboardPoint(x+i,y-i));
            if (x+i<=7&&x+i>=0&&y+i<=7&&y+i>=0) list.add(new ChessboardPoint(x+i,y+i));
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
