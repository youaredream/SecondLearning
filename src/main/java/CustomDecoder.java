import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.LengthFieldBasedFrameDecoder;
import io.netty.handler.codec.MessageToByteEncoder;

import java.nio.charset.StandardCharsets;

public class CustomDecoder extends LengthFieldBasedFrameDecoder {
    private  int length;
    private  String body;

    public CustomDecoder(int maxFrameLength, int lengthFieldOffset, int lengthFieldLength) {
        super(maxFrameLength, lengthFieldOffset, lengthFieldLength);
    }

    @Override
    protected Object decode(ChannelHandlerContext ctx, ByteBuf in) throws Exception {
        length = in.readInt();
        ByteBuf buf = in.readBytes(length);
        byte[] str = new byte[buf.readableBytes()];
        buf.readBytes(str);
        body = new String(str, StandardCharsets.UTF_8);
       System.out.println(length+body);
        return  ctx;
    }
}
