package com.ssalMuck;

import com.ssalMuck.Dto.testDTO;
import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.*;
import java.util.stream.Stream;

@SpringBootTest
public class test {

    @Test
    public void test(){


        Integer[] arrInteger = new Integer[10];
        List<Integer> integersList1 = Arrays.asList(1,2,3);

        for(int i=0; i<arrInteger.length; i++){


            arrInteger[i] = i;
            System.out.println(arrInteger[i]);
        }

        System.out.println("arr : " + arrInteger);
        System.out.println(Arrays.toString(arrInteger));
        System.out.println(integersList1);

        List<Integer> integersList2 = Arrays.asList(arrInteger);
        System.out.println(arrInteger);
        System.out.println(integersList2);
        System.out.println("======================");


    }
}
