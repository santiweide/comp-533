package comp533.a2.model.mapper;


import gradingTools.comp533s19.assignment0.AMapReduceTracer;

/**
 * @author algorithm
 */
public class MapperFactory extends AMapReduceTracer {
    private static IMapper Mapper = new TokenCountingMapper();

    public MapperFactory(IMapper mapper){
        Mapper = mapper;
    }

    public static IMapper getMapper() {
        return Mapper;
    }

    public static void setMapper(IMapper mapper){
        AMapReduceTracer.traceMapperChange(MapperFactory.class, mapper);
        Mapper = mapper;
    }

}
