import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by xy on 2017/5/2/002.
 */
public class SwingMain {
    private JTextField textField1;
    private  JPanel panel1;
    private  JButton button;
    private JProgressBar progressBar1;
    private JFrame frame;

    public static void main(String[] args) {

        JFrame frame = new JFrame("压缩小工具");
        frame.setContentPane(new SwingMain().panel1);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);
    }

    SwingMain(){

        button.addActionListener(new ButtonListen());
        progressBar1.setOrientation(JProgressBar.HORIZONTAL);
        textField1.setSize(200,100);
        progressBar1.setSize(200,100);
        progressBar1.setMaximum(0);
        progressBar1.setMaximum(100);
        progressBar1.setStringPainted(true);
    }

    class ButtonListen implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            new Thread(new Runnable() {

                @Override
                public void run() {
                    if(!ImageUtil.comparess(textField1.getText(),progressBar1)){


                        JOptionPane.showMessageDialog(frame,"该路径不是一个文件夹");
                    };
                }
            }).start();

        }
    }

}
