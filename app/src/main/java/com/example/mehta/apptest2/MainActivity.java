//Designed and Coded Solely by Tanuj Mehta

package com.example.mehta.apptest2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView current;
    private TextView passive;
    private TextView symbol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

          current=(TextView)findViewById(R.id.current);
          passive=(TextView)findViewById(R.id.passive);
          symbol=(TextView)findViewById(R.id.symbol);

        //Define events of different buttons
        //zero
        Button zero=(Button)findViewById(R.id.zero);
        zero.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        stored=stored + "0";
                        current.setText(""+stored);
                    }
                }
        );
        //one
        Button one=(Button)findViewById(R.id.one);
        one.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        stored=stored + "1";
                        current.setText(""+stored);
                    }
                }
        );
        //two
        Button two=(Button)findViewById(R.id.two);
        two.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        stored=stored + "2";
                        current.setText(""+stored);
                    }
                }
        );
        //three
        Button three=(Button)findViewById(R.id.three);
        three.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        stored=stored + "3";
                        current.setText(""+stored);
                    }
                }
        );
        //four
        Button four=(Button)findViewById(R.id.four);
        four.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        stored=stored + "4";
                        current.setText(""+stored);
                    }
                }
        );
        //five
        Button five=(Button)findViewById(R.id.five);
        five.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        stored=stored + "5";
                        current.setText(""+stored);
                    }
                }
        );
        //six
        Button six=(Button)findViewById(R.id.six);
        six.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        stored=stored + "6";
                        current.setText(""+stored);
                    }
                }
        );
        //seven
        Button seven=(Button)findViewById(R.id.seven);
        seven.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        stored=stored + "7";
                        current.setText(""+stored);
                    }
                }
        );
        //eight
        Button eight=(Button)findViewById(R.id.eight);
        eight.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        stored=stored + "8";
                        current.setText(""+stored);
                    }
                }
        );
        //nine
        Button nine=(Button)findViewById(R.id.nine);
        nine.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        stored=stored + "9";
                        current.setText(""+stored);
                    }
                }
        );
        //point
        Button point=(Button)findViewById(R.id.point);
        point.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        boolean x=true;
                        for(int i=0;i<stored.length();i++){
                            Character a=stored.charAt(i);
                            if(a=='.'){
                                x=false;
                            }
                        }
                        if(x){
                            stored=stored + ".";
                        }
                        current.setText(""+stored);
                    }
                }
        );
        //plus
        Button plus=(Button)findViewById(R.id.plus);
        plus.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        CharSequence pre=passive.getText();
                        CharSequence sym=symbol.getText();
                        if(sym.length()==0){
                            if(stored.length()!=0) {
                                if(stored.length()==1){
                                    Character sign=stored.charAt(0);
                                    if(sign=='.'){
                                        passive.setText("0.0");
                                    }else{
                                        if(sign=='-'){
                                            passive.setText("-0");
                                        }else{
                                            passive.setText(""+stored);
                                        }
                                    }
                                }else{
                                    if(stored.length()==2){
                                        Character x=stored.charAt(0);
                                        Character y=stored.charAt(1);
                                        if((x=='-')&&(y=='.')){
                                            stored=stored+"0";
                                        }
                                        passive.setText(""+stored);
                                    }else{
                                        passive.setText(""+stored);
                                    }
                                }
                                current.setText("");
                                symbol.setText("+");
                            }
                        }
                        else{
                            if(stored.length()==0){
                                symbol.setText("+");
                            }else {
                                Character operator = sym.charAt(0);
                                if(stored.length()==1){
                                    Character sign=stored.charAt(0);
                                    if(sign=='-'){
                                        switch(operator){
                                            case '+':
                                                stored=stored+"0";
                                                break;
                                            case '-':
                                                stored=stored+"0";
                                                break;
                                            case 'X':
                                                stored=stored+"1";
                                                break;
                                            case '/':
                                                stored=stored+"1";
                                                break;
                                        }
                                    }else{
                                        if(sign=='.'){
                                            stored=stored+"0";
                                        }
                                    }
                                }
                                if(stored.length()==2){
                                    Character x=stored.charAt(0);
                                    Character y=stored.charAt(1);
                                    if((x=='-')&&(y=='.')){
                                        stored=stored+"0";
                                    }
                                }
                                Double a, b, result;
                                a = Double.parseDouble("" + pre);
                                b = Double.parseDouble("" + stored);
                                switch (operator) {
                                    case '+':
                                        result = a + b;
                                        break;
                                    case '-':
                                        result = a - b;
                                        break;
                                    case 'X':
                                        result = a * b;
                                        break;
                                    case '/':
                                        if (b == 0.0) {
                                            result = Double.NaN;
                                        } else {
                                            result = a / b;
                                        }
                                        break;
                                    default:
                                        result = Double.NaN;
                                }
                                passive.setText("" + result);
                                current.setText("");
                                symbol.setText("+");
                            }
                        }
                    }
                }
        );
        //minus
        Button minus=(Button)findViewById(R.id.minus);
        minus.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        CharSequence pre=passive.getText();
                        CharSequence sym=symbol.getText();
                        if(sym.length()==0){
                            if(stored.length()!=0) {
                                if(stored.length()==1){
                                    Character sign=stored.charAt(0);
                                    if(sign=='.'){
                                        passive.setText("0.0");
                                    }else{
                                        if(sign=='-'){
                                            passive.setText("-0");
                                        }else{
                                            passive.setText(""+stored);
                                        }
                                    }
                                }else{
                                    if(stored.length()==2){
                                        Character x=stored.charAt(0);
                                        Character y=stored.charAt(1);
                                        if((x=='-')&&(y=='.')){
                                            stored=stored+"0";
                                        }
                                        passive.setText(""+stored);
                                    }else{
                                        passive.setText(""+stored);
                                    }
                                }
                                current.setText("");
                                symbol.setText("-");
                            }else{
                                current.setText("-");
                            }
                        }
                        else{
                            if(stored.length()==0){
                                current.setText("-");
                            }else {
                                Character operator = sym.charAt(0);
                                if(stored.length()==1){
                                    Character sign=stored.charAt(0);
                                    if(sign=='-'){
                                        switch(operator){
                                            case '+':
                                                stored=stored+"0";
                                                break;
                                            case '-':
                                                stored=stored+"0";
                                                break;
                                            case 'X':
                                                stored=stored+"1";
                                                break;
                                            case '/':
                                                stored=stored+"1";
                                                break;
                                        }
                                    }else{
                                        if(sign=='.'){
                                            stored=stored+"0";
                                        }
                                    }
                                }
                                if(stored.length()==2){
                                    Character x=stored.charAt(0);
                                    Character y=stored.charAt(1);
                                    if((x=='-')&&(y=='.')){
                                        stored=stored+"0";
                                    }
                                }
                                Double a, b, result;
                                a = Double.parseDouble("" + pre);
                                b = Double.parseDouble("" + stored);
                                switch (operator) {
                                    case '+':
                                        result = a + b;
                                        break;
                                    case '-':
                                        result = a - b;
                                        break;
                                    case 'X':
                                        result = a * b;
                                        break;
                                    case '/':
                                        if (b == 0.0) {
                                            result = Double.NaN;
                                        } else {
                                            result = a / b;
                                        }
                                        break;
                                    default:
                                        result = Double.NaN;
                                }
                                passive.setText("" + result);
                                current.setText("");
                                symbol.setText("-");
                            }
                        }
                    }
                }
        );
        //multiply
        Button mult=(Button)findViewById(R.id.mult);
        mult.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        CharSequence pre=passive.getText();
                        CharSequence sym=symbol.getText();
                        if(sym.length()==0){
                            if(stored.length()!=0) {
                                if(stored.length()==1){
                                    Character sign=stored.charAt(0);
                                    if(sign=='.'){
                                        passive.setText("0.0");
                                    }else{
                                        if(sign=='-'){
                                            passive.setText("-0");
                                        }else{
                                            passive.setText(""+stored);
                                        }
                                    }
                                }else{
                                    if(stored.length()==2){
                                        Character x=stored.charAt(0);
                                        Character y=stored.charAt(1);
                                        if((x=='-')&&(y=='.')){
                                            stored=stored+"0";
                                        }
                                        passive.setText(""+stored);
                                    }else{
                                        passive.setText(""+stored);
                                    }
                                }
                                current.setText("");
                                symbol.setText("X");
                            }
                        }
                        else{
                            if(stored.length()==0){
                                symbol.setText("X");
                            }else {
                                Character operator = sym.charAt(0);
                                if(stored.length()==1){
                                    Character sign=stored.charAt(0);
                                    if(sign=='-'){
                                        switch(operator){
                                            case '+':
                                                stored=stored+"0";
                                                break;
                                            case '-':
                                                stored=stored+"0";
                                                break;
                                            case 'X':
                                                stored=stored+"1";
                                                break;
                                            case '/':
                                                stored=stored+"1";
                                                break;
                                        }
                                    }else{
                                        if(sign=='.'){
                                            stored=stored+"0";
                                        }
                                    }
                                }
                                if(stored.length()==2){
                                    Character x=stored.charAt(0);
                                    Character y=stored.charAt(1);
                                    if((x=='-')&&(y=='.')){
                                        stored=stored+"0";
                                    }
                                }
                                Double a, b, result;
                                a = Double.parseDouble("" + pre);
                                b = Double.parseDouble("" + stored);
                                switch (operator) {
                                    case '+':
                                        result = a + b;
                                        break;
                                    case '-':
                                        result = a - b;
                                        break;
                                    case 'X':
                                        result = a * b;
                                        break;
                                    case '/':
                                        if (b == 0.0) {
                                            result = Double.NaN;
                                        } else {
                                            result = a / b;
                                        }
                                        break;
                                    default:
                                        result = Double.NaN;
                                }
                                passive.setText("" + result);
                                current.setText("");
                                symbol.setText("X");
                            }
                        }

                    }
                }
        );
        //devide
        Button divide=(Button)findViewById(R.id.divide);
        divide.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        CharSequence pre=passive.getText();
                        CharSequence sym=symbol.getText();
                        if(sym.length()==0){
                            if(stored.length()!=0) {
                                if(stored.length()==1){
                                    Character sign=stored.charAt(0);
                                    if(sign=='.'){
                                        passive.setText("0.0");
                                    }else{
                                        if(sign=='-'){
                                            passive.setText("-0");
                                        }else{
                                            passive.setText(""+stored);
                                        }
                                    }
                                }else{
                                    if(stored.length()==2){
                                        Character x=stored.charAt(0);
                                        Character y=stored.charAt(1);
                                        if((x=='-')&&(y=='.')){
                                            stored=stored+"0";
                                        }
                                        passive.setText(""+stored);
                                    }else{
                                        passive.setText(""+stored);
                                    }
                                }
                                current.setText("");
                                symbol.setText("/");
                            }
                        }
                        else{
                            if(stored.length()==0){
                                symbol.setText("/");
                            }else {
                                Character operator = sym.charAt(0);
                                if(stored.length()==1){
                                    Character sign=stored.charAt(0);
                                    if(sign=='-'){
                                        switch(operator){
                                            case '+':
                                                stored=stored+"0";
                                                break;
                                            case '-':
                                                stored=stored+"0";
                                                break;
                                            case 'X':
                                                stored=stored+"1";
                                                break;
                                            case '/':
                                                stored=stored+"1";
                                                break;
                                        }
                                    }else{
                                        if(sign=='.'){
                                            stored=stored+"0";
                                        }
                                    }
                                }
                                if(stored.length()==2){
                                    Character x=stored.charAt(0);
                                    Character y=stored.charAt(1);
                                    if((x=='-')&&(y=='.')){
                                        stored=stored+"0";
                                    }
                                }
                                Double a, b, result;
                                a = Double.parseDouble("" + pre);
                                b = Double.parseDouble("" + stored);
                                switch (operator) {
                                    case '+':
                                        result = a + b;
                                        break;
                                    case '-':
                                        result = a - b;
                                        break;
                                    case 'X':
                                        result = a * b;
                                        break;
                                    case '/':
                                        if (b == 0.0) {
                                            result = Double.NaN;
                                        } else {
                                            result = a / b;
                                        }
                                        break;
                                    default:
                                        result = Double.NaN;

                                }
                                passive.setText("" + result);
                                current.setText("");
                                symbol.setText("/");
                            }
                        }

                    }
                }
        );
        //equal
        Button equal=(Button)findViewById(R.id.equal);
        equal.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        CharSequence pre=passive.getText();
                        CharSequence sym=symbol.getText();
                        Double a,b,result;

                        if(sym.length()==0){
                            if(stored.length()==0){
                                current.setText("");
                                passive.setText("");
                                symbol.setText("");
                            }
                        }else {
                            if(stored.length()!=0) {
                                Character operator = sym.charAt(0);
                                if(stored.length()==1){
                                    Character sign=stored.charAt(0);
                                    if(sign=='-'){
                                        switch(operator){
                                            case '+':
                                                stored=stored+"0";
                                                break;
                                            case '-':
                                                stored=stored+"0";
                                                break;
                                            case 'X':
                                                stored=stored+"1";
                                                break;
                                            case '/':
                                                stored=stored+"1";
                                                break;
                                        }

                                    }else{
                                        if(sign=='.'){
                                            stored=stored+"0";
                                        }
                                    }
                                }
                                if(stored.length()==2){
                                    Character x=stored.charAt(0);
                                    Character y=stored.charAt(1);
                                    if((x=='-')&&(y=='.')){
                                        stored=stored+"0";
                                    }
                                }
                                a = Double.parseDouble("" + pre);
                                b = Double.parseDouble("" + stored);
                                switch (operator) {
                                    case '+':
                                        result = a + b;
                                        break;
                                    case '-':
                                        result = a - b;
                                        break;
                                    case 'X':
                                        result = a * b;
                                        break;
                                    case '/':
                                        if (b == 0.0) {
                                            result = Double.NaN;
                                        } else {
                                            result = a / b;
                                        }
                                        break;
                                    default:
                                        result = Double.NaN;

                                }
                                current.setText("" + result);
                                passive.setText("");
                                symbol.setText("");
                            }
                        }

                    }
                }
        );
        //CE
        Button clear=(Button)findViewById(R.id.clear);
        clear.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        current.setText("");
                    }
                }
        );
        //C Button
        Button ce=(Button)findViewById(R.id.ce);
        ce.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        current.setText("");
                        passive.setText("");
                        symbol.setText("");
                    }
                }
        );
        //Delete single character from end (<--) Button
        Button back=(Button)findViewById(R.id.back);
        back.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        if(stored.length()>0){
                            CharSequence newStored=stored.subSequence(0,stored.length()-1);
                            current.setText(""+newStored);
                        }

                    }
                }
        );
        //Delete all characters on long press of (<--) Button
        back.setOnLongClickListener(
                new Button.OnLongClickListener(){
                    public boolean onLongClick(View v){
                        current.setText("");
                        return true;
                    }
                }
        );
        //percent
        Button percent=(Button)findViewById(R.id.percent);
        percent.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored=current.getText();
                        CharSequence pre=passive.getText();
                        CharSequence sym=symbol.getText();
                        if(sym.length()==0){
                            current.setText("");
                        }else{
                            if(stored.length()==0){
                                current.setText("");
                            }else{
                                Double a,b,result;
                                a=Double.parseDouble(""+pre);
                                b=Double.parseDouble(""+stored);
                                if(b<0){
                                    b=b*(-1);
                                }
                                result=(a*b*0.01);
                                current.setText(""+result);
                            }
                        }

                    }
                }
        );
        //root
        Button root=(Button)findViewById(R.id.root);
        root.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored = current.getText();
                        if(stored.length()>0) {
                            if(stored.length()==1){
                                Character c0=stored.charAt(0);
                                if(c0=='-'){
                                   stored=stored+"0.00000001";
                                }else{
                                    if(c0=='.'){
                                        stored=stored+"0";
                                    }
                                }
                            }else{
                                if(stored.length()==2){
                                    Character c0=stored.charAt(0);
                                    Character c1=stored.charAt(1);
                                    if((c0=='-')&&(c1=='.')){
                                        stored=stored+"000000001";
                                    }
                                }
                            }
                            Double b, a = Double.parseDouble("" + stored);
                            if(a<0){
                                a=Double.NaN;
                            }
                            b = Math.sqrt(a);
                            current.setText("" + b);
                        }else{
                            current.setText("");
                        }
                    }
                }
        );
        //square
        Button square=(Button)findViewById(R.id.square);
        square.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored = current.getText();
                        if(stored.length()>0) {
                            if(stored.length()==1){
                                Character c0=stored.charAt(0);
                                if(c0=='-'){
                                    stored=stored+"0.0";
                                }else{
                                    if(c0=='.'){
                                        stored=stored+"0";
                                    }
                                }
                            }else{
                                if(stored.length()==2){
                                    Character c0=stored.charAt(0);
                                    Character c1=stored.charAt(1);
                                    if((c0=='-')&&(c1=='.')){
                                        stored=stored+"0";
                                    }
                                }
                            }
                            Double b, a = Double.parseDouble("" + stored);
                            b = a*a;
                            current.setText("" + b);
                        }else{
                            current.setText("");
                        }
                    }
                }
        );
        //reciprocal
        Button reciprocal=(Button)findViewById(R.id.reciprocal);
        reciprocal.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        CharSequence stored = current.getText();
                        if(stored.length()>0) {
                            if(stored.length()==1){
                                Character c0=stored.charAt(0);
                                if(c0=='-'){
                                    stored=stored+"0.0";
                                }else{
                                    if(c0=='.'){
                                        stored=stored+"0";
                                    }
                                }
                            }else{
                                if(stored.length()==2){
                                    Character c0=stored.charAt(0);
                                    Character c1=stored.charAt(1);
                                    if((c0=='-')&&(c1=='.')){
                                        stored=stored+"0";
                                    }
                                }
                            }
                            Double b, a = Double.parseDouble("" + stored);
                            b = 1.0/a;
                            current.setText("" + b);
                        }else{
                            current.setText("");
                        }
                    }
                }
        );

    }
}
//Here is the end of my newly developed Android Calculator App.
//Feeling happy after completing it.