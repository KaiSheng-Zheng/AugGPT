import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent {
    public KingChessComponent(char name,char color,int x,int y, ConcreteChessGame game){
        super(name,color,x,y);
        this.game = game;
    }
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint a=this.getSource();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        ArrayList<ChessboardPoint> possible=new ArrayList<>();
        if(a.offset(-1,-1)!=null){
            if(game.getChess(x-1,y-1).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(-1,-1));
            }
        }
        if(a.offset(-1,0)!=null){
            if(game.getChess(x-1,y).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(-1,0));
            }

        }
        if(a.offset(-1,1)!=null){
            if(game.getChess(x-1,y+1).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(-1,1));
            }

        }
        if(a.offset(0,-1)!=null){
            if(game.getChess(x,y-1).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(0,-1));
            }

        }
        if(a.offset(0,1)!=null){
            if(game.getChess(x,y+1).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(0,1));
            }

        }
        if(a.offset(1,-1)!=null){
            if(game.getChess(x+1,y-1).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(1,-1));
            }

        }
        if(a.offset(1,0)!=null){
            if(game.getChess(x+1,y).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(1,0));
            }

        }
        if(a.offset(1,1)!=null){
            if(game.getChess(x+1,y+1).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(1,1));
            }
        }
        if(possible.size()!=0){
            return possible;
        }else{
            return new ArrayList<>();
        }

    }
}
