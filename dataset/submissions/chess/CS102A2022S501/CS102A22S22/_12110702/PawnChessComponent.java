import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    int counter=0;
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> kk=new ArrayList<>();
        if (counter==0){
            int x=getSource().getX();
            int y=getSource().getY();
            if (getChessColor()==ChessColor.WHITE){
                if ((chessBoard[x-1][y] instanceof EmptySlotComponent)){
                    kk.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()));
                }
                if ((chessBoard[x-2][y] instanceof EmptySlotComponent)&&(chessBoard[x-1][y] instanceof EmptySlotComponent)) {
                    kk.add(new ChessboardPoint(getSource().getX()-2,getSource().getY()));
                }
                if (y+1<8&&!(chessBoard[x-1][y+1] instanceof EmptySlotComponent)&&chessBoard[x-1][y].getChessColor()!=getChessColor()){ kk.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));}
                if (y-1>=0&&!(chessBoard[x-1][y-1] instanceof EmptySlotComponent)&&chessBoard[x-1][y].getChessColor()!=getChessColor()){ kk.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));}
//                if (x-1>=0&&y+1<8&&!(chessBoard[x-1][y+1] instanceof EmptySlotComponent)&&chessBoard[x-1][y+1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x-1,y+1));}
//                if (x-1>=0&&y-1>=0&&!(chessBoard[x-1][y-1] instanceof EmptySlotComponent)&&chessBoard[x-1][y-1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x-1,y-1));}
           }
            else{
                if (((chessBoard)[x+1][y] instanceof EmptySlotComponent)) {
                    kk.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()));
                }
                if ((chessBoard[x+2][y] instanceof EmptySlotComponent)&&chessBoard[x+1][y] instanceof EmptySlotComponent) {
                    kk.add(new ChessboardPoint(getSource().getX()+2,getSource().getY()));
                }
                if (y+1<8&&!(chessBoard[x+1][y+1] instanceof EmptySlotComponent)&&chessBoard[x+1][y+1].getChessColor()!=getChessColor()){ kk.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));}
                if (y-1>=0&&!(chessBoard[x+1][y-1] instanceof EmptySlotComponent)&&chessBoard[x+1][y-1].getChessColor()!=getChessColor()){ kk.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));}
           //     if (x+1<8&&y+1<8&&!(chessBoard[x+1][y+1] instanceof EmptySlotComponent)&&chessBoard[x+1][y+1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x+1,y+1));}
             //   if (x+1<8&&y-1>=0&&!(chessBoard[x+1][y-1] instanceof EmptySlotComponent)&&chessBoard[x+1][y-1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x+1,y-1));}
            }
            return kk;
        }
        else{
            int x=getSource().getX();
            int y=getSource().getY();
            if (getChessColor()==ChessColor.WHITE){
                if (x-1>=0&&y+1<8&&!(chessBoard[x-1][y+1] instanceof EmptySlotComponent)&&chessBoard[x-1][y+1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x-1,y+1));}
                if (x-1>=0&&y-1>=0&&!(chessBoard[x-1][y-1] instanceof EmptySlotComponent)&&chessBoard[x-1][y-1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x-1,y-1));}
                if (x-1>=0&&!(chessBoard[x-1][y] instanceof EmptySlotComponent)){
                     return kk;}
                else {kk.add(new ChessboardPoint(x-1,y));return kk;}
            }
            else {
                if (x+1<8&&y+1<8&&!(chessBoard[x+1][y+1] instanceof EmptySlotComponent)&&chessBoard[x+1][y+1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x+1,y+1));}
                if (x+1<8&&y-1>=0&&!(chessBoard[x+1][y-1] instanceof EmptySlotComponent)&&chessBoard[x+1][y-1].getChessColor()!=getChessColor()){kk.add(new ChessboardPoint(x+1,y-1));}
                if (x+1<8&&!(chessBoard[x+1][y] instanceof EmptySlotComponent)){return kk;}
            else {kk.add(new ChessboardPoint(x+1,y));return kk;}}
        }

    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessBoard){
        setSource(source);
        setChessColor(chessColor);
        this.name = name;
        this.chessBoard = chessBoard;
    }
    public void addcounter(){
        counter++;
    }

}
