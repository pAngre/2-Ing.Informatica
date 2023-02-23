// CSD feb 2013 Juansa Sendra
public class Pool4 extends Pool{ //kids cannot enter if there are instructors waiting to exit
    int kswimming = 0, iswimming = 0;
    int ki; // niños por instructor
    int cap; // capacidad maxima
    int waitingInstructor = 0;
    public void init(int ki, int cap)           {
        this.ki = ki;
        this.cap = cap;
    }
    public synchronized void kidSwims()throws InterruptedException{
        while(iswimming == 0 || kswimming/iswimming  >= this.ki || kswimming + iswimming == cap || waitingInstructor > 0){
            log.waitingToSwim();
            wait();
        }
        kswimming++;
        log.swimming();
        notifyAll();
    }
    public synchronized void kidRests(){
        kswimming--;
        log.resting();
        notifyAll(); 
    }
    public synchronized void instructorSwims() throws InterruptedException{
        while(kswimming + iswimming == cap){
            log.waitingToSwim();
            wait();
        }
        iswimming++;
        log.swimming();
        notifyAll();
    }

    public synchronized void instructorRests() throws InterruptedException{
        while((iswimming == 1 && kswimming > 0) || ((kswimming/(iswimming-1)) >= this.ki)){
            waitingInstructor++;
            log.waitingToRest();
            wait();
            waitingInstructor--;
        }
        iswimming--;
        log.resting();
        notifyAll();
    }
}

