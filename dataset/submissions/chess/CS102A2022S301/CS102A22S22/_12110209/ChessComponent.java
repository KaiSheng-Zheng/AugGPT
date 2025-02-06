import java.util.*;

public abstract class ChessComponent {
    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    public ChessComponent[][] chessboard = new ChessComponent[8][8];

    public void setName(char name) {
        this.name = name;
    }

    public ChessComponent() {
    }

    public ChessComponent(char name, ChessColor color, ChessboardPoint source) {
        this.name = name;
        this.chessColor = color;
        this.chessboard = new ChessComponent[8][8];
        this.source = source;
    }

    public abstract List<ChessboardPoint> canMoveTo();

    public String toString() {
        if (Objects.equals(chessColor, ChessColor.NONE)) {
            return String.valueOf(this.name);
        } else if (Objects.equals(chessColor, ChessColor.WHITE)) {
            return String.valueOf(Character.toLowerCase(this.name));
        } else return String.valueOf(this.name);
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public List<ChessboardPoint> rowComponentCheck() {
        List<ChessboardPoint> answer = new ArrayList<>();
        for (int i = 1; this.source.getY() - i >= 0; i++) {
            if (chessboard[this.source.getX()][this.source.getY() - i].name == '_') {
                answer.add(chessboard[this.source.getX()][this.source.getY() - i].source);
            } else {
                if ((!Character.isLowerCase(this.name) && Character.isLowerCase(chessboard[this.source.getX()][this.source.getY() - i].name))||(Character.isLowerCase(this.name) && !Character.isLowerCase(chessboard[this.source.getX()][this.source.getY() - i].name))) {
                    answer.add(chessboard[this.source.getX()][this.source.getY() - i].source);
                }break;
            }
        }
        for (int i = 1; this.source.getY() + i <= 7; i++) {
            if (chessboard[this.source.getX()][this.source.getY() + i].name == '_') {
                answer.add(chessboard[this.source.getX()][this.source.getY() + i].source);
            } else if ((!Character.isLowerCase(this.name) && Character.isLowerCase(chessboard[this.source.getX()][this.source.getY() + i].name))||(Character.isLowerCase(this.name) && !Character.isLowerCase(chessboard[this.source.getX()][this.source.getY() + i].name))) {
                answer.add(chessboard[this.source.getX()][this.source.getY() + i].source);
                break;
            } else break;
        }
        return answer;

    }

    public List<ChessboardPoint> columnComponentCheck() {
        List<ChessboardPoint> answer = new ArrayList<>();
        for (int i = 1; this.source.getX() - i >= 0; i++) {
            if (chessboard[this.source.getX() - i][this.source.getY()].name == '_') {
                answer.add(chessboard[this.source.getX() - i][this.source.getY()].source);
            } else if ((!Character.isLowerCase(this.name) && Character.isLowerCase(chessboard[this.source.getX() - i][this.source.getY()].name))||(Character.isLowerCase(this.name) &&! Character.isLowerCase(chessboard[this.source.getX() - i][this.source.getY()].name))) {
                answer.add(chessboard[this.source.getX() - i][this.source.getY()].source);
                break;
            } else break;
        }
        for (int i = 1; this.source.getX() + i <= 7; i++) {
            if (chessboard[this.source.getX() + i][this.source.getY()].name == '_') {
                answer.add(chessboard[this.source.getX() + i][this.source.getY()].source);
            } else if ((!Character.isLowerCase(this.name) && Character.isLowerCase(chessboard[this.source.getX() + i][this.source.getY()].name))||(Character.isLowerCase(this.name) &&! Character.isLowerCase(chessboard[this.source.getX() + i][this.source.getY()].name))) {
                answer.add(chessboard[this.source.getX() + i][this.source.getY()].source);
                break;
            } else break;
        }
        return answer;

    }

    public void setChessboard(ChessComponent[][] chessboard) {
        this.chessboard = chessboard;
    }

    public List<ChessboardPoint> crossLineComponentCheck() {
        List<ChessboardPoint> answer = new ArrayList<>();
        for (int i = 1; this.source.getX() - i >= 0 && this.source.getY() - i >= 0; i++) {
            if (chessboard[this.source.getX() - i][this.source.getY() - i].name == '_') {
                answer.add(chessboard[this.source.getX() - i][this.source.getY() - i].source);
            } else if ((!Character.isLowerCase(this.name) && Character.isLowerCase(chessboard[this.source.getX() -i][this.source.getY() - i].name))||(Character.isLowerCase(this.name) && !Character.isLowerCase(chessboard[this.source.getX() - i][this.source.getY() - i].name))) {
                answer.add(chessboard[this.source.getX() - i][this.source.getY() - i].source);
                break;
            } else break;
        }
        for (int i = 1; this.source.getX() + i <= 7 && this.source.getY() + i <= 7; i++) {
            if (chessboard[this.source.getX() + i][this.source.getY() + i].name == '_') {
                answer.add(chessboard[this.source.getX() + i][this.source.getY() + i].source);
            } else if ((!Character.isLowerCase(this.name) && Character.isLowerCase(chessboard[this.source.getX() + i][this.source.getY() + i].name))||(Character.isLowerCase(this.name) && !Character.isLowerCase(chessboard[this.source.getX() + i][this.source.getY() + i].name))) {
                answer.add(chessboard[this.source.getX() + i][this.source.getY() + i].source);
                break;
            } else break;
        }
        for (int i = 1; this.source.getX() + i <= 7 && this.source.getY() - i >= 0; i++) {
            if (chessboard[this.source.getX() + i][this.source.getY() - i].name == '_') {
                answer.add(chessboard[this.source.getX() + i][this.source.getY() - i].source);
            } else if ((!Character.isLowerCase(this.name) && Character.isLowerCase(chessboard[this.source.getX() + i][this.source.getY() - i].name))||(Character.isLowerCase(this.name) && !Character.isLowerCase(chessboard[this.source.getX() + i][this.source.getY() - i].name))) {
                answer.add(chessboard[this.source.getX() + i][this.source.getY() - i].source);
                break;
            } else break;
        }
        for (int i = 1; this.source.getX() - i >= 0 && this.source.getY() + i <= 7; i++) {
            if (chessboard[this.source.getX() - i][this.source.getY() + i].name == '_') {
                answer.add(chessboard[this.source.getX() - i][this.source.getY() + i].source);
            } else if ((!Character.isLowerCase(this.name) && Character.isLowerCase(chessboard[this.source.getX() - i][this.source.getY() + i].name))||(Character.isLowerCase(this.name) && !Character.isLowerCase(chessboard[this.source.getX() - i][this.source.getY() + i].name))) {
                answer.add(chessboard[this.source.getX() - i][this.source.getY() + i].source);
                break;
            } else break;
        }
        return answer;

    }


}
