import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestClient {
    public static void main(String[] args) throws InterruptedException{
        EventLoopGroup group = new NioEventLoopGroup();
        Bootstrap b = new Bootstrap();
        b.group(group).channel(NioServerSocketChannel.class).handler(new CustomClientHandler());
        ChannelFuture f = b.connect("dreamlike.top",2001).sync();
        f.channel().closeFuture().sync();

    }
}
