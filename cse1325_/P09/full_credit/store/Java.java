package store;
import java.util.ArrayList;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;



public class Java extends Product{
    public static final String ID = "store.Java";
    public Java(String name, double price, double cost, Darkness darkness){
        super(name, price, cost); //only the SUPER CLASS constructs these.
        this.darkness = darkness;
    }
    
  //Credit to Prof Rice https://github.com/prof-rice/cse1325-prof/blob/main/P08/full-credit/store/Java.java
   public Java(BufferedReader in) throws IOException {
        super(in); //products constructs the cost and price
        this.darkness  = Darkness.valueOf(in.readLine());
        this.shots = new ArrayList<>();
        int size = Integer.parseInt(in.readLine());
        for(int i=0; i<size; ++i)
            shots.add(Shot.valueOf(in.readLine()));
    }
    public void save(BufferedWriter out) throws IOException {
        out.write(ID + '\n');
        super.save(out);
        out.write("" + darkness  + '\n');
        out.write("" + shots.size() + '\n');
        for(Shot s : shots) 
            out.write("" + s + '\n');
    }
    
    public void addShot(Shot shot){
        shots.add(shot);
    }
    
    @Override
    public String toString(){
        return super.toString() + " ("+darkness+" with "+shots+")";
    }
    protected Darkness darkness;
    //An Array List of shot items included in the drink:
    protected ArrayList<Shot> shots = new ArrayList<>();
}
