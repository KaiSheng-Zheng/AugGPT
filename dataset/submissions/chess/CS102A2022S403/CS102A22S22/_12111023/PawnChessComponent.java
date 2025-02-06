import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(int x, int y,ChessColor color,char name){
        super(x, y, color, name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ChessboardPoint temp_po= super.getSource();
        int temp_x = temp_po.getX();
        int temp_y = temp_po.getY();
        List<ChessboardPoint> temp_ls = new ArrayList<ChessboardPoint>();
        if (super.getChessColor() == ChessColor.WHITE && temp_x == 6){
            temp_ls.add(new ChessboardPoint(temp_x-1,temp_y));
            temp_ls.add(new ChessboardPoint(temp_x-2,temp_y));
            return temp_ls;
        }
        else if(super.getChessColor() == ChessColor.BALCK && temp_x == 1){
            temp_ls.add(new ChessboardPoint(temp_x+1,temp_y));
            temp_ls.add(new ChessboardPoint(temp_x+2,temp_y));
            return temp_ls;
        }
        else if(super.getChessColor() == ChessColor.WHITE){
            if(temp_x-1>=0){
                temp_ls.add(new ChessboardPoint(temp_x-1,temp_y));
            }
            if(temp_x-1>=0 && temp_y-1>=0 ){
                temp_ls.add(new ChessboardPoint(temp_x-1,temp_y-1));
            }
            if(temp_x-1>=0 && temp_y+1<=7 ){
                temp_ls.add(new ChessboardPoint(temp_x-1,temp_y+1));
            }
            return temp_ls;
        }
        else {
            if(temp_x+1<=7){
                temp_ls.add(new ChessboardPoint(temp_x+1,temp_y));
            }
            if(temp_x+1<=7 && temp_y-1>=0 ){
                temp_ls.add(new ChessboardPoint(temp_x+1,temp_y-1));
            }
            if(temp_x+1<=7 && temp_y+1<=7 ){
                temp_ls.add(new ChessboardPoint(temp_x+1,temp_y+1));
            }
            return temp_ls;
        }
    }
    @Override
    public String toString(){
        return "6666";
    }
}
