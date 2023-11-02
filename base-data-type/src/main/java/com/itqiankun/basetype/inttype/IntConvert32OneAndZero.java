package com.itqiankun.basetype.inttype;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author: ma_qiankun
 * @date: 2023/10/30
 **/
@Slf4j
public class IntConvert32OneAndZero {
    @Test
    public void it_qk(){
        System.out.println(intToBinary32(-1, 32));
        System.out.println(intToBinary32(0, 32));
        System.out.println(intToBinary32(1, 32));
        System.out.println(intToBinary32(2, 32));
        System.out.println(intToBinary32(3, 32));



        System.out.println(intToBinary32(-1 << 29, 32));
        System.out.println(intToBinary32(0 << 29, 32));
        System.out.println(intToBinary32(1 << 29, 32));
        System.out.println(intToBinary32(2 << 29, 32));
        System.out.println(intToBinary32(3 << 29, 32));
    }

    @Test
    public void it_qk_two(){
        System.out.println(intToBinary32((1<<29)-1, 32));
    }
    @Test
    public void it_qk_three(){
        System.out.println(intToBinary32((1<<29)-1, 32));
        System.out.println(intToBinary32(1<<29-1, 32));
        System.out.println(intToBinary32(1<<28, 32));
    }



    @Test
    public void it_qk_six(){
        System.out.println(intToBinary32(0 << 29, 32));
        System.out.println(intToBinary32(-1 << 29, 32));
        System.out.println(intToBinary32((1 << 29) - 1, 32));
    }

    @Test
    public void it_qk_five(){
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < 31; i++) {
            stringBuffer.append("1");
        }
        System.out.println(stringBuffer.toString());
    }

    @Test
    public void it_qk_four(){
        final AtomicInteger ctl = new AtomicInteger(ctlOf(-1 << 29, 0));
        System.out.println(ctl.get());
        System.out.println(intToBinary32(ctl.get(), 32));
    }

    private  int ctlOf(int rs, int wc) { return rs | wc; }



    @Test
    public void it_qk_1(){
        System.out.println( (1 << 29) - 1);
        System.out.println(intToBinary32( (1 << 29) - 1, 32));
    }

    @Test
    public void it_qk_2(){
        System.out.println(intToBinary32( - 1, 32));
        System.out.println(intToBinary32( 0, 32));
        System.out.println(intToBinary32( 3<<29, 32));
        System.out.println(3<<29);
    }
    @Test
    public void it_qk_3(){
        System.out.println(intToBinary32( - 1, 32));
        System.out.println(intToBinary32( 0, 32));
        System.out.println(intToBinary32( 3<<29, 32));
        System.out.println(3<<29);
    }

    public  String intToBinary32(int i, int bitNum){
        String binaryStr = Integer.toBinaryString(i);
        while(binaryStr.length() < bitNum){
            binaryStr = "0"+binaryStr;
        }
        return binaryStr;
    }

}
