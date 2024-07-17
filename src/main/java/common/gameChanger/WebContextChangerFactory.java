package common.gameChanger;

public class WebContextChangerFactory implements GameFactory{
    @Override
    public ContextChanger ContextChangerFactory() {
        return new WebChange();
    }
}
