import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Main {

  private JPanel mainPanel;
  private JButton roomButton;
  private JButton concertHallButton;

  private Map<String, String> settings;

  public Main() {
    settings = new HashMap<>();
    populateWithDefaultSettings(settings);
    loadUserSettings(
        System.getProperty("user.home") + System.getProperty("file.separator") + ".indoor-map",
        settings);

    roomButton.addActionListener(e -> {
      // do

    });
    concertHallButton.addActionListener(e -> {

    });
  }

  private void loadUserSettings(String settingsFilePath, Map<String, String> settings) {
    BufferedReader reader = null;
    try {
      reader = new BufferedReader(new FileReader(settingsFilePath));

      String line;
      while ((line = reader.readLine()) != null) {
        String[] parts = line.split("=", 2);
        if (parts.length >= 2) {
          String key = parts[0];
          String value = parts[1];
          settings.put(key, value);
        }
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (reader != null) {
        try {
          reader.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }

  private void populateWithDefaultSettings(Map<String, String> settings) {
    settings.put("x", "0");
    settings.put("y", "0");
    settings.put("width", "720");
    settings.put("height", "480");
    settings.put("db_host", "localhost");
    settings.put("db_port", "3306");
    settings.put("db_user", "indoor-db-user");
    settings.put("db_password", "");
  }

  public static void main(String[] args) {
    JFrame frame = new JFrame("Main");
    frame.setContentPane(new Main().mainPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //frame.pack();
    frame.setMinimumSize(new Dimension(720, 480));
    frame.setVisible(true);


  }
}
