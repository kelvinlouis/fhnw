package ch.fhnw.oop2.starwars;

/**
 * the presentation model of the application
 */
public class Presenter {

    private final ApplicationView applicationView;
    private final ApplicationModel applicationModel;

    /**
     * creates a new PresentationModel
     *
     * @param applicationView the ApplicationView
     */
    public Presenter(ApplicationView applicationView) {
        this.applicationView = applicationView;

        applicationModel = new FileReadingStarWarsMovies();
        this.applicationView.setStarWarsMovies(applicationModel.getData());
    }
}
