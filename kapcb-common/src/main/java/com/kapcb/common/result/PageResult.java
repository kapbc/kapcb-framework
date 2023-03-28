package com.kapcb.common.result;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * <a>Title: PageResult </a>
 * <a>Author: Kapcb <a>
 * <a>Description: PageResult <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 13:55
 * @since 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class PageResult<T> implements IPageResult<T>, Serializable {

    private static final long serialVersionUID = -3715342578619107421L;

    private long pageNum;

    private long pageSize;

    private long total;

    private long totalPage;

    private List<T> records;

}
