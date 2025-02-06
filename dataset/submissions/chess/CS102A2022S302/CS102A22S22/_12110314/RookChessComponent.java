import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(){
        super();
        name='R';
    }
    public RookChessComponent(int x,int y){
        super(x, y);
        name='R';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ap=new ArrayList<>();
        {
            int dx=1;int dy=0;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dx++;
            }
        }
        {
            int dx=-1;int dy=0;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dx--;
            }
        }
        {
            int dx=0;int dy=1;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dy++;
            }
        }
        {
            int dx=0;int dy=-1;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dy--;
            }
        }
        return ap;
    }
}
