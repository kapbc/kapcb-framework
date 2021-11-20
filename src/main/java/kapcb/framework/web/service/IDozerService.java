package kapcb.framework.web.service;

import com.kapcb.framework.common.page.IPageResult;
import com.kapcb.framework.common.page.PageResult;

import java.util.List;

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

    /**
     * convert po list to vo list
     *
     * @param p     po
     * @param clazz Class<V>
     * @param <V>   <V>
     * @param <P>   <p>
     * @return List<V>
     */
    <V, P> List<V> toVOList(List<P> p, Class<V> clazz);

    /**
     * convert page result
     *
     * @param pageResult PageResult<P>
     * @param clazz      Class<V>
     * @param <V>        <V>
     * @param <P>        <p>
     * @return PageResult<V>
     */
    <V, P> IPageResult<V> toPage(PageResult<P> pageResult, Class<V> clazz);

    /**
     * convert to array
     *
     * @param p     p
     * @param clazz Class<V>
     * @param <V>   <V>
     * @param <P>   <p>
     * @return V[]
     */
    <V, P> V[] toArray(P[] p, Class<V> clazz);

}
