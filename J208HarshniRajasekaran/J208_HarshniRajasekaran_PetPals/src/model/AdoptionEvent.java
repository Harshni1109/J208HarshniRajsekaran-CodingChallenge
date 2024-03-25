package model;
import java.util.ArrayList;
import java.util.List;
public class AdoptionEvent {
	
    private List<Adoptable> participants;

    public AdoptionEvent() {
        this.participants = new ArrayList<>();
    }

    public void hostEvent() {
        System.out.println("Adoption event hosted:");
        System.out.println("Participants:");
        for (Adoptable participant : participants) {
            participant.adopt();
        }
    }

    public void registerParticipant(Adoptable participant) {
        participants.add(participant);
    }
}
