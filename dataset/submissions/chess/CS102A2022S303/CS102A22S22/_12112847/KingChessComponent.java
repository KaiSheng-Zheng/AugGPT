import java.util.List;

public class KingChessComponent extends ChessComponent{
    static int date=1;
    static int Bremain=0;
    static int Wremain=0;

    public KingChessComponent(char name, ConcreteChessGame game, ChessboardPoint source) {
        super(name, game, source);

    }

    public boolean can(ChessboardPoint source,ChessboardPoint destination) {
        if(game.getChessComponents()[destination.getX()][destination.getY()].getChessColor() != this.getChessColor()) {
            if (Math.abs(destination.getY() - source.getY()) < 2 && Math.abs(destination.getX() - source.getX()) < 2) {
                if (Math.abs(destination.getY() - source.getY()) == 0 && Math.abs(destination.getX() - source.getX()) == 0) {
                    return false;
                }
                return true;
            }
        }
        return false;
    }

    public static boolean can(int sourceX, int sourceY, int destinationX, int destinationY) {
        if(Math.abs(destinationY-sourceY)<2&&Math.abs(destinationX-sourceX)<2){
            if(Math.abs(destinationY-sourceY)==0&&Math.abs(destinationX-sourceX)==0){
                return false;
            }
            return true;
        }
        return false;
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(can(this.getSource(),new ChessboardPoint(i,j)) ){
                    re.add(new ChessboardPoint(i,j));
                }
            }
        }
        return re;
    }
}
