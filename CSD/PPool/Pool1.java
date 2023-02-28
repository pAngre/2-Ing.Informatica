// CSD feb 2015 Juansa Sendra

public class Pool1 extends Pool { 
    int kswimming = 0, iswimming = 0;
    //no kids alone
    public void init(int ki, int cap)           {}
    public synchronized void kidSwims() throws InterruptedException{
        while(iswimming == 0){
            log.waitingToSwim();
            wait();
        }
        kswimming++;
        log.swimming();
        //notifyAll();
    }
    public synchronized void kidRests()      {
        kswimming--;
        notifyAll();
        log.resting();
    }
    public synchronized void instructorSwims()   {
        iswimming++;
        notifyAll();
        log.swimming();
    }
    public synchronized void instructorRests() throws InterruptedException{
        while(iswimming == 1 && kswimming > 0){
            log.waitingToRest();
            wait();
        }
        iswimming--;
        log.resting(); 
        //notifyAll();
    }
}
