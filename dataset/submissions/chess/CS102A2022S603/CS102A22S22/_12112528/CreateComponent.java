import java.util.ArrayList;
import java.util.List;

public class CreateComponent  {
    public static void judge(List<ChessboardPoint> list){
        for (int i=0;i<list.size();i++){
            if (list.get(i).getX()>7||list.get(i).getX()<0||list.get(i).getY()>7||list.get(i).getY()<0){
                list.remove(i);
                i--;
            }
        }
    }
}
class KingChessComponent extends ChessComponent{
    public KingChessComponent() {
    }
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public void judge(List<ChessboardPoint> a){
        for (int i=0;i<a.size();i++){
         if (ChessBoard[a.get(i).getX()][a.get(i).getY()].getChessColor()==this.getChessColor()){
             a.remove(i);
             i--;
         }
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> King=new ArrayList<>();
        System.out.println(getSource().getX()+"  "+getSource().getY());
        King.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()-1));
        King.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()));
        King.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()+1));
        King.add(new ChessboardPoint(this.getSource().getX(),this.getSource().getY()-1));
        King.add(new ChessboardPoint(this.getSource().getX(),this.getSource().getY()+1));
        King.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()-1));
        King.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()));
        King.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()+1));
        CreateComponent.judge(King);
        judge(King);
        System.out.println(King);
        return King;
    }

}






class QueenChessComponent extends ChessComponent{
    public QueenChessComponent() {
    }
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {

        ArrayList<ChessboardPoint> Queen=new ArrayList<>();
        for (int i=1;i<=7;i++){
            if (getSource().getY()+i>7){
                break;
            }
            Queen.add(new ChessboardPoint(getSource().getX(), getSource().getY()+i));
            if (ChessBoard[getSource().getX()][getSource().getY()+i].getChessColor()==this.getChessColor()){
                Queen.remove(Queen.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()][getSource().getY()+i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }

        for (int i=1;i<=7;i++){
            if (getSource().getY()-i<0){
                break;
            }
            Queen.add(new ChessboardPoint(getSource().getX(), getSource().getY()-i));
            if (ChessBoard[getSource().getX()][getSource().getY()-i].getChessColor()==this.getChessColor()){
                Queen.remove(Queen.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()][getSource().getY()-i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getX()+i>7){
                break;
            }
            Queen.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()));
            if (ChessBoard[getSource().getX()+i][getSource().getY()].getChessColor()==this.getChessColor()){
                Queen.remove(Queen.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()+i][getSource().getY()].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getX()-i<0){
                break;
            }
            Queen.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()));
            if (ChessBoard[getSource().getX()-i][getSource().getY()].getChessColor()==this.getChessColor()){
                Queen.remove(Queen.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()-i][getSource().getY()].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getX()+i>7||getSource().getY()+i>7){
                break;
            }
            Queen.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()+i));
            if (ChessBoard[getSource().getX()+i][getSource().getY()+i].getChessColor()==this.getChessColor()){
                Queen.remove(Queen.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()+i][getSource().getY()+i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getX()-i<0||getSource().getY()-i<0){
                break;
            }
            Queen.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()-i));
            if (ChessBoard[getSource().getX()-i][getSource().getY()-i].getChessColor()==this.getChessColor()){
                Queen.remove(Queen.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()-i][getSource().getY()-i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getX()+i>7||getSource().getY()-i<0){
                break;
            }
            Queen.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()-i));
            if (ChessBoard[getSource().getX()+i][getSource().getY()-i].getChessColor()==this.getChessColor()){
                Queen.remove(Queen.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()+i][getSource().getY()-i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getX()-i<0||getSource().getY()+i>7){
                break;
            }
            Queen.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()+i));
            if (ChessBoard[getSource().getX()-i][getSource().getY()+i].getChessColor()==this.getChessColor()){
                Queen.remove(Queen.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()-i][getSource().getY()+i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        return Queen;
    }
}









class RookChessComponent extends ChessComponent{
    public RookChessComponent() {
    }
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Rook=new ArrayList<>();
        for (int i=1;i<=7;i++){
            if (getSource().getY()+i>7){
                break;
            }
            Rook.add(new ChessboardPoint(getSource().getX(), getSource().getY()+i));
            if (ChessBoard[getSource().getX()][getSource().getY()+i].getChessColor()==this.getChessColor()){
                Rook.remove(Rook.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()][getSource().getY()+i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getY()-i<0){
                break;
            }
            Rook.add(new ChessboardPoint(getSource().getX(), getSource().getY()-i));
            if (ChessBoard[getSource().getX()][getSource().getY()-i].getChessColor()==this.getChessColor()){
                Rook.remove(Rook.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()][getSource().getY()-i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getX()+i>7){
                break;
            }
            Rook.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()));
            if (ChessBoard[getSource().getX()+i][getSource().getY()].getChessColor()==this.getChessColor()){
                Rook.remove(Rook.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()+i][getSource().getY()].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getX()-i<0){
                break;
            }
            Rook.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()));
            if (ChessBoard[getSource().getX()-i][getSource().getY()].getChessColor()==this.getChessColor()){
                Rook.remove(Rook.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()-i][getSource().getY()].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        return Rook;
    }
}







class BishopChessComponent extends ChessComponent{
    public BishopChessComponent() {
    }
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Bishop=new ArrayList<>();
        for (int i=1;i<=7;i++){
            if (getSource().getX()+i>7||getSource().getY()+i>7){
                break;
            }
            Bishop.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()+i));
            if (ChessBoard[getSource().getX()+i][getSource().getY()+i].getChessColor()==this.getChessColor()){
                Bishop.remove(Bishop.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()+i][getSource().getY()+i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getX()-i<0||getSource().getY()-i<0){
                break;
            }
            Bishop.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()-i));
            if (ChessBoard[getSource().getX()-i][getSource().getY()-i].getChessColor()==this.getChessColor()){
                Bishop.remove(Bishop.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()-i][getSource().getY()-i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getX()+i>7||getSource().getY()-i<0){
                break;
            }
            Bishop.add(new ChessboardPoint(getSource().getX()+i, getSource().getY()-i));
            if (ChessBoard[getSource().getX()+i][getSource().getY()-i].getChessColor()==this.getChessColor()){
                Bishop.remove(Bishop.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()+i][getSource().getY()-i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }
        for (int i=1;i<=7;i++){
            if (getSource().getX()-i<0||getSource().getY()+i>7){
                break;
            }
            Bishop.add(new ChessboardPoint(getSource().getX()-i, getSource().getY()+i));
            if (ChessBoard[getSource().getX()-i][getSource().getY()+i].getChessColor()==this.getChessColor()){
                Bishop.remove(Bishop.size()-1);
                break;
            }
            if (ChessBoard[getSource().getX()-i][getSource().getY()+i].getChessColor()==ChessColor.NONE){

            }else {
                break;
            }
        }

        return Bishop;
    }
}








class KnightChessComponent extends ChessComponent{
    public KnightChessComponent() {
    }
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public void judge(List<ChessboardPoint> a){
        for (int i=0;i<a.size();i++){
            if (ChessBoard[a.get(i).getX()][a.get(i).getY()].getChessColor()==this.getChessColor()){
                a.remove(i);
                i--;
            }
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> Knight=new ArrayList<>();
        Knight.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()+2));
        Knight.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()+2));
        Knight.add(new ChessboardPoint(this.getSource().getX()+2,this.getSource().getY()+1));
        Knight.add(new ChessboardPoint(this.getSource().getX()+2,this.getSource().getY()-1));
        Knight.add(new ChessboardPoint(this.getSource().getX()+1,this.getSource().getY()-2));
        Knight.add(new ChessboardPoint(this.getSource().getX()-1,this.getSource().getY()-2));
        Knight.add(new ChessboardPoint(this.getSource().getX()-2,this.getSource().getY()+1));
        Knight.add(new ChessboardPoint(this.getSource().getX()-2,this.getSource().getY()-1));
        CreateComponent.judge(Knight);
        judge(Knight);
        return Knight;
    }
}








class PawnChessComponent extends ChessComponent{
    public PawnChessComponent() {
    }
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {

        if (getChessColor()==ChessColor.BLACK){
            ArrayList<ChessboardPoint> Pawn=new ArrayList<>();
            if (getSource().getX()==1) {
                for (int i = 1; i <= 2; i++) {

                    Pawn.add(new ChessboardPoint(getSource().getX()+i, getSource().getY() ));
                    if (ChessBoard[getSource().getX()+ i][getSource().getY() ].getChessColor() == this.getChessColor()) {
                        Pawn.remove(Pawn.size()-1);
                        break;
                    }
                    if (ChessBoard[getSource().getX()+ i][getSource().getY() ].getChessColor() == ChessColor.NONE) {

                    } else {
                        Pawn.remove(Pawn.size()-1);
                        break;
                    }
                }
                if (getSource().getY() - 1 > 0) {
                    if (ChessBoard[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                        Pawn.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
                    }
                }
                if (getSource().getY() + 1 < 7) {
                    if (ChessBoard[getSource().getX() + 1][getSource().getY() + 1].getChessColor() == ChessColor.WHITE) {
                        Pawn.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                }
            }else {
                Pawn.add(new ChessboardPoint(getSource().getX()+ 1, getSource().getY() ));
                if (ChessBoard[getSource().getX()+1][getSource().getY() ].getChessColor() == this.getChessColor()) {
                    Pawn.remove(Pawn.size()-1);
                }
                if (ChessBoard[getSource().getX()+1][getSource().getY() ].getChessColor() == ChessColor.NONE) {

                } else {
                    Pawn.remove(Pawn.size()-1);
                }
                if (getSource().getY() - 1 > 0&&getSource().getX() + 1<7) {
                    if (ChessBoard[getSource().getX() + 1][getSource().getY() - 1].getChessColor() == ChessColor.WHITE) {
                        Pawn.add(new ChessboardPoint(getSource().getX() +1, getSource().getY() - 1));
                    }
                }
                if (getSource().getX() + 1 < 7&&getSource().getY() + 1<7) {
                    if (ChessBoard[getSource().getX() + 1][getSource().getY() +1 ].getChessColor() == ChessColor.WHITE) {
                        Pawn.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() + 1));
                    }
                }
            }
            return Pawn;
        }
        if (getChessColor()==ChessColor.WHITE){
            ArrayList<ChessboardPoint> Pawn=new ArrayList<>();
            if (getSource().getX()==6) {
                for (int i = 1; i <= 2; i++) {

                    Pawn.add(new ChessboardPoint(getSource().getX()-i, getSource().getY() ));
                    if (ChessBoard[getSource().getX()- i][getSource().getY() ].getChessColor() == this.getChessColor()) {
                        Pawn.remove(Pawn.size()-1);
                        break;
                    }
                    if (ChessBoard[getSource().getX()- i][getSource().getY() ].getChessColor() == ChessColor.NONE) {

                    } else {
                        Pawn.remove(Pawn.size()-1);
                        break;
                    }
                }
                if (getSource().getY() - 1 > 0) {
                    if (ChessBoard[getSource().getX() - 1][getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                        Pawn.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                }
                if (getSource().getY() + 1 < 7) {
                    if (ChessBoard[getSource().getX() - 1][getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                        Pawn.add(new ChessboardPoint(getSource().getX() -1, getSource().getY() + 1));
                    }
                }
            }else {
                Pawn.add(new ChessboardPoint(getSource().getX()-1, getSource().getY() ));
                if (ChessBoard[getSource().getX()-1][getSource().getY() ].getChessColor() == this.getChessColor()) {
                    Pawn.remove(Pawn.size()-1);
                }
                if (ChessBoard[getSource().getX()-1][getSource().getY() ].getChessColor() == ChessColor.NONE) {

                } else {
                    Pawn.remove(Pawn.size()-1);
                }
                if (getSource().getX() -1>0&&getSource().getY() - 1>0) {
                    if (ChessBoard[getSource().getX() - 1][getSource().getY() - 1].getChessColor() == ChessColor.BLACK) {
                        Pawn.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
                    }
                }
                if (getSource().getX() - 1 >0&&getSource().getY() + 1<7) {
                    if (ChessBoard[getSource().getX() - 1][getSource().getY() + 1].getChessColor() == ChessColor.BLACK) {
                        Pawn.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
                    }
                }
            }
            return Pawn;
        }
         return new ArrayList<>();
    }
}






class EmptySlotComponent extends ChessComponent{
    public EmptySlotComponent() {
    }

    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}


