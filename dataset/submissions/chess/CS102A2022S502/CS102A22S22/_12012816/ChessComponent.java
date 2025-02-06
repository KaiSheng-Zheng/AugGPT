import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    ChessComponent[][] chessComponents;
    protected char name;

    //should design
    public ChessComponent() {
    }

    public ChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
        this.chessColor = color;
        this.source=source;
        this.chessComponents=chessComponents;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public char getName() {
        return name;
    }

    public List<ChessboardPoint> getmovable(ChessboardPoint point, ChessComponent[][] chessComponents) {
        return new ArrayList<>();
    }
}
    class BishopChessComponent extends ChessComponent{

        public BishopChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
            super(color,source,chessComponents);
            this.name=color.equals(ChessColor.BLACK)?'B':'b';

        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            return getmovable(super.getSource(),chessComponents);
        }

        @Override
        public List<ChessboardPoint> getmovable(ChessboardPoint point, ChessComponent[][] chessComponents) {
            int x = point.getX();int y = point.getY();
            int xnew,ynew;
            List<ChessboardPoint> list=new ArrayList<>();
            ChessboardPoint temp;
            int[] dx={1,1,-1,-1};
            int[] dy={1,-1,-1,1};
            for (int index = 0; index < 4; index++) {
                for (int increment = 1; increment < 8; increment++) {
                    xnew=x+dx[index]*increment;ynew=y+dy[index]*increment;
                    if (xnew<8&&xnew>=0&&ynew<8&&ynew>=0){
                        ChessColor color = chessComponents[xnew][ynew].getChessColor();
                        if (color==ChessColor.NONE){
                            list.add(ChessboardPoint.creatPoint(xnew,ynew));
                        }else if (color!=chessComponents[x][y].getChessColor()){
                            list.add(ChessboardPoint.creatPoint(xnew,ynew));
                            break;
                        }else if (color==this.getChessColor())
                            break;
                    }

                }
            }
            Collections.sort(list);
            return list;
        }
    }

    class RookChessComponent extends ChessComponent {
        public RookChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
            super(color,source,chessComponents);
            this.name = color.equals(ChessColor.BLACK) ? 'R' : 'r';

        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            return getmovable(super.getSource(),chessComponents);
        }

        @Override
        public List<ChessboardPoint> getmovable(ChessboardPoint point, ChessComponent[][] chessComponents) {
            int x = point.getX();
            int y = point.getY();
            int xnew, ynew;
            List<ChessboardPoint> list = new ArrayList<>();
            ChessboardPoint temp;
            int[] dx = {0, 1, 0, -1};
            int[] dy = {1, 0, -1, 0};
            for (int index = 0; index < 4; index++) {
                for (int increment = 1; increment < 8; increment++) {
                    xnew = x + dx[index] * increment;
                    ynew = y + dy[index] * increment;
                    if (xnew < 8 && xnew >= 0 && ynew < 8 && ynew >= 0) {
                        ChessColor color = chessComponents[xnew][ynew].getChessColor();
                        if (color == ChessColor.NONE) {
                            list.add(ChessboardPoint.creatPoint(xnew, ynew));
                        } else if (color != chessComponents[x][y].getChessColor()) {
                            list.add(ChessboardPoint.creatPoint(xnew, ynew));
                            break;
                        } else if (color==this.getChessColor())
                            break;
                    }

                }
            }
            Collections.sort(list);
            return list;
        }
    }

    class QueenChessComponent extends ChessComponent {
        public QueenChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
            super(color,source,chessComponents);
            this.name = color.equals(ChessColor.BLACK) ? 'Q' : 'q';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            return getmovable(super.getSource(),chessComponents);
        }
        @Override
        public List<ChessboardPoint> getmovable(ChessboardPoint point, ChessComponent[][] chessComponents) {
            int x = point.getX();
            int y = point.getY();
            int xnew, ynew;
            List<ChessboardPoint> list = new ArrayList<>();
            ChessboardPoint temp;
            int[] dx = {0, 1, 1, 1, 0, -1, -1, -1};
            int[] dy = {1, 1, 0, -1, -1, -1, 0, 1};
            for (int index = 0; index < 8; index++) {
                for (int increment = 1; increment < 8; increment++) {
                    xnew = x + dx[index] * increment;
                    ynew = y + dy[index] * increment;
                    if (xnew < 8 && xnew >= 0 && ynew < 8 && ynew >= 0) {
                        ChessColor color = chessComponents[xnew][ynew].getChessColor();
                        if (color == ChessColor.NONE) {
                            list.add(ChessboardPoint.creatPoint(xnew, ynew));
                        }else if (color != chessComponents[x][y].getChessColor()) {
                            list.add(ChessboardPoint.creatPoint(xnew, ynew));
                            break;
                        }else if (color==this.getChessColor())
                            break;
                    }

                }
            }
            Collections.sort(list);
            return list;
        }
    }

    class PawnChessComponent extends ChessComponent {
        public PawnChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
            super(color,source,chessComponents);
            this.name = color.equals(ChessColor.BLACK) ? 'P' : 'p';

        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            return getmovable(super.getSource(),chessComponents);
        }

        @Override
        public List<ChessboardPoint> getmovable(ChessboardPoint point, ChessComponent[][] chessComponents) {
            int x = point.getX();
            int y = point.getY();
            int xnew, ynew;
            List<ChessboardPoint> list = new ArrayList<>();
            ChessboardPoint temp;
            if (chessComponents[x][y].getChessColor() == ChessColor.BLACK) {
                //move
                if (x == 1) {
                    if (chessComponents[x + 2][y].getChessColor() ==ChessColor.NONE && chessComponents[x + 1][y].getChessColor() == ChessColor.NONE){
                        list.add(new ChessboardPoint(x + 2, y));
                    }

                }
                if (x != 7) {
                    if (chessComponents[x + 1][y].getChessColor() == ChessColor.NONE)
                        list.add(new ChessboardPoint(x + 1, y));
                }
                //capture
                if (x != 7) {
                    if (y != 7) {
                        if (chessComponents[x+1][y + 1].getChessColor() == ChessColor.WHITE) {
                            list.add(new ChessboardPoint(x + 1, y + 1));
                        }
                    }
                    if (y != 0) {
                        if (chessComponents[x+1][y - 1].getChessColor() == ChessColor.WHITE) {
                            list.add(new ChessboardPoint(x + 1, y - 1));
                        }

                    }

                }

            } else if (chessComponents[x][y].getChessColor() == ChessColor.WHITE) {
                //move
                if (x == 6) {
                    if (chessComponents[x - 2][y].getChessColor() ==ChessColor.NONE && chessComponents[x - 1][y].getChessColor() == ChessColor.NONE){
                        list.add(new ChessboardPoint(x - 2, y));
                    }

                }
                if (x != 0) {
                    if (chessComponents[x - 1][y].getChessColor() == ChessColor.NONE)
                        list.add(new ChessboardPoint(x - 1, y));
                }

                //capture
                if (x != 0) {
                    if (y != 7) {
                        if (chessComponents[x-1][y + 1].getChessColor() == ChessColor.BLACK) {
                            list.add(new ChessboardPoint(x - 1, y + 1));
                        }
                    }
                    if (y != 0) {
                        if (chessComponents[x-1][y - 1].getChessColor() == ChessColor.BLACK) {
                            list.add(new ChessboardPoint(x - 1, y - 1));
                        }

                    }

                }

            }
            Collections.sort(list);
            return list;
        }
    }

    class KnightChessComponent extends ChessComponent {

        public KnightChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
            super(color,source,chessComponents);
            this.name = color.equals(ChessColor.BLACK) ? 'N' : 'n';

        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            return getmovable(super.getSource(),chessComponents);
        }

        public List<ChessboardPoint> getmovable(ChessboardPoint point, ChessComponent[][] chessComponents) {
            int x = point.getX();
            int y = point.getY();
            int xnew, ynew;ChessColor color;
            List<ChessboardPoint> list = new ArrayList<>();
            ChessboardPoint temp;
            int[] dx = {1, 2, 2, 1, -1, -2, -2, -1};
            int[] dy = {2, 1, -1, -2, -2, -1, 1, 2};
            for (int index = 0; index < 8; index++) {
                xnew = x + dx[index];
                ynew = y + dy[index];
                if (xnew < 8 && xnew >= 0 && ynew < 8 && ynew >= 0) {
                     color = chessComponents[xnew][ynew].getChessColor();
                    if (color != this.getChessColor()) {
                        list.add(new ChessboardPoint(xnew,ynew));
                    }
                }

            }
            Collections.sort(list);
            return list;
        }
    }

    class KingChessComponent extends ChessComponent {
        public KingChessComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
            super(color,source,chessComponents);
            this.name = color.equals(ChessColor.BLACK) ? 'K' : 'k';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            return getmovable(super.getSource(),chessComponents);
        }

        @Override
        public List<ChessboardPoint> getmovable(ChessboardPoint point, ChessComponent[][] chessComponents) {
            List<ChessboardPoint> list = new ArrayList<>();
            int x = point.getX();
            int y = point.getY();
            ChessboardPoint temp;
            for (int dx = -1; dx <= 1; dx++) {
                for (int dy = -1; dy <= 1; dy++) {
                    if (!(dy == 0 && dx == 0)) {
                        if (x+dx < 8 && x+dx >= 0 && y+dy < 8 && y+dy >= 0) {
                            if (chessComponents[x + dx][y + dy].getChessColor()!=this.getChessColor()){
                                temp = ChessboardPoint.creatPoint(x + dx, y + dy);
                                if (temp != null)
                                    list.add(temp);
                            }
                        }


                    }
                }
            }
            Collections.sort(list);
            return list;
        }

    }

    class EmptySlotComponent extends ChessComponent {
        public EmptySlotComponent(ChessColor color,ChessboardPoint source,ChessComponent[][] chessComponents) {
            super(color,source,chessComponents);
            this.name = '_';
        }

        @Override
        public List<ChessboardPoint> canMoveTo() {
            return new ArrayList<>();
        }

        @Override
        public List<ChessboardPoint> getmovable(ChessboardPoint point, ChessComponent[][] chessComponents) {
            return new ArrayList<ChessboardPoint>();
        }
    }

