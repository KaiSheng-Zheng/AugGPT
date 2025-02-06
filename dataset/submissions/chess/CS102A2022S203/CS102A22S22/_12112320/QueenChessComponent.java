import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    public QueenChessComponent(ChessboardPoint source, ChessColor color,char name) {
        super.setSource(source);super.setChessColor(color);super.setName(name);
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
    public boolean canMoveTo(ChessboardPoint destination) {
        ChessboardPoint source = getSource();char[][] chars= getChessBoard();
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chars[row][col]=='_')) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chars[row][col]=='_')) {
                    return false;
                }
            }
        } else if (Math.abs(destination.getX()-source.getX()) == Math.abs(destination.getY()-source.getY())) {
            for (int i = 1; i < Math.abs(destination.getX() - source.getX()); i++) {
                int n,m;
                if (destination.getX()>source.getX()){n = 1;}
                else {n = -1;}
                if (destination.getY()>source.getY()){m = 1;}
                else {m = -1;}
                if (!(chars[source.getX() + i*n][source.getY() + i*m]=='_')) {
                    return false;
                }
            }
        }else return false;
        return true;
    }

}
