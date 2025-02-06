import java.util.ArrayList;
    import java.util.List;

    public class KingChessComponent extends ChessComponent {

        private ChessboardPoint source; // Where the chess is
        private ChessColor chessColor;  // What's the color
        private char name;			// What's the name
        ChessComponent[][] chessComponents;
        @Override
        public List<ChessboardPoint> canMoveTo() {
            List<ChessboardPoint> result = new ArrayList<ChessboardPoint>();
            for(int i = 1 ; i>=-1;i--){
                for(int j = 1;j>=-1;j--){
                    if(i!=0||j!=0){
                        ChessboardPoint com = new ChessboardPoint(source.getX()+i, source.getY()+j );

                        if((0<=com.getX()&&com.getX()<=7&&com.getY()<=7 && 0<=com.getY())){
                            boolean test =!chessComponents[com.getX()][com.getY()].getChessColor().equals(this.getChessColor());
                            if(test){
                                result.add(com);
                            }
                        }
                    }
                }
            }
            sort(result);
            return result;
        }
        public void sort(List<ChessboardPoint> com){
            int size = com.size();
            for(int i = 0;i<size;i++){
                for(int k = 0;k<size-1 ;k++){
                    ChessboardPoint com1 = com.get(k);
                    ChessboardPoint com2 = com.get(k+1);
                    if(com1.getX()>com2.getX()) {
                        com.set(k+1,com1);
                        com.set(k,com2);
                    }
                    else if(com1.getX()== com2.getX()&& com1.getY()>com2.getY()){
                        com.set(k+1,com1);
                        com.set(k,com2);
                    }
                }
            }
        }


        public ChessColor counterColor(){
            return this.chessColor.equals(ChessColor.BLACK) ? ChessColor.WHITE :ChessColor.BLACK;
        }
        public KingChessComponent(char name , ChessColor a, ChessboardPoint b,ChessComponent[][] chessComponents){
            this.name = name ;
            chessColor = a;
            source = b;
            this.chessComponents = chessComponents;
        }
        public char getName(){
            return this.name;
        }
        public ChessColor getChessColor(){
            return this.chessColor;
        }
        public void printAllCanMoveTo(){
            List<ChessboardPoint> com = this.canMoveTo();
            for(ChessboardPoint a: com){
                System.out.println("("+a.getX()+","+a.getY()+")");
            }
        }
        public String toString() {
            return String.valueOf(this.name);
        }
    }
