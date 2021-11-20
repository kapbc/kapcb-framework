package kapcb.framework.web.service;

import org.apache.poi.ss.formula.functions.T;

/**
 * <a>Title: IDozerService </a>
 * <a>Author: Kapcb <a>
 * <a>Description: IDozerService <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/20 16:52
 */
public interface IDozerService {

    /**
     * convert po to vo
     *
     * @param p     po
     * @param clazz Class<V>
     * @param <V>   <V>
     * @param <P>   <p>
     * @return V
     */
    <V, P> V toVO(P p, Class<V> clazz);


}
