import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if(chessColor==ChessColor.WHITE){
            this.name='n';
        }else{
            this.name='N';
        }
    }

    public KnightChessComponent(ChessColor chessColor) {
        super(chessColor);
        if(chessColor==ChessColor.WHITE){
            this.name='n';
        }else{
            this.name='N';
        }
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {

        ChessColor chessColor = getChessColor();
        ChessComponent[][] chessComponents = getChessComponents();
        ChessboardPoint source = getSource();
        ArrayList<ChessboardPoint> legalpoints = new ArrayList<>();
        ChessboardPoint legalpoint = new ChessboardPoint(0,0);

        int row = source.getX();
        int col = source.getY();

        
        if(col-2>=0){
            
            if(row-1>=0){
                legalpoint = new ChessboardPoint(row-1, col-2);
                legalpoints.add(legalpoint);
            }
            
            if(row+1<=7){
                legalpoint = new ChessboardPoint(row+1, col-2);
                legalpoints.add(legalpoint);
            }
        }
 
        if(col+2<=7){
         
            if(row-1>=0){
                legalpoint = new ChessboardPoint(row-1, col+2);
                legalpoints.add(legalpoint);
            }
      
            if(row+1<=7){
                legalpoint = new ChessboardPoint(row+1, col+2);
                legalpoints.add(legalpoint);
            }
        }
       
        if(row-2>=0){
            //
            if(col-1>=0){
                legalpoint = new ChessboardPoint(row-2, col-1);
                legalpoints.add(legalpoint);
            }
            //
            if(col+1<=7){
                legalpoint = new ChessboardPoint(row-2, col+1);
                legalpoints.add(legalpoint);
            }
        }
        //
        if(row+2<=7){
            //
            if(col-1>=0){
                legalpoint = new ChessboardPoint(row+2, col-1);
                legalpoints.add(legalpoint);
            }
            //
            if(col+1<=7){
                legalpoint = new ChessboardPoint(row+2, col+1);
                legalpoints.add(legalpoint);
            }
        }
        for (int i = 0; i < legalpoints.size(); i++) {
            if(chessComponents[legalpoints.get(i).getX()][legalpoints.get(i).getY()].getChessColor()==chessColor){
                legalpoints.remove(i);
                i--;
            }
        }


        return legalpoints;
    }
}
