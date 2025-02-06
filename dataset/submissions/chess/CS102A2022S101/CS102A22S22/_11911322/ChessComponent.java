//import java.io.ByteArrayInputStream;
//import java.io.ByteArrayOutputStream;
//import java.io.ObjectInputStream;
//import java.io.ObjectOutputStream;
import java.util.List;

public abstract class ChessComponent {
    private ChessboardPoint source;
    private ChessColor chessColor = ChessColor.NONE;
    protected char name = '_';
    private boolean hasBeenMoved = false;

    private ConcreteChessGame concreteChessGame;

    public void setConcreteChessGame(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
    }

    public ChessComponent(){
    }

    public abstract List<ChessboardPoint> canMoveTo();

    @Override
    public String toString() {
        return String.valueOf(this.name);
    }

    public ChessboardPoint getSource() {
        return source;
    }

    public void setChessColor(ChessColor chessColor) {
        this.chessColor = chessColor;
    }

    public ChessColor getChessColor() {
        return this.chessColor;
    }

    public char getName() {
        return this.name;
    }

    public void setName(char name) {
        this.name = name;
    }

    public void updateConcreteChessGame(ConcreteChessGame concreteChessGame) {
        this.concreteChessGame = concreteChessGame;
    }

    public ConcreteChessGame getConcreteChessGame() {
        return concreteChessGame;
    }

    public void setSource(ChessboardPoint source) {
        this.source = source;
    }

    public boolean isHasBeenMoved() {
        return hasBeenMoved;
    }

    public void Moved() {
        this.hasBeenMoved = true;
    }

//    @Override
//    public ChessComponent clone() {
//        try {
//            ByteArrayOutputStream baos = new ByteArrayOutputStream();
//            ObjectOutputStream oos = new ObjectOutputStream(baos);
//            oos.writeObject(this);
//
//            ByteArrayInputStream bais = new ByteArrayInputStream(baos.toByteArray());
//            ObjectInputStream ois = new ObjectInputStream(bais);
//            ChessComponent obj = (ChessComponent) ois.readObject();
//            return obj;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
}
