package common.gameChanger;

public class NativeContextChangerFactory implements GameFactory{
    @Override
    public ContextChanger ContextChangerFactory() {
        return new NativeChanger();
    }
}
