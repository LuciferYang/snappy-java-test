package org.example;

import org.junit.Assert;
import org.junit.Test;
import org.xerial.snappy.Snappy;

import java.io.IOException;
import java.nio.ByteBuffer;

public class SnappyJavaTest {
    @Test
    public void testCompress() throws IOException {
        ByteBuffer src = ByteBuffer.allocateDirect(1024);
        src.put("hello world".getBytes());
        src.flip();
        ByteBuffer dest = ByteBuffer.allocateDirect(1024);
        int maxCompressedLen = Snappy.compress(src, dest);
        Assert.assertEquals(maxCompressedLen, 13);
    }
}
