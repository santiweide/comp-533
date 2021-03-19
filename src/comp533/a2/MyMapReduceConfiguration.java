package comp533.a2;

import comp533.a2.controller.Controller;
import comp533.a2.model.IModel;
import comp533.a2.model.KeyValue;
import comp533.a2.model.barrier.Barrier;
import comp533.a2.model.joiner.Joiner;
import comp533.a2.model.mapper.IntSummingMapper;
import comp533.a2.model.mapper.MapperFactory;
import comp533.a2.model.mapper.TokenCountingMapper;
import comp533.a2.model.partitioner.Partitioner;
import comp533.a2.model.partitioner.PartitionerFactory;
import comp533.a2.model.reducer.Reducer;
import comp533.a2.model.reducer.ReducerFactory;
import comp533.a2.model.slave.Slave;
import comp533.a2.view.View;
import gradingTools.comp533s21.assignment1.interfaces.MapReduceConfiguration;

/**
 * @author algorithm
 */
public class MyMapReduceConfiguration implements MapReduceConfiguration {

    /**
     *  A1 begin
     */
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

    /**
     *  A1 end
     *  A2 begin
      */

    @Override
    public Class getPartitionerClass() {
        return Partitioner.class;
    }

    @Override
    public Class getPartitionerFactory() {
        return PartitionerFactory.class;
    }

    @Override
    public Object getPartitioner() {
        return PartitionerFactory.getPartitioner();
    }

    @Override
    public Class getJoinerClass() {
        return Joiner.class;
    }

    @Override
    public Class getBarrierClass() {
        return Barrier.class;
    }

    @Override
    public Class getSlaveClass() {
        return Slave.class;
    }

    @Override
    public Object getBarrier(int i) {
        return new Barrier(i);
    }

    @Override
    public Object getJoiner(int i) {
        return new Joiner(i);
    }

    /**
     * A2 end
     * A3 begin
     */
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
