import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {

    public ChessComponent[][] theBoard;

    private ChessboardPoint source;

    private ChessColor chessColor;

    protected char name;

    public ChessComponent() {
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(name);
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public void setTheBoard(ChessComponent[][] theBoard) {
        this.theBoard = theBoard;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }
}

class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] theBoard) {
        setSource(source);
        setChessColor(chessColor);
        setTheBoard(theBoard);
        if (chessColor == ChessColor.WHITE) {
            name = 'k';
        } else {
            name = 'K';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (Math.abs(i - getSource().getX()) <= 1 && Math.abs(j - getSource().getY()) <= 1) {
                    if (theBoard[i][j].getChessColor() != this.getChessColor()) {
                        canMo.add(new ChessboardPoint(i, j));
                    }
                }
            }
        }
        if (canMo.isEmpty()) {
            return new ArrayList<>();
        } else return canMo;
    }
}

class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] theBoard) {
        setSource(source);
        setChessColor(chessColor);
        setTheBoard(theBoard);
        if (chessColor == ChessColor.WHITE) {
            name = 'q';
        } else {
            name = 'Q';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMo = new ArrayList<>();

        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (Math.abs(x - this.getSource().getX()) == Math. abs(y - this.getSource().getY())) {
                    if (x > this.getSource().getX() && y > this.getSource().getY()){
                        boolean canMove = true;
                        for (int k = 1; k < x - this.getSource().getX(); k++) {
                            if (!(theBoard[this.getSource().getX()+k][this.getSource().getY()+k] instanceof  EmptySlotComponent)){
                                canMove = false;
                                break;
                            }
                        }
                        if (canMove && theBoard[x][y].getChessColor()!=this.getChessColor()){
                            canMo.add(new ChessboardPoint(x,y));
                        }
                    }
                    if (x > this.getSource().getX() && y < this.getSource().getY()){
                        boolean canMove = true;
                        for (int k = 1; k < x - this.getSource().getX(); k++) {
                            if (!(theBoard[this.getSource().getX()+k][this.getSource().getY()-k] instanceof  EmptySlotComponent)){
                                canMove = false;
                                break;
                            }
                        }
                        if (canMove && theBoard[x][y].getChessColor()!=this.getChessColor()){
                            canMo.add(new ChessboardPoint(x,y));
                        }
                    }
                    if (x < this.getSource().getX() && y > this.getSource().getY()){
                        boolean canMove = true;
                        for (int k = 1; k < this.getSource().getX() - x; k++) {
                            if (!(theBoard[this.getSource().getX()-k][this.getSource().getY()+k] instanceof  EmptySlotComponent)){
                                canMove = false;
                                break;
                            }
                        }
                        if (canMove && theBoard[x][y].getChessColor()!=this.getChessColor()){
                            canMo.add(new ChessboardPoint(x,y));
                        }
                    }
                    if (x < this.getSource().getX() && y < this.getSource().getY()){
                        boolean canMove = true;
                        for (int k = 1; k < this.getSource().getX()-x; k++) {
                            if (!(theBoard[this.getSource().getX()-k][this.getSource().getY()-k] instanceof  EmptySlotComponent)){
                                canMove = false;
                                break;
                            }
                        }
                        if (canMove && theBoard[x][y].getChessColor()!=this.getChessColor()){
                            canMo.add(new ChessboardPoint(x,y));
                        }
                    }
                }else {
                    if (x == this.getSource().getX()){
                        boolean can = true;
                        for (int k = Math.min(y,this.getSource().getY()) + 1; k < Math.max(y,this.getSource().getY()); k++) {
                            if (!(theBoard[x][k] instanceof EmptySlotComponent)) {
                                can = false;
                                break;
                            }
                        }
                        if (can && theBoard[x][y].getChessColor() != this.getChessColor()){
                            canMo.add(new ChessboardPoint(x,y));
                        }
                    }
                    if (y == this.getSource().getY()){
                        boolean can = true;
                        for (int k = Math.min(x,this.getSource().getX()) + 1; k < Math.max(x,this.getSource().getX()); k++) {
                            if (!(theBoard[k][y] instanceof EmptySlotComponent)) {
                                can = false;
                                break;
                            }
                        }
                        if (can && theBoard[x][y].getChessColor() != this.getChessColor()){
                            canMo.add(new ChessboardPoint(x,y));
                        }
                    }
                }
            }
        }
        if (canMo.isEmpty()) {
            return new ArrayList<>();
        } else return canMo;
    }
}

class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] theBoard) {
        setSource(source);
        setChessColor(chessColor);
        setTheBoard(theBoard);
        if (chessColor == ChessColor.WHITE) {
            name = 'r';
        } else {
            name = 'R';
        }
    }
    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMo = new ArrayList<>();
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (!(row == this.getSource().getX() && col == this.getSource().getY())){
                    if (row == this.getSource().getX()){
                        boolean can = true;
                        for (int k = Math.min(col,this.getSource().getY()) + 1; k < Math.max(col,this.getSource().getY()); k++) {
                            if (!(theBoard[row][k] instanceof EmptySlotComponent)) {
                                can = false;
                                break;
                            }
                        }
                        if (can && theBoard[row][col].getChessColor() != this.getChessColor()){
                            canMo.add(new ChessboardPoint(row,col));
                        }
                    }
                    if (col == this.getSource().getY()){
                        boolean can = true;
                        for (int k = Math.min(row,this.getSource().getX()) + 1; k < Math.max(row,this.getSource().getX()); k++) {
                            if (!(theBoard[k][col] instanceof EmptySlotComponent)) {
                                can = false;
                                break;
                            }
                        }
                        if (can && theBoard[row][col].getChessColor() != this.getChessColor()){
                            canMo.add(new ChessboardPoint(row,col));
                        }
                    }
                }
            }
        }
        if (canMo.isEmpty()) {
            return new ArrayList<>();
        } else return canMo;
    }
}

class BishopChessComponent extends ChessComponent {
    public BishopChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] theBoard) {
        setSource(source);
        setChessColor(chessColor);
        setTheBoard(theBoard);
        if (chessColor == ChessColor.WHITE) {
            name = 'b';
        } else {
            name = 'B';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMo = new ArrayList<>();
        for (int x = 0; x < 8; x++) {
            for (int y = 0; y < 8; y++) {
                if (Math.abs(x - this.getSource().getX()) == Math. abs(y - this.getSource().getY())) {
                    if (x > this.getSource().getX() && y > this.getSource().getY()){
                        boolean canMove = true;
                        for (int k = 1; k < x - this.getSource().getX(); k++) {
                            if (!(theBoard[this.getSource().getX()+k][this.getSource().getY()+k] instanceof  EmptySlotComponent)){
                                canMove = false;
                                break;
                            }
                        }
                        if (canMove && theBoard[x][y].getChessColor()!=this.getChessColor()){
                            canMo.add(new ChessboardPoint(x,y));
                        }
                    }
                    if (x > this.getSource().getX() && y < this.getSource().getY()){
                        boolean canMove = true;
                        for (int k = 1; k < x - this.getSource().getX(); k++) {
                            if (!(theBoard[this.getSource().getX()+k][this.getSource().getY()-k] instanceof  EmptySlotComponent)){
                                canMove = false;
                                break;
                            }
                        }
                        if (canMove && theBoard[x][y].getChessColor()!=this.getChessColor()){
                            canMo.add(new ChessboardPoint(x,y));
                        }
                    }
                    if (x < this.getSource().getX() && y > this.getSource().getY()){
                        boolean canMove = true;
                        for (int k = 1; k < this.getSource().getX() - x; k++) {
                            if (!(theBoard[this.getSource().getX()-k][this.getSource().getY()+k] instanceof  EmptySlotComponent)){
                                canMove = false;
                                break;
                            }
                        }
                        if (canMove && theBoard[x][y].getChessColor()!=this.getChessColor()){
                            canMo.add(new ChessboardPoint(x,y));
                        }
                    }
                    if (x < this.getSource().getX() && y < this.getSource().getY()){
                        boolean canMove = true;
                        for (int k = 1; k < this.getSource().getX()-x; k++) {
                            if (!(theBoard[this.getSource().getX()-k][this.getSource().getY()-k] instanceof  EmptySlotComponent)){
                                canMove = false;
                                break;
                            }
                        }
                        if (canMove && theBoard[x][y].getChessColor()!=this.getChessColor()){
                            canMo.add(new ChessboardPoint(x,y));
                        }
                    }
                }
            }
        }
        if (canMo.isEmpty()) {
            return new ArrayList<>();
        } else return canMo;
    }
}

class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] theBoard) {
        setSource(source);
        setChessColor(chessColor);
        setTheBoard(theBoard);
        if (chessColor == ChessColor.WHITE) {
            name = 'n';
        } else {
            name = 'N';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMo = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if ((getSource().getX() - i) * (getSource().getY() - j) == 2 || (getSource().getX() - i) * (getSource().getY() - j) == -2) {
                    if (theBoard[i][j].getChessColor() != this.getChessColor()) {
                        canMo.add(new ChessboardPoint(i, j));
                    }
                }
            }
        }
        if (canMo.isEmpty()) {
            return new ArrayList<>();
        } else return canMo;
    }
}

class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] theBoard) {
        setSource(source);
        setChessColor(chessColor);
        setTheBoard(theBoard);
        if (chessColor == ChessColor.WHITE) {
            name = 'p';
        } else {
            name = 'P';
        }
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        List<ChessboardPoint> canMo = new ArrayList<>();
        if (this.getChessColor() == ChessColor.BLACK){
            if (this.getSource().getX() == 1){
                if (theBoard[3][this.getSource().getY()] instanceof EmptySlotComponent && theBoard[2][this.getSource().getY()] instanceof EmptySlotComponent){
                    canMo.add(new ChessboardPoint(3,this.getSource().getY()));
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (i == this.getSource().getX()+1 && j == this.getSource().getY() && theBoard[i][j] instanceof EmptySlotComponent){
                        canMo.add(new ChessboardPoint(i,j));
                    }
                    if (i == this.getSource().getX()+1 && Math.abs(j-this.getSource().getY())==1 && theBoard[i][j].getChessColor()==ChessColor.WHITE){
                        canMo.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        if (this.getChessColor() == ChessColor.WHITE){
            if (this.getSource().getX() == 6){
                if (theBoard[4][this.getSource().getY()] instanceof EmptySlotComponent && theBoard[5][this.getSource().getY()] instanceof EmptySlotComponent){
                    canMo.add(new ChessboardPoint(4,this.getSource().getY()));
                }
            }
            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (i == this.getSource().getX()-1 && j == this.getSource().getY() && theBoard[i][j] instanceof EmptySlotComponent){
                        canMo.add(new ChessboardPoint(i,j));
                    }
                    if (i == this.getSource().getX()-1 && Math.abs(j-this.getSource().getY())==1 && theBoard[i][j].getChessColor()==ChessColor.BLACK){
                        canMo.add(new ChessboardPoint(i,j));
                    }
                }
            }
        }
        if (canMo.isEmpty()) {
            return new ArrayList<>();
        } else return canMo;
    }
}

class EmptySlotComponent extends ChessComponent {
    public EmptySlotComponent(ChessboardPoint source, ChessColor chessColor, ChessComponent[][] theBoard) {
        setSource(source);
        setChessColor(chessColor);
        setTheBoard(theBoard);
        name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}