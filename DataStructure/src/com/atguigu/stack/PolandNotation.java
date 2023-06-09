package com.atguigu.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class PolandNotation {
    public static void main(String[] args) {
        /**
         //先创建一个逆波兰表达式,数字和符号采用空格隔开
         String suffixExpression = "4 5 * 8 - 60 + 8 2 / +";
         //1.先将“3 4 + 5 * 6 - ”放入ArrayList中
         //2.将ArrayList传递给一个方法，遍历ArrayList配合栈完成计算
         List<String> rpnList = getListString(suffixExpression);
         System.out.println("rpnList:" + rpnList);
         int res = calculate(rpnList);
         System.out.println("计算的结果="+res);
         */
        //完成将一个中缀表达式转换为一个后缀表达式
        //1. 1+((2+3)*4)-5 --> 1 2 3 + 4 * + 5 -
        //2. 因为直接对str进行操作，不方便，先将字符串中缀表达式转为对应的ArrayList
        //3. 将得到的中缀表达式对应的list --> 后缀表达式对应的list

        String expression = "1+((2+3)*4)-5";
        List<String> infixExpression = toInfixExpressionList(expression);
        System.out.println("中缀表达式：" + infixExpression);
        List<String> suffixExpressionList = parseSuffixExpressionList(toInfixExpressionList(expression));
        System.out.println("后缀表达式：" + suffixExpressionList);
        System.out.printf("expression = %d",calculate(suffixExpressionList));
    }

    public static List<String> parseSuffixExpressionList(List<String> ls) {
        //定义两个栈
        // 符号栈
        Stack<String> s1 = new Stack<String>();
        //存储中间结果的栈,因为s2这个栈，在整个转换过程中没有pop操作，而且后面我们还需要逆序操作
        //因此比较麻烦，这里就不用栈结构，直接使用List<String> s2
//        Stack<String> s2 = new Stack<String>();
        List<String> s2 = new ArrayList<String>();

        //遍历ls
        for (String item : ls) {
            //如果是一个数，加入到s2
            if (item.matches("\\d+")) {
                s2.add(item);
            } else if (item.equals("(")) {
                s1.push(item);
            } else if (item.equals(")")) {
                // 如果是右括号，则依次弹出s1栈顶的运算符，直到遇到左括号为止，此时将左括号丢弃
                while (!s1.peek().equals("(")) {
                    s2.add(s1.pop());
                }
                s1.pop();
                //将（弹出s1栈，消除小括号
            } else {
                //当item的优先级小于等于栈底运算符,将s1的栈顶的运算符弹出加入到s2中
                //我们缺少一个比较优先级的方法
                while (s1.size() != 0 && Operation.getValue(s1.peek()) >= Operation.getValue(item)) {
                    s2.add(s1.pop());
                }
                // 还需要将item压入栈
                s1.push(item);
            }
        }
        //将s1中剩余的压入s2中
        while (s1.size() != 0) {
            s2.add(s1.pop());
        }
        return s2;
    }

    /**
     * 将中缀表达式 字符串s转成对应的list
     */
    public static List<String> toInfixExpressionList(String s) {
//        定义一个List，存放中缀表达式，对应的内容
        List<String> ls = new ArrayList<String>();
//        这是一个指针，用于遍历 中缀表达式的内容
        int i = 0;
//        对多位数的拼接
        String str = "";
//        每遍历到一个字符，就放入到c
        char c;
        do {
            //如果c是非数字，就需要加入到ls
            if ((c = s.charAt(i)) < 48 || (c = s.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else {
                //如果是一个数，需要考虑多位数的问题
                str = "";
                while (i < s.length() && s.charAt(i) >= 48 && s.charAt(i) <= 57) {
                    str += c;
                    i++;
                }
                ls.add(str);
            }
        } while (i < s.length());
        return ls;
    }


    /**
     * 将一个逆波兰表达式，一次将数据和运算符放入Arraylist中
     */
    public static List<String> getListString(String suffixExpression) {
        //将suffixExpression分割
        String[] split = suffixExpression.split(" ");
        List<String> list = new ArrayList<String>();
        for (String ele : split) {
            list.add(ele);
        }
        return list;
    }

    //完成对逆波兰表达式的运算
    public static int calculate(List<String> ls) {
        //只需要一个栈即可
        Stack<String> stack = new Stack<>();
        //遍历ls
        for (String item : ls) {
            //使用正则表达式来取出数
            if (item.matches("\\d+")) {
                //匹配的是多位数
                //入栈
                stack.push(item);
            } else {
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0;
                if (item.equals("+")) {
                    res = num1 + num2;
                } else if (item.equals("-")) {
                    res = num1 - num2;
                } else if (item.equals("*")) {
                    res = num1 * num2;
                } else if (item.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                //把res入栈
                stack.push("" + res);
            }
        }
        //把最后结果输出
        return Integer.parseInt(stack.pop());
    }

}

/**
 * 编写一个类 Operation 可以返回一个运算符 对应的优先级
 */
class Operation {
    private static int ADD = 1;
    private static int SUB = 1;
    private static int MUL = 2;
    private static int DIV = 2;

    //返回对应的优先级数字
    public static int getValue(String operation) {
        int result = 0;
        switch (operation) {
            case "+":
                result = ADD;
                break;
            case "-":
                result = SUB;
                break;
            case "*":
                result = MUL;
                break;
            case "/":
                result = DIV;
                break;
            default:
                break;
        }
        return result;
    }
}