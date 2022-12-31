package com.loto.hotsearch.service.snow;

/**
 * @author 蓝田_Loto
 */
public interface IdGenerator {
    /**
     * 下一个标识
     *
     * @return 下一个标识
     */
    long nextId();

    /**
     * 获取时间戳
     *
     * @param id 雪花标识
     * @return 时间戳
     */
    long getTime(long id);
}
