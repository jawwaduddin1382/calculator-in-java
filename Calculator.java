import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Calculator extends JFrame {

    private JPanel displayPanel=new JPanel(new GridLayout(2,1));
    private JPanel oprationPanel=new JPanel(new GridLayout(5,1,2,2));
    private JPanel numBtnPanel=new JPanel(new GridLayout(5,3, 2,2));

    Font font=new Font("arail",Font.BOLD,20);

    private JTextField tfDisplsy;
    private JTextArea taHistory;
    private JMenuBar menuBar;
    private JMenu fileMenu,editMenu;
    private JMenuItem about,exite;
    private JCheckBox chBox;
    private JScrollPane Js;
    JButton btnNum[]=new JButton[15];
    String btnText[]={"C","x","P","7","8","9","4","5","6","1","2","3","0",".","+/-"};

    JButton oprationBTn[]=new JButton[5];
    String oprtionText[]={"/","*","-","+","="};

    double firstnumber,secondnumber,result;
    String opretion;
    
    
    public Calculator(){
       
        setUpMenuBar();
        setMainDisplay();
        setNumBtn();
        setOprationBtn();
        setUpMainFrame();
        
    }
    
    public void setOprationBtn(){
        for(int i=0 ; i<oprationBTn.length-1 ; i++){
            oprationBTn[i]=new JButton(oprtionText[i]);
            oprationBTn[i].setBackground(Color.lightGray);
            oprationBTn[i].setBorder(BorderFactory.createLineBorder(Color.lightGray));
            oprationBTn[i].setFont(new Font("arail",Font.BOLD,20));
            oprationBTn[i].setForeground(Color.GRAY);
            oprationPanel.add(oprationBTn[i]);
            int index1=i;
            oprationBTn[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    opretion=oprationBTn[index1].getText();
                    firstnumber=Double.parseDouble(tfDisplsy.getText());
                    taHistory.append(firstnumber+opretion);
                    
                }
            });
        }
        for (int i=0 ; i<oprationBTn.length-1; i++){
            int index2=i;
            oprationBTn[i].addMouseListener(new MouseAdapter() {
                
                public void mouseExited(MouseEvent e) {
                    oprationBTn[index2].setBorder(BorderFactory.createLineBorder(Color.lightGray));
                    oprationBTn[index2].setBackground(Color.lightGray);
                    
                }
                 public void mouseEntered(MouseEvent e) {
                    oprationBTn[index2].setBorder(BorderFactory.createLineBorder(Color.decode("#d6d5d5")));
                    oprationBTn[index2].setBackground(Color.decode("#d6d5d5"));
                  }
                 
            });
            
        }

        JButton equal=oprationBTn[4];
        equal=new JButton("   =  ");
        equal.setBackground(Color.decode("#1c577c"));
        equal.setBorder(BorderFactory.createLineBorder(Color.decode("#1c577c")));
        equal.setFont(new Font("arail",Font.PLAIN,30));
        equal.setForeground(Color.WHITE);
        oprationPanel.add(equal);

        equal.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                secondnumber=Double.parseDouble(tfDisplsy.getText());
                switch (opretion) {
                    case "+":

                    result=firstnumber+secondnumber;
                        
                        break;
                    case "-":

                    result=firstnumber-secondnumber;
                        
                        break;
                    case "*":

                    result=firstnumber*secondnumber;
                        
                        break;
                    case "/":

                    result=firstnumber/secondnumber;
                        
                        break;
                }
                tfDisplsy.setText(result+"");
                taHistory.append(secondnumber+"="+result+"\n");
            }
        });
        JButton equal1=equal;
        equal.addMouseListener(new MouseAdapter() {
            public void mouseExited(MouseEvent e) {
                equal1.setBorder(BorderFactory.createLineBorder(Color.decode("#1c577c")));
                equal1.setBackground(Color.decode("#1c577c"));
                
            }
             public void mouseEntered(MouseEvent e) {
                equal1.setBorder(BorderFactory.createLineBorder(Color.decode("#306f97")));
                equal1.setBackground(Color.decode("#306f97"));
              }
             
        });
    }
    
    public void setNumBtn(){
        for (int i=0; i<btnNum.length ; i++){
            btnNum[i]=new JButton(btnText[i]);
            btnNum[i].setBackground(Color.WHITE);
            btnNum[i].setBorder(BorderFactory.createLineBorder(Color.WHITE));
            btnNum[i].setFont(font);
            numBtnPanel.add(btnNum[i]);    
            
        }
        
        for (int i=3 ; i<btnNum.length-1; i++){
            int index2=i;
            btnNum[i].addMouseListener(new MouseAdapter() {
                
                public void mouseExited(MouseEvent e) {
                    btnNum[index2].setBorder(BorderFactory.createLineBorder(Color.WHITE));
                    btnNum[index2].setBackground(Color.WHITE);
                    
                }
                 public void mouseEntered(MouseEvent e) {
                    btnNum[index2].setBorder(BorderFactory.createLineBorder(Color.decode("#f4f2ed")));
                    btnNum[index2].setBackground(Color.decode("#f4f2ed"));
                  }
                 
            });
            
        }
        for (int i=0 ; i<3; i++){
            int index2=i;
            btnNum[i].addMouseListener(new MouseAdapter() {
                
                public void mouseExited(MouseEvent e) {
                    btnNum[index2].setBorder(BorderFactory.createLineBorder(Color.lightGray));
                    btnNum[index2].setBackground(Color.lightGray);
                    
                }
                 public void mouseEntered(MouseEvent e) {
                    btnNum[index2].setBorder(BorderFactory.createLineBorder(Color.decode("#d6d5d5")));
                    btnNum[index2].setBackground(Color.decode("#d6d5d5"));
                  }
                 
            });
            
        }

        
        for (int i=3 ; i<btnNum.length-1; i++){

            int index=i;
            btnNum[i].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e){
                    double d=Double.parseDouble(tfDisplsy.getText());

                    if (d==0 || firstnumber==d || result==d){
                        tfDisplsy.setText("");
                    }
                    tfDisplsy.setText(tfDisplsy.getText()+btnNum[index].getText());
                }
            });
        }
        for (int i=0 ; i<3; i++){
            
            btnNum[i].setBackground(Color.lightGray);
            btnNum[i].setBorder(BorderFactory.createLineBorder(Color.lightGray));
            btnNum[i].setFont(new Font("arail",Font.ITALIC,17));
            btnNum[i].setForeground(Color.GRAY);
        }

        JButton clearBtn=btnNum[0];
        JButton ereseBtn=btnNum[1];
        JButton powr=btnNum[2];
        JButton MPBtn=btnNum[btnNum.length-1];
        clearBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                if (!tfDisplsy.equals("0")) {
                    taHistory.setText("");
                    tfDisplsy.setText("0");
                    
                }
            }
        });
        ereseBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                
                String s=tfDisplsy.getText();

                if (s.length()==1) {
                    tfDisplsy.setText("0");
                }
                else{
                    s=s.substring(0,s.length()-1);
                    tfDisplsy.setText(s);
                }

            }
        });
        powr.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                String s=tfDisplsy.getText();
               double d=Double.parseDouble(tfDisplsy.getText());
               double re=Math.pow(d, 2);
               tfDisplsy.setText(re+"");
               taHistory.append(s+" Power 2 ="+re+"\n");

            }
        });
         
        MPBtn.addActionListener(new ActionListener() {
            
            public void actionPerformed(ActionEvent e) {
                double d=Double.parseDouble(tfDisplsy.getText());
                d=d*-1;
                tfDisplsy.setText(d+"");
            }
        });

    }

    public void setUpMenuBar(){

        menuBar=new JMenuBar();
        setJMenuBar(menuBar);
        fileMenu=new JMenu("File");
        editMenu=new JMenu("Edit");
        chBox=new JCheckBox("Show History");
        about=new JMenuItem("About");
        exite=new JMenuItem("Exit");
        fileMenu.add(about);
        fileMenu.add(exite);
        editMenu.add(chBox);
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.setBackground(Color.decode("#e6e6e6"));
        menuBar.setBorder(BorderFactory.createLineBorder(Color.decode("#e6e6e6")));
        taHistory=new JTextArea(3,9);
        taHistory.setEditable(false);
        Js=new JScrollPane(taHistory);
        displayPanel.add(Js);
        taHistory.setBackground(Color.decode("#e6e6e6"));
        Js.setBorder(BorderFactory.createLineBorder(Color.decode("#e6e6e6")));
        Js.setVisible(false);
        

        chBox.addItemListener(new ItemListener(){
            public void itemStateChanged(ItemEvent e) {
               if (chBox.isSelected()) {
                  Js.setVisible(true);
                  
               }else{
                Js.setVisible(false);
               }
            
            }
            
        });

        exite.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                System.exit(0);
            }
        });

        about.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                new AboutClass();
            }
        });
    }
    
    public void setMainDisplay(){
        tfDisplsy=new JTextField("0",9);
        tfDisplsy.setBackground(Color.decode("#e6e6e6"));
        tfDisplsy.setFont(new Font("arail",Font.BOLD,30));
        tfDisplsy.setBorder(BorderFactory.createLineBorder(Color.decode("#e6e6e6")));
        tfDisplsy.setHorizontalAlignment(JTextField.RIGHT);
        tfDisplsy.setEditable(false);
        displayPanel.add(tfDisplsy);
    }

    public void setUpMainFrame(){
        setTitle("Jawaduddin 'noori'");
        setSize(300,400);
        setLayout(new BorderLayout());
        setResizable(false);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        displayPanel.setBackground(Color.decode("#e6e6e6"));
        numBtnPanel.setBackground(Color.decode("#e6e6e6"));
        oprationPanel.setBackground(Color.decode("#e6e6e6"));
        
        add(displayPanel,BorderLayout.NORTH);
        add(oprationPanel,BorderLayout.EAST);
        add(numBtnPanel,BorderLayout.CENTER);
        setVisible(true);
    }

// about class;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
    class AboutClass extends JFrame{
        AboutClass(){
         ImageIcon img=new ImageIcon(getClass().getResource("jawad.jpg"));
         JLabel la=new JLabel(img);
         add(la);
          setTitle("About");
          setSize(200,250);
          setResizable(false);
          setLocationRelativeTo(null);
          setVisible(true);
        }
        
  }

    public static void main(String[] args) {
        new Calculator();
    }

    
    
}

