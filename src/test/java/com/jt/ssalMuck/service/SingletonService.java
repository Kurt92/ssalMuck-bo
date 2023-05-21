package com.jt.ssalMuck.service;

public class SingletonService {
    // 1. static 영역에 객체를 딱 1개만 생성한다.
    private static final SingletonService instance = new SingletonService();

    // 2. static method를 통해서만 객체를 생성하도록 한다.
    public static SingletonService getInstance() {
        return instance;
    }

    // 3. private 생성자를 통해서 외부에서 new로 객체생성하는 것을 막는다.
    private SingletonService(){ }

}
