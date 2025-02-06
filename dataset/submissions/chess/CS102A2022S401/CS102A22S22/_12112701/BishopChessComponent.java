import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        ChessComponent[][] game=super.getChessGame();
        int x=this.getSource().getX();
        int y=this.getSource().getY();

        for(int i=1;i<=7;i++) {
            if (new ChessboardPoint(x + i, y + i).Check()) {
                if (game[x + i][y + i].getColor().equals(ChessColor.NONE)) {
                    move.add(new ChessboardPoint(x + i, y + i));
                } else if (!game[x + i][y + i].getColor().equals(this.getColor())) {
                    move.add(new ChessboardPoint(x + i, y + i));
                    break;
                }
                if (game[x + i][y + i].getColor().equals(this.getColor())) {
                    break;
                }
            }
        }
        for(int i=1;i<=7;i++) {
            if (new ChessboardPoint(x - i, y - i).Check()) {
                if (game[x - i][y - i].getColor().equals(ChessColor.NONE)) {
                    move.add(new ChessboardPoint(x - i, y - i));
                } else if (!game[x - i][y - i].getColor().equals(this.getColor())) {
                    move.add(new ChessboardPoint(x - i, y - i));
                    break;
                }
                if (game[x - i][y - i].getColor().equals(this.getColor())) {
                    break;
                }
            }
        }
        for(int i=1;i<=7;i++) {
            if (new ChessboardPoint(x + i, y - i).Check()) {
                if (game[x + i][y - i].getColor().equals(ChessColor.NONE)) {
                    move.add(new ChessboardPoint(x + i, y - i));
                } else if (!game[x + i][y - i].getColor().equals(this.getColor())) {
                    move.add(new ChessboardPoint(x + i, y - i));
                    break;
                }
                if (game[x + i][y - i].getColor().equals(this.getColor())) {
                    break;
                }
            }
        }
        for(int i=1;i<=7;i++) {
            if(new ChessboardPoint(x-i,y+i).Check()){
                if(game[x-i][y+i].getColor().equals(ChessColor.NONE)){
                    move.add(new ChessboardPoint(x-i,y+i));
                }
                else if(!game[x-i][y+i].getColor().equals(this.getColor())){
                    move.add(new ChessboardPoint(x-i,y+i));
                    break;
                }
                if(game[x-i][y+i].getColor().equals(this.getColor())){
                    break;
                }
            }

        }
        return move;
    }
}
