import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private final ChessComponent[][] chessComponents;

    public RookChessComponent(ChessboardPoint source,ChessColor chessColor,char name,ChessComponent[][] components) {
        this.source = source;
        this.chessColor=chessColor;
        this.name=name;
        this.chessComponents=components;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public List<ChessboardPoint> canMoveTo(){
        ArrayList<ChessboardPoint> cbp=new ArrayList<>();
                int d1=7- source.getY();
        int d2=7- source.getX();
        if(d1>0){
            for(int i=1;i<=d1;i++){
                if(chessComponents[source.getX()][source.getY()+i].getName()=='_')
                    cbp.add(source.offset(0,i));
                else
                if(chessComponents[source.getX()][source.getY()+i].getChessColor()==this.chessColor)
                    break;
                else{
                    cbp.add(source.offset(0,i));
                    break;
                }

            }
            for(int i=1;i<= source.getY();i++){
                if(chessComponents[source.getX()][source.getY()-i].getName()=='_')
                    cbp.add(source.offset(0,-i));
                else
                if(chessComponents[source.getX()][source.getY()-i].getChessColor()==this.chessColor)
                    break;
                else{
                    cbp.add(source.offset(0,-i));
                    break;
                }
            }
        }
        else if(d1==0){
            for(int i=1;i<= source.getY();i++){
                if(chessComponents[source.getX()][source.getY()-i].getName()=='_')
                    cbp.add(source.offset(0,-i));
                else
                if(chessComponents[source.getX()][source.getY()-i].getChessColor()==this.chessColor)
                    break;
                else{
                    cbp.add(source.offset(0,-i));
                    break;
                }
            }
        }

        if(d2>0){
            for(int i=1;i<=d2;i++){
                if(chessComponents[source.getX()+i][source.getY()].getName()=='_')
                    cbp.add(source.offset(i,0));
                else
                if(chessComponents[source.getX()+i][source.getY()].getChessColor()==this.chessColor)
                    break;
                else{
                    cbp.add(source.offset(i,0));
                    break;
                }
            }
            for(int i=1;i<= source.getX();i++){
                if(chessComponents[source.getX()-i][source.getY()].getName()=='_')
                    cbp.add(source.offset(-i,0));
                else
                if(chessComponents[source.getX()-i][source.getY()].getChessColor()==this.chessColor)
                    break;
                else{
                    cbp.add(source.offset(-i,0));
                    break;
                }
            }
        }
        else if(d2==0){
            for(int i=1;i<= source.getX();i++){
                if(chessComponents[source.getX()-i][source.getY()].getName()=='_')
                    cbp.add(source.offset(-i,0));
                else
                if(chessComponents[source.getX()-i][source.getY()].getChessColor()==this.chessColor)
                    break;
                else{
                    cbp.add(source.offset(-i,0));
                    break;
                }
            }
        }
        return cbp;
    }

    public char getName() {
        return name;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setName(){
        if(chessColor.equals(ChessColor.BLACK))
            this.name='R';
        else if(chessColor.equals(ChessColor.WHITE))
            this.name='r';
        else
            this.name='_';
    }

}