    import java.util.List;

    public abstract class ChessComponent {
        //should design
        private ChessboardPoint source;
        private ChessColor chessColor;
        protected char name;

        //should design

        public ChessComponent(){}

        public ChessComponent(char name, ChessColor chessColor, ChessboardPoint source) {
            this.name=name;
            this.chessColor=chessColor;
            this.source=source;
        }

        public ChessboardPoint getSource() {
            return source;
        }

        public void setSource(ChessboardPoint source) {
            this.source = source;
        }

        public ChessColor getChessColor() {
            return chessColor;
        }

        public void setChessColor(ChessColor chessColor) {
            this.chessColor = chessColor;
        }

        public char getName() {
            return name;
        }



        // should design

        public abstract List<ChessboardPoint> canMoveTo() ;

        /**
         * should design
         * @return
         */
        @Override
        public String toString() {
            return String.valueOf(this.name);
        }

    }


