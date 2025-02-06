import java.util.ArrayList;
import java.util.List;

public class RookChessComponent extends ChessComponent{
        public RookChessComponent(int x,int y, ChessColor color) {
            super();
            super.setSource(new ChessboardPoint(x,y));
            super.setChessColor(color);
            if(color.equals(ChessColor.WHITE)){
                name='r';}
            else if(color.equals(ChessColor.BLACK)){
                name='R';
            }
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> r=new ArrayList<>();
            for(int i=1;i<8;i++) {
                if ( super.getSource().getX()+i <= 7) {
                    if (!chessComponent[super.getSource().getX() + i][super.getSource().getY()].getChessColor().equals(super.getChessColor())&&!chessComponent[super.getSource().getX() + i][super.getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                        r.add(new ChessboardPoint(super.getSource().getX() + i, super.getSource().getY()));
                        break;
                    }
                    else if(chessComponent[super.getSource().getX()+i][super.getSource().getY()].getChessColor().equals(ChessColor.NONE)){
                        r.add(new ChessboardPoint(super.getSource().getX() + i, super.getSource().getY()));
                    }
                    else {
                        break;
                    }
                }
            }
            for(int i=1;i<8;i++) {
                if (super.getSource().getX() - i >= 0) {
                    if (!chessComponent[super.getSource().getX() - i][super.getSource().getY()].getChessColor().equals(super.getChessColor()) && !chessComponent[super.getSource().getX() - i][super.getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                        r.add(new ChessboardPoint(super.getSource().getX() - i, super.getSource().getY()));
                        break;
                    } else if (chessComponent[super.getSource().getX() - i][super.getSource().getY()].getChessColor().equals(ChessColor.NONE)) {
                        r.add(new ChessboardPoint(super.getSource().getX() - i, super.getSource().getY()));
                    } else {
                        break;
                    }
                }
            }
            for(int i=1;i<8;i++) {
                if ( super.getSource().getY()+i <= 7) {
                    if (!chessComponent[super.getSource().getX()][super.getSource().getY() + i].getChessColor().equals(super.getChessColor()) && !chessComponent[super.getSource().getX() ][super.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                        r.add(new ChessboardPoint(super.getSource().getX(), super.getSource().getY() + i));
                        break;
                    } else if (chessComponent[super.getSource().getX()][super.getSource().getY() + i].getChessColor().equals(ChessColor.NONE)) {
                        r.add(new ChessboardPoint(super.getSource().getX(), super.getSource().getY() + i));
                    } else {
                        break;
                    }
                }
            }
            for(int i=1;i<8;i++) {
                if ( super.getSource().getY()-i >=0) {
                    if (!chessComponent[super.getSource().getX()][super.getSource().getY() - i].getChessColor().equals(super.getChessColor()) && !chessComponent[super.getSource().getX()][super.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                        r.add(new ChessboardPoint(super.getSource().getX(), super.getSource().getY() - i));
                        break;
                    } else if (chessComponent[super.getSource().getX() ][super.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                        r.add(new ChessboardPoint(super.getSource().getX() , super.getSource().getY() - i));
                    } else {
                        break;
                    }
                }
            }
            r.remove(new ChessboardPoint(super.getSource().getX(),super.getSource().getY()));
            return r;
        }
}
