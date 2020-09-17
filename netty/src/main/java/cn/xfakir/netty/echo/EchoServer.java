package cn.xfakir.netty.echo;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * 1.绑定到服务器将在其上监听并接受传入连接请求的端口
 * 2.配置Channel，以将有关的入站消息通知给EchoServerHandler实例
 */
public class EchoServer {
    private final int port = 8080;

    public static void main(String[] args) throws Exception{
        new EchoServer().start();
    }

    public void start() throws Exception {
        final EchoServerHandler serverHandler = new EchoServerHandler();
        EventLoopGroup group = new NioEventLoopGroup(); //初始化用于Acceptor的主"线程池"以及用于I/O工作的从"线程池"；
        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap(); //初始化ServerBootstrap实例， 此实例是netty服务端应用开发的入口
            serverBootstrap.group(group) //通过ServerBootstrap的group方法，设置初始化的主从"线程池"
                    .channel(NioServerSocketChannel.class) //指定通道channel的类型，由于是服务端，故而是NioServerSocketChannel
                    .localAddress(new InetSocketAddress(port))
                    .childHandler(new ChannelInitializer<SocketChannel>() {
                        //设置子通道也就是SocketChannel的处理器， 其内部是实际业务开发的"主战场"
                        //EchoServerHandler被标注为@Shareable,所以可以使用同样的实例
                        //当一个新的连接被接受时，一个新的子Channel将会被创建，而ChannelInitializer将会把一个你的EchoServerHandler
                        //的实例添加到该Channel的ChannelPipeline中。
                        @Override
                        protected void initChannel(SocketChannel socketChannel) throws Exception {
                            socketChannel.pipeline().addLast(serverHandler);
                        }
                    });
            //sync(): 使当前线程阻塞，一直到操作完成
            ChannelFuture channelFuture = serverBootstrap.bind().sync(); //异步绑定服务器，调用sync()方法阻塞等待直到绑定完成
            channelFuture.channel().closeFuture().sync(); //获取Channel的CloseFuture，并且阻塞当前线程直到服务器端的Channel关闭(closeFuture)
        } finally {
            group.shutdownGracefully().sync(); //关闭并释放资源
        }
    }
}
