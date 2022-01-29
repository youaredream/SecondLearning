import io.netty.buffer.ByteBuf;
import io.netty.channel.*;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;

public class LengthBasedInitializer extends ChannelInitializer <Channel>{
    @Override
    protected void initChannel(Channel channel) throws Exception {
        ChannelPipeline pipeline = channel.pipeline();
        pipeline.addLast(
                new LengthFieldBasedFrameDecoder(64*1024,0,4));
        pipeline.addLast(new FrameHandler());

    }
    public  static  final  class   FrameHandler extends SimpleChannelInboundHandler<ByteBuf> {
        @Override
        protected void channelRead0(ChannelHandlerContext ctx, ByteBuf in )throws Exception {
            int length = in.readInt();
            byte[]bytes = new byte[in.readableBytes()];
            in.readBytes(bytes);


        }
    }
}
