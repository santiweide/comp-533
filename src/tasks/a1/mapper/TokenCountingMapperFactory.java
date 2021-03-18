package tasks.a1.mapper;


/**
 * @author algorithm
 */
public class TokenCountingMapperFactory {
    private static ITokenCountingMapper Mapper;

    public TokenCountingMapperFactory(){
        Mapper = new TokenCountingMapper();
    }
    public static Class getMapperFactory() {
        return TokenCountingMapperFactory.class;
    }

    public static ITokenCountingMapper getTokenCountingMapper() {
        return Mapper;
    }

}
