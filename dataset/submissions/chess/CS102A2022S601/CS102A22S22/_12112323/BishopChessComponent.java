import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
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

    @Override
    public char getName() {
        return name;
    }

    @Override
    public void setName(char name) {
        this.name = name;
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
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
        if (c>7||r>7){
            break;
        }
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
        if (c>7||r>7){
            break;
        }
        while (c<Math.max(source.getY(), e)){
            if (!(chessGame.getChess(r,c) instanceof EmptySlotComponent)) {
                op=false;
            }
            c++;
            r++;
        }
    }
    else {
        op=false;
    }
    if (op){
        yyc.add(new ChessboardPoint(a,e));
    }
}
  }
        int[] cry = new int[yyc.size()];
        for (int a = 0 ; a<yyc.size();a++){
            cry[a]=yyc.get(a).getX()*10+yyc.get(a).getY();
        }
        Arrays.sort(cry);
        List<ChessboardPoint> qaq = new ArrayList<>();
        for (int a = 0 ; a<yyc.size();a++){
            qaq.add(new ChessboardPoint(cry[a]/10,cry[a]%10));
        }
        return qaq;
    }
      public String toString() {
        return String.valueOf(this.name);

    }
}


