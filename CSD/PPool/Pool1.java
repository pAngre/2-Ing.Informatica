// CSD feb 2015 Juansa Sendra

public class Pool1 extends Pool { 
    int kswimming = 0, iswimming = 0;
    //no kids alone
    public void init(int ki, int cap)           {}
    public void kidSwims() throws InterruptedException{
        while(iswimming == 0){
            log.waitingToSwim();
            wait();
        }
        kswimming++;
        log.swimming();
        notifyAll();
    }
    public void kidRests()      {
        kswimming--;
        log.resting();
        notifyAll();
    }
    public void instructorSwims()   {
        iswimming++;
        log.swimming();
        notifyAll();
    }
    public void instructorRests() throws InterruptedException{
        while(iswimming == 1 && kswimming > 0){
            log.waitingToRest();
            wait();
        }
        iswimming--;
        log.resting(); 
        notifyAll();
    }
}
