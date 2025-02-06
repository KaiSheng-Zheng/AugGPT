
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

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

    @Override
    public char getName() {
        return name;
    }

    @Override
    public void setName(char name) {
        this.name = name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> yyc = new ArrayList<>();
        for (int a=0;a<8;a++){
            for (int e = 0 ; e<8;e++){
                boolean op = true;
                if (source.getX() + source.getY()== a+e&&(chessGame.getChess(a,e).getChessColor()!=this.getChessColor()||chessGame.getChess(a,e) instanceof EmptySlotComponent)) {
                    int c = Math.min(source.getY(), e) + 1;
                    int r = Math.max(source.getX(), a) - 1;
                    while (c<Math.max(source.getY(), e)){
                        if (!(chessGame.getChess(r,c) instanceof EmptySlotComponent)) {
                            op=false;
                        }
                        c++;
                        r--;
                    }
                }
                else  if (source.getY()-source.getX()==e-a&&(chessGame.getChess(a,e).getChessColor()!=this.getChessColor()||chessGame.getChess(a,e) instanceof EmptySlotComponent)) {
                    int c = Math.min(source.getY(), e) + 1;
                    int r = Math.min(source.getX(), a) + 1;
                    while (c<Math.max(source.getY(), e)){
                        if (!(chessGame.getChess(r,c) instanceof EmptySlotComponent)) {
                            op=false;
                        }
                        c++;
                        r++;
                    }
                }
                else { // Not on the same row or the same column.
                    op=false;
                }
                if (op){
                    yyc.add(new ChessboardPoint(a,e));
                }
            }
        }
        int a = this.getSource().getX();
        int b =this.getSource().getY();

        for (int e = 0 ;e <a;e++){
            boolean op = true;
            if (chessGame.getChess(e,b).getChessColor()==chessColor){
                op = false;
            }
            for (int m = e+1;m<a;m++){
                if (!(chessGame.getChess(m,b) instanceof EmptySlotComponent && (chessGame.getChess(e,b).getChessColor()!=this.getChessColor()||chessGame.getChess(e,b) instanceof EmptySlotComponent))){
                    op = false;
                }
            }
            if (op){
                yyc.add(new ChessboardPoint(e,b));
            }

        }
        for (int e = 7 ;e >a;e--){
            boolean op = true;
            if (chessGame.getChess(e,b).getChessColor()==chessColor){
                op = false;
            }
            for (int m = e-1;m>a;m--){
                if (!(chessGame.getChess(m,b) instanceof EmptySlotComponent && (chessGame.getChess(e,b).getChessColor()!=this.getChessColor()||chessGame.getChess(e,b) instanceof EmptySlotComponent))){
                    op = false;
                }
            }
            if (op){
                yyc.add(new ChessboardPoint(e,b));
            }

        }

        for (int e = 0 ;e <b;e++){
            boolean op = true;
            if (chessGame.getChess(a,e).getChessColor()==chessColor){
                op = false;
            }
            for (int m = e+1;m<b;m++){
                if (!(chessGame.getChess(a,m) instanceof EmptySlotComponent && (chessGame.getChess(a,e).getChessColor()!=this.getChessColor()||chessGame.getChess(a,e) instanceof EmptySlotComponent))){
                    op = false;
                }
            }
            if (op){
                yyc.add(new ChessboardPoint(a,e));
            }

        }

        for (int e = 7 ;e >b;e--){
            boolean op = true;
            if (chessGame.getChess(a,e).getChessColor()==chessColor){
                op = false;
            }
            for (int m = e-1;m>b;m--){
                if (!(chessGame.getChess(a,m) instanceof EmptySlotComponent && (chessGame.getChess(a,e).getChessColor()!=this.getChessColor()||chessGame.getChess(a,e) instanceof EmptySlotComponent))){
                    op = false;
                }
            }
            if (op){
                yyc.add(new ChessboardPoint(a,e));
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
}
