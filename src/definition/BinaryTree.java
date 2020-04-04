/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: dbc2201
 *   Date: 27/02/20
 *   Time: 8:33 AM
 */

package definition;

import adt.BinaryTreeADT;

public class BinaryTree<E> implements BinaryTreeADT<E> {

    private Node<E> root;
    private int numberOfNodes = 0;
    private int height=0;

    public int getHeight() {
        return height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public int size() {
        return numberOfNodes;
    }

    private Node<E> addRecursive(Node<E> currentNode, E data) {
        if (currentNode == null) {
            return new Node<>(data);
        }
        else if ((Integer) data < (Integer) currentNode.getData()) {
            currentNode.leftChild = addRecursive(currentNode.getLeftChild(), data);
        } else   {
            currentNode.rightChild = addRecursive(currentNode.getRightChild(), data);
        }
        return currentNode;
    }

    public boolean containNodeRecursive(Node<E> currentNode, E data) {
        if (currentNode == null) {
            System.out.print("empty tree");
            return false;
        }
        if (data.equals(currentNode.getData())) {  //equals work for reference it actually compare hashcode.
            return true;
        }
        return (Integer) data < (Integer) currentNode.getData()
                ? containNodeRecursive(currentNode.getLeftChild(), data) : containNodeRecursive(currentNode.getLeftChild(), data);
    }


    @Override
    public boolean add(E data) {
        root = addRecursive(root, data);
        numberOfNodes++;
        return true;
    }

    private Node<E> deleteRecursive(Node<E> currentNode, E data) {
        if (currentNode == null) {
            return null;
        }
        if (data.equals(currentNode.getData())) {
            //case 1 : no children of the node to be delete
            if (currentNode.getLeftChild() == null && currentNode.getRightChild() == null) {
                return null;
            }
            // case 2 : only one child of the node to be deleted
            if (currentNode.getRightChild() == null) {
                return currentNode.getLeftChild();
            }
            if (currentNode.getLeftChild() == null) {
                return currentNode.getRightChild();
            }
            // case 3 : two children of the node to be deleted
            E smallestValue = findSmallest(currentNode.getRightChild());
            currentNode.data = smallestValue;
            currentNode.rightChild = deleteRecursive(currentNode.getRightChild(), smallestValue);
            return currentNode;
        }
        if ((Integer) data < (Integer) currentNode.getData()) {
            currentNode.leftChild = deleteRecursive(currentNode.leftChild, data);
        }
        currentNode.rightChild = deleteRecursive(currentNode.getRightChild(), data);
        return currentNode;

    }

    public E findSmallest(Node<E> root) {
        return ((root.getLeftChild() == null) ? root.getData() : findSmallest(root.getLeftChild()));
    }

    public void traversePerOrder(Node<E> currentNode) {
        if (currentNode == null) {
            visit(currentNode.getData());
            traversePerOrder(currentNode.getLeftChild());
            traversePerOrder(currentNode.getRightChild());
        }
    }

    public void traverseInOrder(Node<E> currentNode) {
        if (currentNode != null) {
            traverseInOrder(currentNode.getLeftChild());
            visit(currentNode.getData());
            traverseInOrder(currentNode.getRightChild());
        }
    }

    public void traversePostOrder(Node<E> currentNode) {
        if (currentNode != null) {
            traversePostOrder(currentNode.getLeftChild());
            traversePostOrder(currentNode.getRightChild());
            visit(currentNode.getData());
        }
    }

    private void visit(E data) {
        System.out.println(" " + data);
    }

    public void print(int choice) {
       traverseInOrder(root);
    }

    @Override
    public void delete(E data) {
        root = deleteRecursive(root, data);
    }
//    @Override
//    public boolean search(E data) {
//        containNodeRecursive();
//        return true;
//    }

    private static class Node<E> {
        private E data;
        private Node<E> leftChild;
        private Node<E> rightChild;

        public Node(E data) {
            this.data = data;
        }

        public E getData() {
            return data;
        }

        public Node<E> getLeftChild() {
            return leftChild;
        }

        public Node<E> getRightChild() {
            return rightChild;
        }

    }
}
