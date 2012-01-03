package org.jboss.test.clusterbench.ejb.stateful;

import javax.ejb.Remove;
import javax.ejb.Stateful;
import org.jboss.ejb3.annotation.Clustered;
import org.jboss.test.clusterbench.common.SerialBean;

/**
 * 
 * @author Radoslav Husar
 * @version Dec 2011
 */
@Stateful
@Clustered
public class RemoteStatefulSBImpl implements RemoteStatefulSB {

    private SerialBean bean;

    public RemoteStatefulSBImpl() {
        bean = new SerialBean();
    }

    @Override
    public int getSerial() {
        int serial = bean.getSerial();

        bean.setSerial(serial + 1);

        return serial;
    }

    @Override
    public byte[] getCargo() {
        return bean.getCargo();
    }

    @Remove
    private void destroy() {
        bean = null;
    }
}