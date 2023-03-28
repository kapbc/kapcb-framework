package com.kapcb.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * <a>Title: BaseTree </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BaseTree <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 11:11
 * @since 1.0
 */
public class BaseTree<T> implements Tree<Integer, T> {

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


    @Override
    public Integer id() {
        return this.id;
    }

    @Override
    public Integer parentId() {
        return this.parentId;
    }

    @Override
    public List<T> children() {
        return this.children;
    }

}
