import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;
import java.io.IOException;

public class QueenChessComponent extends ChessComponent {

    private static Image QUEEN_WHITE;
    private static Image QUEEN_BLACK;

    private Image queenImage;

    private int value;

    public QueenChessComponent(ChessboardPoint chessboardPoint, Point location, ChessColor chessColor, ClickController clickController, int size) {
        super(chessboardPoint, location, chessColor, clickController, size);
        initiateQueenImage(chessColor);
        if (this.chessColor == ChessColor.BLACK){
            this.value = 2;
        }else{
            this.value = -2;
        }
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }


    private void initiateQueenImage(ChessColor color) {
        try {
            loadResource();
            if (color == ChessColor.WHITE) {
                queenImage = QUEEN_WHITE;
            } else if (color == ChessColor.BLACK) {
                queenImage = QUEEN_BLACK;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadResource() throws IOException {
        if (QUEEN_WHITE == null) {
            QUEEN_WHITE = ImageIO.read(new File("./images/queen-white.png"));
        }

        if (QUEEN_BLACK == null) {
            QUEEN_BLACK = ImageIO.read(new File("./images/queen-black.png"));
        }
    }

    @Override
    public boolean canMoveTo(ChessComponent[][] chessComponents, ChessboardPoint destination) {
        ChessboardPoint source = getChessboardPoint();
        if (source.getX() == destination.getX()) {
            int row = source.getX();
            for (int col = Math.min(source.getY(), destination.getY()) + 1;
                 col < Math.max(source.getY(), destination.getY()); col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY() == destination.getY()) {
            int col = source.getY();
            for (int row = Math.min(source.getX(), destination.getX()) + 1;
                 row < Math.max(source.getX(), destination.getX()); row++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        } else if (source.getY()-destination.getY() == source.getX()-destination.getX()) {
            int row;
            int col;
            if (source.getX()<destination.getX()){
                row = source.getX()+1;
                col = source.getY()+1;
            }else{
                row = destination.getX()+1;
                col = destination.getY()+1;
            }
            for (; row < Math.max(source.getX(), destination.getX()); row++, col++) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    System.out.println(row);
                    System.out.println(col);
                    return false;
                }
            }
        }
        else if (source.getY() + source.getX() == destination.getX() + destination.getY()) {
            int row;
            int col;
            if (source.getX()<destination.getX()){
                row = source.getX()+1;
                col = source.getY()-1;
            }else{
                row = destination.getX()+1;
                col = destination.getY()-1;
            }
            for (; row < Math.max(source.getX(), destination.getX()); row++,col--) {
                if (!(chessComponents[row][col] instanceof EmptySlotComponent)) {
                    return false;
                }
            }
        }
        else { 
            return false;
        }
        return true;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawImage(queenImage, 0, 0, getWidth() , getHeight(), this);
        g.setColor(Color.BLACK);
        if (isSelected()) { 
            g.setColor(Color.RED);
            g.drawOval(0, 0, getWidth() , getHeight());
        }
    }
}


