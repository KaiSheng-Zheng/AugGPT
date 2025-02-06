import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;

    @Override
    public ChessboardPoint getSource() {
        return source;
    }

    @Override
    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    @Override
    public ChessColor getChessColor() {
        return chessColor;
    }

    @Override
    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
this.source=source;
this.chessColor=chessColor;
this.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> yyc = new ArrayList<>();
        int a = this.getSource().getX();
        int b =this.getSource().getY();
for (int q = a+1 ;q<8;q++){
    if (chessGame.getChess(q,b).getChessColor()==ChessColor.NONE){
        yyc.add(new ChessboardPoint(q,b));
    }
   else if (chessGame.getChess(q,b).getChessColor()!=this.chessColor){
        yyc.add(new ChessboardPoint(q,b));
        break;
    }
  else   if (chessGame.getChess(q,b).getChessColor()==this.chessColor){
        break;
    }
}
        for (int q = a-1 ;q>=0;q--){
            if (chessGame.getChess(q,b).getChessColor()==ChessColor.NONE){
                yyc.add(new ChessboardPoint(q,b));
            }
          else   if (chessGame.getChess(q,b).getChessColor()!=this.chessColor){
                yyc.add(new ChessboardPoint(q,b));
                break;
            }
          else   if (chessGame.getChess(q,b).getChessColor()==this.chessColor){
                break;
            }
        }
        for (int q = b-1 ;q>=0;q--){
            if (chessGame.getChess(a,q).getChessColor()==ChessColor.NONE){
                yyc.add(new ChessboardPoint(a,q));
            }
         else   if (chessGame.getChess(a,q).getChessColor()!=this.chessColor){
                yyc.add(new ChessboardPoint(a,q));
                break;
            }
         else    if (chessGame.getChess(a,q).getChessColor()==this.chessColor){
                break;
            }
        }
        for (int q = b+1 ;q<8;q++){
            if (chessGame.getChess(a,q).getChessColor()==ChessColor.NONE){
                yyc.add(new ChessboardPoint(a,q));
            }
         else    if (chessGame.getChess(a,q).getChessColor()!=this.chessColor){
                yyc.add(new ChessboardPoint(a,q));
                break;
            }
        else     if (chessGame.getChess(a,q).getChessColor()==this.chessColor){
                break;
            }
        }

        int[] cry = new int[yyc.size()];
        for (int l = 0 ; l<yyc.size();l++){
            cry[l]=yyc.get(l).getX()*10+yyc.get(l).getY();
        }
        Arrays.sort(cry);
        List<ChessboardPoint> qaq = new ArrayList<>();
        for (int l = 0 ; l<yyc.size();l++){
            qaq.add(new ChessboardPoint(cry[l]/10,cry[l]%10));
        }
        return qaq;
    }
    public String toString() {
        return String.valueOf(this.name);

    }
}
