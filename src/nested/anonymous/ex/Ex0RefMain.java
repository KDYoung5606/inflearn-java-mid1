package nested.anonymous.ex;

// 변하는 부분과 변하지 않는 부분을 구분하는 것이 재사용성의 차이가 난다.
public class Ex0RefMain {
    public static void helloString(String str){
        System.out.println("프로그램 시작");
        System.out.println(str);
        System.out.println("프로그램 종료");
    }

    public static void main(String[] args) {
        helloString("Hello Java");
        helloString("Hello Spring");
    }
}
