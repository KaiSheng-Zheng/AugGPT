import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {

    public List<ChessboardPoint> canMoveTo() {
        int x= getSource().getX();
        int y= getSource().getY();
        if (this.chessComponents[x][y].name == 'b' || this.chessComponents[x][y].name == 'B') {
            ArrayList<ChessboardPoint> b = new ArrayList<>();
            if (x - 1 < 0) {
                if (y - 1 < 0) {
                    for (int i = 1; i < 8; i++) {
                        if (this.chessComponents[x + i][y + i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x + i, y + i));
                        } else if (this.chessComponents[x + i][y + i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x + i, y + i));
                            break;
                        } else {
                            break;
                        }
                    }
                } else if (y - 1 >= 0 && y + 1 <= 7) {
                    for (int i = 1; i < 8 - y; i++) {
                        if (this.chessComponents[x + i][y + i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x + i, y + i));
                        } else if (this.chessComponents[x + i][y + i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x + i, y + i));
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; i <= y; i++) {
                        if (this.chessComponents[x + i][y - i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x + i, y - i));
                        } else if (this.chessComponents[x + i][y - i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x + i, y - i));
                            break;
                        } else {
                            break;
                        }
                    }
                } else {
                    for (int i = 1; i < 8; i++) {
                        if (this.chessComponents[x + i][y - i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x + i, y - i));
                        } else if (this.chessComponents[x + i][y - i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x + i, y - i));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            } else if (x - 1 >= 0 && x + 1 <= 7) {
                if (y - 1 < 0) {
                    for (int i = 1; i < 8 - x; i++) {
                        if (this.chessComponents[x + i][y + i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x + i, y + i));
                        } else if (this.chessComponents[x + i][y - i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x + i, y + i));
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; i <= x; i++) {
                        if (this.chessComponents[x - i][y + i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x - i, y + i));
                        } else if (this.chessComponents[x - i][y + i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x - i, y + i));
                            break;
                        } else {
                            break;
                        }
                    }
                } else if (y - 1 >= 0 && y + 1 <= 7) {
                    for (int i = 1; i < 8; i++) {
                        if (x + i > 7 || y - i < 0) {
                            break;
                        } else {
                            if (this.chessComponents[x + i][y - i].getChessColor() == ChessColor.NONE) {
                                b.add(new ChessboardPoint(x + i, y - i));
                            } else if (this.chessComponents[x + i][y - i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                                b.add(new ChessboardPoint(x + i, y - i));
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                    for (int i = 1; i <8; i++) {
                        if (x - i < 0 || y + i > 7) {
                            break;
                        } else {
                            if (this.chessComponents[x - i][y + i].getChessColor() == ChessColor.NONE) {
                                b.add(new ChessboardPoint(x - i, y + i));
                            } else if (this.chessComponents[x - i][y + i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                                b.add(new ChessboardPoint(x - i, y + i));
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                    for (int i = 1; i < 8 ; i++) {
                        if (x + i > 7 || y + i > 7) {
                            break;
                        } else {
                            if (this.chessComponents[x + i][y + i].getChessColor() == ChessColor.NONE) {
                                b.add(new ChessboardPoint(x + i, y + i));
                            } else if (this.chessComponents[x + i][y + i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                                b.add(new ChessboardPoint(x + i, y + i));
                                break;
                            } else {
                                break;
                            }
                        }
                    }
                    for (int i = 1; i <8; i++) {
                        if (x - i < 0 || y - i < 0) {
                            break;
                        } else {
                            if (this.chessComponents[x - i][y - i].getChessColor() == ChessColor.NONE) {
                                b.add(new ChessboardPoint(x - i, y - i));
                            } else if (this.chessComponents[x - i][y - i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                                b.add(new ChessboardPoint(x - i, y - i));
                                break;
                            } else {
                                break;
                            }
                        }
                    }

                } else {
                    for (int i = 1; i < 8 - x; i++) {
                        if (this.chessComponents[x + i][y - i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x + i, y - i));
                        } else if (this.chessComponents[x + i][y - i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x + i, y - i));
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; i <= x; i++) {
                        if (this.chessComponents[x - i][y - i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x - i, y - i));
                        } else if (this.chessComponents[x - i][y + i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x - i, y - i));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }else{
                if (y-1<0){
                    for (int i=1;i<8;i++){
                        if (this.chessComponents[x - i][y + i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x - i, y +i));
                        } else if (this.chessComponents[x - i][y + i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x - i, y + i));
                            break;
                        } else {
                            break;
                        }
                    }
                }else if (y-1>=0&&y+1<=7){
                    for (int i = 1; i < 8 - y; i++) {
                        if (this.chessComponents[x - i][y + i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x - i, y + i));
                        } else if (this.chessComponents[x - i][y + i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x - i, y + i));
                            break;
                        } else {
                            break;
                        }
                    }
                    for (int i = 1; i <= y; i++) {
                        if (this.chessComponents[x - i][y - i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x - i, y - i));
                        } else if (this.chessComponents[x - i][y - i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x - i, y - i));
                            break;
                        } else {
                            break;
                        }
                    }

                }else{
                    for (int i = 1; i <8; i++) {
                        if (this.chessComponents[x - i][y - i].getChessColor() == ChessColor.NONE) {
                            b.add(new ChessboardPoint(x - i, y - i));
                        } else if (this.chessComponents[x - i][y - i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                            b.add(new ChessboardPoint(x - i, y - i));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            return b;
            }
        else {
                    return new ArrayList<>();
                }
    }
}