package comp533.a1.model.reducer;


public class TokenCountingReducerFactory {
    private static ITokenCountingReducer Reducer =  new TokenCountingReducer();;

    public static Class getReducerFactory() {
        return TokenCountingReducerFactory.class;
    }

    public static ITokenCountingReducer getTokenCountingReducer() {
        return Reducer;
    }
}
