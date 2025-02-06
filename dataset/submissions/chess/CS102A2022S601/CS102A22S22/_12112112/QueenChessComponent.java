import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
    ArrayList<String> a;
    public QueenChessComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard){
        super(source,chessColor,name,chessboard);
        a= (ArrayList<String>) chessboard;

    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> k=new ArrayList<>();
        int x=super.getSource().getX();
        int y=super.getSource().getY();
        if (super.getChessColor()==ChessColor.BLACK){
            int b1=x+1;int b2=y+1;
            while (b1<8&&b2<8){
                if (a.get(b1).charAt(b2)>96){
                    k.add(new ChessboardPoint(b1, b2 ));
                    break;
                }else if (a.get(b1).charAt(b2)=='_'){
                    k.add(new ChessboardPoint(b1, b2 ));
                } else {break;}
                b1++;
                b2++;
            }
            int b3=x-1;int b4=y+1;
            while (b3>=0&&b4<8){
                if (a.get(b3).charAt(b4)>96){
                    k.add(new ChessboardPoint(b3, b4 ));
                    break;
                }else if (a.get(b3).charAt(b4)=='_'){
                    k.add(new ChessboardPoint(b3, b4 ));
                }else {break;}
                b3--;
                b4++;
            }
            int b5=x+1;int b6=y-1;
            while (b5<8&&b6>=0){
                if (a.get(b5).charAt(b6)>96){
                    k.add(new ChessboardPoint(b5, b6 ));
                    break;
                }else if (a.get(b5).charAt(b6)=='_'){
                    k.add(new ChessboardPoint(b5, b6 ));
                }else {break;}
                b5++;
                b6--;
            }
            int b7=x-1;int b8=y-1;
            while (b7>=0&&b8>=0){
                if (a.get(b7).charAt(b8)>96){
                    k.add(new ChessboardPoint(b7, b8 ));
                    break;
                }else if (a.get(b7).charAt(b8)=='_'){
                    k.add(new ChessboardPoint(b7, b8 ));
                }else {break;}
                b7--;
                b8--;
            }

            for (int i=x+1;i<8;i++){
                if (a.get(i).charAt(y)=='_'){
                    k.add(new ChessboardPoint(i, y ));
                }else if (a.get(i).charAt(y)>96) {
                    k.add(new ChessboardPoint(i, y ));
                    break;
                }else {break;}
            }
            for (int i=x-1;i>=0;i--){
                if (a.get(i).charAt(y)=='_'){
                    k.add(new ChessboardPoint(i, y ));
                }else if (a.get(i).charAt(y)>96) {
                    k.add(new ChessboardPoint(i, y ));
                    break;
                }else {break;}
            }
            for (int i=y+1;i<8;i++){
                if (a.get(x).charAt(i)=='_'){
                    k.add(new ChessboardPoint(x, i ));
                }else if (a.get(x).charAt(i)>96) {
                    k.add(new ChessboardPoint(x, i ));
                    break;
                }else {break;}
            }
            for (int i=y-1;i>=0;i--){
                if (a.get(x).charAt(i)=='_'){
                    k.add(new ChessboardPoint(x, i ));
                } else if (a.get(x).charAt(i)>96) {
                    k.add(new ChessboardPoint(x, i ));
                    break;
                }else {break;}
            }
        }else if (super.getChessColor()==ChessColor.WHITE){
            int b1=x+1;int b2=y+1;
            while (b1<8&&b2<8){
                if (a.get(b1).charAt(b2)<91){
                    k.add(new ChessboardPoint(b1, b2 ));
                    break;
                }else if (a.get(b1).charAt(b2)=='_'){
                    k.add(new ChessboardPoint(b1, b2 ));
                }else {break;}
                b1++;
                b2++;
            }
            int b3=x-1;int b4=y+1;
            while (b3>=0&&b4<8){
                if (a.get(b3).charAt(b4)<91){
                    k.add(new ChessboardPoint(b3, b4 ));
                    break;
                }else if (a.get(b3).charAt(b4)=='_'){
                    k.add(new ChessboardPoint(b3, b4 ));
                }else {break;}
                b3--;
                b4++;
            }
            int b5=x+1;int b6=y-1;
            while (b5<8&&b6>=0){
                if (a.get(b5).charAt(b6)<91){
                    k.add(new ChessboardPoint(b5, b6 ));
                    break;
                }else if (a.get(b5).charAt(b6)=='_'){
                    k.add(new ChessboardPoint(b5, b6 ));
                }else {break;}
                b5++;
                b6--;
            }
            int b7=x-1;int b8=y-1;
            while (b7>=0&&b8>=0){
                if (a.get(b7).charAt(b8)<91){
                    k.add(new ChessboardPoint(b7, b8 ));
                    break;
                }else if (a.get(b7).charAt(b8)=='_'){
                    k.add(new ChessboardPoint(b7, b8 ));
                }else {break;}
                b7--;
                b8--;
            }


            for (int i=x+1;i<8;i++){
                if (a.get(i).charAt(y)=='_'){
                    k.add(new ChessboardPoint(i, y ));
                }else if (a.get(i).charAt(y)<91) {
                    k.add(new ChessboardPoint(i, y ));
                    break;
                }else {break;}
            }
            for (int i=x-1;i>=0;i--){
                if (a.get(i).charAt(y)=='_'){
                    k.add(new ChessboardPoint(i, y ));
                }else if (a.get(i).charAt(y)<91) {
                    k.add(new ChessboardPoint(i, y ));
                    break;
                }else {break;}
            }
            for (int i=y+1;i<8;i++){
                if (a.get(x).charAt(i)=='_'){
                    k.add(new ChessboardPoint(x, i ));
                }else if (a.get(x).charAt(i)<91) {
                    k.add(new ChessboardPoint(x, i ));
                    break;
                }else {break;}
            }
            for (int i=y-1;i>=0;i--){
                if (a.get(x).charAt(i)=='_'){
                    k.add(new ChessboardPoint(x, i ));
                }else if (a.get(x).charAt(i)<91) {
                    k.add(new ChessboardPoint(x, i ));
                    break;
                }else {break;}
            }
        }
        Collections.sort(k);
        return k;
    }
    public void setName(char a) {
        super.setName(a);
    }

    public void setChessColor(ChessColor chessColor) {
        super.setChessColor(chessColor);
    }

    public void setSource(ChessboardPoint source) {
        super.setSource(source);
    }
}
