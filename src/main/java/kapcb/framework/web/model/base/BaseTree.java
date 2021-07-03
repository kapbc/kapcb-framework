package kapcb.framework.web.model.base;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: BaseTree </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:51
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class BaseTree<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * node id
     */
    private Integer id;

    /**
     * parent node id, if parentId's value is 0 the node must be parent node
     */
    private Integer parentId;

    /**
     * children node
     */
    private List<T> children = new ArrayList<>();
}