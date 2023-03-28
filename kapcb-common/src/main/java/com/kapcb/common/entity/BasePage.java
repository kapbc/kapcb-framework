package com.kapcb.common.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * <a>Title: BasePage </a>
 * <a>Author: Kapcb <a>
 * <a>Description: BasePage <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 11:10
 * @since 1.0
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class BasePage implements Serializable {

    private static final long serialVersionUID = 2488682760132120314L;

    private long pageNum;

    private long pageSize;

}
