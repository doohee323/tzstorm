package example7.tzstorm.spout;

import java.util.Map;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import storm.trident.spout.ITridentSpout;
import backtype.storm.task.TopologyContext;
import backtype.storm.tuple.Fields;

@SuppressWarnings("rawtypes")
public class TestSpout7 implements ITridentSpout<Long> {
    private static final long serialVersionUID = 1L;
    private static final Log log = LogFactory.getLog(TestSpout7.class);

    public BatchCoordinator<Long> getCoordinator(String txStateId, Map conf, TopologyContext context) {
//        log.debug("TestSpout6.getCoordinator({}, conf, context)" + txStateId);
        return new LogBatchCoordinator();
    }

    public Emitter<Long> getEmitter(String txStateId, Map conf, TopologyContext context) {
//        log.debug("TestSpout6.getEmitter({}, conf, context)" + txStateId);
        return new LogEmitter();
    }

    public Map getComponentConfiguration() {
        return null;
    }

    public Fields getOutputFields() {
        return new Fields("logstring");
    }

}