package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

import java.util.Stack;
import java.util.StringTokenizer;

public class MainActivity extends AppCompatActivity {
    double prevans=0.0;
 boolean canoperator(int position,String exp,char op){
 if(position !=0 && position==exp.length()) {
     if (exp.charAt(position - 1) != '+' && exp.charAt(position - 1) != '-' && exp.charAt(position - 1) != 'x' && exp.charAt(position - 1) != '/' &&
             exp.charAt(position - 1) != '%' && exp.charAt(position - 1) != '.')
         return true;
     else
         return false;
 }
     exp=exp.substring(0,position)+String.valueOf(op)+exp.substring(position);
     for(int i=1;i<exp.length();i++){
         if((exp.charAt(i)=='+' || exp.charAt(i)=='-') &&(exp.charAt(i)==exp.charAt(i-1) || (exp.charAt(i)=='+'  && exp.charAt(i-1)=='-') || (exp.charAt(i)=='-'  && exp.charAt(i-1)=='+')))
             return false;
     }
     boolean flag=false;
     try{
         Expression expression = new ExpressionBuilder(exp.replace('x','*')).build();
         double result = expression.evaluate();
         flag=true;
     }
     catch(Exception e){
     }
     if(flag==true)
         return true;
     return false;
    }
    EditText t;
    TextView v;
    Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14,b15,b16,b17,b18,b19,b20,b21,b22;
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
        b22=findViewById(R.id.ans);
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
                if(canoperator(position, text,'+')) {
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
                if(canoperator(position, text,'-')) {
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
                if(canoperator(position, text,'x')) {
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
                if(canoperator(position, text,'/')) {
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
                    Expression expression = new ExpressionBuilder(t.getText().toString().replace('x', '*')).build();
                    double result = expression.evaluate();
                    v.setText(String.valueOf(result));
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
                if(canoperator(position, text,'%')) {
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
                if(canoperator(position, text, '.')) {
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
                   // Toast.makeText(getApplicationContext(), String.valueOf(position), Toast.LENGTH_LONG).show();
                    if(position>0) {

                        String ans = text.substring(0, position - 1) + text.substring(position);
                        t.setText(ans);
                        t.setSelection(position - 1);
                    }
                }
            }
        });

        b22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text=t.getText().toString();
                int position=t.getSelectionStart();
                String ans=text.substring(0, position)+prevans+text.substring(position);
                t.setText(ans);
                t.setSelection(position+String.valueOf(prevans).length());
            }
        });
    }
}