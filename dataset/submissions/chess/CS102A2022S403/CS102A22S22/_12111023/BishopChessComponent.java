import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(int x, int y,ChessColor color,char name){
        super(x, y, color, name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo(){
        ChessboardPoint temp_po= super.getSource();
        int temp_x = temp_po.getX();
        int temp_y = temp_po.getY();
        List<ChessboardPoint> temp_ls = new ArrayList<ChessboardPoint>();
        int x = temp_x;
        int y = temp_y;
        x++;
        y--;
        while(x>=0&&x<=7&&y>=0&&y<=7){

            temp_ls.add(new ChessboardPoint(x,y));
            x++;
            y--;
        }
        x = temp_x;
        y = temp_y;
        x++;
        y++;
        while(x>=0&&x<=7&&y>=0&&y<=7){

            temp_ls.add(new ChessboardPoint(x,y));
            x++;
            y++;
        }
        x = temp_x;
        y = temp_y;
        x--;
        y++;
        while(x>=0&&x<=7&&y>=0&&y<=7){

            temp_ls.add(new ChessboardPoint(x,y));
            x--;
            y++;
        }
        x = temp_x;
        y = temp_y;
        x--;
        y--;
        while(x>=0&&x<=7&&y>=0&&y<=7){

            temp_ls.add(new ChessboardPoint(x,y));
            x--;
            y--;
        }
        return temp_ls;
    }
    @Override
    public String toString(){
        return "6666";
    }
}
