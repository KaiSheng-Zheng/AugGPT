    import java.util.ArrayList;
    import java.util.List;

    public class KnightChessComponent extends ChessComponent{
        public  KnightChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
            this.source = source;
            this.chessColor = chessColor;
            this.name = name;
        }
        @Override
        public List<ChessboardPoint> canMoveTo() {
            ChessboardPoint source = getSource();
            ChessColor color = getChessColor();
            List<ChessboardPoint> list = new ArrayList<>();

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    ChessboardPoint chessboardPoint = new ChessboardPoint(i,j);
                        if((((j==source.getY()+2)&&(i==source.getX()+1))||
                                ((j==source.getY()+2)&&(i==source.getX()-1))||
                                ((j==source.getY()-2)&&(i==source.getX()+1))||
                                ((j==source.getY()-2)&&(i==source.getX()-1))||
                                ((j==source.getY()+1)&&(i==source.getX()-2))||
                                ((j==source.getY()+1)&&(i==source.getX()+2))||
                                ((j==source.getY()-1)&&(i==source.getX()+2))
                                )&&(chessComponent[i][j].getChessColor()!=color)){
                            list.add(chessboardPoint);
                        }
                }
            }
            return list;
        }

    }
