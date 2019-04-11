package book.chapter.questions.selikof_and_boyearski;

import java.util.ArrayList;

public class Question14 {
    static class Chipmunk {
    }

    public static void main(String[] args) {
        Chipmunk c = new Chipmunk();
        ArrayList<Chipmunk> l = new ArrayList<>();
        Runnable r = new Thread();
        int result = 0;
        if (c instanceof Chipmunk) result += 1;
//        if (l instanceof Chipmunk) result += 2; // COMPILE ERROR
        if (r instanceof Chipmunk) result += 4;
        System.out.println(result);
    }
}
