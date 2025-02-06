import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    ChessComponent[][] chessComponents;


    public PawnChessComponent(ChessComponent[][] chessComponents,int i,int j) {
        this.chessComponents = chessComponents;
        setSource(new ChessboardPoint(i,j));
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> pointslist = new ArrayList<>();

        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(canmoveto(chessComponents,new ChessboardPoint(i,j))){
                    pointslist.add(new ChessboardPoint(i,j));
                }
            }
        }
        return pointslist;
    }

    public boolean canmoveto(ChessComponent[][] chessboard, ChessboardPoint destination) {
        ChessboardPoint source = getSource();
        if(getChessColor()==ChessColor.WHITE) {
            if (source.getX() == 6) {
                if(source.getY()==destination.getY() && -destination.getX()+source.getX()<3 && -destination.getX()+source.getX()>0 && chessboard[destination.getX()][destination.getY()].getChessColor()!=ChessColor.WHITE){
                    return true;
                }else if(source.getX()-destination.getX()==1 && Math.abs(source.getY()-destination.getY())==1 && chessboard[destination.getX()][destination.getY()].getChessColor()!=ChessColor.WHITE){
                    return true;
                }else return false;
            }else if(source.getX()-destination.getX()==1 && Math.abs(destination.getY()-source.getY())==1 && chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.BLACK){
                return true;
            }else if(destination.getY()==source.getY() && source.getX()-destination.getX()==1 && chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.NONE){
                return true;
            }else return false;
        }else if(getChessColor()==ChessColor.BLACK) {
            if (source.getX() == 1) {
                if(source.getY()==destination.getY() && destination.getX()-source.getX()<3 && destination.getX()-source.getX()>0 && chessboard[destination.getX()][destination.getY()].getChessColor()!=ChessColor.BLACK){
                    return true;
                }else if(-source.getX()+destination.getX()==1 && Math.abs(source.getY()-destination.getY())==1 && chessboard[destination.getX()][destination.getY()].getChessColor()!=ChessColor.BLACK){
                    return true;
                }else return false;
            }else if(-source.getX()+destination.getX()==1 && Math.abs(destination.getY()-source.getY())==1 && chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.WHITE){
                return true;
            }else if(destination.getY()==source.getY() && -source.getX()+destination.getX()==1 && chessComponents[destination.getX()][destination.getY()].getChessColor()==ChessColor.NONE){
                return true;
            }else return false;
        }

//            if (destination.getY()==source.getY() &&destination.getX()-source.getX()==1 &&(chessboard[destination.getX()][destination.getY()] instanceof EmptySlotComponent)){
//                return true;
//            }else if (destination.getY()==source.getY() &&destination.getX()==3 &&source.getX()==1){
//                for (int x=2;x<=destination.getX();x++){
//                    if (!(chessboard[x][source.getY()] instanceof EmptySlotComponent)) {
//                        return false;
//                    }
//                }
//                return true;
//            }else if (Math.abs(destination.getY()-source.getY())==1 && destination.getX()-source.getX()==1 &&!(chessboard[destination.getX()][destination.getY()] instanceof EmptySlotComponent)){
//                return true;
//            }else if (source.getX()==4 && destination.getX()==4 &&Math.abs(destination.getY()-source.getY())==1
//                    && !(chessboard[4][destination.getY()] instanceof EmptySlotComponent)){
//                return true;
//            } else {return false;}
        return false;
        }
}
