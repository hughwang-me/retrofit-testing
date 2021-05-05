package com.uwjx.retrofittesting.test;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CrcTesting {

    public static void main(String[] args) {
        List<Byte> list = new ArrayList<>();
        List<Byte> crc_field = new ArrayList<>();
        list.add((byte)0x68); //指令头
        list.add((byte)0x30); //指令码
        list.add((byte)0x30);//数据

//        crc_field.add((byte)0x68);
        crc_field.add((byte)0x30);
        crc_field.add((byte)0x30);

        String crc = CRCUtils.getCrc(getBytes(crc_field));
        log.warn("CRC结果 {} " , crc);

        byte[] crcByte = CRCUtils.getCrcByte(getBytes(crc_field));
        for (byte b : crcByte) {
            log.warn("byte[] : {}" , (int)b );
        }

    }

    private static byte[] getBytes(List<Byte> list) {
        byte [] bs = new byte[list.size()];
        for (int i = 0;i < list.size();i++) {
            bs[i] = list.get(i);
        }
//        Log.w("hugh" , "s list getBytes : " + bs);
        return bs;
    }

    /**
     * 计算CRC16校验码
     *
     * @param bytes
     * @return
     */
    public static String getCRC(byte[] bytes) {
        int CRC = 0x0000ffff;
        int POLYNOMIAL = 0x0000a001;

        int i, j;
        for (i = 0; i < bytes.length; i++) {
            CRC ^= ((int) bytes[i] & 0x000000ff);
            for (j = 0; j < 8; j++) {
                if ((CRC & 0x00000001) != 0) {
                    CRC >>= 1;
                    CRC ^= POLYNOMIAL;
                } else {
                    CRC >>= 1;
                }
            }
        }
        return Integer.toHexString(CRC);
    }
}
