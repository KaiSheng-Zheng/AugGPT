import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(char name,char color,int x,int y,ConcreteChessGame game){
        super(name,color,x,y);
        this.game = game;

    }
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint a=this.getSource();
        ArrayList<ChessboardPoint> possible=new ArrayList<>();
        int x=this.getSource().getX();
        int y=this.getSource().getY();

        if(this.getChessColor()==ChessColor.BLACK){
            if(x==1){
                if(a.offset(1,0)!=null){
                    if(game.getChess(x+1,y).getChessColor()==ChessColor.NONE){
                        possible.add(a.offset(1,0));
                    }
                }
                if(a.offset(1,1)!=null){
                    if(game.getChess(x+1,y+1).getChessColor()==ChessColor.WHITE){
                        possible.add(a.offset(1,1));
                    }
                }
                if(a.offset(1,-1)!=null){
                    if(game.getChess(x+1,y-1).getChessColor()==ChessColor.WHITE){
                        possible.add(a.offset(1,-1));
                    }
                }
                if(a.offset(2,0)!=null){
                    if(game.getChess(x+2,y).getChessColor()==ChessColor.NONE){
                        possible.add(a.offset(2,0));
                    }
                }
            }else {
                if(a.offset(1,0)!=null){
                    if(game.getChess(x+1,y).getChessColor()==ChessColor.NONE){
                        possible.add(a.offset(1,0));
                    }
                }
                if(a.offset(1,1)!=null){
                    if(game.getChess(x+1,y+1).getChessColor()==ChessColor.WHITE){
                        possible.add(a.offset(1,1));
                    }
                }
                if(a.offset(1,-1)!=null){
                    if(game.getChess(x+1,y-1).getChessColor()==ChessColor.WHITE){
                        possible.add(a.offset(1,-1));
                    }
                }
            }


        }
        if(this.getChessColor()==ChessColor.WHITE) {
            if (x == 6) {
                if (a.offset(-1, 0) != null) {
                    if (game.getChess(x - 1, y).getChessColor() == ChessColor.NONE) {
                        possible.add(a.offset(-1, 0));
                    }
                }
                if (a.offset(-1, -1) != null) {
                    if (game.getChess(x - 1, y - 1).getChessColor() == ChessColor.BLACK) {
                        possible.add(a.offset(-1, -1));
                    }
                }
                if (a.offset(-1, 1) != null) {
                    if (game.getChess(x - 1, y + 1).getChessColor() == ChessColor.BLACK) {
                        possible.add(a.offset(-1, 1));
                    }
                }
                if (a.offset(-2, 0) != null) {
                    if (game.getChess(x - 2, y).getChessColor() == ChessColor.NONE) {
                        possible.add(a.offset(-2, 0));
                    }
                }
            } else {
                if (a.offset(-1, 0) != null) {
                    if (game.getChess(x - 1, y).getChessColor() == ChessColor.NONE) {
                        possible.add(a.offset(-1, 0));
                    }
                }
                if (a.offset(-1, -1) != null) {
                    if (game.getChess(x - 1, y - 1).getChessColor() == ChessColor.BLACK) {
                        possible.add(a.offset(-1, -1));
                    }
                }
                if (a.offset(-1, 1) != null) {
                    if (game.getChess(x -1, y + 1).getChessColor() == ChessColor.BLACK) {
                        possible.add(a.offset(-1, 1));
                    }
                }
            }
        }

        if(possible.size()!=0){

            return possible;
        }else{

            return new ArrayList<>();
        }
    }
}
