package ru.mirea.pracrick4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

class Match extends JFrame{
    JPanel[] windowPanel = new JPanel[9];
    private int button1N = 0;
    private int button2N = 0;
    private JLabel resultGame;
    private JLabel lastScorer;
    private JLabel winnerTheGame;
    private JLabel lbl;

    Match() {
        super("Football Match");
        setLayout(new GridLayout(3,3));

        for(int i = 0 ; i < windowPanel.length ; i++) {
            windowPanel[i] = new JPanel();
            add(windowPanel[i]);
        }

        winnerTheGame = new JLabel("Winner: DRAW",JLabel.CENTER );
        resultGame = new JLabel("Result: 0 X 0",JLabel.CENTER);
        resultGame.setSize(350,200);
        lastScorer = new JLabel("Last Scorer: N/A",JLabel.CENTER);
        lbl = new JLabel("");



        ButtonListener nl = new ButtonListener();
        JButton button1 = new JButton("AC Milan");
        button1.addActionListener(nl);
        JButton button2 = new JButton("Real Madrid");
        button2.addActionListener(nl);



        windowPanel[3].setLayout(new BorderLayout());
        windowPanel[3].add(button1, BorderLayout.CENTER);
        windowPanel[5].setLayout(new BorderLayout());
        windowPanel[5].add(button2, BorderLayout.CENTER);
        windowPanel[1].setLayout(new BorderLayout());
        windowPanel[1].add(winnerTheGame);
        windowPanel[4].setLayout(new BorderLayout());
        windowPanel[4].add(resultGame);
        windowPanel[8].setLayout(new BorderLayout());
        windowPanel[8].add(lastScorer);
        windowPanel[0].setLayout(new BorderLayout());
        windowPanel[0].add(lbl, BorderLayout.NORTH);
        setSize(800,500);

        this.addMouseListener(new MouseListener()
        {
            public void mouseExited(MouseEvent a){}
            public void mouseClicked(MouseEvent a)
            {lbl.setText("X="+a.getX()+" Y="+a.getY());}
            public void mouseEntered(MouseEvent a) {}
            public void mouseReleased(MouseEvent a) {}
            public void mousePressed(MouseEvent a) {}
        });


    }


    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            if(e.getActionCommand().equals("AC Milan")){
                button1N += 1;
            }
            else {button2N += 1;}
            resultGame.setText("Result: " + button1N + " X " + button2N);
            lastScorer.setText("Last Scorer: " + e.getActionCommand());
            if(button1N == button2N){
                winnerTheGame.setText("DRAW");
            }
            else if(button1N > button2N){
                winnerTheGame.setText("Winner: AC Milan");
            }
            else{
                winnerTheGame.setText("Winner: Real Madrid");
            }
        }
    }


    public static void main(String[] args) {
        new Match().setVisible(true);
    }
}
