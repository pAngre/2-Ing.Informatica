// CSD feb 2015 Juansa Sendra

public class Pool2 extends Pool{ //max kids/instructor
    int kswimming = 0, iswimming = 0;
    int ki; //niños por instructor
    
    
    public void init(int ki, int cap)           {
        this.ki = ki;
    }
    public synchronized void kidSwims()throws InterruptedException{
        while(iswimming == 0 || kswimming/iswimming  >= this.ki){
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
    public synchronized void instructorSwims()   {
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
