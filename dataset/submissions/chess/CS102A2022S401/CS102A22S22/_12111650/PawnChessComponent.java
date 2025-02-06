import java.util.ArrayList;
import java.util.List;

public class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint point,ChessColor color,char name){
        super(point,color,name);
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> ans = new ArrayList<ChessboardPoint>();
        ChessboardPoint p = getSource();
        int x = p.getX();
        int y = p.getY();
        ChessColor color = chessComponents[x][y].getChessColor();
        if(this.getChessColor()==ChessColor.BLACK&&x==1){
            ChessboardPoint p1 = new ChessboardPoint(x+1,y);
            ChessboardPoint p2 = new ChessboardPoint(x+2,y);
            if(chessComponents[p1.getX()][p1.getY()].getChessColor()==ChessColor.NONE){
                ans.add(p1);
                if(chessComponents[p2.getX()][p2.getY()].getChessColor() == ChessColor.NONE){
                    ans.add(p2);
                }
            }
            if(y-1>=0){
                if(chessComponents[x+1][y-1].getChessColor() != color && chessComponents[x+1][y-1].getChessColor() != ChessColor.NONE){
                    ans.add(new ChessboardPoint(x+1,y-1));
                }
            }
            if(y+1<=8){
                if(chessComponents[x+1][y+1].getChessColor() != color && chessComponents[x+1][y+1].getChessColor() != ChessColor.NONE){
                    ans.add(new ChessboardPoint(x+1,y+1));
                }
            }
        }
        else if(this.getChessColor()==ChessColor.WHITE&&x==6){
            ChessboardPoint p1 = new ChessboardPoint(x-1,y);
            ChessboardPoint p2 = new ChessboardPoint(x-2,y);
            if(chessComponents[p1.getX()][p1.getY()].getChessColor()==ChessColor.NONE){
                ans.add(p1);
                if(chessComponents[p2.getX()][p2.getY()].getChessColor() == ChessColor.NONE){
                    ans.add(p2);
                }
            }
            if(y-1>=0){
                if(chessComponents[x-1][y-1].getChessColor() != color && chessComponents[x-1][y-1].getChessColor() != ChessColor.NONE){
                    ans.add(new ChessboardPoint(x-1,y-1));
                }
            }
            if(y+1<=8){
                if(chessComponents[x-1][y+1].getChessColor() != color && chessComponents[x-1][y+1].getChessColor() != ChessColor.NONE){
                    ans.add(new ChessboardPoint(x-1,y+1));
                }
            }
        }
        else if(this.getChessColor()==ChessColor.BLACK&&x!=1&&x!=7){
            ChessboardPoint p1 = new ChessboardPoint(x+1,y);
            if(chessComponents[x+1][y].getChessColor() == ChessColor.NONE){
                ans.add(p1);
            }
            if(y-1>=0){
                if(chessComponents[x+1][y-1].getChessColor() != color && chessComponents[x+1][y-1].getChessColor() != ChessColor.NONE){
                    ans.add(new ChessboardPoint(x+1,y-1));
                }
            }
            if(y+1<=8){
                if(chessComponents[x+1][y+1].getChessColor() != color && chessComponents[x+1][y+1].getChessColor() != ChessColor.NONE){
                    ans.add(new ChessboardPoint(x+1,y+1));
                }
            }
        }
        else if(this.getChessColor()==ChessColor.WHITE&&x!=6&&x!=0){
            ChessboardPoint p1 = new ChessboardPoint(x-1,y);
            if(chessComponents[x-1][y].getChessColor() == ChessColor.NONE){
                ans.add(p1);
            }
            if(y-1>=0){
                if(chessComponents[x-1][y-1].getChessColor() != color && chessComponents[x-1][y-1].getChessColor() != ChessColor.NONE){
                    ans.add(new ChessboardPoint(x-1,y-1));
                }
            }
            if(y+1<=8){
                if(chessComponents[x-1][y+1].getChessColor() != color && chessComponents[x-1][y+1].getChessColor() != ChessColor.NONE){
                    ans.add(new ChessboardPoint(x-1,y+1));
                }
            }
        }
        return ans;
    }
}
