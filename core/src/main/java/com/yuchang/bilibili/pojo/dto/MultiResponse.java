package com.yuchang.bilibili.pojo.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class MultiResponse<T> extends Response {

    private Collection<T> data;

    public List<T> getData() {
        if (null == data) {
            return Collections.emptyList();
        }
        if (data instanceof List) {
            return (List<T>) data;
        }
        return new ArrayList<>(data);
    }

    public boolean isEmpty() {
        return data == null || data.isEmpty();
    }

    public boolean isNotEmpty() {
        return !isEmpty();
    }

    public static <T> MultiResponse<T> of(Collection<T> data) {
        MultiResponse<T> response = new MultiResponse<>();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

}
