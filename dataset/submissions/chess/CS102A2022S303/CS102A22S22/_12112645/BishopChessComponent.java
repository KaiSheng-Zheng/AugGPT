import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessColor color,Character name,ChessboardPoint source){
        super(color,name,source);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMove=new ArrayList<>();
        //I need write four direction
        int j=getSource().getY()+1;
        for (int i = getSource().getX()+1; i <8 ; i++) {
//            int j=getSource().getY()+1;wrong!!!
            if (j>7){break;}
            if(chessboard[i][j]instanceof EmptySlotComponent){
                canMove.add(new ChessboardPoint(i,j));
                j++;continue;}
            else if(chessboard[i][j].getChessColor()!=getChessColor()){
                canMove.add(new ChessboardPoint(i,j));break;
            }else {break;}
        }
        int k=getSource().getY()+1;
        for (int i = getSource().getX()-1; i >=0 ; i--) {
            if (k>7){break;}
            if(chessboard[i][k]instanceof EmptySlotComponent){
                canMove.add(new ChessboardPoint(i,k));
                k++;continue;}
            else if(chessboard[i][k].getChessColor()!=getChessColor()){
                canMove.add(new ChessboardPoint(i,k));break;
            }else {break;}
        }

        int h=getSource().getY()-1;
        for (int i = getSource().getX()+1; i <8 ; i++) {

            if (h<0){break;}
            if(chessboard[i][h]instanceof EmptySlotComponent){canMove.add(new ChessboardPoint(i,h));
                h--;continue;}
            else if(chessboard[i][h].getChessColor()!=getChessColor()){
                canMove.add(new ChessboardPoint(i,h));break;
            }else {break;}
        }

        int l=getSource().getY()-1;
        for (int i = getSource().getX()-1; i >=0 ; i--) {

            if (l<0){break;}
            if(chessboard[i][l]instanceof EmptySlotComponent){canMove.add(new ChessboardPoint(i,l));
                l--;continue;}
            else if(chessboard[i][l].getChessColor()!=getChessColor()){
                canMove.add(new ChessboardPoint(i,l));break;
            }else {break;}
        }



        return canMove;
    }




}
