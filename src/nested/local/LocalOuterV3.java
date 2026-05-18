package nested.local;

import java.lang.reflect.Field;

public class LocalOuterV3 {

    private int outInstanceVar = 3;

    public Printer process(final int paramVar){
        final int localVar = 1; // 지역변수는 스택 영역이 종료되는 순간 함께 제거된다.
        // 지역 변수는 절대로 중간에 변경되어서는 안되는 final 변수이다. 그런데 왜 중간에 값을 중간에 바꾸면 안되는 것일까?

        // 지역 클래스 생성 (인터페이스도 사용하는 것이 가능하다)
        class LocalPrinter implements Printer{
            int value = 0;

            @Override
            public void print() {
                System.out.println("value = " + value);

                // 인스턴스는 지역 변수보다 더 오래 살아남는다.
                System.out.println("localVar = " + localVar);
                System.out.println("paramVar = " + paramVar);
                System.out.println("outInstanceVar = " + outInstanceVar);
            }
        }

        LocalPrinter localPrinter = new LocalPrinter();
        //localPrinter.print();
        return localPrinter;
    }

    public static void main(String[] args) {
        LocalOuterV3 localOuterV3 = new LocalOuterV3();
        Printer printer = localOuterV3.process(2);
        // Printer.print()를 나중에 실행한다. process()의 스택에서 제거된 이후에 실행한다.
        printer.print();

        // 추가
        System.out.println("필드 확인");
        Field[] declaredField = printer.getClass().getDeclaredFields();
        for (Field field : declaredField) {
            System.out.println("field = " + field);
        }
    }
}
