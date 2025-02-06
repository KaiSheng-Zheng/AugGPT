import java.util.ArrayList;
import java.util.List;

public class CreateChess {


}
class KingChessComponent extends ChessComponent{
    public KingChessComponent() {
    }

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KingChessComponent(ChessComponent[][] board) {
        super(board);
    }
    public static void outOfIndex(ArrayList<ChessboardPoint> al){
        for(int i=0;i<al.size();i++){
            if(al.get(i).getX()<0|al.get(i).getX()>7|al.get(i).getY()<0|al.get(i).getY()>7){
                al.remove(i);
                i--;
            }
        }
    }
    public  void campJudge(ArrayList<ChessboardPoint> al){
        for(int i=0;i<al.size();i++){
            if(Board[al.get(i).getX()][al.get(i).getY()].getChessColor()==getChessColor()){
                al.remove(i);
                i--;
            }
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> aK=new ArrayList<>();
        ChessboardPoint K1=new ChessboardPoint(getSource().getX(),getSource().getY()+1);
        ChessboardPoint K2=new ChessboardPoint(getSource().getX(),getSource().getY()-1);
        ChessboardPoint K3=new ChessboardPoint(getSource().getX()-1,getSource().getY());
        ChessboardPoint K4=new ChessboardPoint(getSource().getX()-1,getSource().getY()+1);
        ChessboardPoint K5=new ChessboardPoint(getSource().getX()-1,getSource().getY()-1);
        ChessboardPoint K6=new ChessboardPoint(getSource().getX()+1,getSource().getY());
        ChessboardPoint K7=new ChessboardPoint(getSource().getX()+1,getSource().getY()-1);
        ChessboardPoint K8=new ChessboardPoint(getSource().getX()+1,getSource().getY()+1);
        aK.add(K1);
        aK.add(K2);
        aK.add(K3);
        aK.add(K4);
        aK.add(K5);
        aK.add(K6);
        aK.add(K7);
        aK.add(K8);
        outOfIndex(aK);
        campJudge(aK);
        return aK;
    }
}
class QueenChessComponent extends ChessComponent{
    public QueenChessComponent() {
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public QueenChessComponent(ChessComponent[][] board) {
        super(board);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> al=new ArrayList<>();
        for(int i=1;i<7-Math.max(getSource().getX(),getSource().getY());i++){
            al.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
            if(getChessColor()==Board[getSource().getX()+i][getSource().getY()+i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }for(int i=1;i<=Math.min(getSource().getX(),7-getSource().getY());i++){
            al.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
            if(getChessColor()==Board[getSource().getX()-i][getSource().getY()+i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }for(int i=1;i<=Math.min(getSource().getX(),getSource().getY());i++){
            al.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
            if(getChessColor()==Board[getSource().getX()-i][getSource().getY()-i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }for(int i=1;i<=Math.min(7-getSource().getX(),getSource().getY());i++){
            al.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
            if(getChessColor()==Board[getSource().getX()+i][getSource().getY()-i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }
        for(int i=1;i<8-getSource().getX();i++){
            al.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()));
            if(getChessColor()==Board[getSource().getX()+i][getSource().getY()].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }for(int i=1;i<=getSource().getX();i++){
            al.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
            if(getChessColor()==Board[getSource().getX()-i][getSource().getY()].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }for(int i=1;i<8-getSource().getY();i++){
            al.add(new ChessboardPoint(getSource().getX(),getSource().getY()+i));
            if(getChessColor()==Board[getSource().getX()][getSource().getY()+i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }for(int i=1;i<=getSource().getY();i++){
            al.add(new ChessboardPoint(getSource().getX(),getSource().getY()-i));
            if(getChessColor()==Board[getSource().getX()][getSource().getY()-i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }
        return al;
    }
}
class RookChessComponent extends ChessComponent{
    public RookChessComponent() {
    }

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public RookChessComponent(ChessComponent[][] board) {
        super(board);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> al=new ArrayList<>();
        if (getSource().getX()==8){
           
        }else {
        for(int i=1;i<8-getSource().getX();i++) {
            al.add(new ChessboardPoint(getSource().getX() + i, getSource().getY()));
            if (getChessColor() == Board[getSource().getX() + i][getSource().getY()].getChessColor()) {
                al.remove(al.size() - 1);
                break;
            }
        }
        }
        if (getSource().getX()==0){}else {for(int i=1;i<=getSource().getX();i++){
            al.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
            if(getChessColor()==Board[getSource().getX()-i][getSource().getY()].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }}if (getSource().getY()==8){}else {for(int i=1;i<8-getSource().getY();i++){
            al.add(new ChessboardPoint(getSource().getX(),getSource().getY()+i));
            if(getChessColor()==Board[getSource().getX()][getSource().getY()+i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }}if (getSource().getY()==0){}else {for(int i=1;i<=getSource().getY();i++){
            al.add(new ChessboardPoint(getSource().getX(),getSource().getY()-i));
            if(getChessColor()==Board[getSource().getX()][getSource().getY()-i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }}
        return al;
    }
}
class BishopChessComponent extends ChessComponent{
    public BishopChessComponent() {
    }

    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public BishopChessComponent(ChessComponent[][] board) {
        super(board);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> al=new ArrayList<>();
        for(int i=1;i<7-Math.max(getSource().getX(),getSource().getY());i++){
            al.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
            if(getChessColor()==Board[getSource().getX()+i][getSource().getY()+i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }for(int i=1;i<=Math.min(getSource().getX(),7-getSource().getY());i++){
            al.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()+i));
            if(getChessColor()==Board[getSource().getX()-i][getSource().getY()+i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }for(int i=1;i<=Math.min(getSource().getX(),getSource().getY());i++){
            al.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()-i));
            if(getChessColor()==Board[getSource().getX()-i][getSource().getY()-i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }for(int i=1;i<=Math.min(7-getSource().getX(),getSource().getY());i++){
            al.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()+i));
            if(getChessColor()==Board[getSource().getX()+i][getSource().getY()-i].getChessColor()){
                al.remove(al.size()-1);
                break;
            }
        }
        return al;
    }
}
class KnightChessComponent extends ChessComponent{
    public KnightChessComponent() {
    }

    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public KnightChessComponent(ChessComponent[][] board) {
        super(board);
    }
    public  void campJudge(ArrayList<ChessboardPoint> al){
        for(int i=0;i<al.size();i++){
            if(Board[al.get(i).getX()][al.get(i).getY()].getChessColor()==getChessColor()){
                al.remove(i);
                i--;
            }
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> aK = new ArrayList<>();
        ChessboardPoint K1 = new ChessboardPoint(getSource().getX()-2, getSource().getY() + 1);
        ChessboardPoint K2 = new ChessboardPoint(getSource().getX()-2, getSource().getY() - 1);
        ChessboardPoint K3 = new ChessboardPoint(getSource().getX() - 1, getSource().getY()-2);
        ChessboardPoint K4 = new ChessboardPoint(getSource().getX() - 1, getSource().getY() +2);
        ChessboardPoint K5 = new ChessboardPoint(getSource().getX() +2, getSource().getY() + 1);
        ChessboardPoint K6 = new ChessboardPoint(getSource().getX() + 1, getSource().getY()-2);
        ChessboardPoint K7 = new ChessboardPoint(getSource().getX() + 2, getSource().getY() - 1);
        ChessboardPoint K8 = new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 2);
        aK.add(K1);
        aK.add(K2);
        aK.add(K3);
        aK.add(K4);
        aK.add(K5);
        aK.add(K6);
        aK.add(K7);
        aK.add(K8);
        KingChessComponent.outOfIndex(aK);
        campJudge(aK);
        return aK;
    }
}
class PawnChessComponent extends ChessComponent{
    public PawnChessComponent() {
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public PawnChessComponent(ChessComponent[][] board) {
        super(board);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}
class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent() {
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public EmptySlotComponent(ChessComponent[][] board) {
        super(board);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> al =new ArrayList<>();
        if(getChessColor()==ChessColor.BLACK){
            if(getSource().getX()==1){
                for(int i=1;i<=2;i++){
                    al.add(new ChessboardPoint(getSource().getX()+i,getSource().getY()));
                    if(Board[getSource().getX()+i][getSource().getY()].getChessColor()==ChessColor.NONE){

                    }else{
                        al.remove(al.size()-1);
                        break;
                    }
                }
                if(getSource().getY()==0){
                    if(Board[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
                    }
                }
                if(getSource().getY()==7){
                    if(Board[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
                    }
                }
                if(0<getSource().getY()&getSource().getY()<7){
                    if(Board[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
                    }
                    if(Board[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
                    }
                }
            }else{
                if(getSource().getX()+1>7){

                }else{
                    if(Board[getSource().getX()+1][getSource().getY()].getChessColor()==ChessColor.NONE) {
                        al.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
                    }
                }


                if(getSource().getY()==0){
                    if(Board[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
                    }
                }
                if(getSource().getY()==7){
                    if(Board[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
                    }
                }
                if(0<getSource().getY()&getSource().getY()<7){
                    if(Board[getSource().getX()+1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()+1));
                    }
                    if(Board[getSource().getX()+1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()+1,getSource().getY()-1));
                    }
                }

            }
        }
        if(getChessColor()==ChessColor.WHITE){
            if(getSource().getX()==6){
                for(int i=1;i<=2;i++){
                    al.add(new ChessboardPoint(getSource().getX()-i,getSource().getY()));
                    if(Board[getSource().getX()-i][getSource().getY()].getChessColor()==ChessColor.NONE){

                    }else{
                        al.remove(al.size()-1);
                        break;
                    }
                }
                if(getSource().getY()==0){
                    if(Board[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
                    }
                }
                if(getSource().getY()==7){
                    if(Board[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
                    }
                }
                if(0<getSource().getY()&getSource().getY()<7){
                    if(Board[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
                    }
                    if(Board[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
                    }
                }
            }else{
                if(getSource().getX()-1<0){

                }else{
                    if(Board[getSource().getX()-1][getSource().getY()].getChessColor()==ChessColor.NONE) {
                        al.add(new ChessboardPoint(getSource().getX() -1, getSource().getY()));
                    }
                }


                if(getSource().getY()==0){
                    if(Board[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
                    }
                }
                if(getSource().getY()==7){
                    if(Board[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
                    }
                }
                if(0<getSource().getY()&getSource().getY()<7){
                    if(Board[getSource().getX()-1][getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()+1));
                    }
                    if(Board[getSource().getX()-1][getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                        al.add(new ChessboardPoint(getSource().getX()-1,getSource().getY()-1));
                    }
                }

            }
        }
        return al;
    }
}