package common.gameChanger;

public class WebChromeContextChangeFactory implements GameFactory{
    @Override
    public ContextChanger ContextChangerFactory() {
        return new WebChromeChanger();
    }
}
