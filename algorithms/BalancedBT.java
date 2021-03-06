
public class BalancedBT {

	// recursive
    public static boolean isBalanced(TreeNode root) {
        return maxDepth(root) != -1;
    }
    
    private static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        if (left == -1 || right == -1 || Math.abs(left - right) > 1) {
            return -1;
        }
        return Math.max(left, right) + 1;
    }
	
	// unit test
	public static void main(String[] args) {
		TreeNode a = new TreeNode(1);
		TreeNode b = new TreeNode(2);
		TreeNode c = new TreeNode(3);
		TreeNode d = new TreeNode(4);
		TreeNode e = new TreeNode(5);
		TreeNode f = new TreeNode(6);
		a.left = b;
		a.right = c;
		b.left = d;
		b.right = e;
		d.left = f;
		System.out.println(isBalanced(a));
	}
}
