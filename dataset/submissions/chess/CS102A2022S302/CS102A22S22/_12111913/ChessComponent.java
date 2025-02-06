

import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessboard;

    public ChessComponent(ChessboardPoint source,ChessColor chessColor,char name){
        this.source=source;
        this.chessColor=chessColor;
        this.name=name;
    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }

    //getchess
    public ChessComponent getChess(int x, int y) {
        if (x>=0&&x<8&&y>=0&&y<8){
         return this.chessboard[x][y];}
        else return null;
    }

    public ChessComponent getChess(ChessboardPoint source) {
        return this.chessboard[source.getX()][source.getY()];
    }

    //getchessname
    public char getChessName(int x,int y){
        return this.chessboard[x][y].getName();
    }

    //search
    public ChessComponent SearchLeft(ChessComponent input){
        ChessComponent ans=getChess(0,input.source.getY());
        if (input.source.getX()!=0){
            for (int i=input.source.getX()-1;i>=0;i--){
              boolean TF=getChessName(i,input.source.getY())=='_';
              if (!TF){
                  ans=getChess(i,input.source.getY());
                  break;}
            }
          }
        return ans;
    }
    public ChessComponent SearchRight(ChessComponent input){
        ChessComponent ans=getChess(7,input.source.getY());
        if (input.source.getX()!=7){
            for (int i=input.source.getX()+1;i<=7;i++){
                boolean TF=getChessName(i,input.source.getY())=='_';
                if (!TF){
                    ans=getChess(i,input.source.getY());
                    break;}
            }
        }
        return ans;
    }
    public ChessComponent SearchDown(ChessComponent input){
        ChessComponent ans=getChess(input.source.getX(),7);
        if (input.source.getY()!=7){
            for (int i=input.source.getY()+1;i<=7;i++){
                boolean TF=getChessName(input.source.getX(),i)=='_';
                if (!TF){
                    ans=getChess(input.source.getX(),i);
                    break;}
            }
        }
        return ans;
    }
    public ChessComponent SearchUp(ChessComponent input){
        ChessComponent ans=getChess(input.source.getX(),0);
        if (input.source.getY()!=0){
            for (int i=input.source.getY()-1;i>=0;i--){
                boolean TF=input.getChessName(input.source.getX(),i)=='_';
                if (!TF){
                    ans=getChess(input.source.getX(),i);
                    break;}
            }
        }
        return ans;
    }
    public ChessComponent SearchLeftUp(ChessComponent input){
        ChessComponent ans=getChess(input.source.getX(),input.source.getY());


        int i=input.source.getX();int j=input.source.getY();

            while (i>0&&j>0){
                i--;j--;
                boolean TF=getChessName(i,j)=='_';
                if (!TF||i==0||j==0){
                    ans=getChess(i,j);
                    break;}
            }

        return ans;
    }
    public ChessComponent SearchLeftDown(ChessComponent input){
        ChessComponent ans=getChess(input.source.getX(),input.source.getY());

        int i=input.source.getX();int j=input.source.getY();

            while (i>0&&j<7){
                i--;j++;
                boolean TF=getChessName(i,j)=='_';
                if (!TF||i==0||j==7){
                    ans=getChess(i,j);
                    break;}
            }

        return ans;
    }
    public ChessComponent SearchRightUp(ChessComponent input){
        ChessComponent ans=getChess(input.source.getX(),input.source.getY());

        int i=input.source.getX();int j=input.source.getY();

            while (i<7&&j>0){
                i++;j--;
                boolean TF=getChessName(i,j)=='_';
                if (!TF||i==7||j==0){
                    ans=getChess(i,j);
                    break;}
            }

        return ans;
    }
    public ChessComponent SearchRightDown(ChessComponent input){
        ChessComponent ans=getChess(input.source.getX(),input.source.getY());

        int i=input.source.getX();int j=input.source.getY();

            while (i<7&&j<7){
                i++;j++;
                boolean TF=getChessName(i,j)=='_';
                if (!TF||i==7||j==7){
                    ans=getChess(i,j);
                    break;}
            }

        return ans;
    }

    //IsSame
   public boolean  IsSame(ChessComponent target){
        boolean ans=false;
        if (target==null){ans=true;}
        else if (target.chessColor==this.chessColor){ans=true;}
        return ans;
   }
   //IsEnemy
   public boolean IsEnemy(ChessComponent target){
       boolean ans= this.getChessColor() == ChessColor.WHITE && target.getChessColor() == ChessColor.BLACK;
       if (this.getChessColor()==ChessColor.BLACK&&target.getChessColor()==ChessColor.WHITE)
       {ans=true;}
       return ans;
   }
    //should design
    public ChessComponent(){}

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
