package com.xiaolinzi.nio.study.nio.study.nio;

import java.nio.ByteBuffer;

/**
 * @author xiaolinzi
 * @Date 2021/3/5 15:11
 * @email xiaolinzi95_27@163.com
 */
public class NioStudyApi {
    public static void main(String[] args) {
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        //position  指标位置
        //limit     指标最大位置
        //capacity  最大容量
        //mark <= position <= limit <= capacity
        //让limit = position  position=0
        byteBuffer.flip();
        //复制一个buffer 修改一个 另一个也修改
        ByteBuffer slice = byteBuffer.slice();
        //复制一个只读的buffer 不可以写数据
        ByteBuffer readOnlyBuffer = byteBuffer.asReadOnlyBuffer();
        //创建directByteBuffer  引用堆外内存 性能更好
        ByteBuffer direct = ByteBuffer.allocateDirect(1024);
        //此时修改bytes  wrap也会改
        byte[] bytes = new byte[]{'a','b'};
        ByteBuffer wrap = ByteBuffer.wrap(bytes);
    }
}
