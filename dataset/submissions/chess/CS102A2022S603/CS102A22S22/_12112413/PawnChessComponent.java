import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> l= new ArrayList<>();
        int nx=this.getChessboardPoint().getX();
        int ny=this.getChessboardPoint().getY();
        if(this.getChessColor()==ChessColor.WHITE){
            if(nx==6&&this.chessComponents[5][ny].getChessColor()==ChessColor.NONE&&this.chessComponents[4][ny].getChessColor()==ChessColor.NONE)
                l.add(new ChessboardPoint(4,ny));
            if(nx!=0) {
                if (this.chessComponents[nx-1][ny].getChessColor()==ChessColor.NONE)
                    l.add(new ChessboardPoint(nx-1,ny));
                if(ny-1>=0)
                    if(this.chessComponents[nx-1][ny-1].getChessColor()!=this.getChessColor()&&this.chessComponents[nx-1][ny-1].getChessColor()!=ChessColor.NONE)
                        l.add(new ChessboardPoint(nx-1,ny-1));
                if(ny+1<=7)
                    if(this.chessComponents[nx-1][ny+1].getChessColor()!=this.getChessColor()&&this.chessComponents[nx-1][ny+1].getChessColor()!=ChessColor.NONE)
                        l.add(new ChessboardPoint(nx-1,ny+1));
            }
        }
        else{
            if(nx==1&&this.chessComponents[2][ny].getChessColor()==ChessColor.NONE&&this.chessComponents[3][ny].getChessColor()==ChessColor.NONE)
                l.add(new ChessboardPoint(3,ny));
            if(nx!=7){
                if (this.chessComponents[nx+1][ny].getChessColor()==ChessColor.NONE)
                    l.add(new ChessboardPoint(nx+1,ny));
                if(ny-1>=0)
                    if(this.chessComponents[nx+1][ny-1].getChessColor()!=this.getChessColor()&&this.chessComponents[nx+1][ny-1].getChessColor()!=ChessColor.NONE)
                        l.add(new ChessboardPoint(nx+1,ny-1));
                if(ny+1<=7)
                    if(this.chessComponents[nx+1][ny+1].getChessColor()!=this.getChessColor()&&this.chessComponents[nx+1][ny+1].getChessColor()!=ChessColor.NONE)
                        l.add(new ChessboardPoint(nx+1,ny+1));
            }
        }

        return l;
    }
}
