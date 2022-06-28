/*
inventory class stores the list of items, contains the sorting method, and the method to save the list.
 */
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

//Items are stored in an ArrayList of Item objects
public class Inventory{
    ArrayList<Item> list = new ArrayList<Item>();
    String[] categories = new String[70];
    File inventoryFile;
    File inventoryCSV;
    public Inventory(File invFile, File invCSV){
        inventoryFile = invFile;
        inventoryCSV = invCSV;
        setCategories();
    }
    //constructor sets the categories of the list
    public Inventory(){
        setCategories();
    }

    //these functions maintain the list
    public void addItem(Item item){
        list.add(item);
    }
    public int size(){
        return list.size();
    }
    public Item get(int i){
        return list.get(i);
    }
    public int indexOf(Item item){
        return list.indexOf(item);
    }
    public Item remove(int i){
        return list.remove(i);
    }
    public void clear(){
        list.clear();
    }

    //sorts the list by id number of the items
    public void sort(){
        for(int i = 0; i < list.size(); i++){
            for(int j = 0; j < list.size() - i - 1; j++){
                if(list.get(j).code > list.get(j+1).code){
                    Item temp = list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }
    }
    // determines if a code is already in use in the list
    public boolean codeIsUsed(int code){
        for(int i = 0; i<size(); i++){
            if(list.get(i).code == code){
                return true;
            }
        }
        return false;
    }
    //creates a new code determined by the category of the item.
    public int getNewItemCode(String category){
        double num = 0;
        switch (category){
            case "Chalices":
                num = 11;
                break;
            case "Patens":
                num = 12;
                break;
            case "Ciboria":
                num = 13;
                break;
            case "pyx":
                num = 13.5;
                break;
            case "Thuribles":
                num = 14;
                break;
            case "boats":
                num = 14.5;
                break;
            case "Cruets":
                num = 15;
                break;
            case "Cruet Tray/Dish":
                num = 15.5;
                break;
            case "Veil":
                num = 16;
                break;
            case "Burse":
                num = 16.5;
                break;
            case "Corpral":
                num = 17;
                break;
            case "Pall":
                num = 17.5;
                break;
            case "Monstrance":
                num = 18;
                break;
            case "Luna":
                num = 18.5;
                break;
            case "Crosses":
                num = 19;
                break;
            case "Processional Crosses":
                num = 19.5;
                break;
            case "Candle Stands":
                num = 21;
                break;
            case "Candle Accessories":
                num = 22;
                break;
            case "Bells":
                num = 23;
                break;
            case "Containers for Sacred Oils":
                num = 24;
                break;
            case "Cassocks":
                num = 31;
                break;
            case "Surplice":
                num = 32;
                break;
            case "Albs":
                num = 33;
                break;
            case "Chasubles":
                num = 34;
                break;
            case "Dalmatics":
                num = 34.5;
                break;
            case "Stoles":
                num = 35;
                break;
            case "Other Vestments":
                num = 39;
                break;
            case "Roman Missal":
                num = 41;
                break;
            case "Lectionary":
                num = 42;
                break;
            case "Book of Rites":
                num = 43;
                break;
            case "Breveries":
                num = 44;
                break;
            case "Other Books":
                num = 45;
                break;
            case "Book Accessories":
                num = 48;
                break;
            case "Book Stands":
                num = 49;
                break;
            case "Holy Water Dishes/Containers":
                num = 51;
                break;
            case "Statues":
                num = 52;
                break;
            case "Stations of the Cross":
                num = 53;
                break;
            case "Ambo/Lecturn":
                num = 54;
                break;
            case "Chairs":
                num = 55;
                break;
            case "Other Furniture":
                num = 56;
                break;
            case "Pictures":
                num = 57;
                break;
            case "Other":
                num = 60;
                break;
        }
        int newCode = (int)(num * 1000);
        //checks if code is already used to ensure each item has a unique code
        newCode++;
        while(codeIsUsed(newCode)){
            newCode++;
        }
        return newCode;

    }
    private void setCategories(){
        categories[0] = "Chalices";
        categories[1] = "Patens";
        categories[2] = "Ciboria";
        categories[3] = "pyx";
        categories[4] = "Thuribles";
        categories[5] = "boats";
        categories[6] = "Cruets";
        categories[7] = "Cruet Tray/Dish";
        categories[8] = "Veil";
        categories[9] = "Burse";
        categories[10] = "Corpral";
        categories[11] = "Pall";
        categories[12] = "Monstrance";
        categories[13] = "Luna";
        categories[14] = "Crosses";
        categories[15] = "Processional Crosses";
        categories[16] = "Candle Stands";
        categories[17] = "Candle Accessories";
        categories[18] = "Bells";
        categories[19] = "Containers for Sacred Oils";
        categories[20] = "Cassocks";
        categories[21] = "Surplice";
        categories[22] = "Albs";
        categories[23] = "Chasubles";
        categories[24] = "Dalmatics";
        categories[25] = "Stoles";
        categories[26] = "Roman Missal";
        categories[27] = "Lectionary";
        categories[28] = "Book of Rites";
        categories[29] = "Breveries";
        categories[30] = "Other Books";
        categories[31] = "Book Stands";
        categories[32] = "Holy Water Dishes/Containers";
        categories[33] = "Statues";
        categories[34] = "Stations of the Cross";
        categories[35] = "Ambo/Lecturn";
        categories[36] = "Chairs";
        categories[37] = "Other Furniture";
        categories[38] = "Pictures";
    }
    //saves the items in the list to a text file to be read in when program is run and a CVS file to be used to see the items in the inventory
    public void saveInventory() throws Exception{
        sort();
        FileWriter fw = new FileWriter(inventoryFile, false);
        PrintWriter pw = new PrintWriter(inventoryCSV);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(String.format("%9s %10s %12s %10s %10s %15s %10s %15s\n","Item Code","Name","Color","Room","From","Checked Out","Where","Description"));
        pw.write("Item Code,Name,Color,Room,From,Checked Out,Where,Description\n");
        for(int i = 0; i < size(); i++){
            bw.write(get(i).toString());
            pw.write(get(i).toCSV());
        }
        bw.close();
        pw.flush();
        pw.close();
    }
}