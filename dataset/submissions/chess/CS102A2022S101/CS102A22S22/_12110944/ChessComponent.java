import java.util.List;

public abstract class ChessComponent {

    private ChessboardPoint source; // Where the chess is
        private ChessColor chessColor; // What's the color
        protected char name; // What's the name
        private ChessComponent[][] chessComponents;
    public ChessComponent(){}
        public ChessComponent(char name, ChessColor chessColor,ChessComponent[][] chessComponents, ChessboardPoint source){
            this.name=name;
            this.source=source;
            this.chessColor = chessColor;
            this.chessComponents=chessComponents;
        }

        public abstract List<ChessboardPoint> canMoveTo();


        @Override
        public String toString() {
            return String.valueOf(this.name);
        }

        public ChessboardPoint getChessboardPoint(){
                return source;
        }

        public ChessColor getChessColor(){
                return chessColor;
        }


    }
