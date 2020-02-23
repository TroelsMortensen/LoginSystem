package login.views;

import login.core.ViewHandler;
import login.core.ViewModelFactory;

public interface ViewController {

    void init(ViewHandler vh, ViewModelFactory vmf);
}
