package com.example.homework5.slice;

import com.example.homework5.ResourceTable;
import com.example.homework5.slice.MyArgumentException;
import com.example.homework5.slice.CalCulator;
import ohos.aafwk.ability.AbilitySlice;
import ohos.aafwk.content.Intent;
import ohos.agp.colors.RgbColor;
import ohos.agp.components.Component;
import ohos.agp.components.Text;
import ohos.agp.components.element.ShapeElement;
import ohos.multimodalinput.event.TouchEvent;

public class MainAbilitySlice extends AbilitySlice {
    private Text displaytext;
    private Text clear,percentage,backspace,division;
    private Text one,two,three,multiplication;
    private Text four,five,six,subtraction;
    private Text seven,eight,nine,addition;
    private Text zero,doublezero,point,equalsign;


    public void initMASComponents(){
        displaytext = (Text) findComponentById(ResourceTable.Id_displaytext);

        clear = (Text) findComponentById(ResourceTable.Id_clear);
        percentage = (Text) findComponentById(ResourceTable.Id_percentage);
        backspace = (Text) findComponentById(ResourceTable.Id_backspace);
        division = (Text) findComponentById(ResourceTable.Id_division);

        one = (Text) findComponentById(ResourceTable.Id_one);
        two = (Text) findComponentById(ResourceTable.Id_two);
        three = (Text) findComponentById(ResourceTable.Id_three);
        multiplication = (Text) findComponentById(ResourceTable.Id_multiplication);

        four = (Text) findComponentById(ResourceTable.Id_four);
        five = (Text) findComponentById(ResourceTable.Id_five);
        six = (Text) findComponentById(ResourceTable.Id_six);
        subtraction = (Text) findComponentById(ResourceTable.Id_subtraction);

        seven = (Text) findComponentById(ResourceTable.Id_seven);
        eight = (Text) findComponentById(ResourceTable.Id_eight);
        nine = (Text) findComponentById(ResourceTable.Id_nine);
        addition = (Text) findComponentById(ResourceTable.Id_addition);

        zero = (Text) findComponentById(ResourceTable.Id_zero);
        doublezero = (Text) findComponentById(ResourceTable.Id_doublezero);
        point = (Text) findComponentById(ResourceTable.Id_point);
        equalsign = (Text) findComponentById(ResourceTable.Id_equalsign);



        /************************************first-row*********************************/
        clear.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.setText("");
            }
        });
        clear.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    clear.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(214, 253, 227));

                    clear.setBackground(shapeElement);
                }
                return true;
            }
        });

        percentage.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                String s = displaytext.getText();
                if(s.equals("")){
                    return;
                }
                if(     s.charAt(s.length() - 1) == '÷'
                        || s.charAt(s.length() - 1) == '×'
                        || s.charAt(s.length() - 1) == '+'
                        || s.charAt(s.length() - 1) == '-'
                        || s.charAt(s.length() - 1) == '%'
                        || s.charAt(s.length() - 1) == '.'){
                    return;
                }

                displaytext.append("%");
            }
        });
        percentage.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    percentage.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(214, 253, 227));

                    percentage.setBackground(shapeElement);
                }
                return true;
            }
        });

        backspace.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                //displaytext.delete(1);//API 7编译，运行在API 7的机器里才有效果

                String s = displaytext.getText();

                if(s.equals("")){
                    return;
                }
                displaytext.setText(s.substring(0,s.length() - 1));

            }
        });
        backspace.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    backspace.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(214, 253, 227));

                    backspace.setBackground(shapeElement);
                }
                return true;
            }
        });

        division.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                String s = displaytext.getText();
                if(s.equals("")){
                    return;
                }
                if(     s.charAt(s.length() - 1) == '÷'
                        || s.charAt(s.length() - 1) == '×'
                        || s.charAt(s.length() - 1) == '+'
                        || s.charAt(s.length() - 1) == '-'
                        || s.charAt(s.length() - 1) == '.'){
                    return;
                }

                displaytext.append("÷");
            }
        });
        division.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    division.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(214, 253, 227));

                    division.setBackground(shapeElement);
                }
                return true;
            }
        });
        /************************************first-row*********************************/

        /************************************second-row*********************************/
        one.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.append("1");
            }
        });
        one.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    one.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(207, 241, 243));

                    one.setBackground(shapeElement);
                }
                return true;
            }
        });

        two.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.append("2");
            }
        });
        two.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    two.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(207, 241, 243));

                    two.setBackground(shapeElement);
                }
                return true;
            }
        });

        three.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.append("3");
            }
        });
        three.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    three.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(207, 241, 243));

                    three.setBackground(shapeElement);
                }
                return true;
            }
        });

        multiplication.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                String s = displaytext.getText();
                if(s.equals("")){
                    return;
                }
                if(     s.charAt(s.length() - 1) == '÷'
                        || s.charAt(s.length() - 1) == '×'
                        || s.charAt(s.length() - 1) == '+'
                        || s.charAt(s.length() - 1) == '-'
                        || s.charAt(s.length() - 1) == '.'){
                    return;
                }
                displaytext.append("×");
            }
        });
        multiplication.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    multiplication.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(207, 241, 243));

                    multiplication.setBackground(shapeElement);
                }
                return true;
            }
        });
        /************************************second-row*********************************/

        /************************************three-row*********************************/
        four.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.append("4");
            }
        });
        four.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    four.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(237, 253, 255));

                    four.setBackground(shapeElement);
                }
                return true;
            }
        });

        five.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.append("5");
            }
        });
        five.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    five.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(237, 253, 255));

                    five.setBackground(shapeElement);
                }
                return true;
            }
        });

        six.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.append("6");
            }
        });
        six.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    six.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(237, 253, 255));

                    six.setBackground(shapeElement);
                }
                return true;
            }
        });

        subtraction.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                String s = displaytext.getText();
                if(s.equals("")){
                    return;
                }
                if(s.charAt(s.length() - 1) == '.'){
                    return;
                }
                if(s.length() >= 3
                        && s.charAt(s.length() - 1) == '-'
                        && s.charAt(s.length() - 1 - 1) == '-'){
                    return;
                }
                displaytext.append("-");
            }
        });
        subtraction.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    subtraction.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(237, 253, 255));

                    subtraction.setBackground(shapeElement);
                }
                return true;
            }
        });
        /************************************third-row*********************************/

        /************************************fourth-row*********************************/
        seven.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.append("7");
            }
        });
        seven.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    seven.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(237, 248, 250));

                    seven.setBackground(shapeElement);
                }
                return true;
            }
        });

        eight.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.append("8");
            }
        });
        eight.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    eight.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(237, 248, 250));

                    eight.setBackground(shapeElement);
                }
                return true;
            }
        });

        nine.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.append("9");
            }
        });
        nine.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    nine.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(237, 248, 250));

                    nine.setBackground(shapeElement);
                }
                return true;
            }
        });

        addition.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                String s = displaytext.getText();
                if(s.equals("")){
                    return;
                }
                if(     s.charAt(s.length() - 1) == '÷'
                        || s.charAt(s.length() - 1) == '×'
                        || s.charAt(s.length() - 1) == '+'
                        || s.charAt(s.length() - 1) == '-'
                        || s.charAt(s.length() - 1) == '.'){
                    return;
                }

                displaytext.append("+");
            }
        });
        addition.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    addition.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(237, 248, 250));

                    addition.setBackground(shapeElement);
                }
                return true;
            }
        });
        /************************************fourth-row*********************************/

        /************************************fifth-row*********************************/
        zero.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.append("0");
            }
        });
        zero.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    zero.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(247, 249, 250));

                    zero.setBackground(shapeElement);
                }
                return true;
            }
        });

        doublezero.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                displaytext.append("00");
            }
        });
        doublezero.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    doublezero.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(247, 249, 250));

                    doublezero.setBackground(shapeElement);
                }
                return true;
            }
        });

        point.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                String s = displaytext.getText();
                if(s.equals("")){
                    return;
                }
                if(     s.charAt(s.length() - 1) == '÷'
                        || s.charAt(s.length() - 1) == '×'
                        || s.charAt(s.length() - 1) == '+'
                        || s.charAt(s.length() - 1) == '-'
                        || s.charAt(s.length() - 1) == '%'
                        || s.charAt(s.length() - 1) == '.'){
                    return;
                }
                displaytext.append(".");
            }
        });
        point.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    point.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(247, 249, 250));

                    point.setBackground(shapeElement);
                }
                return true;
            }
        });

        equalsign.setClickedListener(new Component.ClickedListener() {
            @Override
            public void onClick(Component component) {
                String s = displaytext.getText();
                if(s.equals("")){
                    return;
                }
                char lastchar = s.charAt(s.length() - 1);
                char firstchar = s.charAt(0);
                boolean haveoperate = false;
                if(     lastchar == '÷'
                        || lastchar == '×'
                        || lastchar == '+'
                        || lastchar == '-'
                        || lastchar == '.'
                        || firstchar == '-'){
                    displaytext.setText("error!");
                    return;
                }

                for(int i = 0;i < s.length();i++){
                    char ch = s.charAt(i);
                    if(     ch == '÷'
                            || ch == '×'
                            || ch == '+'
                            || ch == '-'
                            || ch == '%'){
                        haveoperate = true;
                        break;
                    }
                }
                if(!haveoperate){
                    return;
                }
                else{
                    //System.out.println("这里了！");
                    CalCulator calCulator= null;
                    try {
                        calCulator = new CalCulator(s);
                    } catch (MyArgumentException e) {
                        e.printStackTrace();
                    }


                    try{
                        assert calCulator != null;
                        double finalresult = calCulator.doAllOperation();
                        displaytext.setText(""+finalresult);
                    }
                    catch (ArithmeticException e){
                        displaytext.setText("error!");
                        e.printStackTrace();
                    }

                    //calCulatorGo.checklist();
                }


            }
        });
        equalsign.setTouchEventListener(new Component.TouchEventListener() {
            @Override
            public boolean onTouchEvent(Component component, TouchEvent touchEvent) {
                int i = touchEvent.getAction();
                if(i ==  TouchEvent.PRIMARY_POINT_DOWN){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setShape(1);
                    shapeElement.setRgbColor(new RgbColor(187, 255, 255));

                    equalsign.setBackground(shapeElement);
                }
                if(i == TouchEvent.PRIMARY_POINT_UP){
                    ShapeElement shapeElement = new ShapeElement();
                    shapeElement.setRgbColor(new RgbColor(247, 249, 250));

                    equalsign.setBackground(shapeElement);
                }
                return true;
            }
        });
        /************************************fourth-row*********************************/
    }

    @Override
    public void onStart(Intent intent) {
        super.onStart(intent);
        super.setUIContent(ResourceTable.Layout_ability_main);
        initMASComponents();
        CalCulator.displaytext = displaytext;
    }

    @Override
    protected void onInactive() {
        super.onInactive();
    }

    @Override
    public void onActive() {
        super.onActive();
    }

    @Override
    protected void onBackground() {
        super.onBackground();
    }

    @Override
    public void onForeground(Intent intent) {
        super.onForeground(intent);
    }

    @Override
    protected void onStop() {
        super.onStop();
    }
}

