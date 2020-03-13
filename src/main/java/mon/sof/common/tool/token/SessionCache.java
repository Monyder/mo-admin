package mon.sof.common.tool.token;

public class SessionCache {
    private static ThreadLocal<Object> threadLocal = new ThreadLocal<>();

    public static <T extends Object> void put(T t){
        threadLocal.set(t);
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(){
        return (T) threadLocal.get();
    }

    public static void remove() {
        threadLocal.remove();
    }


}
