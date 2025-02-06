import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(int x,int y, ChessColor color) {
        super();
        super.setSource(new ChessboardPoint(x,y));
        super.setChessColor(color);
        if(color.equals(ChessColor.WHITE)){
        name='k';}
        else if(color.equals(ChessColor.BLACK)){
            name='K';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> k=new ArrayList<>();
        for(int i=-1;i<=1;i++){
            for(int j=-1;j<=1;j++){
                if(super.getSource().getX()+i>=0&&super.getSource().getX()+i<=7&&super.getSource().getY()+j>=0&&super.getSource().getY()+j<=7&&!chessComponent[super.getSource().getX()+i][super.getSource().getY()+j].getChessColor().equals(super.getChessColor())){
                    k.add(new ChessboardPoint(super.getSource().getX()+i,super.getSource().getY()+j));
                }
            }
        }
        k.remove(new ChessboardPoint(super.getSource().getX(),super.getSource().getY()));
        return k;
    }
}
