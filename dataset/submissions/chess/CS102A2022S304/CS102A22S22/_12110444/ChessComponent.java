import java.util.List;

public abstract class ChessComponent {
    public ChessboardPoint getSource() {
        return source;
    }

    //should design
    private ChessboardPoint source;
    public ChessComponent(){}
    public ChessColor getChessColor() {
        return chessColor;
    }

    private ChessColor chessColor;
    protected char name;

    //should design
    public ChessComponent(int x,int y,char name){
        source = new ChessboardPoint(x,y);
      this.name=name;
      if(name>'A'&&name<'Z'){
          chessColor=ChessColor.BLACK;
      }
      else if(name>'a'&&name<'z'){
          chessColor=ChessColor.WHITE;
      }
      else{
          chessColor=ChessColor.NONE;
      }
    }
    public ChessboardPoint getChessboardPoint() {
        return source;
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

