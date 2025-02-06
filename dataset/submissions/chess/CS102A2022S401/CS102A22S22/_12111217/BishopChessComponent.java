import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(int x,int y,ChessColor chessColor,ConcreteChessGame concreteChessGame){
        this.concreteChessGame=concreteChessGame;
        setSource(new ChessboardPoint(x,y));
        setChessColor(chessColor);
        if (chessColor==ChessColor.BLACK){
            name='B';
        }
        if (chessColor==ChessColor.WHITE){
            name='b';
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
                if (w.offset(i,i)!=null
                &&concreteChessGame.getChess(w.offset(i,i)).getChessColor()!=this.getChessColor()
                &&(concreteChessGame.getChess(w.offset(i-1,i-1)).getChessColor()==ChessColor.NONE
                   ||concreteChessGame.getChess(w.offset(i-1,i-1)).getChessColor()==this.getChessColor())){
                    result.add(w.offset(i,i));
                }
                else {
                    a=false;
                }
            }
            if (b){
                if (w.offset(i,-i)!=null
                        &&concreteChessGame.getChess(w.offset(i,-i)).getChessColor()!=this.getChessColor()
                        &&(concreteChessGame.getChess(w.offset(i-1,-i+1)).getChessColor()==ChessColor.NONE
                        ||concreteChessGame.getChess(w.offset(i-1,-i+1)).getChessColor()==this.getChessColor())){
                    result.add(w.offset(i,-i));
                }
                else {
                    b=false;
                }
            }
            if (c){
                if (w.offset(-i,i)!=null
                        &&concreteChessGame.getChess(w.offset(-i,i)).getChessColor()!=this.getChessColor()
                        &&(concreteChessGame.getChess(w.offset(-i+1,i-1)).getChessColor()==ChessColor.NONE
                        ||concreteChessGame.getChess(w.offset(-i+1,i-1)).getChessColor()==this.getChessColor())){
                    result.add(w.offset(-i,i));
                }
                else {
                    c=false;
                }
            }
            if (d){
                if (w.offset(-i,-i)!=null
                        &&concreteChessGame.getChess(w.offset(-i,-i)).getChessColor()!=this.getChessColor()
                        &&(concreteChessGame.getChess(w.offset(-i+1,-i+1)).getChessColor()==ChessColor.NONE
                        ||concreteChessGame.getChess(w.offset(-i+1,-i+1)).getChessColor()==this.getChessColor())){
                    result.add(w.offset(-i,-i));
                }
                else {
                    d=false;
                }
            }
        }
        return result;
    }
}
