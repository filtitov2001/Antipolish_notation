package com.company;

import java.util.Stack;

public class Calculating {
    private static int getPr(char simv){
        if(simv ==  '^')
            return 4;
        else if(simv == '*' || simv == '/')
            return 3;
        else if(simv == '-' || simv == '+')
            return 2;
        else if(simv == '(')
            return 1;
        else if(simv == ')')
            return 0;
        else
            return -1;
    };

    public static String StringToPolsk(String str){
        String strFinal="";
        Stack<Character> stack = new Stack<>();

        for(int i = 0; i < str.length(); i++){

            int priority=getPr(str.charAt(i));

            if(priority == -1)
                strFinal+=str.charAt(i);

            else if(priority == 1)
                stack.push(str.charAt(i));

            else if(priority > 1){
                strFinal+=' ';
                while(!stack.empty())
                {
                    if(getPr(stack.peek()) > priority)
                        strFinal+=stack.pop();
                    else break;
                }
                stack.push(str.charAt(i));
            }

            else if(priority == 0){
                strFinal+=' ';
                while(getPr(stack.peek()) != 1){
                    strFinal+=stack.pop();
                }
                stack.pop();
            }
        }
        while(!stack.empty())
            strFinal+=stack.pop();
        return strFinal;
    }

    public static double exchangeToDouble(String str){
        String operand = new String();
        boolean flag=false;
        Stack<Double> stack = new Stack<>();
        int i=0;
        for(i = 0; i < str.length(); i++){
            if(str.charAt(i) == ' ')
                continue;
            if (getPr(str.charAt(i)) == -1){
                while (str.charAt(i)!=' ' && getPr(str.charAt(i)) == -1)
                {
                    operand+= str.charAt(i);
                    i++;
                    if(i==str.length())
                        break;
                }
                i--;
                stack.push(Double.parseDouble(operand));
                operand=new String();
            }

            if(getPr(str.charAt(i)) > 1){
                double a=stack.pop();
                double b=stack.pop();
                if (str.charAt(i) == '+') stack.push(a+b);
                if (str.charAt(i) == '-') stack.push(b-a);
                if (str.charAt(i) == '*') stack.push(b*a);
                if (str.charAt(i) == '/') stack.push(b/a);
                if (str.charAt(i) == '^') stack.push(Math.pow(b,a));
            }
        }
        return stack.pop();
    }
}
