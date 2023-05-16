package qz;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class quiz extends JFrame implements ActionListener {
    
    JLabel label;
    JRadioButton radioButtons[] = new JRadioButton[5]; 
    JButton btnNext,btnResult;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];
    
    quiz (String s){
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for(int i=0; i<5; i++){
            radioButtons[i] = new JRadioButton();
             add(radioButtons[i]);
             bg.add(radioButtons[i]);
        }
        
        btnNext = new JButton("Próximo");
        btnResult = new JButton("Resultado");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30,60,650,20);
        radioButtons[0].setBounds(50,80,450,20);
        radioButtons[1].setBounds(50,110,200,20);
        radioButtons[2].setBounds(50,140,200,20);
        radioButtons[3].setBounds(50,170,200,20);
        btnNext.setBounds(100,240,100,30);
        btnResult.setBounds(270,240,100,30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250,100);
        setVisible(true);
        setSize(600,350);
        
        
    }
    
    void setData(){
    
        radioButtons[4].setSelected(true);
        if(current==0){
            label.setText("Qual a melhor música do Manoel Gomes?");
            radioButtons[0].setText("Ceiça");
            radioButtons[1].setText("Caneta Azul");
            radioButtons[2].setText("Lá ele - feat. Tierry");
            radioButtons[3].setText("Olha se você não me ama");
        }
        if(current==1){
            label.setText("Qual a idade do big querido Manoel?");
            radioButtons[0].setText("10 em ano bissexto.");
            radioButtons[1].setText("62");
            radioButtons[2].setText("Vida eterna");
            radioButtons[3].setText("55");
        }
        if(current==2){
            label.setText("Qual música Manoel homenageou a sua mãezinha querida?");
            radioButtons[0].setText("Parabéns");
            radioButtons[1].setText("Boate azul");
            radioButtons[2].setText("Lá nele 1000x");
            radioButtons[3].setText("Olha se você não me ama");
        }
        if(current==3){
            label.setText("Segundo o própio Manoel, quem manda nos homi?");
            radioButtons[0].setText("Deus");
            radioButtons[1].setText("Rodrigo Faro");
            radioButtons[2].setText("Tiquinho do Botafogo");
            radioButtons[3].setText("É a mulher, eu não me governo não.");
        }
        if(current==4){
            label.setText("Quantas músicas o Manoel Gomes tem?");
            radioButtons[0].setText("2100");
            radioButtons[1].setText("+21.000");
            radioButtons[2].setText("3");
            radioButtons[3].setText("1");
        }
        label.setBounds(30,40,450,20);
        for(int i=0, j=0; i<=90; i+=30, j++){
            radioButtons[j].setBounds(50,80+i,200,20);      
        }
           
}
    
    boolean checkAns(){
        if(current==0){
            return (radioButtons[2].isSelected());
        }
        if(current==1){
            return (radioButtons[2].isSelected());
        }
        if(current==2){
            return (radioButtons[0].isSelected());
        }
        if(current==3){
            return (radioButtons[3].isSelected());
        }
        if(current==4){
            return (radioButtons[1].isSelected());
        }
        
        return false;
    }


    public static void main(String[] args){
        
        new quiz("Quiz bom demaize");
        
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource()==btnNext){
            if(checkAns())
                count = count + 1;
            current++;
            setData();
            if(current==4){
                    btnNext.setEnabled(false);
                    btnResult.setVisible(true);
                    btnResult.setText("Resultado");
            }
        }
        
        if(e.getActionCommand().equals("Resultado")){
            if(checkAns())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this, "Questões corretas foram: " + count);
            System.exit(0);
            }
        }
        
    }
    
