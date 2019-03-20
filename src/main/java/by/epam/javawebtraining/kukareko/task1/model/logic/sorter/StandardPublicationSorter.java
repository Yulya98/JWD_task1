package by.epam.javawebtraining.kukareko.task1.model.logic.sorter;

import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.exception.technical.PublicationsEmptyException;

import java.util.Arrays;


/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class StandardPublicationSorter implements PublicationSorter {

    /*
    Sorted publications using Quick sort
    */
    @Override
    public Publication[] sortedByRating(Publication[] publications)
            throws PublicationsEmptyException {
        try {
            Publication[] publicationsSorted;

            publicationsSorted = Arrays.copyOf(publications, publications.length);
            sortedByRatingQuickSort(publicationsSorted, 0, publicationsSorted.length - 1);

            return publicationsSorted;
        } catch (NullPointerException ex) {
            throw new PublicationsEmptyException(ex);
        }
    }

    /*
    Sorted publications using Shell sort
     */
    @Override
    public Publication[] sortedByCirculationAndPageCount(Publication[] publications)
            throws PublicationsEmptyException {
        Publication[] publicationsSorted;

        try {
            publicationsSorted = Arrays.copyOf(publications, publications.length);
            Publication tmp;
            int j;
            int step = publicationsSorted.length;
            for (step /= 2; step > 0; step /= 2) {
                for (int i = step; i < publicationsSorted.length; i++) {
                    tmp = publicationsSorted[i];
                    for (j = i; j >= step; j -= step) {
                        if ((tmp.getPageCount() < publicationsSorted[j - step].getPageCount())
                                && (tmp.getCirculation() < publicationsSorted[j - step].getCirculation())) {
                            publicationsSorted[j] = publicationsSorted[j - step];
                        } else
                            break;
                    }
                    publicationsSorted[j] = tmp;
                }
            }
            return publicationsSorted;
        } catch (NullPointerException ex) {
            throw new PublicationsEmptyException(ex);
        }
    }

    /*
    Sorted publications using Selection sort
     */
    @Override
    public Publication[] sortedByPageCount(Publication[] publications)
            throws PublicationsEmptyException {
        try {

            Publication[] publicationsSorted = Arrays.copyOf(publications, publications.length);

            for (int i = 0; i < publicationsSorted.length; i++) {
                int iMin = i;
                for (int j = i + 1; j < publicationsSorted.length; j++) {
                    if (publicationsSorted[iMin].getPageCount() > publicationsSorted[j].getPageCount())
                        iMin = j;
                }
                if (iMin != i) {
                    Publication c = publicationsSorted[iMin];
                    publicationsSorted[iMin] = publicationsSorted[i];
                    publicationsSorted[i] = c;
                }
            }
            return publicationsSorted;
        } catch (NullPointerException ex) {
            throw new PublicationsEmptyException(ex);
        }
    }

    /*
    Sorted publications using Insertion sort
     */
    @Override
    public Publication[] sortedByFont(Publication[] publications)
            throws PublicationsEmptyException {
        try {
            Publication[] publicationsSorted = Arrays.copyOf(publications, publications.length);

            for (int i = 0; i < publicationsSorted.length; i++) {
                for (int j = i; j > 0 &&
                        (publicationsSorted[j - 1].getFont() > publicationsSorted[j].getFont()); j--) {
                    Publication elem = publicationsSorted[j];
                    publicationsSorted[j] = publicationsSorted[j - 1];
                    publicationsSorted[j - 1] = elem;
                }
            }
            return publicationsSorted;
        } catch (NullPointerException ex) {
            throw new PublicationsEmptyException(ex);
        }
    }

    private void sortedByRatingQuickSort(Publication[] publications, int first, int last) {
        Publication p = publications[(last - first) / 2 + first];
        Publication temp;
        int i = first, j = last;

        while (i <= j) {
            while (publications[i].getRating() < p.getRating() && i <= last) i++;
            while (publications[j].getRating() > p.getRating() && j >= first) j--;
            if (i <= j) {
                temp = publications[i];
                publications[i] = publications[j];
                publications[j] = temp;
                i++;
                j--;
            }
        }
        if (j > first) sortedByRatingQuickSort(publications, first, j);
        if (i < last) sortedByRatingQuickSort(publications, i, last);
    }
}



