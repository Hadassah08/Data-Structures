import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Pizza extends JFrame implements ActionListener, ItemListener {
    final int FRAME_WIDTH = 800;
    final int FRAME_HEIGHT = 400;
    private int total = 0;
    JComboBox pizzasizes;

    private JCheckBox pepperoniCheckbox, veggiesCheckbox, chickenCheckbox, beefCheckbox, cheeseCheckbox;
    private JLabel totalPriceLabel; // JLabel to display the total price

    public Pizza() {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("BigY Pizza Store");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255,71,77));//color of window
        JLabel namePrompt = new JLabel("Choose a Pizza Size");
        namePrompt.setForeground(Color.BLACK);//color for pizza size prompt
        namePrompt.setHorizontalAlignment(JLabel.CENTER);
        namePrompt.setFont(new Font("Arial", Font.ITALIC, 16)); //font settings for the prompt
        String sizes[] = {"Small - $5", "Medium - $10", "Large - $15", "Super - $20"}; //sets a list of the options for the combo box
        setLayout(new GridLayout(6, 2));
        pizzasizes = new JComboBox(sizes); //puts the sizes in a combo box
        pizzasizes.setForeground(new Color(255,71,77));
        pizzasizes.setBackground(new Color(177,156,217));
        JLabel tplabel = new JLabel("     Pick at least 1 topping and at most 3 toppings");
        tplabel.setForeground(Color.WHITE); // changes the color of the text
        pepperoniCheckbox = new JCheckBox("Pepperoni", false); //creates a checkbox with this option
        pepperoniCheckbox.setForeground(new Color(128,0,0));
        veggiesCheckbox = new JCheckBox("Veggies", false); //creates a checkbox with this option
        veggiesCheckbox.setForeground(Color.GREEN);
        chickenCheckbox = new JCheckBox("Chicken", false); //creates a checkbox with this option
        chickenCheckbox.setForeground(new Color(238,206,128));
        beefCheckbox = new JCheckBox("Beef", false); //creates a checkbox with this option
        beefCheckbox.setForeground(new Color(105,61,61));
        cheeseCheckbox = new JCheckBox("Extra Cheese", false); //creates a checkbox with this option
        cheeseCheckbox.setForeground(Color.YELLOW);
        pepperoniCheckbox.addItemListener(this); //addItemListener ensured that when the checkbox is checked it does something
        veggiesCheckbox.addItemListener(this);
        chickenCheckbox.addItemListener(this);
        beefCheckbox.addItemListener(this);
        cheeseCheckbox.addItemListener(this);
        JButton button = new JButton("Calculate");
        button.addActionListener(this);
        totalPriceLabel = new JLabel("Total Price: ");
        button.setPreferredSize(new Dimension(30, 30));
        add(namePrompt);
        add(pizzasizes);
        add(tplabel);
        add(pepperoniCheckbox);
        add(veggiesCheckbox);
        add(chickenCheckbox);
        add(beefCheckbox);
        add(cheeseCheckbox);
        add(totalPriceLabel);
        add(button);

        pizzasizes.addActionListener(this);
        setVisible(true); //makes everything visible
    }

    public void actionPerformed(ActionEvent e) {
        double BasePrice = 0;

        String selectedSize = (String) pizzasizes.getSelectedItem(); //equates select item to whatever parameter chosen

        //updates BasePrice for whatever price the size is
        switch (selectedSize) {
            case "Small - $5":
                BasePrice = 5;
                break;
            case "Medium - $10":
                BasePrice = 10;
                break;
            case "Large - $15":
                BasePrice = 15;
                break;
            case "Super - $20":
                BasePrice = 20;
                break;

        }

        double toppingsCost = 0;
        //these blocks add 0.5 to the price when the checkboxes are clicked
        if (pepperoniCheckbox.isSelected()) toppingsCost += 0.5;
        if (veggiesCheckbox.isSelected()) toppingsCost += 0.5;
        if (chickenCheckbox.isSelected()) toppingsCost += 0.5;
        if (beefCheckbox.isSelected()) toppingsCost += 0.5;

        // Calculate additional charge for toppings
        double additionalCharge = 0;
        if (toppingsCost == 1.50) {
            additionalCharge = 1.25; // Special deal for 3 toppings
        } else {
            additionalCharge = toppingsCost; // $0.50 per topping
        }
        //this block checks if when more than three toppings are selected, the price stays the same and a prompt tells us we can't pick more than three
        /*because extra cheese is free, we still need to make sure that we get the prompt to tell us we can't pick it if three toppings are already selected
        *The second part of the or statement checks if the additional cost is already 1.25(meaning 3 picked) and if it is then extra cheese can't be picked*/
        if (toppingsCost > 1.50 || (cheeseCheckbox.isSelected() && additionalCharge == 1.25)) {
            JOptionPane.showMessageDialog(this, "You can only have 3 toppings, Don’t be greedy");
            additionalCharge = 1.25;
        } else {
            //this only runs if the pizza is legal
            double totalPrice = BasePrice + additionalCharge;
            totalPriceLabel.setText("Total Price: $" + totalPrice);
        }


    }

    public void itemStateChanged(ItemEvent e) {
        // Logic for handling topping selection
    }

    public static void main(String[] args) {
        new Pizza();
    }
}