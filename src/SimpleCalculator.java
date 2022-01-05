import javax.swing.*;
import java.awt.*;

public class SimpleCalculator {
    ///Создаем все компоненты
    JPanel windowContent = new JPanel();//Основная панель
    static JTextField displayField = new JTextField(30);//Текстовое поле
    JButton button0 = new JButton("0");
    JButton button1 = new JButton("1");
    JButton button2 = new JButton("2");
    JButton button3 = new JButton("3");
    JButton button4 = new JButton("4");
    JButton button5 = new JButton("5");
    JButton button6 = new JButton("6");
    JButton button7 = new JButton("7");
    JButton button8 = new JButton("8");
    JButton button9 = new JButton("9");
    JButton buttonPoint = new JButton(".");
    JButton buttonEqual = new JButton("=");
    static JButton buttonsumm = new JButton("+");
    static JButton buttonminus = new JButton("-");
    static JButton buttonshare = new JButton("/");
    static JButton buttonmultiply = new JButton("*");
    JPanel p1 = new JPanel();//вспомогательная панель с кнопками чисел, точкой и равно
    JPanel p2 = new JPanel();//вспомогательная панель с арефметичискими знаками

    SimpleCalculator(){
        // Задаём схему для этой панели
        BorderLayout bl = new BorderLayout();
        windowContent.setLayout(bl);
        // Добавляем поле в Северную область окна
        windowContent.add("North",displayField);
        // первая вспомогательная панель с GridLayout
        // которая содержит 12 кнопок - 10 кнопок с числами
        // и кнопки с точкой и знаком равно
        GridLayout gl =new GridLayout(4,3);
        p1.setLayout(gl);
        // Добавляем кнопки на панель p1
        p1.add(button1);
        p1.add(button2);
        p1.add(button3);
        p1.add(button4);
        p1.add(button5);
        p1.add(button6);
        p1.add(button7);
        p1.add(button8);
        p1.add(button9);
        p1.add(button0);
        p1.add(buttonPoint);
        p1.add(buttonEqual);
        // Помещаем панель p1 в центральную область окна
        windowContent.add("Center",p1);
        // вторая вспомогательная панель с GridLayout
        // которая содержит 4 кнопки с арефметичискими знаками
        GridLayout gl2 =new GridLayout(4,1);
        p2.setLayout(gl2);
        // Добавляем кнопки на панель p2
        p2.add(buttonsumm);
        p2.add (buttonminus);
        p2.add (buttonshare);
        p2.add (buttonmultiply);
        // Помещаем панель p2 в восточную область окна
        windowContent.add("East",p2);

        //Создаём фрейм и задаём его основную панель
        JFrame frame = new JFrame("Calculator");
        frame.setContentPane(windowContent);
        // делаем размер окна достаточным
        // для того, чтобы вместить все компоненты
        frame.pack();
        // Наконец, отображаем окно
        frame.setVisible(true);

        CalculatorEngine calcEngine = new CalculatorEngine();
        button0.addActionListener(calcEngine);
        button1.addActionListener(calcEngine);
        button2.addActionListener(calcEngine);
        button3.addActionListener(calcEngine);
        button4.addActionListener(calcEngine);
        button5.addActionListener(calcEngine);
        button6.addActionListener(calcEngine);
        button7.addActionListener(calcEngine);
        button8.addActionListener(calcEngine);
        button9.addActionListener(calcEngine);
        buttonsumm.addActionListener(calcEngine);
        buttonminus.addActionListener(calcEngine);
        buttonshare.addActionListener(calcEngine);
        buttonmultiply.addActionListener(calcEngine);
        buttonPoint.addActionListener(calcEngine);
        buttonEqual.addActionListener(calcEngine);

    }
        public static void main (String[] args){
        SimpleCalculator calc = new SimpleCalculator();
    }
}
