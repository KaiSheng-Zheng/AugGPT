import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor color,char name) {
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
    public boolean canMoveTo( ChessboardPoint destination) {
        ChessboardPoint source = getSource();char[][] chars= getChessBoard();
        if (source.getY() == destination.getY()) {
            if ( getChessColor() == ChessColor.BLACK) {
                if (destination.getX()-source.getX()==2){
                    return source.getX() == 1 && (chars[source.getX() + 1][source.getY()] == '_') && (chars[source.getX() + 2][source.getY()] == '_');
                }else if (destination.getX()-source.getX()==1){
                    return chars[source.getX() + 1][source.getY()] == '_';
                }
            } else if (getChessColor()==ChessColor.WHITE) {
                if (source.getX()-destination.getX()==2){
                    return source.getX() == 6 && (chars[source.getX() - 1][source.getY()] == '_') && (chars[source.getX() - 2][source.getY()] == '_');
                }else if (source.getX()-destination.getX()==1){
                    return chars[source.getX() - 1][source.getY()] == '_';
                }
            }
        }else if (Math.abs(source.getY()-destination.getY()) ==1){
            if (getChessColor()==ChessColor.BLACK) {
                if (destination.getX()-source.getX()==1){
                    return !(chars[destination.getX()][destination.getY()] == '_');
                }
            }
            else if (getChessColor()==ChessColor.WHITE) {
                if (source.getX()-destination.getX()==1){
                    return !(chars[destination.getX()][destination.getY()] == '_');
                }
            }
        }return false;
    }

}
