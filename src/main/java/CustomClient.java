import io.netty.bootstrap.Bootstrap;
import io.netty.channel.*;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.SocketChannel;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class CustomClient {
    static  final  String HOST = System.getProperty("host","dreamlike.top");
    static  final  int PORT = Integer.parseInt(System.getProperty("port","2001"));
    static  final int SIZE = Integer.parseInt(System.getProperty("size","256"));

    public static void main(String[] args) {
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group)
                .channel(NioServerSocketChannel.class)
                .option(ChannelOption.TCP_NODELAY,true)
                .handler(new ChannelInitializer<SocketChannel>() {
                    @Override
                    protected void initChannel(SocketChannel ch) throws Exception {
                     ch.pipeline().addLast(new CustomDecoder(1024,0,4));

                    }
                });
        try {
            ChannelFuture future = b.connect(HOST,PORT).sync();
            future.channel().closeFuture()
                    .sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
