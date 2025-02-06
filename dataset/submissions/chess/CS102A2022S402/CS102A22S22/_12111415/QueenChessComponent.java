import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    private ChessboardPoint source;
    private ChessComponent[][] chessComponents;

    public QueenChessComponent(ChessboardPoint chessboardPoint,ChessComponent[][] chessComponents,char name){
        super(chessboardPoint,chessComponents,name);
this.source=chessboardPoint;
this.chessComponents=chessComponents;
this.name=name;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> point=new ArrayList<>();
        int x=source.getX();
        int y=source.getY();
        if (name=='Q'){
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
            if (x >= 0 && x < 8&&y>=0&&y<8) {
                for (int i = x-1; i>=0; i--) {
                    if (chessComponents[i][y].name == '_') {
                        point.add(new ChessboardPoint(i, y));
                    }
                    else  if (chessComponents[i][y].name>=97){
                        point.add(new ChessboardPoint(i, y));
                        break;
                    }
                    else  if (chessComponents[i][y].name<=90){
                        break;
                    }
                }
                for (int i = x+1; i<=7; i++) {
                    if (chessComponents[i][y].name == '_') {
                        point.add(new ChessboardPoint(i, y));
                    }
                    else  if (chessComponents[i][y].name>=97){
                        point.add(new ChessboardPoint(i, y));
                        break;
                    }
                    else  if (chessComponents[i][y].name<=90){
                        break;
                    }
                }

            }
            if (y>=0&&y<8&&x>=0&&x<8){
                for (int i = y-1; i>=0; i++) {

                    if (chessComponents[x][i].name == '_') {
                        point.add(new ChessboardPoint(x, i));
                    }
                    else if (chessComponents[x][i].name>=97){
                        point.add(new ChessboardPoint(x, i));
                        break;
                    }
                    else  if (chessComponents[x][i].name<=90){
                        break;
                    }
                }
                for (int i = y+1; i<=7; i++) {

                    if (chessComponents[x][i].name == '_') {
                        point.add(new ChessboardPoint(x, i));
                    }
                    else if (chessComponents[x][i].name>=97){
                        point.add(new ChessboardPoint(x, i));
                        break;
                    }
                    else  if (chessComponents[x][i].name<=90){
                        break;
                    }
                }

            }

        }
        else if (name=='q'){
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
            if (x >= 0 && x < 8&&y>=0&&y<8) {
                for (int i = x-1; i>=0; i--) {
                    if (chessComponents[i][y].name == '_') {
                        point.add(new ChessboardPoint(i, y));
                    }
                    else  if (chessComponents[i][y].name<=90){
                        point.add(new ChessboardPoint(i, y));
                        break;
                    }
                    else  if (chessComponents[i][y].name>=97){
                        break;
                    }
                }
                for (int i = x+1; i<=7; i++) {
                    if (chessComponents[i][y].name == '_') {
                        point.add(new ChessboardPoint(i, y));
                    }
                    else  if (chessComponents[i][y].name<=90){
                        point.add(new ChessboardPoint(i, y));
                        break;
                    }
                    else  if (chessComponents[i][y].name>=97){
                        break;
                    }
                }

            }
            if (y>=0&&y<8&&x>=0&&x<8){
                for (int i = y-1; i>=0; i--) {

                    if (chessComponents[x][i].name == '_') {
                        point.add(new ChessboardPoint(x, i));
                    }
                    else if (chessComponents[x][i].name<=90){
                        point.add(new ChessboardPoint(x, i));
                        break;
                    }
                    else  if (chessComponents[x][i].name>=97){
                        break;
                    }
                }
                for (int i = y+1; i<=7; i++) {

                    if (chessComponents[x][i].name == '_') {
                        point.add(new ChessboardPoint(x, i));
                    }
                    else if (chessComponents[x][i].name<=90){
                        point.add(new ChessboardPoint(x, i));
                        break;
                    }
                    else  if (chessComponents[x][i].name>=97){
                        break;
                    }
                }

            }


    }
return point;}}

