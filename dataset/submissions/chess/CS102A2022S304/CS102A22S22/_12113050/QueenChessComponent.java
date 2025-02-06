import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{
        public QueenChessComponent(ChessboardPoint source,ChessColor chessColor) {
            super();
            setSource(source);
            setChessColor(chessColor);
            if (chessColor==ChessColor.WHITE){
                name='q';
            }else {
                name='Q';
            }
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            List<ChessboardPoint> Queen = new ArrayList<>();
            ChessComponent[][] a=getChessComponents();
            for (int i = 1; i < 8; i++) {
                if (getSource().getX() + i <= 7&&getSource().getY()+i<=7) {
                    if (a[getSource().getX() + i ][getSource().getY()+i].getChessColor()==ChessColor.NONE){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() + i ,getSource().getY()+i);
                        Queen.add(n);
                    }
                    else if (a[getSource().getX() + i ][getSource().getY()+i].getChessColor()==this.getChessColor()){
                        break;
                    }
                    else if (a[getSource().getX() + i ][getSource().getY()+i].getChessColor()!=this.getChessColor()){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() + i ,getSource().getY()+i);
                        Queen.add(n);
                        break;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (getSource().getX() + i <= 7&&getSource().getY()-i>=0) {
                    if (a[getSource().getX() + i ][getSource().getY()-i] .getChessColor()==ChessColor.NONE){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() + i ,getSource().getY()-i);
                        Queen.add(n);
                    }
                    else if (a[getSource().getX() + i ][getSource().getY()-i].getChessColor()==this.getChessColor()){
                        break;
                    }
                    else if (a[getSource().getX() + i ][getSource().getY()-i].getChessColor()!=this.getChessColor()){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() + i ,getSource().getY()-i);
                        Queen.add(n);
                        break;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (getSource().getX() -i >=0&&getSource().getY()-i>=0) {
                    if (a[getSource().getX() - i ][getSource().getY()-i].getChessColor()==ChessColor.NONE){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY()-i);
                        Queen.add(n);
                    }
                    else if (a[getSource().getX() - i ][getSource().getY()-i].getChessColor()==this.getChessColor()){
                        break;
                    }
                    else if (a[getSource().getX() - i ][getSource().getY()-i].getChessColor()!=this.getChessColor()){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY()-i);
                        Queen.add(n);
                        break;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (getSource().getX() - i >= 0&&getSource().getY()+i<=7) {
                    if (a[getSource().getX() - i ][getSource().getY()+i].getChessColor()==ChessColor.NONE){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY()+i);
                        Queen.add(n);
                    } else if (a[getSource().getX() - i ][getSource().getY()+i].getChessColor()==this.getChessColor()){
                        break;
                    } else if (a[getSource().getX() - i ][getSource().getY()+i].getChessColor()!=this.getChessColor()){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY()+i);
                        Queen.add(n);
                        break;
                    }
                }
            }
            for (int i = 1; i < 8; i++) {
                if (getSource().getX() + i <= 7) {
                    if (a[getSource().getX() + i ][getSource().getY()].getChessColor()==ChessColor.NONE){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() + i,getSource().getY());
                        Queen.add(n);
                    }
                    else {
                        if (a[getSource().getX() + i ][getSource().getY()].getChessColor()!=this.getChessColor()){
                            ChessboardPoint n = new ChessboardPoint(getSource().getX() + i ,getSource().getY());
                            Queen.add(n);
                            break;
                        }
                       break;
                    }

                }
            }
            for (int i = 1; i < 8; i++) {
                if (getSource().getY()-i>=0) {
                    if (a[getSource().getX()][getSource().getY()-i].getChessColor()==ChessColor.NONE){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() ,getSource().getY()-i);
                        Queen.add(n);
                    }
                    else{
                        if (a[getSource().getX()][getSource().getY()-i].getChessColor()!=this.getChessColor()){
                            ChessboardPoint n = new ChessboardPoint(getSource().getX(),getSource().getY()-i);
                            Queen.add(n);
                            break;}

                        break;
                    }

                }
            }
            for (int i = 1; i < 8; i++) {
                if (getSource().getX() -i >=0) {
                    if (a[getSource().getX() - i ][getSource().getY()] .getChessColor()==ChessColor.NONE){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY());
                        Queen.add(n);
                    }
                    else {
                        if (a[getSource().getX() - i ][getSource().getY()].getChessColor()!=this.getChessColor()){
                            ChessboardPoint n = new ChessboardPoint(getSource().getX() - i ,getSource().getY());
                            Queen.add(n);
                            break;
                        }
                        break;
                    }

                }
            }
            for (int i = 1; i < 8; i++) {
                if (getSource().getY()+i<=7) {
                    if (a[getSource().getX() ][getSource().getY()+i].getChessColor()==ChessColor.NONE){
                        ChessboardPoint n = new ChessboardPoint(getSource().getX() ,getSource().getY()+i);
                        Queen.add(n);
                    } else {
                        if (a[getSource().getX()][getSource().getY()+i].getChessColor()!=this.getChessColor()){
                            ChessboardPoint n = new ChessboardPoint(getSource().getX()  ,getSource().getY()+i);
                            Queen.add(n);
                            break;
                        }
                        break;
                    }
                }
            }
            return Queen;

        }
    }
