/*
 * Interface for ceremonial room invetory
 * Luke Zoroufy
 * 01/06/2021
 */
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.*;

public class driver {
    static Inventory inventory;
    public static void main(String[] args) throws Exception {
        new driver();
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                try {
                    InterfaceWindow gui = new InterfaceWindow(inventory);
                }catch(Exception e){

                }
            }
        });
    }
    //sets file path to text file and CSV file
    File inventoryFile = new File("../documents/inventory.txt");
    File inventoryCSV = new File("../documents/inventory.csv");
    public driver() throws Exception{
        inventory = loadInventory();
    }
    //loads in inventory
    public Inventory loadInventory() throws Exception{
        Inventory inv = new Inventory(inventoryFile, inventoryCSV);
        Scanner sc = new Scanner(inventoryFile);
        String str = sc.nextLine();
        while(sc.hasNextLine()){
            str = sc.nextLine();
            Item item = new Item(str);
            inv.addItem(item);
        }
        return inv;
    }

}