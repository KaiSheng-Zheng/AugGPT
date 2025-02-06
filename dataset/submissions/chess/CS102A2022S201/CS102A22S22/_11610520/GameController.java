
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GameController {
    private Chessboard chessboard;

    private Color currentPlayer;

    private JLabel player;
    private int step=0;
    private JLabel count;

    public void setCount(JLabel count) {
        this.count = count;
    }
    public GameController(Chessboard chessboard) {
        this.chessboard = chessboard;
    }

    public void setPlayer(JLabel player) {
        this.player = player;
    }

    public void loadGameFromFile(String path) {
        int[][] gamePieces = new int[8][8];
        ArrayList<String[]> list=new ArrayList<>();
        int width=8;
        int currentPlayer=0;
        String line;
        try {
            BufferedReader in = new BufferedReader(new FileReader(path));
            while ((line = in.readLine()) != null) {
                list.add(line.split(" "));
            }
            if (list.size()!=9){
                System.out.println(list.size());
                System.out.println(list.get(8).length);
                System.out.println(list.get(8)[0]);
                JOptionPane.showMessageDialog(null,"The chess has broken the length boundary!");
            }
            else {
                if (list.get(8)[0].equals("0")) {
                    currentPlayer = 0;
                } else {
                    currentPlayer = 1;
                }
                for (int i = 0; i <8 ; i++) {
                    if (list.get(i).length!=8){
                        width=list.get(i).length;
                        break;
                    }
                }
                if (width!=8){
                    JOptionPane.showMessageDialog(null,"The chess has broken the width boundary!");
                }
                else {
                    for (int i = 0; i <8 ; i++) {
                        for (int j = 0; j <8 ; j++) {
                            gamePieces[i][j]=Integer.parseInt(list.get(i)[j]);
                        }
                    }
                }
            }
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (list.size()==9 && width==8) {
            chessboard.loadGame(gamePieces,currentPlayer);
        }
    }

    public void saveGameToFile (){
        int[][] pieces = new int[8][8];
        for (int i = 0; i <8 ; i++) {
            for (int j = 0; j <8 ; j++) {
                pieces[i][j] = chessboard.getChessComponents()[i][j].getValue();
            }
        }
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy.MM.dd-HH-mm-ss");
            String path = "resource\\file\\" + sdf.format(new Date()) + ".txt";
            File file = new File(path);
            FileWriter out = new FileWriter(file);
            for(int i=0;i<8;i++){
                for(int j=0;j<8;j++){
                    out.write(pieces[i][j]+" ");
                }
                out.write("\r\n");
            }
            if (chessboard.getCurrentColor() == ChessColor.BLACK){
                out.write("1 "+"\r\n");
            }else if (chessboard.getCurrentColor() == ChessColor.WHITE){
                out.write("0 "+"\r\n");
            }
            out.close();
            JOptionPane.showMessageDialog(null,"Save successfully!");
            System.out.println("Save successfully!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }







}
