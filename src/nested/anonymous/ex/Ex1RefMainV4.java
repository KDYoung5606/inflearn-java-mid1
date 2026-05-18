package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV4 {
    public static void hello(Process process){
        System.out.println("프로그램 시작");
        process.run();
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        // 익명클래스 --> 람다 : 함수를 인자로 넘길 수 있는 방법
        hello(() -> {
            for (int j = 0; j < 3; j++) {
                System.out.println("i = " + j);
            }
        });


        // 익명클래스
        hello(() -> {
            int n = new Random().nextInt(6) + 1;
            System.out.println("주사위 = " + n);
        });
    }
}
