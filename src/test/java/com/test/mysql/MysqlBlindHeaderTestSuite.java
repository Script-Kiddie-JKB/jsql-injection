package com.test.mysql;

import org.junit.BeforeClass;

import com.jsql.model.InjectionModel;
import com.jsql.model.MediatorModel;
import com.jsql.model.exception.InjectionFailureException;
import com.jsql.model.injection.method.MethodInjection;
import com.jsql.model.injection.strategy.Strategy;
import com.jsql.util.ConnectionUtil;
import com.jsql.view.terminal.SystemOutTerminal;
import com.test.AbstractTestSuite;

public class MysqlBlindHeaderTestSuite extends ConcreteMysqlTestSuite {

    @BeforeClass
    public static void initialize() throws InjectionFailureException {
        InjectionModel model = new InjectionModel();
        MediatorModel.register(model);
        model.sendVersionToView();

        MediatorModel.model().addObserver(new SystemOutTerminal());

        ConnectionUtil.urlBase = "http://"+ AbstractTestSuite.hostName +"/simulate_header.php";
        ConnectionUtil.dataHeader = "lib:1";
        ConnectionUtil.methodInjection = MethodInjection.HEADER;

        MediatorModel.model().injection();

        MediatorModel.model().setStrategy(Strategy.BLIND);
    }
}