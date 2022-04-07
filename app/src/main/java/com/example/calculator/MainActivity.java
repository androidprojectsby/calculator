package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Stack;

public class MainActivity extends AppCompatActivity {
    static int priority(char ch){
        if(ch=='(')
            return 4;
        if(ch=='^')
            return 3;
        if(ch=='*' || ch=='/' || ch=='%')
            return 2;
        if(ch=='+'|| ch=='-')
            return 1;
        return 0;
    }
    static boolean canoperator(int position,String exp){
                    if(position==0 && exp.length()==0)
                        return false;
                    if(position==0){
                        if(exp.charAt(position) !='+' &&exp.charAt(position) !='-' &&exp.charAt(position) !='x' &&exp.charAt(position) !='/' &&
                                exp.charAt(position) !='%' &&exp.charAt(position) !='.' &&exp.charAt(position) !='(' &&exp.charAt(position) !=')' )
                            return true;
                    }
                    else if(position==exp.length()){
                        if(exp.charAt(position-1) !='+' &&exp.charAt(position-1) !='-' &&exp.charAt(position-1) !='x' &&exp.charAt(position-1) !='/' &&
                                exp.charAt(position-1) !='%' &&exp.charAt(position-1) !='.' &&exp.charAt(position-1) !='(' &&exp.charAt(position-1) !=')' )
                            return true;
                    }
                    else {
                        if(exp.charAt(position) !='+' &&exp.charAt(position) !='-' &&exp.charAt(position) !='x' &&exp.charAt(position) !='/' &&
                                exp.charAt(position) !='%' &&exp.charAt(position) !='.' &&exp.charAt(position) !='(' &&exp.charAt(position) !=')' )
                        {
                            if(exp.charAt(position-1) !='+' && exp.charAt(position-1) !='-' && exp.charAt(position-1) !='x' &&exp.charAt(position-1) !='/' &&
                                    exp.charAt(position-1) !='%' &&exp.charAt(position-1) !='.' &&exp.charAt(position-1) !='(' &&exp.charAt(position-1) !=')' )
                                return true;
                        }
                    }
                    return false;
    }
    static double operation(char op,double a,double b){
        switch(op){
            case '+':
                return b+a;
            case '-':
                return b-a;
            case '*':
                return b*a;
            case '/':
                return b/a;
            case '%':
                return b%a;
            case '^':
                return Math.pow(b,a);
        }
        return -1.0;
    }
    static double eval(String var){
        Stack<Character> operator =new Stack<Character>();
        Stack<Double> value=new Stack<Double>();
        int i;
        for(i=0;i<var.length();i++){
            if(var.charAt(i)>='0' && var.charAt(i)<='9'){
                String data="";
                while(i<var.length() && ((var.charAt(i)>='0' && var.charAt(i)<='9')||var.charAt(i)=='.')){

                    data+=String.valueOf(var.charAt(i));
                    i++;
                }
                value.push(Double.parseDouble(data));
            }
            if(i<var.length()){
                char ch=var.charAt(i);
                if(ch=='(')
                    operator.push(var.charAt(i));
                if(ch==')'){
                    while(operator.peek()!='(')
                        value.push(operation(operator.pop(),value.pop(),value.pop()));
                    operator.pop();
                }
                if(ch=='+' || ch=='-' || ch=='*' || ch=='/' || ch=='^'|| ch=='%'){
                    if(operator.empty()==true || operator.peek()=='(' || priority(operator.peek())<priority(var.charAt(i)))
                        operator.push(var.charAt(i));
                    else{
                        while(operator.empty()!=true && priority(operator.peek())>=priority(var.charAt(i))){

                            char c=operator.pop();

                            value.push(operation(c,value.pop(),value.pop()));
                        }
                        operator.push(var.charAt(i));
                    }
                }
            }
        }
        while(operator.empty()==false)
            value.push(operation(operator.pop(),value.pop(),value.pop()));
        return value.pop();
    }
    EditText t;
    TextView v;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1=findViewById(R.id.one);
        b2=findViewById(R.id.two);
        b3=findViewById(R.id.three);
        b4=findViewById(R.id.four);
        b5=findViewById(R.id.five);
        b6=findViewById(R.id.six);
        b7=findViewById(R.id.seven);
        b8=findViewById(R.id.eight);
        b9=findViewById(R.id.nine);
        b10=findViewById(R.id.zero);
        b11=findViewById(R.id.plus);
        b12=findViewById(R.id.minus);
        b13=findViewById(R.id.multiply);
        b14=findViewById(R.id.divide);
        b15=findViewById(R.id.equal);
        b16=findViewById(R.id.modulo);
        b17=findViewById(R.id.openpara);
        b18=findViewById(R.id.closedpara);
        b19=findViewById(R.id.clear);
        b20=findViewById(R.id.dot);
        b21=findViewById(R.id.onechar);
        t=findViewById(R.id.editTextTextPersonName);
        v=findViewById(R.id.textView5);
        t.setShowSoftInputOnFocus(false);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+"1"+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);

            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+"2"+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+"3"+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);
            }
        });
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+"4"+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);

            }
        });
        b5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+"5"+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);

            }
        });
        b6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+"6"+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);

            }
        });
        b7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+"7"+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);
            }
        });
        b8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+"8"+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);

            }
        });
        b9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+"9"+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);
            }
        });
        b10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+"0"+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);

            }
        });
        b11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                if(canoperator(position, text)) {
                    String ans = text.substring(0, position) + "+" + text.substring(position);
                    t.setText(ans);
                    t.setSelection(position + 1);
                }
            }
        });
        b12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                if(canoperator(position, text)) {
                    String ans = text.substring(0, position) + "-" + text.substring(position);
                    t.setText(ans);
                    t.setSelection(position + 1);
                }
            }
        });
        b13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                if(canoperator(position, text)) {
                    String ans = text.substring(0, position) + "x" + text.substring(position);
                    t.setText(ans);
                    t.setSelection(position + 1);
                }
            }
        });
        b14.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                if(canoperator(position, text)) {
                    String ans = text.substring(0, position) + "/" + text.substring(position);
                    t.setText(ans);
                    t.setSelection(position + 1);
                }
            }
        });
        b15.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    v.setText(String.valueOf(eval(t.getText().toString().replace('x', '*'))));
                }
                catch (Exception e){
                    Toast.makeText(getApplicationContext(),"wrong expression", Toast.LENGTH_SHORT).show();
                }

            }
        });
        b16.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                if(canoperator(position, text)) {
                    String ans = text.substring(0, position) + "%" + text.substring(position);
                    t.setText(ans);
                    t.setSelection(position + 1);
                }
            }
        });
        b17.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+"("+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);
            }
        });b18.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+")"+text.substring(position);
                t.setText(ans);
                t.setSelection(position+1);
            }
        });
        b19.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t.setText("");
            }
        });
        b20.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                if(canoperator(position, text)) {
                String ans = text.substring(0, position) + "." + text.substring(position);
                    t.setText(ans);
                    t.setSelection(position + 1);
                }
            }
        });
        b21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(t.getText().toString().length()>0) {
                    String text = t.getText().toString();
                    int position = t.getSelectionStart();
                    Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_LONG).show();
                    if(position>0) {

                        String ans = text.substring(0, position - 1) + text.substring(position);
                        t.setText(ans);
                        t.setSelection(position - 1);
                    }
                }
            }
        });
    }
}