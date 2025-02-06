import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x= getSource().getX();
        int y= getSource().getY();
        ArrayList<ChessboardPoint>b=new ArrayList<>();
        if (chessComponents[x][y].name == 'q' || chessComponents[x][y].name == 'Q') {
            if (x - 1 < 1) {
                for (int i = x + 1; i <8; i++) {
                    if (this.chessComponents[i][y].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(i, y));
                    } else if (this.chessComponents[i][y].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(i, y));
                        break;
                    } else {
                        break;
                    }
                }
            } else if (x - 1 >= 1 && x + 1 <= 8) {
                for (int i = x - 1; i >= 0; i--) {
                    if (this.chessComponents[i][y].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(i, y));
                    } else if (this.chessComponents[i][y].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(i, y));
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = x + 1; i < 8; i++) {
                    if (this.chessComponents[i][y].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(i, y));
                    } else if (this.chessComponents[i][y].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(i, y));
                        break;
                    } else {
                        break;
                    }
                }
            } else {
                for (int i = x - 1; i >= 0; i--) {
                    if (this.chessComponents[i][y].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(i, y));
                    } else if (this.chessComponents[i][y].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(i, y));
                        break;
                    } else {
                        break;
                    }
                }
            }
            if (y - 1 < 0) {
                for (int i = y + 1; i < 8; i++) {
                    if (this.chessComponents[x][i].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(x, i));
                    } else if (this.chessComponents[x][i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(x, i));
                        break;
                    } else {
                        break;
                    }
                }
            } else if (y - 1 >= 0 && y + 1 <=7) {
                for (int i = y - 1; i >= 0; i--) {
                    if (this.chessComponents[x][i].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(x, i));
                    } else if (this.chessComponents[x][i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(x, i));
                        break;
                    } else {
                        break;
                    }
                }
                for (int i = y + 1; i < 8; i++) {
                    if (this.chessComponents[x][i].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(x, i));
                    } else if (this.chessComponents[x][i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(x, i));
                        break;
                    } else {
                        break;
                    }
                }
            } else {
                for (int i = y-1; i >=0; i--) {
                    if (this.chessComponents[x][i].getChessColor() == ChessColor.NONE) {
                        b.add(new ChessboardPoint(x, i));
                    } else if (this.chessComponents[x][i].getChessColor() != this.chessComponents[x][y].getChessColor()) {
                        b.add(new ChessboardPoint(x, i));
                        break;
                    } else {
                        break;
                    }
                }

            }
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

        } else {
            return new ArrayList<>();
        }
    }
}
