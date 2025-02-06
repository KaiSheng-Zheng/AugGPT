import java.util.ArrayList;
import java.util.List;
//complete done
public class RookChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public RookChessComponent(char name, ChessComponent[][] chessComponents, ChessboardPoint source) {
        super(name, chessComponents, source);
        this.name = name;
        this.source=source;
        this.chessComponents=chessComponents;
    }
    public RookChessComponent(char name) {
        super(name);
        this.name=name;
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        int[]d={1,-1};
            for(int i=0;i<2;i++){
                int x = source.getX();
                int y = source.getY();
                for (int j=0;j<8;j++) {
                    x+=d[i];
                    if (name=='R'){
                       if (x < 8&&x>=0) {
                              if (chessComponents[x][y].name=='_'){
                                  move.add(new ChessboardPoint(x,y));
                              }else if(chessComponents[x][y].name>='a'){
                                  move.add(new ChessboardPoint(x,y));
                                  break;
                              }else{
                                  break;
                           }
                      }else{
                         break;
                    }
                }else if (name=='r'){
                        if (x < 8&&x>=0) {
                            if (chessComponents[x][y].name=='_'){
                                move.add(new ChessboardPoint(x,y));
                            }else if(chessComponents[x][y].name<='Z'){
                                move.add(new ChessboardPoint(x,y));
                                break;
                            }else{
                                break;
                            }
                        }else {
                            break;
                        }
                    }
                }
            }



            for(int i=0;i<2;i++){
                int x = source.getX();
                int y = source.getY();
                for (int j=0;j<8;j++) {
                    y+=d[i];
                    if (name=='R'){
                    if (y < 8&&y>=0) {
                        if (chessComponents[x][y].name=='_'){
                            move.add(new ChessboardPoint(x,y));
                        }else if(chessComponents[x][y].name>='a'){
                            move.add(new ChessboardPoint(x,y));
                            break;
                        }else{
                            break;
                        }
                    }else {
                        break;
                    }
                }else if (name=='r'){
                        if (y < 8&&y>=0) {
                            if (chessComponents[x][y].name=='_'){
                                move.add(new ChessboardPoint(x,y));
                            }else if(chessComponents[x][y].name<='Z'){
                                move.add(new ChessboardPoint(x,y));
                                break;
                            }else{
                                break;
                            }
                        }else {
                            break;
                        }
                    }
                }
            }
            return move;
    }
}
