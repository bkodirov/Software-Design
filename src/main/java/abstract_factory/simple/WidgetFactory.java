package abstract_factory.simple;

/**
 * Abstract Factory Class
 */
public interface WidgetFactory {
    AbstractFrameWidget createFrame();
    AbstractButtonWidget createButton();
    AbstractCheckboxWidget createCheckbox();
    AbstractListboxWidget createListbox();
}