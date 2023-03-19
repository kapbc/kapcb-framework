package com.kapcb.common.result;

/**
 * <a>Title: IResultCode </a>
 * <a>Author: Kapcb <a>
 * <a>Description: IResultCode <a>
 *
 * @author Kapcb
 * @version 1.0
 * @date 2023/3/19 10:08
 * @since 1.0
 */
public interface IResultCode {

    /**
     * result message
     *
     * @return {@link String}
     */
    String msg();

    /**
     * result code
     *
     * @return int
     */
    int code();

}
