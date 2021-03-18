package comp533.a1.model.mapper;


/**
 * @author algorithm
 */
public class TokenCountingMapperFactory {
    private static ITokenCountingMapper Mapper = new TokenCountingMapper();

    public static Class getMapperFactory() {
        return TokenCountingMapperFactory.class;
    }

    public static ITokenCountingMapper getTokenCountingMapper() {
        return Mapper;
    }

}
