import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(char name,char color,int x,int y,ConcreteChessGame game){
        super(name,color,x,y);
        this.game = game;

    }
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint a=this.getSource();
        ArrayList<ChessboardPoint> possible=new ArrayList<>();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        if(a.offset(-2,-1)!=null){
            if(game.getChess(x-2,y-1).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(-2,-1));
            }
        }
        if(a.offset(-2,1)!=null){
            if(game.getChess(x-2,y+1).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(-2,1));
            }
        }
        if(a.offset(2,-1)!=null){
            if(game.getChess(x+2,y-1).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(2,-1));
            }
        }
        if(a.offset(2,1)!=null){
            if(game.getChess(x+2,y+1).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(2,1));
            }
        }
        if(a.offset(-1,-2)!=null){
            if(game.getChess(x-1,y-2).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(-1,-2));
            }
        }
        if(a.offset(1,-2)!=null){
            if(game.getChess(x+1,y-2).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(1,-2));
            }
        }
        if(a.offset(-1,2)!=null){
            if(game.getChess(x-1,y+2).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(-1,2));
            }
        }
        if(a.offset(1,2)!=null){
            if(game.getChess(x+1,y+2).getChessColor()!=this.getChessColor()){
                possible.add(a.offset(1,2));
            }
        }
        if(possible.size()!=0){
            return possible;
        }else{
            return new ArrayList<>();
        }
    }
}
