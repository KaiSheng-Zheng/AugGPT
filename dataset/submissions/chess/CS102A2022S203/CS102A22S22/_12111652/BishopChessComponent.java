import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent{
        public BishopChessComponent(int x,int y, ChessColor color) {
            super();
            super.setSource(new ChessboardPoint(x,y));
            super.setChessColor(color);
            if(color.equals(ChessColor.WHITE)){
                name='b';}
            else if(color.equals(ChessColor.BLACK)){
                name='B';
            }
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> b=new ArrayList<>();
            for(int i=1;i<8;i++) {
                if (super.getSource().getX() + i >= 0 && super.getSource().getX() + i <= 7 && super.getSource().getY() + i >= 0 && super.getSource().getY() + i <= 7) {
                    if (chessComponent[super.getSource().getX() + i][super.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                        b.add(new ChessboardPoint(super.getSource().getX() + i, super.getSource().getY() + i));
                    }else if(!chessComponent[super.getSource().getX() + i][super.getSource().getY()+i].getChessColor().equals(super.getChessColor())){
                        b.add(new ChessboardPoint(super.getSource().getX() + i, super.getSource().getY() + i));
                        break;
                    }else{
                        break;
                    }
                }
            }
            for(int i=1;i<8;i++) {
                if (super.getSource().getX() + i >= 0 && super.getSource().getX() + i <= 7 && super.getSource().getY() - i >= 0 && super.getSource().getY() - i <= 7) {
                    if (chessComponent[super.getSource().getX() + i][super.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                        b.add(new ChessboardPoint(super.getSource().getX() + i, super.getSource().getY() - i));
                    }else if(!chessComponent[super.getSource().getX() + i][super.getSource().getY()-i].getChessColor().equals(super.getChessColor())){
                        b.add(new ChessboardPoint(super.getSource().getX() + i, super.getSource().getY() - i));
                        break;
                    }else{
                        break;
                    }
                }
            }
            for(int i=1;i<8;i++) {
                if (super.getSource().getX() - i >= 0 && super.getSource().getX() - i <= 7 && super.getSource().getY() + i >= 0 && super.getSource().getY() + i <= 7) {
                    if (chessComponent[super.getSource().getX() - i][super.getSource().getY()+i].getChessColor().equals(ChessColor.NONE)) {
                        b.add(new ChessboardPoint(super.getSource().getX() - i, super.getSource().getY() + i));
                    }else if(!chessComponent[super.getSource().getX() - i][super.getSource().getY()+i].getChessColor().equals(super.getChessColor())){
                        b.add(new ChessboardPoint(super.getSource().getX() - i, super.getSource().getY() + i));
                        break;
                    }else{
                        break;
                    }
                }
            }
            for(int i=1;i<8;i++) {
                if (super.getSource().getX() - i >= 0 && super.getSource().getX() - i <= 7 && super.getSource().getY() - i >= 0 && super.getSource().getY() - i <= 7) {
                    if (chessComponent[super.getSource().getX() - i][super.getSource().getY()-i].getChessColor().equals(ChessColor.NONE)) {
                        b.add(new ChessboardPoint(super.getSource().getX() - i, super.getSource().getY() - i));
                    }else if(!chessComponent[super.getSource().getX() - i][super.getSource().getY()-i].getChessColor().equals(super.getChessColor())){
                        b.add(new ChessboardPoint(super.getSource().getX() - i, super.getSource().getY() - i));
                        break;
                    }else{
                        break;
                    }
                }
            }
            return b;
        }

}
