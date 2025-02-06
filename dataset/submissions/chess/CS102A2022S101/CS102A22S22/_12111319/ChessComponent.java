import java.util.List;
public abstract class ChessComponent {
    private ChessboardPoint source;
        private ChessColor chessColor;
        protected char name;
        private ChessComponent[][] chessComponents;
    public ChessComponent(){}

        public ChessComponent( char name, ChessColor chessColor, ChessComponent[][]chessComponents, ChessboardPoint source){
            this.name = name;
            this.source = source;
            this.chessColor = chessColor;
            this.chessComponents = chessComponents;
        }
    public abstract List<ChessboardPoint> canMoveTo();
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
    public boolean canMoveto(int X, int Y) {
        return true;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}