package LoginPage;

public class Main {

    public static void main(String[] args) {

        IdAndPass sharedSystem = new IdAndPass();
        RegisterPage registerPage = new RegisterPage(sharedSystem);
        registerPage.frame.setVisible(true);
    }

}