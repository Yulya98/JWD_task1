package by.epam.javawebtraining.kukareko.task1.model.collection.stack;

import by.epam.javawebtraining.kukareko.task1.model.collection.AbstractPublicationCollection;

import java.io.Serializable;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Objects;

/**
 * @author Yulya Kukareko
 * @version 1.0 06 Mar 2019
 */
public class StackLinkedListBasedCollection<T> extends AbstractPublicationCollection<T> implements StackCollection<T>, Serializable {

    private LinkedList<T> publications;

    public StackLinkedListBasedCollection() {
        publications = new LinkedList<T>();
    }

    public StackLinkedListBasedCollection(LinkedList<T> publications) {
        this.publications = publications;
    }

    @Override
    public boolean push(T publication) {
        return publications.add(publication);
    }

    @Override
    public T pop() {
        return publications.removeLast();
    }

    @Override
    public int size() {
        return publications.size();
    }

    @Override
    public void clear() {
        publications.clear();
    }

    @Override
    public Object[] toArray() {
        return publications.toArray();
    }

    @Override
    public Iterator iterator() {
        return publications.descendingIterator();
    }

    @Override
    public T peek() {
        return !isEmpty() ? publications.get(publications.size() - 1) : null;
    }

    @Override
    public StackLinkedListBasedCollection clone() {
        return new StackLinkedListBasedCollection((LinkedList<T>) publications.clone());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        StackLinkedListBasedCollection that = (StackLinkedListBasedCollection) o;
        return Objects.equals(publications, that.publications);
    }

    @Override
    public int hashCode() {
        return Objects.hash(publications);
    }

    @Override
    public String toString() {
        return "StackLinkedListBasedCollection{" +
                "publications=" + publications +
                '}';
    }
}
