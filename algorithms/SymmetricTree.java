import java.util.LinkedList;
import java.util.Queue;

public class SymmetricTree {

	// recursive
    public static boolean isSymmetric(TreeNode root) {
        return helper(root, root);
    }
    
    private static boolean helper(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 != null && t2 != null && t1.val == t2.val) {
            return helper(t1.left, t2.right) && helper(t1.right, t2.left);
        }
        return false;
    }
    
    // iterative bfs
    public static boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> q1 = new LinkedList<TreeNode>();
        Queue<TreeNode> q2 = new LinkedList<TreeNode>();
        q1.offer(root);
        q2.offer(root);
        while (!q1.isEmpty() && !q2.isEmpty()) {
            TreeNode t1 = q1.poll();
            TreeNode t2 = q2.poll();
            if (t1 == null && t2 == null) {
                continue;
            }
            if (t1 == null || t2 == null || t1.val != t2.val) {
                return false;
            }
            q1.offer(t1.left);
            q1.offer(t1.right);
            q2.offer(t2.right);
            q2.offer(t2.left);
        }
        return true;
    }
    
	// unit test
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		System.out.println(isSymmetric2(a));

	}
	
}


