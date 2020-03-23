package io.github.dunwu.leetcode.common;

/**
 * A list or sequence is an abstract data type that implements an ordered collection of values, where the same value may
 * occur more than once.
 * <p>
 *
 * @author Justin Wetherell <phishman3579@gmail.com>
 * @see <a href="https://en.wikipedia.org/wiki/List_(computing)">List (Wikipedia)</a> <br>
 */
public interface IList<T> {

    /**
     * Add value to list.
     *
     * @param value to add.
     * @return True if added.
     */
    boolean add(T value);

    /**
     * Remove value from list.
     *
     * @param value to remove.
     * @return True if removed.
     */
    boolean remove(T value);

    /**
     * Clear the entire list.
     */
    void clear();

    /**
     * Does the list contain value.
     *
     * @param value to search list for.
     * @return True if list contains value.
     */
    boolean contains(T value);

    /**
     * Size of the list.
     *
     * @return size of the list.
     */
    int size();

    /**
     * Validate the list according to the invariants.
     *
     * @return True if the list is valid.
     */
    boolean validate();

    /**
     * Get this List as a Java compatible List
     *
     * @return Java compatible List
     */
    java.util.List<T> toList();

    /**
     * Get this List as a Java compatible Collection
     *
     * @return Java compatible Collection
     */
    java.util.Collection<T> toCollection();

}
