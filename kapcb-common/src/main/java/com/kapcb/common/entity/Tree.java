package com.kapcb.common.entity;

import java.util.List;

/**
 * <a>Title: Tree </a>
 * <a>Author: Kapcb <a>
 * <a>Description: Tree <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 11:11
 * @since 1.0
 */
public interface Tree<P, T> {

    /**
     * get current node id
     *
     * @return current tree node id
     */
    P id();

    /**
     * get parent node id
     *
     * @return parent node id
     */
    P parentId();

    /**
     * get children nodes
     *
     * @return children nodes element
     */
    List<T> children();

}
