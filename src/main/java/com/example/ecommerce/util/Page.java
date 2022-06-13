package com.example.ecommerce.util;

import java.io.Serializable;
import java.util.List;

public class Page<T> implements Serializable {
    private Integer limti;
    private Integer offset;
    private Integer total;
    private List<T> result;

    public Integer getLimti() {
        return limti;
    }

    public void setLimti(Integer limti) {
        this.limti = limti;
    }

    public Integer getOffset() {
        return offset;
    }

    public void setOffset(Integer offset) {
        this.offset = offset;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        this.result = result;
    }
}
