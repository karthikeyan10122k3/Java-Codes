package com.kar.practice.exercise.DataStructure.src.Tree.BinarySearchTree;

public class BinarySearchTree<T extends Comparable<T>> {

//  BinaryTreeNode Class
    public static class TreeNode<T>{
        final T val;
        private int height;
        TreeNode<T> left;
        TreeNode<T> right;

        public TreeNode(T val){
            this.val = val;
        }
    }

    public BinarySearchTree(){

    }

//  Getting Height Of the BinaryTreeNode
    public int getHeight(TreeNode<T> treeNode){
        if (treeNode == null){
            return  - 1;
        }
        return treeNode.height;
    }
//  Checking if Tree is Empty
    public boolean isEmpty(){
        return root == null;
    }

    private TreeNode<T> root;

//  Inserting Part

    // Inserting Individual Element
    public TreeNode<T> insert(T value) {
        root = insert(root, value);
        return root;
    }

    // Inserting as Array
    public TreeNode<T> insert(T[] inputArray){
        for (T value : inputArray) {
            if (value != null) {
                root = insert(root, value);
            }
        }
        return root;
    }

    // Inserting a Sorted Array
    public void insertSortedArray(T[] inpurArray){
        insertSortedArray(inpurArray,0,inpurArray.length - 1);
    }
    public void insertSortedArray(T[] inpurArray,int start,int end){
        if ( start > end){
            return;
        }
        int mid = ( start + end ) / 2;

        insert(inpurArray[mid]);
        insertSortedArray(inpurArray,start,mid - 1);
        insertSortedArray(inpurArray,mid + 1,end);

    }

    // Inserting element in a Tree Main Recursive Function
    private TreeNode<T> insert(TreeNode<T> treeNode, T value) {
        if (treeNode == null) {
            return new TreeNode<>(value);
        }

        int compare = value.compareTo(treeNode.val);
        if (compare < 0) {
            treeNode.left = insert(treeNode.left, value);
        } else if (compare > 0) {
            treeNode.right = insert(treeNode.right, value);
        }

        treeNode.height = Math.max(getHeight(treeNode.left), getHeight(treeNode.left)) + 1;

        return treeNode;
    }

//  Checking if A BinaryTreeNode is Balanced
    private boolean balanced(TreeNode<T> treeNode){
        if (treeNode == null){
            return true;
        }

        int height = Math.max(getHeight(treeNode.left), getHeight(treeNode.right));

        return  (height >= -1  && height <= 1 ) && balanced(treeNode.left) && balanced(treeNode.right) ;
    }

//  Displaying Tree Part
    public void displayTree() {
        displayTree(root, "", true);
    }

    private void displayTree(TreeNode<T> treeNode, String indent, boolean isRight) {
        if (treeNode == null) {
            return;
        }

        System.out.print(indent);

        if (isRight) {
            System.out.print("R----");
            indent += "     ";
        } else {
            System.out.print("L----");
            indent += "|    ";
        }

        System.out.println(treeNode.val);
        displayTree(treeNode.left, indent, false);
        displayTree(treeNode.right, indent, true);
    }

}
