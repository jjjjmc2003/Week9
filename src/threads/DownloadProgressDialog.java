package threads;
import javax.swing.*;
import java.awt.*;


public class DownloadProgressDialog extends JDialog {

    private JLabel messageLabel;

    public DownloadProgressDialog() {
        setTitle("Downloading in Progress");
        setSize(600, 650);
        setLayout(new BorderLayout());
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);

        messageLabel = new JLabel("Please wait while the images are being downloaded...");
        messageLabel.setHorizontalAlignment(SwingConstants.CENTER);
        add(messageLabel, BorderLayout.NORTH);
        pack();
        setVisible(true);
    }

    public static  void  main (String [] args) {
        DownloadProgressDialog p = new DownloadProgressDialog();
        p.setVisible(true);
    }
}