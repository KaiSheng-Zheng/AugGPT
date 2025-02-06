import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(int x, int y,ChessColor color,char name){
        super(x, y, color, name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ChessboardPoint temp_po= super.getSource();
        int temp_x = temp_po.getX();
        int temp_y = temp_po.getY();
        List<ChessboardPoint> temp_ls = new ArrayList<ChessboardPoint>();
        if(temp_x-2>=0 &&temp_y-1>=0){
            temp_ls.add(new ChessboardPoint(temp_x-2,temp_y-1));
        }
        if(temp_x-2>=0 &&temp_y+1<=7){
            temp_ls.add(new ChessboardPoint(temp_x-2,temp_y+1));
        }
        if(temp_x+2<=7 &&temp_y+1<=7){
            temp_ls.add(new ChessboardPoint(temp_x+2,temp_y+1));
        }
        if(temp_x+2<=7 &&temp_y-1>=0){
            temp_ls.add(new ChessboardPoint(temp_x+2,temp_y-1));
        }
        if(temp_x+1<=7 &&temp_y-2>=0){
            temp_ls.add(new ChessboardPoint(temp_x+1,temp_y-2));
        }
        if(temp_x-1>=0 &&temp_y-2>=0){
            temp_ls.add(new ChessboardPoint(temp_x-1,temp_y-2));
        }
        if(temp_x-1>=0 &&temp_y+2<=7){
            temp_ls.add(new ChessboardPoint(temp_x-1,temp_y+2));
        }
        if(temp_x+1<=7 &&temp_y+2<=7){
            temp_ls.add(new ChessboardPoint(temp_x+1,temp_y+2));
        }
        return temp_ls;


    }
    @Override
    public String toString(){
        return "6666";
    }
}
