package problem8.models;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Clinic implements Iterable<Room> {
    private String name;
    private List<Room> rooms;
    private int countOfRooms;

    public Clinic(String name, int countOfRooms) {
        this.rooms = new ArrayList<>();
        this.setCountOfRooms(countOfRooms);
        setRooms(this.countOfRooms);
        this.setName(name);
    }

    public boolean addPetToClinic(Pet pet) {
//        int size = this.rooms.size();
//        int firstIndex = (int)(size / 2);
//        int leftIndex = firstIndex;
//        int rightIndex = firstIndex;
//        boolean hasPetAdded = false;
//
//        while (leftIndex >= 0 && rightIndex < size){
//
//            if (this.rooms.get(firstIndex).getPet() == null){
//                this.rooms.get(firstIndex).setPet(pet);
//                hasPetAdded = true;
//                break;
//            }
//
//            leftIndex--;
//            if (this.rooms.get(leftIndex).getPet() == null){
//                this.rooms.get(leftIndex).setPet(pet);
//                hasPetAdded = true;
//                break;
//            }
//
//            rightIndex++;
//            if (this.rooms.get(rightIndex).getPet() == null){
//                this.rooms.get(rightIndex).setPet(pet);
//                hasPetAdded = true;
//                break;
//            }
//
//        }
        boolean hasPetAdded = false;
        Iterator<Room> iter = this.iterator();

        while (iter.hasNext()) {
            Room cuurent = iter.next();
            if (cuurent.getPet() == null) {
                cuurent.setPet(pet);
                hasPetAdded = true;
                break;
            }
        }
        return hasPetAdded;
    }

    public boolean releasePetFromClinic() {
        int size = this.rooms.size();
        int firstIndex = (int) (size / 2);
        int nextIndex = firstIndex + 1;
        boolean hasToReleasePet = false;

        while (nextIndex != firstIndex) {

            if (this.rooms.get(firstIndex).getPet() != null) {
                hasToReleasePet = true;
                this.rooms.get(firstIndex).setPet(null);
                break;
            }

            if (nextIndex > size - 1){
                break;
            }

            if (this.rooms.get(nextIndex).getPet() != null) {
                hasToReleasePet = true;
                this.rooms.get(nextIndex).setPet(null);
                break;
            }

            nextIndex = (nextIndex + 1) % size;
        }
        return hasToReleasePet;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < this.rooms.size(); i++) {
            sb.append(this.rooms.get(i)).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public Iterator<Room> iterator() {
        return new Iterator<Room>() {
            int size = rooms.size();
            int index = (int) (size / 2);
            int leftIndex = index;
            int rightIndex = index;
            int count = 0;

            @Override
            public boolean hasNext() {
                if (index < 0 || index > size) {
                    return false;
                }
                return true;
            }

            @Override
            public Room next() {
                Room cuurentRoom = rooms.get(index);
                if (count % 2 == 0) {
                    leftIndex--;
                    index = leftIndex;
                } else {
                    rightIndex++;
                    index = rightIndex;
                }
                count++;
                return cuurentRoom;
            }
        };
    }

    public boolean hasEmptyRoomsInClinic(){

        return this.rooms.stream().anyMatch(r -> r.getPet() == null);
    }

    public List<Room> getRooms() {
        return this.rooms;
    }

    private void setCountOfRooms(int countOfRooms) {
        if (countOfRooms % 2 == 0) {
            throw new IllegalArgumentException();
        }
        this.countOfRooms = countOfRooms;
    }

    private void setRooms(int countOfRooms) {
        for (int i = 1; i <= countOfRooms; i++) {
            this.rooms.add(new Room(i));
        }

    }

    private void setName(String name) {
        this.name = name;
    }


}
