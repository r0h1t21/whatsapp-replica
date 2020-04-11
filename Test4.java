package whatsapp;

import java.awt.Color;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
//import java.text.DateFormat;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.border.LineBorder;
import java.awt.SystemColor;
import javax.swing.JList;

import java.net.*;

import java.awt.*; 
import javax.swing.*; 
import java.awt.event.*; 
import java.net.*; 


public class Test4 {

	private JFrame frame;
	private JTextField password;
	private JTextField phone_no;
	private JTextField username;
	private JTextField Password_1;
	private JTextField Phone_no_1;
	private JLabel Username;
	private JTextField textField;
	private JLabel rec;


	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test4 window = new Test4();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Test4() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(new Rectangle(0, 0, 1080, 1920));
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
	

		
		JPanel Whatsapp = new JPanel();
		Whatsapp.setBorder(null);
		Whatsapp.setBackground(new Color(0, 102, 51));
		Whatsapp.setBounds(0, 0, 1062, 1055);
		frame.getContentPane().add(Whatsapp);
		Whatsapp.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("WhatsApp");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 30));
		lblNewLabel.setBounds(11, 1, 198, 44);
		Whatsapp.add(lblNewLabel);
		
		JButton Search = new JButton("");
		Search.setForeground(new Color(0, 102, 51));
		Search.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\whatsapp\\src\\whatsapp\\search-13-32.png"));
		Search.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JTextField t=new JTextField();
				t.setBounds(290, 15, 610, 32);
				t.setBackground(Color.white);
			    Whatsapp.add(t);
			}
		});
		Search.setBorder(null);
		Search.setBackground(new Color(0, 102, 51));
		Search.setBounds(919, 15, 48, 32);
		Whatsapp.add(Search);
		
		JButton Camera = new JButton("");
		Camera.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try { 
					  
		            // create a URI 
		            URI u = new URI("https://webcamera.io/"); 
		  
		            Desktop d = Desktop.getDesktop(); 
		            d.browse(u); 
		        } 
		        catch (Exception evt) { 
		        } 
			}
		});
		Camera.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\whatsapp\\src\\whatsapp\\camera-32.png"));
		Camera.setBorder(null);
		Camera.setBackground(new Color(0, 102, 51));
		Camera.setForeground(new Color(0, 102, 51));
		Camera.setBounds(11, 90, 48, 32);
		Whatsapp.add(Camera);
		
		JPanel Chats = new JPanel();
		JPanel Status = new JPanel();
		Status.setBackground(SystemColor.inactiveCaption);
		JPanel Calls = new JPanel();
		Calls.setBackground(SystemColor.inactiveCaption);
		JPanel Chat = new JPanel();
		Chat.setBackground(SystemColor.inactiveCaption);
		
		rec = new JLabel("");
		rec.setBorder(null);
		rec.setFont(new Font("Microsoft JhengHei UI", Font.BOLD, 20));
		
		JButton btnNewButton_2 = new JButton("CHATS\r\n");
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setBackground(new Color(0, 102, 51));
		btnNewButton_2.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton_2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent a) {
					
					Chats.setBackground(Color.WHITE);
					
					Status.setVisible(false);
					Calls.setVisible(false);

					try {
						 Class.forName("com.mysql.jdbc.Driver");
						 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Whatsapp?autoReconnect=true&useSSL=false","root","Manideep$21");
						 Statement st=con.createStatement();
						 Statement st1=con.createStatement();
						 ResultSet rs=st.executeQuery("select * from user where phno!="+phone_no.getText()+"");
						 ResultSet rs1=st1.executeQuery("select count(*) from user");
						 rs1.next(); 
						 Chats.removeAll();
						 int count=Integer.parseInt(rs1.getString(1));
						// System.out.println(phone_no.getText());
						 JButton [] b=new JButton[count];
					     for(int j=0;j<count;j++) {
					       if(!rs.next()) {break;}
					       String ss=rs.getString(2);
					       b[j]=new JButton(ss);
					       b[j].setText(ss);
					       b[j].setBackground(Color.white);
					       b[j].setFont(new Font("SansSerif", Font.BOLD, 20));
					       b[j].addActionListener(new ActionListener() {
					    	   public void actionPerformed(ActionEvent a) {
					    		   rec.setText(((JButton)a.getSource()).getText());
					    		   Whatsapp.setVisible(false);
					    		   Chat.setVisible(true);
						    	   
					    	   }
					       });
						   //b[j].setBounds(0, 138*(j+1), 1062, 917/count);
						   Chats.add(b[j]);
					     }
					    
					}
					catch(Exception i) {
						i.printStackTrace();
					}
						/*try { if(ss.equals(password.getText())) {
								Whatsapp.setVisible(true);
								Sign_up.setVisible(false);
								Welcome.setVisible(false);
								Login.setVisible(false);
								Statement st1=con.createStatement();
								DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
								Date o=new Date();
								String s=df.format(o);
								st1.executeUpdate("insert into login values("+phone_no.getText()+",'"+s+"')");
						      }
						}*/
				
					Chats.setVisible(true);
					
					
					}
			});
		
	
	        Chats.setBounds(0, 138, 1062, 917);
	        Whatsapp.add(Chats);
	        Chats.setFont(new Font("SansSerif", Font.BOLD, 20));
	        Chats.setBorder(null);
	        Chats.setLayout(new GridLayout(15, 1, 0, 0));
		btnNewButton_2.setBounds(132, 80, 176, 44);
		Whatsapp.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("STATUS");
		btnNewButton_3.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton_3.setBorder(null);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setBackground(new Color(0, 102, 51));
		
		
		btnNewButton_3.setBounds(484, 80, 176, 44);
		Whatsapp.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("CALLS");
		btnNewButton_4.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton_4.setBorder(null);
		btnNewButton_4.setBackground(new Color(0, 102, 51));
		btnNewButton_4.setForeground(Color.WHITE);
		
		btnNewButton_4.setBounds(836, 80, 176, 44);
		Whatsapp.add(btnNewButton_4);
		
		Status.setFont(new Font("SansSerif", Font.BOLD, 20));
		Status.setBorder(null);
		
		
		Calls.setFont(new Font("SansSerif", Font.BOLD, 20));
		Calls.setBorder(null);
       
        Status.setBounds(0, 138, 1062, 917);
        Whatsapp.add(Status);
        Status.setLayout(new GridLayout(15, 1, 0, 0));	
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent b) {
			Status.setBackground(Color.WHITE);
			Status.setVisible(true);
			Calls.setVisible(false);
			Chats.setVisible(false);
				
			}
		});
		
	
		Calls.setBounds(0, 138, 1062, 917);
		Whatsapp.add(Calls);
		Calls.setLayout(new GridLayout(15, 1, 0, 0));
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\whatsapp\\src\\whatsapp\\list.png"));
		lblNewLabel_4.setBackground(new Color(0, 102, 51));
		lblNewLabel_4.setBounds(1015, 15, 50, 35);
		Whatsapp.add(lblNewLabel_4);
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent c) {
				Calls.setBackground(Color.WHITE);
				Calls.setVisible(true);
				Chats.setVisible(false);
				Status.setVisible(false);
				
			}
		});
		
		JPanel Welcome = new JPanel();
		JPanel Sign_up = new JPanel();
		JPanel Login = new JPanel();
		
		Welcome.setBounds(0, 0, 1062, 1055);
		frame.getContentPane().add(Welcome);
		Welcome.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setFont(new Font("SansSerif", Font.BOLD, 15));
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Welcome.setVisible(false);
				Login.setVisible(true);
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\whatsapp\\src\\whatsapp\\whatsapp.jpg"));
		btnNewButton_6.setBounds(0, 0, 1062, 1055);
		Welcome.add(btnNewButton_6);
		
		
		
		Login.setForeground(Color.WHITE);
		Login.setBackground(new Color(30, 190, 164));
		Login.setBounds(0, 0, 1062, 1055);
		frame.getContentPane().add(Login);
		Login.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username :");
		lblUsername.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblUsername.setHorizontalAlignment(SwingConstants.CENTER);
		lblUsername.setBounds(360, 500, 150, 33);
		Login.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password :");
		lblPassword.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(360, 627, 150, 27);
		Login.add(lblPassword);
		
		JLabel lblPhoneNo = new JLabel("Phone no :");
		lblPhoneNo.setFont(new Font("SansSerif", Font.BOLD, 20));
		lblPhoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblPhoneNo.setBounds(360, 754, 150, 27);
		Login.add(lblPhoneNo);
		
		JLabel lblNewUserRegister = new JLabel("New User? Register:");
		lblNewUserRegister.setBackground(Color.WHITE);
		lblNewUserRegister.setForeground(Color.BLACK);
		lblNewUserRegister.setFont(new Font("SansSerif", Font.BOLD, 17));
		lblNewUserRegister.setBounds(410, 948, 200, 40);
		Login.add(lblNewUserRegister);
		password = new JTextField();
		password.setFont(new Font("SansSerif", Font.BOLD, 20));
		password.setBounds(570, 630, 140, 25);
		Login.add(password);
		password.setColumns(10);
		
		phone_no = new JTextField();
		phone_no.setFont(new Font("SansSerif", Font.BOLD, 20));
		phone_no.setBounds(570, 757, 140, 25);
		Login.add(phone_no);
		phone_no.setColumns(10);
		
		username = new JTextField();
		username.setFont(new Font("SansSerif", Font.BOLD, 20));
		username.setBounds(570, 503, 140, 25);
		Login.add(username);
		username.setColumns(10);
		
		JLabel Error1 = new JLabel("");
		Error1.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		Error1.setForeground(Color.RED);
		Error1.setBounds(730, 503, 250, 25);
		Login.add(Error1);
		
		JButton btnLogin = new JButton("Login");
		btnLogin.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnLogin.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnLogin.setBounds(475, 900, 130, 30);
		btnLogin.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Whatsapp?autoReconnect=true&useSSL=false","root","Manideep$21");
					 Statement st=con.createStatement();
					 ResultSet rs=st.executeQuery("select * from user where phno='"+phone_no.getText()+"'");
					 rs.next();
					 String ss=rs.getString(3);
					 String ss1=rs.getString(1);
					// username.setText(ss);
					try { if(ss.equals(password.getText()) && ss1.equals(username.getText())) {
							Whatsapp.setVisible(true);
							//Chats.setVisible(true);
							Sign_up.setVisible(false);
							Welcome.setVisible(false);
							Login.setVisible(false);
							Statement st1=con.createStatement();
							DateFormat df=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
							Date o=new Date();
							String s=df.format(o);
							st1.executeUpdate("insert into login values("+phone_no.getText()+",'"+s+"')");
					      }
					else {
						Error1.setText("* Invalid Username/Password");
					}
					}
					catch(Exception e1) {
						username.setText("* user doesn't exist");}
				 }
				catch(Exception e) {e.printStackTrace();}
			}
		
		});
		Login.add(btnLogin);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\whatsapp\\src\\whatsapp\\login.png"));
		lblNewLabel_1.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel_1.setBounds(0, 0, 1062, 500);
		Login.add(lblNewLabel_1);
		
		
		Sign_up.setBackground(new Color(30, 190, 164));
		JButton btnNewButton_7 = new JButton("Register");
		btnNewButton_7.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Sign_up.setVisible(true);
				Login.setVisible(false);
				
				
			}
		});
		btnNewButton_7.setFont(new Font("SansSerif", Font.BOLD, 17));
		btnNewButton_7.setBounds(600, 958, 150, 25);
		Login.add(btnNewButton_7);
		
		
		Sign_up.setBounds(0, 0, 1062, 1055);
		frame.getContentPane().add(Sign_up);
		Sign_up.setLayout(null);
		
		Username = new JLabel("Username :");
		Username.setFont(new Font("SansSerif", Font.BOLD, 20));
		Username.setBounds(370, 500, 150, 33);
		Sign_up.add(Username);
		
		JLabel Password = new JLabel("Password :");
		Password.setFont(new Font("SansSerif", Font.BOLD, 20));
		Password.setBounds(370, 627, 150, 27);
		Sign_up.add(Password);
		
		JLabel Phone_no = new JLabel("Phone no :");
		Phone_no.setFont(new Font("SansSerif", Font.BOLD, 20));
		Phone_no.setBounds(370, 754, 150, 27);
		Sign_up.add(Phone_no);
		
		JTextField Username_1 = new JTextField();
		Username_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		Username_1.setBounds(570, 503, 140, 25);
		Sign_up.add(Username_1);
		Username_1.setColumns(10);
		
		Password_1 = new JTextField();
		Password_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		Password_1.setBounds(570, 630, 140, 25);
		Sign_up.add(Password_1);
		Password_1.setColumns(10);
		
		Phone_no_1 = new JTextField();
		Phone_no_1.setFont(new Font("SansSerif", Font.BOLD, 20));
		Phone_no_1.setBounds(570, 757, 140, 25);
		Sign_up.add(Phone_no_1);
		Phone_no_1.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setBounds(720, 500, 250, 30);
		Sign_up.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.RED);
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.BOLD, 15));
		
		JButton btnNewButton_8 = new JButton("Register");
		btnNewButton_8.setBorder(new LineBorder(new Color(0, 0, 0), 2, true));
		btnNewButton_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Whatsapp?autoReconnect=true&useSSL=false","root","Manideep$21");
					 Statement st=con.createStatement();
					 st.executeUpdate("insert into user values('"+Username_1.getText()+"', "+Phone_no_1.getText()+",'"+Password_1.getText()+"')");
					 st.executeUpdate("commit");
					 //st.close();con.close();
				 }
				catch(Exception a) {lblNewLabel_3.setText("* Invalid Username/Phone No.");}
				
				Login.setVisible(true);
				Sign_up.setVisible(false);
			}
			
		});
		btnNewButton_8.setFont(new Font("SansSerif", Font.BOLD, 20));
		btnNewButton_8.setBounds(475, 900, 130, 30);
		Sign_up.add(btnNewButton_8);
		
		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\whatsapp\\src\\whatsapp\\login.png"));
		lblNewLabel_2.setFont(new Font("SansSerif", Font.BOLD, 30));
		lblNewLabel_2.setBounds(0, 0, 1062, 500);
		Sign_up.add(lblNewLabel_2);
		
		
		Chat.setFont(new Font("SansSerif", Font.BOLD, 20));
		Chat.setBounds(0, 0, 1062, 1193);
		frame.getContentPane().add(Chat);
		Chat.setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setFont(new Font("Sitka Heading", Font.ITALIC, 25));
		textArea.setBounds(0, 50, 1062, 895);
		Chat.add(textArea);
		
		textField = new JTextField();
		textField.setFont(new Font("Sitka Text", Font.ITALIC, 20));
		textField.setBounds(0, 945, 1014, 48);
		Chat.add(textField);
		textField.setColumns(10);
		
		
		
		JButton send = new JButton("");
		send.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\whatsapp\\src\\whatsapp\\icons8-email-send-48.png"));
		send.setBackground(SystemColor.inactiveCaption);
		send.setBorder(null);
		send.setFont(new Font("SansSerif", Font.BOLD, 15));
		send.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/Whatsapp?autoReconnect=true&useSSL=false","root","Manideep$21");
					 Statement stt=conn.createStatement();
					 
					 stt.executeUpdate("insert into chats(sender,receiver,chat) values ('"+phone_no.getText()+"','"+rec.getText()+"','"+textField.getText()+"')");
					 stt.executeUpdate("commit");
					 textField.setText("");
       		
					 
					 
					 
					 
					 
					/* 
					 
					 Statement stt1=conn.createStatement();
					 ResultSet rs=stt1.executeQuery("select * from chats where sender='"+phone_no.getText()+"' and receiver='"+rlabel.getText()+"'");
					// ResultSet rs1=stt1.executeQuery("select count(*) from chats where sender='"+phone_no.getText()+"' and receiver='"+rlabel.getText()+"' group by sender");
					// rs1.next();
					// String ct=rs1.getString(1);
					 panel.removeAll();
					 int count=Integer.parseInt("2");
					// System.out.println(phone_no.getText());
					 JButton [] b=new JButton[count];
				     for(int j=0;j<count;j++) {
				       if(!rs.next()) {break;}
				       String ss=rs.getString(3);
				       b[j]=new JButton(ss);
				       b[j].setText(ss);
				    
					   //b[j].setBounds(0, 138*(j+1), 1062, 917/count);
				       panel_1.add(b[j]);
				} }
       		
       		*/
       		
       		}
       		catch (Exception f) {
       			f.printStackTrace();
       			
       		}
       		
				
			}
		});
		send.setBounds(1014, 945, 48, 48);
		Chat.add(send);
		
		JButton back = new JButton("");
		back.setBackground(SystemColor.inactiveCaption);
		back.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\whatsapp\\src\\whatsapp\\Go-back-icon.png"));
		back.setBorder(null);
		back.setFont(new Font("SansSerif", Font.BOLD, 15));
		back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Chat.setVisible(false);
				Whatsapp.setVisible(true);
			}
		});
		back.setBounds(0, 0, 50, 50);
		Chat.add(back);
		int k=0;
		
		JButton refresh = new JButton("");
		refresh.setIcon(new ImageIcon("C:\\Users\\user\\eclipse-workspace\\whatsapp\\src\\whatsapp\\icons8-refresh-48.png"));
		refresh.setBackground(SystemColor.inactiveCaption);
		refresh.setBorder(null);
		refresh.setFont(new Font("SansSerif", Font.BOLD, 15));
		refresh.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					 Class.forName("com.mysql.jdbc.Driver");
					 Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/Whatsapp?autoReconnect=true&useSSL=false","root","Manideep$21");
					 Statement sttt=con.createStatement();
					 Statement s=con.createStatement();
					 ResultSet rs4=sttt.executeQuery("select chat from chats where sender='"+phone_no.getText()+"' and receiver='"+rec.getText()+"' order by  status asc");
					 ResultSet rs5=s.executeQuery("select chat from chats where sender='"+rec.getText()+"' and receiver='"+phone_no.getText()+"' order by status asc");
					 //rs4.next();
					 //rs5.next();
					 textArea.setText("");
					/* while(k<20) {
						 if(k%2==0) { textArea.append("	"+rs4.getString(1)+'\n');rs4.next();}
						 else { textArea.append("                                                                                                               	"+rs5.getString(1)+'\n');rs5.next();}
					 }*/
					 while(rs4.next()) {
						 textArea.append("	"+rs4.getString(1)+'\n');
						 //textArea.append("                              																																									"+rs5.getString(1)+'\n');
					 }
					 
					 while(rs5.next()) {
						// textArea.append(rs4.getString(1)+'\n');
						 textArea.append("                                                                                                               	"+rs5.getString(1)+'\n');
					 } 
			    }
				
				catch(Exception h) { }
		}});
		refresh.setBounds(1012, 0, 50, 50);
		Chat.add(refresh);
		

		rec.setBounds(431, 0, 200, 40);
		Chat.add(rec);
		
		Whatsapp.setVisible(false);
		Welcome.setVisible(true);
		Sign_up.setVisible(false);
		Login.setVisible(false);
		Chat.setVisible(false);
	}
}
	
	


