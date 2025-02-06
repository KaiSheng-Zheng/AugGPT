import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    private char name;
    private ChessComponent[][] chessComponents;
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public RookChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
        int m=this.getSource().getX(),n=this.getSource().getY();
        ChessColor s=this.getChessComponents()[m][n].getChessColor();
        for(int i=m+1,j=n;i<8;i++)
        {
            ChessboardPoint sb= new ChessboardPoint(i, j);
            ChessColor c=this.getChessComponents()[i][j].getChessColor();
            if(c==ChessColor.NONE){
                arrayList.add(sb);
            }
            else {
                if(c!= s) {
                    arrayList.add(sb); break;
                }
                else    break;}
        }
        for(int i=m-1,j=n;i>-1;i--)
        {
            ChessboardPoint sb= new ChessboardPoint(i, j);
            ChessColor c=this.getChessComponents()[i][j].getChessColor();
            if(c==ChessColor.NONE){
                arrayList.add(sb);
            }
            else {
                if(c!= s) {
                    arrayList.add(sb); break;
                }
                else    break;}
        }
        for(int i=m,j=n+1;j<8;j++)
        {
            ChessboardPoint sb= new ChessboardPoint(i, j);
            ChessColor c=this.getChessComponents()[i][j].getChessColor();
            if(c==ChessColor.NONE){
                arrayList.add(sb);
            }
            else {
                if(c!= s) {
                    arrayList.add(sb); break;
                }
                else    break;}
        }
        for(int i=m,j=n-1;j>-1;j--)
        {
            ChessboardPoint sb= new ChessboardPoint(i, j);
            ChessColor c=this.getChessComponents()[i][j].getChessColor();
            if(c==ChessColor.NONE){
                arrayList.add(sb);
            }
            else {
                if(c!= s) {
                    arrayList.add(sb); break;
                }
                else    break;}
        }

        return arrayList;
    }
}
