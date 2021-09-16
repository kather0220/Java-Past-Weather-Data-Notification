package FinalExamProject;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class DateSet extends JFrame{
	
	JComboBox<String> yearBox = new JComboBox<String>();{	// �⵵�� �����ϴ� JComboBox�� �ݺ����� �̿��Ͽ� �⵵�� �߰�
		for(int i=1;i<=19;i++) {
			if(i<=9)
				yearBox.addItem("200"+Integer.toString(i));
			else
				yearBox.addItem("20"+Integer.toString(i));
		}
	}
	
	JComboBox<String> monthBox = new JComboBox<String>();{	// ���� �����ϴ� JComboBox�� �ݺ����� �̿��Ͽ� ���� �߰�
		for(int i=1;i<=12;i++) {
			if(i<=9)
				monthBox.addItem("0"+Integer.toString(i));
			else
				monthBox.addItem(Integer.toString(i));
		}
	}
	JComboBox<String> dateBox = new JComboBox<String>();{	// ���� �����ϴ� JComboBox�� �ݺ����� �̿��Ͽ� ���� �߰�
	for(int i=1; i<=31; i++) {
		
		if(i<=9)
			dateBox.addItem("0"+Integer.toString(i));
		else
			dateBox.addItem(Integer.toString(i));
		}	
	}
	
	
	

	String selectedYear="2001";		// �⵵�� ��, ���� �����ϴ� ������ �����ϰ� �ʱⰪ�� ��������
	String selectedMonth="01";
	String selectedDate="01";
	
	
	public DateSet() throws IOException, InterruptedException {
		setTitle("������ ���� ������");
		
		final JPanel dateSelectMenu= new JPanel();	// dataSelectMenu : ó�� ȭ�� ( final�� ������ ���� �ٸ� �̺�Ʈ �����ʿ��� ������ �� �ֵ��� �ϱ� ���� )
		dateSelectMenu.setLayout(new BorderLayout());	
		dateSelectMenu.setBackground(Color.getHSBColor(20, 20, 20));	// ��ġ�� ���� �Է��Ͽ� ������ ������ ������
		
		Font f = new Font("",Font.PLAIN,20);	// ��Ʈ ��ü
		
		
		JLabel welcomeText = new JLabel("���� ������ �˸����Դϴ�.");
		JLabel chooseDate = new JLabel("��¥�� �����ϼ���!");
		JButton btn1 = new JButton("���� �Ϸ�");
		
		welcomeText.setFont(f);
		chooseDate.setFont(f);
		
		btn1.setBackground(Color.white);	// ��ư�� �޺� �ڽ� ������ ��������
		yearBox.setBackground(Color.white);
		monthBox.setBackground(Color.white);
		dateBox.setBackground(Color.white);
		
		
		yearBox.setBounds(160, 100, 80, 40);	// �� ���۳�Ʈ�� ��ġ�� ��������
		monthBox.setBounds(260, 100, 80, 40);
		dateBox.setBounds(360,100,80,40);
		welcomeText.setBounds(190, 10, 300, 20);
		chooseDate.setBounds(220, 40, 300, 20);
		btn1.setBounds(260, 300, 100, 40);
		
		dateSelectMenu.setLayout(null);	// ���۳�Ʈ�� ��ġ�� �����Ӱ� �߰��ϱ� ���� ���� ���̾ƿ��� ������
		dateSelectMenu.add(yearBox);
		dateSelectMenu.add(monthBox);
		dateSelectMenu.add(dateBox);
		dateSelectMenu.add(chooseDate);
		dateSelectMenu.add(welcomeText);
		dateSelectMenu.add(btn1);
		add(dateSelectMenu);	// �г��� �߰���
		

		
		yearBox.addActionListener(new ActionListener() {	// �⵵�� �����ϴ� �޺��ڽ��� �̺�Ʈ �����ʸ� �־���

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> yearInfo = (JComboBox<String>)e.getSource();
				selectedYear = yearInfo.getSelectedItem().toString();	// ����ڰ� ������ �⵵ �����͸� �����ͼ� ������ ��������
				
			}
			
		});
		
		monthBox.addActionListener(new ActionListener() {	// ���� �����ϴ� �޺��ڽ��� �̺�Ʈ �����ʸ� �־���

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> monthInfo = (JComboBox<String>)e.getSource();
				selectedMonth = monthInfo.getSelectedItem().toString();		// ����ڰ� ������ �� �����͸� �����ͼ� ������ ��������
				
			}
			
		});
		
		dateBox.addActionListener(new ActionListener() {	// ���� �����ϴ� �޺��ڽ��� �̺�Ʈ �����ʸ� �־���

			@Override
			public void actionPerformed(ActionEvent e) {
				JComboBox<String> dateInfo = (JComboBox<String>)e.getSource();
				selectedDate = dateInfo.getSelectedItem().toString();	// ����ڰ� ������ �� �����͸� �����ͼ� ������ ��������

				
			}
			
		});
		
		class MyGUI implements ActionListener{		// ���� �Ϸ� ��ư�� ���� �̺�Ʈ �����ʸ� ���� Ŭ������ ����� ��
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				FileReader fr = null;	// ������ �о���� ���� ��ü ����
				try {
					fr = new FileReader("weather_data.csv");
				} catch (FileNotFoundException e1) {	// ������ �������� �ʾ��� ���� ���� ó��
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				String line = null;
				
				String average, lowest, highest;
				average = lowest = highest = null;
				
				String searchDate = (selectedYear+"-"+selectedMonth+"-"+selectedDate);	
				// searchDate ������ �̷� �������� ���� ���� �о�� ������ �����Ϳ� �������� �񱳸� �ϱ� ���� ����
				
				System.out.println(searchDate);
				
				BufferedReader br = new BufferedReader(fr);		// ������ �� �پ� �б� ���� ��ü
				int count=0;
				try {
					while((line = br.readLine())!=null) {	// ������ ������ ����
						String arr[] = line.split(",");
						for(String s:arr) {	// �����͸� ���������� ��� ������
							if(searchDate.equals(arr[0])) {		// ����ڰ� �Է��� ��¥�� �������� ��¥�� ��ġ�� ��
								
								if(count ==1) {	
									average = s;
									System.out.println("���: "+average);
								}
								if(count == 2) {
									lowest = s;
									System.out.println("���� : "+lowest);
								}
								if(count == 3) {
									highest = s;
									System.out.println("�ְ�: "+highest);
								}
								
								 count++;
								 // count�� �����ϴ� ������ ��ȯ���� �� ������ ���, ����, �ְ� ��� �����͸� ���������� �������� ���� ����
								
								}
					
							}
						
						}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				try {
					br.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				dateSelectMenu.setVisible(false);	// ó�� ȭ���� �Ⱥ��̰� ����
				
				final JPanel noticeWeatherMenu = new JPanel();	// ���� �Ϸ� ��ư�� ������ �� ��Ÿ�� �� �г��� ����
				noticeWeatherMenu.setBackground(Color.PINK);
				add(noticeWeatherMenu);
				noticeWeatherMenu.setVisible(true);
				
				double averageInNum = 0;	// ��� ��� �����͸� �Ǽ������� ��ȯ�Ͽ� �����ϱ� ���� ���� ����
				
				try {	// ���� ����ڰ� �Է��� ��¥�� �������� ���� ��¥���� ���, average���� �����͵� ������� �ʱ� ������ ������ �߻���
				averageInNum = Double.parseDouble(average);
				
				Font f2 = new Font("",Font.BOLD,14);
				// ���, ����, �ְ� ����� ȭ�鿡 �����
				JLabel text1 = new JLabel(searchDate+"�� ��� �����  "+average+"�� �̰� ���� ����� "+lowest+"�� �̸� �ְ� ����� "+highest+"�� �Դϴ�.");
				text1.setFont(f2);
				noticeWeatherMenu.add(text1,BorderLayout.NORTH);
				
				JLabel text2;
				JLabel image;
				// �׸��� ������
				ImageIcon img1 = new ImageIcon("weather-snowman.jpg");
				ImageIcon img2 = new ImageIcon("weather-wind.jpg");
				ImageIcon img3 = new ImageIcon("weather-breeze.jpg");
				ImageIcon img4 = new ImageIcon("weather-sunny.jpg");
				
				// ��� ����� ������ ������ ������ ���� �ٸ� ���� ������ �׸��� ȭ�鿡 ǥ�� ��
				if(averageInNum<=0) {
					
					image = new JLabel(img1);
					noticeWeatherMenu.add(image,BorderLayout.CENTER);
					text2 = new JLabel("������ �ſ� �߿�� ���� ����ϰ� �����ô°� ���ڽ��ϴ�.");
					text2.setFont(f2);
					noticeWeatherMenu.add(text2,BorderLayout.SOUTH);
					
				}
				
				if(averageInNum>0&&averageInNum<=10) {
					
					image = new JLabel(img2);
					noticeWeatherMenu.add(image,BorderLayout.CENTER);
					text2 = new JLabel("������ �ҽ��ϴ� ���� �����Ͻñ� �ٶ��ϴ�.");
					text2.setFont(f2);
					noticeWeatherMenu.add(text2,BorderLayout.SOUTH);
					
				}
				
				if(averageInNum>10&&averageInNum<=20) {
					
					image = new JLabel(img3);
					noticeWeatherMenu.add(image,BorderLayout.CENTER);
					text2 = new JLabel("������ ������ �Ϸ簡 �ǰڽ��ϴ�.");
					text2.setFont(f2);
					noticeWeatherMenu.add(text2,BorderLayout.SOUTH);
					
				}
				
				if(averageInNum>20) {
					
					image = new JLabel(img4);
					noticeWeatherMenu.add(image,BorderLayout.CENTER);
					text2 = new JLabel("������ �ټ� ���ڽ��ϴ�. ���� ������ �����ô°� ���ڽ��ϴ�.");
					text2.setFont(f2);
					noticeWeatherMenu.add(text2,BorderLayout.SOUTH);
					
				}
				
			}
				
				catch(NullPointerException e1) {	
					// ����ڰ� �������� ���� ��¥�� �Է����� ��, ���� �Ϸ� ��ư ���� �� ��Ÿ���� ȭ���� ���̵��� ���� �ʰ�, ������ ȭ�鿡 �ٽ� �Է��϶�� �޽����� �����
					noticeWeatherMenu.setVisible(false);
					dateSelectMenu.setVisible(true);
					JLabel errorMessage = new JLabel("�������� �ʴ� ��¥�Դϴ�. �ٽ� �Է����ּ���.");
					errorMessage.setBounds(190, 200, 400, 20);
					dateSelectMenu.add(errorMessage);
				}
				
				
			}
		}
		
		btn1.addActionListener(new MyGUI());	// ���ÿϷ� ��ư�� �̺�Ʈ �����ʸ� �߰���
			
		setSize(600,500);
		setVisible(true);	
	}
	
	
	public static void main(String[] args) throws IOException, InterruptedException{
		
		new DateSet();
				
		
		}
		
	}
	
	


