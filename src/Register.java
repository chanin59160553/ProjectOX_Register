import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class Register {
    private JTextField UsernameTxt;
    private JTextField PasswordTxt;
    private JTextField RePasswordTxt;
    private JTextField EmailTxt;
    private JButton RegisterButton;
    private JButton clearButton;
    private JPanel Registerpanel;
    private JTextField Username;
    private JPasswordField passwordField1;
    private JPasswordField RepassField;
    private JPasswordField PepasswordField2;
    private JPasswordField PasswordField;
    private JPasswordField RePasswordField;


    public Register() {
        RegisterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                PreparedStatement pst;
                if( new String(PasswordField.getPassword()).equals( new String(RepassField.getPassword()))){


                    try{
                        String serverName = "sql12.freemysqlhosting.net";
                        String mydatabase = "sql12255832";
                        String url = "jdbc:mysql://" + serverName + "/" + mydatabase;
                        String username = "sql12255832";
                        String password = "VqusRaY3qH";
                        Connection connection = DriverManager.getConnection(url, username, password);
                        connection.createStatement();

                        String sql ="Insert into User(User_Name, User_Email, User_Password) values (?,?,?)";

                        pst=connection.prepareStatement(sql);
                        pst.setString(1, UsernameTxt.getText());
                        pst.setString(2, EmailTxt.getText());
                        pst.setString(3,  new String(PasswordField.getPassword()));
                        pst.execute();


                        JOptionPane.showMessageDialog(null, "ลงทะเบียนเสร็จสิ้น");




                    }

                    catch(Exception String) {
                        JOptionPane.showMessageDialog(null, e);

                    }


                }
                else{
                    JOptionPane.showMessageDialog(null, "รหัสผ่านไม่ตรงกัน");

                }
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UsernameTxt.setText("");
                PasswordField.setText("");
                RepassField.setText("");
                EmailTxt.setText("");
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        Register register = new Register();
        frame.setContentPane(register.Registerpanel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setMinimumSize(new Dimension(500,500));
        frame.setVisible(true);
    }
}
