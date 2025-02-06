import java.util.ArrayList;
        import java.util.Comparator;
        import java.util.List;

public abstract class ChessComponent {
    protected ChessboardPoint source;
    protected ChessColor chessColor;
    public ChessComponent[][] chessComponents;
    protected char name;

    public ChessComponent() {}

    public abstract List<ChessboardPoint> canMoveTo();

    public char getName(){
        return name;
    }

    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor(){
        return chessColor;
    }

    public void setChessComponents(ChessComponent[][] chessComponents){
        this.chessComponents = chessComponents;
    }
}


class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent(ChessboardPoint chessboardPoint){}

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points= new ArrayList<>();
        return points;
    }





}

class KingChessComponent extends ChessComponent{

    public KingChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor =chessColor;
        if(chessColor==ChessColor.BLACK){
            this.name='K';
        }else{
            this.name='k';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points= new ArrayList<>();
        int[] a = {-1,0,1};
        for(int i =0;i<3;i++){
            for (int j=0;j<3;j++){
                ChessboardPoint point = source.offset(a[i],a[j]);
                if(point !=null){
                    if(chessComponents[point.getX()][point.getY()].getChessColor()!=chessColor) {
                        points.add(source.offset(a[i], a[j]));
                    }
                }
            }
        }
        return points;
    }
}


class QueenChessComponent extends ChessComponent{
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor =chessColor;
        if(chessColor==ChessColor.BLACK){
            this.name='Q';
        }else{
            this.name='q';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points= new ArrayList<>();
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(i,i);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(-i,-i);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(i,-i);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(-i,i);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(i,0);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(-i,0);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(0,i);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(0,-i);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }

        points.sort(Comparator.comparing(ChessboardPoint::getY));
        points.sort(Comparator.comparing(ChessboardPoint::getX));
        return points;
    }
}


class RookChessComponent extends ChessComponent{

    public RookChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor =chessColor;
        if(chessColor==ChessColor.BLACK){
            this.name='R';
        }else{
            this.name='r';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points= new ArrayList<>();
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(i,0);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(-i,0);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(0,i);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i = 1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(0,-i);
            if(chessboardPoint!=null){
                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
                        break;
                    }
                }
            }
        }

        points.sort(Comparator.comparing(ChessboardPoint::getY));
        points.sort(Comparator.comparing(ChessboardPoint::getX));
        return points;
    }
}


class BishopChessComponent extends ChessComponent{
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor =chessColor;
        if(chessColor==ChessColor.BLACK){
            this.name='B';
        }else{
            this.name='b';
        }
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points= new ArrayList<>();
        for(int i=1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(i,i);
            if(chessboardPoint != null){
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }else{
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!= ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i=1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(-i,-i);
            if(chessboardPoint != null){
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }else{
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!= ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i=1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(i,-i);
            if(chessboardPoint != null){
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }else{
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!= ChessColor.NONE){
                        break;
                    }
                }
            }
        }
        for(int i=1;i<8;i++){
            ChessboardPoint chessboardPoint = source.offset(-i,i);
            if(chessboardPoint != null){
                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
                    break;
                }else{
                    points.add(chessboardPoint);
                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!= ChessColor.NONE){
                        break;
                    }
                }
            }
        }
//        for(int i = 1;i<8;i++){
//            ChessboardPoint chessboardPoint = source.offset(i,i);
//            if(chessboardPoint!=null){
//                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
//                    break;
//                }
//                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
//                    points.add(chessboardPoint);
//                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
//                        break;
//                    }
//                }
//            }
//        }
//        for(int i = 1;i<8;i++){
//            ChessboardPoint chessboardPoint = source.offset(-i,-i);
//            if(chessboardPoint!=null){
//                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
//                    break;
//                }
//                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
//                    points.add(chessboardPoint);
//                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
//                        break;
//                    }
//                }
//            }
//        }
//        for(int i = 1;i<8;i++){
//            ChessboardPoint chessboardPoint = source.offset(i,-i);
//            if(chessboardPoint!=null){
//                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
//                    break;
//                }
//                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
//                    points.add(chessboardPoint);
//                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
//                        break;
//                    }
//                }
//            }
//        }
//        for(int i = 1;i<8;i++){
//            ChessboardPoint chessboardPoint = source.offset(-i,i);
//            if(chessboardPoint!=null){
//                if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()==chessColor){
//                    break;
//                }
//                if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=chessColor){
//                    points.add(chessboardPoint);
//                    if(chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor()!=ChessColor.NONE){
//                        break;
//                    }
//                }
//            }
//        }

        points.sort(Comparator.comparing(ChessboardPoint::getY));
        points.sort(Comparator.comparing(ChessboardPoint::getX));
        return points;
    }
}


class KnightChessComponent extends ChessComponent{
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor =chessColor;
        if(chessColor==ChessColor.BLACK){
            this.name='N';
        }else{
            this.name='n';
        }
    }



    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points= new ArrayList<>();
        int[][] a = {{-2,-1},{-2,+1},{-1,-2},{-1,+2},{1,-2},{1,+2},{2,-1},{2,+1}};
        for(int i =0;i<8;i++){
            ChessboardPoint point = source.offset(a[i][0],a[i][1]);
            if(point !=null){
                if(chessComponents[point.getX()][point.getY()].getChessColor()!=chessColor) {
                    points.add(source.offset(a[i][0], a[i][1]));
                }
            }
        }
        return points;
    }
}


class PawnChessComponent extends ChessComponent{
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor =chessColor;
        if(chessColor==ChessColor.BLACK){
            this.name='P';
        }else{
            this.name='p';
        }
    }




    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points= new ArrayList<>();
        boolean eatenPassBy = false;
        boolean firstStep = true;
        boolean advantage = false;


        if(chessColor == ChessColor.BLACK) {
            firstStep = source.getX() == 1;
            if (firstStep) {
                for (int i = 1; i < 3; i++) {
                    ChessboardPoint chessboardPoint = source.offset(i, 0);
                    if (chessboardPoint != null) {
                        if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() != ChessColor.NONE) {
                            break;
                        } else {
                            points.add(chessboardPoint);
                        }
                    }
                }
                int[][] a = {{1, -1}, {1, 1}};
                for (int i = 0; i < 2; i++) {
                    ChessboardPoint chessboardPoint = source.offset(a[i][0], a[i][1]);
                    if (chessboardPoint != null) {
                        if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.WHITE) {
                            points.add(chessboardPoint);
                        }
                    }
                }

            } else {
                ChessboardPoint chessboardPoint = source.offset(1, 0);
                if (chessboardPoint != null) {
                    if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.NONE) {
                        points.add(chessboardPoint);
                    }
                }
                int[][] a = {{1, -1}, {1, 1}};
                for (int i = 0; i < 2; i++) {
                    chessboardPoint = source.offset(a[i][0], a[i][1]);
                    if (chessboardPoint != null) {
                        if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.WHITE) {
                            points.add(chessboardPoint);
                        }
                    }
                }
            }
        }
            if (chessColor == ChessColor.WHITE) {
                firstStep = source.getX() == 6;
                if (firstStep) {
                    for (int i = 1; i < 3; i++) {
                        ChessboardPoint chessboardPoint = source.offset(-i,0);
                        if (chessboardPoint != null) {
                            if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() != ChessColor.NONE) {
                                break;
                            } else {
                                points.add(chessboardPoint);
                            }
                        }
                    }
                    int[][] a = {{-1, -1}, {-1, 1}};
                    for (int i = 0; i < 2; i++) {
                        ChessboardPoint chessboardPoint = source.offset(a[i][0], a[i][1]);
                        if (chessboardPoint != null) {
                            if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.BLACK) {
                                points.add(chessboardPoint);
                            }
                        }
                    }

                } else {
                    ChessboardPoint chessboardPoint = source.offset(-1, 0);
                    if (chessboardPoint != null) {
                        if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.NONE) {
                            points.add(chessboardPoint);
                        }
                    }
                    int[][] a = {{-1, -1}, {-1, 1}};
                    for (int i = 0; i < 2; i++) {
                        chessboardPoint = source.offset(a[i][0], a[i][1]);
                        if (chessboardPoint != null) {
                            if (chessComponents[chessboardPoint.getX()][chessboardPoint.getY()].getChessColor() == ChessColor.BLACK) {
                                points.add(chessboardPoint);
                            }
                        }
                    }
                }
            }

        points.sort(Comparator.comparing(ChessboardPoint::getY));
        points.sort(Comparator.comparing(ChessboardPoint::getX));
        return points;
    }
}


class EmptyChessComponent extends ChessComponent{
    public EmptyChessComponent(ChessboardPoint source) {
        this.source = source;
        this.chessColor =ChessColor.NONE;
        this.name='_';
    }




    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> points= new ArrayList<>();
        return points;
    }
}

