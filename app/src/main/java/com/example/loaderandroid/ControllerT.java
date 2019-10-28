package com.example.loaderandroid;

public class ControllerT {

    private ThreadPa worker;

    public ThreadPa getThread() {
        return this.worker;
    }

    public void makeThread(int id) {
        worker = new ThreadPa(id);
        worker.start();
    }

    public void interrupt() {
        worker.interrupt();
    }
}
