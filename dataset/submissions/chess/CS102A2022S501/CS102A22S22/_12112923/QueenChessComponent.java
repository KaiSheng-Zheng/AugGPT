import java.util.ArrayList;
import java.util.List;

public class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint chessboardPoint, ChessColor chessColor, char name) {
        super(chessboardPoint, chessColor, name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint>canMove=new ArrayList<>();
        ChessComponent[][] a = super.getChessComponents();
        ChessColor color = super.getChessColor();
        int row = super.getSource().getX();
        int col = super.getSource().getY();
        if (color == ChessColor.BLACK) {
            if(col-1>=0) {
                for (int i = col - 1; i >= 0; i--) {
                    if (a[row][i].getChessColor() == ChessColor.NONE) {
                        canMove.add(new ChessboardPoint(row, i));
                    }
                    if (a[row][i].getChessColor() != ChessColor.NONE) {
                        if (a[row][i].getChessColor() == ChessColor.WHITE) {
                            canMove.add(new ChessboardPoint(row, i));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if(col+1<8) {
                for (int i = col + 1; i < 8; i++) {
                    if (a[row][i].name == '_') {
                        canMove.add(new ChessboardPoint(row, i));
                    }
                    if (a[row][i].name != '_') {
                        if (a[row][i].getChessColor() == ChessColor.WHITE) {
                            canMove.add(new ChessboardPoint(row, i));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if(row-1>=0) {
                for (int i = row - 1; i >= 0; i--) {
                    if (a[i][col].name == '_') {
                        canMove.add(new ChessboardPoint(i, col));
                    }
                    if (a[i][col].name != '_') {
                        if (a[i][col].getChessColor() == ChessColor.WHITE) {
                            canMove.add(new ChessboardPoint(i, col));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if(row+1<8) {
                for (int i = row + 1; i < 8; i++) {
                    if (a[i][col].name == '_') {
                        canMove.add(new ChessboardPoint(i, col));
                    }
                    if (a[i][col].name != '_') {
                        if (a[i][col].getChessColor() == ChessColor.WHITE) {
                            canMove.add(new ChessboardPoint(i, col));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if(Math.max(col,row)<7) {
                for (int i = 1; i < 8 - Math.max(col, row); i++) {
                    if (a[row + i][col + i].name == '_') {
                        canMove.add(new ChessboardPoint((row + i), (col + i)));
                    } else {
                        if (a[row + i][col + i].getChessColor() == ChessColor.WHITE) {
                            canMove.add(new ChessboardPoint((row + i), (col + i)));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if(Math.min(col,row)>=1) {
                for (int i = 1; i <= Math.min(col, row); i++) {
                    if (a[row - i][col - i].name == '_') {
                        canMove.add(new ChessboardPoint((row - i), (col - i)));
                    } else {
                        if (a[row - i][col - i].getChessColor() == ChessColor.WHITE) {
                            canMove.add(new ChessboardPoint((row - i), (col - i)));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if(Math.min(7-row,col)>=1) {
                for (int i = 1; i <= Math.min(7 - row, col); i++) {
                    if (a[row + i][col - i].name == '_') {
                        canMove.add(new ChessboardPoint((row + i), (col - i)));
                    } else {
                        if (a[row + i][col - i].getChessColor() == ChessColor.WHITE) {
                            canMove.add(new ChessboardPoint((row + i), (col - i)));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if(Math.min(row,7-col)>=1) {
                for (int i = 1; i <= Math.min(row, (7 - col)); i++) {
                    if (a[row - i][col + i].name == '_') {
                        canMove.add(new ChessboardPoint((row - i), (col + i)));
                    } else {
                        if (a[row - i][col + i].getChessColor() == ChessColor.WHITE) {
                            canMove.add(new ChessboardPoint((row - i), (col + i)));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }else {
            if (col - 1 >= 0) {
                for (int i = col - 1; i >= 0; i--) {
                    if (a[row][i].name == '_') {
                        canMove.add(new ChessboardPoint(row, i));
                    }
                    if (a[row][i].name != '_') {
                        if (a[row][i].getChessColor() == ChessColor.BLACK) {
                            canMove.add(new ChessboardPoint(row, i));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (col + 1 < 8) {
                for (int i = col+1; i < 8; i++) {
                    if (a[row][i].name == '_') {
                        canMove.add(new ChessboardPoint(row, i));
                    }
                    if (a[row][i].name != '_') {
                        if (a[row][i].getChessColor() == ChessColor.BLACK) {
                            canMove.add(new ChessboardPoint(row, i));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (row - 1 >= 0) {
                for (int i = row - 1; i >= 0; i--) {
                    if (a[i][col].name == '_') {
                        canMove.add(new ChessboardPoint(i, col));
                    }
                    if (a[i][col].name != '_') {
                        if (a[i][col].getChessColor() == ChessColor.BLACK) {
                            canMove.add(new ChessboardPoint(i, col));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (row + 1 < 8) {
                for (int i = row + 1; i < 8; i++) {
                    if (a[i][col].name == '_') {
                        canMove.add(new ChessboardPoint(i, col));
                    }
                    if (a[i][col].name != '_') {
                        if (a[i][col].getChessColor() == ChessColor.BLACK) {
                            canMove.add(new ChessboardPoint(i, col));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (Math.max(col, row) < 7) {
                for (int i = 1; i < 8 - Math.max(col, row); i++) {
                    if (a[row + i][col + i].name == '_') {
                        canMove.add(new ChessboardPoint((row + i), (col + i)));
                    } else {
                        if (a[row + i][col + i].getChessColor() == ChessColor.BLACK) {
                            canMove.add(new ChessboardPoint((row + i), (col + i)));
                            break;
                        } else {
                            ;
                            break;
                        }
                    }
                }
            }
            if (Math.min(col, row) >= 1) {
                for (int i = 1; i <= Math.min(col, row); i++) {
                    if (a[row - i][col - i].name == '_') {
                        canMove.add(new ChessboardPoint((row - i), (col - i)));
                    } else {
                        if (a[row - i][col - i].getChessColor() == ChessColor.BLACK) {
                            canMove.add(new ChessboardPoint((row - i), (col - i)));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (Math.min(7 - row, col) >= 1) {
                for (int i = 1; i <= Math.min(7 - row, col); i++) {
                    if (a[row + i][col - i].name == '_') {
                        canMove.add(new ChessboardPoint((row + i), (col - i)));
                    } else {
                        if (a[row + i][col - i].getChessColor() == ChessColor.BLACK) {
                            canMove.add(new ChessboardPoint((row + i), (col - i)));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (Math.min(row, 7 - col) >= 1) {
                for (int i = 1; i <= Math.min(row, (7 - col)); i++) {
                    if (a[row - i][col + i].name == '_') {
                        canMove.add(new ChessboardPoint((row - i), (col + i)));
                    } else {
                        if (a[row - i][col + i].getChessColor() == ChessColor.BLACK) {
                            canMove.add(new ChessboardPoint((row - i), (col + i)));
                            break;
                        } else {
                            break;
                        }
                    }
                }
            }
        }
        return canMove;
    }
}


