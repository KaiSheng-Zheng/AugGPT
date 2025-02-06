import java.util.ArrayList;
import java.util.List;

public class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        super(source, chessColor);
        if(chessColor==ChessColor.WHITE){
            this.name='k';
        }else{
            this.name='K';
        }
    }

    public KingChessComponent(ChessColor chessColor) {
        super(chessColor);
        if(chessColor==ChessColor.WHITE){
            this.name='k';
        }else{
            this.name='K';
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
        
        if(row+1<=7){
            legalpoint=new ChessboardPoint(row+1,col);
            legalpoints.add(legalpoint);
            if(col+1<=7){
                legalpoint=new ChessboardPoint(row+1,col+1);
                legalpoints.add(legalpoint);
            }
            if(col-1>=0){
                legalpoint=new ChessboardPoint(row+1,col-1);
                legalpoints.add(legalpoint);
            }
        }
        if(row-1>=0){
            legalpoint=new ChessboardPoint(row-1,col);
            legalpoints.add(legalpoint);
            if(col+1<=7){
                legalpoint=new ChessboardPoint(row-1,col+1);
                legalpoints.add(legalpoint);
            }
            if(col-1>=0){
                legalpoint=new ChessboardPoint(row-1,col-1);
                legalpoints.add(legalpoint);
            }
        }
        if(col+1<=7){
            legalpoint=new ChessboardPoint(row,col+1);
            legalpoints.add(legalpoint);
        }
        if(col-1>=0){
            legalpoint=new ChessboardPoint(row,col-1);
            legalpoints.add(legalpoint);
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
