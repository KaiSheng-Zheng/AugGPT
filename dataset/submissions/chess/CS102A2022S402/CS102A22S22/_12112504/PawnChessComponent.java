import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    public PawnChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        super(source,chessColor,name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canPoint = new ArrayList<>();
        for(int i = 0 ; i < 8 ; i ++){
            for(int t = 0 ; t < 8 ; t++) {
                ChessboardPoint destination = new ChessboardPoint(i, t);
                ChessboardPoint source = getChessboardPoint();
                ChessColor color = getChessColor();
                if(chessComponents[destination.getX()][destination.getY()].getChessColor()==getChessColor()){
                    continue;
                }
                if(color==ChessColor.WHITE){
                    if(source.getY()!=destination.getY()){
                        {
                            if((source.getY()+1==destination.getY())&&(source.getX()-1==destination.getX())){
                                if ((chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                            }
                            else if((source.getY()-1==destination.getY())&&(source.getX()-1==destination.getX())){
                                if ((chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                            }
                            else {
                                continue;//
                            }
                        }

                    }
                    else{
                        if(source.getX()==6){
                            int col = source.getY();
                            if(destination.getX()==5){
                                if (!(chessComponents[5][col] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                            }
                            else if(destination.getX()==4){
                                if (!(chessComponents[5][col] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                                else if (!(chessComponents[4][col] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                            }
                            else{
                                continue;//
                            }
                        }
                        else{
                            int col = source.getY();
                            if(destination.getX()==source.getX()-1){
                                if (!(chessComponents[source.getX()-1][col] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                            }
                            else{
                                continue;//
                            }
                        }
                    }
                }
                else if(color==ChessColor.BLACK){
                    if(source.getY()!=destination.getY()){

                        {
                            if((source.getY()+1==destination.getY())&&(source.getX()+1==destination.getX())){
                                if ((chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                            }
                            else if((source.getY()-1==destination.getY())&&(source.getX()+1==destination.getX())){
                                if ((chessComponents[destination.getX()][destination.getY()] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                            }
                            else {
                                continue;//
                            }
                        }

                    }
                    else{
                        if(source.getX()==1){
                            int col = source.getY();
                            if(destination.getX()==2){
                                if (!(chessComponents[2][col] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                            }
                            else if(destination.getX()==3){
                                if (!(chessComponents[2][col] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                                else if (!(chessComponents[3][col] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                            }
                            else{
                                continue;//
                            }
                        }
                        else{
                            int col = source.getY();
                            if(destination.getX()==source.getX()+1){
                                if (!(chessComponents[source.getX()+1][col] instanceof EmptySlotComponent)) {
                                    continue;//
                                }
                            }
                            else{
                                continue;//
                            }
                        }
                    }
                    //

                }
                else { // Not on the same row or the same column.
                    continue;//
                }
                canPoint.add(destination);
            }
        }
        return canPoint;
    }
}