package com.company;

import java.io.*;

class Converter {
    public static byte[] convertToBytes(Object object) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(baos);
        objectOutputStream.writeObject(object);
        return baos.toByteArray();

    }

    public static Object convertFromBytes(byte[] buffer) throws IOException, ClassNotFoundException {
        ByteArrayInputStream bais = new ByteArrayInputStream(buffer);
        ObjectInputStream objectInputStream = new ObjectInputStream(bais);
        Object object = objectInputStream.readObject();
        return object;

    }

}

