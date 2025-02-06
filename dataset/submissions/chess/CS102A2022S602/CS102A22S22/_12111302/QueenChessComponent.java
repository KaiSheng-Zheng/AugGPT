import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public QueenChessComponent() {
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
        int m=this.getSource().getX(),n=this.getSource().getY();
        ChessColor s=this.getChessComponents()[m][n].getChessColor();
        for(int i= this.getSource().getX()+1,j=this.getSource().getY()+1;i<8&&j<8;i++,j++)
        {
            ChessColor c=this.getChessComponents()[i][j].getChessColor();
            ChessboardPoint sb= new ChessboardPoint(i, j);
            if(c==ChessColor.NONE){
                arrayList.add(sb);
            }
            else {
                if(c!= s) {
                    arrayList.add(sb); break;
                }
                else    break;}

        }
        for(int i= this.getSource().getX()-1,j=this.getSource().getY()-1;i>-1&&j>-1;i--,j--)
        {
            ChessColor c=this.getChessComponents()[i][j].getChessColor();
            ChessboardPoint sb= new ChessboardPoint(i, j);
            if(c==ChessColor.NONE){
                arrayList.add(sb);
            }
            else {
                if(c!= s) {
                    arrayList.add(sb); break;
                }
                else    break;}
        }
        for(int i= this.getSource().getX()-1,j=this.getSource().getY()+1;i>-1&&j<8;i--,j++)
        {
            ChessColor c=this.getChessComponents()[i][j].getChessColor();
            ChessboardPoint sb= new ChessboardPoint(i, j);
            if(c==ChessColor.NONE){
                arrayList.add(sb);
            }
            else {
                if(c!= s) {
                    arrayList.add(sb); break;
                }
                else    break;}
        }
        for(int i= this.getSource().getX()+1,j=this.getSource().getY()-1;i<8&&j>-1;i++,j--)
        {
            ChessColor c=this.getChessComponents()[i][j].getChessColor();
            ChessboardPoint sb= new ChessboardPoint(i, j);
            if(c==ChessColor.NONE){
                arrayList.add(sb);
            }
            else {
                if(c!= s) {
                    arrayList.add(sb); break;
                }
                else    break;}
        }
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
