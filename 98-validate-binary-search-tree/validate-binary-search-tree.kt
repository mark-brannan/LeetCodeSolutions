/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 * class TreeNode(var `val`: Int) {
 *     var left: TreeNode? = null
 *     var right: TreeNode? = null
 * }
 */
class Solution {
    fun isValidBST(root: TreeNode?): Boolean = isValid(root, null, null)

    internal fun isValid(root: TreeNode?, min: Int?, max: Int?): Boolean {
        System.out.print("Comparing ${root?.`val`} with $min and $max...")
        return when {
            root == null -> true.also { System.out.println("null $it")}
            min != null && root.`val` <= min -> false
            max != null && root.`val` >= max -> false
            else -> {
                System.out.println("Ok.  Comparing subtrees...")
                isValid(root.left, min, root.`val`) &&
                isValid(root.right, root.`val`, max)
            }
        }
    }
}