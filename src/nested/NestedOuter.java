package nested;

public class NestedOuter {
    private static int outClassValue = 3;
    private int outInstanceValue = 2;

    static class Nested{

        private int nestedInstanceValue = 1;
        // 자신의 맴버에 접근
        public void print(){
            System.out.println(nestedInstanceValue);

            // 바깥 클래스 인스턴스 맴버에는 접근할 수 없다.
            //System.out.println(outInstaceValue);

            // 바깥 클래스의 클래스 맴버에는 접근할 수 있다 이 때는 priavte도 접근할 수 있음
            System.out.println(outClassValue);
        }
    }
}
