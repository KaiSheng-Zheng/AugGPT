

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.io.IOException;

public abstract class ChessComponent extends JComponent {


    private static final Color[] BACKGROUND_COLORS = {Color.WHITE, Color.BLACK};
    private ClickController clickController;

    private ChessboardPoint chessboardPoint;
    protected final ChessColor chessColor;
    private boolean selected;

    private int value;

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    protected ChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        enableEvents(AWTEvent.MOUSE_EVENT_MASK);
        setLocation(location);
        setSize(size, size);
        this.chessboardPoint = chessboardPoint;
        this.chessColor = chessColor;
        this.selected = false;
        this.clickController = clickController;
    }

    public ChessboardPoint getChessboardPoint() {
        return chessboardPoint;
    }

    public void setChessboardPoint(ChessboardPoint chessboardPoint) {
        this.chessboardPoint = chessboardPoint;
    }

    public ChessColor getChessColor() {
        return chessColor;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
    
    @Override
    public void swapLocation(ChessComponent another) {
        ChessboardPoint chessboardPoint1 = getChessboardPoint(), chessboardPoint2 = another.getChessboardPoint();
        Point point1 = getLocation(), point2 = another.getLocation();
        setChessboardPoint(chessboardPoint2);
        setLocation(point2);
        another.setChessboardPoint(chessboardPoint1);
        another.setLocation(point1);
    }

    @Override
    protected void processMouseEvent(MouseEvent e) {
        super.processMouseEvent(e);

        if (e.getID() == MouseEvent.MOUSE_PRESSED) {
            System.out.printf("Click [%d,%d]\n", chessboardPoint.getX(), chessboardPoint.getY());
            clickController.onClick(this);
        }
    }

    public abstract boolean canMoveTo(ChessComponent[][] chessboard, ChessboardPoint destination);

    public abstract void loadResource() throws IOException;

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);
        System.out.printf("repaint chess [%d,%d]\n", chessboardPoint.getX(), chessboardPoint.getY());
        Color squareColor = BACKGROUND_COLORS[(chessboardPoint.getX() + chessboardPoint.getY()) % 2];
        g.setColor(squareColor);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
    }
}
