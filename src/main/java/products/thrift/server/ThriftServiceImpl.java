package products.thrift.server;

import org.apache.thrift.TException;

import products.thrift.BooleanResult;

/**
 * @author zhailzh
 */
public class ThriftServiceImpl implements products.thrift.ThriftService.Iface {

  @Override
  public BooleanResult serverState(String userid) throws TException {
    BooleanResult res = new BooleanResult();
    System.out.println("thrift service 后台访问.......");
    res.err_msg = "thrift service 后台访问";
    return res;
  }

}
