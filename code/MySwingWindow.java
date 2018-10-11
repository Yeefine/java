package com.shiyanlou.course;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;


public class MySwingWindow extends JFrame {
	//此处通过继承JFrame类来使我们自己的MySwingWindow具有窗体的一些属性和方法
	
	
	private static final long serialVersionUID = 8978037719568897634L;
	private JLabel myLabel;
	private JTextField myTextField;
	private JButton myButton;
	
	public MySwingWindow() {
		super();
		
		this.setSize(400, 300);
		//设置窗体大小
		
		this.getContentPane().setLayout(null);
		//返回此窗体的 contentPane 对象，设置其布局
        //这一句不太懂的话也不用担心，先写着
		
		this.setTitle("My First Swing Window");
		
		this.add(getJLabel(), null);
		this.add(getJTextField(), null);
		this.add(getJButton(), null);
		//在自定义的JFrame构造方法中使用add()方法来添加控件
        //add()方法可以将指定组件添加到此容器的给定位置上
        //第一个参数为待添加的组件，这里的组件来自我们的返回值
        //第二个参数为描述组件的布局限制的对象，我们不加限制，所以填null
	}
	
	
	
	
	private JLabel getJLabel() {
		
		if(myLabel == null) {
			myLabel = new JLabel();
			
			myLabel.setBounds(5, 10, 250, 30);
			 //使用setBounds()方法设置尺寸
	        //四个参数的分别是x,y,width,height
	        //代表了横向、纵向的位置，以及标签自身的宽和高
			
			myLabel.setText("Hello! Welcome to shiyanlou.com");
			//使用setText()方法设置要显示的文本
		}
		
		return myLabel;
	}
	
	
	
	private JTextField getJTextField() {
		if(myTextField == null) {
			myTextField = new JTextField();
			
			myTextField.setBounds(5, 45, 200, 30);
			
			myTextField.setText("Shi Yan Lou");
		}
		return myTextField;
	}
	
	
	
	private JButton getJButton() {
		if(myButton == null) {
			myButton = new JButton();
			//实例化myTextField对象
			
			myButton.setBounds(5,  80, 100, 40);
			
			myButton.setText("Click me!");
			
			myButton.addActionListener(new ActionListener() {
				//为其添加一个事件监听，从而使这个按钮可以响应用户的点击操作
	            //ActionListener是用于接收操作事件的侦听器接口。
	            //对处理操作事件感兴趣的类可以实现此接口，而使用该类创建的对
	            //可使用组件的 addActionListener 方法向该组件注册。
	            //在发生操作事件时，调用该对象的 actionPerformed 方法
				
				public void actionPerformed(ActionEvent e) {
					//该方法会在发生操作时被调用，我们要做的事情就可以写在这里面
	                //比如我们下面要做的事情就是改变之前两个控件里面的文字颜色和背景色
					
					myLabel.setForeground(Color.RED);
					//设置此组件的前景色
					
					myTextField.setBackground(Color.BLUE);
					//设置此组件的背景色
				}
			});
			
		}
		
		return myButton;
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MySwingWindow window = new MySwingWindow();
		//声明一个窗体对象 window
		
		window.setVisible(true);
	}

}
