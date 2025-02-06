import java.util.ArrayList;

public class directions {
    public static ChessboardPoint u = new ChessboardPoint(-1, 0);
    public static ChessboardPoint d = new ChessboardPoint(1, 0);
    public static ChessboardPoint l = new ChessboardPoint(0, -1);
    public static ChessboardPoint r = new ChessboardPoint(0, 1);

    public static ChessboardPoint ul = ChessboardPoint.sum(u, l);
    public static ChessboardPoint dl = ChessboardPoint.sum(d, l);
    public static ChessboardPoint dr = ChessboardPoint.sum(d, r);
    public static ChessboardPoint ur = ChessboardPoint.sum(u, r);

    public static ChessboardPoint h1 = new ChessboardPoint(1, 2);
    public static ChessboardPoint h2 = new ChessboardPoint(-1, 2);
    public static ChessboardPoint h3 = new ChessboardPoint(1, -2);
    public static ChessboardPoint h4 = new ChessboardPoint(-1, -2);
    public static ChessboardPoint h5 = new ChessboardPoint(2, 1);
    public static ChessboardPoint h6 = new ChessboardPoint(-2, 1);
    public static ChessboardPoint h7 = new ChessboardPoint(2, -1);
    public static ChessboardPoint h8 = new ChessboardPoint(-2, -1);

    public static ArrayList<ChessboardPoint> Slanting() {
        ArrayList<ChessboardPoint> out = new ArrayList<>();
        out.add(ul);
        out.add(dl);
        out.add(dr);
        out.add(ur);
        return out;
    }

    public static ArrayList<ChessboardPoint> Normal() {
        ArrayList<ChessboardPoint> out = new ArrayList<>();
        out.add(u);
        out.add(d);
        out.add(r);
        out.add(l);
        return out;
    }

    public static ArrayList<ChessboardPoint> All() {
        ArrayList<ChessboardPoint> out = new ArrayList<>();
        out.addAll(Normal());
        out.addAll(Slanting());
        return out;
    }
    public static ArrayList<ChessboardPoint>BPawn(){
        ArrayList<ChessboardPoint> out = new ArrayList<>();
        out.add(d);
        return out;
    }
    public static ArrayList<ChessboardPoint>WPawn(){
        ArrayList<ChessboardPoint> out = new ArrayList<>();
        out.add(u);
        return out;
    }
    public static ArrayList<ChessboardPoint>WEat(){
        ArrayList<ChessboardPoint> out = new ArrayList<>();
        out.add(ul);
        out.add(ur);
        return out;
    }
    public static ArrayList<ChessboardPoint>BEat(){
        ArrayList<ChessboardPoint> out = new ArrayList<>();
        out.add(dl);
        out.add(dr);
        return out;
    }

    public static ArrayList<ChessboardPoint> Knight() {
        ArrayList<ChessboardPoint> out = new ArrayList<>();
        out.add(h1);
        out.add(h2);
        out.add(h3);
        out.add(h4);
        out.add(h5);
        out.add(h6);
        out.add(h7);
        out.add(h8);
        return out;
    }


}