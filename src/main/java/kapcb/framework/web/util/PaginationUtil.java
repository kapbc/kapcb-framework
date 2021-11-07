//package kapcb.framework.web.util;
//
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import io.vavr.Tuple;
//import io.vavr.Tuple2;
//import io.vavr.Tuple4;
//import io.vavr.Tuple5;
//import org.springframework.lang.NonNull;
//import org.springframework.lang.Nullable;
//
//import java.util.List;
//
///**
// * <a>Title: PageUtil </a>
// * <a>Author: Kapcb <a>
// * <a>Description:  <a>
// *
// * @author Kapcb
// * @version 1.0.0
// * @date 2021/7/3 13:58
// */
//public class PaginationUtil {
//
//    private PaginationUtil() {
//    }
//
//    /**
//     * user tuple to assemble pagination params
//     *
//     * @param paginationTuple Tuple5<List<T>, Integer, Integer, Integer, Integer>
//     * @param <T>             <T>
//     * @return PageResult<T>
//     */
//    public static <T> BasePageResult<T> assemblePagination(@NonNull Tuple2<List<T>, Tuple4<Long, Long, Long, Long>> paginationTuple) {
//        Tuple4<Long, Long, Long, Long> paginationParamTuple4 = paginationTuple._2;
//        BasePageResult<T> pageResult = new BasePageResult<>();
//        pageResult.setRecords(paginationTuple._1);
//        pageResult.setTotal(paginationParamTuple4._1);
//        pageResult.setTotalPage(paginationParamTuple4._2);
//        pageResult.setPageSize(paginationParamTuple4._3);
//        pageResult.setPageNum(paginationParamTuple4._4);
//        return pageResult;
//    }
//
//    public static <T> BasePageResult<T> assemblePagination(@NonNull Tuple4<Long, Long, Long, Long> paginationTuple, List<T> resultList) {
//        BasePageResult<T> pageResult = new BasePageResult<>();
//        pageResult.setRecords(resultList);
//        pageResult.setTotal(paginationTuple._1);
//        pageResult.setTotalPage(paginationTuple._2);
//        pageResult.setPageSize(paginationTuple._3);
//        pageResult.setPageNum(paginationTuple._4);
//        return pageResult;
//    }
//
//    /**
//     * records : 查询出来的数据
//     * total : 返回数据的总数
//     * pages : 总页数
//     * size : 每页显示的条数
//     * current : 当前页
//     *
//     * @param page Page<T>
//     * @param <T>  <T>
//     */
//    @NonNull
//    private static <T> Tuple constructPagination(@NonNull Page<T> page) {
//        BasePageResult<T> basePageResult = new BasePageResult<>();
//        basePageResult.setTotal(page.getTotal());
//        basePageResult.setTotalPage(page.getPages());
//        basePageResult.setPageSize(page.getSize());
//        basePageResult.setPageNum(page.getCurrent());
//        return Tuple.of(page.getRecords(), basePageResult);
//    }
//
//    private static <T> Tuple constructPaginationParam(@NonNull Page<T> page) {
//        return Tuple.of(page.getRecords(), Tuple.of(page.getTotal(), page.getPages(), page.getSize(), page.getCurrent()));
//    }
//
//    @NonNull
//    private static <T> BasePageResult<T> directConstructPagination(@NonNull Page<T> page) {
//        BasePageResult<T> basePageResult = new BasePageResult<>();
//        basePageResult.setTotal(page.getTotal());
//        basePageResult.setTotalPage(page.getPages());
//        basePageResult.setPageSize(page.getSize());
//        basePageResult.setPageNum(page.getCurrent());
//        basePageResult.setRecords(page.getRecords());
//        return basePageResult;
//    }
//
//    /**
//     * get pagination records
//     *
//     * @param paginationTuple Tuple5<List<T>, Long, Long, Long, Long>
//     * @param <T>             <T>
//     * @return List<T>
//     */
//    @Nullable
//    private static <T> List<T> getPaginationRecords(@NonNull Tuple5<List<T>, Long, Long, Long, Long> paginationTuple) {
//        return paginationTuple._1;
//    }
//}
