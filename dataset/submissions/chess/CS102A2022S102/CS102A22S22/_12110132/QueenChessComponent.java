import java.util.ArrayList;
import java.util.List;


public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(char name,char color,int x,int y,ConcreteChessGame game){
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

            if(a.offset(i,0)!=null){
                if(flag){
                    flag=false;
                    break;
                }
                if(game.getChess(x+i,y).getChessColor()!=this.getChessColor()){
                    if(game.getChess(x+i,y).getChessColor()!=ChessColor.NONE){
                        flag=true;
                    }
                    possible.add(a.offset(i,0));
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
            if(a.offset(i,0)!=null){
                if(game.getChess(x+i,y).getChessColor()!=this.getChessColor()){
                    if(game.getChess(x+i,y).getChessColor()!=ChessColor.NONE){
                        flag=true;
                    }
                    possible.add(a.offset(i,0));
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
            if(a.offset(0,i)!=null){
                if(game.getChess(x,y+i).getChessColor()!=this.getChessColor()){
                    if(game.getChess(x,y+i).getChessColor()!=ChessColor.NONE){
                        flag=true;
                    }
                    possible.add(a.offset(0,i));
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
            if(a.offset(0,i)!=null){
                if(game.getChess(x,y+i).getChessColor()!=this.getChessColor()){
                    if(game.getChess(x,y+i).getChessColor()!=ChessColor.NONE){
                        flag=true;
                    }
                    possible.add(a.offset(0,i));
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
