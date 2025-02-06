import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(char name,ChessColor chessColor,ChessboardPoint chessboardPoint) {
        this.setName(name);
        this.setChessColor(chessColor);
        this.setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> List = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            if (getChessComponents()[this.getSource().getX()][i].getChessColor()!=this.getChessColor()) {
                int box=0;
                for (int j = Math.min(this.getSource().getY(), i) + 1; j < Math.max(this.getSource().getY(), i); j++) {
                    if (getChessComponents()[this.getSource().getX()][j].getChessColor()!=ChessColor.NONE){
                        box++;
                    }
                }
                if (box==0){
                    List.add(new ChessboardPoint(this.getSource().getX(),i));
                }
            }
        }
        for (int i = 0; i < 8; i++) {
            if (getChessComponents()[i][this.getSource().getY()].getChessColor()!=this.getChessColor()) {
                int box=0;
                for (int j = Math.min(i,this.getSource().getX()) + 1; j < Math.max(i,this.getSource().getX()); j++) {
                    if (getChessComponents()[j][this.getSource().getY()].getChessColor()!=ChessColor.NONE){
                        box++;
                    }
                }
                if (box==0){
                    List.add(new ChessboardPoint(i,this.getSource().getY()));
                }
            }
        }
        return List;
    }


}
