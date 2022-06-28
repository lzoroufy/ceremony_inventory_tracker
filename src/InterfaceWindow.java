/*
InterfaceWindow class contains all of the code of the GUI.
There are two windows.  The main window is where the list is displayed and search features are available.
The second is a pop up window when looking at or editing the information of a specific item.
 */
import javax.swing.*;
import javax.swing.JScrollPane;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import javax.swing.event.*;
import java.io.IOException;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

public class InterfaceWindow extends JFrame{
    boolean inSearch = false;
    Inventory fullInv;
    JList<String> full_list;
    DefaultListModel<String> full_dlm;

    Inventory searchInv;
    //JFrame win;

    JLabel numberLabel;
    JTextField numberText;

    JLabel nameLabel;
    JTextField nameText;

    JLabel colorLabel;
    JTextField colorText;

    JLabel roomLabel;
    JTextField roomText;

    JLabel fromLabel;
    JTextField fromText;

    JLabel checkLabel;
    JTextField checkText;

    JLabel whereLabel;
    JTextField whereText;

    JLabel descriptionLabel;
    JTextArea descriptionText;

    JLabel numberListLabel;
    JLabel nameListLabel;
    JLabel descriptionListLabel;

    JButton addButton;
    JButton saveButton;
    JButton searchButton;
    JButton clearSearchButton;
    JButton editButton;

    //Creates the main window
    public InterfaceWindow(Inventory inventory)throws Exception {
        //puts items into list to be displayed
        fullInv = inventory;
        searchInv = new Inventory();
        fullInv.sort();
        getContentPane().setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();

        //sets and formats text boxes and labels
        numberLabel = new JLabel("Item Number");
        numberLabel.setBounds(20,50,100,30);
        numberText = new JTextField();
        numberText.setBounds(10,70,100,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 50;
        c.gridx = 0;
        c.gridy = 0;
        getContentPane().add(numberLabel,c);

        nameLabel = new JLabel("Name");
        nameLabel.setBounds(120,50,100,30);
        nameText = new JTextField();
        nameText.setBounds(110,70,100,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipadx = 50;
        c.gridx = 1;
        c.gridy = 0;
        getContentPane().add(nameLabel,c);

        colorLabel = new JLabel("Color");
        colorLabel.setBounds(220,50,100,30);
        colorText = new JTextField();
        colorText.setBounds(210,70,100,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 0;
        getContentPane().add(colorLabel,c);

        roomLabel = new JLabel("Room");
        roomLabel.setBounds(320,50,100,30);
        roomText = new JTextField();
        roomText.setBounds(310,70,100,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 3;
        c.gridy = 0;
        getContentPane().add(roomLabel,c);

        fromLabel = new JLabel("From");
        fromLabel.setBounds(420,50,100,30);
        fromText = new JTextField();
        fromText.setBounds(410,70,100,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 4;
        c.gridy = 0;
        getContentPane().add(fromLabel,c);

        checkLabel = new JLabel("Checked Out");
        checkLabel.setBounds(520,50,100,30);
        checkText = new JTextField();
        checkText.setBounds(510,70,100,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 5;
        c.gridy = 0;
        getContentPane().add(checkLabel,c);

        whereLabel = new JLabel("Where");
        whereLabel.setBounds(620,50,100,30);
        whereText = new JTextField();
        whereText.setBounds(610,70,100,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 6;
        c.gridy = 0;
        getContentPane().add(whereLabel,c);

        descriptionLabel = new JLabel("Description");
        descriptionLabel.setBounds(720,50,100,30);
        descriptionText = new JTextArea();
        descriptionText.setLineWrap(true);
        descriptionText.setBounds(710,75,200,80);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 7;
        c.gridy = 0;
        getContentPane().add(descriptionLabel,c);

        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 0;
        c.gridy = 1;
        getContentPane().add(numberText,c);
        c.gridx = 1;
        c.gridy = 1;
        getContentPane().add(nameText,c);
        c.gridx = 2;
        c.gridy = 1;
        getContentPane().add(colorText,c);
        c.gridx = 3;
        c.gridy = 1;
        getContentPane().add(roomText,c);
        c.gridx = 4;
        c.gridy = 1;
        getContentPane().add(fromText,c);
        c.gridx = 5;
        c.gridy = 1;
        getContentPane().add(checkText,c);
        c.gridx = 6;
        c.gridy = 1;
        getContentPane().add(whereText,c);
        c.gridx = 7;
        c.gridy = 1;
        getContentPane().add(descriptionText,c);

        numberListLabel = new JLabel("Number");
        numberListLabel.setBounds(5,175,100,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 50;
        c.gridx = 0;
        c.gridy = 2;
        getContentPane().add(numberListLabel,c);

        nameListLabel = new JLabel("Name");
        nameListLabel.setBounds(80,175,100,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 1;
        c.gridy = 2;
        getContentPane().add(nameListLabel,c);

        descriptionListLabel = new JLabel("Description");
        descriptionListLabel.setBounds(380,175,100,30);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.gridx = 2;
        c.gridy = 2;
        getContentPane().add(descriptionListLabel,c);

        //Sets scoll pane and adds the sorted list of items to the pane
        full_dlm = new DefaultListModel<>();
        for(int i = 0; i < fullInv.size(); i++){
            full_dlm.addElement(fullInv.get(i).toStringForList());
        }
        full_list = new JList<>(full_dlm);
        full_list.setBounds(20,200,900,300);

        JScrollPane scrollPane = new JScrollPane(full_list);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.ipady = 280;
        c.gridx = 0;
        c.gridy = 3;
        c.gridwidth = 8;
        scrollPane.setVisible(true);
        full_list.setVisible(true);
        scrollPane.setViewportView(full_list);
        getContentPane().add(scrollPane,c);
        setSize(1000, 500);
        setVisible(true);
        getContentPane().add(scrollPane,c);

        //sets buttons and their respective function
        addButton = new JButton("ADD ITEM");
        addButton.setBounds(550,80,100,50);
        addButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                openAddWindow();
            }
        });

        getContentPane().add(addButton);

        editButton = new JButton("EDIT");
        editButton.setBounds(650,80,100,50);
        editButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                int indexSelect = full_list.getSelectedIndex();
                if(indexSelect >= 0) {
                    Item item;
                    if(inSearch)
                        item = searchInv.get(indexSelect);
                    else
                        item = fullInv.get(indexSelect);
                    openEditWindow(item, indexSelect);
                }
            }
        });
        getContentPane().add(editButton);

        searchButton = new JButton("SEARCH");
        searchButton.setBounds(300,80,100,50);
        searchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inSearch = true;
                search();
                full_dlm.clear();
                for(int i = 0; i < searchInv.size(); i++){
                    full_dlm.addElement(searchInv.get(i).toStringForList());
                }
            }
        });
        getContentPane().add(searchButton);

        clearSearchButton = new JButton("CLEAR SEARCH");
        clearSearchButton.setBounds(400,80,150,50);
        clearSearchButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e){
                inSearch = false;
                full_dlm.clear();
                for(int i = 0; i < fullInv.size(); i++){
                    full_dlm.addElement(fullInv.get(i).toStringForList());
                }
                clearTextFields();
            }
        });
        getContentPane().add(clearSearchButton);

        saveButton = new JButton("SAVE");
        saveButton.setBounds(600,500,100,50);
        saveButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                try {
                    fullInv.saveInventory();
                }catch(Exception exp){
                    JFrame mess = new JFrame();
                    JOptionPane.showMessageDialog(mess,"Could Not Save!");
                }
            }
        });
        getContentPane().add(saveButton);

        //title text in the GUI
        JLabel diolc = new JLabel("DIOCESE of LA CROSSE");
        diolc.setFont(new Font("Calibri", Font.BOLD, 28));
        diolc.setBounds(100,500,600,60);
        getContentPane().add(diolc);

        JLabel cri = new JLabel("Ceremonies Room");
        cri.setFont(new Font("Calibri", Font.BOLD, 20));
        cri.setBounds(100,530,400,100);
        getContentPane().add(cri);

        JLabel in = new JLabel("Inventory");
        in.setFont(new Font("Calibri", Font.BOLD, 20));
        in.setBounds(100,550,400,100);
        getContentPane().add(in);


        setLayout(null);
        setTitle("DIOLC Ceremonies Room Inventory System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1400,1000);
        getContentPane().setBackground(new Color(166,220,255));
        setVisible(true);
    }

    //Search function reduces the list to just the items that match the parameters that are in the search boxes
    public void search(){
        searchInv.clear();
        for(int i = 0; i < fullInv.size(); i++){
            searchInv.addItem(fullInv.get(i));
        }
        int i;
        if(!numberText.getText().equals("")) {
            i = 0;
            while(i < searchInv.size()){
                if(searchInv.get(i).code != Integer.parseInt(numberText.getText())) {
                    searchInv.remove(i);
                    i--;
                }
                i++;
            }
        }
        if(!nameText.getText().equals("")){
            i = 0;
            while(i < searchInv.size()){
                if(!searchInv.get(i).name.toLowerCase().contains(nameText.getText().toLowerCase())){
                    searchInv.remove(i);
                    i--;
                }
                i++;
            }
        }
        if(!colorText.getText().equals("")){
            i = 0;
            while(i < searchInv.size()){
                if(!searchInv.get(i).color.toLowerCase().contains(colorText.getText().toLowerCase())) {
                    searchInv.remove(i);
                    i--;
                }
                i++;
            }
        }
        if(!roomText.getText().equals("")){
            i = 0;
            while(i < searchInv.size()){
                if(!searchInv.get(i).room.toLowerCase().contains(roomText.getText().toLowerCase())){
                    searchInv.remove(i);
                    i--;
                }
                i++;
            }
        }
        if(!fromText.getText().equals("")){
            i = 0;
            while(i < searchInv.size()){
                if(!searchInv.get(i).from.toLowerCase().contains(fromText.getText().toLowerCase())) {
                    searchInv.remove(i);
                    i--;
                }
                i++;
            }
        }
        if(!checkText.getText().equals("")){
            i = 0;
            while(i < searchInv.size()){
                if(!searchInv.get(i).check.toLowerCase().contains(checkText.getText().toLowerCase())){
                    searchInv.remove(i);
                    i--;
                }
                i++;
            }
        }
        if(!whereText.getText().equals("")){
            i = 0;
            while(i < searchInv.size()){
                if(!searchInv.get(i).where.toLowerCase().contains(whereText.getText().toLowerCase())) {
                    searchInv.remove(i);
                    i--;
                }
                i++;
            }
        }
        if(!descriptionText.getText().equals("")){
            i = 0;
            while(i < searchInv.size()){
                boolean keep = false;
                Item target = searchInv.get(i);
                for(int j = 0; j < target.descriptions.size(); j++){
                    if(target.descriptions.get(j).toLowerCase().contains(descriptionText.getText().toLowerCase()))
                        keep = true;
                }
                if(!keep){
                    searchInv.remove(i);
                    i--;
                }
                i++;
            }
        }
    }
    //clears the search parameter boxes as well as displayes the complete list.
    public void clearTextFields(){
        numberText.setText("");
        nameText.setText("");
        colorText.setText("");
        roomText.setText("");
        fromText.setText("");
        checkText.setText("");
        whereText.setText("");
        descriptionText.setText("");
    }
    //create and displays pop up window that allows a new item to be created and saved into the list
    public void openAddWindow(){
        JFrame addWin;

        JLabel addNumberLabel;
        JLabel addNumberText;

        //list of catagories that the item could be in.  Catagory dictates id number of item.
        JList catTable;
        String[] categories = new String[42];
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
        categories[26] = "Other Vestments";
        categories[27] = "Roman Missal";
        categories[28] = "Lectionary";
        categories[29] = "Book of Rites";
        categories[30] = "Breveries";
        categories[31] = "Other Books";
        categories[32] = "Book Stands";
        categories[33] = "Book Accessories";
        categories[34] = "Holy Water Dishes/Containers";
        categories[35] = "Statues";
        categories[36] = "Stations of the Cross";
        categories[37] = "Ambo/Lecturn";
        categories[38] = "Chairs";
        categories[39] = "Other Furniture";
        categories[40] = "Pictures";
        categories[41] = "Other";

        JLabel addNameLabel;
        JTextField addNameText;

        JLabel addColorLabel;
        JTextField addColorText;

        JLabel addRoomLabel;
        JTextField addRoomText;

        JLabel addFromLabel;
        JTextField addFromText;

        JLabel addCheckLabel;
        JTextField addCheckText;

        JLabel addWhereLabel;
        JTextField addWhereText;

        JLabel addDescriptionLabel;
        JTextArea addDescriptionText;

        JButton addItemButton;

        addWin = new JFrame();

        //formats labels and text boxes for add window
        addNumberLabel = new JLabel("Item Number:");
        addNumberLabel.setBounds(20,50,100,30);
        addNumberText = new JLabel("#####");
        addNumberText.setBounds(120,50,100,30);
        addWin.add(addNumberLabel);
        addWin.add(addNumberText);

        addNameLabel = new JLabel("Name:");
        addNameLabel.setBounds(20,80,100,30);
        addNameText = new JTextField("name");
        addNameText.setBounds(110,80,100,30);
        addWin.add(addNameLabel);
        addWin.add(addNameText);

        addColorLabel = new JLabel("Color:");
        addColorLabel.setBounds(20,110,100,30);
        addColorText = new JTextField("color");
        addColorText.setBounds(110,110,100,30);
        addWin.add(addColorLabel);
        addWin.add(addColorText);

        addRoomLabel = new JLabel("Room:");
        addRoomLabel.setBounds(20,140,100,30);
        addRoomText = new JTextField("A015");
        addRoomText.setBounds(110,140,100,30);
        addWin.add(addRoomLabel);
        addWin.add(addRoomText);

        addFromLabel = new JLabel("From:");
        addFromLabel.setBounds(20,170,100,30);
        addFromText = new JTextField("from");
        addFromText.setBounds(110,170,100,30);
        addWin.add(addFromLabel);
        addWin.add(addFromText);

        addCheckLabel = new JLabel("Checked Out:");
        addCheckLabel.setBounds(20,200,100,30);
        addCheckText = new JTextField("No");
        addCheckText.setBounds(110,200,100,30);
        addWin.add(addCheckLabel);
        addWin.add(addCheckText);

        addWhereLabel = new JLabel("Where:");
        addWhereLabel.setBounds(20,230,100,30);
        addWhereText = new JTextField("NA");
        addWhereText.setBounds(110,230,100,30);
        addWin.add(addWhereLabel);
        addWin.add(addWhereText);

        addDescriptionLabel = new JLabel("Description:");
        addDescriptionLabel.setBounds(20,260,100,30);
        addDescriptionText = new JTextArea("");
        addDescriptionText.setLineWrap(true);
        addDescriptionText.setBounds(110,260,200,80);
        addWin.add(addDescriptionLabel);
        addWin.add(addDescriptionText);

        DefaultListModel<String> dlm = new DefaultListModel<>();
        for(int i = 0; i < categories.length; i++){
            dlm.addElement(categories[i]);
        }
        JList<String> list = new JList<>(dlm);
        list.setBounds(350,10,200,750);
        list.addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent evt) {
                if (evt.getValueIsAdjusting())
                    return;
                //assigns unique id number to the item when a catagory is chosen
                addNumberText.setText(""+fullInv.getNewItemCode(list.getSelectedValue()));
            }
        });
        addWin.add(list);

        //Add button creates the item and adds it to the main list to be displayed on the main window
        addItemButton = new JButton("Add Item");
        addItemButton.setBounds(110,360,100,50);
        addItemButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s", addNumberText.getText(),
                        addNameText.getText(), addColorText.getText(), addRoomText.getText(),
                        addFromText.getText(), addCheckText.getText(), addWhereText.getText(),
                        addDescriptionText.getText());
                Item item = new Item(str);
                fullInv.addItem(item);
                fullInv.sort();
                full_dlm.clear();
                for(int i = 0; i < fullInv.size(); i++){
                    full_dlm.addElement(fullInv.get(i).toStringForList());
                }
                if(inSearch) {
                    search();
                    full_dlm.clear();
                    for (int i = 0; i < searchInv.size(); i++) {
                        full_dlm.addElement(searchInv.get(i).toStringForList());
                    }
                }
                addWin.setVisible(false);
            }
        });
        addWin.add(addItemButton);

        addWin.setBounds(800,0,600,800);
        addWin.setLayout(null);
        addWin.setVisible(true);
    }

    //edit window is similar to add window but allows you to change the attributes of the item but not create a new item
    public void openEditWindow(Item item, int idxSlct){
        JFrame editWin;

        JLabel editNumberLabel;
        JLabel editNumberText;

        JLabel editNameLabel;
        JTextField editNameText;

        JLabel editColorLabel;
        JTextField editColorText;

        JLabel editRoomLabel;
        JTextField editRoomText;

        JLabel editFromLabel;
        JTextField editFromText;

        JLabel editCheckLabel;
        JTextField editCheckText;

        JLabel editWhereLabel;
        JTextField editWhereText;

        JLabel editDescriptionLabel;
        JTextArea editDescriptionText;

        JButton editItemButton;
        JButton deleteItemButton;

        editWin = new JFrame();

        editNumberLabel = new JLabel("Item Number:");
        editNumberLabel.setBounds(20,50,100,30);
        editNumberText = new JLabel(""+item.code);
        editNumberText.setBounds(120,50,100,30);
        editWin.add(editNumberLabel);
        editWin.add(editNumberText);

        editNameLabel = new JLabel("Name:");
        editNameLabel.setBounds(20,80,100,30);
        editNameText = new JTextField(item.name);
        editNameText.setBounds(110,80,100,30);
        editWin.add(editNameLabel);
        editWin.add(editNameText);

        editColorLabel = new JLabel("Color:");
        editColorLabel.setBounds(20,110,100,30);
        editColorText = new JTextField(item.color);
        editColorText.setBounds(110,110,100,30);
        editWin.add(editColorLabel);
        editWin.add(editColorText);

        editRoomLabel = new JLabel("Room:");
        editRoomLabel.setBounds(20,140,100,30);
        editRoomText = new JTextField(item.room);
        editRoomText.setBounds(110,140,100,30);
        editWin.add(editRoomLabel);
        editWin.add(editRoomText);

        editFromLabel = new JLabel("From:");
        editFromLabel.setBounds(20,170,100,30);
        editFromText = new JTextField(item.from);
        editFromText.setBounds(110,170,100,30);
        editWin.add(editFromLabel);
        editWin.add(editFromText);

        editCheckLabel = new JLabel("Checked Out:");
        editCheckLabel.setBounds(20,200,100,30);
        editCheckText = new JTextField(item.check);
        editCheckText.setBounds(110,200,100,30);
        editWin.add(editCheckLabel);
        editWin.add(editCheckText);

        editWhereLabel = new JLabel("Where:");
        editWhereLabel.setBounds(20,230,100,30);
        editWhereText = new JTextField(item.where);
        editWhereText.setBounds(110,230,100,30);
        editWin.add(editWhereLabel);
        editWin.add(editWhereText);

        editDescriptionLabel = new JLabel("Description:");
        editDescriptionLabel.setBounds(20,260,100,30);
        editDescriptionText = new JTextArea(item.description);
        editDescriptionText.setLineWrap(true);
        editDescriptionText.setBounds(110,260,200,80);
        editWin.add(editDescriptionLabel);
        editWin.add(editDescriptionText);

        //save changes buttons saves the new attributes and adds the updated item to the main list
        editItemButton = new JButton("Save Changes");
        editItemButton.setBounds(50,360,100,50);
        editItemButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                full_dlm.clear();
                for(int i = 0; i < fullInv.size(); i++){
                    full_dlm.addElement(fullInv.get(i).toStringForList());
                }
                int indexSelect = idxSlct;
                if(inSearch){
                    indexSelect = fullInv.indexOf(searchInv.get(idxSlct));
                }
                fullInv.remove(indexSelect);
                full_dlm.remove(indexSelect);
                String str = String.format("%s,%s,%s,%s,%s,%s,%s,%s", editNumberText.getText(),
                        editNameText.getText(), editColorText.getText(), editRoomText.getText(),
                        editFromText.getText(), editCheckText.getText(), editWhereText.getText(),
                        editDescriptionText.getText());
                Item newItem = new Item(str);
                fullInv.addItem(newItem);
                fullInv.sort();
                full_dlm.add(fullInv.indexOf(newItem), newItem.toStringForList());
                editWin.setVisible(false);
                if(inSearch) {
                    search();
                    full_dlm.clear();
                    for (int i = 0; i < searchInv.size(); i++) {
                        full_dlm.addElement(searchInv.get(i).toStringForList());
                    }
                }
            }
        });
        editWin.add(editItemButton);

        //delete item button removes the item from the list
        deleteItemButton = new JButton("Delete Item");
        deleteItemButton.setBounds(170,360,100,50);
        deleteItemButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
                full_dlm.clear();
                for(int i = 0; i < fullInv.size(); i++){
                    full_dlm.addElement(fullInv.get(i).toStringForList());
                }
                int indexSelect = idxSlct;
                if(inSearch){
                    indexSelect = fullInv.indexOf(searchInv.get(idxSlct));
                }
                fullInv.remove(indexSelect);
                full_dlm.remove(indexSelect);
                fullInv.sort();
                editWin.setVisible(false);
                if(inSearch) {
                    search();
                    full_dlm.clear();
                    for (int i = 0; i < searchInv.size(); i++) {
                        full_dlm.addElement(searchInv.get(i).toStringForList());
                    }
                }
            }
        });
        editWin.add(deleteItemButton);

        editWin.setBounds(900,0,350,500);
        editWin.setLayout(null);
        editWin.setVisible(true);
    }

}