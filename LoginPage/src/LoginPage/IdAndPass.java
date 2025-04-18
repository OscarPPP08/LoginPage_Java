package LoginPage;

import java.util.HashMap;

public class IdAndPass {
    HashMap<String, String> loginInfo = new HashMap<String, String>();

    IdAndPass() {
        loginInfo.put("admin", "123");
    }

    public void createUser(String username, String password) {
        this.loginInfo.put(username, password);
    }

    protected HashMap getLoginInfo() {
        return loginInfo;
    }
}
