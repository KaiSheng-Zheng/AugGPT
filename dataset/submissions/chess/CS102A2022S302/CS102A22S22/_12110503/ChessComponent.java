import java.util.ArrayList;
import java.util.List;

public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    protected ChessComponent[][] chessComponents;


    //should design
    public ChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source, ChessColor chessColor) {
        this.source = source;
        this.chessColor = chessColor;
        this.chessComponents = chessComponents;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public ChessComponent() {
    }

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    /**
     * should design
     *
     * @return
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

}


class EmptySlotComponent extends ChessComponent {

    public EmptySlotComponent(ChessComponent[][] chessComponents, ChessboardPoint source, ChessColor chessColor) {
        super(chessComponents, source, chessColor);
        this.name = '_';
    }

    public void setName() {
        if (super.getChessColor() == ChessColor.NONE) this.name = '_';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        return new ArrayList<>();
    }
}

class KingChessComponent extends ChessComponent {
    public KingChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source, ChessColor chessColor) {
        super(chessComponents, source, chessColor);
        if (chessColor == ChessColor.BLACK) {
            this.name = 'K';
        } else this.name = 'k';
    }

    public void setName() {
        if (super.getChessColor() == ChessColor.BLACK) this.name = 'K';
        else this.name = 'k';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> KingCanMoveTo = new ArrayList<>();
        int col = this.getSource().getY();
        int row = this.getSource().getX();
        int i,j;
        i=row-1;j=col-1;
        if(i>=0&&j>=0&&j<8&&i<8&&this.chessComponents[i][j].getChessColor() != this.getChessColor())KingCanMoveTo.add(new ChessboardPoint(i, j));
        i=row;j=col-1;
        if(i>=0&&j>=0&&j<8&&i<8&&this.chessComponents[i][j].getChessColor() != this.getChessColor())KingCanMoveTo.add(new ChessboardPoint(i, j));
        i=row;j=col+1;
        if(i>=0&&j>=0&&j<8&&i<8&&this.chessComponents[i][j].getChessColor() != this.getChessColor())KingCanMoveTo.add(new ChessboardPoint(i, j));
        i=row-1;j=col+1;
        if(i>=0&&j>=0&&j<8&&i<8&&this.chessComponents[i][j].getChessColor() != this.getChessColor())KingCanMoveTo.add(new ChessboardPoint(i, j));
        i=row+1;j=col;
        if(i>=0&&j>=0&&j<8&&i<8&&this.chessComponents[i][j].getChessColor() != this.getChessColor())KingCanMoveTo.add(new ChessboardPoint(i, j));
        i=row-1;j=col;
        if(i>=0&&j>=0&&j<8&&i<8&&this.chessComponents[i][j].getChessColor() != this.getChessColor())KingCanMoveTo.add(new ChessboardPoint(i, j));
        i=row+1;j=col-1;
        if(i>=0&&j>=0&&j<8&&i<8&&this.chessComponents[i][j].getChessColor() != this.getChessColor())KingCanMoveTo.add(new ChessboardPoint(i, j));
        i=row+1;j=col+1;
        if(i>=0&&j>=0&&j<8&&i<8&&this.chessComponents[i][j].getChessColor() != this.getChessColor())KingCanMoveTo.add(new ChessboardPoint(i, j));
        return KingCanMoveTo;
    }
}

class QueenChessComponent extends ChessComponent {
    public QueenChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source, ChessColor chessColor) {
        super(chessComponents, source, chessColor);
        if (chessColor == ChessColor.BLACK) {
            this.name = 'Q';
        } else this.name = 'q';
    }

    public void setName() {
        if (super.getChessColor() == ChessColor.BLACK) this.name = 'Q';
        else this.name = 'q';
    }


    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> QueenCanMoveTo = new ArrayList<>();
        int col = this.getSource().getY();
        int row = this.getSource().getX();
        for (int i = row+1; i < 8; i++) {
            if (chessComponents[i][col].getChessColor() == ChessColor.NONE) {
                QueenCanMoveTo.add(new ChessboardPoint(i, col));
            } else if (chessComponents[i][col].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                QueenCanMoveTo.add(new ChessboardPoint(i, col));
                break;
            } else if (chessComponents[i][col].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                QueenCanMoveTo.add(new ChessboardPoint(i, col));
                break;
            } else if (chessComponents[i][col].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int i = row-1; i >= 0; i--) {
            if (chessComponents[i][col].getChessColor() == ChessColor.NONE) {
                QueenCanMoveTo.add(new ChessboardPoint(i, col));
            } else if (chessComponents[i][col].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                QueenCanMoveTo.add(new ChessboardPoint(i, col));
                break;
            } else if (chessComponents[i][col].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                QueenCanMoveTo.add(new ChessboardPoint(i, col));
                break;
            } else if (chessComponents[i][col].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int j = col-1; j >= 0; j--) {
            if (chessComponents[row][j].getChessColor() == ChessColor.NONE) {
                QueenCanMoveTo.add(new ChessboardPoint(row, j));
            } else if (chessComponents[row][j].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                QueenCanMoveTo.add(new ChessboardPoint(row, j));
                break;
            } else if (chessComponents[row][j].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                QueenCanMoveTo.add(new ChessboardPoint(row, j));
                break;
            } else if (chessComponents[row][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int j = col+1; j < 8; j++) {
            if (chessComponents[row][j].getChessColor() == ChessColor.NONE) {
                QueenCanMoveTo.add(new ChessboardPoint(row, j));
            } else if (chessComponents[row][j].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                QueenCanMoveTo.add(new ChessboardPoint(row, j));
                break;
            } else if (chessComponents[row][j].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                QueenCanMoveTo.add(new ChessboardPoint(row, j));
                break;
            } else if (chessComponents[row][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }

        for (int i = row-1, j = col+1; i >= 0 && j < 8; i--, j++) {
            if (chessComponents[i][j].getChessColor() == ChessColor.NONE) {
                QueenCanMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessComponents[i][j].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                QueenCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessComponents[i][j].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                QueenCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessComponents[i][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int i = row+1, j = col-1; j >= 0 && i < 8; j--, i++) {
            if (chessComponents[i][j].getChessColor() == ChessColor.NONE) {
                QueenCanMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessComponents[i][j].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                QueenCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessComponents[i][j].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                QueenCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessComponents[i][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int i = row+1, j = col+1; i <8&&j<8; i++, j++) {
            if(chessComponents[i][j].getChessColor()==ChessColor.NONE){
                QueenCanMoveTo.add(new ChessboardPoint(i, j));}
            else if (chessComponents[i][j].getChessColor()==ChessColor.WHITE&&this.getChessColor()==ChessColor.BLACK){
                QueenCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            }else if (chessComponents[i][j].getChessColor()==ChessColor.BLACK&&this.getChessColor()==ChessColor.WHITE){
                QueenCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            }else if(chessComponents[i][j].getChessColor()==this.getChessColor()){
                break;
            }
        }
        for (int i = row-1, j = col-1; i >=0&&j>=0; i--, j--) {
            if(chessComponents[i][j].getChessColor()==ChessColor.NONE){
                QueenCanMoveTo.add(new ChessboardPoint(i, j));}
            else if (chessComponents[i][j].getChessColor()==ChessColor.WHITE&&this.getChessColor()==ChessColor.BLACK){
                QueenCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            }else if (chessComponents[i][j].getChessColor()==ChessColor.BLACK&&this.getChessColor()==ChessColor.WHITE){
                QueenCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            }else if(chessComponents[i][j].getChessColor()==this.getChessColor()){
                break;
            }
        }
        return QueenCanMoveTo;
    }
}

class RookChessComponent extends ChessComponent {
    public RookChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source, ChessColor chessColor) {
        super(chessComponents, source, chessColor);
        if (chessColor == ChessColor.BLACK) {
            this.name = 'R';
        } else this.name = 'r';
    }

    public void setName() {
        if (super.getChessColor() == ChessColor.BLACK) this.name = 'R';
        else this.name = 'r';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> RookCanMoveTo = new ArrayList<>();
        int col = this.getSource().getY();
        int row = this.getSource().getX();
        for (int i = row+1; i < 8; i++) {
            if (chessComponents[i][col].getChessColor() == ChessColor.NONE) {
                RookCanMoveTo.add(new ChessboardPoint(i, col));
            } else if (chessComponents[i][col].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                RookCanMoveTo.add(new ChessboardPoint(i, col));
                break;
            } else if (chessComponents[i][col].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                RookCanMoveTo.add(new ChessboardPoint(i, col));
                break;
            } else if (chessComponents[i][col].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int i = row-1; i >= 0; i--) {
            if (chessComponents[i][col].getChessColor() == ChessColor.NONE) {
                RookCanMoveTo.add(new ChessboardPoint(i, col));
            } else if (chessComponents[i][col].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                RookCanMoveTo.add(new ChessboardPoint(i, col));
                break;
            } else if (chessComponents[i][col].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                RookCanMoveTo.add(new ChessboardPoint(i, col));
                break;
            } else if (chessComponents[i][col].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int j = col-1; j >= 0; j--) {
            if (chessComponents[row][j].getChessColor() == ChessColor.NONE) {
                RookCanMoveTo.add(new ChessboardPoint(row, j));
            } else if (chessComponents[row][j].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                RookCanMoveTo.add(new ChessboardPoint(row, j));
                break;
            } else if (chessComponents[row][j].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                RookCanMoveTo.add(new ChessboardPoint(row, j));
                break;
            } else if (chessComponents[row][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int j = col+1; j < 8; j++) {
            if (chessComponents[row][j].getChessColor() == ChessColor.NONE) {
                RookCanMoveTo.add(new ChessboardPoint(row, j));
            } else if (chessComponents[row][j].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                RookCanMoveTo.add(new ChessboardPoint(row, j));
                break;
            } else if (chessComponents[row][j].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                RookCanMoveTo.add(new ChessboardPoint(row, j));
                break;
            } else if (chessComponents[row][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        return RookCanMoveTo;
    }
}

class BishopChessComponent extends ChessComponent {

    public BishopChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source, ChessColor chessColor) {
        super(chessComponents, source, chessColor);
        if (chessColor == ChessColor.BLACK) {
            this.name = 'B';
        } else this.name = 'b';
    }

    public void setName() {
        if (super.getChessColor() == ChessColor.BLACK) this.name = 'B';
        else this.name = 'b';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> BishopCanMoveTo = new ArrayList<>();
        int col = this.getSource().getY();
        int row = this.getSource().getX();
        for (int i = row+1, j = col+1; i <8&&j<8; i++, j++) {
            if(chessComponents[i][j].getChessColor()==ChessColor.NONE){
                BishopCanMoveTo.add(new ChessboardPoint(i, j));}
            else if (chessComponents[i][j].getChessColor()==ChessColor.WHITE&&this.getChessColor()==ChessColor.BLACK){
                BishopCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            }else if (chessComponents[i][j].getChessColor()==ChessColor.BLACK&&this.getChessColor()==ChessColor.WHITE){
                BishopCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            }else if(chessComponents[i][j].getChessColor()==this.getChessColor()){
                break;
            }
        }
        for (int i = row-1, j = col-1; i >=0&&j>=0; i--, j--) {
            if(chessComponents[i][j].getChessColor()==ChessColor.NONE){
                BishopCanMoveTo.add(new ChessboardPoint(i, j));}
            else if (chessComponents[i][j].getChessColor()==ChessColor.WHITE&&this.getChessColor()==ChessColor.BLACK){
                BishopCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            }else if (chessComponents[i][j].getChessColor()==ChessColor.BLACK&&this.getChessColor()==ChessColor.WHITE){
                BishopCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            }else if(chessComponents[i][j].getChessColor()==this.getChessColor()){
                break;
            }
        }
        for (int i = row-1, j = col+1; i >= 0 && j < 8; i--, j++) {
            if (chessComponents[i][j].getChessColor() == ChessColor.NONE) {
                BishopCanMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessComponents[i][j].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                BishopCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessComponents[i][j].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                BishopCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessComponents[i][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        for (int i = row+1, j = col-1; j >= 0 && i < 8; j--, i++) {
            if (chessComponents[i][j].getChessColor() == ChessColor.NONE) {
                BishopCanMoveTo.add(new ChessboardPoint(i, j));
            } else if (chessComponents[i][j].getChessColor() == ChessColor.WHITE && this.getChessColor() == ChessColor.BLACK) {
                BishopCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessComponents[i][j].getChessColor() == ChessColor.BLACK && this.getChessColor() == ChessColor.WHITE) {
                BishopCanMoveTo.add(new ChessboardPoint(i, j));
                break;
            } else if (chessComponents[i][j].getChessColor() == this.getChessColor()) {
                break;
            }
        }
        return BishopCanMoveTo;
    }
}

class KnightChessComponent extends ChessComponent {
    public KnightChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source, ChessColor chessColor) {
        super(chessComponents, source, chessColor);
        if (chessColor == ChessColor.BLACK) {
            this.name = 'N';
        } else this.name = 'n';
    }

    public void setName() {
        if (super.getChessColor() == ChessColor.BLACK) this.name = 'N';
        else this.name = 'n';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> KnightCanMoveTo = new ArrayList<>();
        int col = this.getSource().getY();
        int row = this.getSource().getX();
        int i,j;
        i=row+2;j=col-1;
        if(i>=0&&i<8&&j>=0&&j<8&&chessComponents[i][j].getChessColor()!=this.getChessColor())KnightCanMoveTo.add(new ChessboardPoint(i,j));
        i=row+2;j=col+1;
        if(i>=0&&i<8&&j>=0&&j<8&&chessComponents[i][j].getChessColor()!=this.getChessColor())KnightCanMoveTo.add(new ChessboardPoint(i,j));
        i=row+1;j=col-2;
        if(i>=0&&i<8&&j>=0&&j<8&&chessComponents[i][j].getChessColor()!=this.getChessColor())KnightCanMoveTo.add(new ChessboardPoint(i,j));
        i=row+1;j=col+2;
        if(i>=0&&i<8&&j>=0&&j<8&&chessComponents[i][j].getChessColor()!=this.getChessColor())KnightCanMoveTo.add(new ChessboardPoint(i,j));
        i=row-1;j=col-2;
        if(i>=0&&i<8&&j>=0&&j<8&&chessComponents[i][j].getChessColor()!=this.getChessColor())KnightCanMoveTo.add(new ChessboardPoint(i,j));
        i=row-1;j=col+2;
        if(i>=0&&i<8&&j>=0&&j<8&&chessComponents[i][j].getChessColor()!=this.getChessColor())KnightCanMoveTo.add(new ChessboardPoint(i,j));
        i=row-2;j=col-1;
        if(i>=0&&i<8&&j>=0&&j<8&&chessComponents[i][j].getChessColor()!=this.getChessColor())KnightCanMoveTo.add(new ChessboardPoint(i,j));
        i=row-2;j=col+1;
        if(i>=0&&i<8&&j>=0&&j<8&&chessComponents[i][j].getChessColor()!=this.getChessColor())KnightCanMoveTo.add(new ChessboardPoint(i,j));
        return KnightCanMoveTo;
    }
}

class PawnChessComponent extends ChessComponent {
    public PawnChessComponent(ChessComponent[][] chessComponents, ChessboardPoint source, ChessColor chessColor) {
        super(chessComponents, source, chessColor);
        if (chessColor == ChessColor.BLACK) {
            this.name = 'P';
        } else this.name = 'p';
    }

    public void setName() {
        if (super.getChessColor() == ChessColor.BLACK) this.name = 'P';
        else this.name = 'p';
    }

    @Override
    public List<ChessboardPoint> canMoveTo() {
        ArrayList<ChessboardPoint> PawnCanMoveTo = new ArrayList<>();
        int col = this.getSource().getY();
        int row = this.getSource().getX();
        if(this.getChessColor()==ChessColor.WHITE){
            if (this.getSource().getX()==6&&chessComponents[5][this.getSource().getY()].getChessColor()==ChessColor.NONE&&chessComponents[4][this.getSource().getY()].getChessColor()==ChessColor.NONE) {
                PawnCanMoveTo.add(new ChessboardPoint(4, this.getSource().getY()));
            }
            try {
                if (chessComponents[this.getSource().getX()-1][this.getSource().getY()].getChessColor()==ChessColor.NONE){
                    PawnCanMoveTo.add(new ChessboardPoint(this.getSource().getX()-1, this.getSource().getY()));
                }
            }catch (Exception ignored){}
            try {
                if(chessComponents[this.getSource().getX()-1][this.getSource().getY()-1].getChessColor()==ChessColor.BLACK){
                    PawnCanMoveTo.add(new ChessboardPoint(this.getSource().getX()-1, this.getSource().getY()-1));
                }
            }catch (Exception ignored){}
            try {
                if(chessComponents[this.getSource().getX()-1][this.getSource().getY()+1].getChessColor()==ChessColor.BLACK){
                    PawnCanMoveTo.add(new ChessboardPoint(this.getSource().getX()-1, this.getSource().getY()+1));
                }
            }catch (Exception ignored){}
        }else if(this.getChessColor()==ChessColor.BLACK){
            if (this.getSource().getX()==1&&chessComponents[2][this.getSource().getY()].getChessColor()==ChessColor.NONE&&chessComponents[3][this.getSource().getY()].getChessColor()==ChessColor.NONE) {
                PawnCanMoveTo.add(new ChessboardPoint(3, this.getSource().getY()));
            }
            try {
                if (chessComponents[this.getSource().getX()+1][this.getSource().getY()].getChessColor()==ChessColor.NONE){
                    PawnCanMoveTo.add(new ChessboardPoint(this.getSource().getX()+1, this.getSource().getY()));
                }
            }catch (Exception ignored){}
            try {
                if(chessComponents[this.getSource().getX()+1][this.getSource().getY()-1].getChessColor()==ChessColor.WHITE){
                    PawnCanMoveTo.add(new ChessboardPoint(this.getSource().getX()+1, this.getSource().getY()-1));
                }
            }catch (Exception ignored){}
            try {
                if(chessComponents[this.getSource().getX()+1][this.getSource().getY()+1].getChessColor()==ChessColor.WHITE){
                    PawnCanMoveTo.add(new ChessboardPoint(this.getSource().getX()+1, this.getSource().getY()+1));
                }
            }catch (Exception ignored){}
        }
        return PawnCanMoveTo;
    }
}

