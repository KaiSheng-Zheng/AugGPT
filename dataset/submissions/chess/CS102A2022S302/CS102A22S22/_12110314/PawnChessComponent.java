import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(){
        super();
        name='P';
    }
    public PawnChessComponent(int x,int y){
        super(x, y);
        name='P';
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> ap=new ArrayList<>();
        if (getChessColor()==ChessColor.BLACK){
            if (valid(1,0)){
                ap.add(source.xinWei(1,0));
                if (virgin&&valid(2,0)){
                    ap.add(source.xinWei(2,0));
                }
            }
            if (valid(1,1)){
                if (getQiPan().getChess(source.getX()+1,source.getY()+1).getChessColor()==ChessColor.WHITE){
                    ap.add(source.xinWei(1,1));
                }
            }
            if (valid(1,-1)){
                if (getQiPan().getChess(source.getX()+1,source.getY()-1).getChessColor()==ChessColor.WHITE){
                    ap.add(source.xinWei(1,-1));
                }
            }
        }
        if (getChessColor()==ChessColor.WHITE){
            if (valid(-1,0)){
                ap.add(source.xinWei(-1,0));
                if (virgin&&valid(-2,0)){
                    ap.add(source.xinWei(-2,0));
                }
            }
            if (valid(-1,1)){
                if (getQiPan().getChess(source.getX()-1,source.getY()+1).getChessColor()==ChessColor.BLACK){
                    ap.add(source.xinWei(-1,1));
                }
            }
            if (valid(-1,-1)){
                if (getQiPan().getChess(source.getX()-1,source.getY()-1).getChessColor()==ChessColor.BLACK){
                    ap.add(source.xinWei(-1,-1));
                }
            }
        }
        return ap;
    }
}
