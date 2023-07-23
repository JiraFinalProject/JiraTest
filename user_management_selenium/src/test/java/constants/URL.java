package constants;

import utils.ApplicationProperties;

public enum URL {
    Login("auth/login"),
    Home("dashboard/index"),
    UserManagement("admin/viewSystemUsers"),
    UserCreation("admin/saveSystemUser");

    private final String url;
    URL(String path) {
        this.url = ApplicationProperties.get("baseUrl") + path;
    }

    @Override
    public String toString() {
        return url;
    }
}
