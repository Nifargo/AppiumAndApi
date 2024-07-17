package common.gameChanger;

public class ContextSwitcher {
    public GameFactory changeContextFrom(ContextType contextType){
        return switch (contextType) {
            case WEB -> new WebContextChangerFactory();
            case NATIVE -> new NativeContextChangerFactory();
            case CHROME -> new WebChromeContextChangeFactory();
        };
    }
}
