import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RookChessComponent extends ChessComponent{
    ArrayList<String> a;
    public RookChessComponent(ChessboardPoint source,ChessColor chessColor, char name,List<String> chessboard){
        super(source,chessColor,name,chessboard);
        a= (ArrayList<String>) chessboard;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> k=new ArrayList<>();
        int x=super.getSource().getX();
        int y=super.getSource().getY();
        if (super.getChessColor()==ChessColor.BLACK){
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
