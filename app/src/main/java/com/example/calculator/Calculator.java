package com.example.calculator;
import android.app.Activity;
import android.view.View;
import android.widget.Button; // Import Button class from Android SDK
import android.widget.TextView;

import org.w3c.dom.Text;

public class Calculator {
    Button btn0, btn1, btn2, btn3, btn4, btn5, btn6, btn7, btn8, btn9, btnPlus, btnMinus, btnDiv, btnKefel, btnBack, btnSoger1, btnSoger2, btnAC, btnDot,btnshave;
    TextView numdisplay,historyView;
    private String nums ="";
    public Calculator(Activity activity) {

        btn0 = (Button) activity.findViewById(R.id.btn0);
        btn1 = (Button) activity.findViewById(R.id.btn1);
        btn2 = (Button) activity.findViewById(R.id.btn2);
        btn3 = (Button) activity.findViewById(R.id.btn3);
        btn4 = (Button) activity.findViewById(R.id.btn4);
        btn5 = (Button) activity.findViewById(R.id.btn5);
        btn6 = (Button) activity.findViewById(R.id.btn6);
        btn7 = (Button) activity.findViewById(R.id.btn7);
        btn8 = (Button) activity.findViewById(R.id.btn8);
        btn9 = (Button) activity.findViewById(R.id.btn9);
        numdisplay = (TextView) activity.findViewById(R.id.numdisplay);
        historyView = (TextView) activity.findViewById(R.id.historyview);

        btnshave = (Button) activity.findViewById(R.id.btnshave);
        btnPlus = (Button) activity.findViewById(R.id.btnplus);
        btnMinus = (Button) activity.findViewById(R.id.btnminus);
        btnDiv = (Button) activity.findViewById(R.id.btndiv);
        btnKefel = (Button) activity.findViewById(R.id.btnkefel);
        btnBack = (Button) activity.findViewById(R.id.backbtn);
        btnSoger1 = (Button) activity.findViewById(R.id.btnsoger1);
        btnSoger2 = (Button) activity.findViewById(R.id.btnsoger2);
        btnAC = (Button) activity.findViewById(R.id.acbtn);
        btnDot = (Button) activity.findViewById(R.id.btndot);
        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="0";
                numdisplay.setText(nums);
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="1";
                numdisplay.setText(nums);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="2";
                numdisplay.setText(nums);
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="3";
                numdisplay.setText(nums);
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="4";
                numdisplay.setText(nums);
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="5";
                numdisplay.setText(nums);
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="6";
                numdisplay.setText(nums);
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="7";
                numdisplay.setText(nums);
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="8";
                numdisplay.setText(nums);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="9";
                numdisplay.setText(nums);
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nums.length()>1){
                    nums = nums.substring(0,nums.length() -1);
                    numdisplay.setText(nums);
                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+=" + ";
                numdisplay.setText(nums);
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+=" - ";
                numdisplay.setText(nums);
            }
        });
        btnKefel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+=" × ";
                numdisplay.setText(nums);
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+=" ÷ ";
                numdisplay.setText(nums);
            }
        });
        btnshave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                historyView.setText(nums);
                float result = calculate(nums);
                if (result % 1 == 0) {
                    numdisplay.setText(String.valueOf((int) result));
                } else {
                    numdisplay.setText(String.valueOf(result));
                }
                nums="";
            }
        });

        btnAC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums="";
                numdisplay.setText(nums);
            }
        });
        btnSoger1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="(";
                numdisplay.setText(nums);
            }
        });
        btnSoger2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+=")";
                numdisplay.setText(nums);
            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+=".";
                numdisplay.setText(nums);
            }
        });






    }
    public float calculate(String numbers){
        numbers = numbers.replaceAll(" ", "");
        float finalnum=0,temp1=0,temp2=0,finalkefel=0;
        String tempS1 ="",tempS2 ="", str="",str2="";

        int j,start=0,end=0;


        for (int h = 0; h < numbers.length(); h++) {

            char b = numbers.charAt(h);
            if(Character.isDigit(b)){
                str+=b;
            }
            //System.out.println("numbers :" + numbers + " after kefel " + finalkefel + " str1 : " + " str2 : "+str2 );
            if(b=='+'|| b=='-'){
                str = "";
                start = h+1;
            }
            if(b=='×'){

                h++;
                while(Character.isDigit(numbers.charAt(h))&&h<numbers.length()){
                    b = numbers.charAt(h);
                    h++;
                    str2+=b;
                }
                end =h-1;
                System.out.println("numbers :" + numbers + " after kefel " + finalkefel + " str1 : "+ str + " str2 : "+str2 );
                finalkefel = Float.parseFloat(str) * Float.parseFloat(str2);
                if(finalkefel%1==0){
                    numbers= numbers.substring(0, start) + (int) finalkefel + numbers.substring(end +1);
                }else {
                    numbers= numbers.substring(0, start) + finalkefel + numbers.substring(end +1);
                }


                h=0;
                System.out.println("numbers :" + numbers + " after kefel " + finalkefel);
            }
            if(b=='÷'){

                h++;
                b = numbers.charAt(h);
                while(Character.isDigit(b)&&h<numbers.length()){
                    b = numbers.charAt(h);
                    h++;
                    str2+=b;
                }
                end =h;
                finalkefel = Float.parseFloat(str) / Float.parseFloat(str2);
                numbers= numbers.substring(0, start) + finalkefel + numbers.substring(end + 1);
                numbers+="" + finalkefel;
                System.out.println("numbers :" + numbers + " after kefel " + finalkefel);
            }
        }

        for (int i = 0; i < numbers.length(); i++) {
            char c = numbers.charAt(i);
            tempS2="";
            if(!(Character.isDigit(c) || c == '.')){
                System.out.println("started not a num");
                if (c == '+') {
                    System.out.println("_______________________________");
                    j=i+1;
                    while (j < numbers.length() && Character.isDigit(numbers.charAt(j))) {
                        tempS2+= numbers.charAt(j);
                        j++;
                    }
                    temp2=Float.parseFloat(tempS2);
                    if(finalnum==0.0){
                        finalnum= temp1 + temp2;
                    }else{
                        finalnum= finalnum+temp2;
                    }
                    i =j-1;
                } else if (c == '-') {
                    j=i+1;

                    while (j < numbers.length() && Character.isDigit(numbers.charAt(j))) {
                        tempS2+= numbers.charAt(j);
                        j++;
                    }
                    temp2=Float.parseFloat(tempS2);
                    if(finalnum==0.0){
                        finalnum= temp1 - temp2;
                    }else{
                        finalnum= finalnum-temp2;
                    }
                    i =j-1;
                }
                System.out.println("finished loop " + i + " done the function " + numbers.charAt(i) + "the final num is " + finalnum  );
                System.out.println("_______________________________");

            }else {
                temp1 =0;

                tempS1+= Character.toString(c);
                temp1=Float.parseFloat(tempS1);
                System.out.println("finished loop " + i + " added the char " + numbers.charAt(i) + "to (temp1) " + temp1 + "  the final num is " + finalnum );

            }

        }
        return finalnum;
    }
}
