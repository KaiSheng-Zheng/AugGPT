
import java.util.ArrayList;
import java.util.List;
public abstract class ChessComponent {
    //should design
    private ChessboardPoint source;
    private ChessColor chessColor;
    protected char name;
    private ConcreteChessGame concreteChessGame;


    public char getName() {
        return name;
    }
    public void setName(char name) {
        this.name = name;
    }
    public ConcreteChessGame getConcreteChessGame() {
        return concreteChessGame;
    }

    public void setConcreteChessGame(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }
    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }
    public ChessColor getChessColor() {
        return chessColor;
    }



    //should design
    public ChessComponent(){}

    // should design
    public abstract List<ChessboardPoint> canMoveTo();

    /**
     * should design
     */
    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public static class BishopChessComponent extends ChessComponent {
        public BishopChessComponent(ChessboardPoint position, ChessColor color, char name) {
            super.name = name;
            super.setChessColor(color);
            super.setSource(position);
        }
            @Override
            public List<ChessboardPoint> canMoveTo() {
                int x = getSource().getX();
                int y = getSource().getY();
                List<ChessboardPoint> b = new ArrayList<>();
                for (int i = 1; x + i < 8 & y + i < 8; i++){
                    if (getSource().offset(i,i) != null && getChessColor() !=
                            getConcreteChessGame().getChess(x + i,y + i).getChessColor()){
                        b.add(new ChessboardPoint(x + i,y + i));
                        if (ChessColor.NONE !=
                                getConcreteChessGame().getChess(x + i,y + i).getChessColor()){
                            break;
                        }
                    }
                    else {break;}
                }
                for (int i = 1; x - i >= 0 & y - i >= 0; i++){
                    if (getSource().offset(- i,- i) != null && getChessColor() !=
                            getConcreteChessGame().getChess(x - i,y - i).getChessColor()){
                        b.add(new ChessboardPoint(x - i,y - i));
                        if (ChessColor.NONE !=
                                getConcreteChessGame().getChess(x - i,y - i).getChessColor()){
                            break;
                        }
                    }
                    else {break;}
                }
                for (int i = 1; x - i >= 0 & y + i < 8; i++){
                    if (getSource().offset( - i, i) != null && getChessColor() !=
                            getConcreteChessGame().getChess(x - i,y + i).getChessColor()){
                        b.add(new ChessboardPoint(x - i,y + i));
                        if (ChessColor.NONE !=
                                getConcreteChessGame().getChess(x - i,y + i).getChessColor()){
                            break;
                        }
                    }
                    else {break;}
                }
                for (int i = 1; x + i < 8 & y - i >= 0; i++){
                    if (getSource().offset(i,- i) != null && getChessColor() !=
                            getConcreteChessGame().getChess(x + i,y - i).getChessColor()){
                        b.add(new ChessboardPoint(x + i,y - i));
                        if (ChessColor.NONE !=
                                getConcreteChessGame().getChess(x + i,y - i).getChessColor()){
                            break;
                        }
                    }
                    else {break;}
                }
                return b;
            }
        }

    public static class RookChessComponent extends ChessComponent{
        @Override
        public List<ChessboardPoint> canMoveTo() {
            int x = getSource().getX();
            int y = getSource().getY();
            List<ChessboardPoint> r = new ArrayList<>();
            for (int i = 1; x + i < 8; i++){
                if (getSource().offset(i,0) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x + i, y).getChessColor()){
                    r.add(new ChessboardPoint(x + i, y));
                    if (ChessColor.NONE !=
                            getConcreteChessGame().getChess(x + i, y).getChessColor()){
                        break;
                    }
                }
                else {break;}
            }
            for (int i = 1; x - i >= 0; i++){
                if (getSource().offset(-i,0) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x - i, y).getChessColor()){
                    r.add(new ChessboardPoint(x - i, y));
                    if (getConcreteChessGame().getChess(x - i, y).getChessColor()!=
                            ChessColor.NONE ){
                        break;
                    }
                }
                else {break;}
            }
            for (int i = 1; y + i < 8; i++){
                if (getSource().offset(0, i) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x, y + i).getChessColor()){
                    r.add(new ChessboardPoint(x, y + i));
                    if (ChessColor.NONE !=
                            getConcreteChessGame().getChess(x, y + i).getChessColor()){
                        break;
                    }
                }
                else {break;}
            }
            for (int i = 1; y - i >= 0; i++){
                if (getSource().offset(0,-i) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x, y - i).getChessColor()){
                    r.add(new ChessboardPoint(x, y - i));
                    if (ChessColor.NONE !=
                            getConcreteChessGame().getChess(x, y - i).getChessColor()){
                        break;
                    }
                }
                else {break;}
            }
            return r;
        }
        public RookChessComponent(ChessboardPoint position, ChessColor color, char name) {
            super.name = name;
            super.setChessColor(color);
            super.setSource(position);
        }
    }

    public static class QueenChessComponent extends ChessComponent{
        @Override
        public List<ChessboardPoint> canMoveTo() {
            int x = getSource().getX();
            int y = getSource().getY();
            List<ChessboardPoint> q = new ArrayList<>();
            for (int i = 1; x + i < 8; i++){
                if (getSource().offset(i,0) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x + i, y).getChessColor()){
                    q.add(new ChessboardPoint(x + i, y));
                    if (ChessColor.NONE !=
                                    getConcreteChessGame().getChess(x + i, y).getChessColor()){
                        break;
                    }
                }
                else {break;}
            }
            for (int i = 1; x - i >= 0; i++){
                if (getSource().offset(-i,0) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x - i, y).getChessColor()){
                    q.add(new ChessboardPoint(x - i, y));
                    if (getConcreteChessGame().getChess(x - i, y).getChessColor()!=
                                    ChessColor.NONE ){
                        break;
                    }
                }
                else {break;}
            }
            for (int i = 1; y + i < 8; i++){
                if (getSource().offset(0, i) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x, y + i).getChessColor()){
                    q.add(new ChessboardPoint(x, y + i));
                    if (ChessColor.NONE !=
                                    getConcreteChessGame().getChess(x, y + i).getChessColor()){
                        break;
                    }
                }
                else {break;}
            }
            for (int i = 1; y - i >= 0; i++){
                if (getSource().offset(0,-i) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x, y - i).getChessColor()){
                    q.add(new ChessboardPoint(x, y - i));
                    if (ChessColor.NONE !=
                                    getConcreteChessGame().getChess(x, y - i).getChessColor()){
                        break;
                    }
                }
                else {break;}
            }
            for (int i = 1; x + i < 8 & y + i < 8; i++){
                if (getSource().offset(i,i) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x + i,y + i).getChessColor()){
                    q.add(new ChessboardPoint(x + i,y + i));
                    if (ChessColor.NONE !=
                                    getConcreteChessGame().getChess(x + i,y + i).getChessColor()){
                        break;
                    }
                }
                else {break;}
            }
            for (int i = 1; x - i >= 0 & y - i >= 0; i++){
                if (getSource().offset(- i,- i) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x - i,y - i).getChessColor()){
                    q.add(new ChessboardPoint(x - i,y - i));
                    if (ChessColor.NONE !=
                                    getConcreteChessGame().getChess(x - i,y - i).getChessColor()){
                        break;
                    }
                }
                else {break;}
            }
            for (int i = 1; x - i >= 0 & y + i < 8; i++){
                if (getSource().offset( - i, i) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x - i,y + i).getChessColor()){
                    q.add(new ChessboardPoint(x - i,y + i));
                    if (ChessColor.NONE !=
                                    getConcreteChessGame().getChess(x - i,y + i).getChessColor()){
                        break;
                    }
                }
                else {break;}
            }
            for (int i = 1; x + i < 8 & y - i >= 0; i++){
                if (getSource().offset(i,- i) != null && getChessColor() !=
                        getConcreteChessGame().getChess(x + i,y - i).getChessColor()){
                    q.add(new ChessboardPoint(x + i,y - i));
                    if (ChessColor.NONE !=
                                    getConcreteChessGame().getChess(x + i,y - i).getChessColor()){
                        break;
                    }
                }
                else {break;}
            }
            return q;
        }
        public QueenChessComponent(ChessboardPoint position, ChessColor color, char name) {
            super.name = name;
            super.setChessColor(color);
            super.setSource(position);
        }
    }

    public static class PawnChessComponent extends ChessComponent{
        @Override
        public List<ChessboardPoint> canMoveTo() {
            int x = getSource().getX();
            int y = getSource().getY();
            List<ChessboardPoint> p = new ArrayList<>();
            if (getChessColor() == ChessColor.BLACK){
                if (getSource().offset(1,0) != null &&
                        getConcreteChessGame().getChess(x + 1, y).getChessColor() == ChessColor.NONE){
                    p.add(new ChessboardPoint(x + 1, y));
                }
                if (getSource().offset(2,0) != null &&
                        getSource().offset(1,0) != null &&
                        getConcreteChessGame().getChess(x + 1, y).getChessColor() == ChessColor.NONE &&
                        getConcreteChessGame().getChess(x + 2, y).getChessColor() == ChessColor.NONE){
                    p.add(new ChessboardPoint(x + 2, y));
                }
                if (getSource().offset(1,1) != null &&
                        getConcreteChessGame().getChess(x + 1, y + 1).getChessColor() != ChessColor.NONE &&
                        getChessColor() != getConcreteChessGame().getChess(x + 1, y + 1).getChessColor()){
                    p.add(new ChessboardPoint(x + 1, y + 1));
                }
                if (getSource().offset(1,-1) != null &&
                        getConcreteChessGame().getChess(x + 1, y - 1).getChessColor() != ChessColor.NONE &&
                        getChessColor() != getConcreteChessGame().getChess(x + 1, y - 1).getChessColor()){
                    p.add(new ChessboardPoint(x + 1, y - 1));
                }
            }
            else {
                if (getSource().offset(-1,0) != null &&
                        getConcreteChessGame().getChess(x - 1, y).getChessColor() == ChessColor.NONE){
                    p.add(new ChessboardPoint(x - 1, y));
                }
                if (getSource().offset(-2,0) != null &&
                        getSource().offset(-1,0) != null &&
                        getConcreteChessGame().getChess(x - 1, y).getChessColor() == ChessColor.NONE &&
                        getConcreteChessGame().getChess(x - 2, y).getChessColor() == ChessColor.NONE){
                    p.add(new ChessboardPoint(x - 2, y));
                }
                if (getSource().offset(-1,1) != null &&
                        getConcreteChessGame().getChess(x - 1, y + 1).getChessColor() != ChessColor.NONE &&
                        getChessColor() != getConcreteChessGame().getChess(x - 1, y + 1).getChessColor()){
                    p.add(new ChessboardPoint(x - 1, y + 1));
                }
                if (getSource().offset(-1,-1) != null &&
                        getConcreteChessGame().getChess(x - 1, y - 1).getChessColor() != ChessColor.NONE &&
                        getChessColor() != getConcreteChessGame().getChess(x - 1, y - 1).getChessColor()){
                    p.add(new ChessboardPoint(x - 1, y - 1));
                }
            }
            return p;
        }
        public PawnChessComponent(ChessboardPoint position, ChessColor color, char name) {
            super.name = name;
            super.setChessColor(color);
            super.setSource(position);
        }
    }

    public static class KnightChessComponent extends ChessComponent{
        @Override
        public List<ChessboardPoint> canMoveTo() {
            List<ChessboardPoint> n = new ArrayList<>();
            int x = getSource().getX();
            int y = getSource().getY();
            if (    getSource().offset(2,1) != null){
                if (getChessColor() !=
                        getConcreteChessGame().getChess(x + 2, y + 1).getChessColor()){
                    n.add(new ChessboardPoint(x + 2, y + 1));
                }
            }
            if (    getSource().offset(2,-1) != null){
                if (getChessColor() != getConcreteChessGame().getChess(x + 2, y - 1).getChessColor()){
                    n.add(new ChessboardPoint(x + 2, y - 1));
                }
            }
            if (    getSource().offset(-2,1) != null){
                if (getChessColor() !=
                        getConcreteChessGame().getChess(x - 2, y + 1).getChessColor()){
                    n.add(new ChessboardPoint(x - 2, y + 1));
                }
            }
            if (    getSource().offset(-2,-1) != null){
                if (getChessColor() !=
                        getConcreteChessGame().getChess(x - 2, y - 1).getChessColor()){
                    n.add(new ChessboardPoint(x - 2, y - 1));
                }
            }
            if (    getSource().offset(1,2) != null){
                if (getChessColor() !=
                        getConcreteChessGame().getChess(x + 1, y + 2).getChessColor()){
                    n.add(new ChessboardPoint(x + 1, y + 2));
                }
            }
            if (    getSource().offset(1,-2) != null){
                if (getChessColor() !=
                        getConcreteChessGame().getChess(x + 1, y - 2).getChessColor()){
                    n.add(new ChessboardPoint(x + 1, y - 2));
                }
            }
            if (    getSource().offset(-1,-2) != null){
                if (getChessColor() !=
                        getConcreteChessGame().getChess(x - 1, y - 2).getChessColor()){
                    n.add(new ChessboardPoint(x - 1, y - 2));
                }
            }
            if (    getSource().offset(-1,2) != null){
                if (getChessColor() !=
                        getConcreteChessGame().getChess(x - 1, y + 2).getChessColor()){
                    n.add(new ChessboardPoint(x - 1, y + 2));
                }
            }
            return n;
        }
        public KnightChessComponent(ChessboardPoint position, ChessColor color, char name) {
            super.name = name;
            super.setChessColor(color);
            super.setSource(position);
        }
    }

    public static class KingChessComponent extends ChessComponent{
        @Override
        public List<ChessboardPoint> canMoveTo() {
            List<ChessboardPoint> k = new ArrayList<>();
            if (getSource().offset(1,0) != null && getChessColor() !=
                    getConcreteChessGame().getChess(getSource().getX() + 1, getSource().getY()).getChessColor()){
                k.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY()));
            }
            if (getSource().offset(0,1) != null && getChessColor() !=
                    getConcreteChessGame().getChess(getSource().getX() , getSource().getY() + 1).getChessColor()){
                k.add(new ChessboardPoint(getSource().getX() , getSource().getY() + 1));
            }
            if (getSource().offset(1,1) != null && getChessColor() !=
                    getConcreteChessGame().getChess(getSource().getX() + 1 , getSource().getY() + 1).getChessColor()){
                k.add(new ChessboardPoint(getSource().getX() + 1 , getSource().getY() + 1));
            }
            if (getSource().offset(-1,0) != null && getChessColor() !=
                    getConcreteChessGame().getChess(getSource().getX() - 1 , getSource().getY()).getChessColor()){
                k.add(new ChessboardPoint(getSource().getX() - 1 , getSource().getY()));
            }
            if (getSource().offset(0,-1) != null && getChessColor() !=
                    getConcreteChessGame().getChess(getSource().getX() , getSource().getY() - 1).getChessColor()){
                k.add(new ChessboardPoint(getSource().getX() , getSource().getY() - 1));
            }
            if (getSource().offset(-1,-1) != null && getChessColor() !=
                    getConcreteChessGame().getChess(getSource().getX() - 1, getSource().getY() - 1).getChessColor()){
                k.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() - 1));
            }
            if (getSource().offset(1,-1) != null && getChessColor() !=
                    getConcreteChessGame().getChess(getSource().getX() + 1, getSource().getY() - 1).getChessColor()){
                k.add(new ChessboardPoint(getSource().getX() + 1, getSource().getY() - 1));
            }
            if (getSource().offset(-1,1) != null && getChessColor() !=
                    getConcreteChessGame().getChess(getSource().getX() - 1, getSource().getY() + 1).getChessColor()){
                k.add(new ChessboardPoint(getSource().getX() - 1, getSource().getY() + 1));
            }
            return k;
        }
        public KingChessComponent(ChessboardPoint position, ChessColor color, char name) {
            super.name = name;
            super.setChessColor(color);
            super.setSource(position);
        }
    }

    public static class EmptySlotComponent extends ChessComponent{
            @Override
            public List<ChessboardPoint> canMoveTo() {
                return new ArrayList<>();
            }
            public EmptySlotComponent(ChessboardPoint position, ChessColor color, char name) {
                super.name = name;
                super.setChessColor(color);
                super.setSource(position);
            }
    }
}