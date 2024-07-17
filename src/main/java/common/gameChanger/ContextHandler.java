package common.gameChanger;
import java.util.Objects;

public class ContextHandler {

    public void changeContext(ContextType contextType) {

        Objects.requireNonNull(contextType, "Context type cannot be null");

        GameFactory gameFactory = new ContextSwitcher().changeContextFrom(contextType);
        ContextChanger gameChanger = gameFactory.ContextChangerFactory();
        gameChanger.change();
    }
}

