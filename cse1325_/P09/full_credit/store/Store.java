package store;
import gui.MainWin;
import java.util.ArrayList;
import java.util.Scanner;

import java.io.File;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Store{
    //constructor
    public Store(String storeName){ 
        this.storeName = storeName;
    }
    //constructor for bufferedreader... load up a store
    
    //Credit to Prof Rice https://github.com/prof-rice/cse1325-prof/blob/main/P08/full-credit/store/Store.java
    public Store(BufferedReader in) throws IOException {
        this(in.readLine());
        int size = Integer.parseInt(in.readLine());
        for(int i=0; i<size; ++i) {
            String productType = in.readLine();
            switch(productType) {
                case Java.ID:  products.add(new Java(in));  break;
                case Donut.ID: products.add(new Donut(in)); break;
                default: throw new IOException("Invalid product type: " + productType);
            }
        }
        }
        
        
    
    
    public void save(BufferedWriter out) throws IOException {
        out.write(storeName + '\n');
        out.write("" + products.size() + '\n');
        for(Product p : products)
            p.save(out);
    }
    
   /*
        public Store(){ //Empty constructor; was used to instance the cli. Uncomment to use for cli();
        }
    */
    
    public String storeName(){
        System.out.println("What is the Store Name?:");
        Scanner scan = new Scanner(System.in); 
        storeName = scan.next();
        System.out.println("Welcome to "+storeName+"!");
        return storeName;
    }
    
    public void addProduct(Product product){
        products.add(product);
        //System.out.println(products);
    }
    
    public int numberOfProducts(){
        int size = products.size();
        return size;
    }
    
    
    public String toString(int productIndex){
        return "stringHolder";
    } 
    @Override
    public String toString(){
        //convert arrayList products to product String so it can be returned as a string:
        String productString = " \n";
        int i =0;
        while(i<products.size()) {
            productString += i+1 +") "+products.get(i)+"\n";
            i++;
        }
        return productString;
    }
    
    //Note: cli is the temporary class controller for the application.
    @Deprecated
    public void cli(){

        int choice;
        storeName();
        int loopVar = 1;
        while( loopVar != 0){
        System.out.println("Make a choice:");
        System.out.println("0) Exit program\n1) Add java\n2) Add Donut");
        Scanner sc = new Scanner(System.in); 
        choice = sc.nextInt();
        if(choice == 0 ) 
            System.exit(0);
        else if(choice == 1){
            //Ordering Java Functionality
            double cost, price; 
            int pickDark, pickShot;;
            String name, shotType;
            
            System.out.println("Please enter a name for your coffee:");
            name = sc.next();
            System.out.println("Enter a cost:");
            cost = sc.nextDouble();
            System.out.println("Enter a price:");
            price = sc.nextDouble();
            
            System.out.println("Choose a darkness:");
            System.out.println("0)"+ Darkness.blond+"\n1)"+ Darkness.light+"\n2)"+ Darkness.medium+"\n3)"+ Darkness.dark +"\n4)"+Darkness.extreme);
            
            Darkness darkChoice = Darkness.blond; 
                pickDark = sc.nextInt();
                switch(pickDark){
                    case(0):{
                        darkChoice = Darkness.blond;
                        break;
                    }
                    case(1):{
                        darkChoice = Darkness.light;
                        break;
                    }
                    case(2):{
                        darkChoice = Darkness.medium;
                        break;
                    }
                    case(3):{
                        darkChoice = Darkness.dark;
                        break;
                    }
                    case(4):{
                        darkChoice = Darkness.extreme;
                        break;
                    }
                    default:
                        System.out.println("Error");
                }
            
            Java covefe = new Java(name, price, cost, darkChoice);
            
            covefe.price = price;
            covefe.name = name;
            covefe.cost = cost;
            //Shot shot = new Shot();
            //shot.addShot();
            System.out.println("Pick a shot:");
            System.out.println("0)"+Shot.none+"\n1)"+Shot.chocolate+"\n2)"+Shot.vanilla+"\n3)"+Shot.peppermint+"\n4)"+Shot.hazelnut+"\n-1 when finished choosing");
            
            int i =0;
            loop: while(i!=1){
                pickShot = sc.nextInt();
                switch(pickShot){
                    case(-1):{
                        i++;
                        
                        break;
                    }
                    case(0):
                        covefe.addShot(Shot.none);
                        break;
                    case(1):{
                        covefe.addShot(Shot.chocolate);
                        break;  
                    }
                    case(2):{
                        covefe.addShot(Shot.vanilla);
                        break;
                    }
                    case(3):{    
                        covefe.addShot(Shot.peppermint);
                        break;
                    }
                    case(4):{
                        covefe.addShot(Shot.hazelnut);
                        break;
                    }
                }
                System.out.println("Added. Choose again, or -1 whenever finished.");
            }
            
            //Print out all the coffee product (toString)
            
            addProduct(covefe); //adds to the arrayList, products
            //System.out.println(covefe); //prints out the coffee items
        }
        else if(choice== 2){
            int frostChoice, fillChoice;
            Frosting frosting;
            Filling filling;
            //add donut functionality
            System.out.println("Please enter a name for the Donut:");
            String name = sc.next();
            System.out.println("Enter a cost:");
            double cost = sc.nextDouble();
            System.out.println("Enter a price:");
            double price = sc.nextDouble();
            
            System.out.println("Choose a frosting:");
            System.out.println("\n0)"+Frosting.unfrosted+"\n1)"+Frosting.chocolate+"\n2)"+Frosting.vanilla+"\n3)"+Frosting.strawberry);
            frosting = Frosting.unfrosted;
            frostChoice = sc.nextInt();
            if(frostChoice == 0){
                frosting = Frosting.unfrosted;
            }
            else if(frostChoice == 1){
                frosting = Frosting.chocolate;
            }
            else if(frostChoice == 2){
                frosting = Frosting.vanilla;
                
            }
            else if(frostChoice == 3){
                frosting = Frosting.strawberry;
            }
            
            System.out.println("Choose a filling:");
            System.out.println("\n0)"+Filling.unfilled+"\n1)"+Filling.creme+"\n2)"+Filling.Bavarian+"\n3)"+Filling.strawberry);
            filling = Filling.unfilled;
            fillChoice = sc.nextInt();
            if(fillChoice == 0){
                filling = Filling.unfilled;
            }
            else if(fillChoice == 1){
                filling = Filling.creme;
            }
            else if(fillChoice == 2){
                filling = Filling.Bavarian;
                
            }
            else if(fillChoice == 3){
                filling = Filling.strawberry;
            }
            
            
            boolean sprinkles;
            System.out.println("Sprinkles? ('true' for yes, 'false' for no)");
            sprinkles = sc.nextBoolean();
            //create new donut object. Push donut object onto arrayList, products
            Donut donut = new Donut(name, price, cost, frosting, sprinkles, filling);
            addProduct(donut);
        }
        
        System.out.println(products); //MUST USE TO STRING TO PRINT THESE OUT
        }
    }
    
    //public static void main(String args[]){
      //  Store store = new Store();
        //store.cli();
        //In our next verion, this will no longer be called with cli... only for representation purpose of the project.
    //}
    
    protected String storeName;
    protected ArrayList<Product> products = new ArrayList<>(); //filled with donut products and java products, includes our price!
    
}
