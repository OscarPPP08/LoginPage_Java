package LoginPage;

public class Main {

    public static void main(String[] args) {

        IdAndPass idAndPasswords = new IdAndPass();
        RegisterPage registerPage = new RegisterPage(idAndPasswords.getLoginInfo());
        LoginPage loginPage = new LoginPage();
        registerPage.frame.setVisible(false);
    }
}