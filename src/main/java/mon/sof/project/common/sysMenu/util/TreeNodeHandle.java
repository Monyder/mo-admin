package mon.sof.project.common.sysMenu.util;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.lang.tree.Tree;
import cn.hutool.core.lang.tree.TreeNode;
import cn.hutool.core.lang.tree.TreeNodeConfig;
import cn.hutool.core.lang.tree.TreeUtil;
import mon.sof.project.common.sysMenu.entity.SysMenu;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TreeNodeHandle {

    public static List<Tree<String>> handleMenu(List<SysMenu> list) {
        List<TreeNode<String>> nodeList = CollUtil.newArrayList();
        TreeNodeConfig treeNodeConfig = new TreeNodeConfig();
        treeNodeConfig.setDeep(3);
        for (SysMenu sysMenu : list) {
            TreeNode<String> treeNode = new TreeNode<>();
            treeNode.setId(String.valueOf(sysMenu.getId()));
            treeNode.setParentId(String.valueOf(sysMenu.getNodePid()));
            treeNode.setName(sysMenu.getNodeName());
            treeNode.setWeight(sysMenu.getRoderCode());
            HashMap<String, Object> hashMap = new HashMap<>();
            hashMap.put("nodePath", sysMenu.getNodePath());
            hashMap.put("nodeComponent", sysMenu.getNodeComponent());
            hashMap.put("nodeIconcls", sysMenu.getNodeIconcls());
            treeNode.setExtra(hashMap);
            nodeList.add(treeNode);
        }
        List<Tree<String>> build = TreeUtil.build(nodeList, "0", treeNodeConfig,
                (treeNode, tree) -> {
                    tree.setId(treeNode.getId());
                    tree.setParentId(treeNode.getParentId());
                    tree.setWeight(treeNode.getWeight());
                    tree.setName(treeNode.getName());
                    Map<String, Object> extra = treeNode.getExtra();
                    tree.putExtra("nodePath", extra.get("nodePath"));
                    tree.putExtra("nodeComponent", extra.get("nodeComponent"));
                    tree.putExtra("nodeIconcls", extra.get("nodeIconcls"));
                });
        return build;

    }
}
