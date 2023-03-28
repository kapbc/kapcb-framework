package com.kapcb.common.util;

import com.kapcb.common.result.PageResult;
import lombok.experimental.UtilityClass;
import org.apache.commons.collections.CollectionUtils;

import java.util.List;

/**
 * <a>Title: ResultUtil </a>
 * <a>Author: Kapcb <a>
 * <a>Description: ResultUtil <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 14:00
 * @since 1.0
 */
@UtilityClass
public class ResultUtil {

    public static <T, D> PageResult<T> restPage(List<T> data, PageResult<D> pageResult) {
        PageResult<T> restPageResult = new PageResult<>();
        if (CollectionUtils.isNotEmpty(data)) {
            restPageResult.setRecords(data);
            restPageResult.setTotal(pageResult.getTotal());
            restPageResult.setPageNum(pageResult.getPageNum());
            restPageResult.setPageSize(pageResult.getPageSize());
            restPageResult.setTotalPage(pageResult.getTotalPage());
        }
        return restPageResult;
    }

}
