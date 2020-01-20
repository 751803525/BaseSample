package lee.personal.base;


import androidx.annotation.NonNull;

/**
 * Created on 2020/1/20 14:59
 * 单例类
 *
 * @author LEE
 */
public class Instance {
    private static Instance instance;
@NonNull
    public static Instance getInstance() {
        if (instance == null) {
            synchronized (Instance.class) {
                if (instance == null) {
                    instance = new Instance();
                }
            }
        }
        return instance;
    }
}
