import com.company.myServer;
import com.company.cClass;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Interface implements Runnable{
    private JButton startServerButton;
    private JButton pauseServerButton;
    private JButton stopServerButton;
    private JPanel panelMain;
    private JTextField textField1;
    myServer srv = new myServer();
    int restart=0;
    int curentPort=0,oldPort=0;

    public Interface() throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {

        UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());


        startServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                curentPort = Integer.parseInt(textField1.getText());
                if (curentPort==oldPort && restart==1){
                    srv.setStateServer(1);
                    JOptionPane.showMessageDialog(null, "Server-ul a repornit cu succes ! URL:http://localhost:"+curentPort);
                }
                if ((curentPort!=oldPort && restart==1) || restart==0){
                    startSRV();
                    restart=0;
                }
            }
        });

        pauseServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Server-ul este in modul de metenanta!");
                srv.setStateServer(2);
                startServerButton.setText("Restart");
                startServerButton.setEnabled(true);
                restart=1;
            }
        });

        stopServerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Server-ul a fost oprit!");
                srv.setStateServer(3);
                startServerButton.setEnabled(true);
                restart=1;
            }
        });
    }


    public static void main(String[] args) throws ClassNotFoundException, UnsupportedLookAndFeelException, InstantiationException, IllegalAccessException {
        JFrame frame=new JFrame("App");

        frame.setContentPane(new Interface().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public void startSRV(){
        if (srv.setPort(curentPort) && srv.acceptServerPort()) {
            JOptionPane.showMessageDialog(null, "Server-ul a pornit cu succes ! URL:http://localhost:"+curentPort);
            startServerButton.setEnabled(false);
            oldPort=curentPort;
            srv.setStateServer(1);
            Thread interfaceThread = null;
            try {
                interfaceThread = new Thread(new Interface());
            } catch (ClassNotFoundException classNotFoundException) {
                classNotFoundException.printStackTrace();
            } catch (UnsupportedLookAndFeelException unsupportedLookAndFeelException) {
                unsupportedLookAndFeelException.printStackTrace();
            } catch (InstantiationException instantiationException) {
                instantiationException.printStackTrace();
            } catch (IllegalAccessException illegalAccessException) {
                illegalAccessException.printStackTrace();
            }
            interfaceThread.start();
        } else {
            JOptionPane.showMessageDialog(null, "Portul este deja deschis!");

        }
    }

    @Override
    public void run() {
        srv.listenForClients();
    }


}
