import java.util.ArrayList;
import java.util.List;

public class KnightChessComponent extends ChessComponent{
        public KnightChessComponent(int x,int y, ChessColor color) {
            super();
            super.setSource(new ChessboardPoint(x,y));
            super.setChessColor(color);
            if(color.equals(ChessColor.WHITE)){
                name='n';}
            else if(color.equals(ChessColor.BLACK)){
                name='N';
            }
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> n=new ArrayList<>();
            if(super.getSource().getX()+2<=7&&super.getSource().getY()+1<=7){
                if(!chessComponent[super.getSource().getX()+2][super.getSource().getY()+1].getChessColor().equals(super.getChessColor())){
                n.add(new ChessboardPoint(super.getSource().getX()+2,super.getSource().getY()+1));}
            }
            if(super.getSource().getX()+2<=7&&super.getSource().getY()-1>=0) {
                if(!chessComponent[super.getSource().getX()+2][super.getSource().getY()-1].getChessColor().equals(super.getChessColor())){
                    n.add(new ChessboardPoint(super.getSource().getX() + 2, super.getSource().getY() - 1));
                }
            }
            if(super.getSource().getX()-2>=0&&super.getSource().getY()+1<=7){
                if(!chessComponent[super.getSource().getX()-2][super.getSource().getY()+1].getChessColor().equals(super.getChessColor())){
                    n.add(new ChessboardPoint(super.getSource().getX()-2,super.getSource().getY()+1)); }

            }
            if(super.getSource().getX()-2>=0&&super.getSource().getY()-1>=0){
                if(!chessComponent[super.getSource().getX()-2][super.getSource().getY()-1].getChessColor().equals(super.getChessColor())){
                    n.add(new ChessboardPoint(super.getSource().getX()-2,super.getSource().getY()-1));}

            }
            if(super.getSource().getX()+1<=7&&super.getSource().getY()+2<=7) {
                if(!chessComponent[super.getSource().getX()+1][super.getSource().getY()+2].getChessColor().equals(super.getChessColor())){
                    n.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() + 2));
                }
            }
            if(super.getSource().getX()+1<=7&&super.getSource().getY()-2>=0) {
                if(!chessComponent[super.getSource().getX()+1][super.getSource().getY()-2].getChessColor().equals(super.getChessColor())){
                    n.add(new ChessboardPoint(super.getSource().getX() + 1, super.getSource().getY() - 2));
                }
            }
            if(super.getSource().getX()-1>=0&&super.getSource().getY()+2<=7) {
                if(!chessComponent[super.getSource().getX()-1][super.getSource().getY()+2].getChessColor().equals(super.getChessColor())){
                    n.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() + 2));
                }
            }
            if(super.getSource().getX()-1>=0&&super.getSource().getY()-2>=0) {
                if(!chessComponent[super.getSource().getX()-1][super.getSource().getY()-2].getChessColor().equals(super.getChessColor())){
                    n.add(new ChessboardPoint(super.getSource().getX() - 1, super.getSource().getY() - 2));
                }
            }
            return n;
        }
}
