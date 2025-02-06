import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessColor chessColor,ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents) {
        super(chessColor,chessComponents);
        this.name=chessColor==ChessColor.BLACK?'Q':'q';
        setSource(chessboardPoint);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> possibleMove=new ArrayList<>();

        int i=getSource().getX()+1,j=getSource().getY();
        while (i>=0&&i<=7&&j>=0&&j<=7){
            if(getChessComponents()[i][j] instanceof EmptySlotComponent){
                possibleMove.add(new ChessboardPoint(i,j));
            }
            else{
                if(getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    possibleMove.add(new ChessboardPoint(i,j));
                }
                break;
            }
            i++;
        }

        i=getSource().getX()-1;j=getSource().getY();
        while (i>=0&&i<=7&&j>=0&&j<=7){
            if(getChessComponents()[i][j] instanceof EmptySlotComponent){
                possibleMove.add(new ChessboardPoint(i,j));
            }
            else{
                if(getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    possibleMove.add(new ChessboardPoint(i,j));
                }
                break;
            }
            i--;
        }

        i=getSource().getX();j=getSource().getY()-1;
        while (i>=0&&i<=7&&j>=0&&j<=7){
            if(getChessComponents()[i][j] instanceof EmptySlotComponent){
                possibleMove.add(new ChessboardPoint(i,j));
            }
            else{
                if(getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    possibleMove.add(new ChessboardPoint(i,j));
                }
                break;
            }
            j--;
        }

        i=getSource().getX();j=getSource().getY()+1;
        while (i>=0&&i<=7&&j>=0&&j<=7){
            if(getChessComponents()[i][j] instanceof EmptySlotComponent){
                possibleMove.add(new ChessboardPoint(i,j));
            }
            else{
                if(getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    possibleMove.add(new ChessboardPoint(i,j));
                }
                break;
            }
            j++;
        }

        i=getSource().getX()+1;j=getSource().getY()+1;
        while (i>=0&&i<=7&&j>=0&&j<=7){
            if(getChessComponents()[i][j] instanceof EmptySlotComponent){
                possibleMove.add(new ChessboardPoint(i,j));
            }
            else{
                if(getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    possibleMove.add(new ChessboardPoint(i,j));
                }
                break;
            }
            i++;j++;
        }

        i=getSource().getX()+1;j=getSource().getY()-1;
        while (i>=0&&i<=7&&j>=0&&j<=7){
            if(getChessComponents()[i][j] instanceof EmptySlotComponent){
                possibleMove.add(new ChessboardPoint(i,j));
            }
            else{
                if(getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    possibleMove.add(new ChessboardPoint(i,j));
                }
                break;
            }
            i++;j--;
        }

        i=getSource().getX()-1;j=getSource().getY()-1;
        while (i>=0&&i<=7&&j>=0&&j<=7){
            if(getChessComponents()[i][j] instanceof EmptySlotComponent){
                possibleMove.add(new ChessboardPoint(i,j));
            }
            else{
                if(getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    possibleMove.add(new ChessboardPoint(i,j));
                }
                break;
            }
            i--;j--;
        }

        i=getSource().getX()-1;j=getSource().getY()+1;
        while (i>=0&&i<=7&&j>=0&&j<=7){
            if(getChessComponents()[i][j] instanceof EmptySlotComponent){
                possibleMove.add(new ChessboardPoint(i,j));
            }
            else{
                if(getChessComponents()[i][j].getChessColor()!=getChessColor()){
                    possibleMove.add(new ChessboardPoint(i,j));
                }
                break;
            }
            i--;j++;
        }

        return possibleMove;
    }
}
