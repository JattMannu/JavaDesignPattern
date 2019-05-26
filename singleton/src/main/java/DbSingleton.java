public class DbSingleton {

    //volatile is to make it threadsafe
    private static volatile DbSingleton dbSingleton;

    private DbSingleton() {
        //To prevent reflection on this code.
        if(dbSingleton != null){
            throw  new RuntimeException("Use getInstance() method to create.");
        }
    }

    public static DbSingleton getInstance(){
        if(dbSingleton == null){
            synchronized (DbSingleton.class) {
                if(dbSingleton == null) {
                    dbSingleton = new DbSingleton();
                }
            }
        }
        return dbSingleton;
    }
}
