/*
 *   Created by IntelliJ IDEA Ultimate, 2020
 *   User: dbc2201
 *   Date: 27/02/20
 *   Time: 8:34 AM
 */

package main;

import definition.BinaryTree;

public class Main {
    public static void main(String[] args) {
        BinaryTree<Integer> tree = new BinaryTree();
        tree.add(2);
        tree.add(8);
        tree.add(5);
        tree.add(6);
        tree.add(10);
        tree.add(7);
        tree.delete(6);
        tree.print(1);

    }
}
