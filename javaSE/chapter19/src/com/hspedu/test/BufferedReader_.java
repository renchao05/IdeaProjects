package com.hspedu.test;

public class BufferedReader_ extends Reader_ {
    private Reader_ reader_;

    public BufferedReader_(Reader_ reader_) {
        this.reader_ = reader_;
    }

    @Override
    public void read() {
        reader_.read();
    }

    public void read(int num) {
        for (int i = 0; i < num; i++) {
            reader_.read();
        }
    }
}
