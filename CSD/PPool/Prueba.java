public class Prueba extends Thread
{
    private int i;
    public Prueba(int a){i = a;}
    public void run(){
        for(int j = 0; j<i;j++){
            if((j%3) == 0)new Prueba(j).start();
        }
        System.out.println(currentThread().getName() + " i:"+ i);
    }
    static public void main(String args[]){
        Prueba hilo = new Prueba(6);
        hilo.setName("nombre");
        hilo.start();
        new Thread (()->{
            for(int j = 0; j < 6; j++){
                if((j%3)==0)new Prueba(j).start();
            }
        },"lambda");
    }
}
