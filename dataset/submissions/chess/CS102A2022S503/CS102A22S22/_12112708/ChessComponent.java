import java.util.List;

    public abstract class ChessComponent {
        private ChessboardPoint source;
        private ChessColor chessColor;
        protected ChessboardPoint source1;
        protected ChessColor chessColor1;
        protected char name;
        ChessComponent[][] chessboard;
        static ChessColor getCurrentColor(char component){
            if (component=='B'||component=='K'||component=='N'||component=='P'||component=='Q'||component=='R') {
                return ChessColor.BLACK;
            }
            if (component=='b'||component=='k'||component=='n'||component=='p'||component=='q'||component=='r'){
                return ChessColor.WHITE;
            }
            else return ChessColor.NONE;
        }

        void LoadChessboard(ChessComponent[][] chessBoard){
            this.chessboard=chessBoard;
        }

        public ChessComponent(){}

        public abstract List<ChessboardPoint> canMoveTo();

        @Override
        public String toString() {
            return String.valueOf(this.name);
        }

    }