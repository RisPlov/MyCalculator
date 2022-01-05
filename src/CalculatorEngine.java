import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CalculatorEngine implements ActionListener {
    String SrcDisplay = "";
    ArrayList<String> Sing =  new ArrayList<>();/// лист символов
    ArrayList<String> ArSy = new ArrayList<>();/// лист арефметических символов
    @Override
    public void actionPerformed(ActionEvent e) {

        String currentResult = "";
        JButton clickedButton= (JButton)e.getSource();

        String src = clickedButton.getText();
        if (src.equals("+")||src.equals("-")||src.equals("/")||src.equals("*")) {
            SimpleCalculator.displayField.setText(src); //если нажата кнопка с арефметичиским символом, выводим на экран символ
            Sing.add(SrcDisplay);//заполняем лист  символов
            ArSy.add(src);//заполняем лист арефмитических символов
            SrcDisplay = ""; ///обнуляем содержимое переменной для вывода
            }
        else if(!src.equals("=")){SrcDisplay = SrcDisplay +src;
            SimpleCalculator.displayField.setText(SrcDisplay);}
        if (src.equals("=")){
            Sing.add(SrcDisplay);//заполняем лист  символов
            int size = ArSy.size();//определяем размер списка с арефметическими символами
            int element = 0;
            double result = 0;
            for (int i = 0; i<size; i++){//создаем цикл длинной равной длинне листа арефметических символов
                if (ArSy.contains("*")|ArSy.contains("/")){
                    int HelpElement1 = ArSy.indexOf("*");
                    int HelpElement2 = ArSy.indexOf("/");
                    if (-1<HelpElement1&HelpElement1<HelpElement2|HelpElement2==-1){element = ArSy.indexOf("*"); result = Double.parseDouble(Sing.get(element))*Double.parseDouble(Sing.get(element+1)); }//совершаем операцию
                    else {element = ArSy.indexOf("/"); result = Double.parseDouble(Sing.get(element))/Double.parseDouble(Sing.get(element+1));}
                }
                else if (ArSy.contains("+")|ArSy.contains("-")){
                    int HelpElement1 = ArSy.indexOf("+");
                    int HelpElement2 = ArSy.indexOf("-");
                    if (-1<HelpElement1&HelpElement1<HelpElement2|HelpElement2==-1){element = ArSy.indexOf("+"); result = Double.parseDouble(Sing.get(element))+Double.parseDouble(Sing.get(element+1)); }//совершаем операцию
                    else {element = ArSy.indexOf("-"); result = Double.parseDouble(Sing.get(element))-Double.parseDouble(Sing.get(element+1));}
                }
                System.out.println(result);
                currentResult = String.valueOf(result);
                ArSy.remove(element);//удаляем операционный знак
                Sing.remove(element);//удаляем первое операционное число из списка
                Sing.set(element,currentResult);//заменяем результатом второе операционное число
            }
            SimpleCalculator.displayField.setText(currentResult);////если нажата кнопка "=", выводим переменную с результатом
            Sing.clear();
            ArSy.clear();
            SrcDisplay = "";}///обнуляем содержимое переменной для вывода
    }
}
