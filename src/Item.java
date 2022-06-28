/*
The Item object contains the name of the item as well as multiple descriptions of the item,
such as id number, color, where it is stored, where it came from, where it is now, and other descriptions.
This class contains methods to create an item, methods to format the item such as toString, and a method to compare the
id of two items so that items may be sorted.
*/
import java.util.ArrayList;
public class Item{
    int code;
    String name;
    String color;
    String room;
    String from;
    boolean checked_out;
    String check;
    String where;
    String description;
    ArrayList<String> descriptions;

    //generic constructor
    public Item(){

    }
    //costructor from strin containing attributes of the item
    public Item(String str){
        String[] attr = str.split(",",8);
        code = Integer.parseInt(attr[0].trim());
        name = attr[1].trim();
        color = attr[2].trim();
        room = attr[3].trim();
        from = attr[4].trim();
        if(attr[5].equals("Yes"))
            checked_out = true;
        else
            checked_out = false;
        check = attr[5].trim();
        where = attr[6].trim();
        description = attr[7].trim();
        descriptions = toDescList(description);
    }
    //compares the id code of two items to determine which id code is greater
    public boolean isGreaterThan(Item item){
        return code > item.code;
    }
    //formats the item and the descriptions into a string
    public String toString() {
        String str = String.format("%d, %13s, %10s, %10s, %9s, %8s, %12s, %15s\n",
                code, name, color, room, from, check, where, description);
        return str;
    }
    //formats item and description in a way that is used to this the items
    public String toStringForList(){
        String str = String.format("%d;        %-30s %-120s",code,name,color+", " +description);
        return str;
    }
    //formats the item in a way that is used to save the item to a CVS file
    public String toCSV(){
        String str = String.format("%d,%s,%s,%s,%s,%s,%s,",
                code, name, color, room, from, check, where);
        for(int i = 0; i < descriptions.size(); i++){
            str += descriptions.get(i);
            if(!descriptions.get(i).equals(""))
                str += "; ";
        }
        str += "\n";
        return str;
    }
    //helps constructor to seperate out each description
    public ArrayList<String> toDescList(String str){
        ArrayList<String> list = new ArrayList<String>();
        String[] desc = str.split(",");
        for(int i = 0; i < desc.length; i++){
            list.add(desc[i].trim());
        }
        return list;
    }
}