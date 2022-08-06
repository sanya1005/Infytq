public class Solution {
    public ArrayList<ArrayList<Integer>> levelOrder(TreeNode root) {
        ArrayList<ArrayList<Integer>> result=new ArrayList<ArrayList<Integer>>(); 
        if(root==null) return result; 
        ArrayList<TreeNode> list=new ArrayList<TreeNode>();
        list.add(root);
        while(!list.isEmpty())
        {
            ArrayList<TreeNode> Tplist=new ArrayList<TreeNode>();
            ArrayList<Integer> level=new ArrayList<Integer>();
            while(!list.isEmpty())
            {
                TreeNode node=list.remove(0);
                level.add(node.val);
                if(node.left!=null) Tplist.add(node.left);
                if(node.right!=null) Tplist.add(node.right);
            }
            result.add(level);
            list=Tplist; 
        }
        return result; 
    }
}
