package com.example.homework5.slice;

import com.example.homework5.slice.MyArgumentException;
import ohos.agp.components.Text;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;

class StructArrayListType{
    int type = -1;
    String value = "";
    public static Text displaytext;
    public StructArrayListType(String value){
        this.value = value;
        generateType();
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void generateType(){
        if(value.equals("")){
            return;
        }
        if(value.length() == 1){
            switch (value) {
                case "÷":
                    type = 1;
                    break;
                case "×":
                    type = 2;
                    break;
                case "-":
                    type = 3;
                    break;
                case "+":
                    type = 4;
                    break;
                default:
                    type = 0;
                    break;
            }
            return;
        }

        if(value.indexOf("/") != -1){
            int i = value.indexOf("/");

            String a = value.substring(0,i);

            BigDecimal bigDecimal_a = new BigDecimal(a);
            BigDecimal bigDecimal_b = new BigDecimal("100");


            double t = bigDecimal_a.divide(bigDecimal_b,15, RoundingMode.HALF_UP).doubleValue();
            value = String.valueOf(t);
        }
        type = 0;
    }

    public String toString(){
        return "type is "+type+","+"value is "+value;
    }
}


public class CalCulator{
    public static Text displaytext;
    private static final String[] type = {"number","÷","×","-","+",".","%"};
    private String express = "";
    private final ArrayList<StructArrayListType> expersslist = new ArrayList<>();

    public CalCulator(String express) throws MyArgumentException {
        if(express.equals("")){
            throw new MyArgumentException("error!");
        }
        this.express = express;
        StructArrayListType.displaytext = displaytext;
    }

    public void preDo(){
        //将表达式字符串按照数字和运算符每个单独提取出来按照原顺序放入expersslist
        StringBuilder stringBuilder = new StringBuilder();
        int operationsigncount = 0;
        for(int i = 0;i < express.length();i++){
            char ch = express.charAt(i);
            if((ch >= '0' && ch <= '9') || ch == '.' || ch == '%'){
                if(ch == '%'){
                    stringBuilder.append("/100");
                }
                else {
                    stringBuilder.append(ch);
                }
                operationsigncount = 0;
                continue;
            }

            if(operationsigncount != 2){
                operationsigncount++;

                if(operationsigncount == 2){
                    stringBuilder.append(ch);
                    continue;
                }

                expersslist.add(new StructArrayListType(stringBuilder.toString()));
                stringBuilder.delete(0,stringBuilder.length());
                stringBuilder.append(ch);

                if(operationsigncount != 2){
                    expersslist.add(new StructArrayListType(stringBuilder.toString()));
                    stringBuilder.delete(0,stringBuilder.length());
                }
                continue;
            }
            stringBuilder.append(ch);
        }
        expersslist.add(new StructArrayListType(stringBuilder.toString()));

        checklist();
    }

    public void doMutAndDiv() throws ArithmeticException{
        if(expersslist.size() == 0){
            return;
        }
        for(int i = 0;i < expersslist.size();i++){
            if(expersslist.get(i).type == 1 || expersslist.get(i).type == 2){
                double result = dofinalwork(i);
                //System.out.println("result is "+result);

                expersslist.get(i+1).setValue(String.valueOf(result));

                StructArrayListType structArrayListType1 = expersslist.get(i - 1);
                StructArrayListType structArrayListType2 = expersslist.get(i);

                expersslist.remove(structArrayListType1);
                expersslist.remove(structArrayListType2);
                i = 0;
            }
        }
        //checklist();
    }

    public double doSubAndAdd(){
        for (int i = 0; i < expersslist.size(); i++) {
            if(expersslist.get(i).type == 3 || expersslist.get(i).type == 4){
                double result = dofinalwork(i);
                //System.out.println("result is "+result);

                expersslist.get(i+1).setValue(String.valueOf(result));
                StructArrayListType structArrayListType1 = expersslist.get(i - 1);
                StructArrayListType structArrayListType2 = expersslist.get(i);

                expersslist.remove(structArrayListType1);
                expersslist.remove(structArrayListType2);
                i = 0;
            }
        }
        //checklist();
        return Double.parseDouble(expersslist.get(0).value);
    }

    public double doAllOperation() throws ArithmeticException{
        preDo();
        doMutAndDiv();
        return doSubAndAdd();
    }

    public double dofinalwork(int i) throws ArithmeticException{

        String a = expersslist.get(i - 1).value;
        String b = expersslist.get(i + 1).value;

        BigDecimal bigDecimal_a = new BigDecimal(a);
        BigDecimal bigDecimal_b = new BigDecimal(b);

        switch (expersslist.get(i).type) {
            case 1:
                return bigDecimal_a.divide(bigDecimal_b, 15,RoundingMode.HALF_UP).doubleValue();
            case 2:
                return bigDecimal_a.multiply(bigDecimal_b).doubleValue();
            case 3:
                return bigDecimal_a.subtract(bigDecimal_b).doubleValue();
            case 4:
                return bigDecimal_a.add(bigDecimal_b).doubleValue();
            default:
                break;
        }
        return -0.0000000;
    }

    public void checklist(){
        System.out.println("<___________________________");
        for(int i = 0;i < expersslist.size();i++){
            System.out.println(expersslist.get(i).toString());
        }
        System.out.println("___________________________>");
    }

}
//Copyright [MathCalculator] [name of copyright owner]
//
//Licensed under the Apache License, Version 2.0 (the "License");
//you may not use this file except in compliance with the License.
//You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
//Unless required by applicable law or agreed to in writing, software
//distributed under the License is distributed on an "AS IS" BASIS,
//WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//See the License for the specific language governing permissions and
//limitations under the License.
