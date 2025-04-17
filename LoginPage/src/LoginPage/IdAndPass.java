package LoginPage;

import java.util.HashMap;

public class IdAndPass {
    HashMap<String,String> loginInfo = new HashMap<String,String>();

    IdAndPass() {
        loginInfo.put("username","admin123");
        loginInfo.put("marek","jajko2137");
    }

    public void createUser(String username, String password) {
        this.loginInfo.put(username, password);
    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }
}
