import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
        //should design
        public ChessboardPoint source;
        public ChessColor chessColor;
        public ChessComponent[][] chessBoard;
        protected char name;
        public ChessColor getComponentColor(char component){
                if (component=='_'){
                        return ChessColor.NONE;
                }
                if ((int)component>=66&&(int)component<=82){
                        return ChessColor.BLACK;
                }
                else{
                        return ChessColor.WHITE;
                }
        }

        public abstract List<ChessboardPoint> canMoveTo();


        public ChessComponent(ChessboardPoint source,ChessColor chessColor){
                this.source=source;
                this.chessColor=chessColor;
        }
        public ChessComponent(){

        }

        @Override
        public String toString() {
            return String.valueOf(this.name);
        }
        void loadCurrentChessboard(ChessComponent[][] chessBoard){
                this.chessBoard=chessBoard;
        }
}
