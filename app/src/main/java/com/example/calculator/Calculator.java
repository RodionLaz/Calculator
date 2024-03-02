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
    boolean lastcharisop = true;
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
                lastcharisop = false;
            }
        });
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="1";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="2";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="3";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="4";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="5";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="6";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="7";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="8";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nums+="9";
                numdisplay.setText(nums);
                lastcharisop = false;
            }
        });
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(nums.length()>=1){
                    nums = nums.substring(0,nums.length() -1);
                    numdisplay.setText(nums);
                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastcharisop){return;}
                nums+=" + ";
                numdisplay.setText(nums);
                lastcharisop = true;
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastcharisop){return;}
                nums+=" - ";
                numdisplay.setText(nums);
                lastcharisop = true;
            }
        });
        btnKefel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastcharisop){return;}
                nums+=" × ";
                numdisplay.setText(nums);
                lastcharisop = true;
            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(lastcharisop){return;}
                nums+=" ÷ ";
                numdisplay.setText(nums);
                lastcharisop = true;
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
                lastcharisop = true;
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

    public float[] calculateHelper(int charloc,char op,String numbers,float num1){
        char b=' ';
        int h=charloc+1;
        float num2;
        String num2str="";
        float[] finalAndLoc = new float[2];

        while (h < numbers.length() && Character.isDigit(numbers.charAt(h))) {
            num2str += numbers.charAt(h);
            h++;
        }
        finalAndLoc[1] = h-1;
        num2 = Float.parseFloat(num2str);
        switch (op){
            case '×':
                finalAndLoc[0] =num1*num2;
                break;
            case '÷':
                if (num2 != 0) {
                    finalAndLoc[0] = num1 / num2;
                }else{
                    finalAndLoc[0] = 0;
                }
                break;
            case '+':
                finalAndLoc[0] =num1+num2;
                break;
            case '-':
                finalAndLoc[0] =num1-num2;
                break;
            default:
                finalAndLoc[0] = 0;
        }
        return finalAndLoc;
    }

    public float calculate(String numbers){
        numbers = numbers.replaceAll(" ", "");
        float num1;
        String  str="",str2="";
        float[] finalAndLoc;
        int start=0,end=0;
        int h = 0;
        while (h < numbers.length()) {
            char b = numbers.charAt(h);
            if(Character.isDigit(b)) {
                str += b;
            }
            if (b == '+' || b == '-') {
                str = "";
                start = h + 1;
            }
            if (b == '×' || b == '÷') {
                num1 = Float.parseFloat(str);
                finalAndLoc = calculateHelper(h, b, numbers, num1);
                end = (int) finalAndLoc[1];
                if (finalAndLoc[0] % 1 == 0) {
                    numbers = numbers.substring(0, start) + (int) finalAndLoc[0] + numbers.substring(end + 1);
                } else {
                    numbers = numbers.substring(0, start) + finalAndLoc[0] + numbers.substring(end + 1);
                }
                h = 0;
                str = "";
            }else{
                h++;
            }
        }
        start = 0;
        int i = 0;
        while (i < numbers.length()) {
            char c = numbers.charAt(i);
            if (!Character.isDigit(c)) {
                if(c=='.'){str2+=c;i++;}
                if (c == '+'||c == '-') {
                    while(Character.isDigit(c)){
                        i =0;
                    }
                    finalAndLoc = calculateHelper(i, c, numbers, Float.parseFloat(str2));
                    end = (int) finalAndLoc[1];
                    if (finalAndLoc[0] % 1 == 0) {
                        numbers= numbers.substring(0, start) + (int) finalAndLoc[0] + numbers.substring(end +1);
                    } else {
                        numbers= numbers.substring(0, start) + finalAndLoc[0] + numbers.substring(end +1);
                    }
                    i = 0;
                    str2 = "";
                }
            } else {
                str2 += c;
                i++;
            }
        }
        return Float.parseFloat(numbers);
    }
}
