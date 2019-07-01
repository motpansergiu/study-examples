package dvl.srg.certifications.ocp.domain.animal;

public class Card {

    private String rank;

    public boolean equals(Card card) {
        return card != null && rank.equals(card.rank);
    }
}
