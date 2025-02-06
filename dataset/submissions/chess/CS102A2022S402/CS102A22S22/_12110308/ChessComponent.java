import java.util.List;
import java.util.ArrayList;

public abstract class ChessComponent {
    //should design
     ChessboardPoint source;
     ChessColor chessColor;
    protected char name;
    ChessComponent[][] chessBoard;
    int[] dx=new int[]{-1,-1,-1,0,1,1,1,0},dy=new int[]{-1,0,1,1,1,0,-1,-1};
    ChessColor getChessColor(char component){
        return (component=='_')?ChessColor.NONE:((component>='B'&&component<='R')?ChessColor.BLACK:ChessColor.WHITE);
    }
    void loadCurrentChessboard(ChessComponent[][] chessBoard){
        this.chessBoard=chessBoard;
    }
    //should design
    public ChessComponent(){}
    public ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.source=source;
        this.chessColor=chessColor;
    }
    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}


class KingChessComponent extends ChessComponent{
        public KingChessComponent(ChessboardPoint source,ChessColor chessColor){
    super(source,chessColor);
            this.name = chessColor == ChessColor.BLACK ? 'K' : 'k';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
            for(int i=0;i<8;i++){
                ChessboardPoint newPlace=source.offset(dx[i],dy[i]);
                if(newPlace!=null&&getChessColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=chessColor){
                    moveTo.add(newPlace);
                }
            }
            return moveTo;
        }
    }

     class QueenChessComponent extends ChessComponent {
        public QueenChessComponent(ChessboardPoint source,ChessColor chessColor){
            super(source,chessColor);
            this.name=chessColor==ChessColor.BLACK?'Q':'q';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
            for(int i=0;i<8;i++){
                for (int j=1;j<8;j++){ChessboardPoint newPlace=source.offset(j*dx[i],j*dy[i]);
                if(newPlace!=null&&getChessColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=chessColor){
                    moveTo.add(newPlace);if (getChessColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=ChessColor.NONE){break;}
                }else break;}
            }
            return moveTo;
        }
    }

     class RookChessComponent extends ChessComponent {
        public RookChessComponent(ChessboardPoint source,ChessColor chessColor){
            super(source,chessColor);
            this.name=chessColor==ChessColor.BLACK?'R':'r';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
            for(int i=1;i<8;i+=2){
                for (int j=1;j<8;j++){ChessboardPoint newPlace=source.offset(j*dx[i],j*dy[i]);
                    if(newPlace!=null&&getChessColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=chessColor){
                        moveTo.add(newPlace);if (getChessColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=ChessColor.NONE){break;}
                    }else break;}
            }
            return moveTo;
        }
    }

     class BishopChessComponent extends ChessComponent {
        public BishopChessComponent(ChessboardPoint source,ChessColor chessColor){
            super(source,chessColor);
            this.name=chessColor==ChessColor.BLACK?'B':'b';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
            for(int i=0;i<8;i+=2){
                for (int j=1;j<8;j++){ChessboardPoint newPlace=source.offset(j*dx[i],j*dy[i]);
                    if(newPlace!=null&&getChessColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=chessColor){
                        moveTo.add(newPlace);if (getChessColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=ChessColor.NONE){break;}
                    }else break;}
            }
            return moveTo;
        }
    }

     class KnightChessComponent extends ChessComponent {
        public KnightChessComponent(ChessboardPoint source,ChessColor chessColor){
            super(source,chessColor);
            this.name=chessColor==ChessColor.BLACK?'N':'n';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
            int[]kdx=new int[]{-2,-2,-1,1,2,2,1,-1},kdy=new int[]{-1,1,2,2,1,-1,-2,-2};
            for(int i=0;i<8;i++){
                ChessboardPoint newPlace=source.offset(kdx[i],kdy[i]);
                if(newPlace!=null&&getChessColor(chessBoard[newPlace.getX()][newPlace.getY()].toString().charAt(0))!=chessColor){
                    moveTo.add(newPlace);
                }
            }
            return moveTo;
        }
    }

     class PawnChessComponent extends ChessComponent {
        public PawnChessComponent(ChessboardPoint source,ChessColor chessColor){
            super(source,chessColor);
            this.name=chessColor==ChessColor.BLACK?'P':'p';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
            int x=source.getX(),y=source.getY();
            if(chessColor==ChessColor.BLACK){
                if(x<7&&getChessColor(chessBoard[x+1][y].toString().charAt(0))==ChessColor.NONE){
                    moveTo.add(new ChessboardPoint(x+1,y));
                    if(x==1&&getChessColor(chessBoard[x+2][y].toString().charAt(0))==ChessColor.NONE){
                        moveTo.add(new ChessboardPoint(x+2,y));
                    }
                }
                if(y>0&&getChessColor(chessBoard[x-1][y-1].toString().charAt(0))==ChessColor.WHITE){
                    moveTo.add(new ChessboardPoint(x-1,y-1));
                }
                if(y<7&&getChessColor(chessBoard[x-1][y+1].toString().charAt(0))==ChessColor.WHITE){
                    moveTo.add(new ChessboardPoint(x-1,y+1));
                }
            }
            else{
                if(x>0&&getChessColor(chessBoard[x+1][y].toString().charAt(0))==ChessColor.NONE){
                    moveTo.add(new ChessboardPoint(x+1,y));
                    if(x==6&&getChessColor(chessBoard[x+2][y].toString().charAt(0))==ChessColor.NONE){
                        moveTo.add(new ChessboardPoint(x+2,y));
                    }
                }
                if(y>0&&getChessColor(chessBoard[x+1][y-1].toString().charAt(0))==ChessColor.BLACK){
                    moveTo.add(new ChessboardPoint(x+1,y-1));
                }
                if(y<7&&getChessColor(chessBoard[x+1][y+1].toString().charAt(0))==ChessColor.BLACK){
                    moveTo.add(new ChessboardPoint(x+1,y+1));
                }
            }
            return moveTo;
        }
    }

     class EmptySlotComponent extends ChessComponent {
        public EmptySlotComponent(ChessboardPoint source,ChessColor chessColor){
            super(source,chessColor);
            this.name='_';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            return new ArrayList<>();
        }
    }