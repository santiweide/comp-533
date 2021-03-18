package comp533.a1;

import comp533.a1.controller.Controller;
import comp533.a1.model.KeyValue;
import comp533.a1.model.Model;
import comp533.a1.view.View;
import gradingTools.comp533s21.assignment1.interfaces.MapReduceConfiguration;
import comp533.a1.model.mapper.TokenCountingMapper;
import comp533.a1.model.mapper.TokenCountingMapperFactory;
import comp533.a1.model.reducer.TokenCountingReducer;
import comp533.a1.model.reducer.TokenCountingReducerFactory;

public class MyMapReduceConfiguration implements MapReduceConfiguration {

    @Override
    public Class getStandAloneTokenCounter() {
        return TokenCounter.class;
    }

    @Override
    public Class getStandAloneIntegerSummer() {
        return null;
    }

    @Override
    public Class getModelClass() {
        return Model.class;
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
        return TokenCountingMapperFactory.class;
    }

    @Override
    public Class getReducerFactory() {
        return TokenCountingReducerFactory.class;
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
    public Class getIntSummingMapperClass() {
        return null;
    }

    @Override
    public Class getReducerClass() {
        return TokenCountingReducer.class;
    }

    @Override
    public Object getTokenCountingMapper() {
        return TokenCountingMapperFactory.getMapper();
    }

    @Override
    public Object getIntSummingMapper() {
        return null;
    }

    @Override
    public Object getReducer() {
        return TokenCountingReducerFactory.getReducer();
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
