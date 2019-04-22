package book.review.questions;

public class Question9 {



}

class CheetahManager {
    private static CheetahManager cheetahManager;
    private CheetahManager() {}
    public static synchronized CheetahManager getCheetahManager() {
        if(cheetahManager == null) {
            cheetahManager = new CheetahManager();
        }
        return cheetahManager;
    }
}