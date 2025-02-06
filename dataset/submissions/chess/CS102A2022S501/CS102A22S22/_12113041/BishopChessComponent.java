//import java.lang.reflect.Array;
//import java.util.ArrayList;
//import java.util.List;
//
//public class BishopChessComponent extends ChessComponent {
//    private ChessboardPoint source; // Where the chess is
//    private ChessColor chessColor;
//    protected char name;
//
////    public BishopChessComponent( ChessColor chessColor) {
////        this.chessColor = chessColor;
////    }
////
////    public BishopChessComponent(ChessColor chessColor, char name) {
////        this.chessColor = chessColor;
////        this.name = name;
////    }
////public BishopChessComponent(char name) {
////    this.name = name;
////}
//
//
//    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
//        this.source = source;
//        this.chessColor = chessColor;
//        this.name = name;
//    }
//
//    public BishopChessComponent() {
//
//    }
//
//    @Override
//    public ChessColor getChessColor() {
//        return chessColor;
//    }
//
//    @Override
//    public List<ChessboardPoint> canMoveTo() {
//        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<>();
//        for (int x = 0; x < 8; x++) {
//            for (int y = 0; y < 8; y++) {
//                ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
//                if(can(chessboardPoint)){
//                    chessboardPoints.add(chessboardPoint);
//                }
//            }
//        }
//        return chessboardPoints;
//    }
//
//    public boolean can(ChessboardPoint destination) {
//
//            //diagonal
////            if ((Math.abs(destination.getX() - source.getX()) == Math.abs(destination.getY() - source.getY())) && destination.getX() - source.getX() != 0) {
////                //if have chess
////                int r = Math.min(source.getX(), destination.getX())+1 ;
////                int c = Math.min(source.getY(), destination.getY()) ;
////                while (r < Math.max(source.getX(), destination.getX()) && c < Math.max(source.getY(), destination.getY())) {
////                    //c = Math.min(source.getY(), destination.getY()) + 1;
////                    if (!(chessboard[r][c] instanceof EmptySlotComponent)) {
////                        return false;
////                    }
////
////                    r++;
////                    c++;
////                }
////                return true;
////            }
////            return false;
////        }
//        if((chessboard[destination.getX()][destination.getY()].getChessColor())!=(chessboard[source.getX()][source.getY()].getChessColor())) {
//            if (source.getX() != destination.getX()) {
//                if (destination.getX() - source.getX() == destination.getY() - source.getY()) {
//                    //destination.getX() - source.getX() >0&& destination.getY() - source.getY()>0)
//                    if (destination.getX() - source.getX() > 0) {
//                        for (int i = 1; i < destination.getX() - source.getX(); i++) {
//                            if (!(chessboard[source.getX() + i][source.getY() + i] instanceof EmptySlotComponent)) {
//                                return false;
//                            }
//                        }
//                    } else {
//                        for (int i = 1; i < source.getX() - destination.getX(); i++) {
//                            if (!(chessboard[destination.getX() + i][destination.getY() + i] instanceof EmptySlotComponent)) {
//                                return false;
//                            }
//                        }
//                    }
//                    return true;
//                }
//                if (destination.getX() - source.getX() == source.getY() - destination.getY()) {
//                    if (destination.getX() - source.getX() > 0) {
//                        for (int i = 1; i < destination.getX() - source.getX(); i++) {
//                            if (!(chessboard[source.getX() + i][source.getY() - i] instanceof EmptySlotComponent)) {
//                                return false;
//                            }
//                        }
//                    } else {
//                        for (int i = 1; i < source.getX() - destination.getX(); i++) {
//                            if (!(chessboard[destination.getX() + i][destination.getY() - i] instanceof EmptySlotComponent)) {
//                                return false;
//                            }
//                        }
//                    }
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    @Override
//    public String toString() {
//        return String.valueOf(this.name);
//    }
//}
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class BishopChessComponent extends ChessComponent {
//    private ChessboardPoint source; // Where the chess is
//    private ChessColor chessColor;
//    protected char name;

//    public BishopChessComponent( ChessColor chessColor) {
//        this.chessColor = chessColor;
//    }
//
//    public BishopChessComponent(ChessColor chessColor, char name) {
//        this.chessColor = chessColor;
//        this.name = name;
//    }
//public BishopChessComponent(char name) {
//    this.name = name;
//}


    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, char name) {
        super();
        this.setSource(source);
        this.setChessColor(chessColor);
        this.setName(name);
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> chessboardPoints=new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                ChessboardPoint chessboardPoint=new ChessboardPoint(x,y);
                if(can(chessboardPoint)){
                    chessboardPoints.add(chessboardPoint);
                }
            }
        }
        return chessboardPoints;
    }

    public boolean can(ChessboardPoint destination) {
        //diagonal
//            if ((Math.abs(destination.getX() - source.getX()) == Math.abs(destination.getY() - source.getY())) && destination.getX() - source.getX() != 0) {
//                //if have chess
//                int r = Math.min(source.getX(), destination.getX())+1 ;
//                int c = Math.min(source.getY(), destination.getY()) ;
//                while (r < Math.max(source.getX(), destination.getX()) && c < Math.max(source.getY(), destination.getY())) {
//                    //c = Math.min(source.getY(), destination.getY()) + 1;
//                    if (!(chessboard[r][c] instanceof EmptySlotComponent)) {
//                        return false;
//                    }
//
//                    r++;
//                    c++;
//                }
//                return true;
//            }
//            return false;
//        }
        if((chessboard[destination.getX()][destination.getY()].getChessColor())!=(chessboard[this.getSource().getX()][this.getSource().getY()].getChessColor())) {
            if (this.getSource().getX() != destination.getX()) {
                // two four
                if (destination.getX() - this.getSource().getX() == destination.getY() - this.getSource().getY()) {
                    //below
                    if (destination.getX() - this.getSource().getX() > 0) {
                        for (int i = 1; i < destination.getX() - this.getSource().getX(); i++) {
                            if (!(chessboard[this.getSource().getX() + i][this.getSource().getY() + i] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        }
                    }
                    //up
                    else {
                        for (int i = 1; i < this.getSource().getX() - destination.getX(); i++) {
                            if (!(chessboard[destination.getX() + i][destination.getY() + i] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
                //one three
                if (destination.getX() - this.getSource().getX() ==this.getSource().getY() - destination.getY()) {
                    //below
                    if (destination.getX() - this.getSource().getX() > 0) {
                        for (int i = 1; i < destination.getX() - this.getSource().getX(); i++) {
                            if (!(chessboard[this.getSource().getX() + i][this.getSource().getY() - i] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        }
                    }
                    //up
                    else {
                        for (int i = 1; i < this.getSource().getX() - destination.getX(); i++) {
                            if (!(chessboard[destination.getX() + i][destination.getY() - i] instanceof EmptySlotComponent)) {
                                return false;
                            }
                        }
                    }
                    return true;
                }
                return false;
            }
            return false;
        }
      return false;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }
}