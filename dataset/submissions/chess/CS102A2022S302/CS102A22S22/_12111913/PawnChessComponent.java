

import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    @Override
    public List<ChessboardPoint> canMoveTo() {
        boolean sta=false;
        List<ChessboardPoint> ans= new ArrayList<>();
        if (this.getSource().getX()==1&&this.getChessColor()==ChessColor.BLACK){sta=true;}
        if (this.getSource().getX()==6&&this.getChessColor()==ChessColor.WHITE){sta=true;}
        if (sta&&this.getChessColor()==ChessColor.WHITE){
            for (int i=0;i<8;i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.getSource().getX() - i == 1 && this.getSource().getY() - j == 0&&getChess(i,j).getChessColor()==ChessColor.NONE) {
                        ans.add(getChess(i, j).getSource());
                    }
                    if (this.getSource().getX() - i == 2 && this.getSource().getY() - j == 0&&getChess(i,j).getChessColor()==ChessColor.NONE) {
                        ans.add(getChess(i, j).getSource());
                    }
                    if (this.getSource().getX() - i == 1 && this.getSource().getY() - j == -1&&this.IsEnemy(getChess(i,j))) {
                        ans.add(getChess(i, j).getSource());
                    }
                    if (this.getSource().getX() - i == 1 && this.getSource().getY() - j == +1&&this.IsEnemy(getChess(i,j))) {
                        ans.add(getChess(i, j).getSource());
                    }
                }
            }
        }

        if (sta&&this.getChessColor()==ChessColor.BLACK){
            for (int i=0;i<8;i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.getSource().getX() - i == -1 && this.getSource().getY() - j == 0&&getChess(i,j).getChessColor()==ChessColor.NONE) {
                        ans.add(getChess(i, j).getSource());
                    }
                    if (this.getSource().getX() - i == -2 && this.getSource().getY() - j == 0&&getChess(i,j).getChessColor()==ChessColor.NONE) {
                        ans.add(getChess(i, j).getSource());
                    }
                    if (this.getSource().getX() - i == -1 && this.getSource().getY() - j == -1&&this.IsEnemy(getChess(i,j))) {
                        ans.add(getChess(i, j).getSource());
                    }
                    if (this.getSource().getX() - i == -1 && this.getSource().getY() - j == +1&&this.IsEnemy(getChess(i,j))) {
                        ans.add(getChess(i, j).getSource());
                    }
                }
            }
        }

        if (!sta&&this.getChessColor()==ChessColor.WHITE){
            for (int i=0;i<8;i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.getSource().getX() - i == 1 && this.getSource().getY() - j == 0&&getChess(i,j).getChessColor()==ChessColor.NONE) {
                        ans.add(getChess(i, j).getSource());
                    }
                    if (this.getSource().getX() - i == 1 && this.getSource().getY() - j == -1&&this.IsEnemy(getChess(i,j))) {
                        ans.add(getChess(i, j).getSource());
                    }
                    if (this.getSource().getX() - i == 1 && this.getSource().getY() - j == +1&&this.IsEnemy(getChess(i,j))) {
                        ans.add(getChess(i, j).getSource());
                    }
                }
            }
        }

        if (!sta&&this.getChessColor()==ChessColor.BLACK){
            for (int i=0;i<8;i++) {
                for (int j = 0; j < 8; j++) {
                    if (this.getSource().getX() - i == -1 && this.getSource().getY() - j == 0&&getChess(i,j).getChessColor()==ChessColor.NONE) {
                        ans.add(getChess(i, j).getSource());
                    }
                    if (this.getSource().getX() - i == -1 && this.getSource().getY() - j == -1&&this.IsEnemy(getChess(i,j))) {
                        ans.add(getChess(i, j).getSource());
                    }
                    if (this.getSource().getX() - i == -1 && this.getSource().getY() - j == +1&&this.IsEnemy(getChess(i,j))) {
                        ans.add(getChess(i, j).getSource());
                    }
                }
            }
        }

        return ans;
    }
  }
