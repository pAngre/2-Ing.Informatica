// CSD feb 2015 Juansa Sendra

public class Pool3 extends Pool{ //max capacity
    int kswimming = 0, iswimming = 0;
    int ki; // niños por instructor
    int cap; // capacidad maxima
    public void init(int ki, int cap)           {
        this.ki = ki;
        this.cap = cap;
    }
    public synchronized void kidSwims()throws InterruptedException{
        while(iswimming == 0 || kswimming/iswimming  >= this.ki || kswimming + iswimming == cap){
            log.waitingToSwim();
            wait();
        }
        kswimming++;
        log.swimming();
        notifyAll();
    }
    public synchronized void kidRests()      {
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
            log.waitingToRest();
            wait();
        }
        iswimming--;
        log.resting();
        notifyAll();
    }
}
