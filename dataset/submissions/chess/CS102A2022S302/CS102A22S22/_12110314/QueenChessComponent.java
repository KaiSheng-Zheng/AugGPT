import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(){
        super();
        name='Q';
    }
    public QueenChessComponent(int x,int y){
        super(x, y);
        name='Q';
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
        {
            int dx=1;int dy=1;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dx++;dy++;
            }
        }
        {
            int dx=1;int dy=-1;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dx++;dy--;
            }
        }
        {
            int dx=-1;int dy=1;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dx--;dy++;
            }
        }
        {
            int dx=-1;int dy=-1;
            while (valid(dx,dy)){
                ap.add(source.xinWei(dx,dy));
                if (this.getQiPan().getChess(source.getX()+dx,source.getY()+dy).getChessColor()!=ChessColor.NONE){
                    break;
                }
                dx--;dy--;
            }
        }
        return ap;
    }
}
