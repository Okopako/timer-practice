import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {

    Font font;
    JLabel secondLabel, actionLabel;
    Timer secondTimer, actionTimer;
    TimerTask secondTask, actionTask;
    int secondCounter, actionCounter;

    public static void main(String[] args) {
        new TimerMain();
    }

    public TimerMain () {

        secondCounter = 0;
        actionCounter = 0;

        createUI();
        createFont();
        secondTimer();
        actionTimer();
        startSecondTimer();
        startActionTimer();
    }

    public void createFont () { //Creates font and specifies size
         font = new Font("Cambria", Font.BOLD, 16);

    }

    public void createUI() {

        JFrame window = new JFrame();   //Creates window
        window.setSize(400, 150);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);

        JPanel counterPanel = new JPanel(); //Creates panel for second counter and action counter
        counterPanel.setBounds(100, 25, 200, 50);
        counterPanel.setBackground(Color.gray);
        counterPanel.setLayout(new GridLayout(2,1));
        window.add(counterPanel);

        secondLabel = new JLabel(secondCounter + " Seconds");   //creates second counter label
        secondLabel.setForeground(Color.white);
        secondLabel.setFont(font);
        secondLabel.setHorizontalAlignment(JLabel.CENTER);
        counterPanel.add(secondLabel);

        actionLabel = new JLabel(actionCounter + " Actions");    //creates action counter label
        actionLabel.setForeground(Color.white);
        actionLabel.setFont(font);
        actionLabel.setHorizontalAlignment(JLabel.CENTER);
        counterPanel.add(actionLabel);

        window.setVisible(true);    //Opens window when running program
    }

    public void secondTimer() { //creates timer method for second label
        secondTimer = new Timer();
        secondTask = new TimerTask() {
            @Override
            public void run() {
                secondCounter++; //adds value to counter every period (1000ms)
                secondLabel.setText(secondCounter + " Seconds"); //updates second counter
            }
        };
    }

    public void startSecondTimer() {    //starts second label timer at specified delay and period
        secondTimer.scheduleAtFixedRate(secondTask,1000,1000);
    }

    public void actionTimer() { //creates timer method for action label
        actionTimer = new Timer();
        actionTask = new TimerTask() {
            @Override
            public void run() {
                actionCounter+=100; //adds value to counter every period (1ms)
                actionLabel.setText(actionCounter + " Actions");
            }
        };
    }

    public void startActionTimer() {    //starts action label timer at specified delay and period
        actionTimer.scheduleAtFixedRate(actionTask,0 ,1);
    }
}

