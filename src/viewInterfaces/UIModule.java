package viewInterfaces;

import ControllerInterface.ICommand;

public interface UIModule {
    void addEvent(EventName eventName, ICommand command);
    <T> T getDialogResponse(IDialogChoice dialogSettings);
}
