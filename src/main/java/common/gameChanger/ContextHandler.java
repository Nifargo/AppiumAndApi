package common.gameChanger;

import java.util.Objects;

public class ContextHandler {

    public void changeContext(ContextType contextType) {
        try {
            Thread.sleep(6000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
            throw new RuntimeException(e);
        }

        Objects.requireNonNull(contextType, "Context type cannot be null");

        GameFactory gameFactory = new ContextSwitcher().changeContextFrom(contextType);
        ContextChanger gameChanger = gameFactory.ContextChangerFactory();
        gameChanger.change();
    }
}

