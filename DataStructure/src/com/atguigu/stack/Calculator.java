package com.atguigu.stack;

public class Calculator {
    public static void main(String[] args) {
        String expression = "7*2*2-5+1-5+3-4";
        //创建两个栈,数栈，符号栈
        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        //定义需要的相关变量
        int index = 0;
        int num1 = 0, num2 = 0;
        int oper = 0;
        int res = 0;
        char ch = ' ';
        String keepNum = "";
        while (true) {
            //先扫描得到expression中的每一个字符
            ch = expression.substring(index, index + 1).charAt(0);
            if (operStack.isOperation(ch)) {
                //如果是运算法，判断是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈有操作符，就进行比较，如果当前的操作符小于或等于栈中的操作符，就需要从数栈中pop出两个数
                    //再从符号栈中pop出一个符号，进行运算，得到结果，入数栈，然后将当前的操作符入符号栈
                    if (operStack.priority(ch) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        numStack.push(res);
                        operStack.push(ch);
                    } else {
                        operStack.push(ch);
                    }
                } else {
                    operStack.push(ch);
                }
            } else {
//                numStack.push(ch - 48);
                //当处理多位数时，需要向expression向后看一位，如果是数，就进行扫描，如果是符号才入栈
                //我们需要定义一个变量字符串，用于拼接

                //处理多位数
                keepNum += ch;

                //如果ch已经是expression最后一位，直接入栈
                if (index == expression.length() - 1) {
                    numStack.push(Integer.parseInt(keepNum));
                } else {
                    //判断下一个字符是不是数字，注意不是index++
                    if (operStack.isOperation(expression.substring(index + 1, index + 2).charAt(0))) {
                        //后一位是运算符，则入栈
                        numStack.push(Integer.parseInt(keepNum));
                        //重要的！！！！！ keepNum需要清空
                        keepNum = "";
                    }
                }

            }
            // index+1,并判断是否扫描到最后
            index++;
            if (index >= expression.length()) {
                break;
            }
        }

        //当表达式扫描完毕时，就顺序从数栈和符号栈中pop出相应数和符号，并运行
        while (true) {
            //如果符号栈为空，计算到最后结果,数栈中只有一个结果
            if (operStack.isEmpty()) {
                break;
            }
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            res = numStack.cal(num1, num2, oper);
            numStack.push(res);
        }
        System.out.printf("表达式%s = %d", expression, numStack.pop());

    }
}

//先创建一个栈,需要扩展功能
class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    private int top = -1;

    //构造器
    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[maxSize];
    }

    //返回栈顶但不出栈
    public int peek() {
        return stack[top];
    }

    //栈满
    public boolean isFull() {
        return top == maxSize - 1;
    }

    //栈空
    public boolean isEmpty() {
        return top == -1;
    }

    //入栈 - push
    public void push(int value) {
        //先判断栈是否为满
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        stack[top] = value;
    }

    //出栈
    public int pop() {
        if (isEmpty()) {
            throw new RuntimeException("Empty stack");
        }
        int value = stack[top];
        top--;
        return value;
    }

    //显示栈的情况[遍历栈]
    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有数据~~");
            return;
        }
        //需要从栈顶开始显示数据
        for (int i = top; i >= 0; i--) {
            System.out.printf("stack[%d]=%d\n", i, stack[i]);
        }
    }

    //返回运算符的优先级，程序员定的
//    优先级采用数字表示,数字越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //判断是不是一个运算符
    public boolean isOperation(char val) {
        return val == '*' || val == '/' || val == '+' || val == '-';
    }

    //计算方法
    public int cal(int num1, int num2, int oper) {
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            //注意顺序
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
                break;
            default:
                break;
        }
        return res;
    }

}



