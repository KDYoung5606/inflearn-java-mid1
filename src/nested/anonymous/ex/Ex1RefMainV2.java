package nested.anonymous.ex;

import java.util.Random;

public class Ex1RefMainV2 {
    public static void hello(Process process){
        System.out.println("프로그램 시작");
        // 코드 조각 실행
        process.run();
        // 코드 조각 종료
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {

        class sum implements Process{
            @Override
            public void run() {
                for (int j = 0; j < 3; j++) {
                    System.out.println("i = " + j);
                }
            }
        }

        class dice implements Process{
            @Override
            public void run() {
                int n = new Random().nextInt(6) + 1;
                System.out.println("주사위 = " + n);
            }
        }
        hello(new dice());
        hello(new sum());

    }

}
