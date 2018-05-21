package com.xlj;

import com.alibaba.dubbo.common.extension.ExtensionFactory;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
import com.alibaba.dubbo.container.Container;
import com.alibaba.dubbo.container.Main;
import com.alibaba.dubbo.rpc.Protocol;
import com.xlj.interfaces.DubboTest;
import com.xlj.interfaces.model.User;

import java.util.Set;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
//        Class c = Class.class;
//        Class s = String.class;
//        Class i = int.class;
//        Class cu = null;
//        try {
//            cu = Class.forName("com.xlj.interfaces.model.User");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }
//        Class<User> cuc = User.class;
//        Class cucc = User.class;
//
//        System.out.println(cu == cuc);
//
//        Protocol p = ExtensionLoader.getExtensionLoader(Protocol.class).getAdaptiveExtension();
//
//        ExtensionLoader<DubboTest> dtLoader = ExtensionLoader.getExtensionLoader(DubboTest.class);
//        DubboTest dubboTest = dtLoader.getExtension("implv2");
//        System.out.println(App.class.getResource("/").getPath());

        Main.main(args);

    }
}


//package com.alibaba.dubbo.rpc;
//
//        import com.alibaba.dubbo.common.extension.ExtensionLoader;
//
//public class Protocol$Adpative implements com.alibaba.dubbo.rpc.Protocol {
//    public com.alibaba.dubbo.rpc.Exporter export(com.alibaba.dubbo.rpc.Invoker arg0) throws com.alibaba.dubbo.rpc.Invoker {
//        if (arg0 == null) throw new IllegalArgumentException("com.alibaba.dubbo.rpc.Invoker argument == null");
//        if (arg0.getUrl() == null) throw new IllegalArgumentException("com.alibaba.dubbo.rpc.Invoker argument getUrl() == null");com.alibaba.dubbo.common.URL url = arg0.getUrl();
//        String extName = ( url.getProtocol() == null ? "dubbo" : url.getProtocol() );
//        if(extName == null) throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.rpc.Protocol) name from url(" + url.toString() + ") use keys([protocol])");
//        com.alibaba.dubbo.rpc.Protocol extension = (com.alibaba.dubbo.rpc.Protocol)ExtensionLoader.getExtensionLoader(com.alibaba.dubbo.rpc.Protocol.class).getExtension(extName);
//        return extension.export(arg0);
//    }
//
//    public com.alibaba.dubbo.rpc.Invoker refer(java.lang.Class arg0, com.alibaba.dubbo.common.URL arg1) throws java.lang.Class {
//        if (arg1 == null) throw new IllegalArgumentException("url == null");
//        com.alibaba.dubbo.common.URL url = arg1;
//        String extName = ( url.getProtocol() == null ? "dubbo" : url.getProtocol() );
//        if(extName == null) throw new IllegalStateException("Fail to get extension(com.alibaba.dubbo.rpc.Protocol) name from url(" + url.toString() + ") use keys([protocol])");
//        com.alibaba.dubbo.rpc.Protocol extension = (com.alibaba.dubbo.rpc.Protocol)ExtensionLoader.getExtensionLoader(com.alibaba.dubbo.rpc.Protocol.class).getExtension(extName);
//        return extension.refer(arg0, arg1);
//    }
//
//    public void destroy() {throw new UnsupportedOperationException("method public abstract void com.alibaba.dubbo.rpc.Protocol.destroy() of interface com.alibaba.dubbo.rpc.Protocol is not adaptive method!");
//    }
//
//    public int getDefaultPort() {throw new UnsupportedOperationException("method public abstract int com.alibaba.dubbo.rpc.Protocol.getDefaultPort() of interface com.alibaba.dubbo.rpc.Protocol is not adaptive method!");
//    }
//}