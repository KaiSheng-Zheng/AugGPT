import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        ChessComponent[][] game=super.getChessGame();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        if(new ChessboardPoint(x-1,y-1).Check()){
            if(!game[x-1][y-1].getColor().equals(this.getColor())){
                move.add(new ChessboardPoint(x-1,y-1));
            }
        }
        if(new ChessboardPoint(x,y-1).Check()){
            if(!game[x][y-1].getColor().equals(this.getColor())){
                move.add(new ChessboardPoint(x,y-1));
            }
        }
        if(new ChessboardPoint(x+1,y-1).Check()){
            if(!game[x+1][y-1].getColor().equals(this.getColor())){
                move.add(new ChessboardPoint(x+1,y-1));
            }
        }
        if(new ChessboardPoint(x-1,y).Check()){
            if(!game[x-1][y].getColor().equals(this.getColor())){
                move.add(new ChessboardPoint(x-1,y));
            }
        }
        if(new ChessboardPoint(x+1,y).Check()){
            if(!game[x+1][y].getColor().equals(this.getColor())){
                move.add(new ChessboardPoint(x+1,y));
            }
        }
        if(new ChessboardPoint(x-1,y+1).Check()){
            if(!game[x-1][y+1].getColor().equals(this.getColor())){
                move.add(new ChessboardPoint(x-1,y+1));
            }
        }
        if(new ChessboardPoint(x,y+1).Check()){
            if(!game[x][y+1].getColor().equals(this.getColor())){
                move.add(new ChessboardPoint(x,y+1));
            }
        }
        if(new ChessboardPoint(x+1,y+1).Check()){
            if(!game[x+1][y+1].getColor().equals(this.getColor())){
                move.add(new ChessboardPoint(x+1,y+1));
            }
        }

        return move;

    }
}
