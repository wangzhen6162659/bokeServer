package com.admin.user.util;

import com.admin.user.content.TreeNode;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TreeUtil {
    /**
     * 递归查找子节点
     *
     * @param treeNodes
     * @return
     */
    public static <T extends TreeNode> T findChildren(T treeNode, List<T> treeNodes) {
        for (T it : treeNodes) {
            if (treeNode.getId().equals(it.getPId())) {
                if (treeNode.getChildren() == null) {
                    treeNode.setChildren(new ArrayList<T>());
                }
                treeNode.add(findChildren(it, treeNodes));
            }
        }
        return treeNode;
    }
    /**
     * 根据id递归查找子节点
     *
     * @param id
     * @param treeNodes
     * @param <T>
     * @return
     */
    public static <T extends TreeNode> T findChildren(String id, List<T> treeNodes) {
        T treeNode = null;
        for (T it : treeNodes) {
            if (it.getId().equals(id)) {
                treeNode = findChildren(it, treeNodes);
            }
        }
        return treeNode;
    }

    public static <T extends TreeNode> List<T> buildByRecursives(List<T> treeNodes) {
        List<T> trees = new ArrayList<>();

        List<Long> p_ids = treeNodes.stream().map(T::getId).collect(Collectors.toList());
        for (T baseNode : treeNodes) {
            if (!p_ids.contains(baseNode.getPId())) {
                trees.add(findChildren(baseNode, treeNodes));
            }
        }
        return trees;
    }
}
