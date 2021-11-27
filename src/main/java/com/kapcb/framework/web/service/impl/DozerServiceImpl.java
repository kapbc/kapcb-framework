package com.kapcb.framework.web.service.impl;

import com.kapcb.framework.common.page.IPageResult;
import com.kapcb.framework.common.page.PageResult;
import com.kapcb.framework.common.util.PageResultUtil;
import com.kapcb.framework.web.service.IDozerService;
import org.apache.commons.collections.CollectionUtils;
import org.dozer.Mapper;
import org.springframework.context.annotation.Lazy;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.lang.reflect.Array;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * <a>Title: DozerServiceImpl </a>
 * <a>Author: Kapcb <a>
 * <a>Description: DozerServiceImpl <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/11/20 16:52
 */
@Lazy
@Component
public class DozerServiceImpl implements IDozerService {

    @Resource
    private Mapper mapper;

    @Override
    public <V, P> V toVO(P p, @NonNull Class<V> clazz) {
        return Objects.nonNull(p) ? this.mapper.map(p, clazz) : null;
    }

    @Override
    public <V, P> List<V> toVOList(List<P> p, @NonNull Class<V> clazz) {
        return CollectionUtils.isNotEmpty(p) ? p.stream().map(e -> this.mapper.map(e, clazz)).collect(Collectors.toList()) : null;
    }

    @Override
    public <V, P> IPageResult<V> toPage(@NonNull PageResult<P> pageResult, @NonNull Class<V> clazz) {
        List<P> records = pageResult.getRecords();
        List<V> result = null;
        if (CollectionUtils.isNotEmpty(records)) {
            result = toVOList(records, clazz);
        }
        return PageResultUtil.restPage(result, pageResult);
    }

    @Override
    public <V, P> V[] toArray(P[] p, Class<V> clazz) {
        if (Objects.isNull(p)) {
            return null;
        }
        V[] resultArray = (V[]) Array.newInstance(clazz, p.length);
        for (int i = 0; i < p.length; i++) {
            resultArray[i] = this.mapper.map(p[i], clazz);
        }
        return resultArray;
    }
}
