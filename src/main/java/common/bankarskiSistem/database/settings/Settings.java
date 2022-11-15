package common.bankarskiSistem.database.settings;

public interface Settings {

    Object getParameter(String parameter);
    void addParameter(String parameter, Object value);
}
