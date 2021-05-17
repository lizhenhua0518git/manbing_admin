package net.huayiyun.manbing.pojo.qo;

import lombok.Data;

@Data
public class PageQO {

    /**
     * 排序对象，对应的表字段名称
     */
//    private String sidx;

    /**
     * 排序方式，asc/desc
     */
//    private String sord;

    /**
     * 当前页
     */
    private int pageNo=1;

    /**
     * 每页显示条数
     */
    private int pageSize=10;
}
