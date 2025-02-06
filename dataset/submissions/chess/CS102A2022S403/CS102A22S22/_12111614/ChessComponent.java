import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;

    //should design
    public ChessComponent() {
		// TODO Auto-generated constructor stub
	}
    public ChessComponent(int x,int y,char name,ChessComponent[][] chessComponents){
    	source=new ChessboardPoint(x, y);
		this.name=name;
		this.chessComponents=chessComponents;
		if (Character.isUpperCase(name)) {
			chessColor=ChessColor.BLACK;
		}else {
			chessColor=ChessColor.WHITE;
		}
    }
    
    public ChessColor getChessColor() {
		return chessColor;
	}
    
    public void setChessColor(ChessColor chessColor) {
		this.chessColor = chessColor;
	}
    
    public ChessboardPoint getSource() {
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
        return String.valueOf(name);
    }

}
