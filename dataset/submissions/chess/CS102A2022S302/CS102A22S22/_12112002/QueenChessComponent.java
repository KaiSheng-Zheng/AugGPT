import java.util.List;

public class QueenChessComponent extends ChessComponent{
    public QueenChessComponent() {
    }

    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessboard) {
        super(source, chessColor, name, chessboard);
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {

        //clear in a strange way
        list.clear();
        //fix here if necessary

        ChessboardPoint source=getSource();
        int x=source.getX();
        int y=source.getY();
        BishopChessComponent bishopChess=new BishopChessComponent(source,this.getChessColor(),'s',chessboard);


        List<ChessboardPoint> gradient=bishopChess.canMoveTo();
        for (int i = 0; i < gradient.size(); i++) {
            this.list.add(gradient.get(i));
        }
 //FIXME: ROOK IS TO BE ADDED HERE
        RookChessComponent rookChess=new RookChessComponent(source,this.getChessColor(),'S',chessboard);
        List<ChessboardPoint> straight=rookChess.canMoveTo();
        for (int i = 0; i < straight.size(); i++) {
            list.add(straight.get(i));
        }

        return list;

    }
    public boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint chessboardPoint : chessboardPoints) {
            if (target.getX() == chessboardPoint.getX() && target.getY() == chessboardPoint.getY()) return true;
        }
        return false;
    }
}
