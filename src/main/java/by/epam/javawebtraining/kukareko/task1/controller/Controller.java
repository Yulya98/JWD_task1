package by.epam.javawebtraining.kukareko.task1.controller;

import by.epam.javawebtraining.kukareko.task1.model.container.Library;
import by.epam.javawebtraining.kukareko.task1.model.entity.Publication;
import by.epam.javawebtraining.kukareko.task1.model.logic.counter.PublicationCounter;
import by.epam.javawebtraining.kukareko.task1.model.logic.finder.PublicationFinder;
import by.epam.javawebtraining.kukareko.task1.model.logic.sorter.PublicationSorter;
import by.epam.javawebtraining.kukareko.task1.util.creator.PublicationCreator;
import by.epam.javawebtraining.kukareko.task1.view.StandardOutPublicationsRender;

/**
 * @author Yulya Kukareko
 * @version 1.0 16 Feb 2019
 */
public class Controller {
    public static void main(String[] args) {
        try {
            Library library = new Library(5);
            StandardOutPublicationsRender publicationsRender = new StandardOutPublicationsRender();

            for (int i = 0; i < library.getPublications().length; i++) {
                Publication publication1 = PublicationCreator.create();
                library.getPublications()[i] = publication1;
            }

            library.add(PublicationCreator.create());
            library.remove(2);

            PublicationSorter.sortedByRating(library.getPublications(), 0,
                    library.getPublications().length - 1);
            publicationsRender.messageRender("Sorting by rating: ");
            publicationsRender.renderArray(library.getPublications());

            PublicationSorter.sortedByCirculationAndPageCount(library.getPublications());
            publicationsRender.messageRender("Sorting by Circulation and page count: ");
            publicationsRender.renderArray(library.getPublications());

            PublicationFinder.findExtremumByRating(library.getPublications(), "ACK");
            publicationsRender.messageRender("Find extremum element by rating: ");
            publicationsRender.renderElement(PublicationFinder.findExtremumByRating(library.getPublications(),
                    "ACK"));

            PublicationFinder.findByExtremumFont(library.getPublications(), "ACK");
            publicationsRender.messageRender("Find extremum element by font: ");
            publicationsRender.renderElement(PublicationFinder.findExtremumByRating(library.getPublications(),
                    "DESC"));

            PublicationFinder.findByExtremumPageCount(library.getPublications(), "ACK");
            publicationsRender.messageRender("Find extremum element by page count: ");
            publicationsRender.renderElement(PublicationFinder.findExtremumByRating(library.getPublications(),
                    "ACK"));

            publicationsRender.messageRender("Find Publication by param: ");

            publicationsRender.renderElement(PublicationFinder.findByParam(library.getPublications(), 13, 10, 1));

            publicationsRender.messageRender("Books count = "
                    + checkCount(PublicationCounter.countBooks(library.getPublications())));

            publicationsRender.messageRender("Magazines count = "
                    + checkCount(PublicationCounter.countMagazines(library.getPublications())));

            publicationsRender.messageRender("Albums count = "
                    + checkCount(PublicationCounter.countAlbums(library.getPublications())));

        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private static String checkCount(int count){
        return count == -1 ? "Not found" : String.valueOf(count);
    }
}
