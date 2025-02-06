import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent {

    public RookChessComponent() {
    }

    @Override
    public ChessboardPoint getSource() {
        return super.getSource();
    }

    @Override
    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if (chessColor.equals(ChessColor.BLACK)) {
            super.name = 'R';
        } else if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'r';
        } else {
            super.name = '_';
        }
    }
    @Override
    public void setChessColor(ChessColor chessColor) {
        super.setChessColor(chessColor);
        if (chessColor.equals(ChessColor.WHITE)) {
            super.name = 'r';
        } else {
            super.name = 'R';
        }
    }

    @Override
    public ChessColor getChessColor() {
        return super.getChessColor();
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> Points=new ArrayList<>();
        ChessComponent[][] chessboard = getChessComponents();
        int targetX = getSource().getX();
        int targetY = getSource().getY();

        for(int i = targetX - 1; i >= 0; i--){
            if(chessboard[i][targetY].getChessColor() == ChessColor.NONE){
                Points.add(new ChessboardPoint(i,targetY));
            }else{
                if(chessboard[i][targetY].getChessColor() != super.getChessColor()){
                    Points.add(new ChessboardPoint(i,targetY));
                }
                break;
            }
        }

        for(int i = targetX + 1; i < 8; i++){
            if(chessboard[i][targetY].getChessColor() == ChessColor.NONE){
                Points.add(new ChessboardPoint(i,targetY));
            }else{
                if(chessboard[i][targetY].getChessColor() != super.getChessColor()){
                    Points.add(new ChessboardPoint(i,targetY));
                }
                break;
            }
        }

        for(int j = targetY - 1; j >= 0; j--){
            if(chessboard[targetX][j].getChessColor() == ChessColor.NONE){
                Points.add(new ChessboardPoint(targetX,j));
            }else{
                if(chessboard[targetX][j].getChessColor() != super.getChessColor()){
                    Points.add(new ChessboardPoint(targetX,j));
                }
                break;
            }
        }


        for(int j = targetY + 1; j < 8; j++){
            if(chessboard[targetX][j].getChessColor() == ChessColor.NONE){
                Points.add(new ChessboardPoint(targetX,j));
            }else{
                if(chessboard[targetX][j].getChessColor() != super.getChessColor()){
                    Points.add(new ChessboardPoint(targetX,j));
                }
                break;
            }
        }

        return Points;
    }
}
