package io.github.dunwu.leetcode.common;

/**
 * A tree can be defined recursively (locally) as a collection of nodes (starting at a root node), where each node is a
 * data structure consisting of a value, together with a list of nodes (the "children"), with the constraints that no
 * node is duplicated. A tree can be defined abstractly as a whole (globally) as an ordered tree, with a value assigned
 * to each node.
 * <p>
 *
 * @author Justin Wetherell <phishman3579@gmail.com>
 * @see <a href="https://en.wikipedia.org/wiki/Tree_(data_structure)">Tree (Wikipedia)</a>
 * <br>
 */
public interface ITree<T> {

    /**
     * Add value to the tree. Tree can contain multiple equal values.
     *
     * @param value to add to the tree.
     * @return True if successfully added to tree.
     */
    boolean add(T value);

    /**
     * Remove first occurrence of value in the tree.
     *
     * @param value to remove from the tree.
     * @return T value removed from tree.
     */
    T remove(T value);

    /**
     * Clear the entire stack.
     */
    void clear();

    /**
     * Does the tree contain the value.
     *
     * @param value to locate in the tree.
     * @return True if tree contains value.
     */
    boolean contains(T value);

    /**
     * Get number of nodes in the tree.
     *
     * @return Number of nodes in the tree.
     */
    int size();

    /**
     * Validate the tree according to the invariants.
     *
     * @return True if the tree is valid.
     */
    boolean validate();

    /**
     * Get Tree as a Java compatible Collection
     *
     * @return Java compatible Collection
     */
    java.util.Collection<T> toCollection();

}
