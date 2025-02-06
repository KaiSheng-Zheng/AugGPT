import java.awt.*;
import java.io.IOException;

public class EmptySlotComponent extends  ChessComponent {
    private int value;

    public EmptySlotComponent(ChessboardPoint chessboardPoint, Point location, ClickController listener, int size) {
        super(chessboardPoint, location, ChessColor.NONE, listener, size);
        this.value = 0;
    }

    @Override
    public boolean canMoveTo( ChessComponent[][] chessboard, ChessboardPoint destination) {
        return false;
    }

    @Override
    public void loadResource() throws IOException {
    }
    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

}
