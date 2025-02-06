import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <li>This class is an abstract class</li>
 * <li>This class helps to represent all the chess components on the chessboard.</li>
 * <li>This class provides a rough description for all the chess pieces. Abstract methods should be left in</li>
 * <li>abstract form for further implementation,</li>
 *
 * @author root
 */
public abstract class ChessComponent {

    /** Where the chess is */
    private ChessboardPoint source;
    /** What's the color */
    private ChessColor chessColor;
    /** What's the name */
    protected char name;

    protected ChessComponent[][] chessComponents;

    protected static final Integer UPPER_BOUND = 8;
    protected static final Integer DOWN_BOUND = 0;


    /** should design */
    public ChessComponent(){}

    /**
     * @return getter
     */
    public ChessboardPoint getSource() {
        return source;
    }

    /**
     * @param source setter
     */
    public ChessComponent setSource(ChessboardPoint source) {
        this.source = source;
        return this;
    }

    /**
     * @return getter
     */
    public ChessColor getChessColor() {
        return chessColor;
    }

    /**
     * @param chessColor setter
     */
    public ChessComponent setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
        return this;
    }

    /**
     * @return getter
     */
    public char getName() {
        return name;
    }

    /**
     * @param name setter
     */
    public ChessComponent setName(char name) {
        this.name = name;
        return this;
    }

    public ChessComponent[][] getChessComponents() {
        return chessComponents;
    }

    public ChessComponent setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
        return this;
    }

    /**
     * This abstract method tells where this chess piece can move to.
     * @return If no ChessboardPoint can be moved to, return an reference of empty List instead of null.
     */
    public abstract List<ChessboardPoint> canMoveTo();

    public boolean moveChess(int sourceX, int sourceY, int targetX, int targetY, ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
        if (getChessComponents() == null || getChessComponents().length < UPPER_BOUND) {
            return false;
        }
        return moveChess(sourceX, sourceY, targetX, targetY);
    }

    /**
     * 123
     * @param sourceX x
     * @param sourceY y
     * @param targetX x
     * @param targetY y
     * @return true
     */
    protected boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        return chessboardPoints.contains(new ChessboardPoint(targetX, targetY));
    }

    /**
     * should design
     * @return Return the name of current chess piece.
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ChessComponent that = (ChessComponent) o;
        return chessColor == that.chessColor;
    }

    @Override
    public int hashCode() {
        return Objects.hash(chessColor);
    }
}

class BishopChessComponent extends ChessComponent{

    public BishopChessComponent() {
        super.name = 'b';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = this.getSource();
        ChessComponent[][] chessComponents = this.getChessComponents();
        List<ChessboardPoint> targetPoint = new ArrayList<>();
        for (int x = source.getX() - 1, y = source.getY() - 1; x >= DOWN_BOUND && y >= DOWN_BOUND; x--, y--) {
            if (ChessColor.NONE.equals(chessComponents[x][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, y));
            } else if (getChessColor().equals(chessComponents[x][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, y));
                break;
            }
        }
        for (int x = source.getX() + 1, y = source.getY() + 1; x < UPPER_BOUND && y < UPPER_BOUND; x++, y++) {
            if (ChessColor.NONE.equals(chessComponents[x][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, y));
            } else if (getChessColor().equals(chessComponents[x][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, y));
                break;
            }

        }
        for (int x = source.getX() + 1, y = source.getY() - 1; x < UPPER_BOUND && y >= DOWN_BOUND; x++, y--) {
            if (ChessColor.NONE.equals(chessComponents[x][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, y));
            } else if (getChessColor().equals(chessComponents[x][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, y));
                break;
            }
        }
        for (int x = source.getX() - 1, y = source.getY() + 1; y < UPPER_BOUND && x >= DOWN_BOUND; y++, x--) {
            if (ChessColor.NONE.equals(chessComponents[x][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, y));
            } else if (getChessColor().equals(chessComponents[x][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, y));
                break;
            }
        }


        return targetPoint;
    }

}

class EmptySlotComponent extends ChessComponent{

    public EmptySlotComponent() {
        super.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }

}

class KingChessComponent extends ChessComponent{

    public KingChessComponent() {
        super.name = 'k';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessComponent[][] chessComponents = getChessComponents();
        List<ChessComponent> target = getTarget();
        return target.stream()
                .filter(s->!getChessColor().equals(chessComponents[s.getSource().getX()][s.getSource().getY()].getChessColor()))
                .map(ChessComponent::getSource)
                .collect(Collectors.toList());
    }

    @Override
    protected boolean moveChess(int sourceX, int sourceY, int targetX, int targetY) {
        List<ChessComponent> chessboardPoints = getTarget();
        List<ChessboardPoint> collect = chessboardPoints.stream().filter(s-> ChessColor.NONE.equals(s.getChessColor())).map(ChessComponent::getSource).collect(Collectors.toList());
        return collect.contains(new ChessboardPoint(targetX, targetY));
    }

    private List<ChessComponent> getTarget() {
        ChessboardPoint source = getSource();
        List<ChessComponent> targetPoints = new ArrayList<>();
        for (int x = source.getX() - 1; x <= source.getX() + 1; x ++) {
            for (int y = source.getY() - 1; y <= source.getY() + 1; y ++) {
                if (x >= DOWN_BOUND && x < UPPER_BOUND
                        && y >= DOWN_BOUND && y < UPPER_BOUND)
                targetPoints.add(getChessComponents()[x][y]);
            }
        }
        targetPoints.remove(source);
        return targetPoints.stream()
//                .filter(s -> s.getSource().getX() >= DOWN_BOUND && s.getSource().getX() < UPPER_BOUND
//                        && s.getSource().getY() >= DOWN_BOUND && s.getSource().getY() < UPPER_BOUND)
                .collect(Collectors.toList());

    }

}

class KnightChessComponent extends ChessComponent {

    private static final List<Integer> list = List.of(-1, 1, -2, 2);

    public KnightChessComponent() {
        super.name = 'n';
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> targetPoint = new ArrayList<>();
        ChessComponent[][] chessComponents = this.getChessComponents();
        ChessboardPoint source = this.getSource();
        for (int i = 0; i < list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (Math.abs(list.get(i)) != Math.abs(list.get(j))) {

                    if (source.getX() + list.get(i) >= DOWN_BOUND && source.getX() + list.get(i) < UPPER_BOUND
                            && source.getY() + list.get(j) >= DOWN_BOUND && source.getY() + list.get(j) < UPPER_BOUND
                            && !this.getChessColor().equals(chessComponents[source.getX() + list.get(i)][source.getY() + list.get(j)].getChessColor())) {
                        targetPoint.add(new ChessboardPoint(source.getX() + list.get(i), source.getY() + list.get(j)));
                    }
                    if (source.getX() + list.get(j) >= DOWN_BOUND && source.getX() + list.get(j) < UPPER_BOUND
                            && source.getY() + list.get(i) >= DOWN_BOUND && source.getY() + list.get(i) < UPPER_BOUND
                            && !this.getChessColor().equals(chessComponents[source.getX() + list.get(j)][source.getY() + list.get(i)].getChessColor())) {
                        targetPoint.add(new ChessboardPoint(source.getX() + list.get(j), source.getY() + list.get(i)));
                    }
                }
            }
        }
        return targetPoint;
    }
}



class PawnChessComponent extends ChessComponent{

    public PawnChessComponent() {
        super.name = 'p';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> targetPoin = new ArrayList<>();
        ChessComponent[][] chessComponents = this.getChessComponents();
        ChessboardPoint source = this.getSource();

        if (ChessColor.BLACK.equals(this.getChessColor()) && source.getX() + 1 < UPPER_BOUND) {
            ChessComponent chessComponent = chessComponents[source.getX() + 1][source.getY()];
            if (ChessColor.NONE.equals(chessComponent.getChessColor())) {
                targetPoin.add(new ChessboardPoint(source.getX()+1, source.getY()));
                if (source.getX() == 1) {
                    chessComponent = chessComponents[source.getX() + 2][source.getY()];
                    if (ChessColor.NONE.equals(chessComponent.getChessColor())) {
                        targetPoin.add(new ChessboardPoint(source.getX()+2, source.getY()));
                    }
                }
            }
            if (source.getY() - 1 >= DOWN_BOUND) {
                chessComponent = chessComponents[source.getX() + 1][source.getY() - 1];
                if (ChessColor.WHITE.equals(chessComponent.getChessColor())) {
                    targetPoin.add(new ChessboardPoint(source.getX() + 1, source.getY() - 1));
                }
            }
            if (source.getY() + 1 < UPPER_BOUND) {
                chessComponent = chessComponents[source.getX() + 1][source.getY() + 1];
                if (ChessColor.WHITE.equals(chessComponent.getChessColor())) {
                    targetPoin.add(new ChessboardPoint(source.getX() + 1, source.getY() + 1));
                }
            }
        }
        if (ChessColor.WHITE.equals(this.getChessColor()) && source.getX() - 1 >= DOWN_BOUND) {
            ChessComponent chessComponent = chessComponents[source.getX() - 1][source.getY()];
            if (ChessColor.NONE.equals(chessComponent.getChessColor())) {
                targetPoin.add(new ChessboardPoint(source.getX()-1, source.getY()));
                if (source.getX() == 6) {
                    chessComponent = chessComponents[source.getX() - 2][source.getY()];
                    if (ChessColor.NONE.equals(chessComponent.getChessColor())) {
                        targetPoin.add(new ChessboardPoint(source.getX()-2, source.getY()));
                    }
                }
            }
            if (source.getY() - 1 >= DOWN_BOUND) {
                chessComponent = chessComponents[source.getX() - 1][source.getY() - 1];
                if (ChessColor.BLACK.equals(chessComponent.getChessColor())) {
                    targetPoin.add(new ChessboardPoint(source.getX() - 1, source.getY() - 1));
                }
            }
            if (source.getY() + 1 < UPPER_BOUND) {
                chessComponent = chessComponents[source.getX() - 1][source.getY() + 1];
                if (ChessColor.BLACK.equals(chessComponent.getChessColor())) {
                    targetPoin.add(new ChessboardPoint(source.getX() - 1, source.getY() + 1));
                }
            }
        }
        return targetPoin;
    }


}

class QueenChessComponent extends ChessComponent{

    public QueenChessComponent() {
        super.name = 'q';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = this.getSource();
        ChessComponent[][] chessComponents = this.getChessComponents();
        List<ChessboardPoint> targetPoint = new ArrayList<>();
        // Bishop
        for (int x = source.getX() - 1, y = source.getY() - 1; x >= DOWN_BOUND && y >= DOWN_BOUND; x--, y--) {
            if (ChessColor.NONE.equals(chessComponents[x][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, y));
            } else if (getChessColor().equals(chessComponents[x][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, y));
                break;
            }
        }
        for (int x = source.getX() + 1, y = source.getY() + 1; x < UPPER_BOUND && y < UPPER_BOUND; x++, y++) {
            if (ChessColor.NONE.equals(chessComponents[x][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, y));
            } else if (getChessColor().equals(chessComponents[x][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, y));
                break;
            }

        }
        for (int x = source.getX() + 1, y = source.getY() - 1; x < UPPER_BOUND && y >= DOWN_BOUND; x++, y--) {
            if (ChessColor.NONE.equals(chessComponents[x][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, y));
            } else if (getChessColor().equals(chessComponents[x][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, y));
                break;
            }
        }
        for (int x = source.getX() - 1, y = source.getY() + 1; y < UPPER_BOUND && x >= DOWN_BOUND; y++, x--) {
            if (ChessColor.NONE.equals(chessComponents[x][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, y));
            } else if (getChessColor().equals(chessComponents[x][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, y));
                break;
            }
        }
        // Rook
        for (int x = source.getX() - 1; x >= DOWN_BOUND; x--) {
            if (ChessColor.NONE.equals(chessComponents[x][source.getY()].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, source.getY()));
            } else if (getChessColor().equals(chessComponents[x][source.getY()].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, source.getY()));
                break;
            }
        }
        for (int x = source.getX() + 1; x < UPPER_BOUND; x++) {
            if (ChessColor.NONE.equals(chessComponents[x][source.getY()].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, source.getY()));
            } else if (getChessColor().equals(chessComponents[x][source.getY()].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, source.getY()));
                break;
            }
        }
        for (int y = source.getY() - 1; y >= DOWN_BOUND ; y--) {
            if (ChessColor.NONE.equals(chessComponents[source.getX()][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(source.getX(), y));
            } else if (getChessColor().equals(chessComponents[source.getX()][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(source.getX(), y));
                break;
            }
        }
        for (int y = source.getY() + 1; y < UPPER_BOUND; y++) {
            if (ChessColor.NONE.equals(chessComponents[source.getX()][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(source.getX(), y));
            } else if (getChessColor().equals(chessComponents[source.getX()][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(source.getX(), y));
                break;
            }
        }
        return targetPoint;
    }

}

class RookChessComponent extends ChessComponent{

    public RookChessComponent() {
        super.name = 'r';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = this.getSource();
        ChessComponent[][] chessComponents = this.getChessComponents();
        List<ChessboardPoint> targetPoint = new ArrayList<>();
        for (int x = source.getX() - 1; x >= DOWN_BOUND; x--) {
            if (ChessColor.NONE.equals(chessComponents[x][source.getY()].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, source.getY()));
            } else if (getChessColor().equals(chessComponents[x][source.getY()].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, source.getY()));
                break;
            }
        }
        for (int x = source.getX() + 1; x < UPPER_BOUND; x++) {
            if (ChessColor.NONE.equals(chessComponents[x][source.getY()].getChessColor())) {
                targetPoint.add(new ChessboardPoint(x, source.getY()));
            } else if (getChessColor().equals(chessComponents[x][source.getY()].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(x, source.getY()));
                break;
            }
        }
        for (int y = source.getY() - 1; y >= DOWN_BOUND ; y--) {
            if (ChessColor.NONE.equals(chessComponents[source.getX()][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(source.getX(), y));
            } else if (getChessColor().equals(chessComponents[source.getX()][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(source.getX(), y));
                break;
            }
        }
        for (int y = source.getY() + 1; y < UPPER_BOUND; y++) {
            if (ChessColor.NONE.equals(chessComponents[source.getX()][y].getChessColor())) {
                targetPoint.add(new ChessboardPoint(source.getX(), y));
            } else if (getChessColor().equals(chessComponents[source.getX()][y].getChessColor())) {
                break;
            } else {
                targetPoint.add(new ChessboardPoint(source.getX(), y));
                break;
            }
        }
        return targetPoint;
    }

}

class ChessmanFactory {

    /**
     * @param name Piece name
     * @param source subscript
     * @return the piece class based on the piece name
     */
    public ChessComponent productionChessman(char name, ChessboardPoint source) {
        ChessComponent chessComponent;
        switch (Character.toLowerCase(name)) {
            case 'r': chessComponent = new RookChessComponent(); break;
            case 'n': chessComponent = new KnightChessComponent(); break;
            case 'b': chessComponent = new BishopChessComponent(); break;
            case 'q': chessComponent = new QueenChessComponent(); break;
            case 'k': chessComponent = new KingChessComponent(); break;
            case 'p': chessComponent = new PawnChessComponent(); break;
            default: chessComponent = new EmptySlotComponent(); break;
        }
        return chessComponent
                .setName(name)
                .setSource(source)
                .setChessColor(ChessColor.productionColor(name));
    }
}