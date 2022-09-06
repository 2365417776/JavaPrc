package com.cn.prc_3;

import org.junit.Test;

public class ExceptionPrc {
    @Test
    public void test01() throws ArithmeticException{
        try{
            int result = 12 / 0;
        }catch (Exception e){
            throw e;
        }finally {
            System.out.println("异常处理结束");
        }
    }
    @Test
    public void test02() throws BombException{
        //手动抛出一个自定义异常
        throw new BombException("吃得太饱了");
    }
}
//自定义异常
class BombException extends Exception{
    public BombException(String message){
        super(message);
    }
}

