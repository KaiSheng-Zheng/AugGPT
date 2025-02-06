import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;
    public ChessComponent() {
    }

    public void setChessComponents(ChessComponent[][] chessComponents) {
        this.chessComponents = chessComponents;
    }

    public abstract List<ChessboardPoint> canMoveTo();
    public  boolean canMoveTo(ChessboardPoint source) {

        return true;
    }

    public List<ChessboardPoint> MycanMoveTo(ChessComponent[][] chessComponents) {
        return null;
    }

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public char getName() {
        return name;
    }

    public void setName(char name) {
        this.name = name;
    }
}
class KingChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessComponent sourceComponent = chessComponents[source.getX()][source.getY()];
        ChessColor chessColor = getChessColor();
        String colorName = chessColor.name();
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint offset;
        int dx[] = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int dy[] = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        for (int j = 0; j < 8; j++) {
            offset = source.offset(dx[j], dy[j]);
            if (offset != null) {
                ChessComponent component = chessComponents[offset.getX()][offset.getY()];
                if (component.getChessColor().name().equals(colorName)) continue;
                list.add(offset);
            }
        }

        return list;
    }
    public  boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint c: chessboardPoints) {
            if (target.getX() == c.getX() && target.getY() == c.getY()) return true;
        }
        return false;
    }
}

class QueenChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessComponent sourceComponent = chessComponents[source.getX()][source.getY()];
        ChessColor chessColor = getChessColor();
        String colorName = chessColor.name();
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint offset;
        int dx[] = new int[]{-1, -1, 0, 1, 1, 1, 0, -1};
        int dy[] = new int[]{0, 1, 1, 1, 0, -1, -1, -1};
        for (int j = 0; j < 8; j++) {
            for (int i = 1; i <= 8; i++) {
                offset = source.offset(i * dx[j], i * dy[j]);
                if (offset != null) {
                    ChessComponent component = chessComponents[offset.getX()][offset.getY()];
                    if (component.getChessColor().name().equals("NONE")) {
                        list.add(offset);
                    } else if (component.getChessColor().name().equals(colorName)) {
                        break;
                    } else if (!component.getChessColor().name().equals(colorName)) {
                        list.add(offset);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        Collections.sort(list);
        return list;
    }
    public  boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint c: chessboardPoints) {
            if (target.getX() == c.getX() && target.getY() == c.getY()) return true;
        }
        return false;
    }
}

class RookChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessComponent sourceComponent = chessComponents[source.getX()][source.getY()];
        ChessColor chessColor = getChessColor();
        String colorName = chessColor.name();
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint offset;
        int dx[] = new int[]{-1, 1, 0, 0};
        int dy[] = new int[]{0, 0, -1, 1};
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i <= 8; i++) {
                offset = source.offset(i * dx[j], i * dy[j]);
                if (offset != null) {
                    ChessComponent component = chessComponents[offset.getX()][offset.getY()];
                    if (component.getChessColor().name().equals("NONE")) {
                        list.add(offset);
                    } else if (component.getChessColor().name().equals(colorName)) {
                        break;
                    } else if (!component.getChessColor().name().equals(colorName)) {
                        list.add(offset);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        Collections.sort(list);
        return list;
    }
    public  boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint c: chessboardPoints) {
            if (target.getX() == c.getX() && target.getY() == c.getY()) return true;
        }
        return false;
    }
}
class BishopChessComponentz extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessComponent sourceComponent = chessComponents[source.getX()][source.getY()];
        ChessColor chessColor = getChessColor();
        String colorName = chessColor.name();
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint offset;
        int dx[] = new int[]{-1, -1, 1, 1};
        int dy[] = new int[]{-1, 1, -1, 1};
        for (int j = 0; j < 4; j++) {
            for (int i = 1; i <= 8; i++) {
                offset = source.offset(i * dx[j], i * dy[j]);
                if (offset != null) {
                    ChessComponent component = chessComponents[offset.getX()][offset.getY()];
                    if (component.getChessColor().name().equals("NONE")) {
                        list.add(offset);
                    } else if (component.getChessColor().name().equals(colorName)) {
                        break;
                    } else if (!component.getChessColor().name().equals(colorName)) {
                        list.add(offset);
                        break;
                    }
                } else {
                    break;
                }
            }
        }
        Collections.sort(list);
        return list;
    }
    public boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint c: chessboardPoints) {
            if (target.getX() == c.getX() && target.getY() == c.getY()) return true;
        }
        return false;
    }
}

class KnightChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessComponent sourceComponent = chessComponents[source.getX()][source.getY()];
        ChessColor chessColor = sourceComponent.getChessColor();
        String colorName = chessColor.name();
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint offset;
        int dx[] = new int[]{-1, -2, -2, -1, 1, 2, 2, 1};
        int dy[] = new int[]{-2, -1, 1, 2, 2, 1, -1, -2};
        for (int i = 0; i < 8; i++) {
            offset = source.offset(dx[i], dy[i]);
            if (offset != null) {
                ChessComponent component = chessComponents[offset.getX()][offset.getY()];

                if (component.getChessColor().name().equals(colorName)) continue;
                list.add(offset);
            }
        }
        Collections.sort(list);
        return list;
    }
    public  boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint c: chessboardPoints) {
            if (target.getX() == c.getX() && target.getY() == c.getY()) return true;
        }
        return false;
    }
}

class PawnChessComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        ChessboardPoint source = getSource();
        ChessColor chessColor = getChessColor();
        String colorName = chessColor.name();
        List<ChessboardPoint> list = new ArrayList<>();
        ChessboardPoint offset = null;
        if (colorName.equals("BLACK") && source.getX() == 1) {
            offset = source.offset(2, 0);
        } else if (colorName.equals("WHITE") && source.getX() == 6) {
            offset = source.offset(-2, 0);
        }
        ChessComponent component;
        if (offset != null) {
            component = chessComponents[offset.getX()][offset.getY()];
            if (!component.getChessColor().name().equals("NONE")) {
                offset = null;
            }
        }
        if (offset != null) {
            list.add(offset);
        }

        if (colorName.equals("BLACK")) {
            offset = source.offset(1, 0);
        } else {
            offset = source.offset(-1, 0);
        }
        if (offset != null) {
            component = chessComponents[offset.getX()][offset.getY()];
            if (!component.getChessColor().name().equals("NONE")) {
                offset = null;
            }
        }
        if (offset != null) {
            list.add(offset);
        }

        if (colorName.equals("BLACK")) {
            offset = source.offset(1, -1);
            if (offset != null) {
                component = chessComponents[offset.getX()][offset.getY()];
                if (!component.getChessColor().name().equals("WHITE")) {
                    offset = null;
                }
            }
            if (offset != null) {
                list.add(offset);
            }
            offset = source.offset(1, 1);
            if (offset != null) {
                component = chessComponents[offset.getX()][offset.getY()];
                if (!component.getChessColor().name().equals("WHITE")) {
                    offset = null;
                }
            }
            if (offset != null) {
                list.add(offset);
            }
        }

        if (colorName.equals("WHITE")) {
            offset = source.offset(-1, -1);
            if (offset != null) {
                component = chessComponents[offset.getX()][offset.getY()];
                if (!component.getChessColor().name().equals("BLACK")) {
                    offset = null;
                }
            }
            if (offset != null) {
                list.add(offset);
            }
            offset = source.offset(-1, 1);
            if (offset != null) {
                component = chessComponents[offset.getX()][offset.getY()];
                if (!component.getChessColor().name().equals("BLACK")) {
                    offset = null;
                }
            }
            if (offset != null) {
                list.add(offset);
            }
        }
        Collections.sort(list);
        return list;
    }
    public  boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint c: chessboardPoints) {
            if (target.getX() == c.getX() && target.getY() == c.getY()) return true;
        }
        return false;
    }
}

class EmptySlotComponent extends ChessComponent {
    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<ChessboardPoint>();
    }

    @Override
    public String toString() {
        return "_";
    }
    public List<ChessboardPoint> MycanMoveTo(ChessComponent[][] chessComponents) {

        return new ArrayList<ChessboardPoint>();
    }
    public  boolean canMoveTo(ChessboardPoint target) {
        List<ChessboardPoint> chessboardPoints = canMoveTo();
        for (ChessboardPoint c: chessboardPoints) {
            if (target.getX() == c.getX() && target.getY() == c.getY()) return true;
        }
        return false;
    }
}
