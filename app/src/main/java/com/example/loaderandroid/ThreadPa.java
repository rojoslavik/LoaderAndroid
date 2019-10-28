package com.example.loaderandroid;

public class ThreadPa extends Thread {

    int id;
    int progress = 0;
    boolean done = false;

    private OnDoneListener onDoneListener;

    public ThreadPa(int id) {
        this.id = id;
    }

    public void setOnDoneListener( OnDoneListener onDoneListener) {
        this.onDoneListener = onDoneListener;
    }

    public void run() {
        try{
            while (progress <= 100) {
                this.onDoneListener.onComplete(this.progress, this.done, this.id);
                progress += 10;
                sleep(3000);
            }
            this.done = true;
            this.onDoneListener.onComplete(this.progress, this.done, this.id);
        }
        catch (InterruptedException e) {

        }
    }
}
