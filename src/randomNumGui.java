import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class randomNumGui implements ActionListener {
    private JTextArea nums;
    private JTextField smallest;
    private JTextField biggest;
    private ArrayList<String> numsWithInfo;

    public randomNumGui()
    {
        nums = new JTextArea(20, 35);
        smallest = new JTextField();
        biggest = new JTextField();
        numsWithInfo = new ArrayList<>();

        setUp();
    }

    private void setUp()
    {
        JFrame frame = new JFrame("Get Some Random Numbers!");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel welcomeLabel = new JLabel("Numbers!");
        welcomeLabel.setFont(new Font("Helvetica", Font.BOLD, 20));
        welcomeLabel.setForeground(Color.green);

        JPanel logoWelcomePanel = new JPanel();
        logoWelcomePanel.add(welcomeLabel);

        JPanel numListPanel = new JPanel();
        nums.setText("Nums?! \n" );
        nums.setFont(new Font("Helvetica", Font.PLAIN, 16));
        nums.setLineWrap(true);
        nums.setWrapStyleWord(true);
        numListPanel.add(nums);

        JPanel entryPanel = new JPanel();
        JLabel smallLabel = new JLabel("Smallest Number: ");
        smallest = new JTextField(10);
        JLabel bigLabel = new JLabel("Biggest Number: ");
        biggest = new JTextField(10);
        JButton updateButton = new JButton("Update");
        JButton resetButton = new JButton("Reset");
        entryPanel.add(smallLabel);
        entryPanel.add(smallest);
        entryPanel.add(bigLabel);
        entryPanel.add(biggest);
        entryPanel.add(updateButton);
        entryPanel.add(resetButton);

        frame.add(logoWelcomePanel, BorderLayout.NORTH);
        frame.add(numListPanel, BorderLayout.CENTER);
        frame.add(entryPanel, BorderLayout.SOUTH);

        updateButton.addActionListener(this);
        resetButton.addActionListener(this);

        frame.pack();
        frame.setVisible(true);


    }

    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) (e.getSource());
        String text = button.getText();

        if(text.equals("Update"))
        {
            String smallBox = smallest.getText();
            String bigBox = biggest.getText();
            int small = Integer.parseInt(smallBox);
            int big = Integer.parseInt(bigBox);
            int rand;
            if(small < big)
            {
                rand = (int) (Math.random()*(big-small+1)+small);
                numsWithInfo.add("Wow you followed the parameters, your random number is: " + rand);
            } else if(big < small)
            {
                rand = (int) (Math.random()*(small-big+1)+big);
                numsWithInfo.add("Why can't you put your numbers in the right spot: " + rand);

            } else
            {
                numsWithInfo.add("Why would you make the numbers the same. Fine you just get " + big);
            }

            String words = "";
            for (String word: numsWithInfo) {
                words+= word + "\n";
            }

            nums.setText(words);
        }
        else if(text.equals("Reset"))
        {
            nums.setText("");

        }
    }




}
