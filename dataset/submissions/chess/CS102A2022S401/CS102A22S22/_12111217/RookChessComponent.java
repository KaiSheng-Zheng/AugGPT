import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    public RookChessComponent(int x,int y,ChessColor chessColor,ConcreteChessGame concreteChessGame){
        this.concreteChessGame=concreteChessGame;
        setSource(new ChessboardPoint(x,y));
        setChessColor(chessColor);
        if (chessColor==ChessColor.BLACK){
            name='R';
        }
        if (chessColor==ChessColor.WHITE){
            name='r';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> result=new ArrayList<>();
        boolean a=true;
        boolean b=true;
        boolean c=true;
        boolean d=true;
        ChessboardPoint w=getSource();
        for (int i=1;i<8;i++){
            if (a){
                if (w.offset(i,0)!=null
                        &&concreteChessGame.getChess(w.offset(i,0)).getChessColor()!=this.getChessColor()
                        &&(concreteChessGame.getChess(w.offset(i-1,0)).getChessColor()==ChessColor.NONE
                        ||concreteChessGame.getChess(w.offset(i-1,0)).getChessColor()==this.getChessColor())){
                    result.add(w.offset(i,0));
                }
                else {
                    a=false;
                }
            }
            if (b){
                if (w.offset(0,-i)!=null
                        &&concreteChessGame.getChess(w.offset(0,-i)).getChessColor()!=this.getChessColor()
                        &&(concreteChessGame.getChess(w.offset(0,-i+1)).getChessColor()==ChessColor.NONE
                        ||concreteChessGame.getChess(w.offset(0,-i+1)).getChessColor()==this.getChessColor())){
                    result.add(w.offset(0,-i));
                }
                else {
                    b=false;
                }
            }
            if (c){
                if (w.offset(0,i)!=null
                        &&concreteChessGame.getChess(w.offset(0,i)).getChessColor()!=this.getChessColor()
                        &&(concreteChessGame.getChess(w.offset(0,i-1)).getChessColor()==ChessColor.NONE
                        ||concreteChessGame.getChess(w.offset(0,i-1)).getChessColor()==this.getChessColor())){
                    result.add(w.offset(0,i));
                }
                else {
                    c=false;
                }
            }
            if (d){
                if (w.offset(-i,0)!=null
                        &&concreteChessGame.getChess(w.offset(-i,0)).getChessColor()!=this.getChessColor()
                        &&(concreteChessGame.getChess(w.offset(-i+1,0)).getChessColor()==ChessColor.NONE
                        ||concreteChessGame.getChess(w.offset(-i+1,0)).getChessColor()==this.getChessColor())){
                    result.add(w.offset(-i,0));
                }
                else {
                    d=false;
                }
            }
        }
        return result;
    }
}
