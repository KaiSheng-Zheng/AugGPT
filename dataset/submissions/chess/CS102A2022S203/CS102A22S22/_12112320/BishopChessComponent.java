import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor color, char name) {
        super.setSource(source);
        super.setChessColor(color);
        super.setName(name);
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
        int row = source.getX();
        int col = source.getY();
        if (Math.abs(destination.getX() - row) == Math.abs(destination.getY() - col)) {
            for (int i = 1; i < Math.abs(destination.getX() - row); i++) {
                int n, m;
                if (destination.getX() > row) {
                    n = 1;
                } else {
                    n = -1;
                }
                if (destination.getY() > col) {
                    m = 1;
                } else {
                    m = -1;
                }
                if (!(chars[row + i * n][col + i * m]=='_')) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

}
