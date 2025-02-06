import java.util.ArrayList;
import java.util.List;

public abstract class  ChessComponent {
    //should design
   public ChessboardPoint source;
    public ChessColor chessColor;
    protected char name;
ChessComponent[][] chessBoard;
final int[][] move=new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};
    //should design
    public ChessComponent(){};
    public ChessComponent(ChessboardPoint source,ChessColor chessColor){
        this.source=source;
        this.chessColor=chessColor;
    }
    // should design
    public abstract List<ChessboardPoint> canMoveTo();
    ChessColor getComponentColor(char component){
        return (component=='_')?ChessColor.NONE:((component>='A'&&component<='Z')?ChessColor.BLACK:ChessColor.WHITE);
    }
   public void loadCurrentChessboard(ChessComponent[][] chessBoard){
        this.chessBoard=chessBoard;
    }
    /**
     * should design
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }


    static class PawnChessComponent extends ChessComponent {
        public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
            super(source, chessColor);
            this.name = chessColor == ChessColor.BLACK ? 'P' : 'p';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
            int x=source.getX(),y=source.getY();
            ArrayList<ChessboardPoint> moveto = new ArrayList<>();
//            if(chessColor==ChessColor.WHITE){
//                if(x>=1&&getComponentColor(chessBoard[x-1][y].toString().charAt(0))==ChessColor.NONE){
//                    moveto.add(new ChessboardPoint(x-1,y));
//                    if(x==6&&getComponentColor(chessBoard[x-2][y].toString().charAt(0))==ChessColor.NONE){
//                        moveto.add(new ChessboardPoint(x-2,y));
//                    }
//                }
//                if(y>=1&&getComponentColor(chessBoard[x-1][y-1].toString().charAt(0))==ChessColor.BLACK){
//                    moveto.add(new ChessboardPoint(x-1,y-1));
//                }
//                if(y<9&&getComponentColor(chessBoard[x-1][y+1].toString().charAt(0))==ChessColor.BLACK){
//                    moveto.add(new ChessboardPoint(x-1,y+1));
//                }
//            }
//            else{
//                if(x<9&&getComponentColor(chessBoard[x+1][y].toString().charAt(0))==ChessColor.NONE){
//                   moveto.add(new ChessboardPoint(x+1,y));
//                    if(x==1&&getComponentColor(chessBoard[x+2][y].toString().charAt(0))==ChessColor.NONE){
//                        moveto.add(new ChessboardPoint(x+2,y));
//                    }
//                }
//                if(y>0&&getComponentColor(chessBoard[x+1][y-1].toString().charAt(0))==ChessColor.WHITE){
//                    moveto.add(new ChessboardPoint(x+1,y-1));
//                }
//                if(y<7&&getComponentColor(chessBoard[x+1][y+1].toString().charAt(0))==ChessColor.WHITE){
//                    moveto.add(new ChessboardPoint(x+1,y+1));
//                }
//            }
            return moveto;
        }

    }

    static class RookChessComponent extends ChessComponent {
        public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
            super(source, chessColor);
            this.name = chessColor == ChessColor.BLACK ? 'R' : 'r';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveto = new ArrayList<>();

            for (int i = 0; i < 4; i++) {
                int[][] rockmove= new int[][]{{-i,0},{0,i},{i,0},{0,-i}};
              ChessboardPoint n = source.offset(rockmove[i][0], rockmove[i][1]);

                if ((n != null && getComponentColor(chessBoard[n.getX()][n.getY()].toString().charAt(0)) != chessColor)){
                    moveto.add(n);
                }
            }
            return moveto;
        }
    }

    static class QueenChessComponent extends ChessComponent {
        public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
            super(source, chessColor);
            this.name = chessColor == ChessColor.BLACK ? 'Q' : 'q';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveto = new ArrayList<>();
            int[][] bishopmove=new int[][]{{-1,-1},{-1,1},{1,1},{1,-1}};
            for (int i = 0; i < 4; i++) {
                ChessboardPoint n = source.offset(0,i);
                ChessboardPoint m = source.offset(i,0);
                if ((n != null && getComponentColor(chessBoard[n.getX()][n.getY()].toString().charAt(0)) != chessColor)|| m!= null && getComponentColor(chessBoard[m.getX()][m.getY()].toString().charAt(0)) != chessColor){
                    moveto.add(n);
                }
                for (int j = 0; j <8 ; j++) {
                    ChessboardPoint k = source.offset(j*bishopmove[i][0], j*bishopmove[i][1]);
                    if (k != null && getComponentColor(chessBoard[k.getX()][k.getY()].toString().charAt(0)) != chessColor) {
                        moveto.add(n);
                    }
                }}
            return moveto;
        }}

    static class KnightChessComponent extends ChessComponent {
        public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
            super(source, chessColor);
            this.name = chessColor == ChessColor.BLACK ? 'N' : 'n';
        }

        public List<ChessboardPoint> canMoveTo() {
            int[][] knightMove=new int[][]{{-2,-1},{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2}};
            ArrayList<ChessboardPoint> moveTo=new ArrayList<>();
            for(int i=0;i<8;i++){
                ChessboardPoint n=source.offset(knightMove[i][0],knightMove[i][1]);
                if(n!=null&&getComponentColor(chessBoard[n.getX()][n.getY()].toString().charAt(0))!=chessColor){
                    moveTo.add(n);
                }
            }
            return moveTo;
        }}

    static class KingChessComponent extends ChessComponent {
        public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
            super(source, chessColor);
            this.name = chessColor == ChessColor.BLACK ? 'K' : 'k';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveto = new ArrayList<>();
            for (int i = 0; i < 8; i++) {
                ChessboardPoint n = source.offset(move[i][0], move[i][1]);
                if (n != null && getComponentColor(chessBoard[n.getX()][n.getY()].toString().charAt(0)) != chessColor) {
                    moveto.add(n);
                }
            }
            return moveto;
        }
    }

    static class EmptySlotComponent extends ChessComponent {//ok

        public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor) {
            super(source, chessColor);
            this.name = '_';
        }

        @Override

        public List<ChessboardPoint> canMoveTo() {
            return new ArrayList<>();
        }
    }

    static class BishopChessComponent extends ChessComponent {
        public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
            super(source, chessColor);
            this.name = chessColor == ChessColor.BLACK ? 'B' : 'b';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            ArrayList<ChessboardPoint> moveto = new ArrayList<>();
            int[][] bishopmove=new int[][]{{-1,-1},{-1,1},{1,1},{1,-1}};
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j <8 ; j++) {
                    ChessboardPoint n = source.offset(j*bishopmove[i][0], j*bishopmove[i][1]);
                    if (n != null && getComponentColor(chessBoard[n.getX()][n.getY()].toString().charAt(0)) != chessColor) {
                        moveto.add(n);
                    }
                }}
            return moveto;
        }}
}
