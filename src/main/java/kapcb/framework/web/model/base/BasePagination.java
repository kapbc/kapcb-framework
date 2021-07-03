package kapcb.framework.web.model.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import kapcb.framework.web.constants.enums.LongPool;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * <a>Title: BasePagination </a>
 * <a>Author: Kapcb <a>
 * <a>Description:  <a>
 *
 * @author Kapcb
 * @version 1.0.0
 * @date 2021/7/3 13:46
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "分页请求参数", description = "分页请求参数")
public class BasePagination implements Serializable {

    @ApiModelProperty(value = "页数(默认值为1)", required = true)
    private long pageNum = LongPool.ONE.value();

    @ApiModelProperty(value = "每页显示条数(默认值为10)", required = true)
    private long pageSize = LongPool.TEN.value();
}