import java.util.*;
public class Bar {
    private Date date;
    private double open;
    private double high;
    private double low;
    private double close;
    private double AjClose;
    private int 	volume;

    //constructors
    Bar (Date d, double o, double h, double l, double c, double ac, int vol) {
        date = d;
        open = o;
        high = h;
        low = l;
        close = c;
        AjClose = ac;
        volume = vol;
    }
    Bar(String line) {
        String [] fields = line.split(",");
        if (fields.length != 7) {
            System.out.println("Something is wrong: " + line);
            return;
        }
        String today = fields[0];
        if(today.indexOf('/') >= 0) {
            String[] days = today.split("/");
            Calendar myDate = Calendar.getInstance();
            myDate.set(Integer.parseInt(days[2]), (Integer.parseInt(days[0])-1), Integer.parseInt(days[1]));
            date = myDate.getTime();
        }else if (today.indexOf('-') >= 0) {
            String[] days = today.split("-");
            Calendar myDate = Calendar.getInstance();
            myDate.set(Integer.parseInt(days[0]), (Integer.parseInt(days[1])-1), Integer.parseInt(days[2]));
            date = myDate.getTime();
        }else {
            System.out.println("Unknown date format!");
            return;
        }
        open = Double.parseDouble(fields[1]);
        high = Double.parseDouble(fields[2]);
        low = Double.parseDouble(fields[3]);
        close = Double.parseDouble(fields[4]);
        AjClose =  Double.parseDouble(fields[5]);
        volume = Integer.parseInt(fields[6]);

    }
    public String toString() {
        String st = date.toString() + ", " + open + ", " + high + ", " + low + ", " + close +
                ", " + AjClose + ", " + volume;
        return st;
    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public double Open() {
        return open;
    }
    public void setOpen(double open) {
        this.open = open;
    }
    public double High() {
        return high;
    }
    public void setHigh(double high) {
        this.high = high;
    }
    public double Low() {
        return low;
    }
    public void setLow(double low) {
        this.low = low;
    }
    public double Close() {
        return close;
    }
    public void setClose(double close) {
        this.close = close;
    }
    public double AjClose() {
        return AjClose;
    }
    public void setAjClose(double ajClose) {
        AjClose = ajClose;
    }
    public int Volume() {
        return volume;
    }
    public void setVolume(int volume) {
        this.volume = volume;
    }

    public double Range(){
        return this.High() - this.Low();
    }
}