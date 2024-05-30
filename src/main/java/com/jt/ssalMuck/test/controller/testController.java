package com.jt.ssalMuck.test.controller;

import com.jt.ssalMuck.test.service.TestService;
import com.jt.ssalMuck.test.service.testServiceImpl;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@Slf4j
@RequiredArgsConstructor
public class testController {

//    private final TestService iTestIn;
//    private final TestService iTestIn2;
//    @Qualifier("testServiceImpl2")
//    private final TestService iTestIn2;

    //롬북 어노테이션 사용시 선언을 해당 구현체 명과 맞추면 각각의 구현체 사용가능
    private final TestService testServiceImpl;
    private final TestService testServiceImpl2;

    TestService ts1 = new testServiceImpl();

    //    @Autowired
//    public LoginController(TestService testServiceImpl, TestService testServiceImpl2) {
//        this.ts1 = testServiceImpl;
//        this.ts2 = testServiceImpl2;
//
//    }
    @ApiOperation(value="테스트", notes="테스트")
    @PostMapping("/test")
    public ResponseEntity test(){


        ts1.test();
        testServiceImpl.test();
        testServiceImpl2.test();



        return new ResponseEntity<>(HttpStatus.OK);
    }

}

