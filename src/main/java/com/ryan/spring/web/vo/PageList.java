package com.ryan.spring.web.vo;

import java.util.List;

/**
 *
 * @param <T>
 */
public class PageList<T> {


    public PageList(Page page, List<T> list) {
        this.page = page;
        this.list = list;
    }

    private Page page;
    private List<T> list;

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
