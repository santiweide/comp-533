package comp533.a1.model.mapper;


/**
 * @author algorithm
 */
public class MapperFactory {
    private static IMapper Mapper = new TokenCountingMapper();

    public MapperFactory(IMapper mapper){
        Mapper = mapper;
    }

    public static IMapper getMapper() {
        return Mapper;
    }

    public static void setMapper(IMapper mapper){
        Mapper = mapper;
    }

}
