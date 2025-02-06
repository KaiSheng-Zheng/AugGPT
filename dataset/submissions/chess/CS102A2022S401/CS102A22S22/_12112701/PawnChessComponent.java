import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        ChessComponent[][] game=super.getChessGame();
        int x=this.getSource().getX();
        int y=this.getSource().getY();

        if(this.getColor().equals(ChessColor.WHITE)){
            if(x==6){
                if(game[x-1][y].getColor().equals(ChessColor.NONE)){
                    move.add(new ChessboardPoint(x-1,y));
                }
                if(game[x-2][y].getColor().equals(ChessColor.NONE)){
                    move.add(new ChessboardPoint(x-2,y));
                }
            }
            if(x!=6){
                if(new ChessboardPoint(x-1,y).Check()){
                    if(game[x-1][y].getColor().equals(ChessColor.NONE)){
                        move.add(new ChessboardPoint(x-1,y));
                    }
                }
            }
            if(new ChessboardPoint(x-1,y-1).Check()){
                if(game[x-1][y-1].getColor().equals(ChessColor.BLACK)){
                    move.add(new ChessboardPoint(x-1,y-1));
                }
            }
            if(new ChessboardPoint(x-1,y+1).Check()){
                if(game[x-1][y+1].getColor().equals(ChessColor.BLACK)){
                    move.add(new ChessboardPoint(x-1,y+1));
                }
            }
        }

        if(this.getColor().equals(ChessColor.BLACK)){
            if(x==1){
                if(game[x+1][y].getColor().equals(ChessColor.NONE)){
                    move.add(new ChessboardPoint(x+1,y));
                }
                if(game[x+2][y].getColor().equals(ChessColor.NONE)){
                    move.add(new ChessboardPoint(x+2,y));
                }
            }
            if(x!=1){
                if(new ChessboardPoint(x+1,y).Check()){
                    if(game[x+1][y].getColor().equals(ChessColor.NONE)){
                        move.add(new ChessboardPoint(x+1,y));
                    }
                }
            }
            if(new ChessboardPoint(x+1,y-1).Check()){
                if(game[x+1][y-1].getColor().equals(ChessColor.WHITE)){
                    move.add(new ChessboardPoint(x+1,y-1));
                }
            }
            if(new ChessboardPoint(x+1,y+1).Check()){
                if(game[x+1][y+1].getColor().equals(ChessColor.WHITE)){
                    move.add(new ChessboardPoint(x+1,y+1));
                }
            }
        }
        return move;
    }
}
