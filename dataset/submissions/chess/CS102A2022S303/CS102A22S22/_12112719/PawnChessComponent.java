import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
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
        ChessComponent[][] chessComponents =new ChessComponent[8][8];
        int x0 = getSource().getX();
        int y0 = getSource().getY();
        chessComponents =currentgame.getChessComponents();
        ChessboardPoint destination=new ChessboardPoint(0,0);
        int xf, yf;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                destination.setX(i);
                destination.setY(j);
                xf =destination.getX();
                yf =destination.getY();
                boolean can=true;
                
                int x=Math.abs(x0-xf);
                int y=Math.abs(y0-yf); 

                if (yf!=y0){
                    if (Math.abs(yf-y0)==1&& !(chessComponents[xf][yf]instanceof EmptySlotComponent)){
                        if (this.getChessColor()==ChessColor.BLACK&&xf-x0!=1){
                            can=false;
                        }else if (this.getChessColor()==ChessColor.WHITE&&x0-xf!=1){
                            can= false;
                        }
                    }else can= false;
                }
        
                else if (this.getChessColor()==ChessColor.BLACK&&xf-x0!=1){
                    if (!(chessComponents[xf][yf] instanceof EmptySlotComponent)){
                        can=false;
                    }else if (xf-x0==2){
                        if (x0!=1){
                            can=false;
                        }
                    }else can= false;
                }else if (this.getChessColor()==ChessColor.WHITE&&x0-xf!=1){
                    if (!(chessComponents[xf][yf]instanceof EmptySlotComponent)){
                        can=false;
                    }else if (x0-xf==2){
                        if (x0!=6){
                            can=false;
                        }
                    }else can=false;
                    if (!(chessComponents[xf][yf]instanceof EmptySlotComponent)){
                       can=false;
                    }
                }else if (this.getChessColor()==ChessColor.BLACK&&xf-x0==1){
                    if (!(chessComponents[xf][yf]instanceof EmptySlotComponent)){
                        can=false;
                    }
                }else if (this.getChessColor()==ChessColor.WHITE&&x0-xf==1){
                    if (!(chessComponents[xf][yf]instanceof EmptySlotComponent)){
                        can=false;
                    }
                }
                if (can && chessComponents[i][j].getChessColor() != chessColor) {
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
            return "p";
        }else return "P";
    }
}
