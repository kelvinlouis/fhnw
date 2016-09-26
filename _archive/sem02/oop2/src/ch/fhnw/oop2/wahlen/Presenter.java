package ch.fhnw.oop2.wahlen;

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

        applicationModel = new FileBackendModel();
        this.applicationView.setResults(applicationModel.getData());
    }
}
