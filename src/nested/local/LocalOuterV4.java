package nested.local;

public class LocalOuterV4 {

    private int outInstanceVar = 3;

    public Printer process(final int paramVar){
        final int localVar = 1;

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
        // 만약에 localVar의 값을 변경하면 다시 캡쳐해야하나? --> 컴파일 오류가 발생한다. --> 대부분 생성하는 순간에 캡쳐를 한다. --> 이러면 동기화
        // 문제가 발생한다. 바꿀 수 있지만 발생할 수 있는 문제들이 너무 많기 때문에 그냥 변경하지 못하도록 막는다.
        return localPrinter;
    }

    public static void main(String[] args) {
        LocalOuterV4 localOuterV3 = new LocalOuterV4();
        Printer printer = localOuterV3.process(2);
        // Printer.print()를 나중에 실행한다. process()의 스택에서 제거된 이후에 실행한다.
        printer.print();
    }
}
