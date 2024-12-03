package cs112.lab09.controllers;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.event.ActionEvent;
import javafx.stage.Modality;
import javafx.scene.Parent;

import java.io.IOException;

public class MapController {
    private static final String HISTORY_PREFIX = "The following 'history' was told for many years:\n";
    private static final String REVISED_HISTORY_PREFIX = "By correcting history, not just rewriting it, "
        + "we are revising it to embark on the process in righting a wrong."
        + "Here is the revised history:\n";

    @FXML
    private ImageView mapImageView;

    @FXML
    private void onBisbeeEventClick(ActionEvent event) throws IOException {
        openEventWindow("Bisbee, Arizona", "July 1919",
                HISTORY_PREFIX
                    + "Local police in Bisbee, Arizona attacked the 10th U.S. Cavalry, "
                    + "an African-American unit known as the \"Buffalo Soldiers,\" formed in 1866.",
                REVISED_HISTORY_PREFIX
                    + "Although sources are limited, the attack occured on the eve of celebrations meant to honor returning soldiers"
                    + "(like in Norfolk, Virginia).",
                "bisbee.png",  // Image for Bisbee
                "https://en.wikipedia.org/wiki/Bisbee_Riot");
    }

    @FXML
    private void onSanFranciscoEventClick(ActionEvent event) throws IOException {
        openEventWindow("San Francisco, CA", "May 15, 1919",
                HISTORY_PREFIX
                    + "A minor riot between Black and White soldiers occurred in the Presidio in San Fransisco.",
                REVISED_HISTORY_PREFIX
                    + "A minor riot between Black and White soldiers occurred in the Presidio in San Fransisco"
                    + " after a dispute about a Thai soldier who was moved from the \"colored quarters\" to the white military housing."
                    + " Despite defending our country, housing for Black soldiers was not only segregated, but also inferior."
                    + "Black soldiers also faced increased attacks and other forms of discrimination upon returning home.",
                "sanfrancisco.jpg",  // Image for San Francisco
                "https://visualizingtheredsummer.com/?page_id=6");
    }

    @FXML
    public void initialize() {
        mapImageView.setImage(new Image(getClass().getResourceAsStream("/images/Red-Summer.jpg")));
    }

    private void openEventWindow(String location, String date, String description, String revisedDescription, String imageUrl, String citationUrl) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/cs112/lab09/event-view.fxml"));
        Parent root = loader.load();

        EventController controller = loader.getController();
        controller.initData(location, date, description, revisedDescription, imageUrl, citationUrl);

        Stage stage = new Stage();
        stage.setScene(new Scene(root, 600, 400));
        stage.initModality(Modality.APPLICATION_MODAL);
        stage.setTitle("Event Details");
        stage.show();
    }
}
