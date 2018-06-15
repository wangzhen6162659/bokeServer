package com.admin.user.content;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class TreeNode<T> {
    protected Long id;
    protected Long pId;
    protected List<T> children = new ArrayList<>();

    @JsonIgnore
    public void add(T node) {
        children.add(node);
    }
}
