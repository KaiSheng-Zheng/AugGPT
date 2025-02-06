import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PawnChessComponent extends ChessComponent {

    public PawnChessComponent() {
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super(source, chessColor, name);
    }

    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, char name, ChessComponent[][] chessComponents) {
        super(source, chessColor, name, chessComponents);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> move = new ArrayList<>();
        if (this.getChessColor() == ChessColor.BLACK) {
            if (this.getSource().getX() == 1) {
                if (this.getChessComponents()[getSource().getX() + 1][getSource().getY()].name == '_') {
                    move.add(this.getSource().offset(1, 0));
                }
                if (this.getChessComponents()[getSource().getX() + 2][getSource().getY()].name == '_') {
                    move.add(this.getSource().offset(2, 0));
                }
                if (this.getSource().offset(1, 1) != null) {
                    if (getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() != this.getChessColor() &&
                            getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() != ChessColor.NONE) {
                        move.add(this.getSource().offset(1, 1));
                    }
                }
                if (this.getSource().offset(1, -1) != null) {
                    if (getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() != this.getChessColor() &&
                            getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() != ChessColor.NONE) {
                        move.add(this.getSource().offset(1, -1));
                    }
                }
            } else {
                if (this.getSource().offset(1, 0) != null) {
                    if (this.getChessComponents()[getSource().getX() + 1][getSource().getY()].name == '_') {
                        move.add(this.getSource().offset(1, 0));
                    }
                }
                if (this.getSource().offset(1, 1) != null) {
                    if (getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() != this.getChessColor() &&
                            getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() + 1].getChessColor() != ChessColor.NONE) {
                        move.add(this.getSource().offset(1, 1));
                    }
                }
                if (this.getSource().offset(1, -1) != null) {
                    if (getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() != this.getChessColor() &&
                            getChessComponents()[this.getSource().getX() + 1][this.getSource().getY() - 1].getChessColor() != ChessColor.NONE) {
                        move.add(this.getSource().offset(1, -1));
                    }
                }
            }
        } else if (this.getChessColor() == ChessColor.WHITE) {
            if (this.getSource().getX() == 6) {
                if (this.getChessComponents()[getSource().getX() - 1][getSource().getY()].name == '_') {
                    move.add(this.getSource().offset(-1, 0));
                }
                if (this.getChessComponents()[getSource().getX() - 2][getSource().getY()].name == '_') {
                    move.add(this.getSource().offset(-2, 0));
                }
                if (this.getSource().offset(-1, 1) != null) {
                    if (getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() != this.getChessColor() &&
                            getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() != ChessColor.NONE) {
                        move.add(this.getSource().offset(-1, 1));
                    }
                }
                if (this.getSource().offset(-1, -1) != null) {
                    if (getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() != this.getChessColor() &&
                            getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() != ChessColor.NONE) {
                        move.add(this.getSource().offset(-1, -1));
                    }
                }
            } else {
                if (this.getSource().offset(-1, 0) != null) {
                    if (this.getChessComponents()[getSource().getX() - 1][getSource().getY()].name == '_') {
                        move.add(this.getSource().offset(-1, 0));
                    }
                }
                if (this.getSource().offset(-1, 1) != null) {
                    if (getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() != this.getChessColor() &&
                            getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() + 1].getChessColor() != ChessColor.NONE) {
                        move.add(this.getSource().offset(-1, 1));
                    }
                }
                if (this.getSource().offset(-1, -1) != null) {
                    if (getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() != this.getChessColor() &&
                            getChessComponents()[this.getSource().getX() - 1][this.getSource().getY() - 1].getChessColor() != ChessColor.NONE) {
                        move.add(this.getSource().offset(-1, -1));
                    }
                }
            }
        }
        return move;
    }

//    public static void main(String[] args) {
////        ConcreteChessGame test = new ConcreteChessGame();
////        List<String > map = new ArrayList<>();
////        map.add("RNBQKBNR");
////        map.add("PPPPPPPP");
////        map.add("________");
////        map.add("________");
////        map.add("________");
////        map.add("________");
////        map.add("pppppppp");
////        map.add("rnbqkbnr");
////        map.add("w") ;
////        test.loadChessGame(map) ;
////        test.getChess(5,2) .setChessComponents(test.getChessComponents()) ;
////        for (int i = 0; i < 8; i++) {
////            for (int j = 0; j < 8; j++) {
////                System.out.print(test.getChess(i,j).name  );
////                System.out.print(test.getChess(i,j).getChessColor() );
////                System.out.println(test.getChess(i,j).getSource() );
////            }
////        }
////        System.out.print(test.getChess(6,3).name  );
////        System.out.print(test.getChess(6,3).getChessColor() );
////        System.out.print(test.getChess(6,3).canMoveTo() );
////        System.out.println(test.getChessComponents()[6][3].canMoveTo() );
////        System.out.println(test.getCanMovePoints(new ChessboardPoint(6,3)) );
////        List<ChessboardPoint > STR = new ArrayList<>();
////        STR.add(new ChessboardPoint(1,1)) ;
////        ChessboardPoint n = new ChessboardPoint(1,1);
////        if(STR.get(0).getX()==n.getX() ){
////            System.out.println("hhhh");
////        }
//        List<ChessboardPoint> A = new ArrayList<>();
//        A.add(new ChessboardPoint(1,1) );
//        if(A.get(0).getX() == 1 && A.get(0).getY() == 1){
//            System.out.println("hhhh");
//        }
//    }
}
