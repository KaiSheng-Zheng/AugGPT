import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{

    @Override
    public List<ChessboardPoint> canMoveTo() {
        int x= getSource().getX();
        int y= getSource().getY();
        ArrayList<ChessboardPoint> a = new ArrayList<>();
        if (this.chessComponents[x][y].name=='p'||this.chessComponents[x][y].name=='P'){
            if (x==6){
                if (this.chessComponents[5][y].getChessColor()==ChessColor.NONE){
                    a.add(new ChessboardPoint(5,y));
                }if (this.chessComponents[5][y].getChessColor()==ChessColor.NONE&&this.chessComponents[4][y].getChessColor()==ChessColor.NONE){
                    a.add(new ChessboardPoint(4,y));
                }if (y-1<0){
                    if (this.chessComponents[5][y+1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[5][y+1].getChessColor()!=ChessColor.NONE){
                        a.add(new ChessboardPoint(5,y+1));
                    }
                }else if(y-1>=0&&y+1<=7){
                    if (this.chessComponents[5][y-1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[5][y-1].getChessColor()!=ChessColor.NONE){
                        a.add(new ChessboardPoint(5,y-1));
                    }
                    if (this.chessComponents[5][y+1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[5][y+1].getChessColor()!=ChessColor.NONE){
                        a.add(new ChessboardPoint(5,y+1));
                    }
                }else if (y+1>7){
                    if (this.chessComponents[5][y-1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[5][y-1].getChessColor()!=ChessColor.NONE){
                        a.add(new ChessboardPoint(5,y-1));
                    }
                }
            }
            else if (x>1&&x<6){
                if (this.chessComponents[x][y].getChessColor()==ChessColor.BLACK){
                    if (this.chessComponents[x+1][y].getChessColor()==ChessColor.NONE){
                        a.add(new ChessboardPoint(x+1,y));
                    }
                    if (y-1<0){
                        if (this.chessComponents[x+1][y+1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[x+1][y+1].getChessColor()!=ChessColor.NONE){
                            a.add(new ChessboardPoint(x+1,y+1));
                        }
                    }else if(y-1>=0&&y+1<=7){
                        if (this.chessComponents[x+1][y-1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[x+1][y-1].getChessColor()!=ChessColor.NONE){
                            a.add(new ChessboardPoint(x+1,y-1));
                        }
                        if (this.chessComponents[x+1][y+1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[x+1][y+1].getChessColor()!=ChessColor.NONE){
                            a.add(new ChessboardPoint(x+1,y+1));
                        }
                    }else if (x+1>7){
                        if (this.chessComponents[x+1][y-1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[x+1][y-1].getChessColor()!=ChessColor.NONE){
                            a.add(new ChessboardPoint(x+1,y-1));
                        }
                    }
                }else if (this.chessComponents[x][y].getChessColor()==ChessColor.WHITE){
                    if (this.chessComponents[x-1][y].getChessColor()==ChessColor.NONE){
                        a.add(new ChessboardPoint(x-1,y));
                    }
                    if (y-1<0){
                        if (this.chessComponents[x-1][y+1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[x-1][y+1].getChessColor()!=ChessColor.NONE){
                            a.add(new ChessboardPoint(x-1,y+1));
                        }
                    }else if(y-1>=0&&y+1<=7){
                        if (this.chessComponents[x-1][y-1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[x-1][y-1].getChessColor()!=ChessColor.NONE){
                            a.add(new ChessboardPoint(x-1,y-1));
                        }
                        if (this.chessComponents[x-1][y+1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[x-1][y+1].getChessColor()!=ChessColor.NONE){
                            a.add(new ChessboardPoint(x-1,y+1));
                        }
                    }else if (y+1>7){
                        if (this.chessComponents[x-1][y-1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[x-1][y-1].getChessColor()!=ChessColor.NONE){
                            a.add(new ChessboardPoint(x-1,y-1));
                        }
                    }
                }
            }else if (x==1){
                if (this.chessComponents[2][y].getChessColor()==ChessColor.NONE){
                    a.add(new ChessboardPoint(2,y));
                }if (this.chessComponents[2][y].getChessColor()==ChessColor.NONE&&this.chessComponents[x][3].getChessColor()==ChessColor.NONE){
                    a.add(new ChessboardPoint(3,y));
                }if (y-1<0){
                    if (this.chessComponents[2][y+1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[2][y+1].getChessColor()!=ChessColor.NONE){
                        a.add(new ChessboardPoint(2,y+1));
                    }
                }else if(y-1>=0&&y+1<=7){
                    if (this.chessComponents[2][y-1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[2][y-1].getChessColor()!=ChessColor.NONE){
                        a.add(new ChessboardPoint(2,y-1));
                    }
                    if (this.chessComponents[2][y+1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[2][y+1].getChessColor()!=ChessColor.NONE){
                        a.add(new ChessboardPoint(2,y+1));
                    }
                }else if (y+1>7){
                    if (this.chessComponents[2][y-1].getChessColor()!=this.chessComponents[x][y].getChessColor()&&this.chessComponents[2][y-1].getChessColor()!=ChessColor.NONE){
                        a.add(new ChessboardPoint(2,y-1));
                    }
                }
            }

        return a;
        }else{
            return new ArrayList<>();
        }
    }
}
