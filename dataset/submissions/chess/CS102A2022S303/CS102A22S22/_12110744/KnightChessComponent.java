import java.util.ArrayList;
import java.util.List;
//completely done
public class KnightChessComponent extends ChessComponent{
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;
    public KnightChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source){
        super(name, chessComponents, source);
        this.name=name;
        this.source=source;
        this.chessComponents=chessComponents;
    }public KnightChessComponent(char name) {
        super(name);
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    if (name=='N'){
                    if((Math.abs(i-x)==2&&Math.abs(j-y)==1&&chessComponents[i][j].name>'Z')||(Math.abs(i-x)==1&&Math.abs(j-y)==2&&chessComponents[i][j].name>'Z')){
                            move.add(new ChessboardPoint(i,j));
                      }
                   }else if (name=='n'){
                        if((Math.abs(i-x)==2&&Math.abs(j-y)==1&&chessComponents[i][j].name<'a')||(Math.abs(i-x)==1&&Math.abs(j-y)==2&&chessComponents[i][j].name<'a')){
                            move.add(new ChessboardPoint(i,j));
                    }
                 }
              }
            }
        return move;
    }
}
