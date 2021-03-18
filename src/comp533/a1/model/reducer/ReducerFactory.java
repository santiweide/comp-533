package comp533.a1.model.reducer;

public class ReducerFactory {
    private static IReducer Reducer = new TokenCountingReducer();

    public ReducerFactory(IReducer reducer) {
        Reducer = reducer;
    }

    public static IReducer getReducer() {
        return Reducer;
    }

    public static void setReducer(IReducer reducer){
        Reducer = reducer;
    }
}
