package com.ssalMuck;

import com.ssalMuck.Dto.MemberDTO;
import com.ssalMuck.Dto.testDTO;
import com.ssalMuck.Entity.Member;
import com.ssalMuck.service.Board2Service;
import com.ssalMuck.service.MemberService;
import com.ssalMuck.service.SingletonService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.mockito.internal.matchers.InstanceOf;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;


@SpringBootTest
@AllArgsConstructor
public class test {

    private final Board2Service board2Service;

    @Test
    public void test(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();
        //SingletonService singletonService3 = new SingletonService();
        System.out.println(singletonService1);
        System.out.println(singletonService2);


        AnnotationConfigApplicationContext appConfig = new AnnotationConfigApplicationContext();
        Board2Service service1 = null;
        Board2Service service2;
        System.out.println(System.identityHashCode(board2Service));
        System.out.println(System.identityHashCode(service1));

    }


    @Test
    public void testRamda() {
        Optional<String> optional;



    }

}
