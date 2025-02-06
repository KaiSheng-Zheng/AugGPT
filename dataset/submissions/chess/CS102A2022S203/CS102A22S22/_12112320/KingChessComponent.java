import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{
    public KingChessComponent(ChessboardPoint source, ChessColor color,char name) {
       super.setSource(source); super.setChessColor(color);super.setName(name);
        super.add(source,name);
    }
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> can=new ArrayList<>();char[][] chars= getChessBoard();
        ChessboardPoint source = getSource();
        int row = source.getX();
        int col = source.getY();
        for (int i=0;i<8;i++){
            for (int j=0;j<8;j++){
                ChessboardPoint des=new ChessboardPoint(i,j);
                boolean a=Character.isUpperCase(chars[i][j])&&Character.isUpperCase(chars[row][col]);
                boolean b=Character.isLowerCase(chars[i][j])&&Character.isLowerCase(chars[row][col]);
                if (canMoveTo(des)&&!a&&!b){
                    can.add(des);
                }
            }
        }
        return can;
    }
    public boolean canMoveTo( ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        return Math.abs(destination.getX() - source.getX()) <= 1 && Math.abs(destination.getY() - source.getY()) <= 1;
    }

}
