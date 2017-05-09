package abstract_factory.simple.mac;

import abstract_factory.simple.*;

public class MacWidgetFactory implements WidgetFactory {
    @Override
    public AbstractButtonWidget createButton() {
        return new MacButton();
    }

    @Override
    public AbstractCheckboxWidget createCheckbox() {
        return new MacCheckbox();
    }

    @Override
    public AbstractListboxWidget createListbox() {
        return new MacListbox();
    }

    @Override
    public AbstractFrameWidget createFrame() {
        // TODO Auto-generated method stub
        return new MacFrame();
    }
}
