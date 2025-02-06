import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint chessboardPoint,ChessColor color) {
        if (color == ChessColor.BLACK){
            this.name='P';
        }
        if (color == ChessColor.WHITE){
            this.name='p';
        }
        ChessComponent[][] components=new ChessComponent[8][8];
        this.setSource(chessboardPoint);
        this.setChessColor(color);
        this.setChessboard(components);
    }

    public List<ChessboardPoint> canMoveTo(){
        int x=this.getSource().getX();
        int y=this.getSource().getY();
        ChessboardPoint Pawn=new ChessboardPoint(x,y);
        List<ChessboardPoint> chessboardPoints = new ArrayList<>();
        if (this.getChessColor()==ChessColor.BLACK){
            if (Pawn.getX()==1){
                for (int i = 0; i < 2; i++) {
                    if (Pawn.offset(1+i,0)!=null){
                        if (this.getChessboard()[x+1+i][y].getChessColor()!=ChessColor.NONE) {
                            break;
                        }
                        chessboardPoints.add(Pawn.offset(1+i,0));
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                if (Pawn.offset(1,0)!=null){
                    if (this.getChessboard()[x+1][y].getChessColor()==ChessColor.NONE) {
                        chessboardPoints.add(Pawn.offset(1,0));
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                if (Pawn.offset(1,-1+2*i)!=null){
                    if (this.getChessboard()[x+1][y-1+2*i].getChessColor()==ChessColor.WHITE) {
                        chessboardPoints.add(Pawn.offset(1,-1+2*i));
                    }
                }
            }
        }
        if (this.getChessColor()==ChessColor.WHITE){
            if (Pawn.getX()==6){
                for (int i = 0; i < 2; i++) {
                    if (Pawn.offset(-1-i,0)!=null){
                        if (this.getChessboard()[x-1-i][y].getChessColor()!=ChessColor.NONE) {
                            break;
                        }
                        chessboardPoints.add(Pawn.offset(-1-i,0));
                    }
                    else {
                        break;
                    }
                }
            }
            else {
                if (Pawn.offset(-1,0)!=null){
                    if (this.getChessboard()[x-1][y].getChessColor()==ChessColor.NONE) {
                        chessboardPoints.add(Pawn.offset(-1,0));
                    }
                }
            }
            for (int i = 0; i < 2; i++) {
                if (Pawn.offset(-1,-1+2*i)!=null){
                    if (this.getChessboard()[x-1][y-1+2*i].getChessColor()==ChessColor.BLACK) {
                        chessboardPoints.add(Pawn.offset(-1,-1+2*i));
                    }
                }
            }
        }
        return chessboardPoints;
    }
}