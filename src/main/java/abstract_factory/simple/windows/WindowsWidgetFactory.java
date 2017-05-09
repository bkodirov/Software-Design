package abstract_factory.simple.windows;

import abstract_factory.simple.*;

/**
 * Concrete Factory Classes
 */
public class WindowsWidgetFactory implements WidgetFactory {
    @Override
    public AbstractFrameWidget createFrame() { // TODO Auto-generated method stub
        return new WindowsFrame();
    }

    @Override
    public AbstractButtonWidget createButton() {
        return new WindowsButton();
    }

    @Override
    public AbstractCheckboxWidget createCheckbox() {
        return new WindowsCheckbox();
    }

    @Override
    public AbstractListboxWidget createListbox() {
        return new WindowsListbox();
    }
}
