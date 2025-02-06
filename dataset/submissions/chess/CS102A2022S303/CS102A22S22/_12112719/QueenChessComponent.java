import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        this.source = source;
        this.chessColor = chessColor;
        this.name = name;
//        chessPos.add(this);
    }
    public void setSource(ChessboardPoint source) {
        this.source.setX(source.getX());
        this.source.setY(source.getY());
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> canmoveto = new ArrayList<>();
        ChessComponent[][] Board =new ChessComponent[8][8];
        int x0 = getSource().getX();
        int y0 = getSource().getY();
        Board =currentgame.getChessComponents();
        ChessboardPoint destination=new ChessboardPoint(0,0);
        int xf, yf;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                destination.setX(i);
                destination.setY(j);
                xf =destination.getX();
                yf =destination.getY();
                boolean can=true;
                
                if (x0==xf) {
                    int row = x0;
                    for (int col = Math.min(y0,yf) + 1; col < Math.max(y0,yf); col++) {
                        if (!(Board[row][col] instanceof EmptySlotComponent)) {
                            can=false;
                        }
                    }
                } else if (y0==yf) { 
                    int col = y0;
                    for (int row = Math.min(x0,xf) + 1; row < Math.max(x0,xf); row++) {
                        if (!(Board[row][col] instanceof EmptySlotComponent)) {
                            can= false;
                        }
                    }
                }else if (Math.abs(x0-xf)==Math.abs(y0-yf)){
                    if ((x0<xf&&y0<yf)||(x0>xf&&y0>yf)){ 
                        for (int row = 1+Math.min(x0,xf),col=1+Math.min(y0,yf); row <Math.max(x0,xf)&&col<Math.max(y0,yf) ; row++,col++) {
                            if (!(Board[row][col] instanceof EmptySlotComponent)){
                                can= false;
                            }
                        }
                    }else if ((x0>xf&&y0<yf)||(x0<xf&&y0>yf)){
                        for (int row = 1+Math.min(x0,xf),col=Math.max(y0,yf)-1; row <Math.max(x0,xf)&&col>Math.min(y0,yf) ; row++,col--) {
                            if (!(Board[row][col] instanceof EmptySlotComponent)){
                                can= false;
                            }
                        }
                    }
                }else can=false;
                if (can && Board[i][j].getChessColor() != chessColor) {
                    canmoveto.add(new ChessboardPoint(i, j));
                }
            }
        }
        return canmoveto;
    }

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public char getName() {
        return name;
    }
    public String toString() {
        if (getChessColor()==ChessColor.WHITE){
            return "q";
        }else return "Q";
    }
}
