package comp533.a1;

import comp533.a1.controller.Controller;
import comp533.a1.model.IModel;
import comp533.a1.model.KeyValue;
import comp533.a1.model.mapper.IntSummingMapper;
import comp533.a1.model.mapper.MapperFactory;
import comp533.a1.model.mapper.TokenCountingMapper;
import comp533.a1.view.View;
import gradingTools.comp533s21.assignment1.interfaces.MapReduceConfiguration;
import comp533.a1.model.reducer.Reducer;
import comp533.a1.model.reducer.ReducerFactory;

public class MyMapReduceConfiguration implements MapReduceConfiguration {

    @Override
    public Class getStandAloneTokenCounter() {
        return TokenCounter.class;
    }

    @Override
    public Class getStandAloneIntegerSummer() {
        return IntSumming.class;
    }

    @Override
    public Class getModelClass() {
        return IModel.class;
    }

    @Override
    public Class getViewClass() {
        return View.class;
    }

    @Override
    public Class getControllerClass() {
        return Controller.class;
    }

    @Override
    public Class getMapperFactory() {
        return MapperFactory.class;
    }

    @Override
    public Class getReducerFactory() {
        return ReducerFactory.class;
    }

    @Override
    public Class getKeyValueClass() {
        return KeyValue.class;
    }

    @Override
    public Class getTokenCountingMapperClass() {
        return TokenCountingMapper.class;
    }

    @Override
    public Class getIntSummingMapperClass() { return IntSummingMapper.class; }

    @Override
    public Class getReducerClass() {
        return Reducer.class;
    }

    @Override
    public Object getTokenCountingMapper() {
        return MapperFactory.getMapper();
    }

    @Override
    public Object getIntSummingMapper() {
        MapperFactory.setMapper(new IntSummingMapper());
        return MapperFactory.getMapper();
    }

    @Override
    public Object getReducer() {
        return ReducerFactory.getReducer();
    }

    @Override
    public Class getPartitionerClass() {
        return null;
    }

    @Override
    public Class getPartitionerFactory() {
        return null;
    }

    @Override
    public Object getPartitioner() {
        return null;
    }

    @Override
    public Class getJoinerClass() {
        return null;
    }

    @Override
    public Class getBarrierClass() {
        return null;
    }

    @Override
    public Class getSlaveClass() {
        return null;
    }

    @Override
    public Object getBarrier(int i) {
        return null;
    }

    @Override
    public Object getJoiner(int i) {
        return null;
    }

    @Override
    public Class getServerTokenCounter() {
        return null;
    }

    @Override
    public Class getServerIntegerSummer() {
        return null;
    }

    @Override
    public Class getClientTokenCounter() {
        return null;
    }

    @Override
    public Class getRemoteModelInterface() {
        return null;
    }

    @Override
    public Class getRemoteClientObjectInterface() {
        return null;
    }

    @Override
    public Class getRemoteClientObjectClass() {
        return null;
    }

    @Override
    public Class getServerFacebookMapReduce() {
        return null;
    }

    @Override
    public Class getRemoteClientFacebookMapReduce() {
        return null;
    }

    @Override
    public Class getStandAloneFacebookMapReduce() {
        return null;
    }
}
