import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    public BishopChessComponent() {
    }

//    @Override
//    public List<ChessboardPoint> canMoveTo() {
//        return null;
//    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> arrayList=new ArrayList<>();
       ChessColor s= this.getChessComponents()[this.getSource().getX()][this.getSource().getY()].getChessColor();

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
        return arrayList;
    }

}
