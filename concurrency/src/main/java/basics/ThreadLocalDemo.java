package basics;

public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<String>() {
            @Override
            protected String initialValue() {
                return "Hello World";
            }

            @Override
            public String get() {
                return "Hello World";
            }
        };
    }
}
