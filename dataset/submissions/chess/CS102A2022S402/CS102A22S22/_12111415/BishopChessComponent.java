import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent  {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;
    public BishopChessComponent(ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents,char name){
        this.source = chessboardPoint;
        this.chessComponents = chessComponents;
        this.name = name;

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> point=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        if (x>=0&&x<8&&y>=0&&y<8){
        if (name=='B'){
               for (int i=1;i<8;i++){
                 if (x+i>7||y+i>7){break;}
                else    if (chessComponents[x+i][y+i].name=='_'){
                       point.add( new  ChessboardPoint(x+i,y+i));
                   }
                else    if (chessComponents[x+i][y+i].name>=97){
                       point.add(new ChessboardPoint(x+i,y+i));
                       break;
                   }
                  else if (chessComponents[x+i][y+i].name<=90){
                      break;
                 }
               }
            for (int i=1;i<8;i++){
                if (x-i<0||y-i<0){break;}
                else    if (chessComponents[x-i][y-i].name=='_'){
                    point.add( new  ChessboardPoint(x-i,y-i));
                }
                else    if (chessComponents[x-i][y-i].name>=97){
                    point.add(new ChessboardPoint(x-i,y-i));
                    break;
                }
                else if (chessComponents[x-i][y-i].name<=90){
                    break;
                }
            }
            for (int i=1;i<8;i++){
                if (x-i<0||y+i>7){break;}
                else    if (chessComponents[x-i][y+i].name=='_'){
                    point.add( new  ChessboardPoint(x-i,y+i));
                }
                else    if (chessComponents[x-i][y+i].name>=97){
                    point.add(new ChessboardPoint(x-i,y+i));
                    break;
                }
                else if (chessComponents[x-i][y+i].name<=90){
                    break;
                }
            }
            for (int i=1;i<8;i++){
                if (x+i>7||y-i<0){break;}
                else    if (chessComponents[x+i][y-i].name=='_'){
                    point.add( new  ChessboardPoint(x+i,y-i));
                }
                else    if (chessComponents[x+i][y-i].name>=97){
                    point.add(new ChessboardPoint(x+i,y-i));
                    break;
                }
                else if (chessComponents[x+i][y-i].name<=90){
                    break;
                }
            }


           }
else if (name=='b'){
            for (int i=1;i<8;i++){
                if (x+i>7||y+i>7){break;}
                else    if (chessComponents[x+i][y+i].name=='_'){
                    point.add( new  ChessboardPoint(x+i,y+i));
                }
                else    if (chessComponents[x+i][y+i].name<=90){
                    point.add(new ChessboardPoint(x+i,y+i));
                    break;
                }
                else if (chessComponents[x+i][y+i].name>=97){
                    break;
                }
            }
            for (int i=1;i<8;i++){
                if (x-i<0||y-i<0){break;}
                else    if (chessComponents[x-i][y-i].name=='_'){
                    point.add( new  ChessboardPoint(x-i,y-i));
                }
                else    if (chessComponents[x-i][y-i].name<=90){
                    point.add(new ChessboardPoint(x-i,y-i));
                    break;
                }
                else if (chessComponents[x-i][y-i].name>=97){
                    break;
                }
            }
            for (int i=1;i<8;i++){
                if (x-i<0||y+i>7){break;}
                else    if (chessComponents[x-i][y+i].name=='_'){
                    point.add( new  ChessboardPoint(x-i,y+i));
                }
                else    if (chessComponents[x-i][y+i].name<=90){
                    point.add(new ChessboardPoint(x-i,y+i));
                    break;
                }
                else if (chessComponents[x-i][y+i].name>=97){
                    break;
                }
            }
            for (int i=1;i<8;i++){
                if (x+i>7||y-i<0){break;}
                else    if (chessComponents[x+i][y-i].name=='_'){
                    point.add( new  ChessboardPoint(x+i,y-i));
                }
                else    if (chessComponents[x+i][y-i].name<=90){
                    point.add(new ChessboardPoint(x+i,y-i));
                    break;
                }
                else if (chessComponents[x+i][y-i].name>=97){
                    break;
                }
            }


        }


        }
     return point;}


    }




