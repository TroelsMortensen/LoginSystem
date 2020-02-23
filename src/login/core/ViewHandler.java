package login.core;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import login.views.ViewController;
import login.views.changepassword.ChangePasswordController;
import login.views.createuser.CreateUserController;
import login.views.login.LoginController;

import java.io.IOException;

public class ViewHandler {

    private final ViewModelFactory viewModelFactory;
    private Stage mainStage;

    public ViewHandler(ViewModelFactory lvm) {
        this.viewModelFactory = lvm;
        mainStage = new Stage();
    }

    // I could do this in the constructor. It's just personal preference to make the constructor only create things
    // and not start all kinds of stuff.
    public void start() {
        // opening first view
        openLoginView();
        mainStage.show();
    }

    private Scene loginScene;
    public void openLoginView() {
        try {
            // I check if the scene has already been created.
            // storing the scene for future use, so I do not have to load it and initialize the controller
            // multiple times.
            if(loginScene == null) {
                // storing the created scene for future use
                loginScene = getScene("../views/login/Login.fxml");
            }
            // setting title of the window
            mainStage.setTitle("Log in");

            // putting my scene into the window
            mainStage.setScene(loginScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void openLoggedInSuccesfulView() {
        // no need to store for future use, I only get to this view once
        try {
            Scene scene = getScene("../views/loginresult/LoginResult.fxml");
            mainStage.setTitle("Logged in");
            mainStage.setScene(scene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Scene createUserScene;
    public void openCreateUserView() {
        try {
            // no need to load the same scene more than once. I can just reuse it
            if(createUserScene == null) {
                // storing scene in field variable for future use
                createUserScene = getScene("../views/createuser/CreateUser.fxml");
            }
            mainStage.setTitle("Create User");
            mainStage.setScene(createUserScene);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private Scene changePWScene;
    public void openChangePasswordView() {
        try {
            // no need to load the same scene more than once. I can just reuse it
            if(changePWScene == null) {
                // storing scene in field variable for future use
                changePWScene = getScene("../views/changepassword/ChangePassword.fxml");
            }
            mainStage.setTitle("Change password");
            mainStage.setScene(changePWScene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private Scene getScene(String path) throws IOException {
        FXMLLoader loader = new FXMLLoader();

        loader.setLocation(getClass().getResource(path));
        Parent root = loader.load();

        ViewController view = loader.getController();
        view.init(this, viewModelFactory);
        return new Scene(root);
    }
}
