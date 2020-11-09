package ksubaka.abstracts;

import org.springframework.aop.framework.Advised;
import org.springframework.aop.support.AopUtils;

/**
 * Created by jpawar on 11/9/2020.
 */
public abstract class AbstractKsubakaTest {

    public <T> T getTargetObject(Object proxy) {
        try {
            // Need to check both proxy types.
            if (AopUtils.isJdkDynamicProxy(proxy) || AopUtils.isCglibProxy(proxy)) {
                return (T) ((Advised) proxy).getTargetSource().getTarget();
            } else {
                return (T) proxy;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
