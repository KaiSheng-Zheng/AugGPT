import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(char name,char color,int x,int y,ConcreteChessGame game){
        super(name,color,x,y);
        this.game = game;
        ChessComponent[][] chessComponents=game.getChessComponents();
    }
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint a=this.getSource();
        ArrayList<ChessboardPoint> possible=new ArrayList<>();
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        boolean flag=false;
        for(int i=1;i<=7;i++){

            if(flag){
                flag=false;
                break;
            }
            if(a.offset(i,i)!=null){
                if(game.getChess(x+i,y+i).getChessColor()!=this.getChessColor()){
                    if(game.getChess(x+i,y+i).getChessColor()!=ChessColor.NONE){
                        flag=true;
                    }
                    possible.add(a.offset(i,i));
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        for(int i=-1;i>=-7;i--){

            if(flag){
                flag=false;
                break;
            }
            if(a.offset(i,i)!=null){
                if(game.getChess(x+i,y+i).getChessColor()!=this.getChessColor()){
                    if(game.getChess(x+i,y+i).getChessColor()!=ChessColor.NONE){
                        flag=true;
                    }
                    possible.add(a.offset(i,i));
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        for(int i=1;i<=7;i++){

            if(flag){
                flag=false;
                break;
            }
            if(a.offset(i,-i)!=null){
                if(game.getChess(x+i,y-i).getChessColor()!=this.getChessColor()){
                    if(game.getChess(x+i,y-i).getChessColor()!=ChessColor.NONE){
                        flag=true;
                    }
                    possible.add(a.offset(i,-i));
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        for(int i=-1;i>=-7;i--){

            if(flag){
                flag=false;
                break;
            }
            if(a.offset(i,-i)!=null){
                if(game.getChess(x+i,y-i).getChessColor()!=this.getChessColor()){
                    if(game.getChess(x+i,y-i).getChessColor()!=ChessColor.NONE){
                        flag=true;
                    }
                    possible.add(a.offset(i,-i));
                }else{
                    break;
                }
            }else{
                break;
            }
        }
        if(possible.size()!=0){

            return possible;
        }else{
            return new ArrayList<>();
        }

    }
}
