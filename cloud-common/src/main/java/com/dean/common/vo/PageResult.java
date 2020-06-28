package com.dean.common.vo;

import java.io.Serializable;
import java.util.List;

/**
 * @version 1.0
 * @Author Dean
 * @Date 2019/7/26 16:47
 * 自定义分页结果展示类
 */
public class PageResult<T> implements Serializable{
    //总条数
    private Long total;
    //总页数
    private Long totalPage;
    //每页展示的内容
    private List<T> items;

    public PageResult() {
    }

    public PageResult(Long total, Long totalPage, List<T> items) {
        this.total = total;
        this.totalPage = totalPage;
        this.items = items;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Long getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(Long totalPage) {
        this.totalPage = totalPage;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }
}
